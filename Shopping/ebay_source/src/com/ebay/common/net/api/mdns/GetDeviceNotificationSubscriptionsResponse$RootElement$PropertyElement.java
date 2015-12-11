// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.mdns:
//            GetDeviceNotificationSubscriptionsResponse

private final class preference extends com.ebay.nautilus.kernel.util.reference
{

    private final propertyName preference;
    private String propertyName;
    final propertyName this$1;

    public com.ebay.nautilus.kernel.util.reference get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
        {
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetDeviceNotificationSubscriptionsResponse.RootElement.PropertyElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        propertyName = s3;
                        preference.properties.put(propertyName, null);
                    }

            
            {
                this$2 = GetDeviceNotificationSubscriptionsResponse.RootElement.PropertyElement.this;
                super();
            }
                };
            }
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetDeviceNotificationSubscriptionsResponse.RootElement.PropertyElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        preference.properties.put(propertyName, s3);
                    }

            
            {
                this$2 = GetDeviceNotificationSubscriptionsResponse.RootElement.PropertyElement.this;
                super();
            }
                };
            }
        }
        return super.ropertyName(s, s1, s2, attributes);
    }



/*
    static String access$202(_cls2 _pcls2, String s)
    {
        _pcls2.propertyName = s;
        return s;
    }

*/


    public _cls2.this._cls2(_cls2.this._cls2 _pcls2_1)
    {
        this$1 = this._cls1.this;
        super();
        preference = _pcls2_1;
    }
}
