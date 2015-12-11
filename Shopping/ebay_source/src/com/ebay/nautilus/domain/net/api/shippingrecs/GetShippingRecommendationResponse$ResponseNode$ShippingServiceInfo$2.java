// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingRecommendation;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingRecommendationResponse

class this._cls2 extends com.ebay.nautilus.kernel.util.ngServiceInfo._cls2
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        GetShippingRecommendationResponse.access$900(_fld2).shippingService.serviceId = s;
    }

    ()
    {
        this$2 = this._cls2.this;
        super();
    }
}
