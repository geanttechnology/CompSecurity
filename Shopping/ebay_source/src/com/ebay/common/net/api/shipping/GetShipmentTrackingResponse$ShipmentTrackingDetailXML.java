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

private final class this._cls0 extends com.ebay.nautilus.kernel.util.ML
{

    final GetShipmentTrackingResponse this$0;

    public com.ebay.nautilus.kernel.util.ML get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        final ShipmentTrackingDetail detail = (ShipmentTrackingDetail)tracking.details.get(tracking.details.size() - 1);
        if ("tracking".equals(s1))
        {
            return new this._cls0(GetShipmentTrackingResponse.this, detail);
        }
        if ("trackingStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.ShipmentTrackingDetailXML this$1;
                final ShipmentTrackingDetail val$detail;

                public void text(String s3)
                    throws SAXException
                {
                    detail.trackingStatus = s3;
                }

            
            {
                this$1 = GetShipmentTrackingResponse.ShipmentTrackingDetailXML.this;
                detail = shipmenttrackingdetail;
                super();
            }
            };
        }
        if ("history".equals(s1))
        {
            return new _cls1.val.detail(GetShipmentTrackingResponse.this, null);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    public _cls1.val.detail()
    {
        this$0 = GetShipmentTrackingResponse.this;
        super();
        tracking.addDetail();
    }
}
