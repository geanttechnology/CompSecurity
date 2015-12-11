// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.ProgressBar;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.shippingFields.RegionMX;
import com.groupon.service.ShippingService;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.activity:
//            DeliveryAddresses

class downAddress
    implements Function1
{

    final DeliveryAddresses this$0;
    final DealBreakdownAddress val$location;

    public void execute(RegionMX regionmx)
    {
        progressBar.setVisibility(8);
        DeliveryAddresses deliveryaddresses = DeliveryAddresses.this;
        android.view.ViewGroup viewgroup = addressesContainer;
        int i;
        if (DeliveryAddresses.access$600(DeliveryAddresses.this))
        {
            i = 0x7f0301e2;
        } else
        {
            i = 0x7f0301e1;
        }
        deliveryaddresses.getBasicListItem(viewgroup, i, DeliveryAddresses.access$500(DeliveryAddresses.this).getAsJoin(val$location, regionmx.stateName, regionmx.name, false), val$location.shipping_name, val$location, new android.view.View.OnClickListener() {

            final DeliveryAddresses._cls10 this$1;

            public void onClick(View view)
            {
                DeliveryAddresses.access$500(this$0).store(location.id);
                setResultAndFinish();
            }

            
            {
                this$1 = DeliveryAddresses._cls10.this;
                super();
            }
        }, new android.view.View.OnClickListener() {

            final DeliveryAddresses._cls10 this$1;

            public void onClick(View view)
            {
                DeliveryAddresses.access$400(this$0, location);
            }

            
            {
                this$1 = DeliveryAddresses._cls10.this;
                super();
            }
        });
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((RegionMX)obj);
    }

    downAddress()
    {
        this$0 = final_deliveryaddresses;
        val$location = DealBreakdownAddress.this;
        super();
    }
}
