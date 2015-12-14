// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.upstream.DataSource;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.google.android.exoplayer.extractor:
//            ExtractorInput

public final class DefaultExtractorInput
    implements ExtractorInput
{

    private static final byte SCRATCH_SPACE[] = new byte[4096];
    private final DataSource dataSource;
    private byte peekBuffer[];
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final long streamLength;

    public DefaultExtractorInput(DataSource datasource, long l, long l1)
    {
        dataSource = datasource;
        position = l;
        streamLength = l1;
        peekBuffer = new byte[8192];
    }

    private void ensureSpaceForPeek(int i)
    {
        i = peekBufferPosition + i;
        if (i > peekBuffer.length)
        {
            peekBuffer = Arrays.copyOf(peekBuffer, Math.max(peekBuffer.length * 2, i));
        }
    }

    private void updatePeekBuffer(int i)
    {
        peekBufferLength = peekBufferLength - i;
        peekBufferPosition = 0;
        System.arraycopy(peekBuffer, i, peekBuffer, 0, peekBufferLength);
    }

    public void advancePeekPosition(int i)
        throws IOException, InterruptedException
    {
        ensureSpaceForPeek(i);
        int l = i - Math.min(peekBufferLength - peekBufferPosition, i);
        int k = l;
        int i1;
        for (int j = peekBufferLength; k > 0; j += i1)
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            i1 = dataSource.read(peekBuffer, j, k);
            if (i1 == -1)
            {
                throw new EOFException();
            }
            k -= i1;
        }

        peekBufferPosition = peekBufferPosition + i;
        peekBufferLength = peekBufferLength + l;
    }

    public long getLength()
    {
        return streamLength;
    }

    public long getPosition()
    {
        return position;
    }

    public void peekFully(byte abyte0[], int i, int j)
        throws IOException, InterruptedException
    {
        ensureSpaceForPeek(j);
        int k = Math.min(peekBufferLength - peekBufferPosition, j);
        System.arraycopy(peekBuffer, peekBufferPosition, abyte0, i, k);
        i += k;
        int i1 = j - k;
        int l = i1;
        k = peekBufferLength;
        while (l > 0) 
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            int j1 = dataSource.read(peekBuffer, k, l);
            if (j1 == -1)
            {
                throw new EOFException();
            }
            System.arraycopy(peekBuffer, k, abyte0, i, j1);
            l -= j1;
            k += j1;
            i += j1;
        }
        peekBufferPosition = peekBufferPosition + j;
        peekBufferLength = peekBufferLength + i1;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException, InterruptedException
    {
        boolean flag = false;
        if (Thread.interrupted())
        {
            throw new InterruptedException();
        }
        int k = Math.min(peekBufferLength, j);
        System.arraycopy(peekBuffer, 0, abyte0, i, k);
        int l = j - k;
        j = ((flag) ? 1 : 0);
        if (l != 0)
        {
            j = dataSource.read(abyte0, i + k, l);
        }
        if (j == -1)
        {
            return -1;
        } else
        {
            updatePeekBuffer(k);
            i = j + k;
            position = position + (long)i;
            return i;
        }
    }

    public void readFully(byte abyte0[], int i, int j)
        throws IOException, InterruptedException
    {
        readFully(abyte0, i, j, false);
    }

    public boolean readFully(byte abyte0[], int i, int j, boolean flag)
        throws IOException, InterruptedException
    {
        int l = Math.min(peekBufferLength, j);
        System.arraycopy(peekBuffer, 0, abyte0, i, l);
        int k = i + l;
        int i1;
        for (i = j - l; i > 0; i -= i1)
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            i1 = dataSource.read(abyte0, k, i);
            if (i1 == -1)
            {
                if (flag && i == j)
                {
                    return false;
                } else
                {
                    throw new EOFException();
                }
            }
            k += i1;
        }

        updatePeekBuffer(l);
        position = position + (long)j;
        return true;
    }

    public void resetPeekPosition()
    {
        peekBufferPosition = 0;
    }

    public void skipFully(int i)
        throws IOException, InterruptedException
    {
        int k = Math.min(peekBufferLength, i);
        int l;
        for (int j = i - k; j > 0; j -= l)
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            l = dataSource.read(SCRATCH_SPACE, 0, Math.min(SCRATCH_SPACE.length, j));
            if (l == -1)
            {
                throw new EOFException();
            }
        }

        updatePeekBuffer(k);
        position = position + (long)i;
    }

}
