// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingEstimate;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingEstimatesResponse

class this._cls3 extends com.ebay.nautilus.kernel.util.ngServiceInfo._cls3
{

    final this._cls3 this$3;

    protected void setValue(long l)
        throws SAXException
    {
        _fld3.shippingService.minDeliveryDays = l;
    }

    ()
    {
        this$3 = this._cls3.this;
        super();
    }
}
