// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import android.util.Log;
import dax;

public class SpeechLevelGenerator
{

    private static final float AUDIO_METER_MAX_DB = 10F;
    private static final float AUDIO_METER_MIN_DB = -2F;
    private static final String TAG = "SpeechLevelGenerator";
    private boolean mLowAudioLevelsLogged;
    private float mNoiseLevel;
    private final dax mSpeechLevelSource;

    public SpeechLevelGenerator(dax dax1)
    {
        mSpeechLevelSource = dax1;
        mNoiseLevel = 75F;
    }

    private static float calculateRms(byte abyte0[], int i, int j)
    {
        long l1 = 0L;
        int k = j / 2;
        j = i + j;
        long l2 = 0L;
        for (; j >= i + 2; j -= 2)
        {
            int l = (short)((abyte0[j - 1] << 8) + (abyte0[j - 2] & 0xff));
            l2 += l;
            l1 += l * l;
        }

        return (float)Math.sqrt((l1 * (long)k - l2 * l2) / (long)(k * k));
    }

    public static int convertRmsDbToVolume(float f)
    {
        int i = (int)(((Math.min(Math.max(f, -2F), 10F) + 2.0F) * 100F) / 12F);
        if (i < 30)
        {
            return 0;
        } else
        {
            return (i / 10) * 10;
        }
    }

    public static float convertVolumeToRmsDb(int i)
    {
        return 12F * ((float)i / 100F) - 2.0F;
    }

    public void update(byte abyte0[], int i, int j)
    {
        float f2 = calculateRms(abyte0, i, j);
        if (!mLowAudioLevelsLogged && f2 == 0.0F)
        {
            Log.w("SpeechLevelGenerator", "Really low audio levels detected. The audio input may have issues.");
            mLowAudioLevelsLogged = true;
        }
        float f;
        float f1;
        if (mNoiseLevel < f2)
        {
            mNoiseLevel = 0.999F * mNoiseLevel + 0.001F * f2;
        } else
        {
            mNoiseLevel = 0.95F * mNoiseLevel + 0.05F * f2;
        }
        f1 = -120F;
        f = f1;
        if ((double)mNoiseLevel > 0.0D)
        {
            f = f1;
            if ((double)(f2 / mNoiseLevel) > 9.9999999999999995E-07D)
            {
                f = 10F * (float)Math.log10(f2 / mNoiseLevel);
            }
        }
        mSpeechLevelSource.a(convertRmsDbToVolume(f));
    }
}
