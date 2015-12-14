// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.e;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WebViewerActivity, y, DeepLinkActivity

class a extends WebViewClient
{

    final WebViewerActivity a;

    public void onPageFinished(WebView webview, String s)
    {
        a.g.setVisibility(8);
        a.f(s);
        if (a.v && a.f != null)
        {
            a.v = false;
            a.f.clearHistory();
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        a.s = s;
        if ((WebViewerActivity.f(a).a == 1 || WebViewerActivity.f(a).a == 2) && a.t != null)
        {
            a.t.a(s);
        }
        WebViewerActivity.a(a, s);
        if (a.g != null)
        {
            a.g.setVisibility(0);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        DeepLinkActivity.f(s);
        if (a.a(webview, s))
        {
            return true;
        }
        String s1;
        Uri uri;
        Uri uri1;
        String s2;
        String s3;
        String s4;
        String s5;
        try
        {
            uri = Uri.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            return true;
        }
        if (s != null && s.startsWith("http://www.perfectcorp.com/ybc/twitter/callback"))
        {
            e.b(new Object[] {
                s
            });
            webview = Uri.parse(s).getQueryParameter("oauth_verifier");
            s = new Intent();
            s.putExtra("OauthVerifier", webview);
            a.setResult(-1, s);
            a.finish();
            return true;
        }
        s2 = uri.getHost();
        s3 = uri.getScheme();
        s4 = a.getResources().getString(m.bc_scheme);
        s5 = a.getResources().getString(m.bc_appscheme);
        uri1 = uri;
        s1 = s;
        if (s3 != null)
        {
            uri1 = uri;
            s1 = s;
            if (!s3.equals(s5))
            {
                uri1 = uri;
                s1 = s;
                if (WebViewerActivity.p.contains(s3))
                {
                    s1 = s.replaceFirst(s3, s5);
                    try
                    {
                        uri1 = Uri.parse(s1);
                    }
                    // Misplaced declaration of an exception variable
                    catch (WebView webview)
                    {
                        return true;
                    }
                }
            }
        }
        if (s2 != null && s3 != null && (s3.equals(s4) || s3.equals(s5)))
        {
            if (s2.equals(a.getResources().getString(m.bc_host_pick_photo)))
            {
                WebViewerActivity.a(a, Boolean.valueOf(true));
                DialogUtils.a(a, null, 48138);
                return true;
            } else
            {
                c.a(a, uri1);
                return true;
            }
        }
        if (WebViewerActivity.q.contains(s3))
        {
            return c.a(a, uri1);
        }
        if (s3.equals("mailto"))
        {
            c.b(a, s1);
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s1);
        }
    }

    (WebViewerActivity webvieweractivity)
    {
        a = webvieweractivity;
        super();
    }
}
