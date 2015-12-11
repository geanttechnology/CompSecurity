// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.net.CurrencyElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class this._cls0 extends com.ebay.nautilus.kernel.util.n
{

    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.n get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        final ShippingCostsShippingOption so = (ShippingCostsShippingOption)GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this).shippingOptions.get(GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this).shippingOptions.size() - 1);
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("ExpeditedService".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetItemTransactionsResponse.ShippingServiceOption this$1;
                    final ShippingCostsShippingOption val$so;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        so.expeditedService = flag;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingServiceOption.this;
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

                    final GetItemTransactionsResponse.ShippingServiceOption this$1;
                    final ShippingCostsShippingOption val$so;

                    public void text(String s3)
                        throws SAXException
                    {
                        so.shippingServiceName = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingServiceOption.this;
                so = shippingcostsshippingoption;
                super();
            }
                };
            }
            if ("ShippingServicePriority".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetItemTransactionsResponse.ShippingServiceOption this$1;
                    final ShippingCostsShippingOption val$so;

                    public void setValue(int i)
                        throws SAXException
                    {
                        so.shippingServicePriority = i;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingServiceOption.this;
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

                    final GetItemTransactionsResponse.ShippingServiceOption this$1;
                    final ShippingCostsShippingOption val$so;

                    public void setValue(int i)
                        throws SAXException
                    {
                        so.shippingTimeMax = i;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingServiceOption.this;
                so = shippingcostsshippingoption;
                super();
            }
                };
            }
            if ("ShippingTimeMin".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetItemTransactionsResponse.ShippingServiceOption this$1;
                    final ShippingCostsShippingOption val$so;

                    public void setValue(int i)
                        throws SAXException
                    {
                        so.shippingTimeMin = i;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingServiceOption.this;
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
        return super.n(s, s1, s2, attributes);
    }

    public _cls5.val.so()
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
        GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this).shippingOptions.add(new ShippingCostsShippingOption());
    }
}
