// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            j, Prompt, SpeechError, Recognition

public interface Recognizer
    extends j
{
    public static final class EndOfSpeechDetection extends RecognizerConstants.EndOfSpeechDetection
    {

        public EndOfSpeechDetection()
        {
        }
    }

    public static interface Listener
    {

        public abstract void onError(Recognizer recognizer, SpeechError speecherror);

        public abstract void onRecordingBegin(Recognizer recognizer);

        public abstract void onRecordingDone(Recognizer recognizer);

        public abstract void onResults(Recognizer recognizer, Recognition recognition);
    }

    public static final class PromptType extends RecognizerConstants.PromptType
    {

        public PromptType()
        {
        }
    }

    public static final class RecognizerType extends RecognizerConstants.RecognizerType
    {

        public RecognizerType()
        {
        }
    }


    public abstract void cancel();

    public abstract float getAudioLevel();

    public abstract void setListener(Listener listener);

    public abstract void setPrompt(int i, Prompt prompt);

    public abstract void start();

    public abstract void stopRecording();
}
