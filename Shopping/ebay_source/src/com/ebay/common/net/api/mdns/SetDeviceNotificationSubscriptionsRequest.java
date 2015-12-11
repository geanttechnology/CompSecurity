// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import android.text.TextUtils;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public final class SetDeviceNotificationSubscriptionsRequest extends EbayMdnsApi.MdnsRequest
{

    private static final String OPERATION_NAME = "setDeviceNotificationSubscriptions";
    private final EbayMdnsApi.NotificationParams params;

    public SetDeviceNotificationSubscriptionsRequest(EbayMdnsApi.NotificationParams notificationparams)
    {
        super("setDeviceNotificationSubscriptions", notificationparams.iafToken, notificationparams.userId, notificationparams.language, notificationparams.metaCategories, notificationparams.getDeviceHandle(), notificationparams.site);
        params = notificationparams;
    }

    protected void buildSpecificXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "preferences");
label0:
        for (Iterator iterator = params.prefs.iterator(); iterator.hasNext(); xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "preference"))
        {
            NotificationPreference notificationpreference = (NotificationPreference)iterator.next();
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "preference");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "eventName", notificationpreference.eventType);
            Object obj;
            if (notificationpreference.isEnabled)
            {
                obj = "Enable";
            } else
            {
                obj = "Disable";
            }
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "state", ((String) (obj)));
            if (notificationpreference.deliveryPolicyType != null)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "deliveryPolicyType", notificationpreference.deliveryPolicyType.apiValue);
            }
            if (notificationpreference.properties == null || notificationpreference.properties.size() <= 0)
            {
                continue;
            }
            obj = notificationpreference.properties.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    continue label0;
                }
                NameValue namevalue = (NameValue)((Iterator) (obj)).next();
                xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "properties");
                if (notificationpreference.eventType.equals(com.ebay.common.model.mdns.NotificationPreference.EventType.BIDITEM.name()))
                {
                    XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "name", com.ebay.common.model.mdns.NotificationPreference.PropertyType.TimeLeft.name());
                } else
                {
                    XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "name", namevalue.getName());
                }
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "value", namevalue.getValue());
                xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "properties");
            } while (true);
        }

        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "preferences");
        if (!TextUtils.isEmpty(params.metaCategories) && getOperationName().equals("setDeviceNotificationSubscriptions"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "metaCategoryFilter", params.metaCategories);
        }
        if (params.quietTimeStart != null && params.quietTimeStop != null)
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "quietPeriods");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "quietPeriod");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "quietPeriodTypeCode", "Alldays");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "startHour", params.quietTimeStart);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "endHour", params.quietTimeStop);
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "quietPeriod");
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "quietPeriods");
        }
    }
}
