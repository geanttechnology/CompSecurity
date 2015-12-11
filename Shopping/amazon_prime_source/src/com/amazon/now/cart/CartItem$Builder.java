// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cart;


// Referenced classes of package com.amazon.now.cart:
//            CartItem

public static class 
{

    private String asin;
    private String itemId;
    private String merchantId;
    private String offerId;
    private String price;
    private String productDetailUrl;
    private int quantity;
    private int stockOnHand;
    private String title;

    public  asin(String s)
    {
        asin = s;
        return this;
    }

    public CartItem build()
    {
        return new CartItem(asin, offerId, itemId, title, price, merchantId, productDetailUrl, stockOnHand, quantity, null);
    }

    public quantity itemId(String s)
    {
        itemId = s;
        return this;
    }

    public itemId merchantId(String s)
    {
        merchantId = s;
        return this;
    }

    public merchantId offerId(String s)
    {
        offerId = s;
        return this;
    }

    public offerId price(String s)
    {
        price = s;
        return this;
    }

    public price productDetailUrl(String s)
    {
        productDetailUrl = s;
        return this;
    }

    public productDetailUrl quantity(int i)
    {
        quantity = i;
        return this;
    }

    public quantity stockOnHand(int i)
    {
        stockOnHand = i;
        return this;
    }

    public stockOnHand title(String s)
    {
        title = s;
        return this;
    }

    public ()
    {
    }
}
