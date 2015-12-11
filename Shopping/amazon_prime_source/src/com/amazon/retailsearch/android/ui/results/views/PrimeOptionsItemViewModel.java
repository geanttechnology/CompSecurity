// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.text.TextUtils;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.ShippingStatus;
import java.util.List;

public class PrimeOptionsItemViewModel
{
    public static class Builder
    {

        private String asin;
        private EditionsPriceInfo offer;
        private int offersCount;
        private String productGroup;

        public PrimeOptionsItemViewModel build()
        {
            PrimeOptionsItemViewModel primeoptionsitemviewmodel;
            primeoptionsitemviewmodel = new PrimeOptionsItemViewModel();
            if (TextUtils.isEmpty(offer.getAsin()))
            {
                primeoptionsitemviewmodel.setAsin(asin);
            } else
            {
                primeoptionsitemviewmodel.setAsin(offer.getAsin());
            }
            if (TextUtils.isEmpty(offer.getGroup()))
            {
                primeoptionsitemviewmodel.setProductGroup(productGroup);
            } else
            {
                primeoptionsitemviewmodel.setProductGroup(offer.getGroup());
            }
            primeoptionsitemviewmodel.setOfferCount(offersCount);
            if (offer.getShipping().getPrime() == null) goto _L2; else goto _L1
_L1:
            if (offer.getShipping().getPrime().getHasBadge() && offer.getShipping().getPrime().getBadgeLink() != null)
            {
                primeoptionsitemviewmodel.setBadgeId(offer.getShipping().getPrime().getBadgeAssetId());
                primeoptionsitemviewmodel.setBadgeText(offer.getShipping().getPrime().getBadgeLink().getText());
                primeoptionsitemviewmodel.setUrl(offer.getShipping().getPrime().getBadgeLink().getUrl());
            }
_L4:
            return primeoptionsitemviewmodel;
_L2:
            if (offer.getShipping().getAddOn() == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!offer.getShipping().getAddOn().getHasBadge() || offer.getShipping().getAddOn().getBadgeLink() == null) goto _L4; else goto _L3
_L3:
            primeoptionsitemviewmodel.setBadgeId(offer.getShipping().getAddOn().getBadgeAssetId());
            primeoptionsitemviewmodel.setBadgeText(offer.getShipping().getAddOn().getBadgeLink().getText());
            primeoptionsitemviewmodel.setUrl(offer.getShipping().getAddOn().getBadgeLink().getUrl());
            return primeoptionsitemviewmodel;
            if (Utils.isEmpty(offer.getShipping().getAdditionalStatus()) || !((ShippingStatus)offer.getShipping().getAdditionalStatus().get(0)).getHasBadge() || ((ShippingStatus)offer.getShipping().getAdditionalStatus().get(0)).getBadgeLink() == null) goto _L4; else goto _L5
_L5:
            primeoptionsitemviewmodel.setBadgeId(((ShippingStatus)offer.getShipping().getAdditionalStatus().get(0)).getBadgeAssetId());
            primeoptionsitemviewmodel.setBadgeText(((ShippingStatus)offer.getShipping().getAdditionalStatus().get(0)).getBadgeLink().getText());
            primeoptionsitemviewmodel.setUrl(((ShippingStatus)offer.getShipping().getAdditionalStatus().get(0)).getBadgeLink().getUrl());
            return primeoptionsitemviewmodel;
        }

        public Builder setAsin(String s)
        {
            asin = s;
            return this;
        }

        public Builder setOffer(EditionsPriceInfo editionspriceinfo)
        {
            offer = editionspriceinfo;
            return this;
        }

        public Builder setOffersCount(int i)
        {
            offersCount = i;
            return this;
        }

        public Builder setProductGroup(String s)
        {
            productGroup = s;
            return this;
        }

        public Builder()
        {
            offersCount = 1;
        }
    }


    private String asin;
    private String badgeId;
    private String badgeText;
    private int offerCount;
    private String productGroup;
    private String url;

    public PrimeOptionsItemViewModel()
    {
    }

    private void setAsin(String s)
    {
        asin = s;
    }

    private void setBadgeId(String s)
    {
        badgeId = s;
    }

    private void setBadgeText(String s)
    {
        badgeText = s;
    }

    private void setOfferCount(int i)
    {
        offerCount = i;
    }

    private void setProductGroup(String s)
    {
        productGroup = s;
    }

    private void setUrl(String s)
    {
        url = s;
    }

    public String getAsin()
    {
        return asin;
    }

    public String getBadgeId()
    {
        return badgeId;
    }

    public String getBadgeText()
    {
        return badgeText;
    }

    public int getOfferCount()
    {
        return offerCount;
    }

    public String getProductGroup()
    {
        return productGroup;
    }

    public String getUrl()
    {
        return url;
    }






}
