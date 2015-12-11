// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.api.a.g:
//            i, f, k, w

final class b
    implements Iterator
{

    final i a;
    private int b;
    private k c;
    private Object d;
    private boolean e;
    private boolean f;
    private k g;

    public final boolean hasNext()
    {
        if (!f)
        {
            f = true;
            d = null;
            do
            {
                if (d != null)
                {
                    break;
                }
                int j = b + 1;
                b = j;
                if (j >= a.b.d.size())
                {
                    break;
                }
                c = a.b.a((String)a.b.d.get(b));
                d = c.a(a.a);
            } while (true);
        }
        return d != null;
    }

    public final Object next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        } else
        {
            g = c;
            Object obj = d;
            f = false;
            e = false;
            c = null;
            d = null;
            return new <init>(a, g, obj);
        }
    }

    public final void remove()
    {
        boolean flag;
        if (g != null && !e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.b(flag);
        e = true;
        g.a(a.a, null);
    }

    Exception(i j)
    {
        a = j;
        super();
        b = -1;
    }
}
