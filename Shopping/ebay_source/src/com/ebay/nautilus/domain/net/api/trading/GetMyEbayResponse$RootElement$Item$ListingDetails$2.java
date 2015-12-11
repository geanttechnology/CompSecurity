// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.util.Date;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

class this._cls1 extends com.ebay.nautilus.kernel.util.gDetails._cls2
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        _fld1.endDate = EbayDateUtils.parseXml(s);
        _fld1.endTimestamp = _fld1.endDate.getTime();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
