// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class eic extends ehr
    implements List, RandomAccess
{

    eic()
    {
    }

    public static eic a(Iterable iterable)
    {
        f.b(iterable);
        if (iterable instanceof Collection)
        {
            return a(ehc.a(iterable));
        }
        iterable = iterable.iterator();
        if (!iterable.hasNext())
        {
            return ehf.a;
        }
        Object obj = iterable.next();
        if (!iterable.hasNext())
        {
            return a(obj);
        } else
        {
            return (new eie()).b(obj).b(iterable).a();
        }
    }

    public static eic a(Object obj)
    {
        return new eky(obj);
    }

    public static eic a(Collection collection)
    {
        if (collection instanceof ehr)
        {
            eic eic1 = ((ehr)collection).c();
            collection = eic1;
            if (eic1.a())
            {
                collection = b(eic1);
            }
            return collection;
        } else
        {
            return b(collection);
        }
    }

    public static eic a(Object aobj[])
    {
        switch (aobj.length)
        {
        default:
            return c((Object[])((Object []) (aobj)).clone());

        case 0: // '\0'
            return ehf.a;

        case 1: // '\001'
            return new eky(aobj[0]);
        }
    }

    private static eic b(Collection collection)
    {
        return b(collection.toArray());
    }

    static eic b(Object aobj[])
    {
        switch (aobj.length)
        {
        default:
            return c(aobj);

        case 0: // '\0'
            return ehf.a;

        case 1: // '\001'
            return new eky(aobj[0]);
        }
    }

    private static transient eic c(Object aobj[])
    {
        for (int i = 0; i < aobj.length; i++)
        {
            eka.a(aobj[i], i);
        }

        return new ekl(aobj);
    }

    public static eic g()
    {
        return ehf.a;
    }

    public static eie h()
    {
        return new eie();
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public eic a(int i, int j)
    {
        f.a(i, j, size());
        switch (j - i)
        {
        default:
            return b(i, j);

        case 0: // '\0'
            return ehf.a;

        case 1: // '\001'
            return a(get(i));
        }
    }

    public eln a(int i)
    {
        return new eid(this, size(), i);
    }

    public final void add(int i, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(int i, Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    eic b(int i, int j)
    {
        return new eii(this, i, j - i);
    }

    public elm b()
    {
        return d();
    }

    public final eic c()
    {
        return this;
    }

    public boolean contains(Object obj)
    {
        return indexOf(obj) >= 0;
    }

    public eln d()
    {
        return a(0);
    }

    public boolean equals(Object obj)
    {
        return a.a(this, obj);
    }

    public int hashCode()
    {
        return a.c(this);
    }

    public int indexOf(Object obj)
    {
        if (obj == null)
        {
            return -1;
        } else
        {
            return a.b(this, obj);
        }
    }

    public Iterator iterator()
    {
        return b();
    }

    public int lastIndexOf(Object obj)
    {
        if (obj == null)
        {
            return -1;
        } else
        {
            return a.c(this, obj);
        }
    }

    public ListIterator listIterator()
    {
        return d();
    }

    public ListIterator listIterator(int i)
    {
        return a(i);
    }

    public eic m_()
    {
        return new eif(this);
    }

    public final Object remove(int i)
    {
        throw new UnsupportedOperationException();
    }

    public final Object set(int i, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public List subList(int i, int j)
    {
        return a(i, j);
    }

    Object writeReplace()
    {
        return new eih(toArray());
    }
}
