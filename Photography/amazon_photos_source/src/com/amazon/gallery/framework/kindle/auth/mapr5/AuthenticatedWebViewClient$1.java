// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.auth.mapr5;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.thor.GalleryWebViewHelper;
import com.amazon.identity.auth.device.api.Callback;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.framework.kindle.auth.mapr5:
//            AuthenticatedWebViewClient

class val.webView
    implements Callback
{

    final AuthenticatedWebViewClient this$0;
    final String val$domain;
    final WebView val$webView;

    public void onError(Bundle bundle)
    {
        GLogger.e(AuthenticatedWebViewClient.access$200(), "Unable to get authentication cookies.", new Object[0]);
    }

    public void onSuccess(Bundle bundle)
    {
        String as[] = bundle.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
        if (as.length != 0)
        {
            GalleryWebViewHelper.setCookies(AuthenticatedWebViewClient.access$000(AuthenticatedWebViewClient.this), val$domain, as);
        }
        if (StringUtils.isNotEmpty(bundle.getString("com.amazon.identity.auth.device.api.cookiekeys.ResponseUrl")))
        {
            AuthenticatedWebViewClient.access$102(AuthenticatedWebViewClient.this, bundle.getString("com.amazon.identity.auth.device.api.cookiekeys.ResponseUrl"));
        }
        AuthenticatedWebViewClient.access$000(AuthenticatedWebViewClient.this).runOnUiThread(new Runnable() {

            final AuthenticatedWebViewClient._cls1 this$1;

            public void run()
            {
                webView.loadUrl(AuthenticatedWebViewClient.access$100(this$0));
            }

            
            {
                this$1 = AuthenticatedWebViewClient._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_authenticatedwebviewclient;
        val$domain = s;
        val$webView = WebView.this;
        super();
    }
}
