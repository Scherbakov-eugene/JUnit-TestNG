package org;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MethodInterception
{
    @Test
    public void annotationValue()
    {
        MainPage mainPage = createPage(MainPageImpl.class /*MainPage.class*/);
        assertNotNull(mainPage);
        assertEquals(mainPage.buttonSearch(), ".//*[@test-attr='button_search']");
        assertEquals(mainPage.textInputSearch(), ".//*[@test-attr='input_search']");
    }

    private MainPage createPage(Class clazz)
    {
        try
        {
			return (MainPage) DebugProxy.newInstance(clazz.newInstance());
		}
        catch (InstantiationException e)
        {
			e.printStackTrace();
		}
        catch (IllegalAccessException e)
        {
			e.printStackTrace();
		}

        return null;
    }
}
