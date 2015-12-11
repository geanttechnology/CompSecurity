// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import android.content.res.Resources;
import android.text.TextUtils;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.PriceInfo;

public class SubscribeAndSaveModel
{
    public static class Builder
    {

        public SubscribeAndSaveModel build(PriceInfo priceinfo, boolean flag, ResultLayoutType resultlayouttype, Resources resources)
        {
            if (priceinfo == null || resultlayouttype == null || resources == null)
            {
                priceinfo = null;
            } else
            {
                resultlayouttype = new SubscribeAndSaveModel();
                if (TextUtils.isEmpty(priceinfo.getPrice()))
                {
                    return null;
                }
                resultlayouttype.setPrice(priceinfo.getPrice());
                if (priceinfo.getLink() == null || TextUtils.isEmpty(priceinfo.getLink().getText()))
                {
                    return null;
                }
                resultlayouttype.setPriceLabel(priceinfo.getLink().getText());
                priceinfo = resultlayouttype;
                if (flag)
                {
                    resultlayouttype.setSaveMoreText(resources.getString(com.amazon.retailsearch.R.string.subscribe_and_save));
                    return resultlayouttype;
                }
            }
            return priceinfo;
        }

        public Builder()
        {
        }
    }


    private String price;
    private String priceLabel;
    private String saveMoreText;

    public SubscribeAndSaveModel()
    {
    }

    private void setPrice(String s)
    {
        price = s;
    }

    private void setPriceLabel(String s)
    {
        priceLabel = s;
    }

    private void setSaveMoreText(String s)
    {
        saveMoreText = s;
    }

    public String getPrice()
    {
        return price;
    }

    public String getPriceLabel()
    {
        return priceLabel;
    }

    public String getSaveMoreText()
    {
        return saveMoreText;
    }



}
