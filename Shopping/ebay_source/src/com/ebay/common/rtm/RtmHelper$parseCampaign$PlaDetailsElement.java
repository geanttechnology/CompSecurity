// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import android.text.Html;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper

private final class  extends 
{

    final .get this$1;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("shippingInfo".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.PlaDetailsElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    ad.shippingInfo = s3.trim();
                }

            
            {
                this$2 = RtmHelper.parseCampaign.PlaDetailsElement.this;
                super();
            }
            };
        }
        if ("price".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.PlaDetailsElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    ad.formattedPriceString = s3.trim();
                }

            
            {
                this$2 = RtmHelper.parseCampaign.PlaDetailsElement.this;
                super();
            }
            };
        }
        if ("strikethroughPrice".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.PlaDetailsElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    ad.formattedStrikethroughPrice = s3.trim();
                }

            
            {
                this$2 = RtmHelper.parseCampaign.PlaDetailsElement.this;
                super();
            }
            };
        }
        if ("retailerName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.PlaDetailsElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    ad.retailerName = Html.fromHtml(s3.trim()).toString();
                }

            
            {
                this$2 = RtmHelper.parseCampaign.PlaDetailsElement.this;
                super();
            }
            };
        } else
        {
            return super.get(s, s1, s2, attributes);
        }
    }

    public _cls4.this._cls2(_cls4.this._cls2 _pcls2_1)
    {
        this$1 = this._cls1.this;
        super(.this, _pcls2_1);
        _pcls2_1. = true;
    }
}
