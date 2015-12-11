// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.OrderItemTransaction;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class currentTx extends com.ebay.nautilus.kernel.util.l
{

    private final OrderItemTransaction currentTx;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.l get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            final com.ebay.common.model.etailsXml std = (com.ebay.common.model.etailsXml)currentTx.shipmentTrackingDetails.get(currentTx.shipmentTrackingDetails.size() - 1);
            if ("ShipmentTrackingNumber".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipmentTrackingDetailsXml this$1;
                    final com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails val$std;

                    public void text(String s3)
                        throws SAXException
                    {
                        std.shipmentTrackingNumber = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipmentTrackingDetailsXml.this;
                std = shipmenttrackingdetails;
                super();
            }
                };
            }
            if ("ShippingCarrierUsed".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipmentTrackingDetailsXml this$1;
                    final com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails val$std;

                    public void text(String s3)
                        throws SAXException
                    {
                        std.shippingCarrierUsed = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipmentTrackingDetailsXml.this;
                std = shipmenttrackingdetails;
                super();
            }
                };
            }
        }
        return super.l(s, s1, s2, attributes);
    }

    public _cls2.val.std(OrderItemTransaction orderitemtransaction)
    {
        this$0 = GetOrdersResponse.this;
        super();
        currentTx = orderitemtransaction;
        getordersresponse = currentTx;
        getClass();
        getordersresponse = new com.ebay.common.model.>(GetOrdersResponse.this);
        currentTx.shipmentTrackingDetails.add(GetOrdersResponse.this);
    }
}
