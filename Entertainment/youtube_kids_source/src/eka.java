// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public final class eka
{

    static final Object a[] = new Object[0];

    static Object a(Object obj, int i)
    {
        if (obj == null)
        {
            throw new NullPointerException((new StringBuilder("at index ")).append(i).toString());
        } else
        {
            return obj;
        }
    }

    public static Object[] a(Class class1, int i)
    {
        return (Object[])Array.newInstance(class1, i);
    }

    private static Object[] a(Iterable iterable, Object aobj[])
    {
        int i = 0;
        for (iterable = iterable.iterator(); iterable.hasNext();)
        {
            aobj[i] = iterable.next();
            i++;
        }

        return aobj;
    }

    static Object[] a(Collection collection)
    {
        return a(((Iterable) (collection)), new Object[collection.size()]);
    }

    static Object[] a(Collection collection, Object aobj[])
    {
        int i = collection.size();
        Object aobj1[] = aobj;
        if (aobj.length < i)
        {
            aobj1 = a.a(aobj, i);
        }
        a(((Iterable) (collection)), aobj1);
        if (aobj1.length > i)
        {
            aobj1[i] = null;
        }
        return aobj1;
    }

    public static Object[] a(Object aobj[], int i)
    {
        return a.a(aobj, i);
    }

    static Object[] b(Object aobj[], int i)
    {
        Object aobj1[] = a.a(aobj, i);
        System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj1)), 0, Math.min(aobj.length, i));
        return aobj1;
    }

}
