package net.minecubz.launcher.core;

import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class CryptManager
{

	private static String getHexString(byte[] bytes)
	{
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (byte b : bytes)
		{
			if (b <= 0x0F && b >= 0x00)
			{ // On rajoute le 0 de poid fort ignoré à la conversion.
				sb.append('0');
			}
			sb.append(String.format("%x", b));
		}
		return sb.toString();
	}

	public static String sha1(File file)
	{
		String sha1 = null;
		
		if (!file.exists())
			return "";
		
		if (file.exists() && file.isFile() && file.canRead())
		{
			try
			{
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				@SuppressWarnings("resource")
				DigestInputStream dis = new DigestInputStream(new FileInputStream(file), md);
				dis.on(true);

				while (dis.read() != -1)
				{
					;
				}
				byte[] b = md.digest();
				sha1 = getHexString(b);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		else
		{
			System.out.println("[ERREUR] Impossible de trouver le fichier : " + file.getAbsolutePath());
		}
		return sha1;
	}
}
