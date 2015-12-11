// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class ds extends Enum
{

    public static final ds a;
    public static final ds b;
    public static final ds c;
    private static final ds d[];

    private ds(String s, int i)
    {
        super(s, i);
    }

    public static ds valueOf(String s)
    {
        return (ds)Enum.valueOf(com/flurry/sdk/ds, s);
    }

    public static ds[] values()
    {
        return (ds[])d.clone();
    }

    static 
    {
        a = new ds("VIDEO_AD_TYPE_VAST", 0);
        b = new ds("VIDEO_AD_TYPE_MRAID", 1);
        c = new ds("VIDEO_AD_TYPE_CLIPS", 2);
        d = (new ds[] {
            a, b, c
        });
    }
}
