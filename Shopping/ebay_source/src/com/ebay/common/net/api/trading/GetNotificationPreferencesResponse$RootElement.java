// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetNotificationPreferencesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t
{

    private final EbayResponse resp;
    final GetNotificationPreferencesResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
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
                return new <init>(GetNotificationPreferencesResponse.this, null);
            }
            if ("EventProperty".equals(s1))
            {
                return new ent(GetNotificationPreferencesResponse.this, null);
            }
        }
        return super._mth0(s, s1, s2, attributes);
    }

    private ent()
    {
        this$0 = GetNotificationPreferencesResponse.this;
        super();
        resp = GetNotificationPreferencesResponse.this;
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
