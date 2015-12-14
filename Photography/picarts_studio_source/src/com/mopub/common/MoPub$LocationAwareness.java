// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;


public final class  extends Enum
{

    private static final DISABLED $VALUES[];
    public static final DISABLED DISABLED;
    public static final DISABLED NORMAL;
    public static final DISABLED TRUNCATED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/common/MoPub$LocationAwareness, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NORMAL = new <init>("NORMAL", 0);
        TRUNCATED = new <init>("TRUNCATED", 1);
        DISABLED = new <init>("DISABLED", 2);
        $VALUES = (new .VALUES[] {
            NORMAL, TRUNCATED, DISABLED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
