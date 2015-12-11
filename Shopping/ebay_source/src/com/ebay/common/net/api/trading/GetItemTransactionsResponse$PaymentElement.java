// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.Payment;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class payment extends com.ebay.nautilus.kernel.util.t
{

    private final Payment payment;
    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("PaymentStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetItemTransactionsResponse.PaymentElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    payment.status = s3;
                }

            
            {
                this$1 = GetItemTransactionsResponse.PaymentElement.this;
                super();
            }
            };
        }
        if ("PaymentTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetItemTransactionsResponse.PaymentElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    payment.time = EbayDateUtils.parseXml(s3);
                }

            
            {
                this$1 = GetItemTransactionsResponse.PaymentElement.this;
                super();
            }
            };
        }
        if ("PaymentAmount".equals(s1))
        {
            s = payment;
            s1 = new ItemCurrency();
            s.amount = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("FeeOrCreditAmount".equals(s1))
        {
            s = payment;
            s1 = new ItemCurrency();
            s.feeOrCreditAmount = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        } else
        {
            return super.payment(s, s1, s2, attributes);
        }
    }


    public _cls2.this._cls1(Payment payment1)
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
        payment = payment1;
    }
}
