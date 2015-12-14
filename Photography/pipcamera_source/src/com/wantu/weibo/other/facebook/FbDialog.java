// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.weibo.other.facebook;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import zd;

public class FbDialog extends Dialog
{

    static final float a[] = {
        20F, 60F
    };
    static final float b[] = {
        40F, 60F
    };
    static final android.widget.FrameLayout.LayoutParams c = new android.widget.FrameLayout.LayoutParams(-1, -1);
    private String d;
    private zd e;
    private ProgressDialog f;
    private ImageView g;
    private WebView h;
    private FrameLayout i;

    public FbDialog(Context context, String s, zd zd)
    {
        super(context, 0x1030010);
        d = s;
        e = zd;
    }

    static zd a(FbDialog fbdialog)
    {
        return fbdialog.e;
    }

    private void a()
    {
        g = new ImageView(getContext());
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final FbDialog a;

            public void onClick(View view)
            {
                FbDialog.a(a).a();
                a.dismiss();
            }

            
            {
                a = FbDialog.this;
                super();
            }
        });
        Drawable drawable = getContext().getResources().getDrawable(0x7f0200f8);
        g.setImageDrawable(drawable);
        g.setVisibility(4);
    }

    private void a(int j)
    {
        LinearLayout linearlayout = new LinearLayout(getContext());
        h = new WebView(getContext());
        h.setVerticalScrollBarEnabled(false);
        h.setHorizontalScrollBarEnabled(false);
        h.setWebViewClient(new FbWebViewClient());
        h.getSettings().setJavaScriptEnabled(true);
        h.loadUrl(d);
        h.setLayoutParams(c);
        h.setVisibility(4);
        h.getSettings().setSavePassword(false);
        linearlayout.setPadding(j, j, j, j);
        linearlayout.addView(h);
        i.addView(linearlayout);
    }

    static ProgressDialog b(FbDialog fbdialog)
    {
        return fbdialog.f;
    }

    static FrameLayout c(FbDialog fbdialog)
    {
        return fbdialog.i;
    }

    static WebView d(FbDialog fbdialog)
    {
        return fbdialog.h;
    }

    static ImageView e(FbDialog fbdialog)
    {
        return fbdialog.g;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        f = new ProgressDialog(getContext());
        f.requestWindowFeature(1);
        f.setMessage("Loading...");
        requestWindowFeature(1);
        i = new FrameLayout(getContext());
        a();
        a(g.getDrawable().getIntrinsicWidth() / 2);
        i.addView(g, new android.view.ViewGroup.LayoutParams(-2, -2));
        addContentView(i, new android.view.ViewGroup.LayoutParams(-1, -1));
    }


    private class FbWebViewClient extends WebViewClient
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

        public void onReceivedError(WebView webview, int j, String s, String s1)
        {
            super.onReceivedError(webview, j, s, s1);
            FbDialog.a(a).a(new DialogError(s, j, s1));
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

        private FbWebViewClient()
        {
            a = FbDialog.this;
            super();
        }

    }

}
