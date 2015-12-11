// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type.listing;

import com.ebay.nautilus.domain.data.experience.checkout.details.XoListingSummary;
import com.ebay.nautilus.domain.data.experience.deals.DealsListingSummary;
import com.ebay.nautilus.domain.data.experience.type.base.Image;
import com.ebay.nautilus.domain.data.experience.type.base.Presentity;
import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplay;
import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplayValue;
import java.util.List;

public class ListingSummary extends Presentity
{

    public TextualDisplayValue additionalPrice;
    public List aspectValuesList;
    public TextualDisplay bannerStatus;
    public TextualDisplayValue bidCount;
    public DealsListingSummary dealsListingSummary;
    public TextualDisplayValue discount;
    public TextualDisplayValue displayPrice;
    public TextualDisplay distance;
    public Boolean ebayGuarantee;
    public Boolean ended;
    public TextualDisplay energyEfficiencyRating;
    public TextualDisplay hotness;
    public Image image;
    public String listingId;
    public TextualDisplay moreOptions;
    public TextualDisplay purchaseOptions;
    public TextualDisplayValue quantity;
    public TextualDisplayValue shippingCost;
    public TextualDisplay status;
    public TextualDisplayValue timeEnding;
    public TextualDisplay title;
    public String variationId;
    public String version;
    public XoListingSummary xoListingSummary;

    public ListingSummary()
    {
    }
}
