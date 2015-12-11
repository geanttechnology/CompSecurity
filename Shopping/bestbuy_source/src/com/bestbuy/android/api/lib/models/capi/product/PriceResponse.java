// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.product;

import gs;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PriceResponse
{

    private static final String TAG = com/bestbuy/android/api/lib/models/capi/product/PriceResponse.getSimpleName();
    private String currency;
    private double price;
    private String sku;

    public PriceResponse()
    {
    }

    public static PriceResponse loadPriceData(Node node)
    {
        PriceResponse priceresponse = new PriceResponse();
        node = node.getChildNodes();
        int i = 0;
        while (i < node.getLength()) 
        {
            Node node1 = node.item(i);
            if (node1.getNodeName().compareTo("unit-price") == 0)
            {
                Object obj = node1.getAttributes();
                Node node2 = ((NamedNodeMap) (obj)).getNamedItem("sku-id");
                if (node2 != null)
                {
                    priceresponse.sku = node2.getNodeValue();
                }
                obj = ((NamedNodeMap) (obj)).getNamedItem("currency");
                if (obj != null)
                {
                    priceresponse.currency = ((Node) (obj)).getNodeValue();
                }
                try
                {
                    priceresponse.price = Double.parseDouble(node1.getTextContent());
                }
                catch (Exception exception)
                {
                    gs.e(TAG, (new StringBuilder()).append("Could not parse price into double: ").append(exception.getLocalizedMessage()).toString());
                }
            }
            i++;
        }
        return priceresponse;
    }

    public static PriceResponse loadTaxData(Node node)
    {
        PriceResponse priceresponse = new PriceResponse();
        Object obj = node.getAttributes();
        Node node2 = ((NamedNodeMap) (obj)).getNamedItem("sku-id");
        if (node2 != null)
        {
            priceresponse.sku = node2.getNodeValue();
        }
        obj = ((NamedNodeMap) (obj)).getNamedItem("currency");
        if (obj != null)
        {
            priceresponse.currency = ((Node) (obj)).getNodeValue();
        }
        node = node.getChildNodes();
        int i = 0;
        while (i < node.getLength()) 
        {
            Node node1 = node.item(i);
            if (node1.getNodeName().compareTo("value") == 0)
            {
                try
                {
                    priceresponse.price = Double.parseDouble(node1.getTextContent());
                }
                catch (Exception exception)
                {
                    gs.e(TAG, (new StringBuilder()).append("Could not parse price into double: ").append(exception.getLocalizedMessage()).toString());
                }
            }
            i++;
        }
        return priceresponse;
    }

    public String getCurrency()
    {
        return currency;
    }

    public double getPrice()
    {
        return price;
    }

    public String getSku()
    {
        return sku;
    }

}
