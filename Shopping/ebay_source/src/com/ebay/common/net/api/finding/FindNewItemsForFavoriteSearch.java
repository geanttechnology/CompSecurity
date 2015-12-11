// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;

import com.ebay.common.net.EbayRequestHelper;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayDateUtils;
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
import java.util.Date;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

public final class FindNewItemsForFavoriteSearch
{
    public static final class EbaySavedSearchRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private final String searchId;
        private final Date sinceTime;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            String s = (new StringBuilder()).append(getOperationName()).append("Request").toString();
            xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/search/v1/services");
            xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", s);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "searchId", searchId);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "startTimeFrom", EbayDateUtils.formatIso8601DateTime(sinceTime));
            XmlSerializerHelper.writePaginationInput(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", 1, 1);
            xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", s);
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(ApiSettings.finding20Api);
        }

        public EbaySavedSearchResponse getResponse()
        {
            return new EbaySavedSearchResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public EbaySavedSearchRequest(String s, String s1, Date date)
        {
            super("FindingService", false, "findItemsForFavoriteSearch");
            searchId = s1;
            soaAppIdHeaderName = "x-ebay-soa-security-appname";
            super.iafToken = s;
            sinceTime = date;
        }
    }

    private static final class EbaySavedSearchResponse extends EbayResponse
    {

        public int count;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }

        private EbaySavedSearchResponse()
        {
        }

    }

    private final class EbaySavedSearchResponse.MainElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySavedSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("totalEntries".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final EbaySavedSearchResponse.MainElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        count = i;
                    }

            
            {
                this$1 = EbaySavedSearchResponse.MainElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private EbaySavedSearchResponse.MainElement()
        {
            this$0 = EbaySavedSearchResponse.this;
            super();
        }

    }

    private final class EbaySavedSearchResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbaySavedSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(EbaySavedSearchResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(EbaySavedSearchResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(EbaySavedSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            }
            if ("paginationOutput".equals(s1))
            {
                return new EbaySavedSearchResponse.MainElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private EbaySavedSearchResponse.RootElement()
        {
            this$0 = EbaySavedSearchResponse.this;
            super();
        }

    }


    public FindNewItemsForFavoriteSearch()
    {
    }

    public static final int getNewItemCountSince(EbayContext ebaycontext, String s, String s1, long l)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((EbaySavedSearchResponse)EbayRequestHelper.sendRequest(ebaycontext, new EbaySavedSearchRequest(s, s1, new Date(l)))).count;
    }
}
