// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SettingsFragment

class this._cls1 extends WebViewClient
{

    final Activity this$1;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s.contains("fb://") || s.contains("://play.google.com/store/apps/details?id="))
        {
            webview = new Intent("android.intent.action.VIEW");
            webview.setData(Uri.parse(s));
            startActivity(webview);
            return true;
        }
        if (s.startsWith("mailto:"))
        {
            webview = MailTo.parse(s);
            s = new Intent("android.intent.action.SEND");
            s.putExtra("android.intent.extra.EMAIL", new String[] {
                webview.getTo()
            });
            s.setType("message/rfc822");
            startActivity(s);
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
