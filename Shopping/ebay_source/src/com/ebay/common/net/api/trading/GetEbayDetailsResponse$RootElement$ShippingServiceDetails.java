// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayDetail;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetEbayDetailsResponse

private final class this._cls1 extends com.ebay.nautilus.kernel.util.s
{

    final _cls4.val.ssd this$1;

    public com.ebay.nautilus.kernel.util.s get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        final com.ebay.common.model.ceDetails ssd = (com.ebay.common.model.ceDetails)detail.shippingServiceDetails.get(detail.shippingServiceDetails.size() - 1);
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Description".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetEbayDetailsResponse.RootElement.ShippingServiceDetails this$2;
                    final com.ebay.common.model.EbayDetail.ShippingServiceDetail val$ssd;

                    public void text(String s3)
                        throws SAXException
                    {
                        ssd.description = s3;
                    }

            
            {
                this$2 = GetEbayDetailsResponse.RootElement.ShippingServiceDetails.this;
                ssd = shippingservicedetail;
                super();
            }
                };
            }
            if ("ShippingService".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetEbayDetailsResponse.RootElement.ShippingServiceDetails this$2;
                    final com.ebay.common.model.EbayDetail.ShippingServiceDetail val$ssd;

                    public void text(String s3)
                        throws SAXException
                    {
                        ssd.shippingService = s3;
                    }

            
            {
                this$2 = GetEbayDetailsResponse.RootElement.ShippingServiceDetails.this;
                ssd = shippingservicedetail;
                super();
            }
                };
            }
            if ("ShippingCarrier".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetEbayDetailsResponse.RootElement.ShippingServiceDetails this$2;
                    final com.ebay.common.model.EbayDetail.ShippingServiceDetail val$ssd;

                    public void text(String s3)
                        throws SAXException
                    {
                        ssd.shippingCarrier = s3;
                    }

            
            {
                this$2 = GetEbayDetailsResponse.RootElement.ShippingServiceDetails.this;
                ssd = shippingservicedetail;
                super();
            }
                };
            }
        }
        if ("ShippingCategory".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetEbayDetailsResponse.RootElement.ShippingServiceDetails this$2;
                final com.ebay.common.model.EbayDetail.ShippingServiceDetail val$ssd;

                public void text(String s3)
                    throws SAXException
                {
                    ssd.shippingCategory = s3;
                }

            
            {
                this$2 = GetEbayDetailsResponse.RootElement.ShippingServiceDetails.this;
                ssd = shippingservicedetail;
                super();
            }
            };
        } else
        {
            return super.s(s, s1, s2, attributes);
        }
    }

    public _cls4.val.ssd()
    {
        this$1 = this._cls1.this;
        super();
        detail.shippingServiceDetails.add(new com.ebay.common.model.());
    }
}
