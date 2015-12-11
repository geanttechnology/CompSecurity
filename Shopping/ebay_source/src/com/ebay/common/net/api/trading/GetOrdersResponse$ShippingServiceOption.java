// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.OrderItemTransaction;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.net.CurrencyElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class currentTx extends com.ebay.nautilus.kernel.util.n
{

    private final OrderItemTransaction currentTx;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.n get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        final ShippingCostsShippingOption so = (ShippingCostsShippingOption)currentTx.shippingOptions.get(currentTx.shippingOptions.size() - 1);
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("ExpeditedService".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetOrdersResponse.ShippingServiceOption this$1;
                    final ShippingCostsShippingOption val$so;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        so.expeditedService = flag;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingServiceOption.this;
                so = shippingcostsshippingoption;
                super();
            }
                };
            }
            if ("ShippingInsuranceCost".equals(s1))
            {
                s = new ItemCurrency();
                so.shippingInsuranceCost = s;
                return new CurrencyElement(s, "currencyID", attributes);
            }
            if ("ShippingServiceAdditionalCost".equals(s1))
            {
                s = new ItemCurrency();
                so.shippingServiceAdditionalCost = s;
                return new CurrencyElement(s, "currencyID", attributes);
            }
            if ("ShippingServiceCost".equals(s1))
            {
                s = new ItemCurrency();
                so.shippingServiceCost = s;
                return new CurrencyElement(s, "currencyID", attributes);
            }
            if ("ShippingService".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingServiceOption this$1;
                    final ShippingCostsShippingOption val$so;

                    public void text(String s3)
                        throws SAXException
                    {
                        so.shippingServiceName = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingServiceOption.this;
                so = shippingcostsshippingoption;
                super();
            }
                };
            }
            if ("ShippingServicePriority".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetOrdersResponse.ShippingServiceOption this$1;
                    final ShippingCostsShippingOption val$so;

                    public void setValue(int i)
                        throws SAXException
                    {
                        so.shippingServicePriority = i;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingServiceOption.this;
                so = shippingcostsshippingoption;
                super();
            }
                };
            }
            if ("ShippingSurcharge".equals(s1))
            {
                s = new ItemCurrency();
                so.shippingSurcharge = s;
                return new CurrencyElement(s, "currencyID", attributes);
            }
            if ("ShippingTimeMax".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetOrdersResponse.ShippingServiceOption this$1;
                    final ShippingCostsShippingOption val$so;

                    public void setValue(int i)
                        throws SAXException
                    {
                        so.shippingTimeMax = i;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingServiceOption.this;
                so = shippingcostsshippingoption;
                super();
            }
                };
            }
            if ("ShippingTimeMin".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetOrdersResponse.ShippingServiceOption this$1;
                    final ShippingCostsShippingOption val$so;

                    public void setValue(int i)
                        throws SAXException
                    {
                        so.shippingTimeMin = i;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingServiceOption.this;
                so = shippingcostsshippingoption;
                super();
            }
                };
            }
            if ("ImportCharge".equals(s1))
            {
                s = new ItemCurrency();
                so.importCharge = s;
                return new CurrencyElement(s, "currencyID", attributes);
            }
        }
        return super.(s, s1, s2, attributes);
    }

    public _cls5.val.so(OrderItemTransaction orderitemtransaction)
    {
        this$0 = GetOrdersResponse.this;
        super();
        currentTx = orderitemtransaction;
        currentTx.shippingOptions.add(new ShippingCostsShippingOption());
    }
}
