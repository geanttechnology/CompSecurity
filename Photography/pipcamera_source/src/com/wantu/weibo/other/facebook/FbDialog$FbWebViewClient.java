// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.weibo.other.facebook;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import zd;
import ze;

// Referenced classes of package com.wantu.weibo.other.facebook:
//            FbDialog, DialogError, FacebookError

class <init> extends WebViewClient
{

    final FbDialog a;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        FbDialog.b(a).dismiss();
        FbDialog.c(a).setBackgroundColor(0);
        FbDialog.d(a).setVisibility(0);
        FbDialog.e(a).setVisibility(0);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        ze.a("Facebook-WebView", (new StringBuilder()).append("Webview loading URL: ").append(s).toString());
        super.onPageStarted(webview, s, bitmap);
        FbDialog.b(a).show();
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        FbDialog.a(a).a(new DialogError(s, i, s1));
        a.dismiss();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        ze.a("Facebook-WebView", (new StringBuilder()).append("Redirect URL: ").append(s).toString());
        if (s.startsWith("fbconnect://success"))
        {
            Bundle bundle = ze.b(s);
            s = bundle.getString("error");
            webview = s;
            if (s == null)
            {
                webview = bundle.getString("error_type");
            }
            if (webview == null)
            {
                FbDialog.a(a).a(bundle);
            } else
            if (webview.equals("access_denied") || webview.equals("OAuthAccessDeniedException"))
            {
                FbDialog.a(a).a();
            } else
            {
                FbDialog.a(a).a(new FacebookError(webview));
            }
            a.dismiss();
            return true;
        }
        if (s.startsWith("fbconnect://cancel"))
        {
            FbDialog.a(a).a();
            a.dismiss();
            return true;
        }
        if (s.contains("touch"))
        {
            return false;
        } else
        {
            a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
            return true;
        }
    }

    private (FbDialog fbdialog)
    {
        a = fbdialog;
        super();
    }

    a(FbDialog fbdialog, a a1)
    {
        this(fbdialog);
    }
}
