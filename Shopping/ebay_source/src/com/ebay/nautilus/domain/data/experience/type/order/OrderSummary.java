// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type.order;

import com.ebay.nautilus.domain.data.experience.type.base.Presentity;
import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplay;
import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplayValue;
import com.ebay.nautilus.domain.data.experience.type.logistics.BuyerLogisticsSummary;
import java.util.List;

public class OrderSummary extends Presentity
{

    public BuyerLogisticsSummary buyerSelectedLogistics;
    public TextualDisplayValue creationDate;
    public TextualDisplayValue displayTotalPrice;
    public TextualDisplay lineItemCount;
    public String orderId;
    public TextualDisplay orderLevelActions;
    public List orderLineItems;
    public TextualDisplay orderStatus;
    public TextualDisplayValue paidDate;
    public TextualDisplay totalQuantity;

    public OrderSummary()
    {
    }
}
