// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class egi extends egy
    implements Serializable
{

    private static final long serialVersionUID = 0x21f766b1f568c81dL;
    transient Map a;
    transient int b;

    protected egi(Map map)
    {
        f.a(map.isEmpty());
        a = map;
    }

    static int a(egi egi1, int i)
    {
        i = egi1.b + i;
        egi1.b = i;
        return i;
    }

    static int a(egi egi1, Object obj)
    {
        obj = (Collection)ejr.c(egi1.a, obj);
        int i = 0;
        if (obj != null)
        {
            i = ((Collection) (obj)).size();
            ((Collection) (obj)).clear();
            egi1.b = egi1.b - i;
        }
        return i;
    }

    static Iterator a(egi egi1, Collection collection)
    {
        if (collection instanceof List)
        {
            return ((List)collection).listIterator();
        } else
        {
            return collection.iterator();
        }
    }

    static List a(egi egi1, Object obj, List list, egr egr1)
    {
        return egi1.a(obj, list, egr1);
    }

    private List a(Object obj, List list, egr egr1)
    {
        if (list instanceof RandomAccess)
        {
            return new ego(this, obj, list, egr1);
        } else
        {
            return new egt(this, obj, list, egr1);
        }
    }

    static Map a(egi egi1)
    {
        return egi1.a;
    }

    static int b(egi egi1)
    {
        int i = egi1.b;
        egi1.b = i - 1;
        return i;
    }

    static int b(egi egi1, int i)
    {
        i = egi1.b - i;
        egi1.b = i;
        return i;
    }

    static int c(egi egi1)
    {
        int i = egi1.b;
        egi1.b = i + 1;
        return i;
    }

    abstract Collection a();

    final Collection a(Object obj, Collection collection)
    {
        if (collection instanceof SortedSet)
        {
            return new egw(this, obj, (SortedSet)collection, null);
        }
        if (collection instanceof Set)
        {
            return new egv(this, obj, (Set)collection);
        }
        if (collection instanceof List)
        {
            return a(obj, (List)collection, null);
        } else
        {
            return new egr(this, obj, collection, null);
        }
    }

    public boolean a(Object obj)
    {
        return a.containsKey(obj);
    }

    public boolean a(Object obj, Object obj1)
    {
        Collection collection = (Collection)a.get(obj);
        if (collection == null)
        {
            collection = a();
            if (collection.add(obj1))
            {
                b = b + 1;
                a.put(obj, collection);
                return true;
            } else
            {
                throw new AssertionError("New Collection violated the Collection spec");
            }
        }
        if (collection.add(obj1))
        {
            b = b + 1;
            return true;
        } else
        {
            return false;
        }
    }

    public Collection b(Object obj)
    {
        Collection collection1 = (Collection)a.get(obj);
        Collection collection = collection1;
        if (collection1 == null)
        {
            collection = a();
        }
        return a(obj, collection);
    }

    public void b()
    {
        for (Iterator iterator = a.values().iterator(); iterator.hasNext(); ((Collection)iterator.next()).clear()) { }
        a.clear();
        b = 0;
    }

    final Set c()
    {
        if (a instanceof SortedMap)
        {
            return new egq(this, (SortedMap)a);
        } else
        {
            return new egm(this, a);
        }
    }

    final Map d()
    {
        if (a instanceof SortedMap)
        {
            return new egp(this, (SortedMap)a);
        } else
        {
            return new egj(this, a);
        }
    }
}
