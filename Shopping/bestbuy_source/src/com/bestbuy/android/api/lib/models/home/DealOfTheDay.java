// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home:
//            OfferImage, Price

public class DealOfTheDay
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xc91ebb6fa0e2af7bL;
    private String lid;
    private OfferImage offerImage;
    private String offerTitle;
    private String offerType;
    private Price price;
    private PriceBlock priceBlock;
    private Summary summary;
    private String url;

    public DealOfTheDay()
    {
    }

    public String getLid()
    {
        return lid;
    }

    public OfferImage getOfferImage()
    {
        return offerImage;
    }

    public String getOfferTitle()
    {
        return offerTitle;
    }

    public String getOfferType()
    {
        return offerType;
    }

    public Price getPrice()
    {
        return price;
    }

    public PriceBlock getPriceBlock()
    {
        return priceBlock;
    }

    public Summary getSummary()
    {
        return summary;
    }

    public String getUrl()
    {
        return url;
    }

    public void setLid(String s)
    {
        lid = s;
    }

    public void setOfferImage(OfferImage offerimage)
    {
        offerImage = offerimage;
    }

    public void setOfferTitle(String s)
    {
        offerTitle = s;
    }

    public void setOfferType(String s)
    {
        offerType = s;
    }

    public void setPrice(Price price1)
    {
        price = price1;
    }

    public void setPriceBlock(PriceBlock priceblock)
    {
        priceBlock = priceblock;
    }

    public void setSummary(Summary summary1)
    {
        summary = summary1;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
