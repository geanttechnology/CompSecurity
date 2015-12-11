// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            InterstitialAd

static final class  extends Enum
{

    private static final DISMISSED $VALUES[];
    public static final DISMISSED DISMISSED;
    public static final DISMISSED LOADING;
    public static final DISMISSED READY_TO_LOAD;
    public static final DISMISSED READY_TO_SHOW;
    public static final DISMISSED SHOWING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/ads/InterstitialAd$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        READY_TO_LOAD = new <init>("READY_TO_LOAD", 0);
        LOADING = new <init>("LOADING", 1);
        READY_TO_SHOW = new <init>("READY_TO_SHOW", 2);
        SHOWING = new <init>("SHOWING", 3);
        DISMISSED = new <init>("DISMISSED", 4);
        $VALUES = (new .VALUES[] {
            READY_TO_LOAD, LOADING, READY_TO_SHOW, SHOWING, DISMISSED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
