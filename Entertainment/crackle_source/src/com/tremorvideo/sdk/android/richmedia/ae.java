// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import com.tremorvideo.sdk.android.videoad.ad;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public class ae
{

    public static int a = 0;

    public static float a(float f)
    {
        return 1.0F - (float)Math.cos(((double)f * 3.1415926535897931D) / 2D);
    }

    public static float a(int i, int j, float f)
    {
        if ((i & 2) != 2) goto _L2; else goto _L1
_L1:
        if ((j & 1) != 1) goto _L4; else goto _L3
_L3:
        float f1 = c(f);
_L6:
        return f1;
_L4:
        return b(f);
_L2:
        f1 = f;
        if ((j & 1) == 1)
        {
            return a(f);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int a(float f, float f1, float f2)
    {
        return Math.round((1.0F - f2) * f + f1 * f2);
    }

    public static int a(float f, float f1, int i, int j, float f2)
    {
        return a(f, f1, a(i, j, f2));
    }

    public static int a(String s)
    {
        int j = 5381;
        for (int i = 0; i < s.length(); i++)
        {
            j = j + (j << 5) + s.charAt(i);
        }

        return j;
    }

    public static String a(String s, boolean flag, int i)
    {
        Boolean boolean1;
        if (i == 100)
        {
            return ad.x();
        }
        boolean1 = Boolean.valueOf(false);
        String s1 = (new URI(s)).getHost();
        s = boolean1;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        s = boolean1;
        if (s1.toLowerCase().contains("scanscout.com"))
        {
            s = Boolean.valueOf(true);
        }
_L7:
        a;
        JVM INSTR tableswitch 0 3: default 88
    //                   0 90
    //                   1 105
    //                   2 124
    //                   3 128;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return null;
_L2:
        if (flag || s.booleanValue())
        {
            return ad.x();
        }
          goto _L1
_L3:
        if (flag || s.booleanValue())
        {
            return ad.x();
        } else
        {
            return ad.w();
        }
_L4:
        return ad.w();
_L5:
        return ad.x();
        s;
        s = boolean1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static String a(ZipFile zipfile, String s)
    {
        String s1;
        Object obj;
        ZipEntry zipentry;
        try
        {
            obj = zipfile.getName();
        }
        // Misplaced declaration of an exception variable
        catch (ZipFile zipfile)
        {
            ad.a(zipfile);
            return null;
        }
        s1 = ((String) (obj));
        if (((String) (obj)).contains(".zip"))
        {
            s1 = ((String) (obj)).replace(".zip", "");
        }
        obj = zipfile.entries();
        do
        {
            if (!((Enumeration) (obj)).hasMoreElements())
            {
                break;
            }
            zipentry = (ZipEntry)((Enumeration) (obj)).nextElement();
            if (zipentry.getName().startsWith(s))
            {
                a(zipfile, zipentry, s1, true);
            }
        } while (true);
        return s1;
    }

    public static void a(File file)
    {
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                a(afile[i]);
            }

        }
        file.delete();
    }

    private static void a(ZipFile zipfile, ZipEntry zipentry, String s, boolean flag)
        throws IOException
    {
        if (!zipentry.isDirectory()) goto _L2; else goto _L1
_L1:
        c(new File(s, zipentry.getName()));
_L4:
        return;
_L2:
        s = new File(s, zipentry.getName());
        if (!flag && s.exists()) goto _L4; else goto _L3
_L3:
        if (!s.getParentFile().exists())
        {
            c(s.getParentFile());
        }
        ad.d((new StringBuilder()).append("GenericObjec extracting: ").append(zipentry).toString());
        zipfile = new BufferedInputStream(zipfile.getInputStream(zipentry));
        zipentry = new BufferedOutputStream(new FileOutputStream(s));
        s = new byte[1024];
_L5:
        int i = zipfile.read(s);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        zipentry.write(s, 0, i);
          goto _L5
        s;
        ad.a(s);
        zipentry.close();
        zipfile.close();
        return;
        zipentry.close();
        zipfile.close();
        return;
        s;
        zipentry.close();
        zipfile.close();
        throw s;
    }

    public static void a(HttpGet httpget, String s)
    {
        s = c(s);
        if (s != null)
        {
            httpget.setHeader("User-Agent", s);
        }
    }

    public static void a(HttpPost httppost, String s)
    {
        s = c(s);
        if (s != null)
        {
            httppost.setHeader("User-Agent", s);
        }
    }

    public static float b(float f)
    {
        return (float)(-Math.cos((double)f * 1.5707963267948966D + 1.5707963267948966D));
    }

    public static float b(float f, float f1, float f2)
    {
        return (1.0F - f2) * f + f1 * f2;
    }

    public static float b(float f, float f1, int i, int j, float f2)
    {
        return b(f, f1, a(i, j, f2));
    }

    public static String b(File file)
    {
        StringBuilder stringbuilder = new StringBuilder();
        file = new BufferedReader(new FileReader(file));
_L1:
        String s = file.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        stringbuilder.append(s);
        stringbuilder.append(System.getProperty("line.separator"));
          goto _L1
        Exception exception;
        exception;
        try
        {
            file.close();
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            ad.a(file);
        }
_L2:
        return stringbuilder.toString();
        file.close();
          goto _L2
    }

    public static String b(String s)
    {
        StringBuilder stringbuilder;
        s = new File(s);
        if (!s.exists())
        {
            return null;
        }
        stringbuilder = new StringBuilder();
        Object obj = new BufferedReader(new FileReader(s));
_L4:
        s = ((String) (obj));
        String s1 = ((BufferedReader) (obj)).readLine();
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s = ((String) (obj));
        stringbuilder.append(s1);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
_L8:
        s = ((String) (obj));
        exception.printStackTrace();
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        return stringbuilder.toString();
_L2:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        obj;
        s = null;
_L6:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        throw obj;
        obj;
        if (true) goto _L6; else goto _L5
_L5:
        exception;
        obj = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static float c(float f)
    {
        return (float)(1.0D - Math.cos((double)f * 3.1415926535897931D)) / 2.0F;
    }

    public static String c(String s)
    {
        return a(s, false, -1);
    }

    private static void c(File file)
    {
        while (file.exists() || file.mkdirs()) 
        {
            return;
        }
        throw new RuntimeException((new StringBuilder()).append("Can not create dir ").append(file).toString());
    }

}
