// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Pagination;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PaginationEntity extends RetailSearchEntity
    implements Pagination
{

    private int numPages;
    private List pages;

    public PaginationEntity()
    {
    }

    public int getNumPages()
    {
        return numPages;
    }

    public List getPages()
    {
        return pages;
    }

    public void setNumPages(int i)
    {
        numPages = i;
    }

    public void setPages(List list)
    {
        pages = list;
    }
}
