// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.ViewGroup;
import com.groupon.models.shippingFields.SpecialShippingFieldsCLCO;
import com.groupon.service.ShippingService;
import com.groupon.util.Function1;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            DeliveryAddresses

class val.locations
    implements Function1
{

    final DeliveryAddresses this$0;
    final List val$locations;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
    {
        Object obj = DeliveryAddresses.access$500(DeliveryAddresses.this).getSpecialShippingFieldsCLCO(list);
        list = ((SpecialShippingFieldsCLCO) (obj)).getAvailableRegionsForCurrentDeal();
        obj = ((SpecialShippingFieldsCLCO) (obj)).getAvailableLocationsForCurrentDeal();
        DeliveryAddresses.access$800(DeliveryAddresses.this, val$locations, ((java.util.HashMap) (obj)), list);
        list = addressesContainer;
        int i;
        if (addressesContainer.getChildCount() > 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        list.setVisibility(i);
    }

    hippingFieldsCLCO()
    {
        this$0 = final_deliveryaddresses;
        val$locations = List.this;
        super();
    }
}
