// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;


public interface EndpointerListener
{

    public abstract void onEndOfSpeech();

    public abstract void onMusicDetected();

    public abstract void onNoSpeechDetected();

    public abstract void onStartOfSpeech(long l);
}
