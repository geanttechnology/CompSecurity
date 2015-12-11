// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper, RtmContentResult, RtmCampaignType, RtmContent

private final class <init> extends com.ebay.nautilus.kernel.util.ment
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util.ment get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("downloadAppCampaign".equals(s1))
        {
            RtmHelper.access$100(this._cls1.this.<init>).rc.campaign = RtmCampaignType.DOWNLOADAPP_CAMPAIGN;
            return new aignElement(this._cls1.this, null);
        }
        if ("htmlCampaign".equals(s1))
        {
            RtmHelper.access$100(_fld1).rc.campaign = RtmCampaignType.HTML_CAMPAIGN;
            return new ment(this._cls1.this, null);
        }
        if ("themedSearchCampaign".equals(s1))
        {
            RtmHelper.access$100(_fld1).rc.campaign = RtmCampaignType.THEMED_SEARCH_CAMPAIGN;
            RtmHelper.access$100(_fld1).rc.searchDescriptions = new ArrayList();
            RtmHelper.access$100(_fld1).rc.itemSearchURLs = new ArrayList();
            return new paignElement(this._cls1.this, null);
        }
        if ("celebrityItemsCampaign".equals(s1))
        {
            RtmHelper.access$100(_fld1).rc.campaign = RtmCampaignType.CELEBRITY_ITEMS_CAMPAIGN;
            return new ampaignElement(this._cls1.this, null);
        }
        if ("itemListCampaign".equals(s1))
        {
            RtmHelper.access$100(_fld1).rc.campaign = RtmCampaignType.ITEM_LIST_CAMPAIGN;
            RtmHelper.access$100(_fld1).rc.itemIds = new ArrayList();
            return new nElement(this._cls1.this, null);
        } else
        {
            return super.init>(s, s1, s2, attributes);
        }
    }

    private nElement()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
