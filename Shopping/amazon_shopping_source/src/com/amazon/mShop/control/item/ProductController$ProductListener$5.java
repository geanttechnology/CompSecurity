// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickShippingOffers;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController

class ers
    implements Runnable
{

    final is._cls0 this$1;
    final PrimeOneClickShippingOffers val$value;

    public void run()
    {
        if (!cess._mth1300(this._cls1.this))
        {
            ProductController.access$1600(_fld0, val$value);
            ProductController.access$700(_fld0);
        }
    }

    ers()
    {
        this$1 = final_ers;
        val$value = PrimeOneClickShippingOffers.this;
        super();
    }
}
