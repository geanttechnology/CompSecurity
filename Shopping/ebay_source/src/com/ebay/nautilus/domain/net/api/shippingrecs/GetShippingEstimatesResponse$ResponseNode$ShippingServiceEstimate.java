// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingEstimate;
import com.ebay.nautilus.domain.data.ShippingZonalCost;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingEstimatesResponse

private final class estimate extends com.ebay.nautilus.kernel.util.ServiceEstimate
{
    private final class ShippingServiceInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippingServiceName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingServiceInfo this$3;

                    public void text(String s)
                        throws SAXException
                    {
                        estimate.shippingService.shippingServiceName = s;
                    }

            
            {
                this$3 = ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("serviceId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingServiceInfo this$3;

                    public void text(String s)
                        throws SAXException
                    {
                        estimate.shippingService.serviceId = s;
                    }

            
            {
                this$3 = ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("minDeliveryDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ShippingServiceInfo this$3;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        estimate.shippingService.minDeliveryDays = l;
                    }

            
            {
                this$3 = ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("maxDeliveryDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ShippingServiceInfo this$3;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        estimate.shippingService.maxDeliveryDays = l;
                    }

            
            {
                this$3 = ShippingServiceInfo.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ShippingServiceInfo()
        {
            this$2 = GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.this;
            super();
        }

        ShippingServiceInfo(GetShippingEstimatesResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ZonalCostInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ShippingZonalCost cost = new ShippingZonalCost();
        final GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("cost".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ZonalCostInfo this$3;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        cost.cost = d;
                    }

            
            {
                this$3 = ZonalCostInfo.this;
                super();
            }
                };
            }
            if ("zone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ZonalCostInfo this$3;

                    public void setValue(long l)
                        throws SAXException
                    {
                        cost.zone = l;
                    }

            
            {
                this$3 = ZonalCostInfo.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ZonalCostInfo()
        {
            this$2 = GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.this;
            super();
            estimate.costs.add(cost);
        }
    }


    final ShippingEstimate estimate = new ShippingEstimate();
    final ZonalCostInfo this$1;

    public com.ebay.nautilus.kernel.util.ServiceEstimate get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("shippingService".equals(s1))
        {
            return new ShippingServiceInfo(null);
        }
        if ("zonalCost".equals(s1))
        {
            return new ZonalCostInfo();
        } else
        {
            return super.ServiceEstimate(s, s1, s2, attributes);
        }
    }

    public ZonalCostInfo.cost()
    {
        this$1 = this._cls1.this;
        super();
        GetShippingEstimatesResponse.access$400(_fld1).add(estimate);
    }
}
