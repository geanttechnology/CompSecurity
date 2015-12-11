// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            ListCountContent

public class ListContent extends ListCountContent
{

    private final int _highestPageIndex;
    private final List _list;
    private final int _pagesLoaded;
    private final int _totalLoadableItemCount;
    private final int _unfilteredItemsLoaded;

    public ListContent(List list, int i, int j, int k, int l, int i1, ResultStatus resultstatus, 
            long l1)
    {
        super(i1, resultstatus, l1);
        _pagesLoaded = j;
        _highestPageIndex = k;
        _totalLoadableItemCount = l;
        _unfilteredItemsLoaded = i;
        _list = list;
    }

    public ListContent(List list, int i, int j, int k, int l, ResultStatus resultstatus, long l1)
    {
        int i1;
        if (list == null)
        {
            i1 = 0;
        } else
        {
            i1 = list.size();
        }
        this(list, i1, i, j, k, l, resultstatus, l1);
    }

    public final int getHighestPageIndex()
    {
        return _highestPageIndex;
    }

    public final List getList()
    {
        return _list;
    }

    public final int getPagesLoaded()
    {
        return _pagesLoaded;
    }

    public final int getTotalLoadableItemCount()
    {
        return _totalLoadableItemCount;
    }

    public final int getUnfilteredItemsLoaded()
    {
        return _unfilteredItemsLoaded;
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("highest page index:").append(_highestPageIndex).append(", loadable item count:").append(_totalLoadableItemCount).append(", pages loaded:").append(_pagesLoaded).append(", unfiltered items loaded:").append(_unfilteredItemsLoaded).append(", items:");
        int i;
        if (_list == null)
        {
            i = 0;
        } else
        {
            i = _list.size();
        }
        return stringbuilder.append(i).append(", ").append(super.toString()).toString();
    }
}
