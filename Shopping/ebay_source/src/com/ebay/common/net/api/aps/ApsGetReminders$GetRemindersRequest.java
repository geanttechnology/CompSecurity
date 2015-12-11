// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import android.text.TextUtils;
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
//            ApsGetReminders

public static final class nextPageLocator extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.er
{

    private static final String API_VERSION = "835";
    private final int entriesPerPage;
    private final String includeSelector;
    private final String nextPageLocator;
    private final String userId;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.er
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
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/services", "getRemindersRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/services", "includeSelector", includeSelector);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/services", "userID", userId);
        if (entriesPerPage > 0 || !TextUtils.isEmpty(nextPageLocator))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/services", "page");
            if (entriesPerPage > 0)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/services", "entriesPerPage", String.valueOf(entriesPerPage));
            }
            if (!TextUtils.isEmpty(nextPageLocator))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/services", "nextPageLocator", nextPageLocator);
            }
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/services", "page");
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/services", "getRemindersRequest");
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
        iheaders.setHeader("x-ebay-api-version", "835");
    }

    public (String s, EbaySite ebaysite, String s1, String s2, int i, String s3)
    {
        super("IPhoneApplicationProcessService", true, "getReminders");
        super.iafToken = s;
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.soaGlobalId = ebaysite.idString;
        super.soaSoapAction = (new StringBuilder()).append("\"http://www.ebay.com/marketplace/mobileor/v1/services/").append(getOperationName()).append('"').toString();
        userId = s1;
        includeSelector = s2;
        entriesPerPage = i;
        nextPageLocator = s3;
    }
}
