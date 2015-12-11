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

class this._cls1
    implements Runnable
{

    final gRegister this$1;

    public void run()
    {
        kiangRegister();
    }

    se()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/control/device/DeviceRegisterController$1

/* anonymous class */
    class DeviceRegisterController._cls1
        implements Runnable
    {

        final DeviceRegisterController this$0;
        final ServiceCall val$sc;
        final KiangRegisterResponse val$value;

        public void run()
        {
            if (DeviceRegisterController.access$000(DeviceRegisterController.this, sc))
            {
                DeviceRegisterController.access$100(DeviceRegisterController.this);
                String s = value.getApplicationInstallId();
                String s1 = value.getSecret();
                if (Util.isEmpty(s))
                {
                    com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new DeviceRegisterController._cls1._cls1(), getDelayTime());
                    return;
                } else
                {
                    DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
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

            
            {
                this$0 = final_deviceregistercontroller;
                sc = servicecall;
                value = KiangRegisterResponse.this;
                super();
            }
    }

}
