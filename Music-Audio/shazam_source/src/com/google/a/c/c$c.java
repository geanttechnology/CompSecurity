// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            c, ap

private class  extends 
{

    final c a;

    public void clear()
    {
        ap.e(iterator());
    }

    public boolean containsAll(Collection collection)
    {
        return super.c.keySet().containsAll(collection);
    }

    public boolean equals(Object obj)
    {
        return this == obj || super.c.keySet().equals(obj);
    }

    public int hashCode()
    {
        return super.c.keySet().hashCode();
    }

    public Iterator iterator()
    {
        return new Iterator(super.c.entrySet().iterator()) {

            java.util.Map.Entry a;
            final Iterator b;
            final c.c c;

            public final boolean hasNext()
            {
                return b.hasNext();
            }

            public final Object next()
            {
                a = (java.util.Map.Entry)b.next();
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
                com.google.a.c.c.b(c.a, collection.size());
                collection.clear();
            }

            
            {
                c = c.c.this;
                b = iterator1;
                super();
            }
        };
    }

    public boolean remove(Object obj)
    {
        obj = (Collection)super.c.remove(obj);
        int i;
        if (obj != null)
        {
            i = ((Collection) (obj)).size();
            ((Collection) (obj)).clear();
            com.google.a.c.c.b(a, i);
        } else
        {
            i = 0;
        }
        return i > 0;
    }

    nit>(c c1, Map map)
    {
        a = c1;
        super(map);
    }
}
