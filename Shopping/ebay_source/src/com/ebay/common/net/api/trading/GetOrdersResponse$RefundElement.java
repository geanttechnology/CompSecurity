// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.Refund;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class refund extends com.ebay.nautilus.kernel.util.t
{

    private final Refund refund;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("RefundStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.RefundElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    refund.status = s3;
                }

            
            {
                this$1 = GetOrdersResponse.RefundElement.this;
                super();
            }
            };
        }
        if ("RefundType".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.RefundElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    refund.type = s3;
                }

            
            {
                this$1 = GetOrdersResponse.RefundElement.this;
                super();
            }
            };
        }
        if ("RefundTo".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.RefundElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    refund.refundTo = s3;
                }

            
            {
                this$1 = GetOrdersResponse.RefundElement.this;
                super();
            }
            };
        }
        if ("RefundTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.RefundElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    refund.refundTime = EbayDateUtils.parseXml(s3);
                }

            
            {
                this$1 = GetOrdersResponse.RefundElement.this;
                super();
            }
            };
        }
        if ("RefundAmount".equals(s1))
        {
            s = refund;
            s1 = new ItemCurrency();
            s.refundAmount = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        } else
        {
            return super.refund(s, s1, s2, attributes);
        }
    }


    public _cls4.this._cls1(Refund refund1)
    {
        this$0 = GetOrdersResponse.this;
        super();
        refund = refund1;
    }
}
