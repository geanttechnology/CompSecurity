// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;

import java.math.BigDecimal;

// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            Price

public class ShippingAmount
{

    BigDecimal amount;
    BigDecimal list_amount;
    String seller_id;
    Price shipping_amount;
    Price shipping_list_amount;

    public ShippingAmount()
    {
    }

    public void copy(ShippingAmount shippingamount)
    {
        amount = shippingamount.amount;
        list_amount = shippingamount.list_amount;
        seller_id = shippingamount.seller_id;
        shipping_list_amount.copy(shippingamount.shipping_list_amount);
        shipping_amount.copy(shippingamount.shipping_amount);
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public BigDecimal getListAmount()
    {
        return list_amount;
    }

    public String getSellerId()
    {
        return seller_id;
    }
}
