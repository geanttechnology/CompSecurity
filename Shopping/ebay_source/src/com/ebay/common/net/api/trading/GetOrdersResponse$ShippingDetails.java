// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.OrderItemTransaction;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class currentTx extends com.ebay.nautilus.kernel.util.s
{

    private final OrderItemTransaction currentTx;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.s get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("ShippingType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingDetails this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.shippingType = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingDetails.this;
                super();
            }
                };
            }
            if ("ThirdPartyCheckout".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetOrdersResponse.ShippingDetails this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        currentTx.thirdPartyCheckout = flag;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingDetails.this;
                super();
            }
                };
            }
            if ("ShipmentTrackingDetails".equals(s1))
            {
                return new DetailsXml(GetOrdersResponse.this, currentTx);
            }
            if ("ShippingServiceOptions".equals(s1))
            {
                return new ption(GetOrdersResponse.this, currentTx);
            }
            if ("InternationalShippingServiceOption".equals(s1))
            {
                return new ption(GetOrdersResponse.this, currentTx);
            }
            if ("SalesTax".equals(s1))
            {
                return new currentTx(GetOrdersResponse.this, currentTx);
            }
        }
        return super.currentTx(s, s1, s2, attributes);
    }


    public _cls2.this._cls1(OrderItemTransaction orderitemtransaction)
    {
        this$0 = GetOrdersResponse.this;
        super();
        currentTx = orderitemtransaction;
    }
}
