// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.e;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.MailTo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import java.nio.charset.Charset;

// Referenced classes of package com.smule.android.e:
//            a

class b extends WebViewClient
{

    final a a;

    private b(a a1)
    {
        a = a1;
        super();
    }

    b(a a1, a._cls1 _pcls1)
    {
        this(a1);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        if (com.smule.android.e.a.b(a) > 0)
        {
            webview.stopLoading();
            webview.loadData(a.getString(com.smule.android.e.a.b(a)), "text/html", Charset.defaultCharset().toString());
            return;
        } else
        {
            super.onReceivedError(webview, i, s, s1);
            return;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (!s.startsWith("mailto:"))
        {
            break MISSING_BLOCK_LABEL_134;
        }
        webview = MailTo.parse(s);
        s = new Intent("android.intent.action.SEND");
        s.setType("plain/text").putExtra("android.intent.extra.EMAIL", new String[] {
            webview.getTo()
        });
        s.putExtra("android.intent.extra.SUBJECT", webview.getSubject());
        s.putExtra("android.intent.extra.CC", webview.getCc());
        s.putExtra("android.intent.extra.TEXT", com.smule.android.e.a.a(a));
        a.startActivity(s);
_L2:
        return true;
        webview;
        if (a.c == 0) goto _L2; else goto _L1
_L1:
        Toast.makeText(a, a.getResources().getString(a.c), 1).show();
        return true;
        webview.loadUrl(s);
        return true;
    }
}
