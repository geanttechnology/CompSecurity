// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.account;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.now.platform.AndroidPlatform;

// Referenced classes of package com.amazon.now.account:
//            MAPCookiesFetcher

class val.result
    implements Runnable
{

    final val.result this$1;
    final Bundle val$result;

    public void run()
    {
        callback.onError(val$result);
    }

    l.callback()
    {
        this$1 = final_callback;
        val$result = Bundle.this;
        super();
    }

    // Unreferenced inner class com/amazon/now/account/MAPCookiesFetcher$1

/* anonymous class */
    class MAPCookiesFetcher._cls1
        implements Callback
    {

        final MAPCookiesFetcher this$0;
        final Callback val$callback;
        final String val$cookieUrl;

        public void onError(Bundle bundle)
        {
            if (bundle != null)
            {
                int i = bundle.getInt("com.amazon.dcp.sso.ErrorCode", -1);
                String s1 = bundle.getString("com.amazon.dcp.sso.ErrorMessage");
                StringBuilder stringbuilder = (new StringBuilder()).append("Cookie Fetch Fail. Code: ").append(i).append("; errorMsg: ");
                String s = s1;
                if (TextUtils.isEmpty(s1))
                {
                    s = "";
                }
                s = stringbuilder.append(s).toString();
                Log.e(MAPCookiesFetcher.access$000(), s);
            }
            if (callback != null)
            {
                AndroidPlatform.getInstance().runOnUiThread(bundle. new MAPCookiesFetcher._cls1._cls2());
            }
        }

        public void onSuccess(final Bundle result)
        {
            String as[] = result.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
            CookieManager cookiemanager = CookieManager.getInstance();
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                if (!TextUtils.isEmpty(s))
                {
                    cookiemanager.setCookie(cookieUrl, s);
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
                AndroidPlatform.getInstance().runOnUiThread(new MAPCookiesFetcher._cls1._cls1());
            }
        }

            
            {
                this$0 = final_mapcookiesfetcher;
                cookieUrl = s;
                callback = Callback.this;
                super();
            }

        // Unreferenced inner class com/amazon/now/account/MAPCookiesFetcher$1$1

/* anonymous class */
        class MAPCookiesFetcher._cls1._cls1
            implements Runnable
        {

            final MAPCookiesFetcher._cls1 this$1;
            final Bundle val$result;

            public void run()
            {
                callback.onSuccess(result);
            }

                    
                    {
                        this$1 = MAPCookiesFetcher._cls1.this;
                        result = bundle;
                        super();
                    }
        }

    }

}
