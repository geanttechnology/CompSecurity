// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.endpoint.OpenIdResponse;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device:
//            AuthPortalUIActivity

class 
    implements Callback
{

    final AuthPortalUIActivity this$0;
    final OpenIdResponse val$response;
    final String val$sid;

    public void onError(Bundle bundle)
    {
        AuthPortalUIActivity.access$300(AuthPortalUIActivity.this, bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        String s = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
        if (s != null) goto _L2; else goto _L1
_L1:
        MAPLog.w(AuthPortalUIActivity.access$1800(), "directedId returned from registration was null. Not setting Auth Portal domain.");
_L4:
        bundle.putBoolean("com.amazon.identity.auth.device.accountManager.newaccount", val$response.isNewAccount().booleanValue());
        AuthPortalUIActivity.access$2300(AuthPortalUIActivity.this, bundle);
        return;
_L2:
        MAPLog.i(AuthPortalUIActivity.access$1800(), (new StringBuilder("Account registered with domain: ")).append(AuthPortalUIActivity.access$2100(AuthPortalUIActivity.this)).toString());
        AuthPortalUIActivity.access$2200(AuthPortalUIActivity.this).setUserData(s, "authDomain", AuthPortalUIActivity.access$2100(AuthPortalUIActivity.this));
        if (!TextUtils.isEmpty(val$sid))
        {
            AuthPortalUIActivity.access$2200(AuthPortalUIActivity.this).setToken(s, "com.amazon.dcp.sso.token.cookie.sid", val$sid);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ()
    {
        this$0 = final_authportaluiactivity;
        val$sid = s;
        val$response = OpenIdResponse.this;
        super();
    }
}
