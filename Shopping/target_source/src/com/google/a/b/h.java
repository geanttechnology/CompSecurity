// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.a.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

// Referenced classes of package com.google.a.b:
//            g, o, l, p, 
//            k, t, s

public abstract class h extends g
    implements List, RandomAccess
{

    private static final h a;

    h()
    {
    }

    public static h a(Iterable iterable)
    {
        com.google.a.a.f.a(iterable);
        if (iterable instanceof Collection)
        {
            return a((Collection)iterable);
        } else
        {
            return a(iterable.iterator());
        }
    }

    public static h a(Object obj)
    {
        return new p(obj);
    }

    public static h a(Object obj, Object obj1)
    {
        return b(new Object[] {
            obj, obj1
        });
    }

    public static h a(Object obj, Object obj1, Object obj2, Object obj3, Object obj4)
    {
        return b(new Object[] {
            obj, obj1, obj2, obj3, obj4
        });
    }

    public static h a(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7)
    {
        return b(new Object[] {
            obj, obj1, obj2, obj3, obj4, obj5, obj6, obj7
        });
    }

    public static h a(Collection collection)
    {
        if (collection instanceof g)
        {
            h h1 = ((g)collection).d();
            collection = h1;
            if (h1.b())
            {
                collection = a(h1.toArray());
            }
            return collection;
        } else
        {
            return b(collection.toArray());
        }
    }

    public static h a(Iterator iterator1)
    {
        if (!iterator1.hasNext())
        {
            return f();
        }
        Object obj = iterator1.next();
    /* block-local class not found */
    class a {}

        if (!iterator1.hasNext())
        {
            return a(obj);
        } else
        {
            return (new a()).c(obj).b(iterator1).a();
        }
    }

    static h a(Object aobj[])
    {
        return b(aobj, aobj.length);
    }

    private static transient h b(Object aobj[])
    {
        return a(l.a(aobj));
    }

    static h b(Object aobj[], int i)
    {
        switch (i)
        {
        default:
            Object aobj1[] = aobj;
            if (i < aobj.length)
            {
                aobj1 = l.b(aobj, i);
            }
            return new o(aobj1);

        case 0: // '\0'
            return f();

        case 1: // '\001'
            return new p(aobj[0]);
        }
    }

    public static h f()
    {
        return a;
    }

    int a(Object aobj[], int i)
    {
        int i1 = size();
        for (int j = 0; j < i1; j++)
        {
            aobj[i + j] = get(j);
        }

        return i + i1;
    }

    public h a(int i, int j)
    {
        com.google.a.a.f.a(i, j, size());
        switch (j - i)
        {
        default:
            return b(i, j);

        case 0: // '\0'
            return f();

        case 1: // '\001'
            return a(get(i));
        }
    }

    public t a(int i)
    {
        return new _cls1(size(), i);
    }

    public final void add(int i, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(int i, Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    h b(int i, int j)
    {
    /* block-local class not found */
    class b {}

        return new b(i, j - i);
    }

    public s c()
    {
        return g();
    }

    public boolean contains(Object obj)
    {
        return indexOf(obj) >= 0;
    }

    public final h d()
    {
        return this;
    }

    public boolean equals(Object obj)
    {
        return k.a(this, obj);
    }

    public t g()
    {
        return a(0);
    }

    public int hashCode()
    {
        int j = 1;
        int i1 = size();
        for (int i = 0; i < i1; i++)
        {
            j = ~~(j * 31 + get(i).hashCode());
        }

        return j;
    }

    public int indexOf(Object obj)
    {
        if (obj == null)
        {
            return -1;
        } else
        {
            return k.b(this, obj);
        }
    }

    public Iterator iterator()
    {
        return c();
    }

    public int lastIndexOf(Object obj)
    {
        if (obj == null)
        {
            return -1;
        } else
        {
            return k.c(this, obj);
        }
    }

    public ListIterator listIterator()
    {
        return g();
    }

    public ListIterator listIterator(int i)
    {
        return a(i);
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

    static 
    {
        a = new o(l.a);
    }

    /* member class not found */
    class _cls1 {}

}
