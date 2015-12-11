// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper, RtmContentResult, RtmContent

private final class ad extends com.ebay.nautilus.kernel.util.
{

    private final ad ad;
    final ad this$1;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("summary".equals(s1))
        {
            return new lement(this._cls1.this, ad);
        }
        if ("details".equals(s1))
        {
            return new lement(this._cls1.this, ad);
        } else
        {
            return super.it>(s, s1, s2, attributes);
        }
    }

    public lement(lement lement1)
    {
        this$1 = this._cls1.this;
        super();
        ad = lement1;
        if (RtmHelper.access$100(ad.this.ad).rc.ads == null)
        {
            RtmHelper.access$100(ad.this.ad).rc.ads = new ArrayList();
        }
        RtmHelper.access$100(ad.this.ad).rc.ads.add(lement1);
    }
}
