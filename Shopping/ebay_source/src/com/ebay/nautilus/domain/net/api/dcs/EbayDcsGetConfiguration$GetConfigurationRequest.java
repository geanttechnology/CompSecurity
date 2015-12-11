// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.dcs;

import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.dcs:
//            EbayDcsGetConfiguration

public static final class siteId extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.Request
{

    static final String REQUEST_NAME = "getConfigurationRequest";
    static final int TIMEOUT = 0x15f90;
    private final String currConfigVersion;
    private final String siteId;
    private final URL url;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Request
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        Object obj = getEbayContext();
        String s = EbayAppCredentials.get(((EbayContext) (obj))).appName;
        obj = ((EbayContext) (obj)).getAppInfo().getAppVersionWithoutBuildNumber();
        xmlserializer.setPrefix("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/mobile/v1/services");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "getConfigurationRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "applicationName", s);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "applicationVersion", ((String) (obj)));
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "currentConfigurationVersion", currConfigVersion);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "siteId", siteId);
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "getConfigurationRequest");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
    }

    public URL getRequestUrl()
    {
        return url;
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public (URL url1, String s, EbaySite ebaysite)
    {
        super("DeviceConfigurationService", true, "getConfiguration");
        super.soaMessageProtocol = "SOAP12";
        super.soaContentType = "text/xml";
        super.timeout = 0x15f90;
        url = url1;
        currConfigVersion = s;
        siteId = ebaysite.id;
    }
}
