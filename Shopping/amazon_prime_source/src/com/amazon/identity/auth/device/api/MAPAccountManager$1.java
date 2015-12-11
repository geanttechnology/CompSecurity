// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPAccountManager, SigninOption, MAPFuture

class val.activity
    implements Callback
{

    final MAPAccountManager this$0;
    final Activity val$activity;
    final CallbackFuture val$callbackFuture;
    final Bundle val$options;
    final Bundle val$regData;
    final Tracer val$tracer;

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
            MAPAccountManager.access$100$155a5955$7f64b773(bundle, (String)val$regData.get("com.amazon.identity.ap.domain"));
            bundle.putBundle("com.amazon.identity.auth.ChallengeException", bundle2);
            registerAccountWithUI(val$activity, SigninOption.WebviewSignin, bundle, val$callbackFuture);
            return;
        } else
        {
            val$callbackFuture.onError(bundle);
            return;
        }
    }

    public void onSuccess(final Bundle result)
    {
        if (val$options != null && val$options.containsKey("EnsureAccountStateAttributes"))
        {
            MAPLog.i(MAPAccountManager.access$000(), "Register account is done, going to check whether the account has assert attributes");
            Object obj = result.getString("com.amazon.dcp.sso.property.account.acctId");
            final String finalDirectedId = ((String) (obj));
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                MAPLog.i(MAPAccountManager.access$000(), "Did not get the directedID in the reg success respone so we are going to fix the account we get from getAccount(). It should not happen on Gen6+ and normal 3P devices.");
                finalDirectedId = getAccount();
            }
            obj = new Bundle();
            ((Bundle) (obj)).putString("com.amazon.identity.ap.domain", val$regData.getString("com.amazon.identity.ap.domain"));
            ((Bundle) (obj)).putBundle("com.amazon.identity.ap.request.parameters", val$options.getBundle("com.amazon.identity.ap.request.parameters"));
            ((Bundle) (obj)).putStringArrayList("EnsureAccountStateAttributes", val$options.getStringArrayList("EnsureAccountStateAttributes"));
            result = new Callback() {

                final MAPAccountManager._cls1 this$1;
                final String val$finalDirectedId;
                final Bundle val$result;

                public void onError(Bundle bundle)
                {
                    try
                    {
                        tracer.incrementCounter("DeregisterAfterEnsuringAccountStateFail");
                        MAPLog.i(MAPAccountManager.access$000(), "Going to degister the account, since the account doesn't have assert attributes");
                        deregisterAccount(finalDirectedId, null).get();
                    }
                    catch (Exception exception)
                    {
                        MAPLog.e(MAPAccountManager.access$000(), "Exception happened when try to degister account because of missing assert attributes");
                    }
                    callbackFuture.onError(bundle);
                }

                public void onSuccess(Bundle bundle)
                {
                    result.putAll(bundle);
                    callbackFuture.onSuccess(result);
                }

            
            {
                this$1 = MAPAccountManager._cls1.this;
                result = bundle;
                finalDirectedId = s;
                super();
            }
            };
            val$tracer.incrementCounter("RegisterAccountWithEnsuringAccountState");
            ensureAccountState(val$activity, finalDirectedId, ((Bundle) (obj)), result);
            return;
        } else
        {
            val$callbackFuture.onSuccess(result);
            return;
        }
    }

    _cls1.val.finalDirectedId()
    {
        this$0 = final_mapaccountmanager;
        val$options = bundle;
        val$regData = bundle1;
        val$callbackFuture = callbackfuture;
        val$tracer = tracer1;
        val$activity = Activity.this;
        super();
    }
}
