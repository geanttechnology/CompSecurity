// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper

private final class <init> extends com.ebay.nautilus.kernel.util.
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("summary".equals(s1))
        {
            return new nt(this._cls1.this, null);
        }
        if ("details".equals(s1))
        {
            return new nt(this._cls1.this, null);
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    private nt()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
