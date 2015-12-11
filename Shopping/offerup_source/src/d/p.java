// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

// Referenced classes of package d:
//            ab, q, j, f, 
//            y, z, ac

public final class p
    implements ab
{

    private final j a;
    private final Inflater b;
    private int c;
    private boolean d;

    public p(ab ab1, Inflater inflater)
    {
        this(q.a(ab1), inflater);
    }

    p(j j1, Inflater inflater)
    {
        if (j1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            a = j1;
            b = inflater;
            return;
        }
    }

    private void b()
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

    public final boolean a()
    {
        if (!b.needsInput())
        {
            return false;
        }
        b();
        if (b.getRemaining() != 0)
        {
            throw new IllegalStateException("?");
        }
        if (a.e())
        {
            return true;
        } else
        {
            y y1 = a.b().a;
            c = y1.c - y1.b;
            b.setInput(y1.a, y1.b, c);
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

    public final long read(f f1, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (d)
        {
            throw new IllegalStateException("closed");
        }
        if (l == 0L)
        {
            return 0L;
        }
_L2:
        boolean flag = a();
        y y1;
        int i;
        try
        {
            y1 = f1.d(1);
            i = b.inflate(y1.a, y1.c, 2048 - y1.c);
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            throw new IOException(f1);
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        y1.c = y1.c + i;
        f1.b = f1.b + (long)i;
        return (long)i;
        if (b.finished() || b.needsDictionary())
        {
            b();
            if (y1.b == y1.c)
            {
                f1.a = y1.a();
                z.a(y1);
            }
            break MISSING_BLOCK_LABEL_209;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        throw new EOFException("source exhausted prematurely");
        return -1L;
    }

    public final ac timeout()
    {
        return a.timeout();
    }
}
