// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.pds;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class PdsSetAttributesResponse extends EbayResponse
{
    private final class SetAttributesResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final PdsSetAttributesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equalsIgnoreCase(s1))
            {
                return new AckElement(PdsSetAttributesResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(PdsSetAttributesResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(PdsSetAttributesResponse.this, "http://www.ebay.com/marketplace/mobileor/v1/commonservices");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SetAttributesResponseElement()
        {
            this$0 = PdsSetAttributesResponse.this;
            super();
        }

    }


    public PdsSetAttributesResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new SetAttributesResponseElement());
    }
}
