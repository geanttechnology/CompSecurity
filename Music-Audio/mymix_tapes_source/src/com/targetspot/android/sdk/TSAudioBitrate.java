// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk;


public final class TSAudioBitrate extends Enum
{

    private static final TSAudioBitrate $VALUES[];
    public static final TSAudioBitrate TSAudioBitrate16kbps;
    public static final TSAudioBitrate TSAudioBitrate32kbps;
    public static final TSAudioBitrate TSAudioBitrate64kbps;
    public static final TSAudioBitrate TSAudioBitrateDefault;
    private final int audioBitrate;

    private TSAudioBitrate(String s, int i, int j)
    {
        super(s, i);
        audioBitrate = j;
    }

    public static TSAudioBitrate valueOf(String s)
    {
        return (TSAudioBitrate)Enum.valueOf(com/targetspot/android/sdk/TSAudioBitrate, s);
    }

    public static TSAudioBitrate[] values()
    {
        return (TSAudioBitrate[])$VALUES.clone();
    }

    public int getAudioBitrate()
    {
        return audioBitrate;
    }

    static 
    {
        TSAudioBitrateDefault = new TSAudioBitrate("TSAudioBitrateDefault", 0, 0);
        TSAudioBitrate16kbps = new TSAudioBitrate("TSAudioBitrate16kbps", 1, 16);
        TSAudioBitrate32kbps = new TSAudioBitrate("TSAudioBitrate32kbps", 2, 32);
        TSAudioBitrate64kbps = new TSAudioBitrate("TSAudioBitrate64kbps", 3, 64);
        $VALUES = (new TSAudioBitrate[] {
            TSAudioBitrateDefault, TSAudioBitrate16kbps, TSAudioBitrate32kbps, TSAudioBitrate64kbps
        });
    }
}
