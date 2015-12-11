// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.product;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class StoreAvailability
{

    private String availabilityMessage;
    private String href;
    private String name;
    private boolean shipToStore;
    private String storeId;

    public StoreAvailability()
    {
    }

    public static StoreAvailability loadData(Node node)
    {
        StoreAvailability storeavailability;
label0:
        {
            storeavailability = new StoreAvailability();
            node = node.getAttributes();
            Node node1 = node.getNamedItem("id");
            if (node1 != null)
            {
                storeavailability.storeId = node1.getNodeValue();
            }
            node1 = node.getNamedItem("name");
            if (node1 != null)
            {
                storeavailability.name = node1.getNodeValue();
            }
            node1 = node.getNamedItem("availabilityMsg");
            if (node1 != null)
            {
                storeavailability.availabilityMessage = node1.getNodeValue();
            }
            node1 = node.getNamedItem("href");
            if (node1 != null)
            {
                storeavailability.href = node1.getNodeValue();
            }
            node = node.getNamedItem("ship-to-store");
            if (node != null)
            {
                if (node.getNodeValue().compareToIgnoreCase("true") != 0)
                {
                    break label0;
                }
                storeavailability.shipToStore = true;
            }
            return storeavailability;
        }
        storeavailability.shipToStore = false;
        return storeavailability;
    }

    public String getAvailabilityMessage()
    {
        return availabilityMessage;
    }

    public String getHref()
    {
        return href;
    }

    public String getName()
    {
        return name;
    }

    public String getStoreId()
    {
        return storeId;
    }

    public boolean isShipToStore()
    {
        return shipToStore;
    }
}
