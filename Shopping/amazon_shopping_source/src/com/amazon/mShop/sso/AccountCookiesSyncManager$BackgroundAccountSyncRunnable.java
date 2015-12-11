// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.util.Log;

// Referenced classes of package com.amazon.mShop.sso:
//            AccountCookiesSyncManager, SSOUtil

private static class mXCookieOnly
    implements Runnable
{

    final String mAccount;
    final Context mApplicationContext;
    final boolean mCheckLoginAfterCookieRetrieved;
    final boolean mForceSync;
    final boolean mXCookieOnly;

    public void run()
    {
        if (AccountCookiesSyncManager.access$000())
        {
            if (SSOUtil.DEBUG)
            {
                Log.v("Amazon.SSOUtil", "Amazon Account synchronization already in progress");
            }
            return;
        } else
        {
            AccountCookiesSyncManager.access$100(mApplicationContext, mForceSync, mCheckLoginAfterCookieRetrieved, mAccount, mXCookieOnly);
            return;
        }
    }

    (Context context, boolean flag, boolean flag1, String s, boolean flag2)
    {
        mApplicationContext = context;
        mForceSync = flag;
        mCheckLoginAfterCookieRetrieved = flag1;
        mAccount = s;
        mXCookieOnly = flag2;
    }
}
