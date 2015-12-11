// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import com.ebay.nautilus.domain.data.EbnOrderCancelReason;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.r
{

    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.r get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("OrderID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ContainingOrder this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).orderId = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ContainingOrder.this;
                super();
            }
                };
            }
            if ("OrderStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ContainingOrder this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).orderStatus = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ContainingOrder.this;
                super();
            }
                };
            }
            if ("PaymentHoldDetails".equals(s1))
            {
                return new ls(GetItemTransactionsResponse.this, null);
            }
            if ("CancelReason".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ContainingOrder this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).cancelReason = EbnOrderCancelReason.getByName(s3);
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ContainingOrder.this;
                super();
            }
                };
            }
            if ("CancelStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ContainingOrder this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).cancelStatus = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ContainingOrder.this;
                super();
            }
                };
            }
        }
        return super.r(s, s1, s2, attributes);
    }

    private _cls4.this._cls1()
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
