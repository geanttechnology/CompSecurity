// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Iterator;

abstract class eiv extends eiu
{

    private transient Object a[];

    eiv(Object aobj[])
    {
        a = aobj;
    }

    final boolean a()
    {
        return false;
    }

    public final elm b()
    {
        return c().b();
    }

    public boolean containsAll(Collection collection)
    {
        if (collection != this)
        {
            if (!(collection instanceof eiv))
            {
                return super.containsAll(collection);
            }
            if (collection.size() > size())
            {
                return false;
            }
            collection = ((Collection) (((eiv)collection).a));
            int j = collection.length;
            int i = 0;
            while (i < j) 
            {
                if (!contains(collection[i]))
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    final eic f()
    {
        return new ekc(this, a);
    }

    public boolean isEmpty()
    {
        return false;
    }

    public Iterator iterator()
    {
        return c().b();
    }

    public int size()
    {
        return a.length;
    }

    public Object[] toArray()
    {
        return c().toArray();
    }

    public Object[] toArray(Object aobj[])
    {
        return c().toArray(aobj);
    }
}
