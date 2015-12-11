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

public class AddFavoriteSeller
{
    public static class AddRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private static final String operationName = "addFavoriteSellers";
        private final ArrayList savedSellers;
        private final ArrayList sellerNotes;

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
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "addFavoriteSellersRequest");
            for (int i = 0; i < savedSellers.size(); i++)
            {
                xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "favoriteSeller");
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "sellerName", (String)savedSellers.get(i));
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "isInsert", "true");
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "sellerNotes", (String)sellerNotes.get(i));
                xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "favoriteSeller");
            }

            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "addFavoriteSellersRequest");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(ApiSettings.myEbaySvcApi);
        }

        public AddResponse getResponse()
        {
            return new AddResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public AddRequest(String s, EbaySite ebaysite, String s1, ArrayList arraylist, ArrayList arraylist1)
        {
            super("MyEbayApplicationService", true, "addFavoriteSellers");
            super.iafToken = s;
            super.soaGlobalId = ebaysite.idString;
            super.soaMessageProtocol = "SOAP12";
            super.dataFormat = "XML";
            super.soaContentType = "text/xml";
            super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
            super.bUseSoaServiceVersion = false;
            savedSellers = arraylist;
            sellerNotes = arraylist1;
        }
    }

    public static final class AddResponse extends EbayResponse
    {

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }

        protected AddResponse()
        {
        }
    }

    private final class AddResponse.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final AddResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("addFavoriteSellersResponse".equals(s1))
            {
                return new AddResponse.ResponseElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private AddResponse.BodyElement()
        {
            this$0 = AddResponse.this;
            super();
        }

    }

    private final class AddResponse.ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final AddResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(AddResponse.this);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private AddResponse.ResponseElement()
        {
            this$0 = AddResponse.this;
            super();
        }

    }

    private final class AddResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final AddResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new AddResponse.BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private AddResponse.RootElement()
        {
            this$0 = AddResponse.this;
            super();
        }

    }


    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobile/v1/services";
    public static final String SERVICE_NAME = "MyEbayApplicationService";
    public static final String SOAP_DOMAIN = "http://schemas.xmlsoap.org/soap/envelope/";
    public final String iafToken;
    public final EbaySite site;

    public AddFavoriteSeller(EbaySite ebaysite, String s)
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
