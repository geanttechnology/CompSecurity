// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.inner_models.Inventory;
import com.poshmark.data_model.models.inner_models.ListingAggregates;
import com.poshmark.data_model.models.inner_models.OfferHistory;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            ListingSocial, PriceDrop

public class ListingDetails extends ListingSocial
{

    boolean caller_has_offered;
    List events;
    OfferHistory offer_data;
    List pictures;
    PriceDrop price_drop;
    List system_messages;

    public ListingDetails()
    {
        caller_has_offered = false;
    }

    public int getOfferCount()
    {
        return aggregates.active_offers;
    }

    public String getOffersUrl()
    {
        if (offer_data != null)
        {
            return offer_data.target_url;
        } else
        {
            return null;
        }
    }

    public List getPictures()
    {
        return pictures;
    }

    public int getPriceDropPercentage()
    {
        if (price_drop != null)
        {
            return price_drop.percentage;
        } else
        {
            return 0;
        }
    }

    public List getSystemMessages()
    {
        return system_messages;
    }

    public boolean hasOffers()
    {
        return aggregates.active_offers > 0;
    }

    public boolean haveIOffered()
    {
        return caller_has_offered;
    }

    public boolean isListingAvailable()
    {
        String s = getInventory().getInventoryStatus().toString();
        return !s.equals(PMApplication.getApplicationObject().getString(0x7f060187)) && !s.equals(PMApplication.getApplicationObject().getString(0x7f060186)) && !s.equals(PMApplication.getApplicationObject().getString(0x7f060185));
    }

    public boolean isListingSold()
    {
        return getInventory().getInventoryStatus().toString().equals(PMApplication.getApplicationObject().getString(0x7f060187));
    }
}
