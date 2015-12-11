// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper, RtmContentResult, RtmContent

private final class <init> extends com.ebay.nautilus.kernel.util.
{

    final _cls3 this$1;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("title".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.DownloadAppCampaignElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    RtmHelper.access$100(this$0).rc.detailsTitle = s3.trim();
                }

            
            {
                this$2 = RtmHelper.parseCampaign.DownloadAppCampaignElement.this;
                super();
            }
            };
        }
        if ("infoURL".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                final RtmHelper.parseCampaign.DownloadAppCampaignElement this$2;

                public void setValue(URL url)
                    throws SAXException
                {
                    RtmHelper.access$100(this$0).rc.infoURL = url;
                }

            
            {
                this$2 = RtmHelper.parseCampaign.DownloadAppCampaignElement.this;
                super();
            }
            };
        }
        if ("appStoreURL".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                final RtmHelper.parseCampaign.DownloadAppCampaignElement this$2;

                public void setValue(URL url)
                    throws SAXException
                {
                    RtmHelper.access$100(this$0).rc.appStoreURL = url;
                }

            
            {
                this$2 = RtmHelper.parseCampaign.DownloadAppCampaignElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    private _cls3.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
