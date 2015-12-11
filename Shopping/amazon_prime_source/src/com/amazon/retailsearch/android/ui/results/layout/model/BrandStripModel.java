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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BrandStripModel
{
    public static class Builder
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
                return new BrandStripModel(brand, originalKeywords, storeName, brandCells, resourceProvider);
            }
        }

        public Builder setBrand(String s)
        {
            brand = s;
            return this;
        }

        public Builder setOriginalKeywords(String s)
        {
            originalKeywords = s;
            return this;
        }

        public Builder setStoreName(String s)
        {
            storeName = s;
            return this;
        }

        public Builder(List list, ResourceProvider resourceprovider)
        {
            brandCells = list;
            resourceProvider = resourceprovider;
        }
    }


    public static final int MIN_CELL_NUM = 3;
    private String brand;
    private List brandCells;
    private List cellWrappers;
    private String originalKeywords;
    private ResourceProvider resourceProvider;
    private String storeName;

    private BrandStripModel(String s, String s1, String s2, List list, ResourceProvider resourceprovider)
    {
        cellWrappers = new ArrayList();
        brand = s;
        originalKeywords = s1;
        storeName = s2;
        brandCells = list;
        resourceProvider = resourceprovider;
    }


    public String getBrand()
    {
        return brand;
    }

    public List getBrandCellWrappers()
    {
        return cellWrappers;
    }

    public List getBrandCells()
    {
        return brandCells;
    }

    public String getOriginalKeywords()
    {
        return originalKeywords;
    }

    public ResourceProvider getResourceProvider()
    {
        return resourceProvider;
    }

    public String getStoreName()
    {
        return storeName;
    }
}
