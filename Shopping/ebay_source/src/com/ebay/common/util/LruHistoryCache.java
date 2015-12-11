// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LruHistoryCache extends LinkedHashSet
{

    private int mMaxEntries;

    public LruHistoryCache(int i)
    {
        super((int)((double)i * 1.5D));
        mMaxEntries = 100;
        mMaxEntries = i;
    }

    public boolean add(Object obj)
    {
        throw new UnsupportedOperationException("Use LruHistoryCache.remember() instead of .add()");
    }

    public ArrayList getRecent()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = iterator(); iterator.hasNext(); arraylist.add(0, iterator.next())) { }
        return arraylist;
    }

    public void remember(Object obj)
    {
        boolean flag;
        if (!remove(obj))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        super.add(obj);
        if (flag)
        {
            for (; size() > mMaxEntries; remove(iterator().next())) { }
        }
    }
}
