package org.testng;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@TestMethodInfo(priority = Priority.Critical, author = "Test user", lastModified = "20.08.2019")
public class Main
{
	@BeforeTest
	public void setUp()
	{
        if (Main.class.isAnnotationPresent(TestMethodInfo.class))
        {
        	TestMethodInfo tmi = Main.class.getAnnotation(TestMethodInfo.class);
        	System.out.println("Priority = " + tmi.priority());
        	System.out.println("Author = " + tmi.author());
        	System.out.println("LastModified = " + tmi.lastModified());
        }
	}

	@Test
	public void annotation()
	{
		assertEquals(1, 1);
	}
}
