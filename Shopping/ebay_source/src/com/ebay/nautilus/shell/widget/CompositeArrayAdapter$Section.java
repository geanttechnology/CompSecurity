// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.widget;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.shell.widget:
//            CompositeArrayAdapter

public static final class loadMoreOffset
{

    public final List list;
    public final String listName;
    public final int listType;
    public final int loadMoreOffset;
    public final int loadedItems;
    public final int maxItemsToShow;
    public final int pagesLoaded;
    public final int totalItems;

    public final boolean isFilled()
    {
        boolean flag1 = true;
        boolean flag;
        if (pagesLoaded == 0)
        {
            flag = false;
        } else
        {
            flag = flag1;
            if (loadMoreOffset >= 0)
            {
                flag = flag1;
                if (list.size() < maxItemsToShow)
                {
                    flag = flag1;
                    if (size() < totalItems)
                    {
                        return false;
                    }
                }
            }
        }
        return flag;
    }

    public final boolean showMore()
    {
        return totalItems > maxItemsToShow && size() >= maxItemsToShow;
    }

    public final int size()
    {
        int i;
        int j;
        if (list != null)
        {
            i = list.size();
        } else
        {
            i = 0;
        }
        j = i;
        if (i > maxItemsToShow)
        {
            j = maxItemsToShow;
        }
        return j;
    }

    public (int i, String s, List list1, int j, int k, int l, int i1, 
            int j1)
    {
        listType = i;
        listName = s;
        list = list1;
        totalItems = j;
        loadedItems = k;
        i = l;
        if (l < 0)
        {
            i = 0x7fffffff;
        }
        maxItemsToShow = i;
        pagesLoaded = i1;
        loadMoreOffset = j1;
    }
}
