// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.mdns.NotificationPreference;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetNotificationPreferencesResponse

private final class preference extends com.ebay.nautilus.kernel.util.t
{

    NotificationPreference preference;
    final GetNotificationPreferencesResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("EventType".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetNotificationPreferencesResponse.PreferenceElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    preference.eventType = s3;
                }

            
            {
                this$1 = GetNotificationPreferencesResponse.PreferenceElement.this;
                super();
            }
            };
        } else
        {
            return super.t(s, s1, s2, attributes);
        }
    }

    protected _cls1.this._cls1(NotificationPreference notificationpreference)
    {
        this$0 = GetNotificationPreferencesResponse.this;
        super();
        preference = notificationpreference;
    }
}
