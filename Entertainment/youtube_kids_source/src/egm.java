// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class egm extends ejw
{

    final Map a;
    final egi b;

    egm(egi egi1, Map map)
    {
        b = egi1;
        super();
        a = map;
    }

    final Map a()
    {
        return a;
    }

    public void clear()
    {
        ejj.d(iterator());
    }

    public boolean containsAll(Collection collection)
    {
        return a.keySet().containsAll(collection);
    }

    public boolean equals(Object obj)
    {
        return this == obj || a.keySet().equals(obj);
    }

    public int hashCode()
    {
        return a.keySet().hashCode();
    }

    public Iterator iterator()
    {
        return new egn(this, a.entrySet().iterator());
    }

    public boolean remove(Object obj)
    {
        obj = (Collection)a.remove(obj);
        int i;
        if (obj != null)
        {
            i = ((Collection) (obj)).size();
            ((Collection) (obj)).clear();
            egi.b(b, i);
        } else
        {
            i = 0;
        }
        return i > 0;
    }
}
