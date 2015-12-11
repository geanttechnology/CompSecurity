// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.common.model.OrderShippingInfo;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetOrderShippingInfoResponse

private final class <init> extends com.ebay.nautilus.kernel.util.fo
{

    final GetOrderShippingInfoResponse this$0;

    public com.ebay.nautilus.kernel.util.fo get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/shipping/v1/services".equals(s))
        {
            if ("selectedShippingDetails".equals(s1))
            {
                return new Details(GetOrderShippingInfoResponse.this, null);
            }
            if ("itemShippingService".equals(s1) && info.estimatedMaxDeliveryDate == null)
            {
                return new ice(GetOrderShippingInfoResponse.this, null);
            }
            if ("shippedDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrderShippingInfoResponse.TransactionInfo this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        info.shippedDate = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$1 = GetOrderShippingInfoResponse.TransactionInfo.this;
                super();
            }
                };
            }
            if ("actualDeliveryDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrderShippingInfoResponse.TransactionInfo this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        info.actualDeliveryDate = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$1 = GetOrderShippingInfoResponse.TransactionInfo.this;
                super();
            }
                };
            }
        }
        return super.fo(s, s1, s2, attributes);
    }

    private _cls2.this._cls1()
    {
        this$0 = GetOrderShippingInfoResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
