// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.catalog;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class MatchProductResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final MatchProductResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(MatchProductResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(MatchProductResponse.this);
            }
            if ("matchProductResponse".equals(s1))
            {
                return new MatchNode();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = MatchProductResponse.this;
            super();
        }

    }

    private final class RootElement.MatchNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(_fld0);
            }
            if ("productMatch".equals(s1))
            {
                return new RootElement.ProductMatchNode();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.MatchNode()
        {
            this$1 = RootElement.this;
            super();
        }

    }

    private final class RootElement.ProductMatchNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("eBayProductId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.ProductMatchNode this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        results.add(s);
                    }

            
            {
                this$2 = RootElement.ProductMatchNode.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.ProductMatchNode()
        {
            this$1 = RootElement.this;
            super();
        }

    }


    public int abridgedMatchCount;
    public int matchCount;
    public ArrayList results;

    public MatchProductResponse()
    {
        results = new ArrayList();
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
