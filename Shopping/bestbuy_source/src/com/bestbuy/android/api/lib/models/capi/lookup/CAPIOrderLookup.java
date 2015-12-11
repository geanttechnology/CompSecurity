// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.lookup;

import gv;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.bestbuy.android.api.lib.models.capi.lookup:
//            LookupType

public class CAPIOrderLookup
{

    private String link;
    private Date orderDate;
    private String orderId;
    private String status;
    private double total;

    public CAPIOrderLookup()
    {
    }

    public static String getXML(LookupType lookuptype, String s, String s1, String s2)
    {
        if (lookuptype.compareTo(LookupType.CAPIOrderLookupBBY) == 0)
        {
            lookuptype = (new StringBuilder()).append("<order-query>").append("<order-id>").append(s).append("</order-id>").toString();
        } else
        {
            lookuptype = (new StringBuilder()).append("<order-query>").append("<customer-order-id>").append(s).append("</customer-order-id>").toString();
        }
        return (new StringBuilder()).append(lookuptype).append("<last-name>").append(s1).append("</last-name><phone-number>").append(s2).append("</phone-number></order-query>").toString();
    }

    public static CAPIOrderLookup loadData(Node node)
    {
        CAPIOrderLookup capiorderlookup = new CAPIOrderLookup();
        NamedNodeMap namednodemap = node.getAttributes();
        capiorderlookup.orderId = namednodemap.getNamedItem("id").getTextContent();
        capiorderlookup.status = namednodemap.getNamedItem("status").getTextContent();
        Node node2 = namednodemap.getNamedItem("order-date");
        capiorderlookup.orderDate = gv.a.parse(node2.getTextContent());
        capiorderlookup.total = Double.parseDouble(namednodemap.getNamedItem("total").getTextContent());
        node = node.getChildNodes();
        for (int i = 0; i < node.getLength(); i++)
        {
            Node node1 = node.item(i);
            if (node1.getNodeName().compareTo("link") == 0)
            {
                capiorderlookup.link = node1.getAttributes().getNamedItem("href").getTextContent();
            }
        }

        return capiorderlookup;
    }

    public String getLink()
    {
        return link;
    }

    public Date getOrderDate()
    {
        return orderDate;
    }

    public String getOrderId()
    {
        return orderId;
    }

    public String getStatus()
    {
        return status;
    }

    public double getTotal()
    {
        return total;
    }
}
