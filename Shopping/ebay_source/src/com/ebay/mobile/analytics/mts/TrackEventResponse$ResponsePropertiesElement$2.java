// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.mts;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.analytics.mts:
//            TrackEventResponse, AnalyticsProviderModule

class this._cls1 extends com.ebay.nautilus.kernel.util.this._cls1
{

    final is._cls0 this$1;

    public void text(String s)
        throws SAXException
    {
        if ("rovercookie".equals(stKey))
        {
            AnalyticsProviderModule.saveCookie(TrackEventResponse.access$400(_fld0), s);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
