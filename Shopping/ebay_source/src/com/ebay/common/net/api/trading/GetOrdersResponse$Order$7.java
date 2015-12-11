// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayOrder;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

class > extends com.ebay.nautilus.kernel.util._cls7
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        cess._mth000(this._cls1.this).paidTime = EbayDateUtils.parseXml(s);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
