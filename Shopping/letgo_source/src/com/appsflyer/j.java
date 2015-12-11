// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.util.Log;

public class j
{

    private static String a;
    private static String b;

    public static void a(String s)
    {
        a = s;
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        while (i < s.length()) 
        {
            if (i == 0 || i == 1 || i > s.length() - 5)
            {
                stringbuilder.append(s.charAt(i));
            } else
            {
                stringbuilder.append("*");
            }
            i++;
        }
        b = stringbuilder.toString();
    }

    public static void b(String s)
    {
        if (s.contains(a))
        {
            Log.i("AppsFlyer_", s.replace(a, b));
        }
    }
}
