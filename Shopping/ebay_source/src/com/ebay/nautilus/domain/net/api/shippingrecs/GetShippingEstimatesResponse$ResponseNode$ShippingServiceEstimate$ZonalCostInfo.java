// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.ShippingEstimate;
import com.ebay.nautilus.domain.data.ShippingZonalCost;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingEstimatesResponse

private final class cost extends com.ebay.nautilus.kernel.util.e.ZonalCostInfo
{

    final ShippingZonalCost cost = new ShippingZonalCost();
    final cost this$2;

    public com.ebay.nautilus.kernel.util.e.ZonalCostInfo get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("cost".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                final GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.ZonalCostInfo this$3;

                protected void setValue(double d)
                    throws SAXException
                {
                    cost.cost = d;
                }

            
            {
                this$3 = GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.ZonalCostInfo.this;
                super();
            }
            };
        }
        if ("zone".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.ZonalCostInfo this$3;

                public void setValue(long l)
                    throws SAXException
                {
                    cost.zone = l;
                }

            
            {
                this$3 = GetShippingEstimatesResponse.ResponseNode.ShippingServiceEstimate.ZonalCostInfo.this;
                super();
            }
            };
        } else
        {
            return super.ZonalCostInfo(s, s1, s2, attributes);
        }
    }

    public _cls2.this._cls3()
    {
        this$2 = this._cls2.this;
        super();
        _fld2.costs.add(cost);
    }
}
