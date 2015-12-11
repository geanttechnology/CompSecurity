// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class StringUtil
{

    private StringUtil()
    {
    }

    public static String getSysProp(String s)
    {
        Object obj = null;
        String s1 = obj;
        BufferedReader bufferedreader;
        try
        {
            bufferedreader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] {
                "/system/bin/getprop", s
            }).getInputStream()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return s1;
        }
        s1 = obj;
        s = bufferedreader.readLine();
        s1 = s;
        bufferedreader.close();
        return s;
    }

    public static String ionEscape(String s)
    {
        return s.replace('.', '_');
    }

    public static boolean isNullOrEmpty(String s)
    {
        return s == null || s.length() == 0;
    }
}
