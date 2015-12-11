// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingEstimate;
import com.ebay.nautilus.domain.data.ShippingZonalCost;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingEstimatesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.se.ResponseNode
{
    private final class ShippingEstimatesResponse extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingEstimatesResponse.ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippingEstimate".equals(s1))
            {
                return new ShippingServiceEstimate();
            }
            if ("errors".equals(s1))
            {
                return new ErrorMessageElement(this$0, "http://www.ebay.com/marketplace/shipping/v10/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ShippingEstimatesResponse()
        {
            this$1 = GetShippingEstimatesResponse.ResponseNode.this;
            super();
        }

        ShippingEstimatesResponse(GetShippingEstimatesResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ShippingServiceEstimate extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ShippingEstimate estimate = new ShippingEstimate();
        final GetShippingEstimatesResponse.ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
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
                return super.get(s, s1, s2, attributes);
            }
        }

        public ShippingServiceEstimate()
        {
            this$1 = GetShippingEstimatesResponse.ResponseNode.this;
            super();
            GetShippingEstimatesResponse.access$400(this$0).add(estimate);
        }
    }

    private final class ShippingServiceEstimate.ShippingServiceInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ShippingServiceEstimate this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippingServiceName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingServiceEstimate.ShippingServiceInfo this$3;

                    public void text(String s)
                        throws SAXException
                    {
                        estimate.shippingService.shippingServiceName = s;
                    }

            
            {
                this$3 = ShippingServiceEstimate.ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("serviceId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingServiceEstimate.ShippingServiceInfo this$3;

                    public void text(String s)
                        throws SAXException
                    {
                        estimate.shippingService.serviceId = s;
                    }

            
            {
                this$3 = ShippingServiceEstimate.ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("minDeliveryDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ShippingServiceEstimate.ShippingServiceInfo this$3;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        estimate.shippingService.minDeliveryDays = l;
                    }

            
            {
                this$3 = ShippingServiceEstimate.ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("maxDeliveryDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ShippingServiceEstimate.ShippingServiceInfo this$3;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        estimate.shippingService.maxDeliveryDays = l;
                    }

            
            {
                this$3 = ShippingServiceEstimate.ShippingServiceInfo.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ShippingServiceEstimate.ShippingServiceInfo()
        {
            this$2 = ShippingServiceEstimate.this;
            super();
        }

        ShippingServiceEstimate.ShippingServiceInfo(GetShippingEstimatesResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ShippingServiceEstimate.ZonalCostInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ShippingZonalCost cost = new ShippingZonalCost();
        final ShippingServiceEstimate this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("cost".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ShippingServiceEstimate.ZonalCostInfo this$3;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        cost.cost = d;
                    }

            
            {
                this$3 = ShippingServiceEstimate.ZonalCostInfo.this;
                super();
            }
                };
            }
            if ("zone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ShippingServiceEstimate.ZonalCostInfo this$3;

                    public void setValue(long l)
                        throws SAXException
                    {
                        cost.zone = l;
                    }

            
            {
                this$3 = ShippingServiceEstimate.ZonalCostInfo.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ShippingServiceEstimate.ZonalCostInfo()
        {
            this$2 = ShippingServiceEstimate.this;
            super();
            estimate.costs.add(cost);
        }
    }


    final GetShippingEstimatesResponse this$0;

    public com.ebay.nautilus.kernel.util.se.ResponseNode get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ack".equals(s1))
        {
            return new AckElement(GetShippingEstimatesResponse.this);
        }
        if ("timestamp".equals(s1))
        {
            return new TimestampElement(GetShippingEstimatesResponse.this);
        }
        if ("shippingEstimatesResponse".equals(s1))
        {
            return new ShippingEstimatesResponse(null);
        } else
        {
            return super._mth1(s, s1, s2, attributes);
        }
    }

    private ShippingServiceEstimate.estimate()
    {
        this$0 = GetShippingEstimatesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
