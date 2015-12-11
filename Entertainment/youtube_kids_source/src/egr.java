// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;

class egr extends AbstractCollection
{

    final Object a;
    Collection b;
    final egr c;
    final egi d;
    private Collection e;

    egr(egi egi1, Object obj, Collection collection, egr egr1)
    {
        d = egi1;
        super();
        a = obj;
        b = collection;
        c = egr1;
        if (egr1 == null)
        {
            egi1 = null;
        } else
        {
            egi1 = egr1.b;
        }
        e = egi1;
    }

    final void a()
    {
        if (c != null)
        {
            c.a();
            if (c.b != e)
            {
                throw new ConcurrentModificationException();
            }
        } else
        if (b.isEmpty())
        {
            Collection collection = (Collection)egi.a(d).get(a);
            if (collection != null)
            {
                b = collection;
            }
        }
    }

    public boolean add(Object obj)
    {
        a();
        boolean flag = b.isEmpty();
        boolean flag1 = b.add(obj);
        if (flag1)
        {
            egi.c(d);
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
            boolean flag1 = b.addAll(collection);
            flag = flag1;
            if (flag1)
            {
                int j = b.size();
                egi.a(d, j - i);
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
        if (c != null)
        {
            c.b();
        } else
        if (b.isEmpty())
        {
            egi.a(d).remove(a);
            return;
        }
    }

    final void c()
    {
        if (c != null)
        {
            c.c();
            return;
        } else
        {
            egi.a(d).put(a, b);
            return;
        }
    }

    public void clear()
    {
        int i = size();
        if (i == 0)
        {
            return;
        } else
        {
            b.clear();
            egi.b(d, i);
            b();
            return;
        }
    }

    public boolean contains(Object obj)
    {
        a();
        return b.contains(obj);
    }

    public boolean containsAll(Collection collection)
    {
        a();
        return b.containsAll(collection);
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        } else
        {
            a();
            return b.equals(obj);
        }
    }

    public int hashCode()
    {
        a();
        return b.hashCode();
    }

    public Iterator iterator()
    {
        a();
        return new egs(this);
    }

    public boolean remove(Object obj)
    {
        a();
        boolean flag = b.remove(obj);
        if (flag)
        {
            egi.b(d);
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
            boolean flag1 = b.removeAll(collection);
            flag = flag1;
            if (flag1)
            {
                int j = b.size();
                egi.a(d, j - i);
                b();
                return flag1;
            }
        }
        return flag;
    }

    public boolean retainAll(Collection collection)
    {
        f.b(collection);
        int i = size();
        boolean flag = b.retainAll(collection);
        if (flag)
        {
            int j = b.size();
            egi.a(d, j - i);
            b();
        }
        return flag;
    }

    public int size()
    {
        a();
        return b.size();
    }

    public String toString()
    {
        a();
        return b.toString();
    }
}
