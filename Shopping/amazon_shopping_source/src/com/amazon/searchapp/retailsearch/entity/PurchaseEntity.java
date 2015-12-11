// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Purchase;
import com.amazon.searchapp.retailsearch.model.ShippingStatus;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PurchaseEntity extends RetailSearchEntity
    implements Purchase
{

    private String buyingPrice;
    private String date;
    private Image image;
    private Link link;
    private ShippingStatus prime;
    private String title;

    public PurchaseEntity()
    {
    }

    public String getBuyingPrice()
    {
        return buyingPrice;
    }

    public String getDate()
    {
        return date;
    }

    public Image getImage()
    {
        return image;
    }

    public Link getLink()
    {
        return link;
    }

    public ShippingStatus getPrime()
    {
        return prime;
    }

    public String getTitle()
    {
        return title;
    }

    public void setBuyingPrice(String s)
    {
        buyingPrice = s;
    }

    public void setDate(String s)
    {
        date = s;
    }

    public void setImage(Image image1)
    {
        image = image1;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }

    public void setPrime(ShippingStatus shippingstatus)
    {
        prime = shippingstatus;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
