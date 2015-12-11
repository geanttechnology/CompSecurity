// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.params;

import android.net.Uri;

// Referenced classes of package com.google.android.speech.params:
//            AudioInputParams

public class mStreamRewindTimeUsec
{

    private int mEncoding;
    private boolean mNoiseSuppressionEnabled;
    private boolean mPlayBeepEnabled;
    private Uri mRecordedAudioUri;
    private boolean mReportSoundLevels;
    private boolean mRequestAudioFocus;
    private int mSamplingRateHz;
    private long mStreamRewindTimeUsec;
    private boolean mUsePreemptibleAudioSource;

    public AudioInputParams build()
    {
        return new AudioInputParams(mNoiseSuppressionEnabled, mPlayBeepEnabled, mReportSoundLevels, mEncoding, mSamplingRateHz, mStreamRewindTimeUsec, mRecordedAudioUri, mUsePreemptibleAudioSource, mRequestAudioFocus, null);
    }

    public mRequestAudioFocus setEncoding(int i)
    {
        mEncoding = i;
        return this;
    }

    public mEncoding setNoiseSuppressionEnabled(boolean flag)
    {
        mNoiseSuppressionEnabled = flag;
        return this;
    }

    public mNoiseSuppressionEnabled setPlayBeepEnabled(boolean flag)
    {
        mPlayBeepEnabled = flag;
        return this;
    }

    public mPlayBeepEnabled setRecordedAudioUri(Uri uri)
    {
        mRecordedAudioUri = uri;
        return this;
    }

    public mRecordedAudioUri setReportSoundLevels(boolean flag)
    {
        mReportSoundLevels = flag;
        return this;
    }

    public mReportSoundLevels setRequestAudioFocus(boolean flag)
    {
        mRequestAudioFocus = flag;
        return this;
    }

    public mRequestAudioFocus setSamplingRate(int i)
    {
        mSamplingRateHz = i;
        return this;
    }

    public mSamplingRateHz setStreamRewindTimeUsec(long l)
    {
        mStreamRewindTimeUsec = l;
        return this;
    }

    public mStreamRewindTimeUsec setUsePreemptibleAudioSource(boolean flag)
    {
        mUsePreemptibleAudioSource = flag;
        return this;
    }

    public ()
    {
        mNoiseSuppressionEnabled = true;
        mPlayBeepEnabled = true;
        mReportSoundLevels = true;
        mUsePreemptibleAudioSource = false;
        mRequestAudioFocus = true;
        mEncoding = 3;
        mSamplingRateHz = 8000;
        mStreamRewindTimeUsec = -1L;
    }
}
