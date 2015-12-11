// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.a.c:
//            c

private class e extends AbstractCollection
{
    class a
        implements Iterator
    {

        final Iterator a;
        final Collection b;
        final c.g c;

        final void a()
        {
            c.a();
            if (c.c != b)
            {
                throw new ConcurrentModificationException();
            } else
            {
                return;
            }
        }

        public boolean hasNext()
        {
            a();
            return a.hasNext();
        }

        public Object next()
        {
            a();
            return a.next();
        }

        public void remove()
        {
            a.remove();
            com.google.a.c.c.b(c.f);
            c.b();
        }

        a()
        {
            c = c.g.this;
            super();
            b = c.c;
            a = com.google.a.c.c.a(c.g.this.c);
        }

        a(Iterator iterator1)
        {
            c = c.g.this;
            super();
            b = c.c;
            a = iterator1;
        }
    }


    final Object b;
    Collection c;
    final n d;
    final Collection e;
    final c f;

    final void a()
    {
        if (d != null)
        {
            d.a();
            if (d.c != e)
            {
                throw new ConcurrentModificationException();
            }
        } else
        if (c.isEmpty())
        {
            Collection collection = (Collection)com.google.a.c.c.a(f).get(b);
            if (collection != null)
            {
                c = collection;
            }
        }
    }

    public boolean add(Object obj)
    {
        a();
        boolean flag = c.isEmpty();
        boolean flag1 = c.add(obj);
        if (flag1)
        {
            com.google.a.c.c.c(f);
            if (flag)
            {
                c();
            }
        }
        return flag1;
    }

    public boolean addAll(Collection collection)
    {
        boolean flag;
        if (collection.isEmpty())
        {
            flag = false;
        } else
        {
            int i = size();
            boolean flag1 = c.addAll(collection);
            flag = flag1;
            if (flag1)
            {
                int j = c.size();
                com.google.a.c.c.a(f, j - i);
                flag = flag1;
                if (i == 0)
                {
                    c();
                    return flag1;
                }
            }
        }
        return flag;
    }

    final void b()
    {
        c c1;
        for (c1 = this; c1.d != null; c1 = c1.d) { }
        if (c1.c.isEmpty())
        {
            com.google.a.c.c.a(c1.f).remove(c1.b);
        }
    }

    final void c()
    {
        b b1;
        for (b1 = this; b1.d != null; b1 = b1.d) { }
        com.google.a.c.c.a(b1.f).put(b1.b, b1.c);
    }

    public void clear()
    {
        int i = size();
        if (i == 0)
        {
            return;
        } else
        {
            c.clear();
            com.google.a.c.c.b(f, i);
            b();
            return;
        }
    }

    public boolean contains(Object obj)
    {
        a();
        return c.contains(obj);
    }

    public boolean containsAll(Collection collection)
    {
        a();
        return c.containsAll(collection);
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        } else
        {
            a();
            return c.equals(obj);
        }
    }

    public int hashCode()
    {
        a();
        return c.hashCode();
    }

    public Iterator iterator()
    {
        a();
        return new a();
    }

    public boolean remove(Object obj)
    {
        a();
        boolean flag = c.remove(obj);
        if (flag)
        {
            com.google.a.c.c.b(f);
            b();
        }
        return flag;
    }

    public boolean removeAll(Collection collection)
    {
        boolean flag;
        if (collection.isEmpty())
        {
            flag = false;
        } else
        {
            int i = size();
            boolean flag1 = c.removeAll(collection);
            flag = flag1;
            if (flag1)
            {
                int j = c.size();
                com.google.a.c.c.a(f, j - i);
                b();
                return flag1;
            }
        }
        return flag;
    }

    public boolean retainAll(Collection collection)
    {
        com.google.a.a.g.a(collection);
        int i = size();
        boolean flag = c.retainAll(collection);
        if (flag)
        {
            int j = c.size();
            com.google.a.c.c.a(f, j - i);
            b();
        }
        return flag;
    }

    public int size()
    {
        a();
        return c.size();
    }

    public String toString()
    {
        a();
        return c.toString();
    }

    n(c c1, Object obj, Collection collection, n n)
    {
        f = c1;
        super();
        b = obj;
        c = collection;
        d = n;
        if (n == null)
        {
            c1 = null;
        } else
        {
            c1 = n.c;
        }
        e = c1;
    }
}
