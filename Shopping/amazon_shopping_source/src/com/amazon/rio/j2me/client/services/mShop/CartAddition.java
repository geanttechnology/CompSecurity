// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class CartAddition
{

    private String asin;
    private String dealId;
    private boolean isSavedItem;
    private String listId;
    private String listItemId;
    private String offerId;
    private int quantity;

    public CartAddition()
    {
    }

    public String getAsin()
    {
        return asin;
    }

    public String getDealId()
    {
        return dealId;
    }

    public boolean getIsSavedItem()
    {
        return isSavedItem;
    }

    public String getListId()
    {
        return listId;
    }

    public String getListItemId()
    {
        return listItemId;
    }

    public String getOfferId()
    {
        return offerId;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setDealId(String s)
    {
        dealId = s;
    }

    public void setListId(String s)
    {
        listId = s;
    }

    public void setListItemId(String s)
    {
        listItemId = s;
    }

    public void setOfferId(String s)
    {
        offerId = s;
    }

    public void setQuantity(int i)
    {
        quantity = i;
    }
}
