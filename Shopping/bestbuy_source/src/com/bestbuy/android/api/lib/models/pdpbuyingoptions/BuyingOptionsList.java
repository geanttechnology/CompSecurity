// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpbuyingoptions;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpbuyingoptions:
//            Availability, Price, Properties, SellerInfo

public class BuyingOptionsList
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private Availability availability;
    private String condition;
    private boolean displayCertifiedLogo;
    private String displayCondition;
    private ArrayList financingOffers;
    private Price price;
    private String productId;
    private Properties properties;
    private SellerInfo sellerInfo;
    private String skuId;
    private ArrayList specialOffers;

    public BuyingOptionsList()
    {
    }

    public Availability getAvailability()
    {
        return availability;
    }

    public String getCondition()
    {
        return condition;
    }

    public String getDisplayCondition()
    {
        return displayCondition;
    }

    public ArrayList getFinancingOffers()
    {
        return financingOffers;
    }

    public Price getPrice()
    {
        return price;
    }

    public String getProductId()
    {
        return productId;
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

    public ArrayList getSpecialOffers()
    {
        return specialOffers;
    }

    public boolean isDisplayCertifiedLogo()
    {
        return displayCertifiedLogo;
    }

    public void setAvailability(Availability availability1)
    {
        availability = availability1;
    }

    public void setCondition(String s)
    {
        condition = s;
    }

    public void setDisplayCertifiedLogo(boolean flag)
    {
        displayCertifiedLogo = flag;
    }

    public void setDisplayCondition(String s)
    {
        displayCondition = s;
    }

    public void setFinancingOffers(ArrayList arraylist)
    {
        financingOffers = arraylist;
    }

    public void setPrice(Price price1)
    {
        price = price1;
    }

    public void setProductId(String s)
    {
        productId = s;
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

    public void setSpecialOffers(ArrayList arraylist)
    {
        specialOffers = arraylist;
    }
}
