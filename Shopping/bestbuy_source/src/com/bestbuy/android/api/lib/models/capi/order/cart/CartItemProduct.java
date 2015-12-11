// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.cart;

import com.bestbuy.android.api.lib.models.capi.order.fulfillment.Fulfillment;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.bestbuy.android.api.lib.models.capi.order.cart:
//            CartItem

public class CartItemProduct extends CartItem
{

    private boolean ageVerified;
    private Fulfillment fulfillment;
    private int qty;
    private String warrantyId;

    public CartItemProduct()
    {
    }

    public static CartItemProduct loadData(String s, boolean flag, int i, String s1, Fulfillment fulfillment1)
    {
        CartItemProduct cartitemproduct = new CartItemProduct();
        cartitemproduct.itemId = s;
        cartitemproduct.ageVerified = flag;
        cartitemproduct.qty = i;
        cartitemproduct.sku = s1;
        cartitemproduct.fulfillment = fulfillment1;
        return cartitemproduct;
    }

    public static CartItemProduct loadData(Node node)
    {
        int i = 0;
        CartItemProduct cartitemproduct = new CartItemProduct();
        NamedNodeMap namednodemap = node.getAttributes();
        cartitemproduct.sku = namednodemap.getNamedItem("sku").getTextContent();
        cartitemproduct.itemId = namednodemap.getNamedItem("id").getTextContent();
        boolean flag;
        if (namednodemap.getNamedItem("backordered").getTextContent().compareToIgnoreCase("true") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cartitemproduct.backordered = flag;
        node = node.getChildNodes();
        while (i < node.getLength()) 
        {
            Node node1 = node.item(i);
            if (node1.getNodeName().compareTo("quantity") == 0)
            {
                cartitemproduct.qty = Integer.parseInt(node1.getTextContent());
            } else
            if (node1.getNodeName().compareTo("description") == 0)
            {
                cartitemproduct.description = node1.getTextContent();
            } else
            if (node1.getNodeName().compareTo("unit-price") == 0)
            {
                cartitemproduct.cost = Double.parseDouble(node1.getTextContent());
            } else
            if (node1.getNodeName().compareTo("shipping-cost") == 0)
            {
                cartitemproduct.shippingCost = Double.parseDouble(node1.getTextContent());
            } else
            if (node1.getNodeName().compareTo("tax-cost") == 0)
            {
                cartitemproduct.taxCost = Double.parseDouble(node1.getTextContent());
            }
            i++;
        }
        return cartitemproduct;
    }

    public Fulfillment getFulfillment()
    {
        return fulfillment;
    }

    public int getQty()
    {
        return qty;
    }

    public String getWarrantyId()
    {
        return warrantyId;
    }

    public String getXML()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("<item id=\"").append(itemId).append("\" age-verified=\"");
        String s;
        if (ageVerified)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        s = stringbuilder.append(s).append("\">").toString();
        s = (new StringBuilder()).append(s).append("<quantity>").append(qty).append("</quantity>").toString();
        s = (new StringBuilder()).append(s).append("<link rel=\"src\" href=\"http://server/sku/us/").append(sku).append(".xml\"/>").toString();
        return (new StringBuilder()).append(s).append("</item>").toString();
    }

    public boolean isAgeVerified()
    {
        return ageVerified;
    }

    public void setFulfillment(Fulfillment fulfillment1)
    {
        fulfillment = fulfillment1;
    }
}
