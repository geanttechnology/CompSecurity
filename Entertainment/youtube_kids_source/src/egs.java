// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

class egs
    implements Iterator
{

    final Iterator a;
    private Collection b;
    private egr c;

    egs(egr egr1)
    {
        c = egr1;
        super();
        b = c.b;
        a = egi.a(egr1.d, egr1.b);
    }

    egs(egr egr1, Iterator iterator)
    {
        c = egr1;
        super();
        b = c.b;
        a = iterator;
    }

    final void a()
    {
        c.a();
        if (c.b != b)
        {
            throw new ConcurrentModificationException();
        } else
        {
            return;
        }
    }

    public boolean hasNext()
    {
        a();
        return a.hasNext();
    }

    public Object next()
    {
        a();
        return a.next();
    }

    public void remove()
    {
        a.remove();
        egi.b(c.d);
        c.b();
    }
}
