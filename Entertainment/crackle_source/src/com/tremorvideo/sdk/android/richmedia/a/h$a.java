// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tremorvideo.sdk.android.videoad.ad;
import java.net.URI;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            h

private class <init> extends WebViewClient
{

    final h a;

    public void onPageFinished(WebView webview, String s)
    {
        if (s.equals(h.d(a)) && !h.e(a))
        {
            webview = new JSONObject();
            try
            {
                s = a.getLayoutParams();
                if (s instanceof android.widget.tiveLayout.LayoutParams)
                {
                    webview.put("x", ((android.widget.tiveLayout.LayoutParams)s).leftMargin);
                    webview.put("y", ((android.widget.tiveLayout.LayoutParams)s).topMargin);
                    webview.put("width", ((android.view.Group.LayoutParams) (s)).width);
                    webview.put("height", ((android.view.Group.LayoutParams) (s)).height);
                    webview.put("AndroidVersion", ad.q());
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                ad.a(s);
            }
            a.d(webview.toString());
            h.a(a, true);
            a.b();
            (new Thread() {

                final h.a a;

                public void run()
                {
                    a.a.c();
                }

            
            {
                a = h.a.this;
                super();
            }
            }).start();
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s.indexOf("tel:") > -1)
        {
            a.g.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(s)));
            return true;
        }
        if (Uri.parse(s).getScheme().equals("tmwi"))
        {
            h.a(a, URI.create(s));
            return true;
        } else
        {
            return false;
        }
    }

    private _cls1.a(h h1)
    {
        a = h1;
        super();
    }

    a(h h1, a a1)
    {
        this(h1);
    }
}
