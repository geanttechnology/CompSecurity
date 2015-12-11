// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;


public final class DetailLaunchMode extends Enum
{

    private static final DetailLaunchMode $VALUES[];
    public static final DetailLaunchMode DEFAULT;
    public static final DetailLaunchMode ONE_SHOT;

    private DetailLaunchMode(String s, int i)
    {
        super(s, i);
    }

    public static DetailLaunchMode valueOf(String s)
    {
        return (DetailLaunchMode)Enum.valueOf(com/ebay/mobile/search/DetailLaunchMode, s);
    }

    public static DetailLaunchMode[] values()
    {
        return (DetailLaunchMode[])$VALUES.clone();
    }

    static 
    {
        DEFAULT = new DetailLaunchMode("DEFAULT", 0);
        ONE_SHOT = new DetailLaunchMode("ONE_SHOT", 1);
        $VALUES = (new DetailLaunchMode[] {
            DEFAULT, ONE_SHOT
        });
    }
}
