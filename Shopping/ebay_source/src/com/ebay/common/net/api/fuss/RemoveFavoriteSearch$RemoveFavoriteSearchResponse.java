// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fuss;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.fuss:
//            RemoveFavoriteSearch

private final class this._cls0 extends EbayResponse
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RemoveFavoriteSearch.RemoveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("removeFavoriteSearchResponse".equals(s1))
            {
                return new ResponseElement(null);
            }
            if ("Fault".equals(s1))
            {
                return new FaultElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$1 = RemoveFavoriteSearch.RemoveFavoriteSearchResponse.this;
            super();
        }

        BodyElement(RemoveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class DetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RemoveFavoriteSearch.RemoveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(RemoveFavoriteSearch.RemoveFavoriteSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private DetailElement()
        {
            this$1 = RemoveFavoriteSearch.RemoveFavoriteSearchResponse.this;
            super();
        }

        DetailElement(RemoveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RemoveFavoriteSearch.RemoveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            ackCode = -1;
            if ("detail".equals(s1))
            {
                return new DetailElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private FaultElement()
        {
            this$1 = RemoveFavoriteSearch.RemoveFavoriteSearchResponse.this;
            super();
        }

        FaultElement(RemoveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RemoveFavoriteSearch.RemoveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(RemoveFavoriteSearch.RemoveFavoriteSearchResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(RemoveFavoriteSearch.RemoveFavoriteSearchResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(RemoveFavoriteSearch.RemoveFavoriteSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseElement()
        {
            this$1 = RemoveFavoriteSearch.RemoveFavoriteSearchResponse.this;
            super();
        }

        ResponseElement(RemoveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RemoveFavoriteSearch.RemoveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new BodyElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$1 = RemoveFavoriteSearch.RemoveFavoriteSearchResponse.this;
            super();
        }

        RootElement(RemoveFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }


    final RemoveFavoriteSearch this$0;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.BodyElement
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }

    protected RootElement()
    {
        this$0 = RemoveFavoriteSearch.this;
        super();
    }
}
