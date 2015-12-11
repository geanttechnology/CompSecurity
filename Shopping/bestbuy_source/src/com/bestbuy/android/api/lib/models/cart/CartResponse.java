// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.cart;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class CartResponse
    implements gu, Serializable
{

    private String cartId;
    private String commerceItemId;
    private ArrayList cookieHeaders;
    private boolean error;
    private boolean isHaccs;
    private boolean isICR;
    private String msg;
    private String productId;
    private int quantity;
    private String skuId;
    private boolean tryagainMsg;
    private String userId;

    public CartResponse()
    {
    }

    public String getCartId()
    {
        return cartId;
    }

    public String getCommerceItemId()
    {
        return commerceItemId;
    }

    public ArrayList getCookieHeaders()
    {
        return cookieHeaders;
    }

    public String getMsg()
    {
        return msg;
    }

    public String getProductId()
    {
        return productId;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public String getUserId()
    {
        return userId;
    }

    public boolean isError()
    {
        return error;
    }

    public boolean isHaccs()
    {
        return isHaccs;
    }

    public boolean isICR()
    {
        return isICR;
    }

    public boolean isTryagainMsg()
    {
        return tryagainMsg;
    }

    public void setCartId(String s)
    {
        cartId = s;
    }

    public void setCommerceItemId(String s)
    {
        commerceItemId = s;
    }

    public void setCookieHeaders(ArrayList arraylist)
    {
        cookieHeaders = arraylist;
    }

    public void setError(boolean flag)
    {
        error = flag;
    }

    public void setIsHaccs(boolean flag)
    {
        isHaccs = flag;
    }

    public void setIsICR(boolean flag)
    {
        isICR = flag;
    }

    public void setMsg(String s)
    {
        msg = s;
    }

    public void setProductId(String s)
    {
        productId = s;
    }

    public void setQuantity(int i)
    {
        quantity = i;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }

    public void setTryagainMsg(boolean flag)
    {
        tryagainMsg = flag;
    }

    public void setUserId(String s)
    {
        userId = s;
    }
}
