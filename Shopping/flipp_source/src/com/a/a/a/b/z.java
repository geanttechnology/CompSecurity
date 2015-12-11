// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.a.u;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;

// Referenced classes of package com.a.a.a.b:
//            x, q, d

final class z extends OutputStream
{

    static final boolean a;
    final x b;
    private final byte c[];
    private int d;
    private boolean e;
    private boolean f;
    private int g;

    private z(x x1)
    {
        b = x1;
        super();
        c = new byte[8192];
        d = 0;
        g = 0;
    }

    z(x x1, byte byte0)
    {
        this(x1);
    }

    static int a(z z1, int i)
    {
        i = z1.g - i;
        z1.g = i;
        return i;
    }

    private void a()
    {
        x x1 = b;
        x1;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IOException("stream closed");
        }
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        x1;
        JVM INSTR monitorexit ;
        throw exception;
        if (f)
        {
            throw new IOException("stream finished");
        }
        if (x.d(b) != null)
        {
            throw new IOException((new StringBuilder("stream was reset: ")).append(x.d(b)).toString());
        }
        x1;
        JVM INSTR monitorexit ;
    }

    private void a(int i, boolean flag)
    {
_L1:
        if (g + i < x.g(b))
        {
            break MISSING_BLOCK_LABEL_110;
        }
        b.wait();
        if (!flag)
        {
            try
            {
                if (e)
                {
                    throw new IOException("stream closed");
                }
            }
            catch (InterruptedException interruptedexception)
            {
                throw new InterruptedIOException();
            }
        }
        if (f)
        {
            throw new IOException("stream finished");
        }
        if (x.d(b) != null)
        {
            throw new IOException((new StringBuilder("stream was reset: ")).append(x.d(b)).toString());
        }
          goto _L1
    }

    private void a(boolean flag)
    {
        if (!a && Thread.holdsLock(b))
        {
            throw new AssertionError();
        }
        int i = d;
        synchronized (b)
        {
            a(i, flag);
            g = i + g;
        }
        obj = x.b(b);
        i = x.a(b);
        byte abyte0[] = c;
        int j = d;
        ((q) (obj)).d.a(flag, i, abyte0, j);
        d = 0;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static boolean a(z z1)
    {
        return z1.f;
    }

    static boolean a(z z1, boolean flag)
    {
        z1.f = flag;
        return flag;
    }

    static boolean b(z z1)
    {
        return z1.e;
    }

    public final void close()
    {
label0:
        {
            if (!a && Thread.holdsLock(b))
            {
                throw new AssertionError();
            }
            synchronized (b)
            {
                if (!e)
                {
                    break label0;
                }
            }
            return;
        }
        e = true;
        x1;
        JVM INSTR monitorexit ;
        if (!x.f(b).f)
        {
            a(true);
        }
        x.b(b).c();
        x.e(b);
        return;
        exception;
        x1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void flush()
    {
        if (!a && Thread.holdsLock(b))
        {
            throw new AssertionError();
        }
        a();
        if (d > 0)
        {
            a(false);
            x.b(b).c();
        }
    }

    public final void write(int i)
    {
        u.a(this, i);
    }

    public final void write(byte abyte0[], int i, int j)
    {
        if (!a && Thread.holdsLock(b))
        {
            throw new AssertionError();
        }
        u.a(abyte0.length, i, j);
        a();
        int k;
        for (; j > 0; j -= k)
        {
            if (d == c.length)
            {
                a(false);
            }
            k = Math.min(j, c.length - d);
            System.arraycopy(abyte0, i, c, d, k);
            d = d + k;
            i += k;
        }

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
        a = flag;
    }
}
