// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.f;
import com.google.a.a.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

// Referenced classes of package com.google.a.c:
//            z, ay, av, bg, 
//            ap, bk, bl, a

public abstract class ad extends z
    implements List, RandomAccess
{
    public static final class a extends z.a
    {

        public final ad a()
        {
            return ad.b(a, b);
        }

        public final volatile z.a a(Object obj)
        {
            super.a(obj);
            return this;
        }

        public final volatile z.b a(Iterator iterator1)
        {
            super.a(iterator1);
            return this;
        }

        public final z.b b(Object obj)
        {
            super.a(obj);
            return this;
        }

        public final a c(Object obj)
        {
            super.a(obj);
            return this;
        }

        public a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
        }
    }

    final class b extends ad
    {

        final transient int b;
        final transient int c;
        final ad d;

        public final ad a(int i, int j)
        {
            com.google.a.a.g.a(i, j, c);
            return d.a(b + i, b + j);
        }

        final boolean e()
        {
            return true;
        }

        public final Object get(int i)
        {
            com.google.a.a.g.a(i, c);
            return d.get(b + i);
        }

        public final Iterator iterator()
        {
            return a();
        }

        public final ListIterator listIterator()
        {
            return a(0);
        }

        public final ListIterator listIterator(int i)
        {
            return a(i);
        }

        public final int size()
        {
            return c;
        }

        public final List subList(int i, int j)
        {
            return a(i, j);
        }

        b(int i, int j)
        {
            d = ad.this;
            super();
            b = i;
            c = j;
        }
    }


    static final ad a;

    ad()
    {
    }

    public static ad a(Object obj)
    {
        return new bg(obj);
    }

    public static ad a(Collection collection)
    {
        if (collection instanceof z)
        {
            ad ad1 = ((z)collection).b();
            collection = ad1;
            if (ad1.e())
            {
                collection = ((Collection) (ad1.toArray()));
                collection = b(collection, collection.length);
            }
            return collection;
        } else
        {
            collection = ((Collection) (av.a(collection.toArray())));
            return b(collection, collection.length);
        }
    }

    public static ad a(Object aobj[])
    {
        switch (aobj.length)
        {
        default:
            return new ay(av.a((Object[])((Object []) (aobj)).clone()));

        case 0: // '\0'
            return a;

        case 1: // '\001'
            return new bg(aobj[0]);
        }
    }

    public static ad b(Object aobj[])
    {
        return b(aobj, aobj.length);
    }

    static ad b(Object aobj[], int i)
    {
        switch (i)
        {
        default:
            Object aobj1[] = aobj;
            if (i < aobj.length)
            {
                aobj1 = av.b(aobj, i);
            }
            return new ay(aobj1);

        case 0: // '\0'
            return a;

        case 1: // '\001'
            return new bg(aobj[0]);
        }
    }

    public static ad d()
    {
        return a;
    }

    public static a g()
    {
        return new a();
    }

    int a(Object aobj[], int i)
    {
        int k = size();
        for (int j = 0; j < k; j++)
        {
            aobj[i + j] = get(j);
        }

        return i + k;
    }

    public ad a(int i, int j)
    {
        com.google.a.a.g.a(i, j, size());
        switch (j - i)
        {
        default:
            return b(i, j);

        case 0: // '\0'
            return a;

        case 1: // '\001'
            return a(get(i));
        }
    }

    public bk a()
    {
        return a(0);
    }

    public bl a(int i)
    {
        return new com.google.a.c.a(size(), i) {

            final ad a;

            protected final Object a(int j)
            {
                return a.get(j);
            }

            
            {
                a = ad.this;
                super(i, j);
            }
        };
    }

    public final void add(int i, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(int i, Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final ad b()
    {
        return this;
    }

    ad b(int i, int j)
    {
        return new b(i, j - i);
    }

    public boolean contains(Object obj)
    {
        return indexOf(obj) >= 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != com.google.a.a.g.a(this))
        {
            if (!(obj instanceof List) || (size() != ((List) (obj = (List)obj)).size() || !ap.a(iterator(), ((List) (obj)).iterator())))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = 1;
        int k = size();
        for (int i = 0; i < k; i++)
        {
            j = ~~(j * 31 + get(i).hashCode());
        }

        return j;
    }

    public int indexOf(Object obj)
    {
label0:
        {
            if (obj == null)
            {
                break label0;
            }
            ListIterator listiterator = listIterator();
            do
            {
                if (!listiterator.hasNext())
                {
                    break label0;
                }
            } while (!f.a(obj, listiterator.next()));
            return listiterator.previousIndex();
        }
        return -1;
    }

    public Iterator iterator()
    {
        return a();
    }

    public int lastIndexOf(Object obj)
    {
label0:
        {
            if (obj == null)
            {
                break label0;
            }
            ListIterator listiterator = listIterator(size());
            do
            {
                if (!listiterator.hasPrevious())
                {
                    break label0;
                }
            } while (!f.a(obj, listiterator.previous()));
            return listiterator.nextIndex();
        }
        return -1;
    }

    public ListIterator listIterator()
    {
        return a(0);
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
        a = new ay(av.a);
    }
}
