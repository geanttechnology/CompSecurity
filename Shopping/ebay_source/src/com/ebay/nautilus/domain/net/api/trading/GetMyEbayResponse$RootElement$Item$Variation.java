// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private final class <init> extends com.ebay.nautilus.kernel.util..Variation
{

    final this._cls0 this$0;

    public com.ebay.nautilus.kernel.util..Variation get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("VariationSpecifics".equals(s1))
        {
            return new pecifics(this._cls0.this, null);
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    private pecifics()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}
