// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import myobfuscated.s.j;

public final class RecyclableBufferedInputStream extends FilterInputStream
{

    private volatile byte a[];
    private int b;
    private int c;
    private int d;
    private int e;
    private final j f;

    public RecyclableBufferedInputStream(InputStream inputstream, j j1)
    {
        this(inputstream, j1, (byte)0);
    }

    private RecyclableBufferedInputStream(InputStream inputstream, j j1, byte byte0)
    {
        super(inputstream);
        d = -1;
        f = j1;
        a = j1.a(0x10000);
    }

    private int a(InputStream inputstream, byte abyte0[])
    {
        if (d == -1 || e - d >= c)
        {
            int i = inputstream.read(abyte0);
            if (i > 0)
            {
                d = -1;
                e = 0;
                b = i;
            }
            return i;
        }
        byte abyte1[];
        int l;
        int j1;
        if (d == 0 && c > abyte0.length && b == abyte0.length)
        {
            int i1 = abyte0.length * 2;
            int k = i1;
            if (i1 > c)
            {
                k = c;
            }
            abyte1 = f.a(k);
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
            a = abyte1;
            f.a(abyte0);
        } else
        {
            abyte1 = abyte0;
            if (d > 0)
            {
                System.arraycopy(abyte0, d, abyte0, 0, abyte0.length - d);
                abyte1 = abyte0;
            }
        }
        e = e - d;
        d = 0;
        b = 0;
        j1 = inputstream.read(abyte1, e, abyte1.length - e);
        if (j1 <= 0)
        {
            l = e;
        } else
        {
            l = e + j1;
        }
        b = l;
        return j1;
    }

    private static IOException c()
    {
        throw new IOException("BufferedInputStream is closed");
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        c = a.length;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final int available()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = in;
        if (a != null && obj != null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        throw c();
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        int i;
        int k;
        int l;
        i = b;
        k = e;
        l = ((InputStream) (obj)).available();
        this;
        JVM INSTR monitorexit ;
        return l + (i - k);
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            f.a(a);
            a = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void close()
    {
        if (a != null)
        {
            f.a(a);
            a = null;
        }
        InputStream inputstream = in;
        in = null;
        if (inputstream != null)
        {
            inputstream.close();
        }
    }

    public final void mark(int i)
    {
        this;
        JVM INSTR monitorenter ;
        c = Math.max(c, i);
        d = e;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean markSupported()
    {
        return true;
    }

    public final int read()
    {
        int i = -1;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        byte abyte1[];
        abyte1 = a;
        obj = in;
        if (abyte1 != null && obj != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        throw c();
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (e < b) goto _L2; else goto _L1
_L1:
        int k = a(((InputStream) (obj)), abyte1);
        if (k != -1) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        byte abyte0[] = abyte1;
        if (abyte1 == a)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        abyte1 = a;
        abyte0 = abyte1;
        if (abyte1 != null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        throw c();
        if (b - e <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = e;
        e = i + 1;
        i = abyte0[i];
        i &= 0xff;
        if (true) goto _L3; else goto _L4
_L4:
    }

    public final int read(byte abyte0[], int i, int k)
    {
        this;
        JVM INSTR monitorenter ;
        byte abyte2[] = a;
        if (abyte2 != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        throw c();
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        if (k != 0) goto _L2; else goto _L1
_L1:
        i = 0;
_L13:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        InputStream inputstream = in;
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        throw c();
        if (e >= b)
        {
            break MISSING_BLOCK_LABEL_361;
        }
        if (b - e < k) goto _L4; else goto _L3
_L3:
        int l = k;
_L8:
        System.arraycopy(abyte2, e, abyte0, i, l);
        e = e + l;
        if (l == k) goto _L6; else goto _L5
_L5:
        if (inputstream.available() != 0) goto _L7; else goto _L6
_L4:
        l = b - e;
          goto _L8
_L18:
        if (d != -1 || l < abyte2.length) goto _L10; else goto _L9
_L9:
        int i1;
        i = inputstream.read(abyte0, i1, l);
        byte abyte1[];
        int j1;
        j1 = i;
        abyte1 = abyte2;
        if (i != -1) goto _L12; else goto _L11
_L11:
        if (l == k)
        {
            i = -1;
        } else
        {
            i = k - l;
        }
          goto _L13
_L10:
        if (a(inputstream, abyte2) != -1)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        if (l == k)
        {
            i = -1;
        } else
        {
            i = k - l;
        }
          goto _L13
        abyte1 = abyte2;
        if (abyte2 == a)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        abyte2 = a;
        abyte1 = abyte2;
        if (abyte2 != null)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        throw c();
        if (b - e < l) goto _L15; else goto _L14
_L14:
        i = l;
_L17:
        System.arraycopy(abyte1, e, abyte0, i1, i);
        e = e + i;
        j1 = i;
_L12:
        l -= j1;
        i = k;
        if (l == 0) goto _L13; else goto _L16
_L16:
        if (inputstream.available() != 0)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        i = k - l;
          goto _L13
_L15:
        i = b;
        j1 = e;
        i -= j1;
          goto _L17
        i1 += j1;
        abyte2 = abyte1;
          goto _L18
_L6:
        i = l;
          goto _L13
_L7:
        i1 = i + l;
        l = k - l;
          goto _L18
        l = k;
        i1 = i;
          goto _L18
    }

    public final void reset()
    {
        this;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            throw new IOException("Stream is closed");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (-1 == d)
        {
            throw new InvalidMarkException((new StringBuilder("Mark has been invalidated, pos: ")).append(e).append(" markLimit: ").append(c).toString());
        }
        e = d;
        this;
        JVM INSTR monitorexit ;
    }

    public final long skip(long l)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        InputStream inputstream;
        obj = a;
        inputstream = in;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        throw c();
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
        throw c();
        if ((long)(b - e) >= l)
        {
            e = (int)((long)e + l);
            continue; /* Loop/switch isn't completed */
        }
        long l1;
        l1 = b - e;
        e = b;
        if (d == -1 || l > (long)c)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        if (a(inputstream, ((byte []) (obj))) == -1)
        {
            l = l1;
            continue; /* Loop/switch isn't completed */
        }
        if ((long)(b - e) >= l - l1)
        {
            e = (int)((l - l1) + (long)e);
            continue; /* Loop/switch isn't completed */
        }
        l = (l1 + (long)b) - (long)e;
        e = b;
        continue; /* Loop/switch isn't completed */
        l = inputstream.skip(l - l1);
        l = l1 + l;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private class InvalidMarkException extends IOException
    {

        private static final long serialVersionUID = 0xc3cafb6c37664863L;

        public InvalidMarkException(String s)
        {
            super(s);
        }
    }

}
