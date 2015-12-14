// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            SpeechError

public interface Vocalizer
{
    public static interface Listener
    {

        public abstract void onSpeakingBegin(Vocalizer vocalizer, String s, Object obj);

        public abstract void onSpeakingDone(Vocalizer vocalizer, String s, SpeechError speecherror, Object obj);
    }


    public abstract void cancel();

    public abstract void setLanguage(String s);

    public abstract void setListener(Listener listener);

    public abstract void setVoice(String s);

    public abstract void speakMarkupString(String s, Object obj);

    public abstract void speakString(String s, Object obj);
}
