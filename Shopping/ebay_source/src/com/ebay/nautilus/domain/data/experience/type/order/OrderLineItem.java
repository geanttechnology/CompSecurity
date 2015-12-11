// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type.order;

import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplay;
import com.ebay.nautilus.domain.data.experience.type.listing.ListingSummary;

public final class OrderLineItem
{

    public ListingSummary listingSummary;
    public TextualDisplay quantity;
    public String transactionId;

    public OrderLineItem()
    {
    }
}
