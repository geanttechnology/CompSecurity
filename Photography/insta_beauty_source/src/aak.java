// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class aak
{

    public static void a(File file, String s)
    {
        Object obj = new File(s);
        if (!((File) (obj)).exists())
        {
            ((File) (obj)).mkdirs();
        }
        file = new ZipFile(file);
        obj = file.entries();
        do
        {
            if (!((Enumeration) (obj)).hasMoreElements())
            {
                break;
            }
            ZipEntry zipentry = (ZipEntry)((Enumeration) (obj)).nextElement();
            InputStream inputstream = file.getInputStream(zipentry);
            String s1 = new String((new StringBuilder()).append(s).append(File.separator).append(zipentry.getName()).toString().getBytes("8859_1"), "GB2312");
            File file1 = new File(s1);
            Log.v("ZipUtil", (new StringBuilder()).append("ZipUtil upZipFile file Name:").append(s1).toString());
            if (s1 == null || !s1.contains("__MACOSX") && !s1.contains("/._") && !s1.contains(".DS_Store"))
            {
                File file2 = file1.getParentFile();
                if (!file2.exists())
                {
                    file2.mkdirs();
                }
                if (zipentry.isDirectory())
                {
                    if (!file1.exists())
                    {
                        file1.mkdirs();
                    }
                } else
                {
                    if (!file1.exists())
                    {
                        file1.createNewFile();
                    }
                    FileOutputStream fileoutputstream = new FileOutputStream(file1);
                    byte abyte0[] = new byte[0x100000];
                    do
                    {
                        int i = inputstream.read(abyte0);
                        if (i <= 0)
                        {
                            break;
                        }
                        fileoutputstream.write(abyte0, 0, i);
                    } while (true);
                    inputstream.close();
                    fileoutputstream.close();
                }
            }
        } while (true);
    }

    public static boolean a(byte abyte0[], String s)
    {
        boolean flag;
        flag = true;
        if (abyte0 == null || s == null)
        {
            return false;
        }
        try
        {
            s = new FileOutputStream(s);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return false;
        }
        s.write(abyte0);
_L2:
        s.close();
        return flag;
        abyte0;
        abyte0.printStackTrace();
        return false;
        abyte0;
        abyte0.printStackTrace();
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
