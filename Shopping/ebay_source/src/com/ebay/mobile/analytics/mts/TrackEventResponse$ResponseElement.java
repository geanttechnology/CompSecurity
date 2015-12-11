// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.mts;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.analytics.mts:
//            TrackEventResponse

private final class <init> extends com.ebay.nautilus.kernel.util.<init>
{

    final TrackEventResponse this$0;

    public com.ebay.nautilus.kernel.util.<init> get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
        {
            if ("ack".equals(s1))
            {
                return new AckElement(TrackEventResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(TrackEventResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(TrackEventResponse.this, "http://www.ebay.com/marketplace/mobile/v1/services");
            }
            if ("responseProperties".equals(s1))
            {
                return new esElement(TrackEventResponse.this, null);
            }
        }
        return super._mth0(s, s1, s2, attributes);
    }

    private esElement()
    {
        this$0 = TrackEventResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
