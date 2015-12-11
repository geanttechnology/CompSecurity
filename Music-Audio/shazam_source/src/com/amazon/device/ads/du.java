// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


final class du
{

    private static String a = "5.6.20";
    private static String b = "amznAdSDK-android-";
    private static String c = null;
    private static String d = "AmazonAdSDK-Android/";
    private static String e = null;
    private static String f = "(DEV)";

    public static String a()
    {
        String s1 = a;
        String s;
        if (s1 == null || s1.equals(""))
        {
            s = f;
        } else
        {
            s = s1;
            if (s1.endsWith("x"))
            {
                return (new StringBuilder()).append(s1).append(f).toString();
            }
        }
        return s;
    }

    public static String b()
    {
        if (c == null)
        {
            c = (new StringBuilder()).append(b).append(a()).toString();
        }
        return c;
    }

    public static String c()
    {
        if (e == null)
        {
            e = (new StringBuilder()).append(d).append(a()).toString();
        }
        return e;
    }

}
