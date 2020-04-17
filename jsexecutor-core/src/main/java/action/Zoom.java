package action;

import annotation.ExecBy;
import constants.Constants.Arguments;
import manager.BuilderManager;

public class Zoom
{
    public Zoom()
    {
        new BuilderManager(getClass().getEnclosingClass());
    }

    @ExecBy(js = "document.body.style.zoom = " + Arguments.FIRST + "")
    public String pageZoom;
}
