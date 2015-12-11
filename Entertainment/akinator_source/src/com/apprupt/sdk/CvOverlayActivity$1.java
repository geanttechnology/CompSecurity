// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

// Referenced classes of package com.apprupt.sdk:
//            CvOverlayActivity, CvViewHelper, Logger, CvAdType, 
//            CvLauncher

class val.layout extends WebViewClient
{

    final CvOverlayActivity this$0;
    final RelativeLayout val$layout;
    final LinearLayout val$loader;

    public void onPageFinished(WebView webview, String s)
    {
    /* block-local class not found */
    class _cls1 {}

        CvViewHelper.runOnUIThread(new _cls1());
        Logger.get("OVERLAY_PAGE")._mth1(new Object[] {
            "Page", s, "loaded successfully"
        });
        CvOverlayActivity.access$002(CvOverlayActivity.this, true);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Logger.get("OVERLAY_PAGE")._mth0(new Object[] {
            (new StringBuilder()).append("Hiding overlay after error").append(i).append(":").toString(), s, " (URL:", (new StringBuilder()).append(s1).append(")").toString()
        });
        finish();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (mLauncher.shouldRunURL(s, CvAdType.IN_PLACE))
        {
            webview.loadUrl(s);
        }
        return true;
    }

    _cls1()
    {
        this$0 = final_cvoverlayactivity;
        val$loader = linearlayout;
        val$layout = RelativeLayout.this;
        super();
    }
}
