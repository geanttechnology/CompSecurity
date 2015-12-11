// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.cart;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.cart:
//            GiftItem

public class CartRequest
    implements gu, Serializable
{

    private String childType;
    private GiftItem giftItem;
    private String listingId;
    private String lpnId;
    private String parentLineItemId;
    private int quantity;
    private String sellerId;
    private boolean shipToStore;
    private String skuId;
    private String storeId;
    private boolean strClrFlg;
    private boolean warrantyItem;

    public CartRequest()
    {
    }

    public String getChildType()
    {
        return childType;
    }

    public GiftItem getGiftItem()
    {
        return giftItem;
    }

    public String getListingId()
    {
        return listingId;
    }

    public String getLpnId()
    {
        return lpnId;
    }

    public String getParentLineItemId()
    {
        return parentLineItemId;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String getSellerId()
    {
        return sellerId;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public String getStoreId()
    {
        return storeId;
    }

    public boolean isShipToStore()
    {
        return shipToStore;
    }

    public boolean isStrClrFlg()
    {
        return strClrFlg;
    }

    public boolean isWarrantyItem()
    {
        return warrantyItem;
    }

    public void setChildType(String s)
    {
        childType = s;
    }

    public void setGiftItem(GiftItem giftitem)
    {
        giftItem = giftitem;
    }

    public void setListingId(String s)
    {
        listingId = s;
    }

    public void setLpnId(String s)
    {
        lpnId = s;
    }

    public void setParentLineItemId(String s)
    {
        parentLineItemId = s;
    }

    public void setQuantity(int i)
    {
        quantity = i;
    }

    public void setSellerId(String s)
    {
        sellerId = s;
    }

    public void setShipToStore(boolean flag)
    {
        shipToStore = flag;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }

    public void setStoreId(String s)
    {
        storeId = s;
    }

    public void setStrClrFlg(boolean flag)
    {
        strClrFlg = flag;
    }

    public void setWarrantyItem(boolean flag)
    {
        warrantyItem = flag;
    }
}
