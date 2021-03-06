package action;

import constants.Constants.Arguments;
import annotation.Exec;
import manager.BuilderManager;

public class Click
{
    public Click()
    {
        new BuilderManager(this);
    }

    @Exec(js = "var el = document.getElementById(" + Arguments.FIRST + "); const rect = el[" + Arguments.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + Arguments.SECOND + "].click();}")
    public String idAll;

    @Exec(js = "var el = document.getElementsByClassName(" + Arguments.FIRST + "); const rect = el[" + Arguments.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + Arguments.SECOND + "].click();}")
    public String classNameAll;

    @Exec(js = "var el = document.getElementsByName(" + Arguments.FIRST + "); const rect = el[" + Arguments.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + Arguments.SECOND + "].click();}")
    public String nameAll;

    @Exec(js = "var el = document.querySelector(\"*[href=" + Arguments.FIRST + "]\"); const rect = el[" + Arguments.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + Arguments.SECOND + "].click();}")
    public String linkTextAll;

    @Exec(js = "var el = document.getElementsByTagName(" + Arguments.FIRST + "); const rect = el[" + Arguments.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + Arguments.SECOND + "].click();}")
    public String tagNameAll;

    @Exec(js = "var el = document.querySelectorAll(" + Arguments.FIRST + "); const rect = el[" + Arguments.SECOND + "].getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){el[" + Arguments.SECOND + "].click();}")
    public String cssAll;

    @Exec(js = "var el = document.evaluate(" + Arguments.FIRST + ", document, null,XPathResult.ANY_TYPE, null); var item = el.iterateNext(" + Arguments.SECOND + "); const rect = item.getBoundingClientRect(); const windowHeight = (window.innerHeight || document.documentElement.clientHeight); const windowWidth = (window.innerWidth || document.documentElement.clientWidth); const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0); const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0); if (vertInView & horInView){item.click();}")
    public String xpathAll;

    @Exec(js = "var el = " + Arguments.FIRST + "; const rect = el.getBoundingClientRect(); \n" +
            "const windowHeight = (window.innerHeight || document.documentElement.clientHeight);\n" +
            "const windowWidth = (window.innerWidth || document.documentElement.clientWidth);\n" +
            "const vertInView = (rect.top <= windowHeight) && ((rect.top + rect.height) >= 0);\n" +
            "const horInView = (rect.left <= windowWidth) && ((rect.left + rect.width) >= 0);\n" +
            "if (vertInView & horInView) \n" +
            "{\n" +
            "el.click();\n" +
            "}")
    public String isVisibleClick;

    @Exec(js = "document.getElementById(" + Arguments.FIRST + ").click();")
    public String id;

    @Exec(js = "document.getElementsByClassName(" + Arguments.FIRST + ").click();")
    public String className;

    @Exec(js = "document.getElementsByName(" + Arguments.FIRST + ").click();")
    public String name;

    @Exec(js = "document.querySelector(\"*[href=" + Arguments.FIRST + "]\").click();")
    public String linkText;

    @Exec(js = "document.getElementsByTagName(" + Arguments.FIRST + ").click();")
    public String tagName;

    @Exec(js = "document.querySelectorAll(" + Arguments.FIRST + ").click();")
    public String css;

    @Exec(js = "var el = document.evaluate(" + Arguments.FIRST + ", document, null,XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; el.click();")
    public String xpath;

    @Exec(js = "for(var i=0; i < 2; i++) {" + Arguments.FIRST + ".click();}")
    public String doubleClick;
}
