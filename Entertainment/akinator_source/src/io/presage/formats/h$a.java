// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package io.presage.formats:
//            h

final class lient extends WebViewClient
{

    final h a;

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        webview = Uri.parse(s).getScheme();
        return webview != null && !webview.equals("http") && !webview.equals("https");
    }

    public lient(h h1)
    {
        a = h1;
        super();
    }
}
