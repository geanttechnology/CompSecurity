// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;

import java.math.BigDecimal;

public class LineItem
{

    private String id;
    private String inventory_unit_id;
    private String picture_url;
    private BigDecimal price;
    private String product_id;
    private String seller_id;
    private String seller_name;
    private String size;
    private String tax_amount;
    private float tax_rate;
    private String title;

    public LineItem()
    {
    }

    public void copy(LineItem lineitem)
    {
        id = lineitem.id;
        title = lineitem.title;
        price = lineitem.price;
        seller_name = lineitem.seller_name;
        seller_id = lineitem.seller_id;
        size = lineitem.size;
        picture_url = lineitem.picture_url;
        product_id = lineitem.product_id;
        tax_amount = lineitem.tax_amount;
        tax_rate = lineitem.tax_rate;
        inventory_unit_id = lineitem.inventory_unit_id;
    }

    public String getId()
    {
        return id;
    }

    public String getInventoryUnitId()
    {
        return inventory_unit_id;
    }

    public String getPictureURL()
    {
        return picture_url;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public String getProductId()
    {
        return product_id;
    }

    public String getSellerId()
    {
        return seller_id;
    }

    public String getSellerName()
    {
        return seller_name;
    }

    public String getSize()
    {
        return size;
    }

    public float getTaxRate()
    {
        return tax_rate;
    }

    public String getTextAmount()
    {
        return tax_amount;
    }

    public String getTitle()
    {
        return title;
    }
}
