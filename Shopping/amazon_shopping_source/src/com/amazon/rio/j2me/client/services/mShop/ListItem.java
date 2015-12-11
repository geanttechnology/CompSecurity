// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            BasicOfferListing, BasicProductInfo

public class ListItem
{

    private BasicOfferListing basicOffer;
    private BasicProductInfo basicProduct;
    private String comment;
    private String dataAdded;
    private Integer desired;
    private String imageUrl;
    private String listItemId;
    private String price;
    private String priority;
    private String productUrl;
    private Integer received;
    private String siteDomain;
    private String title;

    public ListItem()
    {
    }

    public void setBasicOffer(BasicOfferListing basicofferlisting)
    {
        basicOffer = basicofferlisting;
    }

    public void setBasicProduct(BasicProductInfo basicproductinfo)
    {
        basicProduct = basicproductinfo;
    }

    public void setComment(String s)
    {
        comment = s;
    }

    public void setDataAdded(String s)
    {
        dataAdded = s;
    }

    public void setDesired(Integer integer)
    {
        desired = integer;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setListItemId(String s)
    {
        listItemId = s;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setPriority(String s)
    {
        priority = s;
    }

    public void setProductUrl(String s)
    {
        productUrl = s;
    }

    public void setReceived(Integer integer)
    {
        received = integer;
    }

    public void setSiteDomain(String s)
    {
        siteDomain = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
