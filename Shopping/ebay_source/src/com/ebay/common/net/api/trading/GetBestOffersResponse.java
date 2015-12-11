// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.BestOffer;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class GetBestOffersResponse extends EbayResponse
{
    class BestOfferArrayNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final _cls1 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("BestOffer".equals(s1))
            {
                return new BestOfferNode();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        BestOfferArrayNode()
        {
            this$1 = _cls1.this;
            super();
        }
    }

    class BestOfferNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.Element buyerNode;
        com.ebay.nautilus.kernel.util.SaxHandler.Element buyerShippingAddress;
        private final BestOffer offer = new BestOffer();
        final _cls1 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("BestOfferCodeType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        offer.codeType = s;
                    }

            
            {
                this$2 = BestOfferNode.this;
                super();
            }
                };
            }
            if ("BestOfferID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        offer.id = s;
                    }

            
            {
                this$2 = BestOfferNode.this;
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

                    final BestOfferNode this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        offer.buyerMessage = s;
                    }

            
            {
                this$2 = BestOfferNode.this;
                super();
            }
                };
            }
            if ("SellerMessage".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        offer.sellerMessage = s;
                    }

            
            {
                this$2 = BestOfferNode.this;
                super();
            }
                };
            }
            if ("ExpirationTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        offer.expirationDate = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$2 = BestOfferNode.this;
                super();
            }
                };
            }
            if ("Price".equals(s1))
            {
                return attributes.getValue("currencyID"). new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode this$2;
                    final String val$currencyCode;

                    public void text(String s)
                        throws SAXException
                    {
                        offer.currentOffer = new CurrencyAmount(s, currencyCode);
                    }

            
            {
                this$2 = final_bestoffernode;
                currencyCode = String.this;
                super();
            }
                };
            }
            if ("Quantity".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BestOfferNode this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        offer.quantity = i;
                    }

            
            {
                this$2 = BestOfferNode.this;
                super();
            }
                };
            }
            if ("Status".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        offer.status = s;
                    }

            
            {
                this$2 = BestOfferNode.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public BestOfferNode()
        {
            this$1 = _cls1.this;
            super();
            buyerNode = new _cls9();
            buyerShippingAddress = new _cls10();
            offers.add(offer);
        }
    }


    public final ArrayList offers = new ArrayList();
    com.ebay.nautilus.kernel.util.SaxHandler.Element rootElement;

    public GetBestOffersResponse()
    {
        rootElement = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

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
                        return new BestOfferArrayNode();
                    }
                }
                return super.get(s, s1, s2, attributes);
            }

            
            {
                this$0 = GetBestOffersResponse.this;
                super();
            }
        };
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, rootElement);
    }

    // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$10

/* anonymous class */
    class BestOfferNode._cls10 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final BestOfferNode this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("StateOrProvince".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode._cls10 this$3;

                    public void text(String s)
                        throws SAXException
                    {
    class BestOfferNode._cls10 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {
                        offer.buyerAddress.addressFields.stateOrProvince = s;
                    }

            
            {
                this$3 = BestOfferNode._cls10.this;
                super();
            }
                };
            }
            if ("CountryName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode._cls10 this$3;

                    public void text(String s)
                        throws SAXException
                    {
                        offer.buyerAddress.addressFields.countryName = s;
                    }

            
            {
                this$3 = BestOfferNode._cls10.this;
                super();
            }
                };
            }
            if ("PostalCode".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode._cls10 this$3;

                    public void text(String s)
                        throws SAXException
                    {
                        offer.buyerAddress.addressFields.postalCode = s;
                    }

            
            {
                this$3 = BestOfferNode._cls10.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$2 = BestOfferNode.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$9

/* anonymous class */
    class BestOfferNode._cls9 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final BestOfferNode this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("FeedbackScore".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode._cls9 this$3;

                    public void text(String s)
                        throws SAXException
                    {
    class BestOfferNode._cls9 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {
                        offer.buyerFeedbackScore = s;
                    }

            
            {
                this$3 = BestOfferNode._cls9.this;
                super();
            }
                };
            }
            if ("UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode._cls9 this$3;

                    public void text(String s)
                        throws SAXException
                    {
                        offer.buyerId = s;
                    }

            
            {
                this$3 = BestOfferNode._cls9.this;
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
                this$2 = BestOfferNode.this;
                super();
            }
    }

}
