// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cart;


public class CartItem
{
    public static class Builder
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

        public Builder asin(String s)
        {
            asin = s;
            return this;
        }

        public CartItem build()
        {
            return new CartItem(asin, offerId, itemId, title, price, merchantId, productDetailUrl, stockOnHand, quantity);
        }

        public Builder itemId(String s)
        {
            itemId = s;
            return this;
        }

        public Builder merchantId(String s)
        {
            merchantId = s;
            return this;
        }

        public Builder offerId(String s)
        {
            offerId = s;
            return this;
        }

        public Builder price(String s)
        {
            price = s;
            return this;
        }

        public Builder productDetailUrl(String s)
        {
            productDetailUrl = s;
            return this;
        }

        public Builder quantity(int i)
        {
            quantity = i;
            return this;
        }

        public Builder stockOnHand(int i)
        {
            stockOnHand = i;
            return this;
        }

        public Builder title(String s)
        {
            title = s;
            return this;
        }

        public Builder()
        {
        }
    }


    private final String mAsin;
    private final String mItemId;
    private final String mMerchantId;
    private final String mOfferId;
    private final String mPrice;
    private final String mProductDetailUrl;
    private final int mQuantity;
    private final int mStockOnHand;
    private final String mTitle;

    private CartItem(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            int i, int j)
    {
        mAsin = s;
        mOfferId = s1;
        mItemId = s2;
        mTitle = s3;
        mPrice = s4;
        mMerchantId = s5;
        mProductDetailUrl = s6;
        mStockOnHand = i;
        mQuantity = j;
    }


    public String getAsin()
    {
        return mAsin;
    }

    public String getItemId()
    {
        return mItemId;
    }

    public String getMerchantId()
    {
        return mMerchantId;
    }

    public String getOfferId()
    {
        return mOfferId;
    }

    public String getPrice()
    {
        return mPrice;
    }

    public String getProductDetailUrl()
    {
        return mProductDetailUrl;
    }

    public int getQuantity()
    {
        return mQuantity;
    }

    public int getStockOnHand()
    {
        return mStockOnHand;
    }

    public String getTitle()
    {
        return mTitle;
    }
}
