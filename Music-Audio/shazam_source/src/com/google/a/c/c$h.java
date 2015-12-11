// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.google.a.c:
//            c

private class n extends n
    implements List
{
    private final class a extends c.g.a
        implements ListIterator
    {

        final c.h d;

        private ListIterator b()
        {
            a();
            return (ListIterator)super.a;
        }

        public final void add(Object obj)
        {
            boolean flag = d.isEmpty();
            b().add(obj);
            c.c(d.g);
            if (flag)
            {
                d.c();
            }
        }

        public final boolean hasPrevious()
        {
            return b().hasPrevious();
        }

        public final int nextIndex()
        {
            return b().nextIndex();
        }

        public final Object previous()
        {
            return b().previous();
        }

        public final int previousIndex()
        {
            return b().previousIndex();
        }

        public final void set(Object obj)
        {
            b().set(obj);
        }

        a()
        {
            d = c.h.this;
            super(c.h.this);
        }

        public a(int i)
        {
            d = c.h.this;
            super(c.h.this, ((List)c.h.this.c).listIterator(i));
        }
    }


    final c g;

    public void add(int i, Object obj)
    {
        a();
        boolean flag = super.c.isEmpty();
        ((List)super.c).add(i, obj);
        c.c(g);
        if (flag)
        {
            c();
        }
    }

    public boolean addAll(int i, Collection collection)
    {
        boolean flag;
        if (collection.isEmpty())
        {
            flag = false;
        } else
        {
            int j = size();
            boolean flag1 = ((List)super.c).addAll(i, collection);
            flag = flag1;
            if (flag1)
            {
                i = super.c.size();
                c.a(g, i - j);
                flag = flag1;
                if (j == 0)
                {
                    c();
                    return flag1;
                }
            }
        }
        return flag;
    }

    public Object get(int i)
    {
        a();
        return ((List)super.c).get(i);
    }

    public int indexOf(Object obj)
    {
        a();
        return ((List)super.c).indexOf(obj);
    }

    public int lastIndexOf(Object obj)
    {
        a();
        return ((List)super.c).lastIndexOf(obj);
    }

    public ListIterator listIterator()
    {
        a();
        return new a();
    }

    public ListIterator listIterator(int i)
    {
        a();
        return new a(i);
    }

    public Object remove(int i)
    {
        a();
        Object obj = ((List)super.c).remove(i);
        c.b(g);
        b();
        return obj;
    }

    public Object set(int i, Object obj)
    {
        a();
        return ((List)super.c).set(i, obj);
    }

    public List subList(int i, int j)
    {
        a();
        c c1 = g;
        Object obj1 = super.b;
        List list = ((List)super.c).subList(i, j);
        Object obj;
        if (super.d == null)
        {
            obj = this;
        } else
        {
            obj = super.d;
        }
        return c.a(c1, obj1, list, ((d) (obj)));
    }

    n(c c1, Object obj, List list, Iterator iterator)
    {
        g = c1;
        super(c1, obj, list, iterator);
    }
}
