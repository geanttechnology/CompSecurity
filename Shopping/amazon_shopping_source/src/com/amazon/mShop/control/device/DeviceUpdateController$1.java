// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.device;

import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.KiangUpdateResponse;

// Referenced classes of package com.amazon.mShop.control.device:
//            DeviceUpdateController, KiangSubscriber

class onse
    implements Runnable
{

    final DeviceUpdateController this$0;
    final ServiceCall val$sc;
    final KiangUpdateResponse val$value;

    public void run()
    {
        if (DeviceUpdateController.access$000(DeviceUpdateController.this, val$sc))
        {
            DeviceUpdateController.access$100(DeviceUpdateController.this);
            if (val$value.getResetRegistration() != null && val$value.getResetRegistration().booleanValue())
            {
                DataStore datastore = com.amazon.mShop.platform.nce().getDataStore();
                datastore.remove("applicationInstallId");
                datastore.remove("applicationSecretKey");
                datastore.remove("kiangUpdateSequenceNumber");
                DeviceUpdateController.access$200(DeviceUpdateController.this).onResetRegister();
            }
        }
    }

    onse()
    {
        this$0 = final_deviceupdatecontroller;
        val$sc = servicecall;
        val$value = KiangUpdateResponse.this;
        super();
    }
}
