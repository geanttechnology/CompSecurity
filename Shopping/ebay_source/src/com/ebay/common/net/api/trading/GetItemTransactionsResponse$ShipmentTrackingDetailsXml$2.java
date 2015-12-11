// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

class val.std extends com.ebay.nautilus.kernel.util._cls2
{

    final is._cls0 this$1;
    final com.ebay.common.model.ailsXml val$std;

    public void text(String s)
        throws SAXException
    {
        val$std.ed = s;
        ItemTransaction itemtransaction = GetItemTransactionsResponse.access$600(_fld0);
        boolean flag;
        if ("eBay Now".equalsIgnoreCase(s) || "Scheduled Delivery".equalsIgnoreCase(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        itemtransaction.isEbayNow = flag;
    }

    ()
    {
        this$1 = final_;
        val$std = com.ebay.common.model.ailsXml._cls2.val.std.this;
        super();
    }
}
