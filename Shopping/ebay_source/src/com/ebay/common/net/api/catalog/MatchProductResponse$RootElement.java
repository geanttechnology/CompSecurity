// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.catalog;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.catalog:
//            MatchProductResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t
{
    private final class MatchNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final MatchProductResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(this$0);
            }
            if ("productMatch".equals(s1))
            {
                return new ProductMatchNode(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private MatchNode()
        {
            this$1 = MatchProductResponse.RootElement.this;
            super();
        }

        MatchNode(MatchProductResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ProductMatchNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final MatchProductResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("eBayProductId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ProductMatchNode this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        results.add(s);
                    }

            
            {
                this$2 = ProductMatchNode.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ProductMatchNode()
        {
            this$1 = MatchProductResponse.RootElement.this;
            super();
        }

        ProductMatchNode(MatchProductResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final MatchProductResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
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
            return new MatchNode(null);
        } else
        {
            return super.t(s, s1, s2, attributes);
        }
    }

    private ProductMatchNode()
    {
        this$0 = MatchProductResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
