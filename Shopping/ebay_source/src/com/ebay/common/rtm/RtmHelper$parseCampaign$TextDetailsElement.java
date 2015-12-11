// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import android.text.Html;
import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper

private class ad extends com.ebay.nautilus.kernel.util.
{

    protected ad ad;
    final ad this$1;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("externalLinkName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.TextDetailsElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    ad.externalLinkName = Html.fromHtml(s3.trim()).toString();
                }

            
            {
                this$2 = RtmHelper.parseCampaign.TextDetailsElement.this;
                super();
            }
            };
        }
        if ("externalLink".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                final RtmHelper.parseCampaign.TextDetailsElement this$2;

                public void setValue(URL url)
                    throws SAXException
                {
                    ad.externalLink = url;
                }

            
            {
                this$2 = RtmHelper.parseCampaign.TextDetailsElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    public _cls2.this._cls2(_cls2.this._cls2 _pcls2_1)
    {
        this$1 = this._cls1.this;
        super();
        ad = _pcls2_1;
    }
}
