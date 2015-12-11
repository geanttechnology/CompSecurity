// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android;


// Referenced classes of package com.amazon.blueshift.bluefront.android:
//            SpeechRequestTask

public static final class  extends Enum
{

    private static final MaxSpeechTimeout $VALUES[];
    public static final MaxSpeechTimeout BeginingOfSpeech;
    public static final MaxSpeechTimeout BufferReceived;
    public static final MaxSpeechTimeout EndOfSpeech;
    public static final MaxSpeechTimeout Error;
    public static final MaxSpeechTimeout MaxSpeechTimeout;
    public static final MaxSpeechTimeout NoSpeechTimeout;
    public static final MaxSpeechTimeout ReadyForSpeech;
    public static final MaxSpeechTimeout RmsChanged;
    public static final MaxSpeechTimeout SilenceDetected;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/blueshift/bluefront/android/SpeechRequestTask$RecognitionTaskState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ReadyForSpeech = new <init>("ReadyForSpeech", 0);
        BeginingOfSpeech = new <init>("BeginingOfSpeech", 1);
        BufferReceived = new <init>("BufferReceived", 2);
        RmsChanged = new <init>("RmsChanged", 3);
        SilenceDetected = new <init>("SilenceDetected", 4);
        EndOfSpeech = new <init>("EndOfSpeech", 5);
        Error = new <init>("Error", 6);
        NoSpeechTimeout = new <init>("NoSpeechTimeout", 7);
        MaxSpeechTimeout = new <init>("MaxSpeechTimeout", 8);
        $VALUES = (new .VALUES[] {
            ReadyForSpeech, BeginingOfSpeech, BufferReceived, RmsChanged, SilenceDetected, EndOfSpeech, Error, NoSpeechTimeout, MaxSpeechTimeout
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
