// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.speech.tts.UtteranceProgressListener;

public interface TalkDelegate
{

    public abstract void announceTitle();

    public abstract void cancelAllMessages();

    public abstract void ignoreAnnounceTitleOnce();

    public abstract void onDestroy();

    public abstract void setTitle(String s);

    public abstract void setUtteranceListener(UtteranceProgressListener utteranceprogresslistener);

    public abstract void speak(int i);

    public abstract void speak(String s);

    public abstract void speakManagedMessage(int i);

    public abstract void speakThenListen(String s);

    public abstract void stopSpeaking();
}
