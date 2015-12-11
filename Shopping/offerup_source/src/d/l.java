// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.util.zip.Deflater;

// Referenced classes of package d:
//            aa, q, i, f, 
//            y, z, ae, ac

public final class l
    implements aa
{

    private final i a;
    private final Deflater b;
    private boolean c;

    public l(aa aa1, Deflater deflater)
    {
        this(q.a(aa1), deflater);
    }

    private l(i j, Deflater deflater)
    {
        if (j == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            a = j;
            b = deflater;
            return;
        }
    }

    private void a(boolean flag)
    {
        f f1 = a.b();
        y y1;
label0:
        do
        {
            do
            {
                y1 = f1.d(1);
                int j;
                if (flag)
                {
                    j = b.deflate(y1.a, y1.c, 2048 - y1.c, 2);
                } else
                {
                    j = b.deflate(y1.a, y1.c, 2048 - y1.c);
                }
                if (j <= 0)
                {
                    continue label0;
                }
                y1.c = y1.c + j;
                f1.b = f1.b + (long)j;
                a.r();
            } while (true);
        } while (!b.needsInput());
        if (y1.b == y1.c)
        {
            f1.a = y1.a();
            z.a(y1);
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
            ae.a(throwable1);
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

    public final ac timeout()
    {
        return a.timeout();
    }

    public final String toString()
    {
        return (new StringBuilder("DeflaterSink(")).append(a).append(")").toString();
    }

    public final void write(f f1, long l1)
    {
        ae.a(f1.b, 0L, l1);
        int j;
        for (; l1 > 0L; l1 -= j)
        {
            y y1 = f1.a;
            j = (int)Math.min(l1, y1.c - y1.b);
            b.setInput(y1.a, y1.b, j);
            a(false);
            f1.b = f1.b - (long)j;
            y1.b = y1.b + j;
            if (y1.b == y1.c)
            {
                f1.a = y1.a();
                z.a(y1);
            }
        }

    }
}
