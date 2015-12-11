// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

public class RmFavoriteSeller
{
    public static class RmRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private static final String operationName = "removeFavoriteSellers";
        private final ArrayList savedSellers;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            xmlserializer.setPrefix("soap", "http://schemas.xmlsoap.org/soap/envelope/");
            xmlserializer.setPrefix("ser", "http://www.ebay.com/marketplace/mobile/v1/services");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "removeFavoriteSellersRequest");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "removeAll", "true");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "sellerNamesList");
            for (int i = 0; i < savedSellers.size(); i++)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "sellerName", (String)savedSellers.get(i));
            }

            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "sellerNamesList");
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "removeFavoriteSellersRequest");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(ApiSettings.myEbaySvcApi);
        }

        public RmResponse getResponse()
        {
            return new RmResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public RmRequest(String s, EbaySite ebaysite, String s1, ArrayList arraylist)
        {
            super("MyEbayApplicationService", true, "removeFavoriteSellers");
            super.iafToken = s;
            super.soaGlobalId = ebaysite.idString;
            super.soaMessageProtocol = "SOAP12";
            super.dataFormat = "XML";
            super.soaContentType = "text/xml";
            super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
            super.bUseSoaServiceVersion = false;
            savedSellers = arraylist;
        }
    }

    public static final class RmResponse extends EbayResponse
    {

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }

        protected RmResponse()
        {
        }
    }

    private final class RmResponse.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RmResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("removeFavoriteSellersResponse".equals(s1))
            {
                return new RmResponse.ResponseElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RmResponse.BodyElement()
        {
            this$0 = RmResponse.this;
            super();
        }

    }

    private final class RmResponse.ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RmResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(RmResponse.this);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RmResponse.ResponseElement()
        {
            this$0 = RmResponse.this;
            super();
        }

    }

    private final class RmResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RmResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new RmResponse.BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RmResponse.RootElement()
        {
            this$0 = RmResponse.this;
            super();
        }

    }


    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobile/v1/services";
    public static final String SERVICE_NAME = "MyEbayApplicationService";
    public static final String SOAP_DOMAIN = "http://schemas.xmlsoap.org/soap/envelope/";
    public final String iafToken;
    public final EbaySite site;

    public RmFavoriteSeller(EbaySite ebaysite, String s)
    {
        site = ebaysite;
        iafToken = s;
        if (ebaysite == null)
        {
            throw new NullPointerException("site");
        }
        if (s == null)
        {
            throw new NullPointerException("iafToken");
        } else
        {
            return;
        }
    }
}
