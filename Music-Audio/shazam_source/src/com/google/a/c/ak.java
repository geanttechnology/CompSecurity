// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

// Referenced classes of package com.google.a.c:
//            al, aw, p, aq, 
//            am, z, aj, ad

public abstract class ak extends al
    implements NavigableMap
{

    private static final Comparator a;
    private static final ak b;
    private transient ak c;

    ak()
    {
    }

    ak(ak ak1)
    {
        c = ak1;
    }

    private ak a(Object obj, Object obj1)
    {
        com.google.a.a.g.a(obj);
        com.google.a.a.g.a(obj1);
        boolean flag;
        if (comparator().compare(obj, obj1) <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.a.a.g.a(flag, "expected fromKey <= toKey but %s > %s", new Object[] {
            obj, obj1
        });
        return a(obj1).b(obj);
    }

    public abstract ak a(Object obj);

    public aj b()
    {
        return super.b();
    }

    public abstract ak b(Object obj);

    public java.util.Map.Entry ceilingEntry(Object obj)
    {
        return b(obj).firstEntry();
    }

    public Object ceilingKey(Object obj)
    {
        return aq.a(ceilingEntry(obj));
    }

    public Comparator comparator()
    {
        return f_().comparator();
    }

    public boolean containsValue(Object obj)
    {
        return f().contains(obj);
    }

    public aj d()
    {
        return f_();
    }

    public NavigableSet descendingKeySet()
    {
        return f_().c_();
    }

    public NavigableMap descendingMap()
    {
        ak ak2 = c;
        ak ak1 = ak2;
        if (ak2 == null)
        {
            ak1 = g();
            c = ak1;
        }
        return ak1;
    }

    boolean e()
    {
        return f_().e() || f().e();
    }

    public Set entrySet()
    {
        return b();
    }

    public abstract z f();

    public abstract am f_();

    public java.util.Map.Entry firstEntry()
    {
        if (isEmpty())
        {
            return null;
        } else
        {
            return (java.util.Map.Entry)b().b().get(0);
        }
    }

    public Object firstKey()
    {
        return f_().first();
    }

    public java.util.Map.Entry floorEntry(Object obj)
    {
        return a(obj).lastEntry();
    }

    public Object floorKey(Object obj)
    {
        return aq.a(floorEntry(obj));
    }

    abstract ak g();

    public NavigableMap headMap(Object obj, boolean flag)
    {
        return a(obj);
    }

    public SortedMap headMap(Object obj)
    {
        return a(obj);
    }

    public java.util.Map.Entry higherEntry(Object obj)
    {
        return b(obj).firstEntry();
    }

    public Object higherKey(Object obj)
    {
        return aq.a(higherEntry(obj));
    }

    public Set keySet()
    {
        return f_();
    }

    public java.util.Map.Entry lastEntry()
    {
        if (isEmpty())
        {
            return null;
        } else
        {
            return (java.util.Map.Entry)b().b().get(size() - 1);
        }
    }

    public Object lastKey()
    {
        return f_().last();
    }

    public java.util.Map.Entry lowerEntry(Object obj)
    {
        return a(obj).lastEntry();
    }

    public Object lowerKey(Object obj)
    {
        return aq.a(lowerEntry(obj));
    }

    public NavigableSet navigableKeySet()
    {
        return f_();
    }

    public final java.util.Map.Entry pollFirstEntry()
    {
        throw new UnsupportedOperationException();
    }

    public final java.util.Map.Entry pollLastEntry()
    {
        throw new UnsupportedOperationException();
    }

    public int size()
    {
        return f().size();
    }

    public NavigableMap subMap(Object obj, boolean flag, Object obj1, boolean flag1)
    {
        return a(obj, obj1);
    }

    public SortedMap subMap(Object obj, Object obj1)
    {
        return a(obj, obj1);
    }

    public NavigableMap tailMap(Object obj, boolean flag)
    {
        return b(obj);
    }

    public SortedMap tailMap(Object obj)
    {
        return b(obj);
    }

    public Collection values()
    {
        return f();
    }

    static 
    {
        a = aw.b();
        b = new p(a);
    }
}
