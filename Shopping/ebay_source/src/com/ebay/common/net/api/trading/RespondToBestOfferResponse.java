// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class RespondToBestOfferResponse extends EbayResponse
{
    class BestOfferNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final _cls1 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("CallStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BestOfferNode this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        class _cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
                        {

                            final RespondToBestOfferResponse this$0;

                            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                                throws SAXException
                            {
                                if ("urn:ebay:apis:eBLBaseComponents".equals(s))
                                {
                                    if ("Ack".equals(s1))
                                    {
                                        return new AckElement(RespondToBestOfferResponse.this);
                                    }
                                    if ("Timestamp".equals(s1))
                                    {
                                        return new TimestampElement(RespondToBestOfferResponse.this);
                                    }
                                    if ("Errors".equals(s1))
                                    {
                                        return new ErrorElement(RespondToBestOfferResponse.this, s);
                                    }
                                    if ("RespondToBestOffer".equals(s1))
                                    {
                                        return new RespondToBestOffer();
                                    }
                                }
                                return super.get(s, s1, s2, attributes);
                            }

            
            {
                this$0 = RespondToBestOfferResponse.this;
                super();
            }
                        }

                        status = s;
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
            this$1 = _cls1.this;
            super();
        }
    }

    class RespondToBestOffer extends com.ebay.nautilus.kernel.util.SaxHandler.Element
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

        RespondToBestOffer()
        {
            this$1 = _cls1.this;
            super();
        }
    }


    public static final String ERROR_COUNTEROFFER_GREATER_QUANTITY_THEN_ORIGINAL_OFFER = "21917";
    public static final String ERROR_COUNTEROFFER_GREATER_THAN_BIN = "21916";
    public static final String ERROR_COUNTEROFFER_PRICE_LESS_THEN_AUTO_DECLINE_PRICE = "21991";
    com.ebay.nautilus.kernel.util.SaxHandler.Element rootElement;
    private String status;
    public boolean success;

    public RespondToBestOfferResponse()
    {
        success = false;
        rootElement = new _cls1();
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, rootElement);
        if ("Success".equals(status))
        {
            success = true;
        }
    }


/*
    static String access$002(RespondToBestOfferResponse respondtobestofferresponse, String s)
    {
        respondtobestofferresponse.status = s;
        return s;
    }

*/
}
