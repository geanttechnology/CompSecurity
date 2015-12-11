// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.OrderItemTransaction;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class currentTx extends com.ebay.nautilus.kernel.util.r
{

    private final OrderItemTransaction currentTx;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.r get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("BuyerInfo".equals(s1))
            {
                return new nfo(GetOrdersResponse.this, currentTx);
            }
            if ("UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.Buyer this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.buyerUserId = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.Buyer.this;
                super();
            }
                };
            }
            if ("FeedbackRatingStar".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.Buyer this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.buyerFeedbackRatingStar = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.Buyer.this;
                super();
            }
                };
            }
            if ("FeedbackScore".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetOrdersResponse.Buyer this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        currentTx.buyerFeedbackScore = Integer.valueOf(i);
                    }

            
            {
                this$1 = GetOrdersResponse.Buyer.this;
                super();
            }
                };
            }
            if ("PositiveFeedbackPercent".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                    final GetOrdersResponse.Buyer this$1;

                    public void setValue(float f)
                        throws SAXException
                    {
                        currentTx.buyerPositiveFeedbackPercent = Float.valueOf(f);
                    }

            
            {
                this$1 = GetOrdersResponse.Buyer.this;
                super();
            }
                };
            }
        }
        return super.r(s, s1, s2, attributes);
    }


    public nit>(OrderItemTransaction orderitemtransaction)
    {
        this$0 = GetOrdersResponse.this;
        super();
        currentTx = orderitemtransaction;
    }
}
