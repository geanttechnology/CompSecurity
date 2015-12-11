// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.KeyInfo;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerLogic, AccountsCallbackHelpers

class val.callbackFuture
    implements ner
{

    final AccountManagerLogic this$0;
    final CallbackFuture val$callbackFuture;
    final String val$directedId;
    final KeyInfo val$key;

    public void accountAlreadyExists(String s)
    {
        AccountsCallbackHelpers.onAccountAlreadyExistsError(val$callbackFuture, s);
    }

    public void failure(com.amazon.identity.auth.device.api.strationError strationerror, Bundle bundle)
    {
        strationerror = AccountsCallbackHelpers.getErrorBundle(strationerror.value(), null);
        val$callbackFuture.onError(strationerror);
    }

    public void success(String s, String s1, Bundle bundle)
    {
        AccountManagerLogic.access$000(AccountManagerLogic.this, val$directedId, val$key.getPackageName(), bundle);
        s = new Bundle();
        BackwardsCompatiabilityHelper.addAccountManagerSuccessInformation(AccountManagerLogic.access$100(AccountManagerLogic.this), val$directedId, s);
        s.putString("authtoken", AccountManagerLogic.access$200(AccountManagerLogic.this).getUserData(val$directedId, val$key.getKey()));
        val$callbackFuture.onSuccess(s);
    }

    gistrationError()
    {
        this$0 = final_accountmanagerlogic;
        val$directedId = s;
        val$key = keyinfo;
        val$callbackFuture = CallbackFuture.this;
        super();
    }
}
