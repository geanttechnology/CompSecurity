// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.plp.presenter;

import com.google.a.a.e;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.plp.presenter:
//            ProductSummaryPagePresenterParam

public static class 
{

    String dvmBannerUrl;
    private List filteredSiblingPageItemList;
    private PageItemHierarchy pageItemHierarchy;
    String pageTitle;
    private List productIdentifiers;
    private ProductSummaryParam productSummaryParam;
    boolean showGridView;
    Store store;

    static ProductSummaryParam a( )
    {
        return .productSummaryParam;
    }

    static List b(productSummaryParam productsummaryparam)
    {
        return productsummaryparam.productIdentifiers;
    }

    static PageItemHierarchy c(productIdentifiers productidentifiers)
    {
        return productidentifiers.pageItemHierarchy;
    }

    static List d(pageItemHierarchy pageitemhierarchy)
    {
        return pageitemhierarchy.filteredSiblingPageItemList;
    }

    public filteredSiblingPageItemList a(ProductSummaryParam productsummaryparam)
    {
        productSummaryParam = productsummaryparam;
        return this;
    }

    public productSummaryParam a(Store store1)
    {
        store = store1;
        return this;
    }

    public store a(PageItemHierarchy pageitemhierarchy)
    {
        pageItemHierarchy = pageitemhierarchy;
        return this;
    }

    public pageItemHierarchy a(ProductSummaryPagePresenterParam productsummarypagepresenterparam)
    {
        a((Store)productsummarypagepresenterparam.a().d());
        a((String)productsummarypagepresenterparam.b().d());
        b((String)productsummarypagepresenterparam.c().d());
        a(productsummarypagepresenterparam.d());
        a((PageItemHierarchy)productsummarypagepresenterparam.e().d());
        a(productsummarypagepresenterparam.f());
        a((ProductSummaryParam)productsummarypagepresenterparam.g().d());
        b(productsummarypagepresenterparam.h());
        return this;
    }

    public b a(String s)
    {
        dvmBannerUrl = s;
        return this;
    }

    public dvmBannerUrl a(List list)
    {
        filteredSiblingPageItemList = list;
        return this;
    }

    public filteredSiblingPageItemList a(boolean flag)
    {
        showGridView = flag;
        return this;
    }

    public ProductSummaryPagePresenterParam a()
    {
        if (productSummaryParam == null && productIdentifiers == null)
        {
            throw new IllegalArgumentException("We have to set either setProductSummaryParam() orsetFilteredSiblingPages() to get the product summary");
        } else
        {
            return new ProductSummaryPagePresenterParam(this, null);
        }
    }

    public nit> b(String s)
    {
        pageTitle = s;
        return this;
    }

    public pageTitle b(List list)
    {
        productIdentifiers = list;
        return this;
    }

    public ()
    {
    }
}
