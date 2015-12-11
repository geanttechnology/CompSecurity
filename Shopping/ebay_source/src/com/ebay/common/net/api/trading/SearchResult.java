// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.net.PaginationResultElement;
import java.util.ArrayList;

public final class SearchResult
{

    public ArrayList items;
    public PaginationResultElement pagination;

    public SearchResult()
    {
        pagination = null;
        items = null;
    }

    public final int getTotalCount()
    {
        if (pagination != null)
        {
            return pagination.totalEntries;
        }
        if (items != null)
        {
            return items.size();
        } else
        {
            return 0;
        }
    }
}
