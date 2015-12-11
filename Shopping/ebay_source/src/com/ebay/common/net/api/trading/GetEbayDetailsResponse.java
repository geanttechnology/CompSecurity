// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayDetail;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class GetEbayDetailsResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetEbayDetailsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetEbayDetailsResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetEbayDetailsResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetEbayDetailsResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("ListingStartPriceDetails".equals(s1))
                {
                    return new ListingStartPriceDetails();
                }
                if ("ReturnPolicyDetails".equals(s1))
                {
                    return new ReturnPolicyDetailsNode();
                }
                if ("ShippingServiceDetails".equals(s1))
                {
                    return new ShippingServiceDetails();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetEbayDetailsResponse.this;
            super();
        }

    }

    private final class RootElement.ListingStartPriceDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.EbayDetail.ListingPriceDetails priceDetail;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("ListingType".equals(s1))
                {
                    return new ListingType();
                }
                if ("StartPrice".equals(s1))
                {
                    return attributes.getValue("currencyID"). new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.ListingStartPriceDetails this$2;
                        final String val$currencyCode;

                        public void text(String s)
                            throws SAXException
                        {
                            priceDetail.startPrice = new CurrencyAmount(s, currencyCode);
                        }

            
            {
                this$2 = final_listingstartpricedetails;
                currencyCode = String.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        private RootElement.ListingStartPriceDetails()
        {
            this$1 = RootElement.this;
            super();
            priceDetail = new com.ebay.common.model.EbayDetail.ListingPriceDetails();
        }

    }

    private final class RootElement.ListingStartPriceDetails.ListingType extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final RootElement.ListingStartPriceDetails this$2;

        public void text(String s)
            throws SAXException
        {
            if (s.equals("Chinese"))
            {
                detail.auctionDetails = priceDetail;
            } else
            if (s.equals("FixedPriceItem"))
            {
                detail.fixedPriceDetails = priceDetail;
                return;
            }
        }

        private RootElement.ListingStartPriceDetails.ListingType()
        {
            this$2 = RootElement.ListingStartPriceDetails.this;
            super();
        }

    }

    private final class RootElement.Refund extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.EbayDetail.ReturnPolicyOption option = new com.ebay.common.model.EbayDetail.ReturnPolicyOption();
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.Refund this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.description = s;
                        }

            
            {
                this$2 = RootElement.Refund.this;
                super();
            }
                    };
                }
                if ("RefundOption".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.Refund this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.token = s;
                        }

            
            {
                this$2 = RootElement.Refund.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement.Refund()
        {
            this$1 = RootElement.this;
            super();
            detail.returnPolicyDetails.refund.add(option);
        }
    }

    private final class RootElement.ReturnPolicyDetailsNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.EbayDetail.ReturnPolicyDetails returnPolicy = new com.ebay.common.model.EbayDetail.ReturnPolicyDetails();
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Refund".equals(s1))
                {
                    return new RootElement.Refund();
                }
                if ("ReturnsAccepted".equals(s1))
                {
                    return new RootElement.ReturnsAccepted();
                }
                if ("ReturnsWithin".equals(s1))
                {
                    return new RootElement.ReturnsWithin();
                }
                if ("ShippingCostPaidBy".equals(s1))
                {
                    return new RootElement.ShippingCostPaidBy();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public RootElement.ReturnPolicyDetailsNode()
        {
            this$1 = RootElement.this;
            super();
            detail.returnPolicyDetails = returnPolicy;
        }
    }

    private final class RootElement.ReturnsAccepted extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.EbayDetail.ReturnPolicyOption option = new com.ebay.common.model.EbayDetail.ReturnPolicyOption();
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.ReturnsAccepted this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.description = s;
                        }

            
            {
                this$2 = RootElement.ReturnsAccepted.this;
                super();
            }
                    };
                }
                if ("ReturnsAcceptedOption".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.ReturnsAccepted this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.token = s;
                        }

            
            {
                this$2 = RootElement.ReturnsAccepted.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement.ReturnsAccepted()
        {
            this$1 = RootElement.this;
            super();
            detail.returnPolicyDetails.returnsAccepted.add(option);
        }
    }

    private final class RootElement.ReturnsWithin extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.EbayDetail.ReturnPolicyOption option = new com.ebay.common.model.EbayDetail.ReturnPolicyOption();
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.ReturnsWithin this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.description = s;
                        }

            
            {
                this$2 = RootElement.ReturnsWithin.this;
                super();
            }
                    };
                }
                if ("ReturnsWithinOption".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.ReturnsWithin this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.token = s;
                        }

            
            {
                this$2 = RootElement.ReturnsWithin.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement.ReturnsWithin()
        {
            this$1 = RootElement.this;
            super();
            detail.returnPolicyDetails.returnsWithin.add(option);
        }
    }

    private final class RootElement.ShippingCostPaidBy extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.EbayDetail.ReturnPolicyOption option = new com.ebay.common.model.EbayDetail.ReturnPolicyOption();
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.ShippingCostPaidBy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.description = s;
                        }

            
            {
                this$2 = RootElement.ShippingCostPaidBy.this;
                super();
            }
                    };
                }
                if ("ShippingCostPaidByOption".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.ShippingCostPaidBy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.token = s;
                        }

            
            {
                this$2 = RootElement.ShippingCostPaidBy.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement.ShippingCostPaidBy()
        {
            this$1 = RootElement.this;
            super();
            detail.returnPolicyDetails.shippingCostPaidBy.add(option);
        }
    }

    private final class RootElement.ShippingServiceDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            com.ebay.common.model.EbayDetail.ShippingServiceDetail shippingservicedetail = (com.ebay.common.model.EbayDetail.ShippingServiceDetail)detail.shippingServiceDetails.get(detail.shippingServiceDetails.size() - 1);
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Description".equals(s1))
                {
                    return shippingservicedetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.ShippingServiceDetails this$2;
                        final com.ebay.common.model.EbayDetail.ShippingServiceDetail val$ssd;

                        public void text(String s)
                            throws SAXException
                        {
                            ssd.description = s;
                        }

            
            {
                this$2 = final_shippingservicedetails;
                ssd = com.ebay.common.model.EbayDetail.ShippingServiceDetail.this;
                super();
            }
                    };
                }
                if ("ShippingService".equals(s1))
                {
                    return shippingservicedetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.ShippingServiceDetails this$2;
                        final com.ebay.common.model.EbayDetail.ShippingServiceDetail val$ssd;

                        public void text(String s)
                            throws SAXException
                        {
                            ssd.shippingService = s;
                        }

            
            {
                this$2 = final_shippingservicedetails;
                ssd = com.ebay.common.model.EbayDetail.ShippingServiceDetail.this;
                super();
            }
                    };
                }
                if ("ShippingCarrier".equals(s1))
                {
                    return shippingservicedetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.ShippingServiceDetails this$2;
                        final com.ebay.common.model.EbayDetail.ShippingServiceDetail val$ssd;

                        public void text(String s)
                            throws SAXException
                        {
                            ssd.shippingCarrier = s;
                        }

            
            {
                this$2 = final_shippingservicedetails;
                ssd = com.ebay.common.model.EbayDetail.ShippingServiceDetail.this;
                super();
            }
                    };
                }
            }
            if ("ShippingCategory".equals(s1))
            {
                return shippingservicedetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.ShippingServiceDetails this$2;
                    final com.ebay.common.model.EbayDetail.ShippingServiceDetail val$ssd;

                    public void text(String s)
                        throws SAXException
                    {
                        ssd.shippingCategory = s;
                    }

            
            {
                this$2 = final_shippingservicedetails;
                ssd = com.ebay.common.model.EbayDetail.ShippingServiceDetail.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.ShippingServiceDetails()
        {
            this$1 = RootElement.this;
            super();
            detail.shippingServiceDetails.add(new com.ebay.common.model.EbayDetail.ShippingServiceDetail());
        }
    }


    public final EbayDetail detail = new EbayDetail();

    public GetEbayDetailsResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
