// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetShipmentTrackingResponse

class this._cls1 extends com.ebay.nautilus.kernel.util.._cls2
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        cess._mth700(this._cls1.this).trackingNumber = s;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
