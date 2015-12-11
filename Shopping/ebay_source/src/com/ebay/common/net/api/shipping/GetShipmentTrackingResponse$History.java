// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetShipmentTrackingResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ry
{

    final GetShipmentTrackingResponse this$0;

    public com.ebay.nautilus.kernel.util.ry get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        ShipmentTrackingDetail shipmenttrackingdetail = (ShipmentTrackingDetail)tracking.details.get(tracking.details.size() - 1);
        if ("scanDetail".equals(s1))
        {
            return new il(GetShipmentTrackingResponse.this, shipmenttrackingdetail);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private il()
    {
        this$0 = GetShipmentTrackingResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
