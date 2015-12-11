// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.audio;


public interface AudioSourceListener
{

    public abstract void onBeginningOfSpeech();

    public abstract void onBufferReceived(byte abyte0[]);

    public abstract void onMaxSpeechTimeout();

    public abstract void onNoSpeechTimeout();

    public abstract void onReadyForSpeech();

    public abstract void onRmsChanged(float f);

    public abstract void onSilenceDetected();
}
