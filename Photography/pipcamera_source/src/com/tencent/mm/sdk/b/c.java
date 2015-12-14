// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.b;

import java.util.TimeZone;

public final class c
{

    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final long q[] = {
        300L, 200L, 300L, 200L
    };
    private static final char r[] = {
        '<', '>', '"', '\'', '&'
    };
    private static final String s[] = {
        "&lt;", "&gt;", "&quot;", "&apos;", "&amp;"
    };

    public static boolean a(String s1)
    {
        return s1 == null || s1.length() <= 0;
    }

}
