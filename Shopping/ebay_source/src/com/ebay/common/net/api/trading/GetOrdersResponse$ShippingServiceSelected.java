// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.OrderItemTransaction;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.net.CurrencyElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class currentTx extends com.ebay.nautilus.kernel.util.d
{

    private final OrderItemTransaction currentTx;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.d get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("ShippingService".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingServiceSelected this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.selectedShippingOption.shippingServiceName = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingServiceSelected.this;
                super();
            }
                };
            }
            if ("ShippingServiceCost".equals(s1))
            {
                s = currentTx.selectedShippingOption;
                s1 = new ItemCurrency();
                s.shippingServiceCost = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ShippingServiceAdditionalCost".equals(s1))
            {
                s = currentTx.selectedShippingOption;
                s1 = new ItemCurrency();
                s.shippingServiceAdditionalCost = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ShippingTimeMin".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetOrdersResponse.ShippingServiceSelected this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        currentTx.selectedShippingOption.shippingTimeMin = i;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingServiceSelected.this;
                super();
            }
                };
            }
            if ("ShippingTimeMax".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetOrdersResponse.ShippingServiceSelected this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        currentTx.selectedShippingOption.shippingTimeMax = i;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingServiceSelected.this;
                super();
            }
                };
            }
            if ("ImportCharge".equals(s1))
            {
                s = currentTx.selectedShippingOption;
                s1 = new ItemCurrency();
                s.importCharge = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
        }
        return super.currentTx(s, s1, s2, attributes);
    }


    public _cls3.this._cls1(OrderItemTransaction orderitemtransaction)
    {
        this$0 = GetOrdersResponse.this;
        super();
        currentTx = orderitemtransaction;
    }
}
