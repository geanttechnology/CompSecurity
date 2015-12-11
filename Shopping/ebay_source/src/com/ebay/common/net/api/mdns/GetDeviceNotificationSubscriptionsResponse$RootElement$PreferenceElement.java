// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.mdns:
//            GetDeviceNotificationSubscriptionsResponse

private final class preference extends com.ebay.nautilus.kernel.util.reference
{

    private final preference preference;
    final preference this$1;

    public com.ebay.nautilus.kernel.util.reference get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
        {
            if ("eventName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetDeviceNotificationSubscriptionsResponse.RootElement.PreferenceElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        preference.eventType = com.ebay.common.model.mdns.NotificationPreference.EventType.valueOf(s3);
                    }

            
            {
                this$2 = GetDeviceNotificationSubscriptionsResponse.RootElement.PreferenceElement.this;
                super();
            }
                };
            }
            if ("properties".equals(s1))
            {
                return new nit>(this._cls1.this, preference);
            }
        }
        return super.reference(s, s1, s2, attributes);
    }


    public _cls1.this._cls2(List list)
    {
        this$1 = this._cls1.this;
        super();
        _pcls2 = new this._cls1();
        preference = preference.this;
        list.add(preference.this);
    }
}
