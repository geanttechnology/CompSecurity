// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp:
//            BundleCustomerRatings, BundleDescriptions, BundleManufacturer, BundleMedia, 
//            BundleName

public class BundleItems
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private BundleCustomerRatings bundleCustomerRatings;
    private BundleDescriptions bundleDescriptions;
    private BundleManufacturer bundleManufacturerId;
    private BundleMedia media;
    private BundleName names;
    private String skuId;
    private String url;

    public BundleItems()
    {
    }

    public BundleCustomerRatings getBundleCustomerRatings()
    {
        return bundleCustomerRatings;
    }

    public BundleDescriptions getBundleDescriptions()
    {
        return bundleDescriptions;
    }

    public BundleManufacturer getBundleManufacturerId()
    {
        return bundleManufacturerId;
    }

    public BundleMedia getMedia()
    {
        return media;
    }

    public BundleName getNames()
    {
        return names;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public String getUrl()
    {
        return url;
    }

    public void setBundleCustomerRatings(BundleCustomerRatings bundlecustomerratings)
    {
        bundleCustomerRatings = bundlecustomerratings;
    }

    public void setBundleDescriptions(BundleDescriptions bundledescriptions)
    {
        bundleDescriptions = bundledescriptions;
    }

    public void setBundleManufacturerId(BundleManufacturer bundlemanufacturer)
    {
        bundleManufacturerId = bundlemanufacturer;
    }

    public void setMedia(BundleMedia bundlemedia)
    {
        media = bundlemedia;
    }

    public void setNames(BundleName bundlename)
    {
        names = bundlename;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
