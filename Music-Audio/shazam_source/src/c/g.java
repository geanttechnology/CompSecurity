// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import java.util.zip.Deflater;

// Referenced classes of package c:
//            r, m, d, c, 
//            p, q, u, t

public final class g
    implements r
{

    private final d a;
    private final Deflater b;
    private boolean c;

    private g(d d1, Deflater deflater)
    {
        if (d1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            a = d1;
            b = deflater;
            return;
        }
    }

    public g(r r1, Deflater deflater)
    {
        this(m.a(r1), deflater);
    }

    private void a(boolean flag)
    {
        c c1 = a.b();
        p p1;
label0:
        do
        {
            do
            {
                p1 = c1.e(1);
                int i;
                if (flag)
                {
                    i = b.deflate(p1.a, p1.c, 2048 - p1.c, 2);
                } else
                {
                    i = b.deflate(p1.a, p1.c, 2048 - p1.c);
                }
                if (i <= 0)
                {
                    continue label0;
                }
                p1.c = p1.c + i;
                c1.b = c1.b + (long)i;
                a.s();
            } while (true);
        } while (!b.needsInput());
        if (p1.b == p1.c)
        {
            c1.a = p1.a();
            q.a(p1);
        }
    }

    public final void a_(c c1, long l)
    {
        u.a(c1.b, 0L, l);
        int i;
        for (; l > 0L; l -= i)
        {
            p p1 = c1.a;
            i = (int)Math.min(l, p1.c - p1.b);
            b.setInput(p1.a, p1.b, i);
            a(false);
            c1.b = c1.b - (long)i;
            p1.b = p1.b + i;
            if (p1.b == p1.c)
            {
                c1.a = p1.a();
                q.a(p1);
            }
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
        try
        {
            b.finish();
            a(false);
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable1) { }
        b.end();
        throwable = throwable1;
_L3:
        a.close();
        throwable1 = throwable;
_L4:
        c = true;
        if (throwable1 != null)
        {
            u.a(throwable1);
            return;
        }
          goto _L1
        throwable;
        if (throwable1 != null)
        {
            throwable = throwable1;
        }
          goto _L3
        Throwable throwable2;
        throwable2;
        throwable1 = throwable;
        if (throwable == null)
        {
            throwable1 = throwable2;
        }
          goto _L4
    }

    public final void flush()
    {
        a(true);
        a.flush();
    }

    public final String toString()
    {
        return (new StringBuilder("DeflaterSink(")).append(a).append(")").toString();
    }

    public final t w_()
    {
        return a.w_();
    }
}
