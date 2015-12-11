// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.event;


public final class MASHEventType extends Enum
{

    private static final MASHEventType $VALUES[];
    public static final MASHEventType appPause;
    public static final MASHEventType appResume;
    public static final MASHEventType cartUpdated;

    private MASHEventType(String s, int i)
    {
        super(s, i);
    }

    public static MASHEventType valueOf(String s)
    {
        return (MASHEventType)Enum.valueOf(com/amazon/mobile/mash/event/MASHEventType, s);
    }

    public static MASHEventType[] values()
    {
        return (MASHEventType[])$VALUES.clone();
    }

    static 
    {
        appPause = new MASHEventType("appPause", 0);
        appResume = new MASHEventType("appResume", 1);
        cartUpdated = new MASHEventType("cartUpdated", 2);
        $VALUES = (new MASHEventType[] {
            appPause, appResume, cartUpdated
        });
    }
}
