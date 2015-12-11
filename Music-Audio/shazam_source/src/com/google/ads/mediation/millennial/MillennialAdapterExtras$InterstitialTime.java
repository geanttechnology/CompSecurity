// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;


// Referenced classes of package com.google.ads.mediation.millennial:
//            MillennialAdapterExtras

public static final class  extends Enum
{

    private static final TRANSITION $VALUES[];
    public static final TRANSITION APP_LAUNCH;
    public static final TRANSITION TRANSITION;
    public static final TRANSITION UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$InterstitialTime, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        APP_LAUNCH = new <init>("APP_LAUNCH", 1);
        TRANSITION = new <init>("TRANSITION", 2);
        $VALUES = (new .VALUES[] {
            UNKNOWN, APP_LAUNCH, TRANSITION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
