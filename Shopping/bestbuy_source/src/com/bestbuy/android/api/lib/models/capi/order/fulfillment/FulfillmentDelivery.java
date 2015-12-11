// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.fulfillment;

import com.bestbuy.android.api.lib.models.capi.user.CAPIAddress;
import gv;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

// Referenced classes of package com.bestbuy.android.api.lib.models.capi.order.fulfillment:
//            Fulfillment

public class FulfillmentDelivery extends Fulfillment
{

    private CAPIAddress address;
    private Date deliveryDate;
    private Date startDate;

    public FulfillmentDelivery()
    {
    }

    public static FulfillmentDelivery loadData(String s, String s1, Date date, Date date1, CAPIAddress capiaddress)
    {
        FulfillmentDelivery fulfillmentdelivery = new FulfillmentDelivery();
        fulfillmentdelivery.itemId = s;
        fulfillmentdelivery.ffId = s1;
        fulfillmentdelivery.startDate = date;
        fulfillmentdelivery.deliveryDate = date1;
        fulfillmentdelivery.address = capiaddress;
        return fulfillmentdelivery;
    }

    public static FulfillmentDelivery loadData(Node node)
    {
        FulfillmentDelivery fulfillmentdelivery = new FulfillmentDelivery();
        node = node.getAttributes();
        fulfillmentdelivery.itemId = node.getNamedItem("item-id").getTextContent();
        fulfillmentdelivery.ffId = node.getNamedItem("id").getTextContent();
        return fulfillmentdelivery;
    }

    public CAPIAddress getAddress()
    {
        return address;
    }

    public Date getDelieveryDate()
    {
        return deliveryDate;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public String getXML()
    {
        String s;
        try
        {
            s = (new StringBuilder()).append("<homedelivery-fulfillment start-date=\"").append(gv.a.format(startDate)).append("\" delivery-date=\"").append(gv.a.format(deliveryDate)).append("\" item-id=\"").append(itemId).append("\"").toString();
            s = (new StringBuilder()).append(s).append("<address type=\"delivery\" verified=\"").append(address.isVerified()).append("\">").toString();
            s = (new StringBuilder()).append(s).append(getCAPIAddressGuts(address)).toString();
            s = (new StringBuilder()).append(s).append("</address></homedelivery-fulfillment>").toString();
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return s;
    }

    public void setAddress(CAPIAddress capiaddress)
    {
        address = capiaddress;
    }
}
