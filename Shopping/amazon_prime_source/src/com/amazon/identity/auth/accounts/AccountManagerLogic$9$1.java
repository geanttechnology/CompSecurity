// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.devicedata.DeviceDataStoreCache;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerLogic, AmazonAccountManager, AccountsCallbackHelpers

class val.innerCallback
    implements Callback
{

    final val.innerCallback this$1;
    final Callback val$innerCallback;

    public void onError(Bundle bundle)
    {
        val$innerCallback.onError(bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        AccountManagerLogic.access$200(_fld0).setDeviceData("dcp.third.party.device.state", "serial.number", regData.getString("Device Serial Number"));
        DeviceDataStoreCache.getInstance().invalidateCache();
        val$innerCallback.onSuccess(bundle);
    }

    l.tracer()
    {
        this$1 = final_tracer;
        val$innerCallback = Callback.this;
        super();
    }

    // Unreferenced inner class com/amazon/identity/auth/accounts/AccountManagerLogic$9

/* anonymous class */
    class AccountManagerLogic._cls9
        implements AccountAuthenticatorQueue.AccountAuthenticatorTask
    {

        final AccountManagerLogic this$0;
        final Callback val$callback;
        final Bundle val$regData;
        final Tracer val$tracer;

        public Bundle run(Callback callback1)
        {
            if (!getAccounts().isEmpty())
            {
                MAPLog.e(AccountManagerLogic.access$700(), "Registered account found on device. bootstrap API works only on unregistered devices");
                AccountsCallbackHelpers.onAccountAlreadyExistsError(callback, AccountManagerLogic.access$1000(AccountManagerLogic.this).getDevicePrimaryAmazonAccount());
                return null;
            } else
            {
                return AccountManagerLogic.access$400(AccountManagerLogic.this, RegistrationType.FROM_ADP_TOKEN, regData, callback1. new AccountManagerLogic._cls9._cls1(), tracer);
            }
        }

            
            {
                this$0 = final_accountmanagerlogic;
                callback = callback1;
                regData = bundle;
                tracer = Tracer.this;
                super();
            }
    }

}
