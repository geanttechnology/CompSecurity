// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import android.text.TextUtils;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.util.LogisticsUtil;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.net.CurrencyElement;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.d
{

    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.d get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("ShippingService".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShippingServiceSelected this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).selectedShippingOption.shippingServiceName = s3;
                        if (!TextUtils.isEmpty(s3) && LogisticsUtil.sPlanOptionTokenMap.containsKey(s3))
                        {
                            GetItemTransactionsResponse.access$600(this$0).isEbayNow = true;
                        }
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingServiceSelected.this;
                super();
            }
                };
            }
            if ("ShippingServiceCost".equals(s1))
            {
                s = GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this).selectedShippingOption;
                s1 = new ItemCurrency();
                s.shippingServiceCost = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ShippingServiceAdditionalCost".equals(s1))
            {
                s = GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this).selectedShippingOption;
                s1 = new ItemCurrency();
                s.shippingServiceAdditionalCost = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ShippingTimeMin".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetItemTransactionsResponse.ShippingServiceSelected this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).selectedShippingOption.shippingTimeMin = i;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingServiceSelected.this;
                super();
            }
                };
            }
            if ("ShippingTimeMax".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetItemTransactionsResponse.ShippingServiceSelected this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).selectedShippingOption.shippingTimeMax = i;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingServiceSelected.this;
                super();
            }
                };
            }
            if ("ImportCharge".equals(s1))
            {
                s = GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this).selectedShippingOption;
                s1 = new ItemCurrency();
                s.importCharge = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ShippingPackageInfo".equals(s1))
            {
                return new nt(GetItemTransactionsResponse.this);
            }
        }
        return super._mth0(s, s1, s2, attributes);
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
