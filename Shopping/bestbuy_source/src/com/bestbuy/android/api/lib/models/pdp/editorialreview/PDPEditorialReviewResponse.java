// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.editorialreview;

import com.bestbuy.android.api.lib.models.home.Names;
import gu;
import java.io.Serializable;
import java.util.List;

public class PDPEditorialReviewResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private List editorialReviews;
    private Names names;
    private String productType;
    private String skuId;

    public PDPEditorialReviewResponse()
    {
    }

    public List getEditorialReviews()
    {
        return editorialReviews;
    }

    public Names getNames()
    {
        return names;
    }

    public String getProductType()
    {
        return productType;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public void setEditorialReviews(List list)
    {
        editorialReviews = list;
    }

    public void setNames(Names names1)
    {
        names = names1;
    }

    public void setProductType(String s)
    {
        productType = s;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }
}
