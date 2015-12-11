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

class val.tracer
    implements eue.AccountAuthenticatorTask
{

    final AccountManagerLogic this$0;
    final Callback val$callback;
    final Bundle val$regData;
    final Tracer val$tracer;

    public Bundle run(final Callback innerCallback)
    {
        if (!getAccounts().isEmpty())
        {
            MAPLog.e(AccountManagerLogic.access$700(), "Registered account found on device. bootstrap API works only on unregistered devices");
            AccountsCallbackHelpers.onAccountAlreadyExistsError(val$callback, AccountManagerLogic.access$1000(AccountManagerLogic.this).getDevicePrimaryAmazonAccount());
            return null;
        } else
        {
            return AccountManagerLogic.access$400(AccountManagerLogic.this, RegistrationType.FROM_ADP_TOKEN, val$regData, new Callback() {

                final AccountManagerLogic._cls9 this$1;
                final Callback val$innerCallback;

                public void onError(Bundle bundle)
                {
                    innerCallback.onError(bundle);
                }

                public void onSuccess(Bundle bundle)
                {
                    AccountManagerLogic.access$200(this$0).setDeviceData("dcp.third.party.device.state", "serial.number", regData.getString("Device Serial Number"));
                    DeviceDataStoreCache.getInstance().invalidateCache();
                    innerCallback.onSuccess(bundle);
                }

            
            {
                this$1 = AccountManagerLogic._cls9.this;
                innerCallback = callback1;
                super();
            }
            }, val$tracer);
        }
    }

    _cls1.val.innerCallback()
    {
        this$0 = final_accountmanagerlogic;
        val$callback = callback1;
        val$regData = bundle;
        val$tracer = Tracer.this;
        super();
    }
}
