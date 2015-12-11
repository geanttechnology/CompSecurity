// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.cart;

import java.util.ArrayList;

public abstract class CartItem
{

    protected boolean backordered;
    protected double cost;
    protected String description;
    protected ArrayList extraCosts;
    protected String itemId;
    protected double shippingCost;
    protected String sku;
    protected double taxCost;
    protected double unitPrice;

    public CartItem()
    {
    }

    public double getCost()
    {
        return cost;
    }

    public String getDescription()
    {
        return description;
    }

    public ArrayList getExtraCosts()
    {
        return extraCosts;
    }

    public String getItemId()
    {
        return itemId;
    }

    public double getShippingCost()
    {
        return shippingCost;
    }

    public String getSku()
    {
        return sku;
    }

    public double getTaxCost()
    {
        return taxCost;
    }

    public double getUnitPrice()
    {
        return unitPrice;
    }

    public boolean isBackordered()
    {
        return backordered;
    }
}
