// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.mdns:
//            GetDeviceNotificationSubscriptionsResponse, DeviceNotificationSubscriptions

private final class operationElement extends com.ebay.nautilus.kernel.util.perationElement
{
    private final class FaultDetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions data;
        final GetDeviceNotificationSubscriptionsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/services".equals(s) && "errorMessage".equals(s1))
            {
                return new ErrorMessageElement(this$0, "http://www.ebay.com/marketplace/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public FaultDetailElement(DeviceNotificationSubscriptions devicenotificationsubscriptions)
        {
            this$1 = GetDeviceNotificationSubscriptionsResponse.RootElement.this;
            super();
            data = devicenotificationsubscriptions;
        }
    }

    private final class FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions data;
        final GetDeviceNotificationSubscriptionsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.w3.org/2003/05/soap-envelope".equals(s) && "Detail".equals(s1))
            {
                return new FaultDetailElement(data);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public FaultElement(DeviceNotificationSubscriptions devicenotificationsubscriptions)
        {
            this$1 = GetDeviceNotificationSubscriptionsResponse.RootElement.this;
            super();
            data = devicenotificationsubscriptions;
        }
    }

    private final class OperationElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions data;
        final GetDeviceNotificationSubscriptionsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
            {
                if ("ack".equals(s1))
                {
                    return new AckElement(this$0);
                }
                if ("timestamp".equals(s1))
                {
                    return new TimestampElement(this$0);
                }
                if ("version".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final OperationElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            setVersion(s);
                        }

            
            {
                this$2 = OperationElement.this;
                super();
            }
                    };
                }
                if ("errorMessage".equals(s1))
                {
                    return new ErrorMessageElement(this$0, "http://www.ebay.com/marketplace/mobile/v1/services");
                }
                if ("active".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final OperationElement this$2;

                        protected void setValue(boolean flag)
                            throws SAXException
                        {
                            data.isActive = flag;
                        }

            
            {
                this$2 = OperationElement.this;
                super();
            }
                    };
                }
                if ("description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final OperationElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.description = s;
                        }

            
            {
                this$2 = OperationElement.this;
                super();
            }
                    };
                }
                if ("language".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final OperationElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            data.language = s;
                        }

            
            {
                this$2 = OperationElement.this;
                super();
            }
                    };
                }
                if ("preferences".equals(s1))
                {
                    return new PreferencesElement(data.activePreferences);
                }
                if ("inactivePreferences".equals(s1))
                {
                    return new PreferencesElement(data.inactivePreferences);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public OperationElement(DeviceNotificationSubscriptions devicenotificationsubscriptions)
        {
            this$1 = GetDeviceNotificationSubscriptionsResponse.RootElement.this;
            super();
            data = devicenotificationsubscriptions;
        }
    }

    private final class PreferenceElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions.Preference preference;
        final GetDeviceNotificationSubscriptionsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
            {
                if ("eventName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final PreferenceElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            preference.eventType = com.ebay.common.model.mdns.NotificationPreference.EventType.valueOf(s);
                        }

            
            {
                this$2 = PreferenceElement.this;
                super();
            }
                    };
                }
                if ("properties".equals(s1))
                {
                    return new PropertyElement(preference);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public PreferenceElement(List list)
        {
            this$1 = GetDeviceNotificationSubscriptionsResponse.RootElement.this;
            super();
            rootelement = new DeviceNotificationSubscriptions.Preference();
            preference = GetDeviceNotificationSubscriptionsResponse.RootElement.this;
            list.add(GetDeviceNotificationSubscriptionsResponse.RootElement.this);
        }
    }

    private final class PreferencesElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final List preferences;
        final GetDeviceNotificationSubscriptionsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s) && "preference".equals(s1))
            {
                return new PreferenceElement(preferences);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public PreferencesElement(List list)
        {
            this$1 = GetDeviceNotificationSubscriptionsResponse.RootElement.this;
            super();
            preferences = list;
        }
    }

    private final class PropertyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions.Preference preference;
        private String propertyName;
        final GetDeviceNotificationSubscriptionsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
            {
                if ("name".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final PropertyElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            propertyName = s;
                            preference.properties.put(propertyName, null);
                        }

            
            {
                this$2 = PropertyElement.this;
                super();
            }
                    };
                }
                if ("value".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final PropertyElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            preference.properties.put(propertyName, s);
                        }

            
            {
                this$2 = PropertyElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }



/*
        static String access$202(PropertyElement propertyelement, String s)
        {
            propertyelement.propertyName = s;
            return s;
        }

*/


        public PropertyElement(DeviceNotificationSubscriptions.Preference preference1)
        {
            this$1 = GetDeviceNotificationSubscriptionsResponse.RootElement.this;
            super();
            preference = preference1;
        }
    }

    private final class SoapBodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final DeviceNotificationSubscriptions data;
        private final String operationElement;
        final GetDeviceNotificationSubscriptionsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
            {
                if (operationElement.equals(s1))
                {
                    return new OperationElement(data);
                }
            } else
            if ("http://www.w3.org/2003/05/soap-envelope".equals(s) && "Fault".equals(s1))
            {
                return new FaultElement(data);
            }
            return super.get(s, s1, s2, attributes);
        }

        public SoapBodyElement(DeviceNotificationSubscriptions devicenotificationsubscriptions, String s)
        {
            this$1 = GetDeviceNotificationSubscriptionsResponse.RootElement.this;
            super();
            data = devicenotificationsubscriptions;
            operationElement = s;
        }
    }


    private final DeviceNotificationSubscriptions data;
    private final String operationElement;
    final GetDeviceNotificationSubscriptionsResponse this$0;

    public com.ebay.nautilus.kernel.util.oapBodyElement.data get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.w3.org/2003/05/soap-envelope".equals(s) && "Body".equals(s1))
        {
            return new SoapBodyElement(data, operationElement);
        } else
        {
            return super.perationElement(s, s1, s2, attributes);
        }
    }

    public SoapBodyElement.operationElement(DeviceNotificationSubscriptions devicenotificationsubscriptions, String s)
    {
        this$0 = GetDeviceNotificationSubscriptionsResponse.this;
        super();
        data = devicenotificationsubscriptions;
        operationElement = s;
    }
}
