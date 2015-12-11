// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fuss;

import android.text.TextUtils;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.fuss:
//            RemoveFavoriteSearch

private final class isConvertedToAlternateHttpFaultStatus extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.isConvertedToAlternateHttpFaultStatus
{

    final String searchId;
    final String searchName;
    final RemoveFavoriteSearch this$0;

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

    public  getResponse()
    {
        return new (RemoveFavoriteSearch.this);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public (String s, String s1, String s2)
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
