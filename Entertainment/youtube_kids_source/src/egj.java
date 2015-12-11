// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class egj extends AbstractMap
{

    final transient Map a;
    final egi b;
    private transient Set c;

    egj(egi egi1, Map map)
    {
        b = egi1;
        super();
        a = map;
    }

    public void clear()
    {
        if (a == egi.a(b))
        {
            b.b();
            return;
        } else
        {
            ejj.d(new egl(this));
            return;
        }
    }

    public boolean containsKey(Object obj)
    {
        return ejr.b(a, obj);
    }

    public Set entrySet()
    {
        Set set = c;
        Object obj = set;
        if (set == null)
        {
            obj = new egk(this);
            c = ((Set) (obj));
        }
        return ((Set) (obj));
    }

    public boolean equals(Object obj)
    {
        return this == obj || a.equals(obj);
    }

    public Object get(Object obj)
    {
        Collection collection = (Collection)ejr.a(a, obj);
        if (collection == null)
        {
            return null;
        } else
        {
            return b.a(obj, collection);
        }
    }

    public int hashCode()
    {
        return a.hashCode();
    }

    public Set keySet()
    {
        return b.e();
    }

    public Object remove(Object obj)
    {
        obj = (Collection)a.remove(obj);
        if (obj == null)
        {
            return null;
        } else
        {
            Collection collection = b.a();
            collection.addAll(((Collection) (obj)));
            egi.b(b, ((Collection) (obj)).size());
            ((Collection) (obj)).clear();
            return collection;
        }
    }

    public int size()
    {
        return a.size();
    }

    public String toString()
    {
        return a.toString();
    }
}
