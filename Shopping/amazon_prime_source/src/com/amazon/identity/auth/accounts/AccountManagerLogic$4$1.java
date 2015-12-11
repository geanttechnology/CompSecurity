// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.utils.ThreadUtils;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerLogic, AccountsCallbackHelpers

class val.extras
    implements Runnable
{

    final val.extras this$1;
    final String val$accountName;
    final String val$accountType;
    final Bundle val$extras;

    public void run()
    {
        AccountManagerLogic.access$500$70268062(_fld0, regType, regData, callback, val$accountName, val$extras);
    }

    l.callback()
    {
        this$1 = final_callback;
        val$accountType = s;
        val$accountName = s1;
        val$extras = Bundle.this;
        super();
    }

    // Unreferenced inner class com/amazon/identity/auth/accounts/AccountManagerLogic$4

/* anonymous class */
    class AccountManagerLogic._cls4
        implements AccountRegistrar.Listener
    {

        final AccountManagerLogic this$0;
        final Callback val$callback;
        final Bundle val$regData;
        final RegistrationType val$regType;

        public void accountAlreadyExists(String s)
        {
            AccountsCallbackHelpers.onAccountAlreadyExistsError(callback, s);
        }

        public void failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror, Bundle bundle)
        {
            AccountManagerLogic.access$600$1d91c68c(registrationerror, callback, bundle);
        }

        public void success(final String accountType, final String accountName, Bundle bundle)
        {
            ThreadUtils.submitToBackgroundThread(bundle. new AccountManagerLogic._cls4._cls1());
        }

            
            {
                this$0 = final_accountmanagerlogic;
                regType = registrationtype;
                regData = bundle;
                callback = Callback.this;
                super();
            }
    }

}
