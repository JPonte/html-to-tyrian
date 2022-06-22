package org.jponte

object Attributes {
  def htmlAttrs: List[AttributeType] =
    List(
      Normal("accept"),
      Normal("accessKey"),
      Normal("action"),
      Normal("alt"),
      NoValue("async"),
      Normal("autoComplete"),
      NoValue("autoFocus"),
      NoValue("autofocus"),
      NoValue("autoPlay"),
      NoValue("autoplay"),
      Normal("charset"),
      NoValue("checked"),
      Normal("cite"),
      Normal("`class`", "class"),
      Normal("cls", "class"),
      Normal("className", "class"),
      Normal("classname", "class"),
      Normal("_class", "class"),
      Normal("cols").withTypes("String", "Int"),
      Normal("colSpan").withTypes("String", "Int"),
      Normal("colspan").withTypes("String", "Int"),
      Normal("content"),
      Normal("contentEditable").withTypes("String", "Boolean"),
      Normal("contenteditable").withTypes("String", "Boolean"),
      NoValue("controls"),
      Normal("coords"),
      Normal("data"),
      Normal("dateTime"),
      Normal("datetime"),
      NoValue("default"),
      NoValue("defer"),
      Normal("dir"),
      Normal("dirname"),
      NoValue("disabled"),
      NoValue("download"),
      Normal("draggable").withTypes("String", "Boolean"),
      Normal("encType"),
      Normal("enctype"),
      Normal("_for", "for"),
      Normal("forId", "for"),
      Normal("htmlFor", "for"),
      Normal("form"),
      Normal("formAction"),
      Normal("formaction"),
      Normal("headers"),
      Normal("height").withTypes("String", "Int"),
      NoValue("hidden"),
      Normal("high").withTypes("String", "Double"),
      Normal("href"),
      Normal("hrefLang"),
      Normal("hreflang"),
      Normal("http"),
      Normal("id"),
      NoValue("isMap"),
      NoValue("ismap"),
      Normal("kind"),
      Normal("label"),
      Normal("lang"),
      Normal("list"),
      NoValue("loop"),
      Normal("low").withTypes("String", "Double"),
      Normal("max").withTypes("String", "Int"),
      Normal("maxLength").withTypes("String", "Int"),
      Normal("maxlength").withTypes("String", "Int"),
      Normal("media"),
      Normal("method"),
      Normal("min").withTypes("String", "Int"),
      Normal("multiple"),
      Normal("muted"),
      Normal("name"),
      NoValue("noValidate"),
      NoValue("novalidate"),
      EventEmitting("onAbort"),
      EventEmitting("onAfterPrint"),
      EventEmitting("onBeforePrint"),
      EventEmitting("onBeforeUnload"),
      EventEmitting("onBlur"),
      EventEmitting("onCanPlay"),
      EventEmitting("onCanPlayThrough"),
      EventEmitting("onChange", "change"),
      EventEmitting("onClick", "click"),
      EventEmitting("onContextMenu"),
      EventEmitting("onCopy"),
      EventEmitting("onCueChange"),
      EventEmitting("onCut"),
      EventEmitting("onDblClick"),
      EventEmitting("onDoubleClick", "dblclick"),
      EventEmitting("onDrag"),
      EventEmitting("onDragEnd"),
      EventEmitting("onDragEnter"),
      EventEmitting("onDragLeave"),
      EventEmitting("onDragOver"),
      EventEmitting("onDragStart"),
      EventEmitting("onDrop"),
      EventEmitting("onDurationChange"),
      EventEmitting("onEmptied"),
      EventEmitting("onEnded"),
      EventEmitting("onError"),
      EventEmitting("onFocus"),
      EventEmitting("onHashChange"),
      EventEmitting("onInput"),
      EventEmitting("onInvalid"),
      EventEmitting("onKeyDown"),
      EventEmitting("onKeyPress"),
      EventEmitting("onKeyUp"),
      EventEmitting("onLoad"),
      EventEmitting("onLoadedData"),
      EventEmitting("onLoadedMetadata"),
      EventEmitting("onLoadStart"),
      EventEmitting("onMouseDown"),
      EventEmitting("onMousemove"),
      EventEmitting("onMouseOut"),
      EventEmitting("onMouseOver"),
      EventEmitting("onMouseUp"),
      EventEmitting("onMouseWheel"),
      EventEmitting("onOffline"),
      EventEmitting("onOnline"),
      EventEmitting("onPageHide"),
      EventEmitting("onPageShow"),
      EventEmitting("onPaste"),
      EventEmitting("onPause"),
      EventEmitting("onPlay"),
      EventEmitting("onPlaying"),
      EventEmitting("onPopState"),
      EventEmitting("onProgress"),
      EventEmitting("onRateChange"),
      EventEmitting("onReset"),
      EventEmitting("onResize"),
      EventEmitting("onScroll"),
      EventEmitting("onSearch"),
      EventEmitting("onSeeked"),
      EventEmitting("onSeeking"),
      EventEmitting("onSelect"),
      EventEmitting("onStalled"),
      EventEmitting("onStorage"),
      EventEmitting("onSubmit"),
      EventEmitting("onSuspend"),
      EventEmitting("onTimeUpdate"),
      EventEmitting("onToggle"),
      EventEmitting("onUnload"),
      EventEmitting("onVolumeChange"),
      EventEmitting("onWaiting"),
      EventEmitting("onWheel"),
      NoValue("open"),
      Normal("optimum").withTypes("String", "Double"),
      Normal("pattern"),
      Normal("placeholder"),
      Normal("poster"),
      Normal("preload"),
      NoValue("readOnly"),
      NoValue("readonly"),
      Normal("rel"),
      NoValue("required"),
      NoValue("reversed"),
      Normal("rows").withTypes("String", "Int"),
      Normal("rowSpan").withTypes("String", "Int"),
      Normal("rowspan").withTypes("String", "Int"),
      NoValue("sandbox"),
      Normal("scope"),
      NoValue("selected"),
      Normal("shape"),
      Normal("size").withTypes("String", "Int"),
      Normal("sizes"),
      Normal("span").withTypes("String", "Int"),
      Normal("spellCheck").withTypes("String", "Boolean"),
      Normal("spellcheck").withTypes("String", "Boolean"),
      Normal("src"),
      Normal("srcDoc"),
      Normal("srcdoc"),
      Normal("srcLang"),
      Normal("srclang"),
      Normal("srcSet"),
      Normal("srcset"),
      Normal("start").withTypes("String", "Int"),
      Normal("step").withTypes("String", "Int"),
      Normal("style"),
      Normal("tabIndex").withTypes("String", "Int"),
      Normal("tabindex").withTypes("String", "Int"),
      Normal("target"),
      Normal("title"),
      Normal("translate"),
      Normal("`type`", "type"),
      Normal("_type", "type"),
      Normal("typ", "type"),
      Normal("tpe", "type"),
      Normal("useMap"),
      Normal("usemap"),
      Normal("width").withTypes("String", "Int"),
      Normal("wrap")
    )

