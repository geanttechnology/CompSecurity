// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingEstimatesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.esResponse.Body
{

    final GetShippingEstimatesResponse this$0;

    public com.ebay.nautilus.kernel.util.esResponse.Body get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("getShippingEstimatesResponse".equals(s1))
        {
            return new nseNode(GetShippingEstimatesResponse.this, null);
        } else
        {
            return super._mth1(s, s1, s2, attributes);
        }
    }

    private nseNode()
    {
        this$0 = GetShippingEstimatesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
