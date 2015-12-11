// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import c.c;
import c.d;
import c.f;
import c.g;
import c.m;
import com.g.b.a.k;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

// Referenced classes of package com.g.b.a.d:
//            c, n, d, a, 
//            m

static final class flater
    implements com.g.b.a.d.c
{

    private final d a;
    private final c b = new c();
    private final d c;
    private final boolean d;
    private boolean e;

    private void a(List list)
    {
        if (b.b != 0L)
        {
            throw new IllegalStateException();
        }
        c.f(list.size());
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            f f1 = ((com.g.b.a.d.d)list.get(i)).h;
            c.f(f1.c.length);
            c.b(f1);
            f1 = ((com.g.b.a.d.d)list.get(i)).i;
            c.f(f1.c.length);
            c.b(f1);
        }

        c.flush();
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
    }

    public final void a(int i, long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_26;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (l != 0L && l <= 0x7fffffffL)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        throw new IllegalArgumentException((new StringBuilder("windowSizeIncrement must be between 1 and 0x7fffffff: ")).append(l).toString());
        a.f(0x80030009);
        a.f(8);
        a.f(i);
        a.f((int)l);
        a.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(int i, a a1)
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
        if (a1.t == -1)
        {
            throw new IllegalArgumentException();
        }
        a.f(0x80030003);
        a.f(8);
        a.f(0x7fffffff & i);
        a.f(a1.t);
        a.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(int i, a a1, byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
        if (a1.u == -1)
        {
            throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
        }
        a.f(0x80030007);
        a.f(8);
        a.f(i);
        a.f(a1.u);
        a.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(com.g.b.a.d.m m1)
    {
    }

    public final void a(boolean flag, int i, int j)
    {
        boolean flag2 = true;
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        boolean flag3 = d;
        boolean flag1;
        if ((i & 1) == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag3 != flag1)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
          goto _L1
_L3:
        if (flag == flag1)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        throw new IllegalArgumentException("payload != reply");
        a.f(0x80030006);
        a.f(4);
        a.f(i);
        a.flush();
        this;
        JVM INSTR monitorexit ;
        return;
_L1:
        if (true) goto _L3; else goto _L2
_L2:
    }

    public final void a(boolean flag, int i, c c1, int j)
    {
        this;
        JVM INSTR monitorenter ;
        int l;
        if (flag)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_37;
        c1;
        this;
        JVM INSTR monitorexit ;
        throw c1;
        if ((long)j <= 0xffffffL)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        throw new IllegalArgumentException((new StringBuilder("FRAME_TOO_LARGE max size is 16Mib: ")).append(j).toString());
        a.f(0x7fffffff & i);
        a.f((l & 0xff) << 24 | 0xffffff & j);
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        a.a_(c1, j);
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(boolean flag, int i, List list)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_27;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        int j;
        a(list);
        j = (int)(10L + b.b);
        if (flag)
        {
            flag1 = true;
        }
        a.f(0x80030001);
        a.f(((flag1 | false) & 0xff) << 24 | j & 0xffffff);
        a.f(0x7fffffff & i);
        a.f(0);
        a.g(0);
        a.a(b);
        a.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        a.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public final void b(com.g.b.a.d.m m1)
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        m1;
        this;
        JVM INSTR monitorexit ;
        throw m1;
        int i = Integer.bitCount(m1.a);
        a.f(0x80030004);
        a.f(i * 8 + 4 & 0xffffff | 0);
        a.f(i);
        int j = 0;
_L2:
        if (j > 10)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        if (m1.a(j))
        {
            int l = m1.b(j);
            a.f((l & 0xff) << 24 | j & 0xffffff);
            a.f(m1.d[j]);
        }
        break MISSING_BLOCK_LABEL_152;
        a.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final int c()
    {
        return 16383;
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        e = true;
        k.a(a, c);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    flater(d d1, boolean flag)
    {
        a = d1;
        d = flag;
        d1 = new Deflater();
        d1.setDictionary(n.a);
        c = m.a(new g(b, d1));
    }
}
