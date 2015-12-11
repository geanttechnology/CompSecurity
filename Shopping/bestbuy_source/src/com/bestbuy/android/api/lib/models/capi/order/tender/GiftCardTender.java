// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.tender;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class GiftCardTender
{

    private String cardNum;
    private String pin;

    public GiftCardTender()
    {
    }

    public static GiftCardTender loadData(Node node)
    {
        GiftCardTender giftcardtender = new GiftCardTender();
        node = node.getAttributes();
        giftcardtender.cardNum = node.getNamedItem("card-num").getTextContent();
        giftcardtender.pin = node.getNamedItem("pin").getTextContent();
        return giftcardtender;
    }

    public String getCardNum()
    {
        return cardNum;
    }

    public String getPin()
    {
        return pin;
    }

    public String getXML()
    {
        return (new StringBuilder()).append("<giftcard-tender card-num=\"").append(cardNum).append("\" pin=\"").append(pin).append("\"/>").toString();
    }
}
