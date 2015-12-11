// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.data.ShippingPackageInfo;
import com.ebay.nautilus.domain.data.ShippingTrackingEvent;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

class this._cls1 extends com.ebay.nautilus.kernel.util._cls2
{

    final is._cls0 this$1;

    public void text(String s)
        throws SAXException
    {
        GetItemTransactionsResponse.access$600(_fld0).selectedShippingOption.shippingPackageInfo.shippingTrackingEvent = ShippingTrackingEvent.valueOf(s);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
