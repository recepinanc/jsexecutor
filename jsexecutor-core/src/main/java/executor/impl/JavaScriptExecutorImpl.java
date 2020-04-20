package executor.impl;

import executor.JavaScriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DataType;

import java.util.List;

public interface JavaScriptExecutorImpl
{
    JavaScriptExecutor getDriver(WebDriver driver);

    JavaScriptExecutor executeScript(String script, Object... args);

    <T> T executeScript(Class<T> clazz, String script, Object... args);

    /**
     * LocalStorage
     **/

    void removeItemFromLocalStorage(String item);

    boolean isItemPresentInLocalStorage(String item);

    String getItemFromLocalStorage(String item);

    String getKeyFromLocalStorage(int key);

    Long getLocalStorageLength();

    void setItemInLocalStorage(String item, String value);

    void clearLocalStorage();

    /**
     * SessionStorage
     **/

    void removeItemFromSessionStorage(String item);

    boolean isItemPresentInSessionStorage(String item);

    String getItemFromSessionStorage(String key);

    String getKeyFromSessionStorage(int key);

    Long getSessionStorageLength();

    void setItemInSessionStorage(String item, String value);

    void clearSessionStorage();

    /**
     * Scroll
     **/

    JavaScriptExecutor scrollWithElement(WebElement element);

    JavaScriptExecutor scrollHorizontally(int value);

    JavaScriptExecutor scrollVertically(int value);

    JavaScriptExecutor scrollHorizontallyAndVertically(int h, int v);

    JavaScriptExecutor scrollDown();

    JavaScriptExecutor scrollUp();

    JavaScriptExecutor scrollPageCenter();

    /**
     * Click
     **/

    JavaScriptExecutor click(Object object);

    JavaScriptExecutor forceClick(Object object);

    JavaScriptExecutor click(List<WebElement> object, int index);

    JavaScriptExecutor doubleClick(Object object);

    JavaScriptExecutor randomElementClick(List<Object> objects);


    /** ElementIsDisplayed **/

    //boolean isDisplayed(String script);

    /**
     * Url
     **/
    JavaScriptExecutor goToUrl(String url);

    /**
     * Set Value
     **/
    JavaScriptExecutor setValue(Object object, String value);

    JavaScriptExecutor sleep(int time);

    JavaScriptExecutor assertTrue(boolean value);

    JavaScriptExecutor assertFalse(boolean value);

    JavaScriptExecutor assertEqual(String expected, String actual);

    JavaScriptExecutor clear(Object object);

    /**
     * Get Value
     **/

    String getText(Object object);

    /**
     * checkbox
     **/

    boolean isCheckBoxChecked(Object object);

    boolean isCheckedAllCheckBox();

    JavaScriptExecutor checkAllCheckBox();

    /**
     * Assert
     **/

    boolean isDisplayed(Object object);

    /**
     * Is Attribute Present
     **/

    boolean isAttributePresent(Object object, Object attributeName);

    /**
     * Open Tab
     **/

    JavaScriptExecutor newTab(String url);

    /**
     * Random Generate
     **/

    Object randomGenerate(DataType dataType, int length);

    /**
     * Select
     **/

    JavaScriptExecutor selectByValue(Object object, Object valueName);

    JavaScriptExecutor selectByIndex(Object object, Object index);

    List<Object> getSelectBoxOptionsValue(Object object);

    Object getSelectBoxOptionsText(Object object);

    /**
     * Selected Option
     **/

    String getSelectedOptionVisibleText(Object object);

    Number getSelectedOptionIndex(Object object);

    String getSelectedOptionValue(Object object);

    /**
     * Get Attribute
     **/

    Object getAttribute(Object object, Object attributeName);

    /**
     * Zoom
     **/

    JavaScriptExecutor pageZoom(int percentValue);

    /**
     * Mouse Over
     **/

    JavaScriptExecutor mouseOver(Object object);

    /**
     * Page Refresh
     **/

    JavaScriptExecutor pageRefresh();

    /**
     * Get Location Path Name "www.siteName.com/LOCATION_PATH_NAME"
     **/

    String getLocationPathName();

    /**
     * Get Current URL
     **/

    String getCurrentUrl();

    /**
     * wait
     */
    JavaScriptExecutor ajaxComplete();

    JavaScriptExecutor checkExist(Object object, int millisecond);

    /**
     * encode - decode
     */

    String decode(String text);

}