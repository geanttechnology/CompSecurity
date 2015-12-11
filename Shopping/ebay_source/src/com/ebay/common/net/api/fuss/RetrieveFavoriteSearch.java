// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fuss;

import com.ebay.common.model.search.SavedSearch;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

final class RetrieveFavoriteSearch
{
    private final class RetrieveFavoriteSearchRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        final RetrieveFavoriteSearch this$0;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            RetrieveFavoriteSearch.makeRequest(xmlserializer);
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(EbaySettings.findingUserSettingsApi);
        }

        public RetrieveFavoriteSearchResponse getResponse()
        {
            return new RetrieveFavoriteSearchResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public RetrieveFavoriteSearchRequest(String s, EbayCountry ebaycountry)
        {
            this$0 = RetrieveFavoriteSearch.this;
            super("FindingUserSettingsService", true, "retrieveFavoriteSearch");
            super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
            super.soaMessageProtocol = "SOAP12";
            super.soaContentType = "text/xml";
            super.iafToken = s;
            super.bUseSoaServiceVersion = false;
            isConvertedToAlternateHttpFaultStatus = true;
        }
    }

    private final class RetrieveFavoriteSearchResponse extends EbayResponse
    {

        private final TreeMap searchMap = new TreeMap();
        final RetrieveFavoriteSearch this$0;

        List getSearchList()
        {
            return new ArrayList(searchMap.values());
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }


        protected RetrieveFavoriteSearchResponse()
        {
            this$0 = RetrieveFavoriteSearch.this;
            super();
        }
    }

    private final class RetrieveFavoriteSearchResponse.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RetrieveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("retrieveFavoriteSearchResponse".equals(s1))
            {
                return new RetrieveFavoriteSearchResponse.ResponseElement();
            }
            if ("Fault".equals(s1))
            {
                return new RetrieveFavoriteSearchResponse.FaultElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RetrieveFavoriteSearchResponse.BodyElement()
        {
            this$1 = RetrieveFavoriteSearchResponse.this;
            super();
        }

    }

    private final class RetrieveFavoriteSearchResponse.DetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RetrieveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(RetrieveFavoriteSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RetrieveFavoriteSearchResponse.DetailElement()
        {
            this$1 = RetrieveFavoriteSearchResponse.this;
            super();
        }

    }

    private final class RetrieveFavoriteSearchResponse.FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RetrieveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            ackCode = -1;
            if ("detail".equals(s1))
            {
                return new RetrieveFavoriteSearchResponse.DetailElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RetrieveFavoriteSearchResponse.FaultElement()
        {
            this$1 = RetrieveFavoriteSearchResponse.this;
            super();
        }

    }

    private final class RetrieveFavoriteSearchResponse.MainElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private boolean idParsed;
        private boolean nameParsed;
        private final SavedSearch savedSearch;
        final RetrieveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("searchId".equals(s1))
            {
                idParsed = true;
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RetrieveFavoriteSearchResponse.MainElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        savedSearch.id = s;
                    }

            
            {
                this$2 = RetrieveFavoriteSearchResponse.MainElement.this;
                super();
            }
                };
            }
            if ("searchName".equals(s1))
            {
                nameParsed = true;
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RetrieveFavoriteSearchResponse.MainElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        savedSearch.name = s;
                    }

            
            {
                this$2 = RetrieveFavoriteSearchResponse.MainElement.this;
                super();
            }
                };
            }
            if (idParsed && nameParsed)
            {
                searchMap.put((new StringBuilder()).append(savedSearch.name.toLowerCase(Locale.getDefault())).append(savedSearch.id).toString(), savedSearch);
                nameParsed = false;
                idParsed = false;
            }
            return super.get(s, s1, s2, attributes);
        }


        private RetrieveFavoriteSearchResponse.MainElement()
        {
            this$1 = RetrieveFavoriteSearchResponse.this;
            super();
            savedSearch = new SavedSearch(m_country, 25);
            idParsed = false;
            nameParsed = false;
        }

    }

    private final class RetrieveFavoriteSearchResponse.ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RetrieveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(RetrieveFavoriteSearchResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(RetrieveFavoriteSearchResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(RetrieveFavoriteSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            }
            if ("favoriteSearchRecordResponse".equals(s1))
            {
                return new RetrieveFavoriteSearchResponse.MainElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RetrieveFavoriteSearchResponse.ResponseElement()
        {
            this$1 = RetrieveFavoriteSearchResponse.this;
            super();
        }

    }

    private final class RetrieveFavoriteSearchResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RetrieveFavoriteSearchResponse this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new RetrieveFavoriteSearchResponse.BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RetrieveFavoriteSearchResponse.RootElement()
        {
            this$1 = RetrieveFavoriteSearchResponse.this;
            super();
        }

    }


    private final EbayCountry m_country;

    RetrieveFavoriteSearch(EbayCountry ebaycountry)
    {
        m_country = ebaycountry;
    }

    protected static void makeRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("soap", "http://schemas.xmlsoap.org/soap/envelope/");
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/search/v1/services");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "retrieveFavoriteSearchRequest");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "retrieveFavoriteSearchRequest");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
    }

    final List retrieveFavoriteSearch(EbayContext ebaycontext, String s)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((RetrieveFavoriteSearchResponse)EbayRequestHelper.sendRequest(ebaycontext, new RetrieveFavoriteSearchRequest(s, m_country))).getSearchList();
    }

}
