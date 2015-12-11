// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.device;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control.device:
//            DeviceUpdateController

class val.sc
    implements Runnable
{

    final DeviceUpdateController this$0;
    final ServiceCall val$sc;

    public void run()
    {
        if (DeviceUpdateController.access$300(DeviceUpdateController.this, val$sc))
        {
            DeviceUpdateController.access$400(DeviceUpdateController.this);
            kiangUpdate();
        }
    }

    ()
    {
        this$0 = final_deviceupdatecontroller;
        val$sc = ServiceCall.this;
        super();
    }
}
