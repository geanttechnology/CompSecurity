// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            ButtonInfo, UniversalLink, InterstitialCartItemsInfo

public class CartItems
{

    private List alertMessages;
    private List alertMessagesDetailed;
    private ButtonInfo alternateCartButton;
    private UniversalLink cartButtonUri;
    private List cartItem;
    private InterstitialCartItemsInfo interstitialCartInfo;
    private List messages;
    private String pointsTotal;
    private String subtotal;

    public CartItems()
    {
    }

    public List getCartItem()
    {
        return cartItem;
    }

    public List getMessages()
    {
        return messages;
    }

    public void setAlertMessages(List list)
    {
        alertMessages = list;
    }

    public void setAlertMessagesDetailed(List list)
    {
        alertMessagesDetailed = list;
    }

    public void setAlternateCartButton(ButtonInfo buttoninfo)
    {
        alternateCartButton = buttoninfo;
    }

    public void setCartButtonUri(UniversalLink universallink)
    {
        cartButtonUri = universallink;
    }

    public void setCartItem(List list)
    {
        cartItem = list;
    }

    public void setInterstitialCartInfo(InterstitialCartItemsInfo interstitialcartitemsinfo)
    {
        interstitialCartInfo = interstitialcartitemsinfo;
    }

    public void setMessages(List list)
    {
        messages = list;
    }

    public void setPointsTotal(String s)
    {
        pointsTotal = s;
    }

    public void setSubtotal(String s)
    {
        subtotal = s;
    }
}
