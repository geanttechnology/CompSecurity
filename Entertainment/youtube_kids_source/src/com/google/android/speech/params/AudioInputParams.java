// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.params;

import android.net.Uri;

public class AudioInputParams
{

    private final int mEncoding;
    private final boolean mNoiseSuppressionEnabled;
    private final boolean mPlayBeepEnabled;
    private final Uri mRecordedAudioUri;
    private final boolean mReportSoundLevels;
    private final boolean mRequestAudioFocus;
    private final int mSamplingRateHz;
    private final long mStreamRewindTimeUsec;
    private final boolean mUsePreemptibleAudioSource;

    private AudioInputParams(boolean flag, boolean flag1, boolean flag2, int i, int j, long l, 
            Uri uri, boolean flag3, boolean flag4)
    {
        mNoiseSuppressionEnabled = flag;
        mPlayBeepEnabled = flag1;
        mReportSoundLevels = flag2;
        mEncoding = i;
        mSamplingRateHz = j;
        mStreamRewindTimeUsec = l;
        mRecordedAudioUri = uri;
        mUsePreemptibleAudioSource = flag3;
        mRequestAudioFocus = flag4;
    }

    AudioInputParams(boolean flag, boolean flag1, boolean flag2, int i, int j, long l, 
            Uri uri, boolean flag3, boolean flag4, _cls1 _pcls1)
    {
        this(flag, flag1, flag2, i, j, l, uri, flag3, flag4);
    }

    public int getEncoding()
    {
        return mEncoding;
    }

    public Uri getRecordedAudioUri()
    {
        return mRecordedAudioUri;
    }

    public int getSamplingRate()
    {
        return mSamplingRateHz;
    }

    public long getStreamRewindTime()
    {
        return mStreamRewindTimeUsec;
    }

    public boolean hasStreamRewindTime()
    {
        return mStreamRewindTimeUsec >= 0L;
    }

    public boolean isNoiseSuppressionEnabled()
    {
        return mNoiseSuppressionEnabled;
    }

    public boolean isPlayBeepEnabled()
    {
        return mPlayBeepEnabled;
    }

    public boolean shouldReportSoundLevels()
    {
        return mReportSoundLevels;
    }

    public boolean shouldRequestAudioFocus()
    {
        return mRequestAudioFocus;
    }

    public boolean usePreemptibleAudioSource()
    {
        return mUsePreemptibleAudioSource;
    }
}
