// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            RespondToBestOfferResponse

class this._cls0 extends com.ebay.nautilus.kernel.util._cls1
{
    class BestOfferNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RespondToBestOfferResponse._cls1 this$1;

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
                        RespondToBestOfferResponse.access$002(this$0, s);
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
            this$1 = RespondToBestOfferResponse._cls1.this;
            super();
        }
    }

    class RespondToBestOffer extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RespondToBestOfferResponse._cls1 this$1;

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
            this$1 = RespondToBestOfferResponse._cls1.this;
            super();
        }
    }


    final RespondToBestOfferResponse this$0;

    public com.ebay.nautilus.kernel.util._cls1 get(String s, String s1, String s2, Attributes attributes)
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
        return super._mth1(s, s1, s2, attributes);
    }

    RespondToBestOffer.this._cls1()
    {
        this$0 = RespondToBestOfferResponse.this;
        super();
    }
}
