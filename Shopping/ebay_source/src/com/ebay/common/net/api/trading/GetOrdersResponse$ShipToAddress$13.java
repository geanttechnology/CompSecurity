// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.OrderItemTransaction;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

class this._cls1 extends com.ebay.nautilus.kernel.util._cls3
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        ess._mth700(this._cls1.this).multiLegStreet1 = s;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
