package net.minecubz.launcher.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class WebInteractions
{
	public static String readTxt(String url)
	{
		String content = "";
		try
		{
			URL location = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(location.openStream()));
			content = in.readLine();
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
		return content;
	}
}
