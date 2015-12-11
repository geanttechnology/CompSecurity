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

class this._cls1 extends com.ebay.nautilus.kernel.util.e
{

    final > this$1;

    public com.ebay.nautilus.kernel.util.e get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("BestOffer".equals(s1))
        {
            return new >();
        } else
        {
            return super.it>(s, s1, s2, attributes);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1

/* anonymous class */
    class GetBestOffersResponse._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {
        class GetBestOffersResponse._cls1.BestOfferNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
        {

            com.ebay.nautilus.kernel.util.SaxHandler.Element buyerNode;
            com.ebay.nautilus.kernel.util.SaxHandler.Element buyerShippingAddress;
            private final BestOffer offer = new BestOffer();
            final GetBestOffersResponse._cls1 this$1;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("BestOfferCodeType".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode._cls1();
                }
                if ("BestOfferID".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode._cls2();
                }
                if ("Buyer".equals(s1))
                {
                    return buyerNode;
                }
                if ("BuyerMessage".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode._cls3();
                }
                if ("SellerMessage".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode._cls4();
                }
                if ("ExpirationTime".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode._cls5();
                }
                if ("Price".equals(s1))
                {
                    return attributes.getValue("currencyID"). new GetBestOffersResponse._cls1.BestOfferNode._cls6();
                }
                if ("Quantity".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode._cls7();
                }
                if ("Status".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode._cls8();
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            }


            public GetBestOffersResponse._cls1.BestOfferNode()
            {
                this$1 = GetBestOffersResponse._cls1.this;
                super();
                buyerNode = new GetBestOffersResponse._cls1.BestOfferNode._cls9();
                buyerShippingAddress = new GetBestOffersResponse._cls1.BestOfferNode._cls10();
                offers.add(offer);
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

        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$1

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetBestOffersResponse._cls1.BestOfferNode this$2;

            public void text(String s)
                throws SAXException
            {
                offer.codeType = s;
            }

                    
                    {
                        this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$10

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls10 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
        {

            final GetBestOffersResponse._cls1.BestOfferNode this$2;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("StateOrProvince".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode._cls10._cls1();
                }
                if ("CountryName".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode._cls10._cls2();
                }
                if ("PostalCode".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode._cls10._cls3();
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            }

                    
                    {
                        this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$10$1

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls10._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetBestOffersResponse._cls1.BestOfferNode._cls10 this$3;

            public void text(String s)
                throws SAXException
            {
                offer.buyerAddress.addressFields.stateOrProvince = s;
            }

                    
                    {
                        this$3 = GetBestOffersResponse._cls1.BestOfferNode._cls10.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$10$2

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls10._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetBestOffersResponse._cls1.BestOfferNode._cls10 this$3;

            public void text(String s)
                throws SAXException
            {
                offer.buyerAddress.addressFields.countryName = s;
            }

                    
                    {
                        this$3 = GetBestOffersResponse._cls1.BestOfferNode._cls10.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$10$3

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls10._cls3 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetBestOffersResponse._cls1.BestOfferNode._cls10 this$3;

            public void text(String s)
                throws SAXException
            {
                offer.buyerAddress.addressFields.postalCode = s;
            }

                    
                    {
                        this$3 = GetBestOffersResponse._cls1.BestOfferNode._cls10.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$2

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetBestOffersResponse._cls1.BestOfferNode this$2;

            public void text(String s)
                throws SAXException
            {
                offer.id = s;
            }

                    
                    {
                        this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$3

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls3 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetBestOffersResponse._cls1.BestOfferNode this$2;

            public void text(String s)
                throws SAXException
            {
                offer.buyerMessage = s;
            }

                    
                    {
                        this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$4

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls4 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetBestOffersResponse._cls1.BestOfferNode this$2;

            public void text(String s)
                throws SAXException
            {
                offer.sellerMessage = s;
            }

                    
                    {
                        this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$5

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls5 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetBestOffersResponse._cls1.BestOfferNode this$2;

            public void text(String s)
                throws SAXException
            {
                offer.expirationDate = EbayDateUtils.parseXml(s);
            }

                    
                    {
                        this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$6

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls6 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetBestOffersResponse._cls1.BestOfferNode this$2;
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
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$7

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls7 extends com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement
        {

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
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$8

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls8 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetBestOffersResponse._cls1.BestOfferNode this$2;

            public void text(String s)
                throws SAXException
            {
                offer.status = s;
            }

                    
                    {
                        this$2 = GetBestOffersResponse._cls1.BestOfferNode.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$9

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls9 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
        {

            final GetBestOffersResponse._cls1.BestOfferNode this$2;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("FeedbackScore".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode._cls9._cls1();
                }
                if ("UserID".equals(s1))
                {
                    return new GetBestOffersResponse._cls1.BestOfferNode._cls9._cls2();
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
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$9$1

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls9._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetBestOffersResponse._cls1.BestOfferNode._cls9 this$3;

            public void text(String s)
                throws SAXException
            {
                offer.buyerFeedbackScore = s;
            }

                    
                    {
                        this$3 = GetBestOffersResponse._cls1.BestOfferNode._cls9.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/GetBestOffersResponse$1$BestOfferNode$9$2

/* anonymous class */
        class GetBestOffersResponse._cls1.BestOfferNode._cls9._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final GetBestOffersResponse._cls1.BestOfferNode._cls9 this$3;

            public void text(String s)
                throws SAXException
            {
                offer.buyerId = s;
            }

                    
                    {
                        this$3 = GetBestOffersResponse._cls1.BestOfferNode._cls9.this;
                        super();
                    }
        }

    }

}
