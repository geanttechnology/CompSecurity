// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.rtm;

import android.util.Base64;
import com.ebay.common.rtm.RtmContentResult;
import com.ebay.nautilus.kernel.util.XmlFormatter;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.rtm:
//            GetRtm, EbayRtmApi

class this._cls1 extends com.ebay.nautilus.kernel.util.is._cls1
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        if (EbayRtmApi.debugLogger._fld1)
        {
            EbayRtmApi.debugLogger._mth1(XmlFormatter.format(Base64.decode(s, 0)));
        }
        _fld1.rtmContentBase64 = s;
    }

    I()
    {
        this$1 = this._cls1.this;
        super();
    }
}
