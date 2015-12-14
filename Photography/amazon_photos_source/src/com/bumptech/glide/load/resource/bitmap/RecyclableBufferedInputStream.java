// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream extends FilterInputStream
{
    public static class InvalidMarkException extends RuntimeException
    {

        public InvalidMarkException(String s)
        {
            super(s);
        }
    }


    private volatile byte buf[];
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;

    public RecyclableBufferedInputStream(InputStream inputstream, byte abyte0[])
    {
        super(inputstream);
        markpos = -1;
        if (abyte0 == null || abyte0.length == 0)
        {
            throw new IllegalArgumentException("buffer is null or empty");
        } else
        {
            buf = abyte0;
            return;
        }
    }

    private int fillbuf(InputStream inputstream, byte abyte0[])
        throws IOException
    {
        if (markpos == -1 || pos - markpos >= marklimit)
        {
            int i = inputstream.read(abyte0);
            if (i > 0)
            {
                markpos = -1;
                pos = 0;
                count = i;
            }
            return i;
        }
        byte abyte1[];
        int k;
        int i1;
        if (markpos == 0 && marklimit > abyte0.length && count == abyte0.length)
        {
            int l = abyte0.length * 2;
            int j = l;
            if (l > marklimit)
            {
                j = marklimit;
            }
            if (Log.isLoggable("BufferedIs", 3))
            {
                Log.d("BufferedIs", (new StringBuilder()).append("allocate buffer of length: ").append(j).toString());
            }
            abyte1 = new byte[j];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
            buf = abyte1;
        } else
        {
            abyte1 = abyte0;
            if (markpos > 0)
            {
                System.arraycopy(abyte0, markpos, abyte0, 0, abyte0.length - markpos);
                abyte1 = abyte0;
            }
        }
        pos = pos - markpos;
        markpos = 0;
        count = 0;
        i1 = inputstream.read(abyte1, pos, abyte1.length - pos);
        if (i1 <= 0)
        {
            k = pos;
        } else
        {
            k = pos + i1;
        }
        count = k;
        return i1;
    }

    private static IOException streamClosed()
        throws IOException
    {
        throw new IOException("BufferedInputStream is closed");
    }

    public int available()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = in;
        if (buf != null && obj != null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        throw streamClosed();
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        int i;
        int j;
        int k;
        i = count;
        j = pos;
        k = ((InputStream) (obj)).available();
        this;
        JVM INSTR monitorexit ;
        return (i - j) + k;
    }

    public void close()
        throws IOException
    {
        buf = null;
        InputStream inputstream = in;
        in = null;
        if (inputstream != null)
        {
            inputstream.close();
        }
    }

    public void fixMarkLimit()
    {
        this;
        JVM INSTR monitorenter ;
        marklimit = buf.length;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void mark(int i)
    {
        this;
        JVM INSTR monitorenter ;
        marklimit = Math.max(marklimit, i);
        markpos = pos;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean markSupported()
    {
        return true;
    }

    public int read()
        throws IOException
    {
        int i = -1;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        byte abyte1[];
        abyte1 = buf;
        obj = in;
        if (abyte1 != null && obj != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        throw streamClosed();
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (pos < count) goto _L2; else goto _L1
_L1:
        int j = fillbuf(((InputStream) (obj)), abyte1);
        if (j != -1) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        byte abyte0[] = abyte1;
        if (abyte1 == buf)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        abyte1 = buf;
        abyte0 = abyte1;
        if (abyte1 != null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        throw streamClosed();
        if (count - pos <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = pos;
        pos = i + 1;
        i = abyte0[i];
        i &= 0xff;
        if (true) goto _L3; else goto _L4
_L4:
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        byte byte0 = -1;
        this;
        JVM INSTR monitorenter ;
        byte abyte2[] = buf;
        if (abyte2 != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        throw streamClosed();
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        if (j != 0) goto _L2; else goto _L1
_L1:
        i = 0;
_L21:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        InputStream inputstream = in;
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        throw streamClosed();
        if (pos >= count) goto _L4; else goto _L3
_L3:
        if (count - pos < j) goto _L6; else goto _L5
_L5:
        int k = j;
_L10:
        System.arraycopy(abyte2, pos, abyte0, i, k);
        pos = pos + k;
        if (k == j) goto _L8; else goto _L7
_L7:
        if (inputstream.available() != 0) goto _L9; else goto _L8
_L6:
        k = count - pos;
          goto _L10
_L17:
        if (markpos != -1 || k < abyte2.length) goto _L12; else goto _L11
_L11:
        int i1 = inputstream.read(abyte0, i, k);
        byte abyte1[];
        int l;
        abyte1 = abyte2;
        l = i1;
        if (i1 == -1)
        {
            i = byte0;
            if (k != j)
            {
                i = j - k;
            }
            continue; /* Loop/switch isn't completed */
        }
          goto _L13
_L12:
        if (fillbuf(inputstream, abyte2) == -1)
        {
            i = byte0;
            if (k != j)
            {
                i = j - k;
            }
            continue; /* Loop/switch isn't completed */
        }
        abyte1 = abyte2;
        if (abyte2 == buf)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        abyte2 = buf;
        abyte1 = abyte2;
        if (abyte2 != null)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        throw streamClosed();
        if (count - pos < k) goto _L15; else goto _L14
_L14:
        l = k;
_L16:
        System.arraycopy(abyte1, pos, abyte0, i, l);
        pos = pos + l;
          goto _L13
_L15:
        l = count - pos;
          goto _L16
_L19:
        i1 = inputstream.available();
        if (i1 == 0)
        {
            i = j - k;
            continue; /* Loop/switch isn't completed */
        }
        i += l;
        abyte2 = abyte1;
          goto _L17
_L8:
        i = k;
        continue; /* Loop/switch isn't completed */
_L9:
        i += k;
        k = j - k;
          goto _L17
_L4:
        k = j;
          goto _L17
_L13:
        k -= l;
        if (k != 0) goto _L19; else goto _L18
_L18:
        i = j;
        if (true) goto _L21; else goto _L20
_L20:
    }

    public void reset()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (buf == null)
        {
            throw new IOException("Stream is closed");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (-1 == markpos)
        {
            throw new InvalidMarkException("Mark has been invalidated");
        }
        pos = markpos;
        this;
        JVM INSTR monitorexit ;
    }

    public long skip(long l)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        InputStream inputstream;
        obj = buf;
        inputstream = in;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        throw streamClosed();
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (l >= 1L) goto _L2; else goto _L1
_L1:
        l = 0L;
_L4:
        this;
        JVM INSTR monitorexit ;
        return l;
_L2:
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        throw streamClosed();
        if ((long)(count - pos) >= l)
        {
            pos = (int)((long)pos + l);
            continue; /* Loop/switch isn't completed */
        }
        long l1;
        l1 = count - pos;
        pos = count;
        if (markpos == -1 || l > (long)marklimit)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        if (fillbuf(inputstream, ((byte []) (obj))) == -1)
        {
            l = l1;
            continue; /* Loop/switch isn't completed */
        }
        if ((long)(count - pos) >= l - l1)
        {
            pos = (int)((long)pos + (l - l1));
            continue; /* Loop/switch isn't completed */
        }
        long l2;
        l = count;
        l2 = pos;
        pos = count;
        l = (l + l1) - l2;
        continue; /* Loop/switch isn't completed */
        l = inputstream.skip(l - l1);
        l = l1 + l;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
