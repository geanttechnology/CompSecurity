// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.uas;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class IsValidForResponse extends EbayResponse
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final IsValidForResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("isValidForResponse".equals(s1))
            {
                return new ResponseElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$0 = IsValidForResponse.this;
            super();
        }

    }

    private final class ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final IsValidForResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(IsValidForResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(IsValidForResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(IsValidForResponse.this, "http://www.ebay.com/marketplace/security/v1/services");
            }
            if ("status".equals(s1))
            {
                return new StatusElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseElement()
        {
            this$0 = IsValidForResponse.this;
            super();
        }

    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final IsValidForResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = IsValidForResponse.this;
            super();
        }

    }

    private final class StatusElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final IsValidForResponse this$0;

        public void text(String s)
            throws SAXException
        {
            valid = "true".equals(s);
        }

        private StatusElement()
        {
            this$0 = IsValidForResponse.this;
            super();
        }

    }


    boolean valid;

    public IsValidForResponse()
    {
    }

    public boolean isValid()
    {
        return valid;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
