// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetShipmentTrackingResponse

class val.detail extends com.ebay.nautilus.kernel.util.._cls1
{

    final val.detail this$1;
    final ShipmentTrackingDetail val$detail;

    public void text(String s)
        throws SAXException
    {
        val$detail.trackingStatus = s;
    }

    ()
    {
        this$1 = final_;
        val$detail = ShipmentTrackingDetail.this;
        super();
    }
}
