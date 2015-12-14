// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;


public final class mType extends Enum
{

    private static final MOBILE_WEB $VALUES[];
    public static final MOBILE_WEB ANDROID;
    public static final MOBILE_WEB IOS;
    public static final MOBILE_WEB MOBILE_WEB;
    public static final MOBILE_WEB NONE;
    private final int mType;

    public static mType valueOf(String s)
    {
        return (mType)Enum.valueOf(com/mopub/common/event/BaseEvent$AppPlatform, s);
    }

    public static mType[] values()
    {
        return (mType[])$VALUES.clone();
    }

    public final int getType()
    {
        return mType;
    }

    static 
    {
        NONE = new <init>("NONE", 0, 0);
        IOS = new <init>("IOS", 1, 1);
        ANDROID = new <init>("ANDROID", 2, 2);
        MOBILE_WEB = new <init>("MOBILE_WEB", 3, 3);
        $VALUES = (new .VALUES[] {
            NONE, IOS, ANDROID, MOBILE_WEB
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        mType = j;
    }
}
