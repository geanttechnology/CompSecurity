// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

final class df
    implements Iterator
{

    private int a;
    private int b;
    private int c;
    private boolean d;
    private de e;

    df(de de1, int i)
    {
        e = de1;
        super();
        d = false;
        a = i;
        b = de1.a();
    }

    public final boolean hasNext()
    {
        return c < b;
    }

    public final Object next()
    {
        Object obj = e.a(c, a);
        c = c + 1;
        d = true;
        return obj;
    }

    public final void remove()
    {
        if (!d)
        {
            throw new IllegalStateException();
        } else
        {
            c = c - 1;
            b = b - 1;
            d = false;
            e.a(c);
            return;
        }
    }
}
