// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetFeedbackResponse

private final class <init> extends com.ebay.nautilus.kernel.util.y
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util.y get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "FeedbackDetail".equals(s1))
        {
            return new >(this._cls1.this);
        } else
        {
            return super._mth1(s, s1, s2, attributes);
        }
    }

    private Y()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
