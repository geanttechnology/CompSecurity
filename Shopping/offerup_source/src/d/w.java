// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.EOFException;
import java.io.InputStream;

// Referenced classes of package d:
//            j, f, ab, x, 
//            k, ac

final class w
    implements j
{

    public final f a;
    public final ab b;
    private boolean c;

    public w(ab ab1)
    {
        this(ab1, new f());
    }

    private w(ab ab1, f f1)
    {
        if (ab1 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            a = f1;
            b = ab1;
            return;
        }
    }

    static boolean a(w w1)
    {
        return w1.c;
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
            if (b.read(a, 2048L) == -1L)
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
                    if (b.read(a, 2048L) == -1L)
                    {
                        return -1L;
                    }
                } while (true);
            }
        } while (b.read(a, 2048L) != -1L);
        l1 = -1L;
_L2:
        long l3;
        return l1;
        if (true) goto _L2; else goto _L1
_L1:
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

    public final f b()
    {
        return a;
    }

    public final k c(long l1)
    {
        a(l1);
        return a.c(l1);
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
            a.q();
            return;
        }
    }

    public final boolean e()
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        return a.e() && b.read(a, 2048L) == -1L;
    }

    public final byte[] e(long l1)
    {
        a(l1);
        return a.e(l1);
    }

    public final InputStream f()
    {
        return new x(this);
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
            if (a.b == 0L && b.read(a, 2048L) == -1L)
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

    public final byte g()
    {
        a(1L);
        return a.g();
    }

    public final short h()
    {
        a(2L);
        return a.h();
    }

    public final int i()
    {
        a(4L);
        return a.i();
    }

    public final short j()
    {
        a(2L);
        return a.j();
    }

    public final int k()
    {
        a(4L);
        return a.k();
    }

    public final long l()
    {
        int i1 = 0;
        do
        {
            if (!b(i1 + 1))
            {
                break;
            }
            byte byte0 = a.b(i1);
            if ((byte0 < 48 || byte0 > 57) && (i1 != 0 || byte0 != 45))
            {
                break;
            }
            i1++;
        } while (true);
        if (i1 == 0)
        {
            throw new NumberFormatException((new StringBuilder("Expected leading [0-9] or '-' character but was 0x")).append(Integer.toHexString(a.b(0L))).toString());
        } else
        {
            return a.l();
        }
    }

    public final long m()
    {
        int i1 = 0;
        do
        {
            if (!b(i1 + 1))
            {
                break;
            }
            byte byte0 = a.b(i1);
            if ((byte0 < 48 || byte0 > 57) && (byte0 < 97 || byte0 > 102) && (byte0 < 65 || byte0 > 70))
            {
                break;
            }
            i1++;
        } while (true);
        if (i1 == 0)
        {
            throw new NumberFormatException((new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x")).append(Integer.toHexString(a.b(0L))).toString());
        } else
        {
            return a.m();
        }
    }

    public final String o()
    {
        long l1 = a((byte)10);
        if (l1 == -1L)
        {
            f f1 = new f();
            a.a(f1, 0L, Math.min(32L, a.b));
            throw new EOFException((new StringBuilder("\\n not found: size=")).append(a.b).append(" content=").append(f1.n().c()).append("...").toString());
        } else
        {
            return a.d(l1);
        }
    }

    public final byte[] p()
    {
        a.a(b);
        return a.p();
    }

    public final long read(f f1, long l1)
    {
        if (f1 == null)
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
        if (a.b == 0L && b.read(a, 2048L) == -1L)
        {
            return -1L;
        } else
        {
            l1 = Math.min(l1, a.b);
            return a.read(f1, l1);
        }
    }

    public final ac timeout()
    {
        return b.timeout();
    }

    public final String toString()
    {
        return (new StringBuilder("buffer(")).append(b).append(")").toString();
    }
}
