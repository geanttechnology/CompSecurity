// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class <init> extends com.ebay.nautilus.kernel.util..Variations
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util..Variations get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Pictures".equals(s1))
            {
                return new nit>(this._cls1.this, null);
            }
            if ("Variation".equals(s1))
            {
                return new l(this._cls1.this);
            }
            if ("VariationSpecificsSet".equals(s1))
            {
                return new ecificsSet(this._cls1.this, null);
            }
        }
        return super.(s, s1, s2, attributes);
    }

    private ecificsSet()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
