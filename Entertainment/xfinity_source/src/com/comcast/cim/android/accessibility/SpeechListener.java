// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;


public interface SpeechListener
{

    public abstract boolean onSpeechResponseCancel();

    public abstract boolean onSpeechResponseClear();

    public abstract boolean onSpeechResponseClose();

    public abstract boolean onSpeechResponseFeedback(String s);

    public abstract boolean onSpeechResponseIgnoreReentry();

    public abstract boolean onSpeechResponseLess();

    public abstract boolean onSpeechResponseMore();

    public abstract boolean onSpeechResponseOpen(String as[]);

    public abstract boolean onSpeechResponsePause();

    public abstract boolean onSpeechResponsePlay(String as[]);

    public abstract boolean onSpeechResponseRepeat();

    public abstract boolean onSpeechResponseSearch(String as[]);

    public abstract boolean onSpeechResponseSeek(String as[]);
}
