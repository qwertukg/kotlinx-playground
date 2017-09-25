package kz.qwertukg.ui

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import org.springframework.http.HttpMethod
import org.springframework.http.HttpRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HomeController {
    @GetMapping
    fun index(): String {
        val html = createHTML().html {
            this.lang = "en"
            head {
                link("https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css", "stylesheet")
                //link("https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js", "stylesheet")
                script("text/javascript", "https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.8/ace.js")
                script("text/javascript", "https://code.jquery.com/jquery-1.12.4.min.js")

                script {
                    unsafe {
                        +"""
$(document).ready(function() {
        var editor = ace.edit('editor');
//        editor.setTheme('ace/theme/monokai');
        editor.getSession().setMode('ace/mode/json');


});
                    """
                    }

                }
            }
            body {
                div("container-fluid") {
                    h1 { +"Request" }

                    div("row") {
                        div("col") {
                            form(action = "#") {
                                div("form-group") {
                                    div("form-row") {
                                        div("col-2") {
                                            select("form-control") {
                                                HttpMethod.values().forEach {
                                                    option { +it.toString() }
                                                }
                                            }
                                        }
                                        div("col-10") {
                                            input(InputType.text, classes = "form-control") { placeholder = "Url address" }
                                        }
                                    }
                                }
                                div("form-group") {
                                    div("form-row") {
                                        div("col-1") {
                                            submitInput(classes = "btn btn-danger") { value = "X" }
                                        }
                                        div("col-5") {
                                            input(InputType.text, classes = "form-control") { placeholder = "Header name" }
                                        }
                                        div("col-6") {
                                            input(InputType.text, classes = "form-control") { placeholder = "Value" }
                                        }
                                    }
                                }
                                div("form-group") {
                                    submitInput(classes = "btn btn-primary") { value = "Add header" }
                                }

                                div("form-group") {
                                    div("btn-group") {
                                        submitInput(classes = "btn") { value = "Json" }
                                        submitInput(classes = "btn") { value = "Xml" }
                                    }
                                    div {
                                        id = "editor"
                                        attributes["style"] = "width: 100%; height: 300px;" +
                                                "border: 1px solid rgba(0,0,0,.15);" +
                                                "border-radius: .25rem;"
                                    }
                                    //textArea(classes = "form-control") { placeholder = "Request body" }
                                }
                                div("form-group ") { submitInput(classes = "btn btn-primary") }
                            }
                        }
                        div("col") {

                        }
                    }
                }

            }
        }

        return html
    }
}