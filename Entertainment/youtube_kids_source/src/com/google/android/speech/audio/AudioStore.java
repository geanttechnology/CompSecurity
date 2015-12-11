// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;


public interface AudioStore
{

    public abstract AudioRecording getAudio(String s);

    public abstract AudioRecording getLastAudio();

    public abstract boolean hasAudio(String s);

    public abstract void put(String s, AudioRecording audiorecording);
}
