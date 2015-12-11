// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


public class Conditions
{

    public Conditions()
    {
    }

    public static String beginsWith(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20bw%20").append(s1).toString();
    }

    public static String contains(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20c%20").append(s1).toString();
    }

    public static String endsWith(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20ew%20").append(s1).toString();
    }

    public static String equals(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20eq%20").append(s1).toString();
    }

    public static String greaterThan(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20gt%20").append(s1).toString();
    }

    public static String greaterThanEquals(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20gte%20").append(s1).toString();
    }

    public static String in(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20in%20").append(s1).toString();
    }

    public static String lesserThan(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20lt%20").append(s1).toString();
    }

    public static String lesserThanEquals(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20lte%20").append(s1).toString();
    }

    public static String notBeginsWith(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20nbw%20").append(s1).toString();
    }

    public static String notContains(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20nc%20").append(s1).toString();
    }

    public static String notEndsWith(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20new%20").append(s1).toString();
    }

    public static String notEquals(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("%20ne%20").append(s1).toString();
    }
}
