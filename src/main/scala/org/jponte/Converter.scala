package org.jponte

import org.jsoup.Jsoup
import org.jsoup.nodes.Element

import java.io.{File, PrintWriter}
import scala.jdk.CollectionConverters._

object Converter {

  def outputFile(content: String): String =
    s"""import tyrian.Html.*
       |import tyrian.SVG.*
       |import tyrian.*
       |
       |def view: Html[Msg] = {
       |  $content
       |}
       |""".stripMargin

  def main(args: Array[String]): Unit = {
    val doc = Jsoup.parse(new File(args(0)))
    val content = outputFile(generate(doc.body()))

    val file = new File("result.scala.generated")
    val pw = new PrintWriter(file)
    pw.write(content)
    pw.close()

  }

  def allTags: List[TagType] = Tags.htmlTags ++ Tags.svgTags

  def allAttributes: List[AttributeType] = Attributes.htmlAttrs ++ Attributes.svgAttrs

  def generate(element: Element, depth: Int = 0): String = {
    val attributes = element.attributes().asList().asScala
    val tagType = allTags.find(t => t.tag.getOrElse(t.name) == element.tagName())

    val attrString = attributes.map { attribute =>
      val attributeType = allAttributes.find(a => a.attrName.getOrElse(a.name) == attribute.getKey)

      attributeType match {
        case Some(attr) => s"${attr.name} := \"${attribute.getValue}\""
        case None => s"Attribute(\"${attribute.getKey}\", \"${attribute.getValue}\")"
      }
    }.mkString(", ")

    val innerString = if (element.childrenSize() > 0) {
      s"(\n${element.children().asScala.map(element => generate(element, depth + 1)).mkString(",\n")})"
    } else if (element.hasText) {
      s"(\"${element.text()}\")"
    } else if (tagType.exists(_.isInstanceOf[NoChildren])) {
      ""
    } else {
      "()"
    }

    val tabs: String = (0 until depth).map(_ => "\t").mkString("")

    tagType match {
      case Some(tag) => s"$tabs${tag.name}($attrString)$innerString"
      case None => s"${tabs}tag(\"${element.tagName()}\")($attrString)$innerString"
    }
  }
}
