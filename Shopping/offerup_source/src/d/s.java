// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.InputStream;

// Referenced classes of package d:
//            ab, ac, f, y

final class s
    implements ab
{

    private ac a;
    private InputStream b;

    s(ac ac1, InputStream inputstream)
    {
        a = ac1;
        b = inputstream;
        super();
    }

    public final void close()
    {
        b.close();
    }

    public final long read(f f1, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (l == 0L)
        {
            return 0L;
        }
        a.throwIfReached();
        y y1 = f1.d(1);
        int i = (int)Math.min(l, 2048 - y1.c);
        i = b.read(y1.a, y1.c, i);
        if (i == -1)
        {
            return -1L;
        } else
        {
            y1.c = y1.c + i;
            f1.b = f1.b + (long)i;
            return (long)i;
        }
    }

    public final ac timeout()
    {
        return a;
    }

    public final String toString()
    {
        return (new StringBuilder("source(")).append(b).append(")").toString();
    }
}
