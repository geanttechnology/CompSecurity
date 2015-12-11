// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.Deal;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController

class val.value
    implements Runnable
{

    final is._cls0 this$1;
    final ServiceCall val$sc;
    final Deal val$value;

    public void run()
    {
        if (val$sc == cess._mth3700(this._cls1.this))
        {
            setDeal(val$value);
            ProductController.access$3100(_fld0);
        }
    }

    ()
    {
        this$1 = final_;
        val$sc = servicecall;
        val$value = Deal.this;
        super();
    }
}
