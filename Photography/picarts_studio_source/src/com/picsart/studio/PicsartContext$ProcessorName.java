// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.text.TextUtils;

final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN ARMV6;
    public static final UNKNOWN ARMV7;
    public static final UNKNOWN UNKNOWN;

    static  fromString(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return UNKNOWN;
        }
        if (s.equalsIgnoreCase("6"))
        {
            return ARMV6;
        }
        if (s.equalsIgnoreCase("7"))
        {
            return ARMV7;
        } else
        {
            return UNKNOWN;
        }
    }

    public static UNKNOWN valueOf(String s)
    {
        return (UNKNOWN)Enum.valueOf(com/picsart/studio/PicsartContext$ProcessorName, s);
    }

    public static UNKNOWN[] values()
    {
        return (UNKNOWN[])$VALUES.clone();
    }

    static 
    {
        ARMV6 = new <init>("ARMV6", 0);
        ARMV7 = new <init>("ARMV7", 1);
        UNKNOWN = new <init>("UNKNOWN", 2);
        $VALUES = (new .VALUES[] {
            ARMV6, ARMV7, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
