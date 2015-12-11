// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas.models;

import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas.models:
//            EcasShoppingCart

public static class kdown
{

    public List attributes;
    public String carrier;
    public String category;
    public Date deliveryDateMax;
    public Date deliveryDateMin;
    public Integer deliveryDaysMax;
    public Integer deliveryDaysMin;
    public ItemCurrency handlingCost;
    public String id;
    public ItemCurrency importCharges;
    public boolean isApplicable;
    public String name;
    public Conversion shippingCost;
    public kdown shippingCostBreakdown;
    public ItemCurrency shippingInsuranceCost;
    public String superscript;
    public String token;

    public kdown()
    {
    }
}
