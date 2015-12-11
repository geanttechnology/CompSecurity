// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.OutputStream;

// Referenced classes of package d:
//            aa, f, ae, ac, 
//            y, z

final class r
    implements aa
{

    private ac a;
    private OutputStream b;

    r(ac ac1, OutputStream outputstream)
    {
        a = ac1;
        b = outputstream;
        super();
    }

    public final void close()
    {
        b.close();
    }

    public final void flush()
    {
        b.flush();
    }

    public final ac timeout()
    {
        return a;
    }

    public final String toString()
    {
        return (new StringBuilder("sink(")).append(b).append(")").toString();
    }

    public final void write(f f1, long l)
    {
        ae.a(f1.b, 0L, l);
        do
        {
            if (l <= 0L)
            {
                break;
            }
            a.throwIfReached();
            y y1 = f1.a;
            int i = (int)Math.min(l, y1.c - y1.b);
            b.write(y1.a, y1.b, i);
            y1.b = y1.b + i;
            long l1 = l - (long)i;
            f1.b = f1.b - (long)i;
            l = l1;
            if (y1.b == y1.c)
            {
                f1.a = y1.a();
                z.a(y1);
                l = l1;
            }
        } while (true);
    }
}
