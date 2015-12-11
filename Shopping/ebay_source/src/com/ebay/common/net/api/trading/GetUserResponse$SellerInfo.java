// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserResponse

static final class data extends com.ebay.nautilus.kernel.util.o
{

    private final com.ebay.common.model.get data;

    public com.ebay.nautilus.kernel.util.o get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("SellerBusinessType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.SellerInfo this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.sellerBusinessType = s3;
                    }

            
            {
                this$0 = GetUserResponse.SellerInfo.this;
                super();
            }
                };
            }
            if ("PaymentMethod".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.SellerInfo this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.paymentMethod = s3;
                    }

            
            {
                this$0 = GetUserResponse.SellerInfo.this;
                super();
            }
                };
            }
            if ("SellerPaymentAddress".equals(s1))
            {
                data.rPaymentAddress = new com.ebay.common.model.rPaymentAddress();
                return new it>(data.rPaymentAddress);
            }
        }
        return super.Address(s, s1, s2, attributes);
    }


    (com.ebay.common.model.ellerInfo ellerinfo)
    {
        data = ellerinfo;
    }
}
