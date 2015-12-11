// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.model;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.BrandCell;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.Link;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.model:
//            BrandStripModel

public static class resourceProvider
{

    private String brand;
    private List brandCells;
    private String originalKeywords;
    private ResourceProvider resourceProvider;
    private final RetailSearchLogger retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
    private String storeName;

    private boolean hasSelectedBrand(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            if (((BrandCell)list.next()).getSelected())
            {
                return true;
            }
        }

        return false;
    }

    private boolean hasValidBrandCellListSize(List list)
    {
        return !Utils.isEmpty(list) && list.size() >= 3;
    }

    private boolean hasValidBrandCells(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            BrandCell brandcell = (BrandCell)list.next();
            if (brandcell.getLink() == null || brandcell.getLink().getUrl() == null || brandcell.getImage() == null || brandcell.getImage().getUrl() == null)
            {
                return false;
            }
        }

        return true;
    }

    public BrandStripModel build()
    {
        if (resourceProvider == null || !hasValidBrandCellListSize(brandCells) || !hasSelectedBrand(brandCells) || !hasValidBrandCells(brandCells))
        {
            retailSearchLogger.error("BrandStrip model invalid", null);
            return null;
        } else
        {
            return new BrandStripModel(brand, originalKeywords, storeName, brandCells, resourceProvider, null);
        }
    }

    public resourceProvider setBrand(String s)
    {
        brand = s;
        return this;
    }

    public brand setOriginalKeywords(String s)
    {
        originalKeywords = s;
        return this;
    }

    public originalKeywords setStoreName(String s)
    {
        storeName = s;
        return this;
    }

    public (List list, ResourceProvider resourceprovider)
    {
        brandCells = list;
        resourceProvider = resourceprovider;
    }
}
