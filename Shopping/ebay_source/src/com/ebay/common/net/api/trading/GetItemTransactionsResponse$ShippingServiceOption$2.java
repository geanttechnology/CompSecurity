// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

class val.so extends com.ebay.nautilus.kernel.util._cls2
{

    final val.so this$1;
    final ShippingCostsShippingOption val$so;

    public void text(String s)
        throws SAXException
    {
        val$so.shippingServiceName = s;
    }

    Y()
    {
        this$1 = final_y;
        val$so = ShippingCostsShippingOption.this;
        super();
    }
}
