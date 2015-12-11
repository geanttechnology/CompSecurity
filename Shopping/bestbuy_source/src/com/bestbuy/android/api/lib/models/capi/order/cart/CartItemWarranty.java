// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.cart;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.bestbuy.android.api.lib.models.capi.order.cart:
//            CartItem

public class CartItemWarranty extends CartItem
{

    private String parentId;
    private String parentSku;
    private String state;

    public CartItemWarranty()
    {
    }

    public static CartItemWarranty loadData(String s, String s1, String s2, String s3)
    {
        CartItemWarranty cartitemwarranty = new CartItemWarranty();
        cartitemwarranty.itemId = s;
        cartitemwarranty.parentId = s1;
        cartitemwarranty.state = s2;
        cartitemwarranty.sku = s3;
        return cartitemwarranty;
    }

    public static CartItemWarranty loadData(Node node)
    {
        int i = 0;
        CartItemWarranty cartitemwarranty = new CartItemWarranty();
        NamedNodeMap namednodemap = node.getAttributes();
        cartitemwarranty.sku = namednodemap.getNamedItem("sku").getTextContent();
        cartitemwarranty.itemId = namednodemap.getNamedItem("id").getTextContent();
        boolean flag;
        if (namednodemap.getNamedItem("backordered").getTextContent().compareToIgnoreCase("true") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cartitemwarranty.backordered = flag;
        node = node.getChildNodes();
        while (i < node.getLength()) 
        {
            Node node1 = node.item(i);
            if (node1.getNodeName().compareToIgnoreCase("description") == 0)
            {
                cartitemwarranty.description = node1.getTextContent();
            } else
            if (node1.getNodeName().compareToIgnoreCase("unit-price") == 0)
            {
                cartitemwarranty.unitPrice = Double.parseDouble(node1.getTextContent());
            } else
            if (node1.getNodeName().compareToIgnoreCase("shipping-cost") == 0)
            {
                cartitemwarranty.shippingCost = Double.parseDouble(node1.getTextContent());
            } else
            if (node1.getNodeName().compareToIgnoreCase("tax-cost") == 0)
            {
                cartitemwarranty.taxCost = Double.parseDouble(node1.getTextContent());
            }
            i++;
        }
        return cartitemwarranty;
    }

    public String getParentId()
    {
        return parentId;
    }

    public String getParentSku()
    {
        return parentSku;
    }

    public String getState()
    {
        return state;
    }

    public String getXML()
    {
        String s = (new StringBuilder()).append("<item id=\"").append(itemId).append("\" parent-item=\"").append(parentId).append("\" state=\"").append(state).append("\">").toString();
        s = (new StringBuilder()).append(s).append("<quantity>1</quantity>").toString();
        s = (new StringBuilder()).append(s).append("<link rel=\"src\" href=\"http://server/sku/us/").append(sku).append(".xml\"/>").toString();
        return (new StringBuilder()).append(s).append("</item>").toString();
    }
}
