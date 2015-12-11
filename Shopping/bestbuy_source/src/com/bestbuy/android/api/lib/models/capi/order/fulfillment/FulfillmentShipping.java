// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.capi.order.fulfillment;

import com.bestbuy.android.api.lib.models.capi.user.CAPIAddress;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

// Referenced classes of package com.bestbuy.android.api.lib.models.capi.order.fulfillment:
//            Fulfillment

public class FulfillmentShipping extends Fulfillment
{

    private CAPIAddress address;
    private String estimatedDeliveryDateRange;
    private String shippingOption;

    public FulfillmentShipping()
    {
    }

    public static FulfillmentShipping loadData(String s, String s1, String s2, String s3, CAPIAddress capiaddress)
    {
        FulfillmentShipping fulfillmentshipping = new FulfillmentShipping();
        fulfillmentshipping.itemId = s;
        fulfillmentshipping.ffId = s1;
        fulfillmentshipping.shippingOption = s2;
        fulfillmentshipping.estimatedDeliveryDateRange = s3;
        fulfillmentshipping.address = capiaddress;
        return fulfillmentshipping;
    }

    public static FulfillmentShipping loadData(Node node)
    {
        FulfillmentShipping fulfillmentshipping = new FulfillmentShipping();
        node = node.getAttributes();
        fulfillmentshipping.shippingOption = node.getNamedItem("shipping-option").getTextContent();
        fulfillmentshipping.itemId = node.getNamedItem("item-id").getTextContent();
        fulfillmentshipping.ffId = node.getNamedItem("id").getTextContent();
        return fulfillmentshipping;
    }

    public CAPIAddress getAddress()
    {
        return address;
    }

    public String getEstimatedDeliveryDateRange()
    {
        return estimatedDeliveryDateRange;
    }

    public String getShippingOption()
    {
        return shippingOption;
    }

    public String getXML()
    {
        String s;
        try
        {
            s = (new StringBuilder()).append("").append("<address-fulfillment item-id=\"").append(itemId).append("\"><shipping option=\"").append(shippingOption).append("\"/><address type=\"Shipping\" verified=\"").append(address.isVerified()).append("\">").toString();
            s = (new StringBuilder()).append(s).append(getCAPIAddressGuts(address)).toString();
            s = (new StringBuilder()).append(s).append("</address></address-fulfillment>").toString();
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
