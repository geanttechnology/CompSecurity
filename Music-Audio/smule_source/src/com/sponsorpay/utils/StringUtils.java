// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;


public class StringUtils
{

    public static final String EMPTY_STRING = "";

    public StringUtils()
    {
    }

    public static final boolean notNullNorEmpty(String s)
    {
        return !nullOrEmpty(s);
    }

    public static final boolean nullOrEmpty(String s)
    {
        return s == null || s.trim().equals("");
    }

    public static String trim(String s)
    {
        if (s != null)
        {
            return s.trim();
        } else
        {
            return null;
        }
    }
}
