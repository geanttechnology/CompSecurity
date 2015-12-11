// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.OutputStream;

// Referenced classes of package d:
//            i, f, ab, v, 
//            aa, ae, y, k, 
//            ac

final class u
    implements i
{

    public final f a;
    private aa b;
    private boolean c;

    public u(aa aa1)
    {
        this(aa1, new f());
    }

    private u(aa aa1, f f1)
    {
        if (aa1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            a = f1;
            b = aa1;
            return;
        }
    }

    static boolean a(u u1)
    {
        return u1.c;
    }

    public final long a(ab ab1)
    {
        if (ab1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        long l = 0L;
        do
        {
            long l1 = ab1.read(a, 2048L);
            if (l1 != -1L)
            {
                l += l1;
                r();
            } else
            {
                return l;
            }
        } while (true);
    }

    public final f b()
    {
        return a;
    }

    public final i b(k k)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(k);
            return r();
        }
    }

    public final i b(String s)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(s);
            return r();
        }
    }

    public final i b(byte abyte0[])
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(abyte0);
            return r();
        }
    }

    public final i c(byte abyte0[], int k, int l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.b(abyte0, k, l);
            return r();
        }
    }

    public final OutputStream c()
    {
        return new v(this);
    }

    public final void close()
    {
        if (!c) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Throwable throwable;
        Throwable throwable1;
        throwable1 = null;
        throwable = throwable1;
        if (a.b <= 0L)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        b.write(a, a.b);
        throwable = throwable1;
_L4:
        b.close();
        throwable1 = throwable;
_L3:
        c = true;
        if (throwable1 != null)
        {
            ae.a(throwable1);
            return;
        }
          goto _L1
        Throwable throwable2;
        throwable2;
        throwable1 = throwable;
        if (throwable == null)
        {
            throwable1 = throwable2;
        }
          goto _L3
        throwable;
          goto _L4
    }

    public final i d()
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        long l = a.b;
        if (l > 0L)
        {
            b.write(a, l);
        }
        return this;
    }

    public final i e(int k)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.c(k);
            return r();
        }
    }

    public final i f(int k)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.b(k);
            return r();
        }
    }

    public final void flush()
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        if (a.b > 0L)
        {
            b.write(a, a.b);
        }
        b.flush();
    }

    public final i g(int k)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(k);
            return r();
        }
    }

    public final i i(long l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.h(l);
            return r();
        }
    }

    public final i j(long l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.g(l);
            return r();
        }
    }

    public final i r()
    {
        Object obj;
        long l1;
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        obj = a;
        l1 = ((f) (obj)).b;
        if (l1 != 0L) goto _L2; else goto _L1
_L1:
        long l = 0L;
_L4:
        if (l > 0L)
        {
            b.write(a, l);
        }
        return this;
_L2:
        obj = ((f) (obj)).a.g;
        l = l1;
        if (((y) (obj)).c < 2048)
        {
            l = l1;
            if (((y) (obj)).e)
            {
                l = l1 - (long)(((y) (obj)).c - ((y) (obj)).b);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final ac timeout()
    {
        return b.timeout();
    }

    public final String toString()
    {
        return (new StringBuilder("buffer(")).append(b).append(")").toString();
    }

    public final void write(f f1, long l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.write(f1, l);
            r();
            return;
        }
    }
}
