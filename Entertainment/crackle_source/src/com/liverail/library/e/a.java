// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.e;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;

public class a
{

    public a()
    {
    }

    public static String a(InputStream inputstream)
    {
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        inputstream = new StringBuilder(inputstream.available());
_L1:
        String s = bufferedreader.readLine();
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        return inputstream.toString();
        inputstream.append(s);
          goto _L1
        inputstream;
        com.liverail.library.b.a.e(inputstream.getMessage());
        return "";
    }

    public static boolean a(String s)
    {
        return s.equalsIgnoreCase("true") || s.equalsIgnoreCase("1") || s.equalsIgnoreCase("yes");
    }

    public static float b(String s)
    {
        float f1;
        try
        {
            f1 = Float.parseFloat(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            f1 = 0.0F;
        }
        if (f1 >= 0.0F)
        {
            return f1;
        } else
        {
            return 0.0F;
        }
    }

    public static float c(String s)
    {
        float f1;
        try
        {
            f1 = Float.parseFloat(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0.0F;
        }
        return f1;
    }

    public static int d(String s)
    {
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            i = 0;
        }
        if (i >= 0)
        {
            return i;
        } else
        {
            return 0;
        }
    }

    public static int e(String s)
    {
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0;
        }
        return i;
    }

    public static String f(String s)
    {
        int i = 0;
        byte abyte0[];
        StringBuilder stringbuilder;
        int j;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            byte abyte1[] = s.getBytes("UTF-8");
            messagedigest.update(abyte1, 0, abyte1.length);
            abyte0 = messagedigest.digest();
            stringbuilder = new StringBuilder();
            j = abyte0.length;
        }
        catch (Exception exception)
        {
            com.liverail.library.b.a.d((new StringBuilder("Failed to convert to SHA-1 string=")).append(s).append("\n").append(exception).toString());
            return null;
        }
        if (i < j)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        return stringbuilder.toString();
        stringbuilder.append(String.format("%02X", new Object[] {
            Byte.valueOf(abyte0[i])
        }));
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_40;
        }
    }
}
