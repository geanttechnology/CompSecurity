// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.device;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control.device:
//            DeviceRegisterController, KiangSubscriber

class val.sc
    implements Runnable
{

    final DeviceRegisterController this$0;
    final ServiceCall val$sc;

    public void run()
    {
        if (DeviceRegisterController.access$300(DeviceRegisterController.this, val$sc))
        {
            DeviceRegisterController.access$400(DeviceRegisterController.this);
            kiangRegister();
            return;
        } else
        {
            DeviceRegisterController.access$200(DeviceRegisterController.this).onRegisterError();
            return;
        }
    }

    ()
    {
        this$0 = final_deviceregistercontroller;
        val$sc = ServiceCall.this;
        super();
    }
}
