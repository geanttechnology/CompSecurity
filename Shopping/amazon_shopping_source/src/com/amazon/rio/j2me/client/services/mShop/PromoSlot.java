// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            Action, HomeItem

public class PromoSlot
{

    private Action action;
    private String clickStreamOrigin;
    private String imageUrl;
    private HomeItem product;
    private String productHeader;
    private String slotToken;

    public PromoSlot()
    {
    }

    public Action getAction()
    {
        return action;
    }

    public String getClickStreamOrigin()
    {
        return clickStreamOrigin;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public HomeItem getProduct()
    {
        return product;
    }

    public String getProductHeader()
    {
        return productHeader;
    }

    public String getSlotToken()
    {
        return slotToken;
    }

    public void setAction(Action action1)
    {
        action = action1;
    }

    public void setClickStreamOrigin(String s)
    {
        clickStreamOrigin = s;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setProduct(HomeItem homeitem)
    {
        product = homeitem;
    }

    public void setProductHeader(String s)
    {
        productHeader = s;
    }

    public void setSlotToken(String s)
    {
        slotToken = s;
    }
}
