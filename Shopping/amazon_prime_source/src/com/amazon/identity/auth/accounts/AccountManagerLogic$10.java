// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.app.Activity;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.SigninOption;
import com.amazon.identity.auth.device.api.TokenManagement;
import com.amazon.identity.auth.device.attribute.PandaUserProfileRequest;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.token.TokenCallbackHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.ArrayList;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerLogic

class val.activity
    implements Runnable
{

    final AccountManagerLogic this$0;
    final Activity val$activity;
    final Callback val$callback;
    final String val$directedId;
    final Bundle val$options;
    final Tracer val$tracer;

    public void run()
    {
        Object obj1 = val$options.getString("com.amazon.identity.ap.domain");
        Object obj = val$options.getStringArrayList("EnsureAccountStateAttributes");
        Object obj2 = new TokenManagement(AccountManagerLogic.access$100(AccountManagerLogic.this));
        try
        {
            obj2 = (Bundle)((TokenManagement) (obj2)).getToken(val$directedId, "com.amazon.dcp.sso.token.oauth.amazon.access_token", null, null).get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MAPLog.e(AccountManagerLogic.access$700(), "Cannot get access token");
            val$callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.trationError.INTERNAL_ERROR.value(), "MAP cannot get access token for ensuring the account state"));
            return;
        }
        obj1 = (new PandaUserProfileRequest(((Bundle) (obj2)).getString("value_key"), ((String) (obj1)), val$tracer)).getAccountMissingProfileAttributes(((java.util.List) (obj)));
        if (obj1 == null)
        {
            MAPLog.e(AccountManagerLogic.access$700(), "Cannot fetch user profile from Panda");
            val$callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.trationError.INTERNAL_ERROR.value(), "MAP cannot get user profile from Panda"));
            return;
        }
        if (((ArrayList) (obj1)).isEmpty())
        {
            AccountManagerLogic.access$1500$3a298657(val$callback, ((ArrayList) (obj)));
            return;
        } else
        {
            val$options.putStringArrayList("AccountMissingAttributes", ((ArrayList) (obj1)));
            val$options.putBoolean("set_cookie_for_authenticate_account_with_ui", true);
            val$options.putString("com.amazon.dcp.sso.property.account.acctId", val$directedId);
            val$options.putBoolean("isAccountStateFixUpFlow", true);
            authenticateAccountWithUI(val$activity, SigninOption.WebviewSignin, val$options, val$callback, val$tracer);
            return;
        }
    }

    s()
    {
        this$0 = final_accountmanagerlogic;
        val$options = bundle;
        val$directedId = s;
        val$callback = callback1;
        val$tracer = tracer1;
        val$activity = Activity.this;
        super();
    }
}
