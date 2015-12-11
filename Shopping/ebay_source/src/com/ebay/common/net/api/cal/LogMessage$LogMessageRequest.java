// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cal;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.cal:
//            LogMessage

public static final class data extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.stBuilder
{

    static final String REQUEST_NAME = "logMessageRequest";
    final String data;
    final String details;
    final String version;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.eption
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/mobile/v1/services");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "logMessageRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "name", "APIError");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "level", "ERROR");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "clientInfo");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "clientDetails", details);
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "appDetails");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "environment", "PRODUCTION");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "version", version);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "appName", "eBayAndroid");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "appDetails");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "clientType", "Mobile");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "clientInfo");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "data", data);
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "logMessageRequest");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.cal);
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public boolean isErrorReportable()
    {
        return false;
    }

    public boolean isTrafficReportable()
    {
        return false;
    }

    protected (String s, String s1, String s2, EbaySite ebaysite)
    {
        super("ApplicationLoggingService", true, "logMessage");
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.bUseSoaServiceVersion = true;
        if (ebaysite != null)
        {
            ebaysite = ebaysite.idString;
        } else
        {
            ebaysite = GLOBAL_ID;
        }
        super.soaGlobalId = ebaysite;
        super.soaMessageProtocol = "SOAP12";
        super.soaContentType = "text/xml";
        details = s;
        version = s1;
        data = s2;
    }
}
