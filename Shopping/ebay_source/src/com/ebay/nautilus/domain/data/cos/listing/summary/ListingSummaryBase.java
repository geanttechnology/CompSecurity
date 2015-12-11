// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.listing.summary;

import com.ebay.nautilus.domain.data.cos.base.Amount;
import com.ebay.nautilus.domain.data.cos.base.DateTime;
import com.ebay.nautilus.domain.data.cos.base.MarketplaceIdEnum;
import com.ebay.nautilus.domain.data.cos.base.NameValuesPair;
import com.ebay.nautilus.domain.data.cos.base.Text;
import com.ebay.nautilus.domain.data.cos.listing.ListingFormatEnum;
import com.ebay.nautilus.domain.data.cos.listing.ListingStatusEnum;
import com.ebay.nautilus.domain.data.cos.listing.classification.ListingCondition;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.cos.listing.summary:
//            ImageSummary

public class ListingSummaryBase
{

    public DateTime actualEndDate;
    public List aspectValuesList;
    public int bidCount;
    public Amount currentBidPrice;
    public List discountPrices;
    public ListingFormatEnum format;
    public boolean freeShippingAvailable;
    public List images;
    public ListingCondition listingCondition;
    public String listingId;
    public String listingLocale;
    public Amount lowestFixedPrice;
    public MarketplaceIdEnum marketplaceListedOn;
    public boolean multipleVariationsListed;
    public List purchaseOptions;
    public DateTime scheduledEndDate;
    public DateTime scheduledStartDate;
    public ListingStatusEnum status;
    public Text title;

    public ListingSummaryBase()
    {
        format = ListingFormatEnum.UNKNOWN;
        status = ListingStatusEnum.UNKNOWN;
    }

    public NameValuesPair getEnergyEfficiencyRating()
    {
        Object obj = null;
        NameValuesPair namevaluespair = obj;
        if (aspectValuesList != null)
        {
            Iterator iterator = aspectValuesList.iterator();
            do
            {
                namevaluespair = obj;
                if (!iterator.hasNext())
                {
                    break;
                }
                namevaluespair = (NameValuesPair)iterator.next();
            } while (!"EnergyEfficiencyRating".equals(namevaluespair.globalIdentifier) || namevaluespair.values.isEmpty() || namevaluespair.name == null);
        }
        return namevaluespair;
    }

    public Amount getPrice()
    {
        if (currentBidPrice != null)
        {
            return currentBidPrice;
        } else
        {
            return lowestFixedPrice;
        }
    }

    public String getPrimaryImageUrl()
    {
        if (images != null && !images.isEmpty())
        {
            return ((ImageSummary)images.get(0)).imageUrl;
        } else
        {
            return null;
        }
    }

    public String getTitle(boolean flag)
    {
        if (title != null)
        {
            return title.getText(flag);
        } else
        {
            return null;
        }
    }
}
