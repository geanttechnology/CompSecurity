// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.rio.j2me.client.services.mShop.ShippingOffer;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController, BuyButtonType

public class BuyButtonController
{

    private final String dealId;
    private final String offerId;
    private ShippingOffer primeOneClickShippingOffer;
    private final ProductController productController;
    private final String shippingSpeed;
    private final BuyButtonType type;

    public BuyButtonController(BuyButtonType buybuttontype, ProductController productcontroller)
    {
        type = buybuttontype;
        productController = productcontroller;
        offerId = null;
        dealId = null;
        shippingSpeed = null;
        primeOneClickShippingOffer = null;
    }

    BuyButtonController(BuyButtonType buybuttontype, ProductController productcontroller, String s, String s1)
    {
        type = buybuttontype;
        productController = productcontroller;
        offerId = s;
        dealId = s1;
        shippingSpeed = null;
        primeOneClickShippingOffer = null;
    }

    public BuyButtonController(BuyButtonType buybuttontype, ProductController productcontroller, String s, String s1, ShippingOffer shippingoffer)
    {
        type = buybuttontype;
        productController = productcontroller;
        offerId = s;
        dealId = s1;
        shippingSpeed = shippingoffer.getShipOption();
        primeOneClickShippingOffer = shippingoffer;
    }

    BuyButtonController(BuyButtonType buybuttontype, ProductController productcontroller, String s, String s1, String s2)
    {
        type = buybuttontype;
        productController = productcontroller;
        offerId = s;
        dealId = s1;
        shippingSpeed = s2;
        primeOneClickShippingOffer = null;
    }

    public BuyButtonType getBuyButtonType()
    {
        return type;
    }

    public String getDealId()
    {
        return dealId;
    }

    public String getOfferId()
    {
        return offerId;
    }

    public ShippingOffer getPrimeOneClickShippingOffer()
    {
        return primeOneClickShippingOffer;
    }

    public ProductController getProductController()
    {
        return productController;
    }

    public String getShippingSpeed()
    {
        return shippingSpeed;
    }
}
