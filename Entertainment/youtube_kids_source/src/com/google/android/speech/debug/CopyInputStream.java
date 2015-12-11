// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.debug;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyInputStream extends FilterInputStream
{

    private static final String TAG = com/google/android/speech/debug/CopyInputStream.getSimpleName();
    private OutputStream mOut;

    public CopyInputStream(InputStream inputstream, OutputStream outputstream)
    {
        super(inputstream);
        mOut = outputstream;
    }

    public void close()
    {
        super.close();
        mOut.close();
    }

    public int read()
    {
        int i = in.read();
        if (i == -1)
        {
            mOut.close();
            return i;
        } else
        {
            mOut.write(i);
            return i;
        }
    }

    public int read(byte abyte0[])
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
    {
        j = in.read(abyte0, i, j);
        if (j == -1)
        {
            mOut.close();
            return j;
        } else
        {
            mOut.write(abyte0, i, j);
            return j;
        }
    }

}
