// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingRecommendation;
import com.ebay.nautilus.domain.data.ShippingZonalCost;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingRecommendationResponse

private final class <init> extends com.ebay.nautilus.kernel.util.se.ResponseNode
{
    private final class PackageType extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingRecommendationResponse.ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("packageType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PackageType this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        GetShippingRecommendationResponse.access$900(this$0).packageType = s;
                    }

            
            {
                this$2 = PackageType.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private PackageType()
        {
            this$1 = GetShippingRecommendationResponse.ResponseNode.this;
            super();
        }

        PackageType(GetShippingRecommendationResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ShippingDimension extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingRecommendationResponse.ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("length".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ShippingDimension this$2;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        GetShippingRecommendationResponse.access$900(this$0).length = d;
                    }

            
            {
                this$2 = ShippingDimension.this;
                super();
            }
                };
            }
            if ("width".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ShippingDimension this$2;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        GetShippingRecommendationResponse.access$900(this$0).width = d;
                    }

            
            {
                this$2 = ShippingDimension.this;
                super();
            }
                };
            }
            if ("height".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ShippingDimension this$2;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        GetShippingRecommendationResponse.access$900(this$0).height = d;
                    }

            
            {
                this$2 = ShippingDimension.this;
                super();
            }
                };
            }
            if ("dimensionUnitType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingDimension this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        GetShippingRecommendationResponse.access$900(this$0).dimensionUnitType = s;
                    }

            
            {
                this$2 = ShippingDimension.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ShippingDimension()
        {
            this$1 = GetShippingRecommendationResponse.ResponseNode.this;
            super();
        }

        ShippingDimension(GetShippingRecommendationResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ShippingRecommendationResponse extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingRecommendationResponse.ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errors".equals(s1))
            {
                return new ErrorElement(this$0, "http://www.ebay.com/marketplace/shipping/v10/services");
            }
            if ("shippingServiceRecommendation".equals(s1))
            {
                return new ShippingServiceRecommendation(null);
            }
            if ("weight".equals(s1))
            {
                return new ShippingWeight(null);
            }
            if ("dimension".equals(s1))
            {
                return new ShippingDimension(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ShippingRecommendationResponse()
        {
            this$1 = GetShippingRecommendationResponse.ResponseNode.this;
            super();
        }

        ShippingRecommendationResponse(GetShippingRecommendationResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ShippingServiceInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingRecommendationResponse.ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippingServiceName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingServiceInfo this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        GetShippingRecommendationResponse.access$900(this$0).shippingService.shippingServiceName = s;
                    }

            
            {
                this$2 = ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("serviceId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingServiceInfo this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        GetShippingRecommendationResponse.access$900(this$0).shippingService.serviceId = s;
                    }

            
            {
                this$2 = ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("minDeliveryDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ShippingServiceInfo this$2;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        GetShippingRecommendationResponse.access$900(this$0).shippingService.minDeliveryDays = l;
                    }

            
            {
                this$2 = ShippingServiceInfo.this;
                super();
            }
                };
            }
            if ("maxDeliveryDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ShippingServiceInfo this$2;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        GetShippingRecommendationResponse.access$900(this$0).shippingService.maxDeliveryDays = l;
                    }

            
            {
                this$2 = ShippingServiceInfo.this;
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
            this$1 = GetShippingRecommendationResponse.ResponseNode.this;
            super();
        }

        ShippingServiceInfo(GetShippingRecommendationResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ShippingServiceRecommendation extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingRecommendationResponse.ResponseNode this$1;

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
            }
            if ("packageDetail".equals(s1))
            {
                return new PackageType(null);
            }
            if ("requireWeighDimensionValidation".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final ShippingServiceRecommendation this$2;

                    protected void setValue(boolean flag)
                        throws SAXException
                    {
                        GetShippingRecommendationResponse.access$900(this$0).requireWeighDimensionValidation = flag;
                    }

            
            {
                this$2 = ShippingServiceRecommendation.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ShippingServiceRecommendation()
        {
            this$1 = GetShippingRecommendationResponse.ResponseNode.this;
            super();
        }

        ShippingServiceRecommendation(GetShippingRecommendationResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ShippingWeight extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShippingRecommendationResponse.ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("weight".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ShippingWeight this$2;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        GetShippingRecommendationResponse.access$900(this$0).weight = d;
                    }

            
            {
                this$2 = ShippingWeight.this;
                super();
            }
                };
            }
            if ("unitType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingWeight this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        GetShippingRecommendationResponse.access$900(this$0).weightUnitType = s;
                    }

            
            {
                this$2 = ShippingWeight.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ShippingWeight()
        {
            this$1 = GetShippingRecommendationResponse.ResponseNode.this;
            super();
        }

        ShippingWeight(GetShippingRecommendationResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ZonalCostInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ShippingZonalCost cost = new ShippingZonalCost();
        final GetShippingRecommendationResponse.ResponseNode this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("cost".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                    final ZonalCostInfo this$2;

                    protected void setValue(double d)
                        throws SAXException
                    {
                        cost.cost = d;
                    }

            
            {
                this$2 = ZonalCostInfo.this;
                super();
            }
                };
            }
            if ("zone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final ZonalCostInfo this$2;

                    public void setValue(long l)
                        throws SAXException
                    {
                        cost.zone = l;
                    }

            
            {
                this$2 = ZonalCostInfo.this;
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
            this$1 = GetShippingRecommendationResponse.ResponseNode.this;
            super();
            GetShippingRecommendationResponse.access$900(this$0).costs.add(cost);
        }
    }


    final GetShippingRecommendationResponse this$0;

    public com.ebay.nautilus.kernel.util.se.ResponseNode get(String s, String s1, String s2, Attributes attributes)
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
            return new ShippingRecommendationResponse(null);
        } else
        {
            return super._mth1(s, s1, s2, attributes);
        }
    }

    private ZonalCostInfo.cost()
    {
        this$0 = GetShippingRecommendationResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
