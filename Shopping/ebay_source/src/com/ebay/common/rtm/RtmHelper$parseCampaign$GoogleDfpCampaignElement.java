// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper

private final class ad extends com.ebay.nautilus.kernel.util.
{

    protected final ad ad;
    final ad this$1;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("adUnitId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.GoogleDfpCampaignElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    ad.adUnitId = s3.trim();
                }

            
            {
                this$2 = RtmHelper.parseCampaign.GoogleDfpCampaignElement.this;
                super();
            }
            };
        }
        if ("ppid".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.GoogleDfpCampaignElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    ad.ppid = s3;
                }

            
            {
                this$2 = RtmHelper.parseCampaign.GoogleDfpCampaignElement.this;
                super();
            }
            };
        }
        if ("adSizeWidth".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final RtmHelper.parseCampaign.GoogleDfpCampaignElement this$2;

                protected void setValue(int i)
                    throws SAXException
                {
                    ad.adSizeWidth = i;
                }

            
            {
                this$2 = RtmHelper.parseCampaign.GoogleDfpCampaignElement.this;
                super();
            }
            };
        }
        if ("adSizeHeight".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final RtmHelper.parseCampaign.GoogleDfpCampaignElement this$2;

                protected void setValue(int i)
                    throws SAXException
                {
                    ad.adSizeHeight = i;
                }

            
            {
                this$2 = RtmHelper.parseCampaign.GoogleDfpCampaignElement.this;
                super();
            }
            };
        }
        if ("userTargetedFlag".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final RtmHelper.parseCampaign.GoogleDfpCampaignElement this$2;

                protected void setValue(boolean flag)
                    throws SAXException
                {
                    ad.userTargeted = flag;
                }

            
            {
                this$2 = RtmHelper.parseCampaign.GoogleDfpCampaignElement.this;
                super();
            }
            };
        }
        if ("parameters".equals(s1))
        {
            return new ad(this._cls1.this, ad);
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
