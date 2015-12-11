// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

public abstract class eiz extends ejd
    implements SortedMap
{

    private static final Comparator a;
    private static final eiz b;
    private static final long serialVersionUID = 0L;

    eiz()
    {
    }

    static eiz a(Comparator comparator1)
    {
        if (ekb.a().equals(comparator1))
        {
            return b;
        } else
        {
            return new ehh(comparator1);
        }
    }

    static eiz a(Comparator comparator1, Collection collection)
    {
        if (collection.isEmpty())
        {
            return a(comparator1);
        }
        eie eie1 = eic.h();
        eie eie2 = eic.h();
        java.util.Map.Entry entry;
        for (collection = collection.iterator(); collection.hasNext(); eie2.b(entry.getValue()))
        {
            entry = (java.util.Map.Entry)collection.next();
            eie1.b(entry.getKey());
        }

        return new eks(new ekv(eie1.a(), comparator1), eie2.a());
    }

    static void a(List list, Comparator comparator1)
    {
        Collections.sort(list, new eja(comparator1));
    }

    static void b(List list, Comparator comparator1)
    {
        for (int i = 1; i < list.size(); i++)
        {
            if (comparator1.compare(((java.util.Map.Entry)list.get(i - 1)).getKey(), ((java.util.Map.Entry)list.get(i)).getKey()) == 0)
            {
                throw new IllegalArgumentException((new StringBuilder("Duplicate keys in mappings ")).append(list.get(i - 1)).append(" and ").append(list.get(i)).toString());
            }
        }

    }

    public abstract eiz a(Object obj, boolean flag);

    public eiu b()
    {
        return super.b();
    }

    public abstract eiz b(Object obj, boolean flag);

    public Comparator comparator()
    {
        return n_().comparator();
    }

    public boolean containsValue(Object obj)
    {
        return f().contains(obj);
    }

    public eiu d()
    {
        return n_();
    }

    boolean e()
    {
        return n_().a() || f().a();
    }

    public Set entrySet()
    {
        return b();
    }

    public abstract ehr f();

    public Object firstKey()
    {
        return n_().first();
    }

    public SortedMap headMap(Object obj)
    {
        return a(obj, false);
    }

    public Set keySet()
    {
        return n_();
    }

    public Object lastKey()
    {
        return n_().last();
    }

    public abstract eje n_();

    public int size()
    {
        return f().size();
    }

    public SortedMap subMap(Object obj, Object obj1)
    {
        f.b(obj);
        f.b(obj1);
        boolean flag;
        if (comparator().compare(obj, obj1) <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag, "expected fromKey <= toKey but %s > %s", new Object[] {
            obj, obj1
        });
        return a(obj1, false).b(obj, true);
    }

    public SortedMap tailMap(Object obj)
    {
        return b(obj, true);
    }

    public Collection values()
    {
        return f();
    }

    Object writeReplace()
    {
        return new ejc(this);
    }

    static 
    {
        a = ekb.a();
        b = new ehh(a);
    }
}
