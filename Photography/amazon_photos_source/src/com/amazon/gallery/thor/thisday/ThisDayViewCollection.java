// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import java.util.List;

public class ThisDayViewCollection
{

    public final int collectionType;
    private int totalMediaItems;
    public final List yearInfoList;

    public ThisDayViewCollection(int i, List list)
    {
        collectionType = i;
        yearInfoList = list;
    }

    public int getTotalMediaItemsInCollection()
    {
        return totalMediaItems;
    }

    public void incrementTotalMediaItemsBy(int i)
    {
        totalMediaItems = totalMediaItems + i;
    }

    public boolean isEmpty()
    {
        return yearInfoList.isEmpty();
    }
}
