// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.account:
//            OneClickController

class val.value
    implements Runnable
{

    final OneClickController this$0;
    final ServiceCall val$sc;
    final List val$value;

    public void run()
    {
        if (OneClickController.access$400(OneClickController.this, val$sc))
        {
            OneClickController.access$500(OneClickController.this);
            OneClickController.access$600(OneClickController.this, val$value);
            OneClickController.access$300(OneClickController.this).onReceiveOneClickAddresses(val$value);
        }
    }

    eClickSubscriber()
    {
        this$0 = final_oneclickcontroller;
        val$sc = servicecall;
        val$value = List.this;
        super();
    }
}
