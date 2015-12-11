// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController

class val.sc
    implements Runnable
{

    final val.sc this$1;
    final Exception val$e;
    final ServiceCall val$sc;

    public void run()
    {
        ProductController.access$1000(_fld0, val$e, val$sc);
    }

    ()
    {
        this$1 = final_;
        val$e = exception;
        val$sc = ServiceCall.this;
        super();
    }
}
