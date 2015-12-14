// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public final class StringUtil
{

    public static String clipString(String s, int i, boolean flag)
    {
        String s2 = s.substring(0, Math.min(i, s.length()));
        String s1 = s2;
        if (flag)
        {
            s1 = s2;
            if (s2.length() < s.length())
            {
                s1 = (new StringBuilder()).append(s2).append("...").toString();
            }
        }
        return s1;
    }

    public static String convertSetToString(Set set)
    {
        if (set == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        for (set = set.iterator(); set.hasNext(); stringbuilder.append((new StringBuilder()).append("'").append(s).append("'").toString()))
        {
            s = (String)set.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(",");
            }
        }

        return stringbuilder.toString();
    }

    public static String convertStreamToString(InputStream inputstream, Charset charset)
        throws IOException
    {
        inputstream = new BufferedReader(new InputStreamReader(inputstream, charset));
        charset = new StringBuilder();
        do
        {
            String s = inputstream.readLine();
            if (s != null)
            {
                charset.append((new StringBuilder()).append(s).append("\n").toString());
            } else
            {
                inputstream.close();
                return charset.toString();
            }
        } while (true);
    }

    public static String convertStreamToUTF8String(InputStream inputstream)
        throws IOException
    {
        return convertStreamToString(inputstream, Charset.forName("UTF-8"));
    }

    public static boolean isBlank(String s)
    {
        return s == null || s.trim().length() == 0;
    }

    public static boolean isNullOrEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public static String trimOrPadString(String s, int i, char c)
    {
        int j = i;
        if (i < 0)
        {
            j = 0;
        }
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        s = new StringBuffer();
        if (s1.length() > j - 1)
        {
            s.append(s1.substring(s1.length() - j));
        } else
        {
            for (i = 0; i < j - s1.length(); i++)
            {
                s.append(c);
            }

            s.append(s1);
        }
        return s.toString();
    }
}
