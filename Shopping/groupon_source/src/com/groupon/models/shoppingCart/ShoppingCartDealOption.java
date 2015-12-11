// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.shoppingCart;

import com.groupon.models.GenericAmount;
import java.util.Date;
import java.util.List;

public class ShoppingCartDealOption
{

    public List customFields;
    public GenericAmount discount;
    public Date endAt;
    public String id;
    public List images;
    public boolean isSoldOut;
    public int maximumPurchaseQuantity;
    public int minimumPurchaseQuantity;
    public GenericAmount price;
    public String title;
    public String uuid;
    public GenericAmount value;

    public ShoppingCartDealOption()
    {
        minimumPurchaseQuantity = 1;
        maximumPurchaseQuantity = 10;
    }
}
