// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.offerup.android.activities:
//            OfferUpWebViewActivity

final class eo extends WebChromeClient
{

    private OfferUpWebViewActivity a;

    eo(OfferUpWebViewActivity offerupwebviewactivity)
    {
        a = offerupwebviewactivity;
        super();
    }

    public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            OfferUpWebViewActivity.a(a, s1, jsresult);
            return true;
        } else
        {
            return super.onJsAlert(webview, s, s1, jsresult);
        }
    }

    public final boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            OfferUpWebViewActivity.a(a, s1, jsresult);
            return true;
        } else
        {
            return super.onJsConfirm(webview, s, s1, jsresult);
        }
    }
}
