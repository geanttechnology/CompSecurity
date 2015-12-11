// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingRecommendation;
import com.ebay.nautilus.domain.data.ShippingZonalCost;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class GetShippingRecommendationResponse extends EbayResponse
{
    private final class Body extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingRecommendationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getShippingRecommendationResponse".equals(s1))
            {
                return new ResponseNode();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Body()
        {
            this$0 = GetShippingRecommendationResponse.this;
            super();
        }

    }

    private final class ResponseNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingRecommendationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(GetShippingRecommendationResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(GetShippingRecommendationResponse.this);
            }
            if ("shippingRecommendationResponse".equals(s1))
            {
                return new ShippingRecommendationResponse();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseNode()
        {
            this$0 = GetShippingRecommendationResponse.this;
            super();
        }

    }

    private final class ResponseNode.PackageType extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("packageType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseNode.PackageType this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        details.packageType = s;
                    }

            
            {
                this$2 = ResponseNode.PackageType.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseNode.PackageType()
        {
            this$1 = ResponseNode.this;
            super();
        }

    }

    private final class ResponseNode.ShippingDimension extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("length".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ResponseNode.ShippingDimension this$2;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        details.length = d;
                    }

            
            {
                this$2 = ResponseNode.ShippingDimension.this;
                super();
            }
                };
            }
            if ("width".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ResponseNode.ShippingDimension this$2;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        details.width = d;
                    }

            
            {
                this$2 = ResponseNode.ShippingDimension.this;
                super();
            }
                };
            }
            if ("height".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ResponseNode.ShippingDimension this$2;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        details.height = d;
                    }

            
            {
                this$2 = ResponseNode.ShippingDimension.this;
                super();
            }
                };
            }
            if ("dimensionUnitType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseNode.ShippingDimension this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        details.dimensionUnitType = s;
                    }

            
            {
                this$2 = ResponseNode.ShippingDimension.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseNode.ShippingDimension()
        {
            this$1 = ResponseNode.this;
            super();
        }

    }

    private final class ResponseNode.ShippingRecommendationResponse extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errors".equals(s1))
            {
                return new ErrorElement(_fld0, "http://www.ebay.com/marketplace/shipping/v10/services");
            }
            if ("shippingServiceRecommendation".equals(s1))
            {
                return new ResponseNode.ShippingServiceRecommendation();
            }
            if ("weight".equals(s1))
            {
                return new ResponseNode.ShippingWeight();
            }
            if ("dimension".equals(s1))
            {
                return new ResponseNode.ShippingDimension();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseNode.ShippingRecommendationResponse()
        {
            this$1 = ResponseNode.this;
            super();
        }

    }

    private final class ResponseNode.ShippingServiceInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippingServiceName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseNode.ShippingServiceInfo this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        details.shippingService.shippingServiceName = s;
                    }

            
            {
                this$2 = ResponseNode.ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("serviceId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseNode.ShippingServiceInfo this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        details.shippingService.serviceId = s;
                    }

            
            {
                this$2 = ResponseNode.ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("minDeliveryDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ResponseNode.ShippingServiceInfo this$2;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        details.shippingService.minDeliveryDays = l;
                    }

            
            {
                this$2 = ResponseNode.ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("maxDeliveryDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ResponseNode.ShippingServiceInfo this$2;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        details.shippingService.maxDeliveryDays = l;
                    }

            
            {
                this$2 = ResponseNode.ShippingServiceInfo.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseNode.ShippingServiceInfo()
        {
            this$1 = ResponseNode.this;
            super();
        }

    }

    private final class ResponseNode.ShippingServiceRecommendation extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippingService".equals(s1))
            {
                return new ResponseNode.ShippingServiceInfo();
            }
            if ("zonalCost".equals(s1))
            {
                return new ResponseNode.ZonalCostInfo();
            }
            if ("packageDetail".equals(s1))
            {
                return new ResponseNode.PackageType();
            }
            if ("requireWeighDimensionValidation".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final ResponseNode.ShippingServiceRecommendation this$2;

                    protected void setValue(boolean flag)
                        throws SAXException
                    {
                        details.requireWeighDimensionValidation = flag;
                    }

            
            {
                this$2 = ResponseNode.ShippingServiceRecommendation.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseNode.ShippingServiceRecommendation()
        {
            this$1 = ResponseNode.this;
            super();
        }

    }

    private final class ResponseNode.ShippingWeight extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("weight".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ResponseNode.ShippingWeight this$2;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        details.weight = d;
                    }

            
            {
                this$2 = ResponseNode.ShippingWeight.this;
                super();
            }
                };
            }
            if ("unitType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseNode.ShippingWeight this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        details.weightUnitType = s;
                    }

            
            {
                this$2 = ResponseNode.ShippingWeight.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseNode.ShippingWeight()
        {
            this$1 = ResponseNode.this;
            super();
        }

    }

    private final class ResponseNode.ZonalCostInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ShippingZonalCost cost = new ShippingZonalCost();
        final ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("cost".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ResponseNode.ZonalCostInfo this$2;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        cost.cost = d;
                    }

            
            {
                this$2 = ResponseNode.ZonalCostInfo.this;
                super();
            }
                };
            }
            if ("zone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ResponseNode.ZonalCostInfo this$2;

                    public void setValue(long l)
                        throws SAXException
                    {
                        cost.zone = l;
                    }

            
            {
                this$2 = ResponseNode.ZonalCostInfo.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ResponseNode.ZonalCostInfo()
        {
            this$1 = ResponseNode.this;
            super();
            details.costs.add(cost);
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingRecommendationResponse this$0;

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
            this$0 = GetShippingRecommendationResponse.this;
            super();
        }

    }


    private final ShippingRecommendation details = new ShippingRecommendation();

    GetShippingRecommendationResponse()
    {
    }

    public ShippingRecommendation getDetails()
    {
        return details;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }

}
