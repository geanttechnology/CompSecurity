// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.b;

import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingBase;
import com.target.ui.util.am;

public class a
{

    private Product mProduct;
    private String mTitle;

    public a(Product product)
    {
        mProduct = product;
    }

    public a(WeeklyAdListingBase weeklyadlistingbase)
    {
        mProduct = am.a(weeklyadlistingbase);
        if (mProduct == null)
        {
            mTitle = weeklyadlistingbase.a();
        }
    }

    public String a()
    {
        return mTitle;
    }

    public Product b()
    {
        return mProduct;
    }
}
