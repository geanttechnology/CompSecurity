// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.audio;

import com.google.common.base.Preconditions;

public final class AudioTimeouts
{

    private static final int DEFAULT_MAX_SPEECH_TIMEOUT = 5000;
    private static final int DEFAULT_NO_SPEECH_TIMEOUT = 5000;
    private final int mMaxSpeechTimeout;
    private final int mNoSpeechTimeout;

    public AudioTimeouts()
    {
        this(5000, 5000);
    }

    public AudioTimeouts(int i, int j)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "No input timeout must be greater than 0");
        if (j > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Max speech timeout must be greater than 0");
        mNoSpeechTimeout = i;
        mMaxSpeechTimeout = j;
    }

    public int getMaxSpeechTimeout()
    {
        return mMaxSpeechTimeout;
    }

    public int getNoSpeechTimeout()
    {
        return mNoSpeechTimeout;
    }
}