  def htmlProps: List[Normal] =
    List(
      Normal("value").withTypes("String", "Double", "Boolean")
    )

  def svgAttrs: List[AttributeType] = List(
    Normal("cx"),
    Normal("cy"),
    Normal("d"),
    Normal("fill"),
    Normal("pathLength", "pathLength"), // svg attributes are case sensitive
    Normal("points"),
    Normal("r"),
    Normal("rx"),
    Normal("ry"),
    Normal("stroke"),
    Normal("viewBox", "viewBox"), // svg attributes are case sensitive
    Normal("xmlns"),
    Normal("x"),
    Normal("x1"),
    Normal("x2"),
    Normal("y"),
    Normal("y1"),
    Normal("y2")
  )

}

sealed trait AttributeType {
  def name: String
  def attrName: Option[String]
}

final case class Normal(name: String, attrName: Option[String], types: List[String]) extends AttributeType {
  def withTypes(newTypes: String*): Normal =
    Normal(name, attrName, newTypes.toList)
}

object Normal {
  def apply(name: String): Normal = Normal(name, None, List("String"))

  def apply(name: String, attrName: String): Normal = Normal(name, Some(attrName), List("String"))
}

final case class NoValue(name: String, attrName: Option[String]) extends AttributeType

object NoValue {
  def apply(name: String): NoValue = NoValue(name, None)

  def apply(name: String, attrName: String): NoValue = NoValue(name, Some(attrName))
}

final case class EventEmitting(name: String, attrName: Option[String]) extends AttributeType

object EventEmitting {
  def apply(name: String): EventEmitting = EventEmitting(name, None)

  def apply(name: String, attrName: String): EventEmitting = EventEmitting(name, Some(attrName))
}

