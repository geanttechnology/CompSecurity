// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

public class ah
{

    private String a;
    private int b;

    public ah()
    {
        b = 4096;
        a = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").toString();
    }

    public static String a(File file, String s)
    {
        String s1 = file.getParent();
        String s2 = file.getName();
        s = (new StringBuilder()).append(s2.substring(0, s2.lastIndexOf("."))).append(s).toString().replaceAll(" ", "");
        s = new File((new StringBuilder()).append(s1).append("/").append(s).toString());
        if (!s.exists() && file.exists())
        {
            file.renameTo(s);
            return s.getAbsolutePath();
        } else
        {
            return file.getAbsolutePath();
        }
    }

    public static String d(String s)
    {
        byte abyte0[];
        abyte0 = null;
        s = new File(s);
        if (s.isFile()) goto _L2; else goto _L1
_L1:
        s = abyte0;
_L5:
        return s;
_L2:
        abyte0 = new byte[1024];
        MessageDigest messagedigest;
        messagedigest = MessageDigest.getInstance("MD5");
        s = new FileInputStream(s);
_L3:
        int i = s.read(abyte0, 0, 1024);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                messagedigest.update(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return null;
            }
        }
          goto _L3
        s.close();
        String s1 = (new BigInteger(1, messagedigest.digest())).toString(16);
        int j = 16 - s1.length();
        s = s1;
        if (j > 0)
        {
            return (new StringBuilder()).append("00000000000".substring(0, j)).append(s1).toString();
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static String e(String s)
    {
        String s1 = "";
        if (!TextUtils.isEmpty(s))
        {
            s1 = s.substring(s.lastIndexOf("/") + 1, s.length());
        }
        return s1;
    }

    public File a(String s)
    {
        s = new File((new StringBuilder()).append(a).append(s).toString());
        s.createNewFile();
        return s;
    }

    public File a(String s, String s1, InputStream inputstream)
    {
        byte abyte0[] = null;
        File file;
        int i;
        try
        {
            b(s);
            file = a((new StringBuilder()).append(s).append(s1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            s = null;
            file = null;
            continue; /* Loop/switch isn't completed */
        }
        s = new FileOutputStream(file);
        s1 = s;
        abyte0 = new byte[b];
_L2:
        s1 = s;
        i = inputstream.read(abyte0);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        s.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
        inputstream;
_L6:
        s1 = s;
        inputstream.printStackTrace();
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return file;
        }
        return file;
_L1:
        s1 = s;
        s.flush();
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return file;
        }
        return file;
        s;
        s1 = abyte0;
_L4:
        try
        {
            s1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
        }
        throw s;
        s;
        if (true) goto _L4; else goto _L3
_L3:
        inputstream;
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String a()
    {
        return a;
    }

    public File b(String s)
    {
        s = new File((new StringBuilder()).append(a).append(s).toString());
        s.mkdir();
        return s;
    }

    public boolean c(String s)
    {
        return (new File((new StringBuilder()).append(a).append(s).toString())).exists();
    }
}
