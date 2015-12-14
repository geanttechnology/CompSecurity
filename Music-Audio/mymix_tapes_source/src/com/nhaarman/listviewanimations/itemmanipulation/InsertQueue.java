// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class InsertQueue
{

    private final Set mActiveIndexes = new HashSet();
    private final AnimateAdditionAdapter.Insertable mInsertable;
    private final List mPendingItemsToInsert = new ArrayList();

    public InsertQueue(AnimateAdditionAdapter.Insertable insertable)
    {
        mInsertable = insertable;
    }

    private void insertPending()
    {
        Pair pair;
        for (Iterator iterator = mPendingItemsToInsert.iterator(); iterator.hasNext(); mInsertable.add(((Integer)pair.first).intValue(), pair.second))
        {
            pair = (Pair)iterator.next();
            Iterator iterator1 = mActiveIndexes.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                AtomicInteger atomicinteger = (AtomicInteger)iterator1.next();
                if (atomicinteger.intValue() >= ((Integer)pair.first).intValue())
                {
                    atomicinteger.incrementAndGet();
                }
            } while (true);
            mActiveIndexes.add(new AtomicInteger(((Integer)pair.first).intValue()));
        }

        mPendingItemsToInsert.clear();
    }

    public void clearActive()
    {
        mActiveIndexes.clear();
        insertPending();
    }

    public Collection getActiveIndexes()
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = mActiveIndexes.iterator(); iterator.hasNext(); hashset.add(Integer.valueOf(((AtomicInteger)iterator.next()).get()))) { }
        return hashset;
    }

    public List getPendingItemsToInsert()
    {
        return mPendingItemsToInsert;
    }

    public void insert(int i, Object obj)
    {
        if (mActiveIndexes.isEmpty() && mPendingItemsToInsert.isEmpty())
        {
            mActiveIndexes.add(new AtomicInteger(i));
            mInsertable.add(i, obj);
            return;
        } else
        {
            mPendingItemsToInsert.add(new Pair(Integer.valueOf(i), obj));
            return;
        }
    }

    public void insert(List list)
    {
        if (mActiveIndexes.isEmpty() && mPendingItemsToInsert.isEmpty())
        {
            Pair pair;
            for (list = list.iterator(); list.hasNext(); mInsertable.add(((Integer)pair.first).intValue(), pair.second))
            {
                pair = (Pair)list.next();
                Iterator iterator = mActiveIndexes.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    AtomicInteger atomicinteger = (AtomicInteger)iterator.next();
                    if (atomicinteger.intValue() >= ((Integer)pair.first).intValue())
                    {
                        atomicinteger.incrementAndGet();
                    }
                } while (true);
                mActiveIndexes.add(new AtomicInteger(((Integer)pair.first).intValue()));
            }

        } else
        {
            mPendingItemsToInsert.addAll(list);
        }
    }

    public transient void insert(Pair apair[])
    {
        insert(Arrays.asList(apair));
    }

    public void removeActiveIndex(int i)
    {
        boolean flag = false;
        Iterator iterator = mActiveIndexes.iterator();
        do
        {
            if (!iterator.hasNext() || flag)
            {
                break;
            }
            if (((AtomicInteger)iterator.next()).get() == i)
            {
                iterator.remove();
                flag = true;
            }
        } while (true);
        if (mActiveIndexes.isEmpty())
        {
            insertPending();
        }
    }
}
