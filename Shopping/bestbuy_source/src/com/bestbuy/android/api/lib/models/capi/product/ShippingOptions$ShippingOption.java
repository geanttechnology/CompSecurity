// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.product;

import gs;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

// Referenced classes of package com.bestbuy.android.api.lib.models.capi.product:
//            ShippingOptions

public class 
{

    private String currency;
    private Date expectedDeliveryDate;
    private String key;
    private String name;
    private double price;

    private static  loadData(Node node)
    {
          = new <init>();
        Object obj = node.getAttributes();
        Node node1 = ((NamedNodeMap) (obj)).getNamedItem("price");
        if (node1 != null)
        {
            try
            {
                .price = Double.parseDouble(node1.getNodeValue());
            }
            catch (Exception exception)
            {
                gs.d(ShippingOptions.access$100(), (new StringBuilder()).append("Could not parse Shipping Option Price to double: ").append(node1.getNodeValue()).toString());
            }
        }
        node1 = ((NamedNodeMap) (obj)).getNamedItem("currency");
        if (node1 != null)
        {
            .currency = node1.getNodeValue();
        }
        node1 = ((NamedNodeMap) (obj)).getNamedItem("expected-delivery-date");
        if (node1 != null)
        {
            String s = node1.getNodeValue();
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault());
            try
            {
                .expectedDeliveryDate = simpledateformat.parse(s);
            }
            catch (ParseException parseexception)
            {
                gs.d(ShippingOptions.access$100(), (new StringBuilder()).append("Could not parse Shipping Option expected-delivery-date: ").append(node1.getNodeValue()).toString());
            }
        }
        obj = ((NamedNodeMap) (obj)).getNamedItem("key");
        if (obj != null)
        {
            .key = ((Node) (obj)).getNodeValue();
        }
        .name = node.getTextContent();
        return ;
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


    public ()
    {
    }
}
