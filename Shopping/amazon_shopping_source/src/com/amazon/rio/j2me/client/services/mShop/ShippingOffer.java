// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            Date

public class ShippingOffer
{

    private Date deliveryDate;
    private String getItText;
    private String name;
    private String price;
    private Integer remainingMinutes;
    private String shipOption;

    public ShippingOffer()
    {
    }

    public Date getDeliveryDate()
    {
        return deliveryDate;
    }

    public String getGetItText()
    {
        return getItText;
    }

    public String getName()
    {
        return name;
    }

    public String getPrice()
    {
        return price;
    }

    public Integer getRemainingMinutes()
    {
        return remainingMinutes;
    }

    public String getShipOption()
    {
        return shipOption;
    }

    public void setDeliveryDate(Date date)
    {
        deliveryDate = date;
    }

    public void setGetItText(String s)
    {
        getItText = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setRemainingMinutes(Integer integer)
    {
        remainingMinutes = integer;
    }

    public void setShipOption(String s)
    {
        shipOption = s;
    }
}
