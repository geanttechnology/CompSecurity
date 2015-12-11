// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.os.Bundle;
import android.webkit.CookieSyncManager;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.sso:
//            CentralSSOLoginActivity, AccountCookiesSyncManager, MShopCheckLogin

class val.account
    implements Callback
{

    final CentralSSOLoginActivity this$0;
    final String val$account;
    final String val$prevAtMain;

    public void onError(Bundle bundle)
    {
        int i = bundle.getInt("com.amazon.dcp.sso.ErrorCode");
        CentralSSOLoginActivity.access$100(CentralSSOLoginActivity.this, i);
        setResult(0);
        CentralSSOLoginActivity.access$200(CentralSSOLoginActivity.this);
        finish();
    }

    public void onSuccess(Bundle bundle)
    {
        CookieSyncManager.getInstance().sync();
        bundle = CookieBridge.getAtMainCookie(getApplicationContext());
        if (Util.isEmpty(bundle) || bundle.equals(val$prevAtMain))
        {
            AccountCookiesSyncManager.syncAndWait(getApplicationContext(), true, false, val$account);
        }
        (new MShopCheckLogin(getApplicationContext(), false, null, false)).checkLogin();
        setResult(-1);
        CentralSSOLoginActivity.access$000(CentralSSOLoginActivity.this);
        finish();
    }

    ()
    {
        this$0 = final_centralssologinactivity;
        val$prevAtMain = s;
        val$account = String.this;
        super();
    }
}
