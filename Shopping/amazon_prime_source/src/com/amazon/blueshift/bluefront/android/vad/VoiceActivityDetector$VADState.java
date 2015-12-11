// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.vad;


// Referenced classes of package com.amazon.blueshift.bluefront.android.vad:
//            VoiceActivityDetector

public static final class  extends Enum
{

    private static final ENDPOINTED $VALUES[];
    public static final ENDPOINTED ENDPOINTED;
    public static final ENDPOINTED NOT_STARTPOINTED;
    public static final ENDPOINTED STARTPOINTED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/blueshift/bluefront/android/vad/VoiceActivityDetector$VADState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NOT_STARTPOINTED = new <init>("NOT_STARTPOINTED", 0);
        STARTPOINTED = new <init>("STARTPOINTED", 1);
        ENDPOINTED = new <init>("ENDPOINTED", 2);
        $VALUES = (new .VALUES[] {
            NOT_STARTPOINTED, STARTPOINTED, ENDPOINTED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
