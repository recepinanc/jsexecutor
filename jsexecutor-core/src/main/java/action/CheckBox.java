package action;

import annotation.ExecBy;

public class CheckBox
{

    public CheckBox()
    {
        new JSFieldManager(this);
    }

    @ExecBy(js = "var checkboxes = document.querySelectorAll('[type=\"checkbox\"]');\n" +
            "\n" +
            "var result; \n" +
            "\n" +
            "for(var i = 0; i < checkboxes.length; i++) \n" +
            "{\n" +
            " \tif(checkboxes[i].checked === false) \n" +
            "\n" +
            "\t{ \n" +
            "\t return result = false;\n" +
            "\t}\n" +
            "}  \n" +
            "\n" +
            "return result = true;")
    public String checkedControl;

    @ExecBy(js = "var checkboxes = document.querySelectorAll(\"input[type='checkbox']\"); for(var i = 0; i < " +
            "checkboxes" +
            ".length; i++) {checkboxes[i].checked = true;}")
    public String allClick;

    @ExecBy(js = "return " + JSConstants.Objects.FIRST + ".checked;")
    public String checkBoxChecked;

}
