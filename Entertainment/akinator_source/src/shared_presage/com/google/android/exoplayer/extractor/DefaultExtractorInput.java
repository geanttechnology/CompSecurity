// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor;

import java.io.EOFException;
import java.util.Arrays;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor:
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

    public final void advancePeekPosition(int i)
    {
        ensureSpaceForPeek(i);
        int l = i - Math.min(peekBufferLength - peekBufferPosition, i);
        int j = peekBufferLength;
        for (int k = l; k > 0;)
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            int i1 = dataSource.read(peekBuffer, j, k);
            if (i1 == -1)
            {
                throw new EOFException();
            }
            k -= i1;
            j += i1;
        }

        peekBufferPosition = peekBufferPosition + i;
        peekBufferLength = peekBufferLength + l;
    }

    public final long getLength()
    {
        return streamLength;
    }

    public final long getPosition()
    {
        return position;
    }

    public final void peekFully(byte abyte0[], int i, int j)
    {
        ensureSpaceForPeek(j);
        int l = Math.min(peekBufferLength - peekBufferPosition, j);
        System.arraycopy(peekBuffer, peekBufferPosition, abyte0, i, l);
        int j1 = j - l;
        int k = peekBufferLength;
        i += l;
        for (int i1 = j1; i1 > 0;)
        {
            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
            int k1 = dataSource.read(peekBuffer, k, i1);
            if (k1 == -1)
            {
                throw new EOFException();
            }
            System.arraycopy(peekBuffer, k, abyte0, i, k1);
            i1 -= k1;
            k += k1;
            i += k1;
        }

        peekBufferPosition = peekBufferPosition + j;
        peekBufferLength = peekBufferLength + j1;
    }

    public final int read(byte abyte0[], int i, int j)
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

    public final void readFully(byte abyte0[], int i, int j)
    {
        readFully(abyte0, i, j, false);
    }

    public final boolean readFully(byte abyte0[], int i, int j, boolean flag)
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

    public final void resetPeekPosition()
    {
        peekBufferPosition = 0;
    }

    public final void skipFully(int i)
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
