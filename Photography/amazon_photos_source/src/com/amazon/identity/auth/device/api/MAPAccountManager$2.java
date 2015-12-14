// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.app.Activity;
import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPAccountManager, SigninOption

class val.signinOption
    implements Callback
{

    final MAPAccountManager this$0;
    final Activity val$activity;
    final Bundle val$authData;
    final CallbackFuture val$callbackFuture;
    final Bundle val$options;
    final SigninOption val$signinOption;

    public void onError(Bundle bundle)
    {
        if (bundle.getInt("com.amazon.dcp.sso.ErrorCode", -1) == gistrationError.AUTHENTICATION_CHALLENGED.value())
        {
            bundle = bundle.getBundle("com.amazon.identity.auth.ChallengeException");
            Bundle bundle1 = new Bundle();
            if (val$options != null)
            {
                bundle1.putAll(val$options);
            }
            Object obj = MAPAccountManager.this;
            obj = val$authData;
            MAPAccountManager.access$100$155a5955$7f64b773(bundle1, (String)val$authData.get("com.amazon.identity.ap.domain"));
            if (val$authData.containsKey("com.amazon.dcp.sso.property.account.acctId") && !bundle1.containsKey("com.amazon.dcp.sso.property.account.acctId"))
            {
                bundle1.putString("com.amazon.dcp.sso.property.account.acctId", val$authData.getString("com.amazon.dcp.sso.property.account.acctId"));
            }
            bundle1.putBundle("com.amazon.identity.auth.ChallengeException", bundle);
            authenticateAccountWithUI(val$activity, val$signinOption, bundle1, val$callbackFuture);
            return;
        } else
        {
            val$callbackFuture.onError(bundle);
            return;
        }
    }

    public void onSuccess(Bundle bundle)
    {
        val$callbackFuture.onSuccess(bundle);
    }

    gistrationError()
    {
        this$0 = final_mapaccountmanager;
        val$callbackFuture = callbackfuture;
        val$options = bundle;
        val$authData = bundle1;
        val$activity = activity1;
        val$signinOption = SigninOption.this;
        super();
    }
}
