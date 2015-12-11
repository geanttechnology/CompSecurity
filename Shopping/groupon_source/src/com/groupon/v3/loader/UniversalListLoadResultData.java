// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.loader;

import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import java.util.List;

// Referenced classes of package com.groupon.v3.loader:
//            EmptyListChecker

public class UniversalListLoadResultData
{

    protected DealSubsetAttribute dealSubsetAttribute;
    protected List listData;
    protected Pagination pagination;

    public UniversalListLoadResultData(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination1)
    {
        listData = list;
        dealSubsetAttribute = dealsubsetattribute;
        pagination = pagination1;
    }

    public DealSubsetAttribute getDealSubsetAttribute()
    {
        return dealSubsetAttribute;
    }

    public List getListData()
    {
        return listData;
    }

    public Pagination getPagination()
    {
        return pagination;
    }

    public boolean hasNoData(EmptyListChecker emptylistchecker)
    {
        return emptylistchecker.isEmpty(listData);
    }

    public void setListData(List list)
    {
        listData = list;
    }
}
