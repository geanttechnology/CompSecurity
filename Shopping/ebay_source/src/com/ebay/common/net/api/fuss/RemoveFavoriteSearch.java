// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fuss;

import android.text.TextUtils;
import com.ebay.common.net.EbayRequestHelper;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

final class RemoveFavoriteSearch
{
    private final class RemoveFavoriteSearchRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        final String searchId;
        final String searchName;
        final RemoveFavoriteSearch this$0;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            xmlserializer.setPrefix("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/search/v1/services");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "removeFavoriteSearchRequest");
            if (!TextUtils.isEmpty(searchId))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "searchId", searchId);
            } else
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "searchName", searchName);
            }
            xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "removeFavoriteSearchRequest");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(EbaySettings.findingUserSettingsApi);
        }

        public RemoveFavoriteSearchResponse getResponse()
        {
            return new RemoveFavoriteSearchResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public RemoveFavoriteSearchRequest(String s, String s1, String s2)
        {
            this$0 = RemoveFavoriteSearch.this;
            super("FindingUserSettingsService", true, "removeFavoriteSearch");
            super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
            super.soaMessageProtocol = "SOAP12";
            super.soaContentType = "text/xml";
            super.iafToken = s;
            super.bUseSoaServiceVersion = false;
            searchId = s1;
            searchName = s2;
            isConvertedToAlternateHttpFaultStatus = true;
        }
    }

    private final class RemoveFavoriteSearchResponse extends EbayResponse
    {

        final RemoveFavoriteSearch this$0;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }

        protected RemoveFavoriteSearchResponse()
        {
            this$0 = RemoveFavoriteSearch.this;
            super();
        }
    }

    private final class RemoveFavoriteSearchResponse.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RemoveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("removeFavoriteSearchResponse".equals(s1))
            {
                return new RemoveFavoriteSearchResponse.ResponseElement();
            }
            if ("Fault".equals(s1))
            {
                return new RemoveFavoriteSearchResponse.FaultElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RemoveFavoriteSearchResponse.BodyElement()
        {
            this$1 = RemoveFavoriteSearchResponse.this;
            super();
        }

    }

    private final class RemoveFavoriteSearchResponse.DetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RemoveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(RemoveFavoriteSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RemoveFavoriteSearchResponse.DetailElement()
        {
            this$1 = RemoveFavoriteSearchResponse.this;
            super();
        }

    }

    private final class RemoveFavoriteSearchResponse.FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RemoveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            ackCode = -1;
            if ("detail".equals(s1))
            {
                return new RemoveFavoriteSearchResponse.DetailElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RemoveFavoriteSearchResponse.FaultElement()
        {
            this$1 = RemoveFavoriteSearchResponse.this;
            super();
        }

    }

    private final class RemoveFavoriteSearchResponse.ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RemoveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(RemoveFavoriteSearchResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(RemoveFavoriteSearchResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(RemoveFavoriteSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RemoveFavoriteSearchResponse.ResponseElement()
        {
            this$1 = RemoveFavoriteSearchResponse.this;
            super();
        }

    }

    private final class RemoveFavoriteSearchResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RemoveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new RemoveFavoriteSearchResponse.BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RemoveFavoriteSearchResponse.RootElement()
        {
            this$1 = RemoveFavoriteSearchResponse.this;
            super();
        }

    }


    RemoveFavoriteSearch(EbayCountry ebaycountry)
    {
    }

    final boolean removeFavoriteSearch(EbayContext ebaycontext, String s, String s1, String s2)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((RemoveFavoriteSearchResponse)EbayRequestHelper.sendRequest(ebaycontext, new RemoveFavoriteSearchRequest(s, s1, s2))).isSuccessful();
    }
}
