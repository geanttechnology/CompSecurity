// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class dg
    implements Set
{

    private de a;

    dg(de de1)
    {
        a = de1;
        super();
    }

    public final boolean add(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection)
    {
        int i = a.a();
        java.util.Map.Entry entry;
        for (collection = collection.iterator(); collection.hasNext(); a.a(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)collection.next();
        }

        return i != a.a();
    }

    public final void clear()
    {
        a.c();
    }

    public final boolean contains(Object obj)
    {
        if (obj instanceof java.util.Map.Entry)
        {
            obj = (java.util.Map.Entry)obj;
            int i = a.a(((java.util.Map.Entry) (obj)).getKey());
            if (i >= 0)
            {
                return db.a(a.a(i, 1), ((java.util.Map.Entry) (obj)).getValue());
            }
        }
        return false;
    }

    public final boolean containsAll(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext();)
        {
            if (!contains(collection.next()))
            {
                return false;
            }
        }

        return true;
    }

    public final boolean equals(Object obj)
    {
        return de.a(this, obj);
    }

    public final int hashCode()
    {
        int j = a.a() - 1;
        int i = 0;
        while (j >= 0) 
        {
            Object obj = a.a(j, 0);
            Object obj1 = a.a(j, 1);
            int k;
            int l;
            if (obj == null)
            {
                k = 0;
            } else
            {
                k = obj.hashCode();
            }
            if (obj1 == null)
            {
                l = 0;
            } else
            {
                l = obj1.hashCode();
            }
            j--;
            i += l ^ k;
        }
        return i;
    }

    public final boolean isEmpty()
    {
        return a.a() == 0;
    }

    public final Iterator iterator()
    {
        return new di(a);
    }

    public final boolean remove(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final int size()
    {
        return a.a();
    }

    public final Object[] toArray()
    {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray(Object aobj[])
    {
        throw new UnsupportedOperationException();
    }
}
