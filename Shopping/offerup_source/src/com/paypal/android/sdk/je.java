// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

// Referenced classes of package com.paypal.android.sdk:
//            hq, jc, kq, ku, 
//            kz, kr, ii, kt, 
//            hn, jb, hl

final class je
    implements hq
{

    private final kr a;
    private final kq b = new kq();
    private final kr c;
    private final boolean d;
    private boolean e;

    je(kr kr1, boolean flag)
    {
        a = kr1;
        d = flag;
        kr1 = new Deflater();
        kr1.setDictionary(jc.a);
        c = kz.a(new ku(b, kr1));
    }

    private void a(List list)
    {
        c.f(list.size());
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            kt kt1 = ((ii)list.get(i)).h;
            c.f(kt1.b.length);
            c.b(kt1);
            kt1 = ((ii)list.get(i)).i;
            c.f(kt1.b.length);
            c.b(kt1);
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

    public final void a(int i, hn hn1)
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        hn1;
        this;
        JVM INSTR monitorexit ;
        throw hn1;
        if (hn1.j == -1)
        {
            throw new IllegalArgumentException();
        }
        a.f(0x80030003);
        a.f(8);
        a.f(0x7fffffff & i);
        a.f(hn1.j);
        a.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(int i, hn hn1, byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        hn1;
        this;
        JVM INSTR monitorexit ;
        throw hn1;
        if (hn1.k == -1)
        {
            throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
        }
        a.f(0x80030007);
        a.f(8);
        a.f(i);
        a.f(hn1.k);
        a.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(jb jb1)
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

    public final void a(boolean flag, int i, kq kq1, int j)
    {
        this;
        JVM INSTR monitorenter ;
        int k;
        if (flag)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_37;
        kq1;
        this;
        JVM INSTR monitorexit ;
        throw kq1;
        if ((long)j <= 0xffffffL)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        throw new IllegalArgumentException((new StringBuilder("FRAME_TOO_LARGE max size is 16Mib: ")).append(j).toString());
        a.f(0x7fffffff & i);
        a.f((k & 0xff) << 24 | 0xffffff & j);
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        a.a_(kq1, j);
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(boolean flag, boolean flag1, int i, int j, List list)
    {
        byte byte0 = 0;
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_29;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        int k;
        a(list);
        k = (int)(10L + b.b);
        break MISSING_BLOCK_LABEL_49;
_L2:
        a.f(0x80030001);
        a.f(((byte0 | j) & 0xff) << 24 | k & 0xffffff);
        a.f(0x7fffffff & i);
        a.f(0);
        a.g(0);
        a.a(b);
        a.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (flag1)
        {
            byte0 = 2;
        }
        if (true) goto _L2; else goto _L1
_L1:
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

    public final void b(jb jb1)
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        jb1;
        this;
        JVM INSTR monitorexit ;
        throw jb1;
        int i = jb1.b();
        a.f(0x80030004);
        a.f((i << 3) + 4 & 0xffffff | 0);
        a.f(i);
        int j = 0;
_L2:
        if (j > 10)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        if (jb1.a(j))
        {
            int k = jb1.c(j);
            a.f((k & 0xff) << 24 | j & 0xffffff);
            a.f(jb1.b(j));
        }
        break MISSING_BLOCK_LABEL_147;
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
        hl.a(a, c);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
