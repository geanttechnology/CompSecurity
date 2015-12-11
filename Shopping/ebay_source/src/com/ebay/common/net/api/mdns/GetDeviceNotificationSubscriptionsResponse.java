// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.mdns:
//            DeviceNotificationSubscriptions

public class GetDeviceNotificationSubscriptionsResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions data;
        private final String operationElement;
        final GetDeviceNotificationSubscriptionsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.w3.org/2003/05/soap-envelope".equals(s) && "Body".equals(s1))
            {
                return new SoapBodyElement(data, operationElement);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement(DeviceNotificationSubscriptions devicenotificationsubscriptions, String s)
        {
            this$0 = GetDeviceNotificationSubscriptionsResponse.this;
            super();
            data = devicenotificationsubscriptions;
            operationElement = s;
        }
    }

    private final class RootElement.FaultDetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions data;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/services".equals(s) && "errorMessage".equals(s1))
            {
                return new ErrorMessageElement(_fld0, "http://www.ebay.com/marketplace/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.FaultDetailElement(DeviceNotificationSubscriptions devicenotificationsubscriptions)
        {
            this$1 = RootElement.this;
            super();
            data = devicenotificationsubscriptions;
        }
    }

    private final class RootElement.FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions data;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.w3.org/2003/05/soap-envelope".equals(s) && "Detail".equals(s1))
            {
                return new RootElement.FaultDetailElement(data);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.FaultElement(DeviceNotificationSubscriptions devicenotificationsubscriptions)
        {
            this$1 = RootElement.this;
            super();
            data = devicenotificationsubscriptions;
        }
    }

    private final class RootElement.OperationElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions data;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
            {
                if ("ack".equals(s1))
                {
                    return new AckElement(_fld0);
                }
                if ("timestamp".equals(s1))
                {
                    return new TimestampElement(_fld0);
                }
                if ("version".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.OperationElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            setVersion(s);
                        }

            
            {
                this$2 = RootElement.OperationElement.this;
                super();
            }
                    };
                }
                if ("errorMessage".equals(s1))
                {
                    return new ErrorMessageElement(_fld0, "http://www.ebay.com/marketplace/mobile/v1/services");
                }
                if ("active".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final RootElement.OperationElement this$2;

                        protected void setValue(boolean flag)
                            throws SAXException
                        {
                            data.isActive = flag;
                        }

            
            {
                this$2 = RootElement.OperationElement.this;
                super();
            }
                    };
                }
                if ("description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.OperationElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.description = s;
                        }

            
            {
                this$2 = RootElement.OperationElement.this;
                super();
            }
                    };
                }
                if ("language".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.OperationElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.language = s;
                        }

            
            {
                this$2 = RootElement.OperationElement.this;
                super();
            }
                    };
                }
                if ("preferences".equals(s1))
                {
                    return new RootElement.PreferencesElement(data.activePreferences);
                }
                if ("inactivePreferences".equals(s1))
                {
                    return new RootElement.PreferencesElement(data.inactivePreferences);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement.OperationElement(DeviceNotificationSubscriptions devicenotificationsubscriptions)
        {
            this$1 = RootElement.this;
            super();
            data = devicenotificationsubscriptions;
        }
    }

    private final class RootElement.PreferenceElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions.Preference preference;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
            {
                if ("eventName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.PreferenceElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            preference.eventType = com.ebay.common.model.mdns.NotificationPreference.EventType.valueOf(s);
                        }

            
            {
                this$2 = RootElement.PreferenceElement.this;
                super();
            }
                    };
                }
                if ("properties".equals(s1))
                {
                    return new RootElement.PropertyElement(preference);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement.PreferenceElement(List list)
        {
            this$1 = RootElement.this;
            super();
            rootelement = new DeviceNotificationSubscriptions.Preference();
            preference = RootElement.this;
            list.add(RootElement.this);
        }
    }

    private final class RootElement.PreferencesElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final List preferences;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s) && "preference".equals(s1))
            {
                return new RootElement.PreferenceElement(preferences);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.PreferencesElement(List list)
        {
            this$1 = RootElement.this;
            super();
            preferences = list;
        }
    }

    private final class RootElement.PropertyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions.Preference preference;
        private String propertyName;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
            {
                if ("name".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.PropertyElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            propertyName = s;
                            preference.properties.put(propertyName, null);
                        }

            
            {
                this$2 = RootElement.PropertyElement.this;
                super();
            }
                    };
                }
                if ("value".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.PropertyElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            preference.properties.put(propertyName, s);
                        }

            
            {
                this$2 = RootElement.PropertyElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }



/*
        static String access$202(RootElement.PropertyElement propertyelement, String s)
        {
            propertyelement.propertyName = s;
            return s;
        }

*/


        public RootElement.PropertyElement(DeviceNotificationSubscriptions.Preference preference1)
        {
            this$1 = RootElement.this;
            super();
            preference = preference1;
        }
    }

    private final class RootElement.SoapBodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions data;
        private final String operationElement;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
            {
                if (operationElement.equals(s1))
                {
                    return new RootElement.OperationElement(data);
                }
            } else
            if ("http://www.w3.org/2003/05/soap-envelope".equals(s) && "Fault".equals(s1))
            {
                return new RootElement.FaultElement(data);
            }
            return super.get(s, s1, s2, attributes);
        }

        public RootElement.SoapBodyElement(DeviceNotificationSubscriptions devicenotificationsubscriptions, String s)
        {
            this$1 = RootElement.this;
            super();
            data = devicenotificationsubscriptions;
            operationElement = s;
        }
    }


    public DeviceNotificationSubscriptions subscriptions;

    public GetDeviceNotificationSubscriptionsResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        DeviceNotificationSubscriptions devicenotificationsubscriptions = new DeviceNotificationSubscriptions();
        subscriptions = devicenotificationsubscriptions;
        SaxHandler.parseXml(inputstream, new RootElement(devicenotificationsubscriptions, "getDeviceNotificationSubscriptionsResponse"));
    }
}
