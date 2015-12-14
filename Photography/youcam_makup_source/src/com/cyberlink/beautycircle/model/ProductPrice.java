// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.perfectcorp.model.Model;

public class ProductPrice extends Model
{

    public long id;
    public double priceMax;
    public double priceMin;
    public String priceRangeName;

    public ProductPrice()
    {
    }

    public static ProductPrice b()
    {
        ProductPrice productprice = new ProductPrice();
        productprice.id = 0L;
        productprice.priceMin = -1D;
        productprice.priceMax = -1D;
        productprice.priceRangeName = Globals.n().getString(m.bc_products_price);
        return productprice;
    }

    public String toString()
    {
        if (priceRangeName != null)
        {
            return priceRangeName;
        }
        if (priceMax > priceMin)
        {
            return (new StringBuilder()).append((int)priceMin).append("-").append((int)priceMax).toString();
        } else
        {
            return (new StringBuilder()).append((int)priceMin).append("+").toString();
        }
    }
}
