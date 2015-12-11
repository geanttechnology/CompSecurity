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

class this._cls1
    implements Callback
{

    final ss._cls000 this$1;

    public void onError(Bundle bundle)
    {
        MAPLog.e(CentralAccountManagerCommunication.access$000(), "Failed to deregister the device after detecting child device type change.");
    }

    public void onSuccess(Bundle bundle)
    {
        MAPLog.i(CentralAccountManagerCommunication.access$000(), "Device was deregistered due to the child device type change.");
    }

    l.tracer()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1

/* anonymous class */
    class CentralAccountManagerCommunication._cls1
        implements Runnable
    {

        final CentralAccountManagerCommunication this$0;
        final Tracer val$tracer;

        public void run()
        {
            deregisterDevice(new CentralAccountManagerCommunication._cls1._cls1(), tracer);
        }

            
            {
                this$0 = final_centralaccountmanagercommunication;
                tracer = Tracer.this;
                super();
            }
    }

}
