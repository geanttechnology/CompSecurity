// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.mdns.NotificationPreference;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetNotificationPreferencesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t
{

    final GetNotificationPreferencesResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("NotificationEnable".equals(s1))
        {
            s = new NotificationPreference();
            prefList.add(s);
            return new ement(GetNotificationPreferencesResponse.this, s);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private ement()
    {
        this$0 = GetNotificationPreferencesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
