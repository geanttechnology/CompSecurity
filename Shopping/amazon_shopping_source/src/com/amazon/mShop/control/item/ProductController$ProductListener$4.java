// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.rio.j2me.client.services.mShop.Savings;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController

class val.value
    implements Runnable
{

    final val.value this$1;
    final Savings val$value;

    public void run()
    {
        if (!cess._mth1300(this._cls1.this))
        {
            setProductSavings(val$value);
        }
    }

    ()
    {
        this$1 = final_;
        val$value = Savings.this;
        super();
    }
}
