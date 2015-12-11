// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            BinaryDecoder

private static class <init> extends <init>
{

    private InputStream in;
    protected boolean isEof;

    public void close()
        throws IOException
    {
        in.close();
    }

    public boolean isEof()
    {
        return isEof;
    }

    public int read()
        throws IOException
    {
        if (ba.ba() - ba.ba() == 0)
        {
            return in.read();
        } else
        {
            int i = ba.ba();
            byte byte0 = ba.ba()[i];
            ba.ba(i + 1);
            return byte0 & 0xff;
        }
    }

    protected void readRaw(byte abyte0[], int i, int j)
        throws IOException
    {
        while (j > 0) 
        {
            int k = in.read(abyte0, i, j);
            if (k < 0)
            {
                isEof = true;
                throw new EOFException();
            }
            j -= k;
            i += k;
        }
    }

    protected void skipSourceBytes(long l)
        throws IOException
    {
        boolean flag = false;
        while (l > 0L) 
        {
            long l1 = in.skip(l);
            if (l1 > 0L)
            {
                l -= l1;
            } else
            if (l1 == 0L)
            {
                if (flag)
                {
                    isEof = true;
                    throw new EOFException();
                }
                flag = true;
            } else
            {
                isEof = true;
                throw new EOFException();
            }
        }
    }

    protected int tryReadRaw(byte abyte0[], int i, int j)
        throws IOException
    {
        int k = j;
_L2:
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        int l = in.read(abyte0, i, k);
        if (l >= 0)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        try
        {
            isEof = true;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            isEof = true;
        }
        return j - k;
        k -= l;
        i += l;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected long trySkipBytes(long l)
        throws IOException
    {
        boolean flag;
        long l1;
        l1 = l;
        flag = false;
_L2:
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        long l2 = in.skip(l);
        if (l2 > 0L)
        {
            l1 -= l2;
            continue; /* Loop/switch isn't completed */
        }
        if (l2 == 0L)
        {
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            try
            {
                isEof = true;
            }
            catch (EOFException eofexception)
            {
                isEof = true;
            }
            break MISSING_BLOCK_LABEL_74;
        }
        isEof = true;
        return l - l1;
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private (InputStream inputstream)
    {
        isEof = false;
        in = inputstream;
    }

    in(InputStream inputstream, in in1)
    {
        this(inputstream);
    }
}
