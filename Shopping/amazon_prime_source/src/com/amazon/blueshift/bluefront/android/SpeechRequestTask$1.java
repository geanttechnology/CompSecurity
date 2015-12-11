// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android;


// Referenced classes of package com.amazon.blueshift.bluefront.android:
//            SpeechRequestTask

static class cognitionTaskState
{

    static final int $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[];

    static 
    {
        $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState = new int[cognitionTaskState.values().length];
        try
        {
            $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[cognitionTaskState.ReadyForSpeech.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[cognitionTaskState.BeginingOfSpeech.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[cognitionTaskState.BufferReceived.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[cognitionTaskState.RmsChanged.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[cognitionTaskState.SilenceDetected.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[cognitionTaskState.Error.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[cognitionTaskState.NoSpeechTimeout.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$blueshift$bluefront$android$SpeechRequestTask$RecognitionTaskState[cognitionTaskState.MaxSpeechTimeout.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
