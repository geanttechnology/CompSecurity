// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;


public final class mType extends Enum
{

    private static final NATIVE $VALUES[];
    public static final NATIVE NATIVE;
    public static final NATIVE NONE;
    public static final NATIVE WEB_VIEW;
    private final int mType;

    public static mType valueOf(String s)
    {
        return (mType)Enum.valueOf(com/mopub/common/event/BaseEvent$SdkProduct, s);
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
        WEB_VIEW = new <init>("WEB_VIEW", 1, 1);
        NATIVE = new <init>("NATIVE", 2, 2);
        $VALUES = (new .VALUES[] {
            NONE, WEB_VIEW, NATIVE
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        mType = j;
    }
}
