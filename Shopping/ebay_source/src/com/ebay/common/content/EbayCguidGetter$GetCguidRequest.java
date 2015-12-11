// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.content:
//            EbayCguidGetter

private static final class iafToken extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.uilder
{

    private static final String REQUEST_NAME = "getUserCGUIDRequest";
    private static final String SERVICE_NAME = "CommonMobileAppService";
    private static final String SERVICE_OPERATION = "getUserCGUID";
    private static final String SERVICE_VERSION = "1.1.5";
    private static final URL ServiceUrl;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.ion
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("soap", "http://www.w3.org/2003/05/soap-envelope");
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Envelope");
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Body");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "getUserCGUIDRequest");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/commonservices", "getUserCGUIDRequest");
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Body");
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Envelope");
    }

    public URL getRequestUrl()
    {
        return ServiceUrl;
    }

    public  getResponse()
    {
        return new ();
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

    static 
    {
        Object obj1 = null;
        Object obj;
        if (NautilusKernel.isQaMode())
        {
            obj = "https://api4.qa.ebay.com/services/mobileor/v1/CommonMobileAppService";
        } else
        {
            obj = "https://svcs.ebay.com/services/mobileor/v1/CommonMobileAppService";
        }
        try
        {
            obj = new URL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            malformedurlexception = obj1;
        }
        ServiceUrl = ((URL) (obj));
        return;
    }

    public (EbaySite ebaysite, String s)
    {
        super("CommonMobileAppService", true, "getUserCGUID");
        soaServiceVersion = "1.1.5";
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
        soaGlobalId = ebaysite.idString;
        dataFormat = "XML";
        responseDataFormat = "XML";
        if (s != null)
        {
            iafToken = s;
        }
    }
}
