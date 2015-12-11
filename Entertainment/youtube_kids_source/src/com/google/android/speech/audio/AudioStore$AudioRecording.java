// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import f;

public class mAudio
{

    private final byte mAudio[];
    private final int mSampleRate;

    public byte[] getAudio()
    {
        return mAudio;
    }

    public int getSampleRate()
    {
        return mSampleRate;
    }

    public (int i, byte abyte0[])
    {
        boolean flag;
        if (abyte0 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag);
        mSampleRate = i;
        mAudio = abyte0;
    }
}
