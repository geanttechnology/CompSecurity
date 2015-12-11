// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import com.ebay.common.model.mdns.DeviceHandle;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.mdns:
//            EbayMdnsApi

public static abstract class metaCategories extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.RequestBuilder
{

    private final DeviceHandle deviceHandle;
    private final String language;
    private final String metaCategories;
    private final String userId;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.taException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    protected abstract void buildSpecificXmlRequest(XmlSerializer xmlserializer)
        throws IOException;

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        String s = getOperationName();
        EbayMdnsApi.writeCommonFirstElements(s, userId, language, deviceHandle, xmlserializer);
        buildSpecificXmlRequest(xmlserializer);
        EbayMdnsApi.writeCommonLastElements(s, xmlserializer);
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.notificationApi);
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

    protected (String s, String s1, String s2, String s3, String s4, DeviceHandle devicehandle, EbaySite ebaysite)
    {
        super("MobileDeviceNotificationService", true, s);
        iafToken = s1;
        userId = s2;
        deviceHandle = devicehandle;
        language = s3;
        soaMessageProtocol = "SOAP12";
        if (ebaysite != null)
        {
            s = ebaysite.idString;
        } else
        {
            s = GLOBAL_ID;
        }
        soaGlobalId = s;
        dataFormat = "XML";
        isConvertedToAlternateHttpFaultStatus = true;
        metaCategories = s4;
    }
}
