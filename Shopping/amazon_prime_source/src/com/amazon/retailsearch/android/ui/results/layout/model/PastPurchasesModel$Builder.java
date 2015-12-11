// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.model;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.PastPurchases;
import com.amazon.searchapp.retailsearch.model.Product;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.model:
//            PastPurchasesModel

public static class productImageRes
{

    private PastPurchases pastPurchases;
    private int productImageRes;
    private ResourceProvider resourceProvider;
    private List seeAllLinks;
    private String store;

    public PastPurchasesModel build()
    {
        if (pastPurchases == null || resourceProvider == null || Utils.isEmpty(pastPurchases.getProducts()) || pastPurchases.getProducts().get(0) == null || productImageRes <= 0)
        {
            return null;
        } else
        {
            PastPurchasesModel pastpurchasesmodel = new PastPurchasesModel((Product)pastPurchases.getProducts().get(0), resourceProvider, productImageRes, null);
            PastPurchasesModel.access$100(pastpurchasesmodel, store);
            PastPurchasesModel.access$200(pastpurchasesmodel, seeAllLinks);
            return pastpurchasesmodel;
        }
    }

    public seeAllLinks setSeeAllLinks(List list)
    {
        seeAllLinks = list;
        return this;
    }

    public seeAllLinks setStore(String s)
    {
        store = s;
        return this;
    }

    public (PastPurchases pastpurchases, ResourceProvider resourceprovider, int i)
    {
        pastPurchases = pastpurchases;
        resourceProvider = resourceprovider;
        productImageRes = i;
    }
}
