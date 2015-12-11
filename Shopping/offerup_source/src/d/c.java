// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.IOException;

// Referenced classes of package d:
//            ab, a, f, ac

final class c
    implements ab
{

    private ab a;
    private a b;

    c(a a1, ab ab1)
    {
        b = a1;
        a = ab1;
        super();
    }

    public final void close()
    {
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

    public final long read(f f, long l)
    {
        b.enter();
        l = a.read(f, l);
        b.exit(true);
        return l;
        f;
        throw b.exit(f);
        f;
        b.exit(false);
        throw f;
    }

    public final ac timeout()
    {
        return b;
    }

    public final String toString()
    {
        return (new StringBuilder("AsyncTimeout.source(")).append(a).append(")").toString();
    }
}
