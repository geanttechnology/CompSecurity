// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import java.util.TimeZone;

public final class Util
{

    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final char INVALID[] = {
        '<', '>', '"', '\'', '&'
    };
    private static final long LIGHT_PATTERN[] = {
        300L, 50L, 300L, 50L
    };
    private static final String VALID[] = {
        "&lt;", "&gt;", "&quot;", "&apos;", "&amp;"
    };
    private static final long VIRBRATOR_PATTERN[] = {
        300L, 200L, 300L, 200L
    };

    private Util()
    {
    }

    public static boolean isNullOrNil(String s)
    {
        return s == null || s.length() <= 0;
    }

}
