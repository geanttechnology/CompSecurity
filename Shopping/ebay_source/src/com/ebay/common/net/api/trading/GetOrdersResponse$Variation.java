// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransactionVariation;
import com.ebay.common.model.OrderItemTransaction;
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
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("SKU".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.Variation this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.variation.sku = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.Variation.this;
                super();
            }
                };
            }
            if ("VariationTitle".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.Variation this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.variation.variationTitle = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.Variation.this;
                super();
            }
                };
            }
            if ("VariationViewItemURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.Variation this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.variation.variationViewItemURL = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.Variation.this;
                super();
            }
                };
            }
            if ("VariationSpecifics".equals(s1))
            {
                return new pecifics(GetOrdersResponse.this, currentTx);
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
