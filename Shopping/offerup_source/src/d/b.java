// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.IOException;

// Referenced classes of package d:
//            aa, a, ac, f

final class b
    implements aa
{

    private aa a;
    private a b;

    b(a a1, aa aa1)
    {
        b = a1;
        a = aa1;
        super();
    }

    public final void close()
    {
        b.enter();
        a.close();
        b.exit(true);
        return;
        Object obj;
        obj;
        throw b.exit(((IOException) (obj)));
        obj;
        b.exit(false);
        throw obj;
    }

    public final void flush()
    {
        b.enter();
        a.flush();
        b.exit(true);
        return;
        Object obj;
        obj;
        throw b.exit(((IOException) (obj)));
        obj;
        b.exit(false);
        throw obj;
    }

    public final ac timeout()
    {
        return b;
    }

    public final String toString()
    {
        return (new StringBuilder("AsyncTimeout.sink(")).append(a).append(")").toString();
    }

    public final void write(f f, long l)
    {
        b.enter();
        a.write(f, l);
        b.exit(true);
        return;
        f;
        throw b.exit(f);
        f;
        b.exit(false);
        throw f;
    }
}
