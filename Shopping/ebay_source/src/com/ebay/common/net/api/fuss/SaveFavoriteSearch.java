// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fuss;

import com.ebay.common.net.EbayRequestHelper;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
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

final class SaveFavoriteSearch
{
    private static class SaveFavoriteSearchRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        String searchName;
        com.ebay.common.net.api.search.SavedSearchesApi.EbaySearchRequest searchRequest;

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
            xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "saveFavoriteSearchRequest");
            xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "favoriteSearchRecordRequest");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "searchName", searchName);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "emailMe", "false");
            xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "favoriteSearchRecordRequest");
            searchRequest.buildSearchParameterDetails(xmlserializer);
            xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "saveFavoriteSearchRequest");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(EbaySettings.findingUserSettingsApi);
        }

        public SaveFavoriteSearchResponse getResponse()
        {
            return new SaveFavoriteSearchResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public SaveFavoriteSearchRequest(String s, SearchParameters searchparameters, String s1)
        {
            super("FindingUserSettingsService", true, "saveFavoriteSearch");
            super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
            super.soaGlobalId = searchparameters.country.site.idString;
            super.soaMessageProtocol = "SOAP12";
            super.soaContentType = "text/xml";
            super.iafToken = s;
            super.bUseSoaServiceVersion = false;
            searchRequest = new com.ebay.common.net.api.search.SavedSearchesApi.EbaySearchRequest(searchparameters, 1, false, false);
            searchName = s1;
            isConvertedToAlternateHttpFaultStatus = true;
        }
    }

    private static class SaveFavoriteSearchResponse extends EbayResponse
    {

        private String searchId;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }



/*
        static String access$002(SaveFavoriteSearchResponse savefavoritesearchresponse, String s)
        {
            savefavoritesearchresponse.searchId = s;
            return s;
        }

*/

        protected SaveFavoriteSearchResponse()
        {
        }
    }

    private final class SaveFavoriteSearchResponse.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SaveFavoriteSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("saveFavoriteSearchResponse".equals(s1))
            {
                return new SaveFavoriteSearchResponse.ResponseElement();
            }
            if ("Fault".equals(s1))
            {
                return new SaveFavoriteSearchResponse.FaultElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SaveFavoriteSearchResponse.BodyElement()
        {
            this$0 = SaveFavoriteSearchResponse.this;
            super();
        }

    }

    private final class SaveFavoriteSearchResponse.DetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SaveFavoriteSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(SaveFavoriteSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SaveFavoriteSearchResponse.DetailElement()
        {
            this$0 = SaveFavoriteSearchResponse.this;
            super();
        }

    }

    private final class SaveFavoriteSearchResponse.FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SaveFavoriteSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            ackCode = -1;
            if ("detail".equals(s1))
            {
                return new SaveFavoriteSearchResponse.DetailElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SaveFavoriteSearchResponse.FaultElement()
        {
            this$0 = SaveFavoriteSearchResponse.this;
            super();
        }

    }

    private final class SaveFavoriteSearchResponse.MainElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public String id;
        boolean idParsed;
        final SaveFavoriteSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("searchId".equals(s1))
            {
                idParsed = true;
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SaveFavoriteSearchResponse.MainElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        id = s;
                    }

            
            {
                this$1 = SaveFavoriteSearchResponse.MainElement.this;
                super();
            }
                };
            }
            if (idParsed)
            {
                searchId = id;
                idParsed = false;
            }
            return super.get(s, s1, s2, attributes);
        }

        private SaveFavoriteSearchResponse.MainElement()
        {
            this$0 = SaveFavoriteSearchResponse.this;
            super();
            idParsed = false;
        }

    }

    private final class SaveFavoriteSearchResponse.ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SaveFavoriteSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(SaveFavoriteSearchResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(SaveFavoriteSearchResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(SaveFavoriteSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            }
            if ("favoriteSearchRecordResponse".equals(s1))
            {
                return new SaveFavoriteSearchResponse.MainElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SaveFavoriteSearchResponse.ResponseElement()
        {
            this$0 = SaveFavoriteSearchResponse.this;
            super();
        }

    }

    private final class SaveFavoriteSearchResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SaveFavoriteSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new SaveFavoriteSearchResponse.BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SaveFavoriteSearchResponse.RootElement()
        {
            this$0 = SaveFavoriteSearchResponse.this;
            super();
        }

    }


    private SaveFavoriteSearch()
    {
    }

    static String saveFavoriteSearch(EbayContext ebaycontext, String s, SearchParameters searchparameters, String s1)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((SaveFavoriteSearchResponse)EbayRequestHelper.sendRequest(ebaycontext, new SaveFavoriteSearchRequest(s, searchparameters, s1))).searchId;
    }
}
