// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayOrder;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class order extends com.ebay.nautilus.kernel.util.r
{

    private final EbayOrder order;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.r get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ShippingService".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.ShippingServiceSelectedOrder this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.shippingService = s3;
                }

            
            {
                this$1 = GetOrdersResponse.ShippingServiceSelectedOrder.this;
                super();
            }
            };
        }
        if ("ShippingServiceCost".equals(s1))
        {
            s = order;
            s1 = new ItemCurrency();
            s.shippingCost = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        } else
        {
            return super.order(s, s1, s2, attributes);
        }
    }


    public _cls1.this._cls1(EbayOrder ebayorder)
    {
        this$0 = GetOrdersResponse.this;
        super();
        order = ebayorder;
    }
}
