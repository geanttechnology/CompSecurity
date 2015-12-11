// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.vad.config;


// Referenced classes of package com.amazon.blueshift.bluefront.android.vad.config:
//            WebRtcVADConfig

public static final class  extends Enum
{

    private static final VERY_AGGRESSIVE $VALUES[];
    public static final VERY_AGGRESSIVE AGGRESSIVE;
    public static final VERY_AGGRESSIVE LOW_BITRATE;
    public static final VERY_AGGRESSIVE QUALITY;
    public static final VERY_AGGRESSIVE VERY_AGGRESSIVE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/blueshift/bluefront/android/vad/config/WebRtcVADConfig$AggressionMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        QUALITY = new <init>("QUALITY", 0);
        LOW_BITRATE = new <init>("LOW_BITRATE", 1);
        AGGRESSIVE = new <init>("AGGRESSIVE", 2);
        VERY_AGGRESSIVE = new <init>("VERY_AGGRESSIVE", 3);
        $VALUES = (new .VALUES[] {
            QUALITY, LOW_BITRATE, AGGRESSIVE, VERY_AGGRESSIVE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
