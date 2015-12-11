// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package c:
//            d, c, s, r, 
//            u, p, f, t

final class n
    implements d
{

    public final c a;
    public final r b;
    boolean c;

    public n(r r1)
    {
        this(r1, new c());
    }

    private n(r r1, c c1)
    {
        if (r1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            a = c1;
            b = r1;
            return;
        }
    }

    public final long a(s s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        long l = 0L;
        do
        {
            long l1 = s1.a(a, 2048L);
            if (l1 != -1L)
            {
                l += l1;
                s();
            } else
            {
                return l;
            }
        } while (true);
    }

    public final void a_(c c1, long l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a_(c1, l);
            s();
            return;
        }
    }

    public final c b()
    {
        return a;
    }

    public final d b(f f1)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(f1);
            return s();
        }
    }

    public final d b(String s1)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(s1);
            return s();
        }
    }

    public final d b(byte abyte0[])
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(abyte0);
            return s();
        }
    }

    public final d c(byte abyte0[], int k, int l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.b(abyte0, k, l);
            return s();
        }
    }

    public final OutputStream c()
    {
        return new OutputStream() {

            final n a;

            public final void close()
            {
                a.close();
            }

            public final void flush()
            {
                if (!a.c)
                {
                    a.flush();
                }
            }

            public final String toString()
            {
                return (new StringBuilder()).append(a).append(".outputStream()").toString();
            }

            public final void write(int k)
            {
                if (a.c)
                {
                    throw new IOException("closed");
                } else
                {
                    a.a.b((byte)k);
                    a.s();
                    return;
                }
            }

            public final void write(byte abyte0[], int k, int l)
            {
                if (a.c)
                {
                    throw new IOException("closed");
                } else
                {
                    a.a.b(abyte0, k, l);
                    a.s();
                    return;
                }
            }

            
            {
                a = n.this;
                super();
            }
        };
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
        b.a_(a, a.b);
        throwable = throwable1;
_L4:
        b.close();
        throwable1 = throwable;
_L3:
        c = true;
        if (throwable1 != null)
        {
            u.a(throwable1);
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

    public final d d()
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        long l = a.b;
        if (l > 0L)
        {
            b.a_(a, l);
        }
        return this;
    }

    public final d f(int k)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.d(k);
            return s();
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
            b.a_(a, a.b);
        }
        b.flush();
    }

    public final d g(int k)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.c(k);
            return s();
        }
    }

    public final d h(int k)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.b(k);
            return s();
        }
    }

    public final d i(long l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.h(l);
            return s();
        }
    }

    public final d j(long l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.g(l);
            return s();
        }
    }

    public final d s()
    {
        Object obj;
        long l1;
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        obj = a;
        l1 = ((c) (obj)).b;
        if (l1 != 0L) goto _L2; else goto _L1
_L1:
        long l = 0L;
_L4:
        if (l > 0L)
        {
            b.a_(a, l);
        }
        return this;
_L2:
        obj = ((c) (obj)).a.g;
        l = l1;
        if (((p) (obj)).c < 2048)
        {
            l = l1;
            if (((p) (obj)).e)
            {
                l = l1 - (long)(((p) (obj)).c - ((p) (obj)).b);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final String toString()
    {
        return (new StringBuilder("buffer(")).append(b).append(")").toString();
    }

    public final t w_()
    {
        return b.w_();
    }
}
