// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.mdns:
//            GetDeviceNotificationSubscriptionsResponse

private final class preferences extends com.ebay.nautilus.kernel.util.references
{

    private final List preferences;
    final preferences this$1;

    public com.ebay.nautilus.kernel.util.references get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s) && "preference".equals(s1))
        {
            return new init>(this._cls1.this, preferences);
        } else
        {
            return super.references(s, s1, s2, attributes);
        }
    }

    public (List list)
    {
        this$1 = this._cls1.this;
        super();
        preferences = list;
    }
}
