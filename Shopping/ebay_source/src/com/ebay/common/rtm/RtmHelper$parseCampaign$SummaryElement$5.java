// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper, RtmContentResult, RtmContent

class this._cls2 extends com.ebay.nautilus.kernel.util.
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        RtmHelper.access$100(_fld2).rc.trackingClickID = s.trim();
    }

    ()
    {
        this$2 = this._cls2.this;
        super();
    }
}
