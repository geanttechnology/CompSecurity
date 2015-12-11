// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import java.io.InputStream;

// Referenced classes of package com.google.android.speech.audio:
//            Tee

class mSharedStream extends InputStream
{

    private final Tee mSharedStream;

    public void close()
    {
        mSharedStream.remove(0);
        mSharedStream.close();
    }

    public int read()
    {
        throw new UnsupportedOperationException("Find some other app to be inefficient in.");
    }

    public int read(byte abyte0[], int i, int j)
    {
        j = mSharedStream.readLeader(abyte0, i, j);
        i = j;
        if (j == 0)
        {
            i = -1;
        }
        return i;
    }

    (Tee tee)
    {
        mSharedStream = tee;
    }
}
