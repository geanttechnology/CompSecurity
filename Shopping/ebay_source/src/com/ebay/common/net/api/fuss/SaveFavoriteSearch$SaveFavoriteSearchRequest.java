// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fuss;

import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.fuss:
//            SaveFavoriteSearch

private static class isConvertedToAlternateHttpFaultStatus extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.isConvertedToAlternateHttpFaultStatus
{

    String searchName;
    com.ebay.common.net.api.search.tResponse searchRequest;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.isConvertedToAlternateHttpFaultStatus
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
        searchRequest.hParameterDetails(xmlserializer);
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "saveFavoriteSearchRequest");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.findingUserSettingsApi);
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public (String s, SearchParameters searchparameters, String s1)
    {
        super("FindingUserSettingsService", true, "saveFavoriteSearch");
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.soaGlobalId = searchparameters.country.site.idString;
        super.soaMessageProtocol = "SOAP12";
        super.soaContentType = "text/xml";
        super.iafToken = s;
        super.bUseSoaServiceVersion = false;
        searchRequest = new com.ebay.common.net.api.search.archRequest(searchparameters, 1, false, false);
        searchName = s1;
        isConvertedToAlternateHttpFaultStatus = true;
    }
}
