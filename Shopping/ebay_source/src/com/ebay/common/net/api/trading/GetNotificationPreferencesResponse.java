// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import android.text.TextUtils;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class GetNotificationPreferencesResponse extends EbayResponse
{
    private final class MainElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetNotificationPreferencesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("NotificationEnable".equals(s1))
            {
                s = new NotificationPreference();
                prefList.add(s);
                return new PreferenceElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private MainElement()
        {
            this$0 = GetNotificationPreferencesResponse.this;
            super();
        }

    }

    private final class PreferenceElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        NotificationPreference preference;
        final GetNotificationPreferencesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("EventType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PreferenceElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        preference.eventType = s;
                    }

            
            {
                this$1 = PreferenceElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        protected PreferenceElement(NotificationPreference notificationpreference)
        {
            this$0 = GetNotificationPreferencesResponse.this;
            super();
            preference = notificationpreference;
        }
    }

    private final class PropertyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetNotificationPreferencesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PropertyElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        property.setName(s);
                    }

            
            {
                this$1 = PropertyElement.this;
                super();
            }
                };
            }
            if ("Value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PropertyElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        property.addValue(s);
                    }

            
            {
                this$1 = PropertyElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private PropertyElement()
        {
            this$0 = GetNotificationPreferencesResponse.this;
            super();
        }

    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayResponse resp;
        final GetNotificationPreferencesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(resp);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(resp);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(resp, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("UserDeliveryPreferenceArray".equals(s1))
                {
                    return new MainElement();
                }
                if ("EventProperty".equals(s1))
                {
                    return new PropertyElement();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetNotificationPreferencesResponse.this;
            super();
            resp = GetNotificationPreferencesResponse.this;
        }

    }


    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("GetNotificationPrefs", 3, "Log GetNotificationPreferences");
    protected final ArrayList prefList = new ArrayList();
    protected final NameValue property = new NameValue();

    public GetNotificationPreferencesResponse()
    {
    }

    ArrayList getResults()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = prefList.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            NotificationPreference notificationpreference = (NotificationPreference)iterator.next();
            int i = NotificationPreference.clientAlertNameToId(notificationpreference.eventType);
            if (i != -1)
            {
                if (log.isLoggable)
                {
                    FwLog.println(log, (new StringBuilder()).append("getResults, alert name: ").append(notificationpreference.eventType).toString());
                }
                notificationpreference.eventType = NotificationPreference.idToName(i);
                if (i == 1 && !TextUtils.isEmpty(property.getName()) && property.getName().equals(com.ebay.common.model.mdns.NotificationPreference.PropertyType.TimeLeft.name()) && !TextUtils.isEmpty(property.getValue()))
                {
                    notificationpreference.properties.add(property);
                    if (log.isLoggable)
                    {
                        FwLog.println(log, (new StringBuilder()).append("getResults, property time left: ").append(property.getValue()).toString());
                    }
                }
                if (i == 17 && !TextUtils.isEmpty(property.getName()) && property.getName().equals(com.ebay.common.model.mdns.NotificationPreference.PropertyType.TimeLeft.name()) && !TextUtils.isEmpty(property.getValue()))
                {
                    notificationpreference.properties.add(property);
                    if (log.isLoggable)
                    {
                        FwLog.println(log, (new StringBuilder()).append("getResults, property time left: ").append(property.getValue()).toString());
                    }
                }
                arraylist.add(notificationpreference);
            }
        } while (true);
        return arraylist;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }

}
