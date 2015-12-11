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

class this._cls1 extends com.ebay.nautilus.kernel.util.e
{

    final _cls1 this$1;

    public com.ebay.nautilus.kernel.util.e get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("CallStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RespondToBestOfferResponse._cls1.BestOfferNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    RespondToBestOfferResponse.access$002(this$0, s3);
                }

            
            {
                this$2 = RespondToBestOfferResponse._cls1.BestOfferNode.this;
                super();
            }
            };
        } else
        {
            return super.e(s, s1, s2, attributes);
        }
    }

    ffer.this._cls1()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/ebay/common/net/api/trading/RespondToBestOfferResponse$1

/* anonymous class */
    class RespondToBestOfferResponse._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {
        class RespondToBestOfferResponse._cls1.RespondToBestOffer extends com.ebay.nautilus.kernel.util.SaxHandler.Element
        {

            final RespondToBestOfferResponse._cls1 this$1;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("BestOffer".equals(s1))
                {
                    return new RespondToBestOfferResponse._cls1.BestOfferNode();
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            }

            RespondToBestOfferResponse._cls1.RespondToBestOffer()
            {
                this$1 = RespondToBestOfferResponse._cls1.this;
                super();
            }
        }


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
                    return new RespondToBestOfferResponse._cls1.RespondToBestOffer();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

            
            {
                this$0 = RespondToBestOfferResponse.this;
                super();
            }
    }

}
