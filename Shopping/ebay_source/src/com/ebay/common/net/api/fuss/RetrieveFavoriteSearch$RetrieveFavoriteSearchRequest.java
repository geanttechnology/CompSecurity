// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fuss;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.fuss:
//            RetrieveFavoriteSearch

private final class isConvertedToAlternateHttpFaultStatus extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.isConvertedToAlternateHttpFaultStatus
{

    final RetrieveFavoriteSearch this$0;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.isConvertedToAlternateHttpFaultStatus
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

    public  getResponse()
    {
        return new (RetrieveFavoriteSearch.this);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public (String s, EbayCountry ebaycountry)
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
