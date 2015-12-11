// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.ShippingStatus;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class ShippingEntity extends RetailSearchEntity
    implements Shipping
{

    private ShippingStatus addOn;
    private List additionalStatus;
    private ShippingStatus cod;
    private ShippingStatus fba;
    private List message;
    private boolean preOrder;
    private List priceLabel;
    private ShippingStatus prime;
    private List sss;

    public ShippingEntity()
    {
    }

    public ShippingStatus getAddOn()
    {
        return addOn;
    }

    public List getAdditionalStatus()
    {
        return additionalStatus;
    }

    public ShippingStatus getCod()
    {
        return cod;
    }

    public ShippingStatus getFba()
    {
        return fba;
    }

    public List getMessage()
    {
        return message;
    }

    public boolean getPreOrder()
    {
        return preOrder;
    }

    public List getPriceLabel()
    {
        return priceLabel;
    }

    public ShippingStatus getPrime()
    {
        return prime;
    }

    public List getSss()
    {
        return sss;
    }

    public void setAddOn(ShippingStatus shippingstatus)
    {
        addOn = shippingstatus;
    }

    public void setAdditionalStatus(List list)
    {
        additionalStatus = list;
    }

    public void setCod(ShippingStatus shippingstatus)
    {
        cod = shippingstatus;
    }

    public void setFba(ShippingStatus shippingstatus)
    {
        fba = shippingstatus;
    }

    public void setMessage(List list)
    {
        message = list;
    }

    public void setPreOrder(boolean flag)
    {
        preOrder = flag;
    }

    public void setPriceLabel(List list)
    {
        priceLabel = list;
    }

    public void setPrime(ShippingStatus shippingstatus)
    {
        prime = shippingstatus;
    }

    public void setSss(List list)
    {
        sss = list;
    }
}
