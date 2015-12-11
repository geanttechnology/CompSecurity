// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.io.InputStream;

public class cin extends InputStream
{

    private static final String a = cin.getSimpleName();
    private final cio b;
    private byte c[];
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;

    public cin(cio cio1)
    {
        g = false;
        h = false;
        b = cio1;
    }

    private void d()
    {
        if (d > e)
        {
            b.g.h = true;
            b.h.h = true;
            b.f.a(d, e, c.length);
            g = true;
            h = true;
        }
    }

    final int a()
    {
        this;
        JVM INSTR monitorenter ;
        byte abyte0[] = c;
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = c.length;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    final void a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IOException("Invalid content length.");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (c != null) goto _L2; else goto _L1
_L1:
        c = new byte[i];
        d = 0;
        e = i - 1;
        f = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (c.length == i) goto _L4; else goto _L3
_L3:
        close();
        int j = c.length;
        throw new IOException((new StringBuilder(82)).append("contentLength: ").append(i).append(" is different from the previously set value: ").append(j).toString());
    }

    final void a(byte abyte0[], int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            throw new IOException("Must first call InitContentLengthOrDie().");
        }
        break MISSING_BLOCK_LABEL_24;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        if (i > c.length - d)
        {
            b.g.h = true;
            notify();
            throw new IOException("The content fed from forward exceeded the buffer length.");
        }
        System.arraycopy(abyte0, 0, c, d, i);
        d = d + i;
        d();
        notify();
        this;
        JVM INSTR monitorexit ;
    }

    final void a(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            throw new IOException("Must first call InitContentLengthOrDie().");
        }
        break MISSING_BLOCK_LABEL_24;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        int k = (e - j) + 1;
        if (k >= 0)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        b.h.h = true;
        notify();
        abyte0 = String.valueOf("startPos = currentBackwardPos - length + 1 must be >= 0.  ; currentBackwardPos=");
        i = e;
        throw new IOException((new StringBuilder(String.valueOf(abyte0).length() + 31)).append(abyte0).append(i).append("; length=").append(j).toString());
        System.arraycopy(abyte0, i, c, k, j);
        e = e - j;
        d();
        notify();
        this;
        JVM INSTR monitorexit ;
    }

    final void b()
    {
        this;
        JVM INSTR monitorenter ;
        g = true;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void c()
    {
        this;
        JVM INSTR monitorenter ;
        h = true;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        b.g.h = true;
        b.h.h = true;
        g = true;
        h = true;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int read()
    {
        byte abyte0[] = new byte[1];
        if (read(abyte0, 0, 1) == -1)
        {
            return -1;
        } else
        {
            return abyte0[0];
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
_L8:
        if (c == null) goto _L2; else goto _L1
_L1:
        if (d <= e) goto _L4; else goto _L3
_L3:
        int k = c.length - f;
_L6:
        if (k <= 0) goto _L2; else goto _L5
_L5:
        j = Math.min(k, j);
        System.arraycopy(c, f, abyte0, i, j);
        f = f + j;
        i = j;
_L7:
        this;
        JVM INSTR monitorexit ;
        return i;
_L4:
        k = d - f;
          goto _L6
_L2:
        if (!g || !h)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        if (c == null || f < c.length)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        i = -1;
          goto _L7
        throw new IOException("Connections have ended, and read() attempts to get data that will never be available.");
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        wait();
          goto _L8
        abyte0;
        abyte0 = a;
        Thread.currentThread().interrupt();
        throw new IOException("Experienced InterruptedException.");
    }

}
