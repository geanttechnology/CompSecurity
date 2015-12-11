// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.aps:
//            GetUserActivitySummary

public static final class userId extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.serId
{

    private static final String API_VERSION = "835";
    private final String userId;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.serId
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/mobileor/v1/services");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/services", "getUserActivitySummary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/services", "clientID", userId);
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/services", "getUserActivitySummary");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.applicationProcessSvc);
    }

    public  getResponse()
    {
        return new (null);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("x-ebay-api-compatibility-level", "835");
        iheaders.setHeader("x-ebay-api-version", "835");
    }

    public (String s, EbaySite ebaysite, String s1)
    {
        super("IPhoneApplicationProcessService", true, "getUserActivitySummary");
        super.iafToken = s;
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.soaGlobalId = ebaysite.idString;
        super.soaSoapAction = (new StringBuilder()).append("\"http://www.ebay.com/marketplace/mobileor/v1/services/").append(getOperationName()).append('"').toString();
        super.timeout = 0x2bf20;
        userId = s1;
    }
}
