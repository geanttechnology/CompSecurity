// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            Platform

public final class ObjectArrays
{

    private static Object[] fillArray(Iterable iterable, Object aobj[])
    {
        int i = 0;
        for (iterable = iterable.iterator(); iterable.hasNext();)
        {
            aobj[i] = iterable.next();
            i++;
        }

        return aobj;
    }

    public static Object[] newArray(Object aobj[], int i)
    {
        return Platform.newArray(aobj, i);
    }

    static Object[] toArrayImpl(Collection collection)
    {
        return fillArray(collection, new Object[collection.size()]);
    }

    static Object[] toArrayImpl(Collection collection, Object aobj[])
    {
        int i = collection.size();
        Object aobj1[] = aobj;
        if (aobj.length < i)
        {
            aobj1 = newArray(aobj, i);
        }
        fillArray(collection, aobj1);
        if (aobj1.length > i)
        {
            aobj1[i] = null;
        }
        return aobj1;
    }
}
