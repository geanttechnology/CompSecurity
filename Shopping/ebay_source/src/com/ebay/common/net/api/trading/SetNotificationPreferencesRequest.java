// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.trading:
//            SetNotificationPreferencesResponse

public final class SetNotificationPreferencesRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private static final String CALL_NAME = "SetNotificationPreferences";
    public static final String CLIENT_ALERTS_TYPE = "ClientAlerts";
    private final List alertNames;
    private final String deliveryType;
    private final String watchWarningTimeLeft;

    public SetNotificationPreferencesRequest(EbayTradingApi ebaytradingapi, String s, List list, String s1, String s2)
    {
        super(ebaytradingapi, "SetNotificationPreferences");
        deliveryType = s;
        alertNames = list;
        watchWarningTimeLeft = s1;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("", "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "SetNotificationPreferences");
        XmlSerializerHelper.writeSimple(xmlserializer, null, "Version", apiVersion);
        XmlSerializerHelper.writeSimple(xmlserializer, null, "WarningLevel", "High");
        xmlserializer.startTag(null, "ApplicationDeliveryPreferences");
        XmlSerializerHelper.writeSimple(xmlserializer, null, "DeviceType", deliveryType);
        xmlserializer.endTag(null, "ApplicationDeliveryPreferences");
        xmlserializer.startTag(null, "UserDeliveryPreferenceArray");
        for (Iterator iterator = alertNames.iterator(); iterator.hasNext(); xmlserializer.endTag(null, "NotificationEnable"))
        {
            String s = (String)iterator.next();
            xmlserializer.startTag(null, "NotificationEnable");
            XmlSerializerHelper.writeSimple(xmlserializer, null, "EventEnable", "Enable");
            XmlSerializerHelper.writeSimple(xmlserializer, null, "EventType", s);
        }

        xmlserializer.endTag(null, "UserDeliveryPreferenceArray");
        if (!TextUtils.isEmpty(watchWarningTimeLeft))
        {
            xmlserializer.startTag(null, "EventProperty");
            XmlSerializerHelper.writeSimple(xmlserializer, null, "EventType", "WatchedItemEndingSoon");
            XmlSerializerHelper.writeSimple(xmlserializer, null, "Name", "TimeLeft");
            XmlSerializerHelper.writeSimple(xmlserializer, null, "Value", watchWarningTimeLeft);
            xmlserializer.endTag(null, "EventProperty");
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "SetNotificationPreferences");
    }

    public SetNotificationPreferencesResponse getResponse()
    {
        return new SetNotificationPreferencesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
