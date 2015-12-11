// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;

import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.finding:
//            GetSearchKeywordsRecommendationResponse

public class GetSearchKeywordsRecommendationRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final String keywords;

    public GetSearchKeywordsRecommendationRequest(String s)
    {
        super("FindingService", false, "getSearchKeywordsRecommendation");
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
        keywords = s;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("", "http://www.ebay.com/marketplace/search/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "getSearchKeywordsRecommendationRequest");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "keywords", keywords);
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "getSearchKeywordsRecommendationRequest");
    }

    public URL getRequestUrl()
    {
        ApiSettings apisettings;
        if (iafToken == null)
        {
            apisettings = ApiSettings.finding20Api;
        } else
        {
            apisettings = ApiSettings.finding20ApiSecure;
        }
        return ApiSettings.getUrl(apisettings);
    }

    public GetSearchKeywordsRecommendationResponse getResponse()
    {
        return new GetSearchKeywordsRecommendationResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
