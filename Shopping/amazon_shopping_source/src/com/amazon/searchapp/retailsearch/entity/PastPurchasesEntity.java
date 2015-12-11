// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.PastPurchases;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PastPurchasesEntity extends RetailSearchEntity
    implements PastPurchases
{

    private List purchases;

    public PastPurchasesEntity()
    {
    }

    public List getPurchases()
    {
        return purchases;
    }

    public void setPurchases(List list)
    {
        purchases = list;
    }
}
