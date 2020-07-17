package org;

import java.lang.reflect.Method;

public class MainPageImpl implements MainPage
{
	public String textInputSearch()
	{
		return getAnnotationXPath("textInputSearch");
	}

	public String buttonSearch()
	{
		return getAnnotationXPath("buttonSearch");
	}

	public String getAnnotationXPath(String methodName)
	{
		for (Method m : MainPage.class.getDeclaredMethods())
        {
			if (m.getName().equals(methodName))
			{
	            if (m.isAnnotationPresent(Selector.class))
	            {
	            	Selector sel = m.getAnnotation(Selector.class);
	            	return sel.xpath();
	            }
			}
        }

		return null;
	}
}
