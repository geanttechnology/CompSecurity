// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.EOFException;

// Referenced classes of package com.paypal.android.sdk:
//            ks, kq, lj, kt, 
//            lk

final class le
    implements ks
{

    private kq a;
    private lj b;
    private boolean c;

    public le(lj lj1)
    {
        this(lj1, new kq());
    }

    private le(lj lj1, kq kq1)
    {
        if (lj1 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            a = kq1;
            b = lj1;
            return;
        }
    }

    private boolean b(long l1)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l1).toString());
        }
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        while (a.b < l1) 
        {
            if (b.a(a, 2048L) == -1L)
            {
                return false;
            }
        }
        return true;
    }

    public final long a(byte byte0)
    {
        long l1;
        long l2 = 0L;
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        do
        {
            l1 = l2;
            if (0L < a.b)
            {
                do
                {
                    l3 = a.a(byte0, l1);
                    l1 = l3;
                    if (l3 != -1L)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    l1 = a.b;
                    if (b.a(a, 2048L) == -1L)
                    {
                        return -1L;
                    }
                } while (true);
            }
        } while (b.a(a, 2048L) != -1L);
        l1 = -1L;
_L2:
        long l3;
        return l1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final long a(kq kq1, long l1)
    {
        if (kq1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        }
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l1).toString());
        }
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        if (a.b == 0L && b.a(a, 2048L) == -1L)
        {
            return -1L;
        } else
        {
            l1 = Math.min(l1, a.b);
            return a.a(kq1, l1);
        }
    }

    public final lk a()
    {
        return b.a();
    }

    public final void a(long l1)
    {
        if (!b(l1))
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public final kq b()
    {
        return a;
    }

    public final kt c(long l1)
    {
        a(l1);
        return a.c(l1);
    }

    public final boolean c()
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        return a.c() && b.a(a, 2048L) == -1L;
    }

    public final void close()
    {
        if (c)
        {
            return;
        } else
        {
            c = true;
            b.close();
            a.n();
            return;
        }
    }

    public final byte d()
    {
        a(1L);
        return a.d();
    }

    public final short e()
    {
        a(2L);
        return a.e();
    }

    public final byte[] e(long l1)
    {
        a(l1);
        return a.e(l1);
    }

    public final int f()
    {
        a(4L);
        return a.f();
    }

    public final void f(long l1)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
_L3:
        if (l1 > 0L)
        {
            if (a.b == 0L && b.a(a, 2048L) == -1L)
            {
                throw new EOFException();
            }
        } else
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L2:
        long l2 = Math.min(l1, a.b);
        a.f(l2);
        l1 -= l2;
        if (true) goto _L3; else goto _L1
_L1:
    }

    public final short g()
    {
        a(2L);
        return a.g();
    }

    public final int h()
    {
        a(4L);
        return a.h();
    }

    public final long i()
    {
        a(1L);
        int j = 0;
        do
        {
            if (!b(j + 1))
            {
                break;
            }
            byte byte0 = a.b(j);
            if ((byte0 < 48 || byte0 > 57) && (byte0 < 97 || byte0 > 102) && (byte0 < 65 || byte0 > 70))
            {
                if (j == 0)
                {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[] {
                        Byte.valueOf(byte0)
                    }));
                }
                break;
            }
            j++;
        } while (true);
        return a.i();
    }

    public final String l()
    {
        long l1 = a((byte)10);
        if (l1 == -1L)
        {
            kq kq1 = new kq();
            a.a(kq1, 0L, Math.min(32L, a.b));
            throw new EOFException((new StringBuilder("\\n not found: size=")).append(a.b).append(" content=").append(kq1.j().b()).append("...").toString());
        } else
        {
            return a.d(l1);
        }
    }

    public final byte[] m()
    {
        a.a(b);
        return a.m();
    }

    public final String toString()
    {
        return (new StringBuilder("buffer(")).append(b).append(")").toString();
    }
}
