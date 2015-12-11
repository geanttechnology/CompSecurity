// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;

import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.finding:
//            FindNewItemsForFavoriteSearch

public static final class sinceTime extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.st
{

    private final String searchId;
    private final Date sinceTime;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.st
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        String s = (new StringBuilder()).append(getOperationName()).append("Request").toString();
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/search/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", s);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "searchId", searchId);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "startTimeFrom", EbayDateUtils.formatIso8601DateTime(sinceTime));
        XmlSerializerHelper.writePaginationInput(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", 1, 1);
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", s);
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.finding20Api);
    }

    public  getResponse()
    {
        return new (null);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public (String s, String s1, Date date)
    {
        super("FindingService", false, "findItemsForFavoriteSearch");
        searchId = s1;
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.iafToken = s;
        sinceTime = date;
    }
}
