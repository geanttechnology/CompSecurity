// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper

private final class ad extends com.ebay.nautilus.kernel.util.
{

    private final this._cls1 ad;
    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("parameter".equals(s1))
        {
            if (ad.ad == null)
            {
                ad.ad = new ArrayList();
            }
            s = new ad();
            ad.ad.add(s);
            return new init>(this._cls1.this, s);
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    public ( 1)
    {
        this$1 = this._cls1.this;
        super();
        ad = 1;
    }
}
