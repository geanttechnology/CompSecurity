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

private final class ad extends com.ebay.nautilus.kernel.util.
{

    private final ad ad;
    final ad this$1;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("title".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.AdSummaryElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    ad.title = Html.fromHtml(s3.trim()).toString();
                }

            
            {
                this$2 = RtmHelper.parseCampaign.AdSummaryElement.this;
                super();
            }
            };
        }
        if ("subtitle".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.AdSummaryElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    ad.subTitle = Html.fromHtml(s3.trim()).toString();
                }

            
            {
                this$2 = RtmHelper.parseCampaign.AdSummaryElement.this;
                super();
            }
            };
        }
        if ("thumbnailURL".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                final RtmHelper.parseCampaign.AdSummaryElement this$2;

                public void setValue(URL url)
                    throws SAXException
                {
                    ad.thumbnailURL = url;
                }

            
            {
                this$2 = RtmHelper.parseCampaign.AdSummaryElement.this;
                super();
            }
            };
        }
        if ("rtmTrackingURL".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                final RtmHelper.parseCampaign.AdSummaryElement this$2;

                public void setValue(URL url)
                    throws SAXException
                {
                    ad.trackingURL = url;
                }

            
            {
                this$2 = RtmHelper.parseCampaign.AdSummaryElement.this;
                super();
            }
            };
        }
        if ("ClickId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.AdSummaryElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    ad.trackingClickID = s3.trim();
                }

            
            {
                this$2 = RtmHelper.parseCampaign.AdSummaryElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }


    public _cls5.this._cls2(_cls5.this._cls2 _pcls2_1)
    {
        this$1 = this._cls1.this;
        super();
        ad = _pcls2_1;
    }
}
