// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public abstract class eje extends ejh
    implements ela, SortedSet
{

    private static final Comparator c;
    private static final eje d;
    final transient Comparator a;

    eje(Comparator comparator1)
    {
        a = comparator1;
    }

    static eje a(Comparator comparator1)
    {
        if (c.equals(comparator1))
        {
            return d;
        } else
        {
            return new ehi(comparator1);
        }
    }

    static transient eje a(Comparator comparator1, int i, Object aobj[])
    {
        int j = 0;
        if (i != 0)
        {
            for (j = 0; j < i; j++)
            {
                eka.a(aobj[j], j);
            }

            Arrays.sort(aobj, 0, i, comparator1);
            int k = 1;
            j = 1;
            for (; k < i; k++)
            {
                Object obj = aobj[k];
                if (comparator1.compare(obj, aobj[j - 1]) != 0)
                {
                    int l = j + 1;
                    aobj[j] = obj;
                    j = l;
                }
            }

            Arrays.fill(aobj, j, i, null);
        }
        if (j == 0)
        {
            return a(comparator1);
        }
        Object aobj1[] = aobj;
        if (j < aobj.length)
        {
            aobj1 = eka.b(aobj, j);
        }
        return new ekv(eic.b(aobj1), comparator1);
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        throw new InvalidObjectException("Use SerializedForm");
    }

    abstract int a(Object obj);

    final int a(Object obj, Object obj1)
    {
        return a.compare(obj, obj1);
    }

    abstract eje a(Object obj, boolean flag);

    abstract eje a(Object obj, boolean flag, Object obj1, boolean flag1);

    abstract eje b(Object obj, boolean flag);

    public abstract elm b();

    public Comparator comparator()
    {
        return a;
    }

    public abstract elm e();

    public Object first()
    {
        return b().next();
    }

    public SortedSet headSet(Object obj)
    {
        return a(f.b(obj), false);
    }

    public Iterator iterator()
    {
        return b();
    }

    public Object last()
    {
        return e().next();
    }

    public SortedSet subSet(Object obj, Object obj1)
    {
        f.b(obj);
        f.b(obj1);
        boolean flag;
        if (a.compare(obj, obj1) <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag);
        return a(obj, true, obj1, false);
    }

    public SortedSet tailSet(Object obj)
    {
        return b(f.b(obj), true);
    }

    Object writeReplace()
    {
        return new ejg(a, toArray());
    }

    static 
    {
        c = ekb.a();
        d = new ehi(c);
    }
}
