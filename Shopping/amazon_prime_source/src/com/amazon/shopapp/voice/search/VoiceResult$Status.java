// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search;


// Referenced classes of package com.amazon.shopapp.voice.search:
//            VoiceResult

public static final class  extends Enum
{

    private static final ERROR $VALUES[];
    public static final ERROR ERROR;
    public static final ERROR HIGH_CONFIDENCE;
    public static final ERROR LOW_CONFIDENCE;
    public static final ERROR MEDIUM_CONFIDENCE;
    public static final ERROR NO_SPEECH_DETECTED;
    public static final ERROR WRONG_TIME_ON_DEVICE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/shopapp/voice/search/VoiceResult$Status, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HIGH_CONFIDENCE = new <init>("HIGH_CONFIDENCE", 0);
        MEDIUM_CONFIDENCE = new <init>("MEDIUM_CONFIDENCE", 1);
        LOW_CONFIDENCE = new <init>("LOW_CONFIDENCE", 2);
        NO_SPEECH_DETECTED = new <init>("NO_SPEECH_DETECTED", 3);
        WRONG_TIME_ON_DEVICE = new <init>("WRONG_TIME_ON_DEVICE", 4);
        ERROR = new <init>("ERROR", 5);
        $VALUES = (new .VALUES[] {
            HIGH_CONFIDENCE, MEDIUM_CONFIDENCE, LOW_CONFIDENCE, NO_SPEECH_DETECTED, WRONG_TIME_ON_DEVICE, ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
