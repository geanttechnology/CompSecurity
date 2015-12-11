// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.callback.RemoteCallbackWrapper;
import com.amazon.identity.auth.device.endpoint.OpenIdResponse;
import com.amazon.identity.auth.device.storage.AccountTransaction;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device:
//            AuthPortalUIActivity

class Wrapper
    implements Callback
{

    final AuthPortalUIActivity this$0;
    final RemoteCallbackWrapper val$callbackWrapper;
    final OpenIdResponse val$response;
    final String val$sid;

    public void onError(Bundle bundle)
    {
        AuthPortalUIActivity.access$2600(AuthPortalUIActivity.this, bundle, val$callbackWrapper);
    }

    public void onSuccess(Bundle bundle)
    {
        Object obj = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
        if (obj == null)
        {
            MAPLog.w(AuthPortalUIActivity.access$2000(), "directedId returned from registration was null. Not setting Auth Portal domain.");
        } else
        {
            MAPLog.i(AuthPortalUIActivity.access$2000(), (new StringBuilder("Account registered with domain: ")).append(AuthPortalUIActivity.access$2300(AuthPortalUIActivity.this)).toString());
            obj = new AccountTransaction(((String) (obj)), null, null);
            ((AccountTransaction) (obj)).setUserData("authDomain", AuthPortalUIActivity.access$2300(AuthPortalUIActivity.this));
            if (!TextUtils.isEmpty(val$sid))
            {
                ((AccountTransaction) (obj)).setToken("com.amazon.dcp.sso.token.cookie.sid", val$sid);
            }
            AuthPortalUIActivity.access$2400(AuthPortalUIActivity.this).setData(((AccountTransaction) (obj)));
        }
        bundle.putBoolean("com.amazon.identity.auth.device.accountManager.newaccount", val$response.isNewAccount().booleanValue());
        bundle.putString("claim_type", val$response.getClaimType());
        AuthPortalUIActivity.access$2500(AuthPortalUIActivity.this, bundle, val$callbackWrapper);
    }

    Wrapper()
    {
        this$0 = final_authportaluiactivity;
        val$sid = s;
        val$response = openidresponse;
        val$callbackWrapper = RemoteCallbackWrapper.this;
        super();
    }
}
