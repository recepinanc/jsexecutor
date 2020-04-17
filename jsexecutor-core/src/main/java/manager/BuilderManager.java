package manager;

import annotation.ExecBy;
import constants.FinderType;
import constants.Regex;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;

import java.util.Arrays;

public class BuilderManager
{
    public BuilderManager(Class clz)
    {
        buildIt(clz);
    }

    private void buildIt(Class clz)
    {

        Arrays.stream(clz.getDeclaredFields()).parallel().filter(jField
                -> jField.isAnnotationPresent(ExecBy.class)).forEach(jField
                -> {

            ExecBy scriptBy = jField.getAnnotation(ExecBy.class);
            jField.setAccessible(true);
            try
            {
                if (!scriptBy.js().isEmpty())
                    jField.set(clz, scriptBy.js());
                if (!scriptBy.jquery().isEmpty())
                    jField.set(clz, scriptBy.jquery());
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        });
    }

    public How assertValidFindType(Object object)
    {
        String locatorType;

        if (object instanceof By)
        {
            locatorType = object.toString().replaceAll(Regex.FINDER_TYPE, "");
        }
        else
        {
            try
            {
                locatorType = object.toString().split(Regex.FINDER_TYPE_FOR_WEB_ELEMENT)[1].split(":")[0];

            }
            catch (ArrayIndexOutOfBoundsException o)
            {
                locatorType = object.toString().replaceAll(Regex.FINDER_TYPE, "");
                if (locatorType.equals("Proxy element for"))
                {

                    locatorType = object.toString().split(Regex.FINDER_PROXY)[1].split(":")[0];
                }

            }
            catch (Exception e)
            {

                locatorType = object.toString().split(Regex.FINDER_PROXY)[1].split(":")[0];
            }
        }

        if (locatorType.equals(FinderType.CLASS_NAME))
            return How.CLASS_NAME;

        if (locatorType.equals(FinderType.CSS) || locatorType.equals("cssSelector"))
            return How.CSS;

        if (locatorType.equals(FinderType.ID))
            return How.ID;

        if (locatorType.equals(FinderType.LINK_TEXT))
            return How.LINK_TEXT;

        if (locatorType.equals(FinderType.NAME))
            return How.NAME;

        if (locatorType.equals(FinderType.PARTIAL_LINK_TEXT))
            return How.PARTIAL_LINK_TEXT;

        if (locatorType.equals(FinderType.TAG_NAME))
            return How.TAG_NAME;

        if (locatorType.equals(FinderType.XPATH))
            return How.XPATH;

        //((DefaultElementLocator) ((LocatingElementHandler) ((Proxy) element).h).locator).by

        return null;
    }

    public String finderValue(Object object)
    {
        if (object instanceof By)
        {
            return object.toString().replaceAll(Regex.FINDER_VALUE, "").trim();
        }
        else
        {
            return object.toString().split(Regex.FINDER_VALUE)[1].split("(.$)")[0];
        }
    }
}