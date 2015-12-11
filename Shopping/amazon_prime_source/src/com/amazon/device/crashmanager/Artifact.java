// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class Artifact
    implements Closeable
{

    private String mCrashDescriptor;
    private final long mCreationTimeUTCMillis;
    private final InputStream mInputStream;
    private final String mTag;

    public Artifact(String s, InputStream inputstream, long l)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Artifact tag cannot be null");
        }
        if (inputstream == null)
        {
            throw new IllegalArgumentException("Artifact InputSteam cannot be null");
        }
        if (l < 0L)
        {
            throw new IllegalArgumentException("Creation Time cannot be negative");
        } else
        {
            mTag = s;
            mInputStream = inputstream;
            mCreationTimeUTCMillis = l;
            return;
        }
    }

    public void close()
        throws IOException
    {
        if (mInputStream != null)
        {
            mInputStream.close();
        }
    }

    public String getCrashDescriptor()
    {
        return mCrashDescriptor;
    }

    public long getCreationTimeUTCMillis()
    {
        return mCreationTimeUTCMillis;
    }

    public InputStream getInputStream()
    {
        return mInputStream;
    }

    public String getTag()
    {
        return mTag;
    }

    public void setCrashDescriptor(String s)
    {
        mCrashDescriptor = s;
    }
}
