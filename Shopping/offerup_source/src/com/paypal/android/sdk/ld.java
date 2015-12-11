// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            kr, kq, lj, lh, 
//            lm, lf, lk, kt

final class ld
    implements kr
{

    private kq a;
    private lh b;
    private boolean c;

    public ld(lh lh1)
    {
        this(lh1, new kq());
    }

    private ld(lh lh1, kq kq1)
    {
        if (lh1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            a = kq1;
            b = lh1;
            return;
        }
    }

    public final long a(lj lj1)
    {
        if (lj1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        long l = 0L;
        do
        {
            long l1 = lj1.a(a, 2048L);
            if (l1 != -1L)
            {
                l += l1;
                o();
            } else
            {
                return l;
            }
        } while (true);
    }

    public final lk a()
    {
        return b.a();
    }

    public final void a_(kq kq1, long l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a_(kq1, l);
            o();
            return;
        }
    }

    public final kq b()
    {
        return a;
    }

    public final kr b(kt kt)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(kt);
            return o();
        }
    }

    public final kr b(String s)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(s);
            return o();
        }
    }

    public final kr b(byte abyte0[])
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(abyte0);
            return o();
        }
    }

    public final kr b(byte abyte0[], int i, int j)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.a(abyte0, i, j);
            return o();
        }
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
            lm.a(throwable1);
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

    public final kr f(int i)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.d(i);
            return o();
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

    public final kr g(int i)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.c(i);
            return o();
        }
    }

    public final kr h(int i)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.b(i);
            return o();
        }
    }

    public final kr h(long l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        } else
        {
            a.g(l);
            return o();
        }
    }

    public final kr o()
    {
        Object obj;
        long l1;
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        obj = a;
        l1 = ((kq) (obj)).b;
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
        obj = ((kq) (obj)).a.g;
        l = l1;
        if (((lf) (obj)).c < 2048)
        {
            l = l1;
            if (((lf) (obj)).e)
            {
                l = l1 - (long)(((lf) (obj)).c - ((lf) (obj)).b);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final String toString()
    {
        return (new StringBuilder("buffer(")).append(b).append(")").toString();
    }
}
