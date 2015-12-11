// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            c, ap

private abstract class 
    implements Iterator
{

    final Iterator b;
    Object c;
    Collection d;
    Iterator e;
    final c f;

    abstract Object a(Object obj, Object obj1);

    public boolean hasNext()
    {
        return b.hasNext() || e.hasNext();
    }

    public Object next()
    {
        if (!e.hasNext())
        {
            java.util.Entry entry = (java.util.Entry)b.next();
            c = entry.getKey();
            d = (Collection)entry.getValue();
            e = d.iterator();
        }
        return a(c, e.next());
    }

    public void remove()
    {
        e.remove();
        if (d.isEmpty())
        {
            b.remove();
        }
        com.google.a.c.c.b(f);
    }

    n(c c1)
    {
        f = c1;
        super();
        b = com.google.a.c.c.a(c1).entrySet().iterator();
        c = null;
        d = null;
        e = ap.b();
    }
}
