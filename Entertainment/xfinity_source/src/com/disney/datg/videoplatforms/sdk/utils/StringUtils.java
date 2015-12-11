// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.utils;


public final class StringUtils
{

    public static boolean isNotNull(String s)
    {
        return s != null && !s.equalsIgnoreCase("null") && !s.trim().equals("") && !s.equalsIgnoreCase("-1");
    }
}
