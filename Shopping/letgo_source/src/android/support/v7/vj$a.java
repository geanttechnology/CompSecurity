// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Iterator;

// Referenced classes of package android.support.v7:
//            vj

final class b
    implements Iterator
{

    final int a;
    int b;
    int c;
    boolean d;
    final vj e;

    public boolean hasNext()
    {
        return c < b;
    }

    public Object next()
    {
        Object obj = e.a(c, a);
        c = c + 1;
        d = true;
        return obj;
    }

    public void remove()
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

    ception(vj vj1, int i)
    {
        e = vj1;
        super();
        d = false;
        a = i;
        b = vj1.a();
    }
}
