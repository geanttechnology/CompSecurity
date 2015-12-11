// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.util.Log;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.sso:
//            AccountCookiesSyncManager, SSOUtil, MShopCheckLogin

static class mAccount
{

    private final String mAccount;
    private final Context mApplicationContext;
    private final boolean mCheckLoginAfterCookieRetrieved;

    public void identityCookiesSuccessfullyFetched()
    {
        if (SSOUtil.DEBUG)
        {
            Log.v("Amazon.SSOUtil", "AccountCookiesSyncManager.UserSubscriberCallback.identityCookiesSuccessfullyFetched()");
        }
        AccountCookiesSyncManager.access$200(mApplicationContext, mAccount);
        if (mCheckLoginAfterCookieRetrieved && !Util.isEmpty(mAccount))
        {
            User.saveUser(new User("", SSOUtil.getFullNameFromCustomerAttribute(mAccount), false, false, null, Boolean.valueOf(false), null));
        }
        AccountCookiesSyncManager.access$300();
        if (Util.isEmpty(mAccount))
        {
            com.amazon.mShop.platform.unt().getDataStore().putBoolean("hasFetchedNonauthCookies", true);
        } else
        if (mCheckLoginAfterCookieRetrieved)
        {
            (new MShopCheckLogin(mApplicationContext, true, null)).checkLogin();
            return;
        }
    }

    public void onFailed(String s)
    {
        if (SSOUtil.DEBUG)
        {
            Log.w("Amazon.SSOUtil", (new StringBuilder()).append("MAPCookieFetcher failed ").append(s).toString());
        }
        AccountCookiesSyncManager.access$300();
    }

    (Context context, String s, boolean flag)
    {
        mApplicationContext = context;
        mCheckLoginAfterCookieRetrieved = flag;
        mAccount = s;
    }
}
