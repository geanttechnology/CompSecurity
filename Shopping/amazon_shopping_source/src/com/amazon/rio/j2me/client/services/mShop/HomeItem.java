// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            BasicOfferListing, BasicProductInfo, UniversalLink

public class HomeItem
{

    private String asin;
    private BasicOfferListing basicOffer;
    private BasicProductInfo basicProduct;
    private String clickStreamOrigin;
    private String imageUrl;
    private String itemDescription;
    private UniversalLink link;
    private String remembersId;

    public HomeItem()
    {
    }

    public String getAsin()
    {
        return asin;
    }

    public BasicOfferListing getBasicOffer()
    {
        return basicOffer;
    }

    public BasicProductInfo getBasicProduct()
    {
        return basicProduct;
    }

    public String getClickStreamOrigin()
    {
        return clickStreamOrigin;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setBasicOffer(BasicOfferListing basicofferlisting)
    {
        basicOffer = basicofferlisting;
    }

    public void setBasicProduct(BasicProductInfo basicproductinfo)
    {
        basicProduct = basicproductinfo;
    }

    public void setClickStreamOrigin(String s)
    {
        clickStreamOrigin = s;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setItemDescription(String s)
    {
        itemDescription = s;
    }

    public void setLink(UniversalLink universallink)
    {
        link = universallink;
    }

    public void setRemembersId(String s)
    {
        remembersId = s;
    }
}
