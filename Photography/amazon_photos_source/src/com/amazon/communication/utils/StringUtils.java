// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.utils;


public class StringUtils
{

    public static boolean isNullOrEmpty(String s)
    {
        return s == null || s.trim().length() == 0;
    }
}
