// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetOrderShippingInfoResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ls
{

    final GetOrderShippingInfoResponse this$0;

    public com.ebay.nautilus.kernel.util.ls get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/shipping/v1/services".equals(s) && "deliveryEstimate".equals(s1))
        {
            return new <init>(GetOrderShippingInfoResponse.this, null);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private ()
    {
        this$0 = GetOrderShippingInfoResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
