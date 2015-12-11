// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetShipmentTrackingResponse

private final class detail extends com.ebay.nautilus.kernel.util.op
{

    private final ShipmentTrackingDetail detail;
    final GetShipmentTrackingResponse this$0;

    public com.ebay.nautilus.kernel.util.op get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        final com.ebay.nautilus.domain.data.op hop = (com.ebay.nautilus.domain.data.op)detail.hops.get(detail.hops.size() - 1);
        if ("From".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.Hop this$1;
                final com.ebay.nautilus.domain.data.ShipmentTrackingDetail.Hop val$hop;

                public void text(String s3)
                    throws SAXException
                {
                    hop.from = s3;
                }

            
            {
                this$1 = GetShipmentTrackingResponse.Hop.this;
                hop = hop2;
                super();
            }
            };
        }
        if ("To".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.Hop this$1;
                final com.ebay.nautilus.domain.data.ShipmentTrackingDetail.Hop val$hop;

                public void text(String s3)
                    throws SAXException
                {
                    hop.to = s3;
                }

            
            {
                this$1 = GetShipmentTrackingResponse.Hop.this;
                hop = hop2;
                super();
            }
            };
        } else
        {
            return super.op(s, s1, s2, attributes);
        }
    }

    public _cls2.val.hop(ShipmentTrackingDetail shipmenttrackingdetail)
    {
        this$0 = GetShipmentTrackingResponse.this;
        super();
        detail = shipmenttrackingdetail;
        detail.addHop();
    }
}
