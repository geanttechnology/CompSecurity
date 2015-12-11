// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingRecommendation;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingRecommendationResponse

private final class <init> extends com.ebay.nautilus.kernel.util.pingServiceInfo
{

    final _cls4 this$1;

    public com.ebay.nautilus.kernel.util.pingServiceInfo get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("shippingServiceName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShippingRecommendationResponse.ResponseNode.ShippingServiceInfo this$2;

                public void text(String s3)
                    throws SAXException
                {
                    GetShippingRecommendationResponse.access$900(this$0).shippingService.shippingServiceName = s3;
                }

            
            {
                this$2 = GetShippingRecommendationResponse.ResponseNode.ShippingServiceInfo.this;
                super();
            }
            };
        }
        if ("serviceId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShippingRecommendationResponse.ResponseNode.ShippingServiceInfo this$2;

                public void text(String s3)
                    throws SAXException
                {
                    GetShippingRecommendationResponse.access$900(this$0).shippingService.serviceId = s3;
                }

            
            {
                this$2 = GetShippingRecommendationResponse.ResponseNode.ShippingServiceInfo.this;
                super();
            }
            };
        }
        if ("minDeliveryDays".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final GetShippingRecommendationResponse.ResponseNode.ShippingServiceInfo this$2;

                protected void setValue(long l)
                    throws SAXException
                {
                    GetShippingRecommendationResponse.access$900(this$0).shippingService.minDeliveryDays = l;
                }

            
            {
                this$2 = GetShippingRecommendationResponse.ResponseNode.ShippingServiceInfo.this;
                super();
            }
            };
        }
        if ("maxDeliveryDays".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final GetShippingRecommendationResponse.ResponseNode.ShippingServiceInfo this$2;

                protected void setValue(long l)
                    throws SAXException
                {
                    GetShippingRecommendationResponse.access$900(this$0).shippingService.maxDeliveryDays = l;
                }

            
            {
                this$2 = GetShippingRecommendationResponse.ResponseNode.ShippingServiceInfo.this;
                super();
            }
            };
        } else
        {
            return super.pingServiceInfo(s, s1, s2, attributes);
        }
    }

    private _cls4.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
