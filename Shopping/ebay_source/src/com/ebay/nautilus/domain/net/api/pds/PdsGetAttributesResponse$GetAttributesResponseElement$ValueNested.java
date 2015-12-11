// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.pds;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.pds:
//            PdsGetAttributesResponse

private final class attributeId extends com.ebay.nautilus.kernel.util.Nested
{

    final String attributeId;
    final attributeId this$1;

    public com.ebay.nautilus.kernel.util.Nested get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("customValue".equals(s1))
        {
            return new <init>(this._cls1.this, attributeId);
        } else
        {
            return super.attributeId(s, s1, s2, attributes);
        }
    }

    (String s)
    {
        this$1 = this._cls1.this;
        super();
        attributeId = s;
    }
}
