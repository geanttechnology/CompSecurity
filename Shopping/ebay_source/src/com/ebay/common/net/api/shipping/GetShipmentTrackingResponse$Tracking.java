// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetShipmentTrackingResponse

private final class detail extends com.ebay.nautilus.kernel.util.ng
{

    private final ShipmentTrackingDetail detail;
    final GetShipmentTrackingResponse this$0;

    public com.ebay.nautilus.kernel.util.ng get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("shippingCarrier".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.Tracking this$1;

                public void text(String s3)
                    throws SAXException
                {
                    detail.carrier = s3;
                }

            
            {
                this$1 = GetShipmentTrackingResponse.Tracking.this;
                super();
            }
            };
        }
        if ("trackingNumber".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.Tracking this$1;

                public void text(String s3)
                    throws SAXException
                {
                    detail.trackingNumber = s3;
                }

            
            {
                this$1 = GetShipmentTrackingResponse.Tracking.this;
                super();
            }
            };
        }
        if ("Hop".equals(s1))
        {
            return new >(GetShipmentTrackingResponse.this, detail);
        } else
        {
            return super.detail(s, s1, s2, attributes);
        }
    }


    public _cls2.this._cls1(ShipmentTrackingDetail shipmenttrackingdetail)
    {
        this$0 = GetShipmentTrackingResponse.this;
        super();
        detail = shipmenttrackingdetail;
    }
}
