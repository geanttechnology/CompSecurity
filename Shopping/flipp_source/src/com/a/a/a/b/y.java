// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.a.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.a.a.a.b:
//            x, q, s

final class y extends InputStream
{

    static final boolean e;
    final byte a[];
    int b;
    int c;
    boolean d;
    final x f;
    private boolean g;
    private int h;

    private y(x x1)
    {
        f = x1;
        super();
        a = new byte[0x10000];
        b = -1;
        h = 0;
    }

    y(x x1, byte byte0)
    {
        this(x1);
    }

    private void a()
    {
        if (g)
        {
            throw new IOException("stream closed");
        }
        if (x.d(f) != null)
        {
            throw new IOException((new StringBuilder("stream was reset: ")).append(x.d(f)).toString());
        } else
        {
            return;
        }
    }

    static boolean a(y y1)
    {
        return y1.d;
    }

    static boolean a(y y1, boolean flag)
    {
        y1.d = flag;
        return flag;
    }

    static boolean b(y y1)
    {
        return y1.g;
    }

    public final int available()
    {
label0:
        {
            synchronized (f)
            {
                a();
                if (b != -1)
                {
                    break label0;
                }
            }
            return 0;
        }
        int i;
        int j;
        if (c <= b)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        i = c;
        j = b;
        x1;
        JVM INSTR monitorexit ;
        return i - j;
        exception;
        x1;
        JVM INSTR monitorexit ;
        throw exception;
        int k;
        i = c;
        j = a.length;
        k = b;
        x1;
        JVM INSTR monitorexit ;
        return i + (j - k);
    }

    public final void close()
    {
        synchronized (f)
        {
            g = true;
            f.notifyAll();
        }
        x.e(f);
        return;
        exception;
        x1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final int read()
    {
        return u.a(this);
    }

    public final int read(byte abyte0[], int i, int j)
    {
        x x1 = f;
        x1;
        JVM INSTR monitorenter ;
        u.a(abyte0.length, i, j);
        long l1;
        long l2;
        l2 = 0L;
        l1 = 0L;
        if (x.c(f) != 0L)
        {
            l2 = System.nanoTime() / 0xf4240L;
            l1 = x.c(f);
        }
_L7:
        if (b != -1 || d || g || x.d(f) != null) goto _L2; else goto _L1
_L3:
        throw new InterruptedIOException();
        abyte0;
        x1;
        JVM INSTR monitorexit ;
        throw abyte0;
_L1:
        if (x.c(f) == 0L)
        {
            f.wait();
            continue; /* Loop/switch isn't completed */
        }
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        f.wait(l1);
        l1 = (x.c(f) + l2) - System.nanoTime() / 0xf4240L;
        continue; /* Loop/switch isn't completed */
        try
        {
            throw new SocketTimeoutException();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[]) { }
          goto _L3
_L2:
        a();
        if (b != -1) goto _L5; else goto _L4
_L4:
        x1;
        JVM INSTR monitorexit ;
        return -1;
_L5:
        int k = 0;
        if (c > b)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        k = Math.min(j, a.length - b);
        System.arraycopy(a, b, abyte0, i, k);
        b = b + k;
        int l;
        l = k + 0;
        k = l;
        if (b != a.length)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        b = 0;
        k = l;
        l = k;
        if (k >= j)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        j = Math.min(c - b, j - k);
        System.arraycopy(a, b, abyte0, i + k, j);
        b = b + j;
        l = k + j;
        h = h + l;
        if (h >= 32768)
        {
            abyte0 = x.b(f);
            i = x.a(f);
            j = h;
            q.a.submit(new s(abyte0, "OkHttp SPDY Writer %s stream %d", new Object[] {
                ((q) (abyte0)).e, Integer.valueOf(i)
            }, i, j));
            h = 0;
        }
        if (b == c)
        {
            b = -1;
            c = 0;
        }
        x1;
        JVM INSTR monitorexit ;
        return l;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static 
    {
        boolean flag;
        if (!com/a/a/a/b/x.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
    }
}
