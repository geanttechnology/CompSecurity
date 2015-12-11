// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

// Referenced classes of package c:
//            s, m, e, c, 
//            p, q, t

public final class l
    implements s
{

    private final e a;
    private final Inflater b;
    private int c;
    private boolean d;

    l(e e1, Inflater inflater)
    {
        if (e1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            a = e1;
            b = inflater;
            return;
        }
    }

    public l(s s1, Inflater inflater)
    {
        this(m.a(s1), inflater);
    }

    private void c()
    {
        if (c == 0)
        {
            return;
        } else
        {
            int i = c - b.getRemaining();
            c = c - i;
            a.f(i);
            return;
        }
    }

    public final long a(c c1, long l1)
    {
        if (l1 < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l1).toString());
        }
        if (d)
        {
            throw new IllegalStateException("closed");
        }
        if (l1 == 0L)
        {
            return 0L;
        }
_L2:
        boolean flag = b();
        p p1;
        int i;
        try
        {
            p1 = c1.e(1);
            i = b.inflate(p1.a, p1.c, 2048 - p1.c);
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            throw new IOException(c1);
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        p1.c = p1.c + i;
        c1.b = c1.b + (long)i;
        return (long)i;
        if (b.finished() || b.needsDictionary())
        {
            c();
            if (p1.b == p1.c)
            {
                c1.a = p1.a();
                q.a(p1);
            }
            break MISSING_BLOCK_LABEL_209;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        throw new EOFException("source exhausted prematurely");
        return -1L;
    }

    public final boolean b()
    {
        if (!b.needsInput())
        {
            return false;
        }
        c();
        if (b.getRemaining() != 0)
        {
            throw new IllegalStateException("?");
        }
        if (a.e())
        {
            return true;
        } else
        {
            p p1 = a.b().a;
            c = p1.c - p1.b;
            b.setInput(p1.a, p1.b, c);
            return false;
        }
    }

    public final void close()
    {
        if (d)
        {
            return;
        } else
        {
            b.end();
            d = true;
            a.close();
            return;
        }
    }

    public final t w_()
    {
        return a.w_();
    }
}
