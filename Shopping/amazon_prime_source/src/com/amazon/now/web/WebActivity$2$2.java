// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.app.Activity;
import android.text.TextUtils;

// Referenced classes of package com.amazon.now.web:
//            WebActivity, NowWebFragment, NowWebView

class this._cls1
    implements Runnable
{

    final sh this$1;

    public void run()
    {
        NowWebView nowwebview = mWebFragment.getWebView();
        if (nowwebview != null)
        {
            if (nowwebview.canGoBack())
            {
                nowwebview.goBack();
            } else
            if (TextUtils.isEmpty(nowwebview.getUrl()))
            {
                finish();
                return;
            }
        }
    }

    l.returnUrl()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/now/web/WebActivity$2

/* anonymous class */
    class WebActivity._cls2
        implements com.amazon.now.account.SSO.SignInCallback
    {

        final WebActivity this$0;
        final String val$returnUrl;

        public void failure()
        {
            runOnUiThread(new WebActivity._cls2._cls2());
        }

        public void success(final Activity activity)
        {
            if (!TextUtils.isEmpty(returnUrl) && (activity instanceof WebActivity))
            {
                runOnUiThread(new WebActivity._cls2._cls1());
            }
        }

            
            {
                this$0 = final_webactivity;
                returnUrl = String.this;
                super();
            }

        // Unreferenced inner class com/amazon/now/web/WebActivity$2$1

/* anonymous class */
        class WebActivity._cls2._cls1
            implements Runnable
        {

            final WebActivity._cls2 this$1;
            final Activity val$activity;

            public void run()
            {
                ((WebActivity)activity).loadUrl(returnUrl);
            }

                    
                    {
                        this$1 = WebActivity._cls2.this;
                        activity = activity1;
                        super();
                    }
        }

    }

}
