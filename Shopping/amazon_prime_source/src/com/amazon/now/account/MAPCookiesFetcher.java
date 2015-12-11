// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.account;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.TokenManagement;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.now.util.AppUtils;

// Referenced classes of package com.amazon.now.account:
//            SSO

public class MAPCookiesFetcher
{

    private static final String TAG = com/amazon/now/account/MAPCookiesFetcher.getSimpleName();
    private final String mAccount;
    private final Context mApplicationContext;

    public MAPCookiesFetcher(Context context, String s)
    {
        mApplicationContext = context;
        mAccount = s;
    }

    private String getMAPDomain(String s)
    {
        if (AppUtils.isDevo())
        {
            return SSO.getMAPDomain(mApplicationContext);
        } else
        {
            return s.substring(1);
        }
    }

    public void getCookies(boolean flag, final Callback callback)
    {
        TokenManagement tokenmanagement = new TokenManagement(mApplicationContext);
        final String cookieUrl = AppUtils.getServiceDomain();
        String s = getMAPDomain(cookieUrl);
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.amazon.identity.auth.device.api.cookiekeys.options.forcerefresh", flag);
        tokenmanagement.getCookies(mAccount, s, bundle, new Callback() {

            final MAPCookiesFetcher this$0;
            final Callback val$callback;
            final String val$cookieUrl;

            public void onError(Bundle bundle1)
            {
                if (bundle1 != null)
                {
                    int i = bundle1.getInt("com.amazon.dcp.sso.ErrorCode", -1);
                    String s2 = bundle1.getString("com.amazon.dcp.sso.ErrorMessage");
                    StringBuilder stringbuilder = (new StringBuilder()).append("Cookie Fetch Fail. Code: ").append(i).append("; errorMsg: ");
                    String s1 = s2;
                    if (TextUtils.isEmpty(s2))
                    {
                        s1 = "";
                    }
                    s1 = stringbuilder.append(s1).toString();
                    Log.e(MAPCookiesFetcher.TAG, s1);
                }
                if (callback != null)
                {
                    AndroidPlatform.getInstance().runOnUiThread(bundle1. new Runnable() {

                        final _cls1 this$1;
                        final Bundle val$result;

                        public void run()
                        {
                            callback.onError(result);
                        }

            
            {
                this$1 = final__pcls1;
                result = Bundle.this;
                super();
            }
                    });
                }
            }

            public void onSuccess(Bundle bundle1)
            {
                String as[] = bundle1.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
                CookieManager cookiemanager = CookieManager.getInstance();
                int j = as.length;
                for (int i = 0; i < j; i++)
                {
                    String s1 = as[i];
                    if (!TextUtils.isEmpty(s1))
                    {
                        cookiemanager.setCookie(cookieUrl, s1);
                    }
                }

                if (android.os.Build.VERSION.SDK_INT < 21)
                {
                    CookieSyncManager.getInstance().sync();
                } else
                {
                    CookieManager.getInstance().flush();
                }
                if (callback != null)
                {
                    AndroidPlatform.getInstance().runOnUiThread(bundle1. new Runnable() {

                        final _cls1 this$1;
                        final Bundle val$result;

                        public void run()
                        {
                            callback.onSuccess(result);
                        }

            
            {
                this$1 = final__pcls1;
                result = Bundle.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = MAPCookiesFetcher.this;
                cookieUrl = s;
                callback = callback1;
                super();
            }
        });
    }


}
