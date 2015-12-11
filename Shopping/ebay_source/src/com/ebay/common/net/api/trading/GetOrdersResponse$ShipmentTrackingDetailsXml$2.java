// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

class val.std extends com.ebay.nautilus.kernel.util._cls2
{

    final ed this$1;
    final com.ebay.common.model.ailsXml val$std;

    public void text(String s)
        throws SAXException
    {
        val$std.gCarrierUsed = s;
    }

    ()
    {
        this$1 = final_;
        val$std = com.ebay.common.model.ailsXml._cls2.val.std.this;
        super();
    }
}
