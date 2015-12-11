// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.device;

import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.KiangRegisterResponse;

// Referenced classes of package com.amazon.mShop.control.device:
//            DeviceRegisterController, KiangSubscriber

class onse
    implements Runnable
{

    final DeviceRegisterController this$0;
    final ServiceCall val$sc;
    final KiangRegisterResponse val$value;

    public void run()
    {
        if (DeviceRegisterController.access$000(DeviceRegisterController.this, val$sc))
        {
            DeviceRegisterController.access$100(DeviceRegisterController.this);
            String s = val$value.getApplicationInstallId();
            String s1 = val$value.getSecret();
            if (Util.isEmpty(s))
            {
                com.amazon.mShop.platform.e().invokeLater(new Runnable() {

                    final DeviceRegisterController._cls1 this$1;

                    public void run()
                    {
                        kiangRegister();
                    }

            
            {
                this$1 = DeviceRegisterController._cls1.this;
                super();
            }
                }, getDelayTime());
                return;
            } else
            {
                DataStore datastore = com.amazon.mShop.platform.e().getDataStore();
                datastore.putString("applicationInstallId", s);
                datastore.putString("applicationSecretKey", s1);
                DeviceRegisterController.access$200(DeviceRegisterController.this).onRegisterCompleted();
                return;
            }
        } else
        {
            DeviceRegisterController.access$200(DeviceRegisterController.this).onRegisterError();
            return;
        }
    }

    onse()
    {
        this$0 = final_deviceregistercontroller;
        val$sc = servicecall;
        val$value = KiangRegisterResponse.this;
        super();
    }
}
