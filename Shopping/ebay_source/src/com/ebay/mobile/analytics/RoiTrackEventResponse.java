// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class RoiTrackEventResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RoiTrackEventResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
            {
                if ("ack".equals(s1))
                {
                    return new AckElement(RoiTrackEventResponse.this);
                }
                if ("errorMessage".equals(s1))
                {
                    return new ErrorMessageElement(RoiTrackEventResponse.this, "http://www.ebay.com/marketplace/mobile/v1/services");
                }
                if ("timestamp".equals(s1))
                {
                    return new TimestampElement(RoiTrackEventResponse.this);
                }
                if ("roiFactoryResponses".equals(s1))
                {
                    return new RoiTrackEventResponses();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = RoiTrackEventResponse.this;
            super();
        }

    }

    private final class RootElement.RoiTrackEventResponses extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s) && "roiFactoryResponse".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.RoiTrackEventResponses this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        if (urls == null)
                        {
                            urls = new ArrayList();
                        }
                        urls.add(s);
                    }

            
            {
                this$2 = RootElement.RoiTrackEventResponses.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.RoiTrackEventResponses()
        {
            this$1 = RootElement.this;
            super();
        }

    }


    static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobile/v1/services";
    static final String SOAP_DOMAIN = "http://schemas.xmlsoap.org/soap/envelope/";
    public ArrayList urls;

    public RoiTrackEventResponse()
    {
        urls = null;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
