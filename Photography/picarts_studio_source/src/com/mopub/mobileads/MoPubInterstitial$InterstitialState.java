// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


final class  extends Enum
{

    private static final NOT_READY $VALUES[];
    public static final NOT_READY CUSTOM_EVENT_AD_READY;
    public static final NOT_READY NOT_READY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/mobileads/MoPubInterstitial$InterstitialState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    final boolean isReady()
    {
        return this != NOT_READY;
    }

    static 
    {
        CUSTOM_EVENT_AD_READY = new <init>("CUSTOM_EVENT_AD_READY", 0);
        NOT_READY = new <init>("NOT_READY", 1);
        $VALUES = (new .VALUES[] {
            CUSTOM_EVENT_AD_READY, NOT_READY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
