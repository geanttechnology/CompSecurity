// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingEstimate;
import com.ebay.nautilus.domain.data.ShippingZonalCost;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class GetShippingEstimatesResponse extends EbayResponse
{
    private final class Body extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingEstimatesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getShippingEstimatesResponse".equals(s1))
            {
                return new ResponseNode();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Body()
        {
            this$0 = GetShippingEstimatesResponse.this;
            super();
        }

    }

    private final class ResponseNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingEstimatesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
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
                return new ShippingEstimatesResponse();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseNode()
        {
            this$0 = GetShippingEstimatesResponse.this;
            super();
        }

    }

    private final class ResponseNode.ShippingEstimatesResponse extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippingEstimate".equals(s1))
            {
                return new ResponseNode.ShippingServiceEstimate();
            }
            if ("errors".equals(s1))
            {
                return new ErrorMessageElement(_fld0, "http://www.ebay.com/marketplace/shipping/v10/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseNode.ShippingEstimatesResponse()
        {
            this$1 = ResponseNode.this;
            super();
        }

    }

    private final class ResponseNode.ShippingServiceEstimate extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ShippingEstimate estimate = new ShippingEstimate();
        final ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippingService".equals(s1))
            {
                return new ShippingServiceInfo();
            }
            if ("zonalCost".equals(s1))
            {
                return new ZonalCostInfo();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ResponseNode.ShippingServiceEstimate()
        {
            this$1 = ResponseNode.this;
            super();
            estimates.add(estimate);
        }
    }

    private final class ResponseNode.ShippingServiceEstimate.ShippingServiceInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ResponseNode.ShippingServiceEstimate this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippingServiceName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseNode.ShippingServiceEstimate.ShippingServiceInfo this$3;

                    public void text(String s)
                        throws SAXException
                    {
                        estimate.shippingService.shippingServiceName = s;
                    }

            
            {
                this$3 = ResponseNode.ShippingServiceEstimate.ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("serviceId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseNode.ShippingServiceEstimate.ShippingServiceInfo this$3;

                    public void text(String s)
                        throws SAXException
                    {
                        estimate.shippingService.serviceId = s;
                    }

            
            {
                this$3 = ResponseNode.ShippingServiceEstimate.ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("minDeliveryDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ResponseNode.ShippingServiceEstimate.ShippingServiceInfo this$3;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        estimate.shippingService.minDeliveryDays = l;
                    }

            
            {
                this$3 = ResponseNode.ShippingServiceEstimate.ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("maxDeliveryDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ResponseNode.ShippingServiceEstimate.ShippingServiceInfo this$3;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        estimate.shippingService.maxDeliveryDays = l;
                    }

            
            {
                this$3 = ResponseNode.ShippingServiceEstimate.ShippingServiceInfo.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseNode.ShippingServiceEstimate.ShippingServiceInfo()
        {
            this$2 = ResponseNode.ShippingServiceEstimate.this;
            super();
        }

    }

    private final class ResponseNode.ShippingServiceEstimate.ZonalCostInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ShippingZonalCost cost = new ShippingZonalCost();
        final ResponseNode.ShippingServiceEstimate this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("cost".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ResponseNode.ShippingServiceEstimate.ZonalCostInfo this$3;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        cost.cost = d;
                    }

            
            {
                this$3 = ResponseNode.ShippingServiceEstimate.ZonalCostInfo.this;
                super();
            }
                };
            }
            if ("zone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ResponseNode.ShippingServiceEstimate.ZonalCostInfo this$3;

                    public void setValue(long l)
                        throws SAXException
                    {
                        cost.zone = l;
                    }

            
            {
                this$3 = ResponseNode.ShippingServiceEstimate.ZonalCostInfo.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ResponseNode.ShippingServiceEstimate.ZonalCostInfo()
        {
            this$2 = ResponseNode.ShippingServiceEstimate.this;
            super();
            estimate.costs.add(cost);
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingEstimatesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://schemas.xmlsoap.org/soap/envelope/".equals(s) && "Body".equals(s1))
            {
                return new Body();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = GetShippingEstimatesResponse.this;
            super();
        }

    }


    private final ArrayList estimates = new ArrayList();

    GetShippingEstimatesResponse()
    {
    }

    public ArrayList getEstimates()
    {
        return estimates;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }

}
