// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.nautilus.domain.data.ShipmentTrackingScanDetail;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetShipmentTrackingResponse

class val.scanDetail extends com.ebay.nautilus.kernel.util.._cls1
{

    final val.scanDetail this$1;
    final ShipmentTrackingScanDetail val$scanDetail;

    public void text(String s)
        throws SAXException
    {
        val$scanDetail.eventStatus = s;
    }

    ()
    {
        this$1 = final_;
        val$scanDetail = ShipmentTrackingScanDetail.this;
        super();
    }
}
