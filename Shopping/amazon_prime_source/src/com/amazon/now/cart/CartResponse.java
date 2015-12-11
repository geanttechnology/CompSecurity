// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cart;


public class CartResponse
{

    private CartRequest.CartAction mCartAction;
    private int mCartCount;
    private String mError;
    private boolean mIsValid;
    private int mItemCount;
    private String mItemId;
    private int mStockOnHand;

    public CartResponse()
    {
        mCartCount = -1;
        mItemCount = -1;
        mCartAction = CartRequest.CartAction.GET;
        mIsValid = true;
    }

    public CartRequest.CartAction getCartAction()
    {
        return mCartAction;
    }

    public int getCartCount()
    {
        return mCartCount;
    }

    public String getError()
    {
        return mError;
    }

    public int getItemCount()
    {
        return mItemCount;
    }

    public String getItemId()
    {
        return mItemId;
    }

    public int getStockOnHand()
    {
        return mStockOnHand;
    }

    public boolean isValid()
    {
        return mIsValid;
    }

    public void setCartAction(CartRequest.CartAction cartaction)
    {
        mCartAction = cartaction;
    }

    public void setCartCount(int i)
    {
        mCartCount = i;
    }

    public void setCartError(String s)
    {
        mError = s;
    }

    public void setIsValid(boolean flag)
    {
        mIsValid = flag;
    }

    public void setItemCount(int i)
    {
        mItemCount = i;
    }

    public void setItemId(String s)
    {
        mItemId = s;
    }

    public void setStockOnHand(int i)
    {
        mStockOnHand = i;
    }
}
