// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.android.speech.audio:
//            Tee

class mStreamId extends InputStream
{

    private Tee mSharedStream;
    private final int mStreamId;

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (mSharedStream != null)
        {
            mSharedStream.remove(mStreamId);
            mSharedStream = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int read()
    {
        throw new UnsupportedOperationException("Find some other app to be inefficient in.");
    }

    public int read(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (mSharedStream == null)
        {
            throw new IOException("Secondary Tee stream closed.");
        }
        break MISSING_BLOCK_LABEL_24;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        i = mSharedStream.readSecondary(mStreamId, abyte0, i, j);
        j = i;
        if (i == 0)
        {
            j = -1;
        }
        this;
        JVM INSTR monitorexit ;
        return j;
    }

    A(Tee tee, int i)
    {
        mSharedStream = tee;
        mStreamId = i;
    }
}
