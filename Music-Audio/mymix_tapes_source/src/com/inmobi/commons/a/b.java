// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.a;

import android.content.Context;
import com.inmobi.commons.core.b.c;

public class b
{

    public static String a()
    {
        char ac[] = b().toCharArray();
        String s = "";
        int i = 0;
        while (i < ac.length) 
        {
            if (ac[i] == '.')
            {
                s = (new StringBuilder()).append(s).append("T").toString();
            } else
            {
                s = (new StringBuilder()).append(s).append((char)((ac[i] - 48) + 65)).toString();
            }
            i++;
        }
        return (new StringBuilder()).append("pr-SAND-").append(s).append("-").append(e()).toString();
    }

    public static String a(Context context)
    {
        return com.inmobi.commons.core.b.c.a(context, "sdk_version_store").b("sdk_version", null);
    }

    public static void a(Context context, String s)
    {
        com.inmobi.commons.core.b.c.a(context, "sdk_version_store").a("sdk_version", s);
    }

    public static String b()
    {
        return "5.1.1";
    }

    public static String c()
    {
        return "2.0";
    }

    public static String d()
    {
        return "android";
    }

    public static String e()
    {
        return "20151202";
    }

    public static String f()
    {
        return "http://www.inmobi.com/products/sdk/#downloads";
    }
}
