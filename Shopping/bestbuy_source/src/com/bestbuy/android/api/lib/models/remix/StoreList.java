// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.remix;

import java.util.ArrayList;
import java.util.Iterator;

public class StoreList
    implements Iterable
{

    private boolean hasNext;
    private ArrayList stores;
    private int totalStores;

    public StoreList()
    {
    }

    public ArrayList getStores()
    {
        return stores;
    }

    public int getTotalStores()
    {
        return totalStores;
    }

    public boolean isHasNext()
    {
        return hasNext;
    }

    public Iterator iterator()
    {
        return stores.iterator();
    }

    public void setHasNext(boolean flag)
    {
        hasNext = flag;
    }

    public void setStores(ArrayList arraylist)
    {
        stores = arraylist;
    }

    public void setTotalStores(int i)
    {
        totalStores = i;
    }
}
