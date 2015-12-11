// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import com.bestbuy.android.api.lib.models.home.availability.Availability;
import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home:
//            Attributes, Brand, ButtonState, Names, 
//            Price, Properties, SellerInfo

public class PriceBlock
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x5fa15d3b671867cdL;
    private Attributes attributes;
    private Availability availability;
    private Brand brand;
    private ButtonState buttonState;
    private String condition;
    private Names names;
    private Price price;
    private String productId;
    private String productType;
    private Properties properties;
    private SellerInfo sellerInfo;
    private String skuId;
    private String url;

    public PriceBlock()
    {
    }

    public Attributes getAttributes()
    {
        return attributes;
    }

    public Availability getAvailability()
    {
        return availability;
    }

    public Brand getBrand()
    {
        return brand;
    }

    public ButtonState getButtonState()
    {
        return buttonState;
    }

    public String getCondition()
    {
        return condition;
    }

    public Names getNames()
    {
        return names;
    }

    public Price getPrice()
    {
        return price;
    }

    public String getProductId()
    {
        return productId;
    }

    public String getProductType()
    {
        return productType;
    }

    public Properties getProperties()
    {
        return properties;
    }

    public SellerInfo getSellerInfo()
    {
        return sellerInfo;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public String getUrl()
    {
        return url;
    }

    public void setAttributes(Attributes attributes1)
    {
        attributes = attributes1;
    }

    public void setAvailability(Availability availability1)
    {
        availability = availability1;
    }

    public void setBrand(Brand brand1)
    {
        brand = brand1;
    }

    public void setButtonState(ButtonState buttonstate)
    {
        buttonState = buttonstate;
    }

    public void setCondition(String s)
    {
        condition = s;
    }

    public void setNames(Names names1)
    {
        names = names1;
    }

    public void setPrice(Price price1)
    {
        price = price1;
    }

    public void setProductId(String s)
    {
        productId = s;
    }

    public void setProductType(String s)
    {
        productType = s;
    }

    public void setProperties(Properties properties1)
    {
        properties = properties1;
    }

    public void setSellerInfo(SellerInfo sellerinfo)
    {
        sellerInfo = sellerinfo;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
