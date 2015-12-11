// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayOrder;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class order extends com.ebay.nautilus.kernel.util.s
{

    private final EbayOrder order;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.s get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("eBayPaymentStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.CheckoutStatus this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.eBayPaymentStatus = s3;
                }

            
            {
                this$1 = GetOrdersResponse.CheckoutStatus.this;
                super();
            }
            };
        }
        if ("LastModifiedTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.CheckoutStatus this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.lastModifiedTime = EbayDateUtils.parseXml(s3);
                }

            
            {
                this$1 = GetOrdersResponse.CheckoutStatus.this;
                super();
            }
            };
        }
        if ("PaymentMethod".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.CheckoutStatus this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.paymentMethod = s3;
                }

            
            {
                this$1 = GetOrdersResponse.CheckoutStatus.this;
                super();
            }
            };
        }
        if ("Status".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.CheckoutStatus this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.statusXO = s3;
                }

            
            {
                this$1 = GetOrdersResponse.CheckoutStatus.this;
                super();
            }
            };
        } else
        {
            return super.s(s, s1, s2, attributes);
        }
    }


    public _cls4.this._cls1(EbayOrder ebayorder)
    {
        this$0 = GetOrdersResponse.this;
        super();
        order = ebayorder;
    }
}
