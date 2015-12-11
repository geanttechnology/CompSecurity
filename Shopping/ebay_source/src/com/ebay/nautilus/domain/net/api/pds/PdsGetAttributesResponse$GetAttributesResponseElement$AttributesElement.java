// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.pds;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.pds:
//            PdsGetAttributesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.lement
{

    attributeId attributeId;
    final attributeId this$1;

    public com.ebay.nautilus.kernel.util.lement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Id".equals(s1))
        {
            return attributeId;
        }
        if ("Value".equals(s1))
        {
            return new attributeId(this._cls1.this, attributeId.attributeId);
        } else
        {
            return super.id(s, s1, s2, attributes);
        }
    }

    private ()
    {
        this$1 = this._cls1.this;
        super();
        attributeId = new (this._cls1.this, null);
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
