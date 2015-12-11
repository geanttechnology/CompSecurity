// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.lookup;

import gs;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GiftCard
{

    private static final String TAG = com/bestbuy/android/api/lib/models/capi/lookup/GiftCard.getSimpleName();
    private String cardNumber;
    private String currency;
    private double value;

    public GiftCard()
    {
    }

    public static GiftCard loadData(Node node)
    {
        GiftCard giftcard = new GiftCard();
        node = node.getChildNodes();
        int i = 0;
        while (i < node.getLength()) 
        {
            Node node1 = node.item(i);
            if (node1.getNodeName().compareTo("gift-card") == 0)
            {
                Object obj = node1.getAttributes();
                Node node2 = ((NamedNodeMap) (obj)).getNamedItem("card-num");
                if (node2 != null)
                {
                    giftcard.cardNumber = node2.getNodeValue();
                }
                obj = ((NamedNodeMap) (obj)).getNamedItem("currency");
                if (obj != null)
                {
                    giftcard.currency = ((Node) (obj)).getNodeValue();
                }
                try
                {
                    giftcard.value = Double.parseDouble(node1.getTextContent());
                }
                catch (Exception exception)
                {
                    gs.e(TAG, (new StringBuilder()).append("Could not parse price into double: ").append(exception.getLocalizedMessage()).toString());
                }
            }
            i++;
        }
        return giftcard;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public String getCurrency()
    {
        return currency;
    }

    public double getValue()
    {
        return value;
    }

    public void setCardNumber(String s)
    {
        cardNumber = s;
    }

    public void setCurrency(String s)
    {
        currency = s;
    }

    public void setValue(double d)
    {
        value = d;
    }

}
