// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper, RtmContentResult, RtmCampaignType, RtmContent

private final class ad extends com.ebay.nautilus.kernel.util.
{

    private final ad ad;
    final ad this$1;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("plaAdCampaign".equals(s1))
        {
            return new (this._cls1.this, ad);
        }
        if ("textAdCampaign".equals(s1))
        {
            return new t(this._cls1.this, ad);
        }
        if ("googleDFPCampaign".equals(s1))
        {
            RtmHelper.access$100(this._cls1.this.ad).rc.campaign = RtmCampaignType.GOOGLE_DFP_CAMPAIGN;
            return new Element(this._cls1.this, ad);
        } else
        {
            return super.nit>(s, s1, s2, attributes);
        }
    }

    public Element(Element element1)
    {
        this$1 = this._cls1.this;
        super();
        ad = element1;
    }
}
