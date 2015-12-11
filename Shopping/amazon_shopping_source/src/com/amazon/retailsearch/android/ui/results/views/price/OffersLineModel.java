// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import com.amazon.searchapp.retailsearch.model.PriceInfo;
import com.amazon.searchapp.retailsearch.model.Prices;
import java.util.List;

public class OffersLineModel
{
    public static class Builder
    {

        public OffersLineModel build(Prices prices, boolean flag, boolean flag1)
        {
            if (flag1 && flag)
            {
                return null;
            }
            if (prices == null)
            {
                return null;
            }
            OffersLineModel offerslinemodel = new OffersLineModel();
            PriceInfo priceinfo = null;
            if (prices.getUsedAndNewOffers() != null)
            {
                priceinfo = prices.getUsedAndNewOffers();
            } else
            if (prices.getUsedOffers() != null)
            {
                priceinfo = prices.getUsedOffers();
            } else
            if (prices.getNewOffers() != null)
            {
                priceinfo = prices.getNewOffers();
            }
            if (priceinfo == null || priceinfo.getMarketplaceLabel() == null || priceinfo.getMarketplaceLabel().isEmpty())
            {
                return null;
            } else
            {
                offerslinemodel.setStyledText(priceinfo.getMarketplaceLabel());
                return offerslinemodel;
            }
        }

        public Builder()
        {
        }
    }


    private List styledText;

    public OffersLineModel()
    {
    }

    public List getStyledText()
    {
        return styledText;
    }

    public void setStyledText(List list)
    {
        styledText = list;
    }
}
