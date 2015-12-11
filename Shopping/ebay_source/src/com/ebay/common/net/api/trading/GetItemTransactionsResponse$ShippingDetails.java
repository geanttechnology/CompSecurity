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
            if ("ShippingType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShippingDetails this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).shippingType = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingDetails.this;
                super();
            }
                };
            }
            if ("ThirdPartyCheckout".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetItemTransactionsResponse.ShippingDetails this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).thirdPartyCheckout = flag;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingDetails.this;
                super();
            }
                };
            }
            if ("ShipmentTrackingDetails".equals(s1))
            {
                return new DetailsXml(GetItemTransactionsResponse.this);
            }
            if ("ShippingServiceOptions".equals(s1))
            {
                return new ption(GetItemTransactionsResponse.this);
            }
            if ("InternationalShippingServiceOption".equals(s1))
            {
                return new ption(GetItemTransactionsResponse.this);
            }
            if ("SalesTax".equals(s1))
            {
                return new this._cls0(GetItemTransactionsResponse.this, null);
            }
        }
        return super._mth0(s, s1, s2, attributes);
    }

    private _cls2.this._cls1()
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
