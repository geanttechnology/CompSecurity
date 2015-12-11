// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            as

private class <init> extends WebChromeClient
{

    final as a;

    public void onGeolocationPermissionsShowPrompt(String s, android.webkit.cationPermissions.Callback callback)
    {
        callback.invoke(s, true, false);
    }

    public void onHideCustomView()
    {
        as.e(a);
    }

    public void onProgressChanged(WebView webview, int i)
    {
        super.onProgressChanged(webview, i);
        if (i == 100 && a.b != null)
        {
            a.b.a();
        }
    }

    public void onShowCustomView(View view, android.webkit.romeClient.CustomViewCallback customviewcallback)
    {
        if (as.a(a) != null)
        {
            customviewcallback.onCustomViewHidden();
            return;
        }
        android.widget.VideoView videoview = as.a(a, view);
        if (videoview != null)
        {
            as.a(a, videoview);
        }
        as.b(a).setVisibility(8);
        as.c(a).addView(view, new android.widget.Layout.LayoutParams(-1, -1));
        as.b(a, view);
        as.a(a, customviewcallback);
        as.c(a).setVisibility(0);
        as.d(a);
    }

    private Callback(as as1)
    {
        a = as1;
        super();
    }

    a(as as1, a a1)
    {
        this(as1);
    }
}
