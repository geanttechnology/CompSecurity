// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.models.inner_models.Amount;
import com.poshmark.utils.CurrencyUtils;
import java.math.BigDecimal;

public class PMDiscount
{

    public static final String TargetTypeItemPrice = "iprc";
    public static final String TargetTypeShipping = "shp";
    Amount amount;
    BigDecimal discount_price;
    String discount_title;
    String discount_type;
    String target_type;

    public PMDiscount()
    {
    }

    public String getDiscountPriceString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(discount_price)).toString();
    }

    public String getTargetType()
    {
        return target_type;
    }

    public String getTitle()
    {
        return discount_title;
    }
}
