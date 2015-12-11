// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.app.Activity;
import android.text.TextUtils;

// Referenced classes of package com.amazon.now.web:
//            WebActivity, NowWebFragment, NowWebView

class val.returnUrl
    implements com.amazon.now.account.back
{

    final WebActivity this$0;
    final String val$returnUrl;

    public void failure()
    {
        runOnUiThread(new Runnable() {

            final WebActivity._cls2 this$1;

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

            
            {
                this$1 = WebActivity._cls2.this;
                super();
            }
        });
    }

    public void success(final Activity activity)
    {
        if (!TextUtils.isEmpty(val$returnUrl) && (activity instanceof WebActivity))
        {
            runOnUiThread(new Runnable() {

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
            });
        }
    }

    _cls2.this._cls1()
    {
        this$0 = final_webactivity;
        val$returnUrl = String.this;
        super();
    }
}
