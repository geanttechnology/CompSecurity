// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController

class val.value
    implements Runnable
{

    final s._cls0 this$1;
    final String val$value;

    public void run()
    {
        setDealId(val$value);
        if (!Util.isEmpty(val$value))
        {
            if (!val$value.equals(ProductController.access$2600(_fld0)))
            {
                requestDeal(getDealId());
            } else
            {
                ProductController.access$3100(_fld0);
            }
        }
        ProductController.access$2602(_fld0, null);
    }

    ()
    {
        this$1 = final_;
        val$value = String.this;
        super();
    }
}
