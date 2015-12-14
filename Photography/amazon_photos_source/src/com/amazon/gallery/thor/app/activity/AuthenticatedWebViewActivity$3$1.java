// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.WebView;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.auth.mapr5.AuthenticatedWebViewClient;
import com.amazon.gallery.framework.kindle.ui.VisibilityAnimator;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AuthenticatedWebViewActivity

class this._cls1
    implements Runnable
{

    final sh this$1;

    public void run()
    {
        if (mSpinner.isShowing())
        {
            AuthenticatedWebViewActivity.access$200(_fld0);
            finish();
        }
    }

    ent()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/app/activity/AuthenticatedWebViewActivity$3

/* anonymous class */
    class AuthenticatedWebViewActivity._cls3 extends AuthenticatedWebViewClient
    {

        final AuthenticatedWebViewActivity this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            if (AuthenticatedWebViewActivity.access$000(AuthenticatedWebViewActivity.this) || !AuthenticatedWebViewActivity.access$100(AuthenticatedWebViewActivity.this))
            {
                onPageReady();
                return;
            } else
            {
                AuthenticatedWebViewActivity.access$400(AuthenticatedWebViewActivity.this).postDelayed(new AuthenticatedWebViewActivity._cls3._cls1(), AuthenticatedWebViewActivity.access$300());
                return;
            }
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            super.onPageStarted(webview, s, bitmap);
            if (!mSpinner.isShowing())
            {
                mSpinner.show();
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            mSpinner.dismiss();
            if (AuthenticatedWebViewActivity.access$000(AuthenticatedWebViewActivity.this) || !AuthenticatedWebViewActivity.access$100(AuthenticatedWebViewActivity.this))
            {
                AuthenticatedWebViewActivity.access$500(AuthenticatedWebViewActivity.this).show();
                AuthenticatedWebViewActivity.access$200(AuthenticatedWebViewActivity.this);
            }
            GLogger.i(AuthenticatedWebViewActivity.access$600(), "Failed to load web view: errorCode: %d, description: %s, url: %s", new Object[] {
                Integer.valueOf(i), s, s1
            });
        }

            
            {
                this$0 = AuthenticatedWebViewActivity.this;
                super(activity);
            }
    }

}
