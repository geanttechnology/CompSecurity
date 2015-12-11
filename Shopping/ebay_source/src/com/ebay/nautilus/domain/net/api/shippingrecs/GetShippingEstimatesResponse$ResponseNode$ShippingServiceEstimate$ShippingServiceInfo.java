// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingEstimate;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingEstimatesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.pingServiceInfo
{

    final _cls4 this$2;

    public com.ebay.nautilus.kernel.util.pingServiceInfo get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("shippingServiceName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.ShippingServiceInfo this$3;

                public void text(String s3)
                    throws SAXException
                {
                    estimate.shippingService.shippingServiceName = s3;
                }

            
            {
                this$3 = GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.ShippingServiceInfo.this;
                super();
            }
            };
        }
        if ("serviceId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.ShippingServiceInfo this$3;

                public void text(String s3)
                    throws SAXException
                {
                    estimate.shippingService.serviceId = s3;
                }

            
            {
                this$3 = GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.ShippingServiceInfo.this;
                super();
            }
            };
        }
        if ("minDeliveryDays".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.ShippingServiceInfo this$3;

                protected void setValue(long l)
                    throws SAXException
                {
                    estimate.shippingService.minDeliveryDays = l;
                }

            
            {
                this$3 = GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.ShippingServiceInfo.this;
                super();
            }
            };
        }
        if ("maxDeliveryDays".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.ShippingServiceInfo this$3;

                protected void setValue(long l)
                    throws SAXException
                {
                    estimate.shippingService.maxDeliveryDays = l;
                }

            
            {
                this$3 = GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.ShippingServiceInfo.this;
                super();
            }
            };
        } else
        {
            return super.pingServiceInfo(s, s1, s2, attributes);
        }
    }

    private _cls4.this._cls3()
    {
        this$2 = this._cls2.this;
        super();
    }

    this._cls2(this._cls2 _pcls2_1)
    {
        this();
    }
}
