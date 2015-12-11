// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.a.c:
//            c

final class t>
    implements Iterator
{

    java.util.try a;
    final Iterator b;
    final clear c;

    public final boolean hasNext()
    {
        return b.hasNext();
    }

    public final Object next()
    {
        a = (java.util.try)b.next();
        return a.getKey();
    }

    public final void remove()
    {
        Collection collection;
        boolean flag;
        if (a != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g.b(flag, "no calls to next() since the last call to remove()");
        collection = (Collection)a.getValue();
        b.remove();
        com.google.a.c.c.b(c.c, collection.size());
        collection.clear();
    }

    ( , Iterator iterator)
    {
        c = ;
        b = iterator;
        super();
    }
}
