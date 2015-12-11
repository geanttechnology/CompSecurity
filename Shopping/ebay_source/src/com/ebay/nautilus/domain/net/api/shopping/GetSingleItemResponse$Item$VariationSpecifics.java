// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.Variation;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class variation extends com.ebay.nautilus.kernel.util.onSpecifics
{

    final variation this$1;
    final Variation variation;

    public com.ebay.nautilus.kernel.util.onSpecifics get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "NameValueList".equals(s1))
        {
            return new >(this._cls1.this, variation.getNameValueList());
        } else
        {
            return super.variation(s, s1, s2, attributes);
        }
    }

    public (Variation variation1)
    {
        this$1 = this._cls1.this;
        super();
        variation = variation1;
    }
}
