// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.mdns:
//            GetDeviceNotificationSubscriptionsResponse, DeviceNotificationSubscriptions

private final class data extends com.ebay.nautilus.kernel.util.ata
{

    private final DeviceNotificationSubscriptions data;
    final data this$1;

    public com.ebay.nautilus.kernel.util.ata get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.w3.org/2003/05/soap-envelope".equals(s) && "Detail".equals(s1))
        {
            return new ement(this._cls1.this, data);
        } else
        {
            return super.ata(s, s1, s2, attributes);
        }
    }

    public ement(DeviceNotificationSubscriptions devicenotificationsubscriptions)
    {
        this$1 = this._cls1.this;
        super();
        data = devicenotificationsubscriptions;
    }
}
