// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

class egt extends egr
    implements List
{

    final egi e;

    egt(egi egi1, Object obj, List list, egr egr1)
    {
        e = egi1;
        super(egi1, obj, list, egr1);
    }

    public void add(int i, Object obj)
    {
        a();
        boolean flag = super.b.isEmpty();
        d().add(i, obj);
        egi.c(e);
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
            boolean flag1 = d().addAll(i, collection);
            flag = flag1;
            if (flag1)
            {
                i = super.b.size();
                egi.a(e, i - j);
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

    final List d()
    {
        return (List)super.b;
    }

    public Object get(int i)
    {
        a();
        return d().get(i);
    }

    public int indexOf(Object obj)
    {
        a();
        return d().indexOf(obj);
    }

    public int lastIndexOf(Object obj)
    {
        a();
        return d().lastIndexOf(obj);
    }

    public ListIterator listIterator()
    {
        a();
        return new egu(this);
    }

    public ListIterator listIterator(int i)
    {
        a();
        return new egu(this, i);
    }

    public Object remove(int i)
    {
        a();
        Object obj = d().remove(i);
        egi.b(e);
        b();
        return obj;
    }

    public Object set(int i, Object obj)
    {
        a();
        return d().set(i, obj);
    }

    public List subList(int i, int j)
    {
        a();
        egi egi1 = e;
        Object obj1 = super.a;
        List list = d().subList(i, j);
        Object obj;
        if (super.c == null)
        {
            obj = this;
        } else
        {
            obj = super.c;
        }
        return egi.a(egi1, obj1, list, ((egr) (obj)));
    }
}
