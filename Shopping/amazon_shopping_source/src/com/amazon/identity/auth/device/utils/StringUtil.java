// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;


public final class StringUtil
{

    private StringUtil()
    {
    }

    public static boolean isEmpty(String s)
    {
        return s != null && s.length() == 0;
    }

    public static boolean isEmptyOrWhitespace(String s)
    {
        return s == null || s.trim().length() == 0;
    }
}
