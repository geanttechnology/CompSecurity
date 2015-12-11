// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class CollectionUtils
{

    private CollectionUtils()
    {
    }

    public static boolean containsAny(Collection collection, Collection collection1)
    {
        Collection collection2;
        if (collection.size() < collection1.size())
        {
            collection2 = collection;
            collection = collection1;
        } else
        {
            collection2 = collection1;
        }
        for (collection1 = collection2.iterator(); collection1.hasNext();)
        {
            if (collection.contains(collection1.next()))
            {
                return true;
            }
        }

        return false;
    }

    public static List createList(Object obj)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(obj);
        return arraylist;
    }

    public static List createList(Object obj, Object obj1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(obj);
        arraylist.add(obj1);
        return arraylist;
    }

    public static List createList(Object obj, Object obj1, Object obj2)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(obj);
        arraylist.add(obj1);
        arraylist.add(obj2);
        return arraylist;
    }

    public static boolean nullOrEmpty(Collection collection)
    {
        return collection == null || collection.isEmpty();
    }
}
