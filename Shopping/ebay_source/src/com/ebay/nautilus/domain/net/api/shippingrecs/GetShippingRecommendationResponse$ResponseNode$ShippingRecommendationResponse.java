// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.net.ErrorElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingRecommendationResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ndationResponse
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util.ndationResponse get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("errors".equals(s1))
        {
            return new ErrorElement(this._cls1.this.<init>, "http://www.ebay.com/marketplace/shipping/v10/services");
        }
        if ("shippingServiceRecommendation".equals(s1))
        {
            return new init>(this._cls1.this, null);
        }
        if ("weight".equals(s1))
        {
            return new this._cls1(this._cls1.this, null);
        }
        if ("dimension".equals(s1))
        {
            return new this._cls1(this._cls1.this, null);
        } else
        {
            return super._mth1(s, s1, s2, attributes);
        }
    }

    private _81_()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
