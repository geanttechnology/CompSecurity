// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.OrderItemTransaction;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class currentTx extends com.ebay.nautilus.kernel.util.x
{

    private final OrderItemTransaction currentTx;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.x get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("SalesTaxAmount".equals(s1))
            {
                s = currentTx;
                s1 = new ItemCurrency();
                s.salesTaxAmount = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("SalesTaxPercent".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                    final GetOrdersResponse.SalesTax this$1;

                    public void setValue(float f)
                        throws SAXException
                    {
                        currentTx.salesTaxPercent = f;
                    }

            
            {
                this$1 = GetOrdersResponse.SalesTax.this;
                super();
            }
                };
            }
            if ("SalesTaxState".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.SalesTax this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.salesTaxState = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.SalesTax.this;
                super();
            }
                };
            }
            if ("ShippingIncludedInTax".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetOrdersResponse.SalesTax this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        currentTx.salesTaxShippingIncludedInTax = flag;
                    }

            
            {
                this$1 = GetOrdersResponse.SalesTax.this;
                super();
            }
                };
            }
        }
        return super.x(s, s1, s2, attributes);
    }


    public it>(OrderItemTransaction orderitemtransaction)
    {
        this$0 = GetOrdersResponse.this;
        super();
        currentTx = orderitemtransaction;
    }
}
