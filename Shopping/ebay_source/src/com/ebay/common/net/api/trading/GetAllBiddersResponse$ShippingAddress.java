// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetAllBiddersResponse

private final class shippingAddress extends com.ebay.nautilus.kernel.util.s
{

    private final com.ebay.common.model.ngAddress shippingAddress;
    final GetAllBiddersResponse this$0;

    public com.ebay.nautilus.kernel.util.s get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Country".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.ShippingAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        shippingAddress.country = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.ShippingAddress.this;
                super();
            }
                };
            }
            if ("PostalCode".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.ShippingAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        shippingAddress.postalCode = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.ShippingAddress.this;
                super();
            }
                };
            }
        }
        return super.s(s, s1, s2, attributes);
    }


    public _cls2.this._cls1(com.ebay.common.model.ngAddress ngaddress)
    {
        this$0 = GetAllBiddersResponse.this;
        super();
        shippingAddress = ngaddress;
    }
}
