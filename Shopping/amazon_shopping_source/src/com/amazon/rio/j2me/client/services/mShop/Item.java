// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            MerchantInfo

public class Item
{

    private String asin;
    private String binding;
    private String byLine;
    private String imageUrl;
    private String itemId;
    private String lineItemId;
    private MerchantInfo merchantInfo;
    private String price;
    private int quantity;
    private List status;
    private String title;

    public Item()
    {
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setBinding(String s)
    {
        binding = s;
    }

    public void setByLine(String s)
    {
        byLine = s;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setItemId(String s)
    {
        itemId = s;
    }

    public void setLineItemId(String s)
    {
        lineItemId = s;
    }

    public void setMerchantInfo(MerchantInfo merchantinfo)
    {
        merchantInfo = merchantinfo;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setQuantity(int i)
    {
        quantity = i;
    }

    public void setStatus(List list)
    {
        status = list;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
