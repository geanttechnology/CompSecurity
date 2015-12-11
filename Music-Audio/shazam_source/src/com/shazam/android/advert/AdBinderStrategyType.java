// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert;


public final class AdBinderStrategyType extends Enum
{

    private static final AdBinderStrategyType $VALUES[];
    public static final AdBinderStrategyType DEFERRED_REQUEST_RESUMING;
    public static final AdBinderStrategyType PASSIVE;
    public static final AdBinderStrategyType RESUMING;
    public static final AdBinderStrategyType SELECTION;

    private AdBinderStrategyType(String s, int i)
    {
        super(s, i);
    }

    public static AdBinderStrategyType valueOf(String s)
    {
        return (AdBinderStrategyType)Enum.valueOf(com/shazam/android/advert/AdBinderStrategyType, s);
    }

    public static AdBinderStrategyType[] values()
    {
        return (AdBinderStrategyType[])$VALUES.clone();
    }

    static 
    {
        SELECTION = new AdBinderStrategyType("SELECTION", 0);
        RESUMING = new AdBinderStrategyType("RESUMING", 1);
        DEFERRED_REQUEST_RESUMING = new AdBinderStrategyType("DEFERRED_REQUEST_RESUMING", 2);
        PASSIVE = new AdBinderStrategyType("PASSIVE", 3);
        $VALUES = (new AdBinderStrategyType[] {
            SELECTION, RESUMING, DEFERRED_REQUEST_RESUMING, PASSIVE
        });
    }
}
