// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk;


public final class TSAudioFormat extends Enum
{

    private static final TSAudioFormat $VALUES[];
    public static final TSAudioFormat TSAudioAAC;
    public static final TSAudioFormat TSAudioDefault;
    public static final TSAudioFormat TSAudioMP3;
    public static final TSAudioFormat TSAudioOGG;
    private final int audioFormat;

    private TSAudioFormat(String s, int i, int j)
    {
        super(s, i);
        audioFormat = j;
    }

    public static TSAudioFormat valueOf(String s)
    {
        return (TSAudioFormat)Enum.valueOf(com/targetspot/android/sdk/TSAudioFormat, s);
    }

    public static TSAudioFormat[] values()
    {
        return (TSAudioFormat[])$VALUES.clone();
    }

    public int getAudioType()
    {
        return audioFormat;
    }

    public String toString()
    {
        if (audioFormat == 1)
        {
            return "mp3";
        }
        if (audioFormat == 2)
        {
            return "aac";
        }
        if (audioFormat == 3)
        {
            return "ogg";
        } else
        {
            return "default";
        }
    }

    static 
    {
        TSAudioDefault = new TSAudioFormat("TSAudioDefault", 0, 0);
        TSAudioMP3 = new TSAudioFormat("TSAudioMP3", 1, 1);
        TSAudioAAC = new TSAudioFormat("TSAudioAAC", 2, 2);
        TSAudioOGG = new TSAudioFormat("TSAudioOGG", 3, 3);
        $VALUES = (new TSAudioFormat[] {
            TSAudioDefault, TSAudioMP3, TSAudioAAC, TSAudioOGG
        });
    }
}
