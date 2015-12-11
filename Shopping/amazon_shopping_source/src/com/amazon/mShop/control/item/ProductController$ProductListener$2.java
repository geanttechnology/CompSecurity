// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController

class val.value
    implements Runnable
{

    final is._cls0 this$1;
    final BasicProductInfo val$value;

    public void run()
    {
        if (!cess._mth1300(this._cls1.this))
        {
            ProductController.access$1400(_fld0, val$value);
            if (!Util.isEmpty(val$value.getImageUrl()))
            {
                ProductController.access$500(_fld0);
            }
        }
    }

    ()
    {
        this$1 = final_;
        val$value = BasicProductInfo.this;
        super();
    }
}
