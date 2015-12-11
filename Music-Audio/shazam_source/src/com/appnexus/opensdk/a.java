// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.net.Uri;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnexus.opensdk.b.b;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

final class a
{

    static void a(WebView webview, String s, List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringBuilder stringbuilder1 = stringbuilder.append("cb=");
        if (s == null)
        {
            s = "-1";
        }
        stringbuilder1.append(s);
        s = list.iterator();
        do
        {
            if (!s.hasNext())
            {
                break;
            }
            list = (BasicNameValuePair)s.next();
            if (list.getName() != null && list.getValue() != null)
            {
                stringbuilder.append("&").append(list.getName()).append("=").append(Uri.encode(list.getValue()));
            }
        } while (true);
        webview.loadUrl(String.format("javascript:window.sdkjs.client.result(\"%s\")", new Object[] {
            stringbuilder.toString()
        }));
    }

    // Unreferenced inner class com/appnexus/opensdk/a$1

/* anonymous class */
    static final class _cls1 extends WebViewClient
    {

        public final void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            b.b(b.b, (new StringBuilder("RecordEvent completed loading: ")).append(s).toString());
            webview = CookieSyncManager.getInstance();
            if (webview != null)
            {
                webview.sync();
            }
        }

    }

}
