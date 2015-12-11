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

class _cls3 extends com.ebay.nautilus.kernel.util._cls1
{
    class SuggestedBidValues extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final _cls3 this$2;

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
            this$2 = _cls3.this;
            super();
        }
    }

    class BestOfferNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final PlaceOfferResponse._cls1 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("BestOfferID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        result.bestOfferId = s;
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
                        result.bestOfferStatus = s;
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

        BestOfferNode()
        {
            this$1 = PlaceOfferResponse._cls1.this;
            super();
        }
    }

    class RoverRoiResultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final PlaceOfferResponse._cls1 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("RoverROIUrl".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RoverRoiResultElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        result.roiUrl = s;
                    }

            
            {
                this$2 = RoverRoiResultElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        RoverRoiResultElement()
        {
            this$1 = PlaceOfferResponse._cls1.this;
            super();
        }
    }


    com.ebay.nautilus.kernel.util.t sellingStatus;
    final PlaceOfferResponse this$0;

    public com.ebay.nautilus.kernel.util._cls1 get(String s, String s1, String s2, Attributes attributes)
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
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PlaceOfferResponse._cls1 this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        result.bidTransactionId = s3;
                    }

            
            {
                this$1 = PlaceOfferResponse._cls1.this;
                super();
            }
                };
            }
            if ("TransactionID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PlaceOfferResponse._cls1 this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        result.transactionId = s3;
                    }

            
            {
                this$1 = PlaceOfferResponse._cls1.this;
                super();
            }
                };
            }
            if ("RoverROIResult".equals(s1))
            {
                return new RoverRoiResultElement();
            }
            if ("BestOffer".equals(s1))
            {
                return new BestOfferNode();
            }
        }
        return super.t(s, s1, s2, attributes);
    }

    <init>()
    {
        this$0 = PlaceOfferResponse.this;
        super();
        sellingStatus = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

            com.ebay.nautilus.kernel.util.SaxHandler.Element highBidder;
            final PlaceOfferResponse._cls1 this$1;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
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

                            final _cls3 this$2;

                            public void setValue(boolean flag)
                                throws SAXException
                            {
                                result.reserveMet = flag;
                            }

            
            {
                this$2 = _cls3.this;
                super();
            }
                        };
                    }
                    if ("SuggestedBidValues".equals(s1))
                    {
                        return new SuggestedBidValues();
                    }
                }
                return super.get(s, s1, s2, attributes);
            }

            
            {
                this$1 = PlaceOfferResponse._cls1.this;
                super();
                highBidder = new _cls2();
            }
        };
    }

    // Unreferenced inner class com/ebay/common/net/api/trading/PlaceOfferResponse$1$3$2

/* anonymous class */
    class _cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final _cls3 this$2;

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
    class _cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
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
                this$2 = _cls3.this;
                super();
            }
    }

}
