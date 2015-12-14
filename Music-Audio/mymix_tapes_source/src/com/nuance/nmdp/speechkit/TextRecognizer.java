// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            Prompt, SpeechError, GenericRecognition

public interface TextRecognizer
{
    public static interface Listener
    {

        public abstract void onError(TextRecognizer textrecognizer, SpeechError speecherror);

        public abstract void onResults(TextRecognizer textrecognizer, GenericRecognition genericrecognition);
    }


    public abstract void cancel();

    public abstract void setListener(Listener listener);

    public abstract void setPrompt(int i, Prompt prompt);

    public abstract void start();
}
