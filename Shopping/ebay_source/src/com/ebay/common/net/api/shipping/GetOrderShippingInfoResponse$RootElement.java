// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.nautilus.domain.net.ErrorElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetOrderShippingInfoResponse

private final class <init> extends com.ebay.nautilus.kernel.util.nt
{

    final GetOrderShippingInfoResponse this$0;

    public com.ebay.nautilus.kernel.util.nt get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://schemas.xmlsoap.org/soap/envelope/".equals(s))
        {
            if ("Errors".equals(s1))
            {
                return new ErrorElement(GetOrderShippingInfoResponse.this, "urn:ebay:apis:eBLBaseComponents");
            }
            if ("Body".equals(s1))
            {
                return new this._cls0(GetOrderShippingInfoResponse.this, null);
            }
        }
        return super._mth0(s, s1, s2, attributes);
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
