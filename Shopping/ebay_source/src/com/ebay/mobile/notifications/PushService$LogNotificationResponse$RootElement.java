// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.nautilus.domain.net.AckElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.notifications:
//            PushService

private final class <init> extends com.ebay.nautilus.kernel.util.<init>
{

    final this._cls0 this$0;

    public com.ebay.nautilus.kernel.util.<init> get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Ack".equals(s1))
        {
            return new AckElement(this._cls0.this);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private ()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}
