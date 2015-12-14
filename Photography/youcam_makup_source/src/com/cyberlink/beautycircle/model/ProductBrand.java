// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.perfectcorp.model.Model;

public class ProductBrand extends Model
{

    public String brandName;
    public long id;

    public ProductBrand()
    {
    }

    public static ProductBrand b()
    {
        ProductBrand productbrand = new ProductBrand();
        productbrand.id = -1L;
        productbrand.brandName = Globals.n().getString(m.bc_products_brand);
        return productbrand;
    }

    public String toString()
    {
        return brandName;
    }
}
