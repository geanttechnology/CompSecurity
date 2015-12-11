// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            CentralAccountManagerCommunication, AccountsCallbackHelpers

class val.callbackFuture
    implements com.amazon.identity.auth.device.token.callbackFuture
{

    final CentralAccountManagerCommunication this$0;
    final CallbackFuture val$callbackFuture;

    public void failure$2498c652(int i, String s)
    {
        AccountsCallbackHelpers.onError(val$callbackFuture, i, s, null);
    }

    public void failure$5dc9c75(Bundle bundle)
    {
        val$callbackFuture.onError(bundle);
    }

    public void success()
    {
        val$callbackFuture.onSuccess(new Bundle());
    }

    ()
    {
        this$0 = final_centralaccountmanagercommunication;
        val$callbackFuture = CallbackFuture.this;
        super();
    }
}
