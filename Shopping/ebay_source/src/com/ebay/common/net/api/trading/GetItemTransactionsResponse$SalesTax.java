// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.x
{

    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.x get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("SalesTaxAmount".equals(s1))
            {
                s = GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this);
                s1 = new ItemCurrency();
                s.salesTaxAmount = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("SalesTaxPercent".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                    final GetItemTransactionsResponse.SalesTax this$1;

                    public void setValue(float f)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).salesTaxPercent = f;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.SalesTax.this;
                super();
            }
                };
            }
            if ("SalesTaxState".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.SalesTax this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).salesTaxState = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.SalesTax.this;
                super();
            }
                };
            }
            if ("ShippingIncludedInTax".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetItemTransactionsResponse.SalesTax this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).salesTaxShippingIncludedInTax = flag;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.SalesTax.this;
                super();
            }
                };
            }
        }
        return super.x(s, s1, s2, attributes);
    }

    private _cls3.this._cls1()
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
