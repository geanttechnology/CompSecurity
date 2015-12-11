// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.webkit.WebView;

// Referenced classes of package com.groupon.view:
//            NonLeakingNonFlickerWebView

protected class this._cls0 extends this._cls0
{

    final NonLeakingNonFlickerWebView this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super._mth0(webview, s);
        NonLeakingNonFlickerWebView.access$002(NonLeakingNonFlickerWebView.this, true);
        NonLeakingNonFlickerWebView.access$201(NonLeakingNonFlickerWebView.this, NonLeakingNonFlickerWebView.access$100(NonLeakingNonFlickerWebView.this));
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        NonLeakingNonFlickerWebView.access$002(NonLeakingNonFlickerWebView.this, false);
        super._mth0(webview, s, bitmap);
    }

    public (Activity activity)
    {
        this$0 = NonLeakingNonFlickerWebView.this;
        super(activity);
    }
}
