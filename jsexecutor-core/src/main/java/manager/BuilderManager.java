package manager;

import annotation.Exec;
import constants.FinderType;
import constants.Regex;
import exception.JavaScriptExecutorException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;

import java.util.Arrays;

public class BuilderManager
{
    public BuilderManager()
    {
    }

    public BuilderManager(Object clz)
    {
        buildIt(clz);
    }

    private void buildIt(Object clz)
    {
        Arrays.stream(clz.getClass().getDeclaredFields()).parallel().filter(jField
                -> jField.isAnnotationPresent(Exec.class)).forEach(jField
                -> {

            Exec exec = jField.getAnnotation(Exec.class);
            jField.setAccessible(true);
            try
            {
                if (!exec.js().isEmpty())
                    jField.set(clz, exec.js());
                if (!exec.jquery().isEmpty())
                    jField.set(clz, exec.jquery());
                if (!exec.sql().isEmpty())
                    jField.set(clz, exec.sql());
                if (!exec.path().isEmpty())
                    jField.set(clz, exec.path());
                if (!exec.func().isEmpty())
                    jField.set(clz, exec.func());
                if (!exec.func().isEmpty() && !exec.path().isEmpty())
                {
                    jField.set(clz, "func[" + exec.func() + "]" + "path[" + exec.path() + "]");
                }
            }
            catch (IllegalAccessException ae)
            {
                throw new JavaScriptExecutorException(ae);
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
