// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.now.account.SSO;

// Referenced classes of package com.amazon.now.web:
//            WebActivity, NowWebFragment

class val.url
    implements Callback
{

    final WebActivity this$0;
    final String val$url;

    public void onError(Bundle bundle)
    {
        runOnUiThread(new Runnable() {

            final WebActivity._cls1 this$1;

            public void run()
            {
                finish();
            }

            
            {
                this$1 = WebActivity._cls1.this;
                super();
            }
        });
    }

    public void onSuccess(Bundle bundle)
    {
        runOnUiThread(new Runnable() {

            final WebActivity._cls1 this$1;

            public void run()
            {
                SSO.updateLastAuthenticationTime();
                if (!TextUtils.isEmpty(url))
                {
                    mWebFragment.loadUrl(url);
                }
            }

            
            {
                this$1 = WebActivity._cls1.this;
                super();
            }
        });
    }

    _cls2.this._cls1()
    {
        this$0 = final_webactivity;
        val$url = String.this;
        super();
    }
}
