// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            CentralAccountManagerCommunication

class val.tracer
    implements Runnable
{

    final CentralAccountManagerCommunication this$0;
    final Tracer val$tracer;

    public void run()
    {
        deregisterDevice(new Callback() {

            final CentralAccountManagerCommunication._cls1 this$1;

            public void onError(Bundle bundle)
            {
                MAPLog.e(CentralAccountManagerCommunication.access$000(), "Failed to deregister the device after detecting child device type change.");
            }

            public void onSuccess(Bundle bundle)
            {
                MAPLog.i(CentralAccountManagerCommunication.access$000(), "Device was deregistered due to the child device type change.");
            }

            
            {
                this$1 = CentralAccountManagerCommunication._cls1.this;
                super();
            }
        }, val$tracer);
    }

    _cls1.this._cls1()
    {
        this$0 = final_centralaccountmanagercommunication;
        val$tracer = Tracer.this;
        super();
    }
}
