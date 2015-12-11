// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

class this._cls1 extends com.ebay.nautilus.kernel.util.nse.Item._cls20
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        item.endDate = EbayDateUtils.parseXml(s);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
