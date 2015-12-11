// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.net.ErrorMessageElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingEstimatesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.timatesResponse
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util.timatesResponse get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("shippingEstimate".equals(s1))
        {
            return new nit>(this._cls1.this);
        }
        if ("errors".equals(s1))
        {
            return new ErrorMessageElement(_fld1, "http://www.ebay.com/marketplace/shipping/v10/services");
        } else
        {
            return super._mth1(s, s1, s2, attributes);
        }
    }

    private ()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
