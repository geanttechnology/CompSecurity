// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.app.Activity;
import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPAccountManager, SigninOption

class val.activity
    implements Callback
{

    final MAPAccountManager this$0;
    final Activity val$activity;
    final CallbackFuture val$callbackFuture;
    final Bundle val$options;

    public void onError(Bundle bundle)
    {
        if (bundle.getInt("com.amazon.dcp.sso.ErrorCode", -1) == gistrationError.AUTHENTICATION_CHALLENGED.value())
        {
            Bundle bundle2 = bundle.getBundle("com.amazon.identity.auth.ChallengeException");
            Bundle bundle1 = val$options;
            bundle = bundle1;
            if (bundle1 == null)
            {
                bundle = new Bundle();
            }
            bundle.putBundle("com.amazon.identity.auth.ChallengeException", bundle2);
            registerAccountWithUI(val$activity, SigninOption.WebviewSignin, bundle, val$callbackFuture);
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
        val$activity = Activity.this;
        super();
    }
}
