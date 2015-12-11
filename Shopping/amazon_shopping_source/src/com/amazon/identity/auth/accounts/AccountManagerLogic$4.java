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

class val.callback
    implements ner
{

    final AccountManagerLogic this$0;
    final Callback val$callback;
    final Bundle val$regData;
    final RegistrationType val$regType;

    public void accountAlreadyExists(String s)
    {
        AccountsCallbackHelpers.onAccountAlreadyExistsError(val$callback, s);
    }

    public void failure(com.amazon.identity.auth.device.api.strationError strationerror, Bundle bundle)
    {
        AccountManagerLogic.access$600(AccountManagerLogic.this, strationerror, val$callback, bundle);
    }

    public void success(final String accountType, final String accountName, final Bundle extras)
    {
        ThreadUtils.submitToBackgroundThread(new Runnable() {

            final AccountManagerLogic._cls4 this$1;
            final String val$accountName;
            final String val$accountType;
            final Bundle val$extras;

            public void run()
            {
                AccountManagerLogic.access$500(this$0, regType, regData, callback, accountType, accountName, extras);
            }

            
            {
                this$1 = AccountManagerLogic._cls4.this;
                accountType = s;
                accountName = s1;
                extras = bundle;
                super();
            }
        });
    }

    _cls1.val.extras()
    {
        this$0 = final_accountmanagerlogic;
        val$regType = registrationtype;
        val$regData = bundle;
        val$callback = Callback.this;
        super();
    }
}
