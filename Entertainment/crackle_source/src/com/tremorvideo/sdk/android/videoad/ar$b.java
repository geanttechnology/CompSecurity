// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ar

private class <init> extends WebChromeClient
{

    final ar a;

    public void onGeolocationPermissionsShowPrompt(String s, android.webkit.cationPermissions.Callback callback)
    {
        callback.invoke(s, true, false);
    }

    public void onProgressChanged(WebView webview, int i)
    {
        super.onProgressChanged(webview, i);
        if (i == 100 && a.b != null)
        {
            a.b.a();
        }
    }

    private lback(ar ar1)
    {
        a = ar1;
        super();
    }

    a(ar ar1, a a1)
    {
        this(ar1);
    }
}
