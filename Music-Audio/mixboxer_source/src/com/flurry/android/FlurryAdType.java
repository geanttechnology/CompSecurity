// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


public final class FlurryAdType extends Enum
{

    public static final FlurryAdType VIDEO_TAKEOVER;
    public static final FlurryAdType WEB_BANNER;
    public static final FlurryAdType WEB_TAKEOVER;
    private static final FlurryAdType cb[];

    private FlurryAdType(String s, int i)
    {
        super(s, i);
    }

    public static FlurryAdType valueOf(String s)
    {
        return (FlurryAdType)Enum.valueOf(com/flurry/android/FlurryAdType, s);
    }

    public static FlurryAdType[] values()
    {
        return (FlurryAdType[])cb.clone();
    }

    static 
    {
        WEB_BANNER = new FlurryAdType("WEB_BANNER", 0);
        WEB_TAKEOVER = new FlurryAdType("WEB_TAKEOVER", 1);
        VIDEO_TAKEOVER = new FlurryAdType("VIDEO_TAKEOVER", 2);
        cb = (new FlurryAdType[] {
            WEB_BANNER, WEB_TAKEOVER, VIDEO_TAKEOVER
        });
    }
}
