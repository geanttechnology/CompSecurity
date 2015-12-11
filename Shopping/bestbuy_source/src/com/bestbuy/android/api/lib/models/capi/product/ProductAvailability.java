// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.product;

import gs;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProductAvailability
{

    private static final String TAG = com/bestbuy/android/api/lib/models/capi/product/ProductAvailability.getSimpleName();
    private String displayMessage;
    private int homeDeliveryCode;
    private String homeDeliveryMessage;
    private boolean instoreAvailabilty;
    private int maxQuantity;
    private int orderCode;
    private String sku;

    public ProductAvailability()
    {
    }

    public static ProductAvailability loadData(Node node)
    {
        ProductAvailability productavailability = new ProductAvailability();
        Node node1 = node.getAttributes().getNamedItem("sku-id");
        if (node1 != null)
        {
            productavailability.sku = node1.getNodeValue();
        }
        node = node.getChildNodes();
        int i = 0;
        while (i < node.getLength()) 
        {
            Object obj = node.item(i);
            if (((Node) (obj)).getNodeName().compareTo("order-code") == 0)
            {
                try
                {
                    productavailability.orderCode = Integer.parseInt(((Node) (obj)).getTextContent());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    gs.d(TAG, (new StringBuilder()).append("Could not parse order code to integer: ").append(((Exception) (obj)).getLocalizedMessage()).toString());
                }
            } else
            if (((Node) (obj)).getNodeName().compareTo("display-message") == 0)
            {
                productavailability.displayMessage = ((Node) (obj)).getTextContent();
            } else
            if (((Node) (obj)).getNodeName().compareTo("home-delivery-code") == 0)
            {
                try
                {
                    productavailability.homeDeliveryCode = Integer.parseInt(((Node) (obj)).getTextContent());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    gs.d(TAG, (new StringBuilder()).append("Could not parse home delivery code to integer: ").append(((Exception) (obj)).getLocalizedMessage()).toString());
                }
            } else
            if (((Node) (obj)).getNodeName().compareTo("home-delivery-message") == 0)
            {
                productavailability.homeDeliveryMessage = ((Node) (obj)).getTextContent();
            } else
            if (((Node) (obj)).getNodeName().compareTo("instore-availability") == 0)
            {
                if (((Node) (obj)).getTextContent().compareToIgnoreCase("true") == 0)
                {
                    productavailability.instoreAvailabilty = true;
                } else
                {
                    productavailability.instoreAvailabilty = false;
                }
            } else
            if (((Node) (obj)).getNodeName().compareTo("max-quantity") == 0)
            {
                try
                {
                    productavailability.maxQuantity = Integer.parseInt(((Node) (obj)).getTextContent());
                }
                catch (Exception exception)
                {
                    gs.d(TAG, (new StringBuilder()).append("Could not parse max quantity to integer: ").append(exception.getLocalizedMessage()).toString());
                }
            }
            i++;
        }
        return productavailability;
    }

    public String getDisplayMessage()
    {
        return displayMessage;
    }

    public int getHomeDeliveryCode()
    {
        return homeDeliveryCode;
    }

    public String getHomeDeliveryMessage()
    {
        return homeDeliveryMessage;
    }

    public int getMaxQuantity()
    {
        return maxQuantity;
    }

    public int getOrderCode()
    {
        return orderCode;
    }

    public String getSku()
    {
        return sku;
    }

    public boolean isInstoreAvailabilty()
    {
        return instoreAvailabilty;
    }

}
