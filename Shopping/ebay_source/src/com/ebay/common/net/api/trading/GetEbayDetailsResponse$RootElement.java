// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayDetail;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetEbayDetailsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t
{
    private final class ListingStartPriceDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.EbayDetail.ListingPriceDetails priceDetail;
        final GetEbayDetailsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("ListingType".equals(s1))
                {
                    return new ListingType(null);
                }
                if ("StartPrice".equals(s1))
                {
                    return attributes.getValue("currencyID"). new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ListingStartPriceDetails this$2;
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


        private ListingStartPriceDetails()
        {
            this$1 = GetEbayDetailsResponse.RootElement.this;
            super();
            priceDetail = new com.ebay.common.model.EbayDetail.ListingPriceDetails();
        }

        ListingStartPriceDetails(GetEbayDetailsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ListingStartPriceDetails.ListingType extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ListingStartPriceDetails this$2;

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

        private ListingStartPriceDetails.ListingType()
        {
            this$2 = ListingStartPriceDetails.this;
            super();
        }

        ListingStartPriceDetails.ListingType(GetEbayDetailsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class Refund extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.EbayDetail.ReturnPolicyOption option = new com.ebay.common.model.EbayDetail.ReturnPolicyOption();
        final GetEbayDetailsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Refund this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.description = s;
                        }

            
            {
                this$2 = Refund.this;
                super();
            }
                    };
                }
                if ("RefundOption".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Refund this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.token = s;
                        }

            
            {
                this$2 = Refund.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public Refund()
        {
            this$1 = GetEbayDetailsResponse.RootElement.this;
            super();
            detail.returnPolicyDetails.refund.add(option);
        }
    }

    private final class ReturnPolicyDetailsNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.EbayDetail.ReturnPolicyDetails returnPolicy = new com.ebay.common.model.EbayDetail.ReturnPolicyDetails();
        final GetEbayDetailsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Refund".equals(s1))
                {
                    return new Refund();
                }
                if ("ReturnsAccepted".equals(s1))
                {
                    return new ReturnsAccepted();
                }
                if ("ReturnsWithin".equals(s1))
                {
                    return new ReturnsWithin();
                }
                if ("ShippingCostPaidBy".equals(s1))
                {
                    return new ShippingCostPaidBy();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public ReturnPolicyDetailsNode()
        {
            this$1 = GetEbayDetailsResponse.RootElement.this;
            super();
            detail.returnPolicyDetails = returnPolicy;
        }
    }

    private final class ReturnsAccepted extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.EbayDetail.ReturnPolicyOption option = new com.ebay.common.model.EbayDetail.ReturnPolicyOption();
        final GetEbayDetailsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnsAccepted this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.description = s;
                        }

            
            {
                this$2 = ReturnsAccepted.this;
                super();
            }
                    };
                }
                if ("ReturnsAcceptedOption".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnsAccepted this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.token = s;
                        }

            
            {
                this$2 = ReturnsAccepted.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public ReturnsAccepted()
        {
            this$1 = GetEbayDetailsResponse.RootElement.this;
            super();
            detail.returnPolicyDetails.returnsAccepted.add(option);
        }
    }

    private final class ReturnsWithin extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.EbayDetail.ReturnPolicyOption option = new com.ebay.common.model.EbayDetail.ReturnPolicyOption();
        final GetEbayDetailsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnsWithin this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.description = s;
                        }

            
            {
                this$2 = ReturnsWithin.this;
                super();
            }
                    };
                }
                if ("ReturnsWithinOption".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ReturnsWithin this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.token = s;
                        }

            
            {
                this$2 = ReturnsWithin.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public ReturnsWithin()
        {
            this$1 = GetEbayDetailsResponse.RootElement.this;
            super();
            detail.returnPolicyDetails.returnsWithin.add(option);
        }
    }

    private final class ShippingCostPaidBy extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.EbayDetail.ReturnPolicyOption option = new com.ebay.common.model.EbayDetail.ReturnPolicyOption();
        final GetEbayDetailsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingCostPaidBy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.description = s;
                        }

            
            {
                this$2 = ShippingCostPaidBy.this;
                super();
            }
                    };
                }
                if ("ShippingCostPaidByOption".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingCostPaidBy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            option.token = s;
                        }

            
            {
                this$2 = ShippingCostPaidBy.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public ShippingCostPaidBy()
        {
            this$1 = GetEbayDetailsResponse.RootElement.this;
            super();
            detail.returnPolicyDetails.shippingCostPaidBy.add(option);
        }
    }

    private final class ShippingServiceDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetEbayDetailsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            com.ebay.common.model.EbayDetail.ShippingServiceDetail shippingservicedetail = (com.ebay.common.model.EbayDetail.ShippingServiceDetail)detail.shippingServiceDetails.get(detail.shippingServiceDetails.size() - 1);
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Description".equals(s1))
                {
                    return shippingservicedetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingServiceDetails this$2;
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

                        final ShippingServiceDetails this$2;
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

                        final ShippingServiceDetails this$2;
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

                    final ShippingServiceDetails this$2;
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

        public ShippingServiceDetails()
        {
            this$1 = GetEbayDetailsResponse.RootElement.this;
            super();
            detail.shippingServiceDetails.add(new com.ebay.common.model.EbayDetail.ShippingServiceDetail());
        }
    }


    final GetEbayDetailsResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
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
                return new ListingStartPriceDetails(null);
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
        return super.t(s, s1, s2, attributes);
    }

    private ShippingServiceDetails.this._cls1()
    {
        this$0 = GetEbayDetailsResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
