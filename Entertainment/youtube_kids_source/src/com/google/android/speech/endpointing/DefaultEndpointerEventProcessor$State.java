// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.endpointing;


final class Q extends Enum
{

    private static final END_OF_SPEECH $VALUES[];
    public static final END_OF_SPEECH DELAY_END_OF_SPEECH;
    public static final END_OF_SPEECH END_OF_SPEECH;
    public static final END_OF_SPEECH NO_SPEECH_DETECTED;
    public static final END_OF_SPEECH SPEECH_DETECTED;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/google/android/speech/endpointing/DefaultEndpointerEventProcessor$State, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        NO_SPEECH_DETECTED = new <init>("NO_SPEECH_DETECTED", 0);
        SPEECH_DETECTED = new <init>("SPEECH_DETECTED", 1);
        DELAY_END_OF_SPEECH = new <init>("DELAY_END_OF_SPEECH", 2);
        END_OF_SPEECH = new <init>("END_OF_SPEECH", 3);
        $VALUES = (new .VALUES[] {
            NO_SPEECH_DETECTED, SPEECH_DETECTED, DELAY_END_OF_SPEECH, END_OF_SPEECH
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
