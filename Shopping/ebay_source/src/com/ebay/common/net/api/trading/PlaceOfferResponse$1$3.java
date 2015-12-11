// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.PlaceOfferResult;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            PlaceOfferResponse

class _cls2 extends com.ebay.nautilus.kernel.util._cls3
{
    class SuggestedBidValues extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final PlaceOfferResponse._cls1._cls3 this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("BidValue".equals(s1))
            {
                if (result.suggestedBidValues == null)
                {
                    result.suggestedBidValues = new ArrayList();
                }
                s = new ItemCurrency();
                s1 = new CurrencyElement(s, "currencyID", attributes);
                result.suggestedBidValues.add(s);
                return s1;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        SuggestedBidValues()
        {
            this$2 = PlaceOfferResponse._cls1._cls3.this;
            super();
        }
    }


    com.ebay.nautilus.kernel.util._cls3 highBidder;
    final SuggestedBidValues this$1;

    public com.ebay.nautilus.kernel.util._cls3 get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("CurrentPrice".equals(s1))
            {
                s = result;
                s1 = new ItemCurrency();
                s.currentPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ConvertedCurrentPrice".equals(s1))
            {
                s = result;
                s1 = new ItemCurrency();
                s.convertedCurrentPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("MinimumToBid".equals(s1))
            {
                s = result;
                s1 = new ItemCurrency();
                s.minimumToBid = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("HighBidder".equals(s1))
            {
                return highBidder;
            }
            if ("ReserveMet".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final PlaceOfferResponse._cls1._cls3 this$2;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        result.reserveMet = flag;
                    }

            
            {
                this$2 = PlaceOfferResponse._cls1._cls3.this;
                super();
            }
                };
            }
            if ("SuggestedBidValues".equals(s1))
            {
                return new SuggestedBidValues();
            }
        }
        return super._mth3(s, s1, s2, attributes);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
        highBidder = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

            final PlaceOfferResponse._cls1._cls3 this$2;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "UserID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final _cls2 this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            result.highBidder = s;
                        }

            
            {
                this$3 = _cls2.this;
                super();
            }
                    };
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            }

            
            {
                this$2 = PlaceOfferResponse._cls1._cls3.this;
                super();
            }
        };
    }

    // Unreferenced inner class com/ebay/common/net/api/trading/PlaceOfferResponse$1

/* anonymous class */
    class PlaceOfferResponse._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {
        class PlaceOfferResponse._cls1.BestOfferNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
        {

            final PlaceOfferResponse._cls1 this$1;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("BestOfferID".equals(s1))
                {
                    return new PlaceOfferResponse._cls1.BestOfferNode._cls1();
                }
                if ("Status".equals(s1))
                {
                    return new PlaceOfferResponse._cls1.BestOfferNode._cls2();
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            }

            PlaceOfferResponse._cls1.BestOfferNode()
            {
                this$1 = PlaceOfferResponse._cls1.this;
                super();
            }
        }

        class PlaceOfferResponse._cls1.RoverRoiResultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
        {

            final PlaceOfferResponse._cls1 this$1;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("RoverROIUrl".equals(s1))
                {
                    return new PlaceOfferResponse._cls1.RoverRoiResultElement._cls1();
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            }

            PlaceOfferResponse._cls1.RoverRoiResultElement()
            {
                this$1 = PlaceOfferResponse._cls1.this;
                super();
            }
        }


        com.ebay.nautilus.kernel.util.SaxHandler.Element sellingStatus;
        final PlaceOfferResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(PlaceOfferResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(PlaceOfferResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(PlaceOfferResponse.this, s);
                }
                if ("SellingStatus".equals(s1))
                {
                    return sellingStatus;
                }
                if ("BidTransactionID".equals(s1))
                {
                    return new PlaceOfferResponse._cls1._cls1();
                }
                if ("TransactionID".equals(s1))
                {
                    return new PlaceOfferResponse._cls1._cls2();
                }
                if ("RoverROIResult".equals(s1))
                {
                    return new PlaceOfferResponse._cls1.RoverRoiResultElement();
                }
                if ("BestOffer".equals(s1))
                {
                    return new PlaceOfferResponse._cls1.BestOfferNode();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

            
            {
                this$0 = PlaceOfferResponse.this;
                super();
                sellingStatus = new PlaceOfferResponse._cls1._cls3();
            }

        // Unreferenced inner class com/ebay/common/net/api/trading/PlaceOfferResponse$1$1

/* anonymous class */
        class PlaceOfferResponse._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final PlaceOfferResponse._cls1 this$1;

            public void text(String s)
                throws SAXException
            {
                result.bidTransactionId = s;
            }

                    
                    {
                        this$1 = PlaceOfferResponse._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/PlaceOfferResponse$1$2

/* anonymous class */
        class PlaceOfferResponse._cls1._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final PlaceOfferResponse._cls1 this$1;

            public void text(String s)
                throws SAXException
            {
                result.transactionId = s;
            }

                    
                    {
                        this$1 = PlaceOfferResponse._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/PlaceOfferResponse$1$BestOfferNode$1

/* anonymous class */
        class PlaceOfferResponse._cls1.BestOfferNode._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final PlaceOfferResponse._cls1.BestOfferNode this$2;

            public void text(String s)
                throws SAXException
            {
                result.bestOfferId = s;
            }

                    
                    {
                        this$2 = PlaceOfferResponse._cls1.BestOfferNode.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/PlaceOfferResponse$1$BestOfferNode$2

/* anonymous class */
        class PlaceOfferResponse._cls1.BestOfferNode._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final PlaceOfferResponse._cls1.BestOfferNode this$2;

            public void text(String s)
                throws SAXException
            {
                result.bestOfferStatus = s;
            }

                    
                    {
                        this$2 = PlaceOfferResponse._cls1.BestOfferNode.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/api/trading/PlaceOfferResponse$1$RoverRoiResultElement$1

/* anonymous class */
        class PlaceOfferResponse._cls1.RoverRoiResultElement._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final PlaceOfferResponse._cls1.RoverRoiResultElement this$2;

            public void text(String s)
                throws SAXException
            {
                result.roiUrl = s;
            }

                    
                    {
                        this$2 = PlaceOfferResponse._cls1.RoverRoiResultElement.this;
                        super();
                    }
        }

    }

}
