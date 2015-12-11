// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.data_model.models.MetaItem;
import java.util.ArrayList;

public class MetaItemList extends ArrayList
{

    private final int limit;

    public MetaItemList(int i)
    {
        limit = i;
    }

    public boolean addToGlobalList(MetaItem metaitem)
    {
        for (; size() >= limit; remove(size() - 1)) { }
        super.add(0, metaitem);
        return true;
    }

    public boolean addToRecentList(MetaItem metaitem)
    {
        for (; size() >= limit; remove(size() - 1)) { }
        super.add(0, metaitem);
        return true;
    }

    public int getLimit()
    {
        return limit;
    }
}
