// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.BrandStrip;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class BrandStripEntity extends RetailSearchEntity
    implements BrandStrip
{

    private String brand;
    private List brandCells;
    private String id;
    private String originalKeywords;
    private String storeName;

    public BrandStripEntity()
    {
    }

    public String getBrand()
    {
        return brand;
    }

    public List getBrandCells()
    {
        return brandCells;
    }

    public String getId()
    {
        return id;
    }

    public String getOriginalKeywords()
    {
        return originalKeywords;
    }

    public String getStoreName()
    {
        return storeName;
    }

    public void setBrand(String s)
    {
        brand = s;
    }

    public void setBrandCells(List list)
    {
        brandCells = list;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setOriginalKeywords(String s)
    {
        originalKeywords = s;
    }

    public void setStoreName(String s)
    {
        storeName = s;
    }
}
