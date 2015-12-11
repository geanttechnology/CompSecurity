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
//            EbayMdnsApi, GetDeviceNotificationSubscriptionsResponse

public class GetDeviceNotificationSubscriptionsRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private static final String OPERATION_NAME = "getDeviceNotificationSubscriptions";
    private final DeviceHandle deviceHandle;
    private final String language;
    private final String userId;

    public GetDeviceNotificationSubscriptionsRequest(String s, String s1, EbaySite ebaysite, DeviceHandle devicehandle, String s2)
    {
        super("MobileDeviceNotificationService", true, "getDeviceNotificationSubscriptions");
        iafToken = s1;
        userId = s;
        deviceHandle = devicehandle;
        language = s2;
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
    }

    public final byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        String s = getOperationName();
        EbayMdnsApi.writeCommonFirstElements(s, userId, language, deviceHandle, xmlserializer);
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "outputSelectors");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "outputSelector", "UseDeviceFingerPrint");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "outputSelectors");
        EbayMdnsApi.writeCommonLastElements(s, xmlserializer);
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.notificationApi);
    }

    public GetDeviceNotificationSubscriptionsResponse getResponse()
    {
        return new GetDeviceNotificationSubscriptionsResponse();
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
