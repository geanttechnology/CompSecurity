// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.BestOffer;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetBestOffersResponse

class offer extends com.ebay.nautilus.kernel.util.e
{

    com.ebay.nautilus.kernel.util.e buyerNode;
    com.ebay.nautilus.kernel.util.e buyerShippingAddress;
    private final BestOffer offer = new BestOffer();
    final offer this$1;

    public com.ebay.nautilus.kernel.util.e get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("BestOfferCodeType".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetBestOffersResponse._cls1.BestOfferNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    offer.codeType = s3;
                }

            
            {
                this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                super();
            }
            };
        }
        if ("BestOfferID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetBestOffersResponse._cls1.BestOfferNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    offer.id = s3;
                }

            
            {
                this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                super();
            }
            };
        }
        if ("Buyer".equals(s1))
        {
            return buyerNode;
        }
        if ("BuyerMessage".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetBestOffersResponse._cls1.BestOfferNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    offer.buyerMessage = s3;
                }

            
            {
                this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                super();
            }
            };
        }
        if ("SellerMessage".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetBestOffersResponse._cls1.BestOfferNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    offer.sellerMessage = s3;
                }

            
            {
                this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                super();
            }
            };
        }
        if ("ExpirationTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetBestOffersResponse._cls1.BestOfferNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    offer.expirationDate = EbayDateUtils.parseXml(s3);
                }

            
            {
                this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                super();
            }
            };
        }
        if ("Price".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetBestOffersResponse._cls1.BestOfferNode this$2;
                final String val$currencyCode;

                public void text(String s3)
                    throws SAXException
                {
                    offer.currentOffer = new CurrencyAmount(s3, currencyCode);
                }

            
            {
                this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                currencyCode = s;
                super();
            }
            };
        }
        if ("Quantity".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetBestOffersResponse._cls1.BestOfferNode this$2;

                protected void setValue(int i)
                    throws SAXException
                {
                    offer.quantity = i;
                }

            
            {
                this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                super();
            }
            };
        }
        if ("Status".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetBestOffersResponse._cls1.BestOfferNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    offer.status = s3;
                }

            
            {
                this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                super();
            }
            };
        } else
        {
            return super.e(s, s1, s2, attributes);
        }
    }


    public Node.this._cls1()
    {
        this$1 = this._cls1.this;
        super();
        buyerNode = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

            final GetBestOffersResponse._cls1.BestOfferNode this$2;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("FeedbackScore".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final _cls9 this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            offer.buyerFeedbackScore = s;
                        }

            
            {
                this$3 = _cls9.this;
                super();
            }
                    };
                }
                if ("UserID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final _cls9 this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            offer.buyerId = s;
                        }

            
            {
                this$3 = _cls9.this;
                super();
            }
                    };
                }
                if ("ShippingAddress".equals(s1))
                {
                    offer.buyerAddress = new Address();
                    return buyerShippingAddress;
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            }

            
            {
                this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                super();
            }
        };
        buyerShippingAddress = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

            final GetBestOffersResponse._cls1.BestOfferNode this$2;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("StateOrProvince".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final _cls10 this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            offer.buyerAddress.addressFields.stateOrProvince = s;
                        }

            
            {
                this$3 = _cls10.this;
                super();
            }
                    };
                }
                if ("CountryName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final _cls10 this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            offer.buyerAddress.addressFields.countryName = s;
                        }

            
            {
                this$3 = _cls10.this;
                super();
            }
                    };
                }
                if ("PostalCode".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final _cls10 this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            offer.buyerAddress.addressFields.postalCode = s;
                        }

            
            {
                this$3 = _cls10.this;
                super();
            }
                    };
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            }

            
            {
                this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                super();
            }
        };
        offers.add(offer);
    }

    // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1

/* anonymous class */
    class GetBestOffersResponse._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {
        class GetBestOffersResponse._cls1.BestOfferArrayNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
        {

            final GetBestOffersResponse._cls1 this$1;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("BestOffer".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode();
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            }

            GetBestOffersResponse._cls1.BestOfferArrayNode()
            {
                this$1 = GetBestOffersResponse._cls1.this;
                super();
            }
        }


        final GetBestOffersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetBestOffersResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetBestOffersResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetBestOffersResponse.this, s);
                }
                if ("BestOfferArray".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferArrayNode();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

            
            {
                this$0 = GetBestOffersResponse.this;
                super();
            }
    }

}
