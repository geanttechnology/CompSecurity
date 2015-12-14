// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            j, Prompt, SpeechError, GenericRecognition

public interface NluRecognizer
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

        public abstract void onError(NluRecognizer nlurecognizer, SpeechError speecherror);

        public abstract void onRecordingBegin(NluRecognizer nlurecognizer);

        public abstract void onRecordingDone(NluRecognizer nlurecognizer);

        public abstract void onResults(NluRecognizer nlurecognizer, GenericRecognition genericrecognition);
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
