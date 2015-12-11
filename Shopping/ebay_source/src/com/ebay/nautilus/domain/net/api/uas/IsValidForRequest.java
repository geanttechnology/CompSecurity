// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.uas;

import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.uas:
//            IsValidForResponse

public final class IsValidForRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/security/v1/services";

    public IsValidForRequest(String s, String s1)
    {
        super("UserAuthenticationService", true, "isValidFor");
        iafToken = s;
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
        soaMessageProtocol = "SOAP12";
        soaGlobalId = s1;
        dataFormat = "XML";
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("soap", "http://www.w3.org/2003/05/soap-envelope");
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Envelope");
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Body");
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/security/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/security/v1/services", "isValidForRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/security/v1/services", "hours", "0");
        xmlserializer.endTag("http://www.ebay.com/marketplace/security/v1/services", "isValidForRequest");
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Body");
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Envelope");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.userAuthenticationApi);
    }

    public IsValidForResponse getResponse()
    {
        return new IsValidForResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("x-ebay3pp-device-id", EbayIdentity.get3ppFingerprint(getContext()));
    }
}
