// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.s
{

    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.s get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("CompleteStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Status this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).completeStatus = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Status.this;
                super();
            }
                };
            }
            if ("eBayPaymentStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Status this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).ebayPaymentStatus = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Status.this;
                super();
            }
                };
            }
            if ("PaymentHoldStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Status this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).paymentHoldStatus = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Status.this;
                super();
            }
                };
            }
            if ("PaymentMethodUsed".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Status this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).paymentMethodUsed = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Status.this;
                super();
            }
                };
            }
            if ("CheckoutStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Status this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).checkoutStatus = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Status.this;
                super();
            }
                };
            }
            if ("InquiryStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Status this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).inquiryStatus = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Status.this;
                super();
            }
                };
            }
            if ("ReturnStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Status this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).returnStatus = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Status.this;
                super();
            }
                };
            }
        }
        return super.s(s, s1, s2, attributes);
    }

    private _cls7.this._cls1()
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
