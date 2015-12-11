// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.fulfillment;

import com.bestbuy.android.api.lib.models.capi.user.FriendsFamily;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.bestbuy.android.api.lib.models.capi.order.fulfillment:
//            Fulfillment

public class FulfillmentStore extends Fulfillment
{

    private FriendsFamily agent;
    private boolean shipToStore;
    private String storeId;

    public FulfillmentStore()
    {
    }

    public static FulfillmentStore loadData(String s, String s1, String s2, boolean flag, FriendsFamily friendsfamily)
    {
        FulfillmentStore fulfillmentstore = new FulfillmentStore();
        fulfillmentstore.itemId = s;
        fulfillmentstore.ffId = s1;
        fulfillmentstore.storeId = s2;
        fulfillmentstore.shipToStore = flag;
        fulfillmentstore.agent = friendsfamily;
        return fulfillmentstore;
    }

    public static FulfillmentStore loadData(Node node)
    {
        int i = 0;
        FulfillmentStore fulfillmentstore = new FulfillmentStore();
        NamedNodeMap namednodemap = node.getAttributes();
        fulfillmentstore.storeId = namednodemap.getNamedItem("store-id").getTextContent();
        fulfillmentstore.itemId = namednodemap.getNamedItem("item-id").getTextContent();
        boolean flag;
        if (namednodemap.getNamedItem("item-id").getTextContent().compareToIgnoreCase("true") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        fulfillmentstore.shipToStore = flag;
        node = node.getChildNodes();
        do
        {
label0:
            {
                if (i < node.getLength())
                {
                    Node node1 = node.item(i);
                    if (node1.getNodeName().compareTo("friends-family-details") != 0)
                    {
                        break label0;
                    }
                    fulfillmentstore.agent = FriendsFamily.loadData(node1);
                }
                return fulfillmentstore;
            }
            i++;
        } while (true);
    }

    public FriendsFamily getAgent()
    {
        return agent;
    }

    public String getStoreId()
    {
        return storeId;
    }

    public String getXML()
    {
        Object obj = (new StringBuilder()).append("").append("<store-fulfillment store-id=\"").append(storeId).append("\" item-id=\"").append(itemId).append("\" ship-to-store=\"");
        String s;
        if (shipToStore)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        obj = ((StringBuilder) (obj)).append(s).append("\">").toString();
        s = ((String) (obj));
        if (agent != null)
        {
            s = (new StringBuilder()).append(((String) (obj))).append("<friends-family-details><firstname>").append(agent.getFirstName()).append("</firstname>").append("<lastname>").append(agent.getLastName()).append("</lastname>").append("<emailaddress>").append(agent.getEmail()).append("</emailaddress>").append("<phonenumber>").append(agent.getPhoneNumber()).append("</phonenumber>").append("</friends-family-details>").toString();
        }
        return (new StringBuilder()).append(s).append("</store-fulfillment>").toString();
    }

    public boolean isShipToStore()
    {
        return shipToStore;
    }
}
