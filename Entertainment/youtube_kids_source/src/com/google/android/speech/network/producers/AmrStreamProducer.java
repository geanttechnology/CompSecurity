// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.network.producers;

import a;
import com.google.android.speech.audio.AudioUtils;
import dah;
import dat;
import emm;
import emp;
import exe;
import java.io.IOException;
import java.io.InputStream;

public class AmrStreamProducer
    implements dah
{

    private final InputStream mAmrStream;
    private final byte mBuffer[];
    private boolean mComplete;
    private final dat mThreadCheck;

    public AmrStreamProducer(InputStream inputstream, int i, int j)
    {
        this(AudioUtils.getEncodingInputStream(inputstream, i), new byte[j]);
    }

    AmrStreamProducer(InputStream inputstream, byte abyte0[])
    {
        mAmrStream = inputstream;
        mBuffer = abyte0;
        mThreadCheck = a.H();
    }

    private void closeAndMarkComplete()
    {
        if (!mComplete)
        {
            mComplete = true;
            emp.a(mAmrStream);
        }
    }

    public void close()
    {
        dat dat = mThreadCheck;
        closeAndMarkComplete();
    }

    public exe next()
    {
        dat dat = mThreadCheck;
        if (mComplete)
        {
            return null;
        }
        exe exe;
        int i;
        try
        {
            i = emm.a(mAmrStream, mBuffer, 0, mBuffer.length);
        }
        catch (IOException ioexception)
        {
            closeAndMarkComplete();
            throw ioexception;
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        return a.c(mBuffer, i);
        closeAndMarkComplete();
        exe = a.D();
        return exe;
    }
}
