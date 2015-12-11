// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;

// Referenced classes of package com.groupon.activity:
//            DeliveryAddresses

class this._cls0
    implements android.view.
{

    final DeliveryAddresses this$0;

    public void onClick(View view)
    {
        DeliveryAddresses deliveryaddresses = DeliveryAddresses.this;
        if (DeliveryAddresses.access$300(DeliveryAddresses.this))
        {
            view = defaultAddress;
        } else
        {
            view = null;
        }
        DeliveryAddresses.access$400(deliveryaddresses, view);
    }

    ()
    {
        this$0 = DeliveryAddresses.this;
        super();
    }
}
