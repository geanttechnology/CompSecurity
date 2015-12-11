// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.NonPrimeOffer;
import java.util.List;

public class ForcedPrimeModel
{
    public static class Builder
    {

        public ForcedPrimeModel build(NonPrimeOffer nonprimeoffer, String s)
        {
            if (nonprimeoffer == null || nonprimeoffer.getLink() == null || TextUtils.isEmpty(nonprimeoffer.getLink().getText()))
            {
                return null;
            } else
            {
                ForcedPrimeModel forcedprimemodel = new ForcedPrimeModel();
                forcedprimemodel.setLowerPriceMessage(nonprimeoffer.getLink().getText());
                forcedprimemodel.setPriceAndLabel(nonprimeoffer.getLabel());
                forcedprimemodel.setAsin(nonprimeoffer.getAsin());
                forcedprimemodel.setUrl(nonprimeoffer.getLink().getUrl());
                forcedprimemodel.setProductGroup(s);
                return forcedprimemodel;
            }
        }

        public Builder()
        {
        }
    }


    private String asin;
    private String lowerPriceMessage;
    private List priceAndLabel;
    private String productGroup;
    private String url;

    public ForcedPrimeModel()
    {
    }

    private void setAsin(String s)
    {
        asin = s;
    }

    private void setLowerPriceMessage(String s)
    {
        lowerPriceMessage = s;
    }

    private void setPriceAndLabel(List list)
    {
        priceAndLabel = list;
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

    public String getLowerPriceMessage()
    {
        return lowerPriceMessage;
    }

    public List getPriceAndLabel()
    {
        return priceAndLabel;
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
