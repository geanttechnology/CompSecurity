// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetShipmentTrackingResponse

private final class <init> extends com.ebay.nautilus.kernel.util.se
{

    final GetShipmentTrackingResponse this$0;

    public com.ebay.nautilus.kernel.util.se get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ack".equals(s1))
        {
            return new AckElement(GetShipmentTrackingResponse.this);
        }
        if ("Timestamp".equals(s1))
        {
            return new TimestampElement(GetShipmentTrackingResponse.this);
        }
        if ("Errors".equals(s1))
        {
            return new ErrorElement(GetShipmentTrackingResponse.this, "urn:ebay:apis:eBLBaseComponents");
        }
        if ("shipmentTrackingResponseInfo".equals(s1))
        {
            return new nfo(GetShipmentTrackingResponse.this, null);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private nfo()
    {
        this$0 = GetShipmentTrackingResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
