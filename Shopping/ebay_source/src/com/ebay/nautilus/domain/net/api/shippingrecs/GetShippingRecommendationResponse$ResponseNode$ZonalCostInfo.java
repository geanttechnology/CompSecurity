// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.ShippingRecommendation;
import com.ebay.nautilus.domain.data.ShippingZonalCost;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingRecommendationResponse

private final class cost extends com.ebay.nautilus.kernel.util.e.ZonalCostInfo
{

    final ShippingZonalCost cost = new ShippingZonalCost();
    final cost this$1;

    public com.ebay.nautilus.kernel.util.e.ZonalCostInfo get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("cost".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                final GetShippingRecommendationResponse.ResponseNode.ZonalCostInfo this$2;

                protected void setValue(double d)
                    throws SAXException
                {
                    cost.cost = d;
                }

            
            {
                this$2 = GetShippingRecommendationResponse.ResponseNode.ZonalCostInfo.this;
                super();
            }
            };
        }
        if ("zone".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final GetShippingRecommendationResponse.ResponseNode.ZonalCostInfo this$2;

                public void setValue(long l)
                    throws SAXException
                {
                    cost.zone = l;
                }

            
            {
                this$2 = GetShippingRecommendationResponse.ResponseNode.ZonalCostInfo.this;
                super();
            }
            };
        } else
        {
            return super.ZonalCostInfo(s, s1, s2, attributes);
        }
    }

    public _cls2.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
        GetShippingRecommendationResponse.access$900(_fld1).costs.add(cost);
    }
}
