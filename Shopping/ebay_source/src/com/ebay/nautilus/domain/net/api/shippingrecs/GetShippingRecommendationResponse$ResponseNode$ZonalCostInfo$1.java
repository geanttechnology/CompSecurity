// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.ShippingZonalCost;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingRecommendationResponse

class this._cls2 extends com.ebay.nautilus.kernel.util.ZonalCostInfo._cls1
{

    final st this$2;

    protected void setValue(double d)
        throws SAXException
    {
        st.cost = d;
    }

    ()
    {
        this$2 = this._cls2.this;
        super();
    }
}
