// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class this._cls0 extends com.ebay.nautilus.kernel.util.l
{

    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.l get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            final com.ebay.common.model.etailsXml std = (com.ebay.common.model.etailsXml)GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this).shipmentTrackingDetails.get(GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this).shipmentTrackingDetails.size() - 1);
            if ("ShipmentTrackingNumber".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipmentTrackingDetailsXml this$1;
                    final com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails val$std;

                    public void text(String s3)
                        throws SAXException
                    {
                        std.shipmentTrackingNumber = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipmentTrackingDetailsXml.this;
                std = shipmenttrackingdetails;
                super();
            }
                };
            }
            if ("ShippingCarrierUsed".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipmentTrackingDetailsXml this$1;
                    final com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails val$std;

                    public void text(String s3)
                        throws SAXException
                    {
                        std.shippingCarrierUsed = s3;
                        ItemTransaction itemtransaction = GetItemTransactionsResponse.access$600(this$0);
                        boolean flag;
                        if ("eBay Now".equalsIgnoreCase(s3) || "Scheduled Delivery".equalsIgnoreCase(s3))
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        itemtransaction.isEbayNow = flag;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipmentTrackingDetailsXml.this;
                std = shipmenttrackingdetails;
                super();
            }
                };
            }
        }
        return super.l(s, s1, s2, attributes);
    }

    public _cls2.val.std()
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
        Object obj = GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this);
        obj.getClass();
        obj = new com.ebay.common.model.etailsXml.this._cls0(((ItemTransaction) (obj)));
        GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this).shipmentTrackingDetails.add(obj);
    }
}
