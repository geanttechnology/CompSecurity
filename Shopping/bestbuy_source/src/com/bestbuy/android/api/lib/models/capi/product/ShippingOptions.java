// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.product;

import gs;
import java.util.ArrayList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ShippingOptions
{

    private static final String TAG = com/bestbuy/android/api/lib/models/capi/product/ShippingOptions.getSimpleName();
    private boolean freeShipping;
    private ArrayList shippingOptions;
    private String sku;

    public ShippingOptions()
    {
        shippingOptions = new ArrayList();
    }

    public static ShippingOptions loadData(Node node)
    {
        int i = 0;
        ShippingOptions shippingoptions = new ShippingOptions();
        Object obj = node.getAttributes();
        Node node2 = ((NamedNodeMap) (obj)).getNamedItem("sku-id");
        if (node2 != null)
        {
            shippingoptions.sku = node2.getNodeValue();
        }
        obj = ((NamedNodeMap) (obj)).getNamedItem("free-shipping");
        if (obj != null)
        {
            if (((Node) (obj)).getNodeValue().compareToIgnoreCase("true") == 0)
            {
                shippingoptions.freeShipping = true;
            } else
            {
                shippingoptions.freeShipping = false;
            }
        } else
        {
            shippingoptions.freeShipping = false;
        }
        shippingoptions.shippingOptions = new ArrayList();
        node = node.getChildNodes();
        while (i < node.getLength()) 
        {
            Node node1 = node.item(i);
            if (node1.getNodeName().compareTo("option") == 0)
            {
                shippingoptions.shippingOptions.add(ShippingOption.loadData(node1));
            } else
            {
                gs.d(TAG, (new StringBuilder()).append("Unknown elements found in while parsing ProductAggregate's shipping options: ").append(node1.getNodeName()).toString());
            }
            i++;
        }
        return shippingoptions;
    }

    public ArrayList getShippingOptions()
    {
        return shippingOptions;
    }

    public String getSku()
    {
        return sku;
    }

    public boolean isFreeShipping()
    {
        return freeShipping;
    }



    private class ShippingOption
    {

        private String currency;
        private Date expectedDeliveryDate;
        private String key;
        private String name;
        private double price;

        private static ShippingOption loadData(Node node)
        {
            ShippingOption shippingoption = new ShippingOption();
            Object obj = node.getAttributes();
            Node node1 = ((NamedNodeMap) (obj)).getNamedItem("price");
            if (node1 != null)
            {
                try
                {
                    shippingoption.price = Double.parseDouble(node1.getNodeValue());
                }
                catch (Exception exception)
                {
                    gs.d(ShippingOptions.TAG, (new StringBuilder()).append("Could not parse Shipping Option Price to double: ").append(node1.getNodeValue()).toString());
                }
            }
            node1 = ((NamedNodeMap) (obj)).getNamedItem("currency");
            if (node1 != null)
            {
                shippingoption.currency = node1.getNodeValue();
            }
            node1 = ((NamedNodeMap) (obj)).getNamedItem("expected-delivery-date");
            if (node1 != null)
            {
                String s = node1.getNodeValue();
                SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault());
                try
                {
                    shippingoption.expectedDeliveryDate = simpledateformat.parse(s);
                }
                catch (ParseException parseexception)
                {
                    gs.d(ShippingOptions.TAG, (new StringBuilder()).append("Could not parse Shipping Option expected-delivery-date: ").append(node1.getNodeValue()).toString());
                }
            }
            obj = ((NamedNodeMap) (obj)).getNamedItem("key");
            if (obj != null)
            {
                shippingoption.key = ((Node) (obj)).getNodeValue();
            }
            shippingoption.name = node.getTextContent();
            return shippingoption;
        }

        public String getCurrency()
        {
            return currency;
        }

        public Date getExpectedDeliveryDate()
        {
            return expectedDeliveryDate;
        }

        public String getKey()
        {
            return key;
        }

        public String getName()
        {
            return name;
        }

        public double getPrice()
        {
            return price;
        }


        public ShippingOption()
        {
        }
    }

}
