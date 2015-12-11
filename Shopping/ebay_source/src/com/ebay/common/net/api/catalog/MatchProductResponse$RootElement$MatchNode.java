// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.catalog;

import com.ebay.nautilus.domain.net.AckElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.catalog:
//            MatchProductResponse

private final class <init> extends com.ebay.nautilus.kernel.util.e
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util.e get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ack".equals(s1))
        {
            return new AckElement(this._cls1.this.<init>);
        }
        if ("productMatch".equals(s1))
        {
            return new chNode(this._cls1.this, null);
        } else
        {
            return super._mth1(s, s1, s2, attributes);
        }
    }

    private chNode()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
