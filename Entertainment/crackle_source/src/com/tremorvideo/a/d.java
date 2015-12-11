// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.a;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tremorvideo.sdk.android.d.s;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.an;
import com.tremorvideo.sdk.android.videoad.bv;

// Referenced classes of package com.tremorvideo.a:
//            e, f, a, g, 
//            c

public class d extends Dialog
{
    protected class a extends WebViewClient
    {

        final d a;

        protected void a()
        {
            d.b(a, false);
            if (a.isShowing())
            {
                a.dismiss();
            }
        }

        public void onPageFinished(WebView webview, String s1)
        {
            super.onPageFinished(webview, s1);
            if (d.b(a) && !d.c(a))
            {
                d.b(a, false);
                a.getWindow().setFlags(1024, 1024);
                a.show();
                s1 = d.d(a).getTitle();
                if (s1 != null && s1.length() > 0)
                {
                    d.e(a).setText(s1);
                }
                webview.forceLayout();
            }
            if (d.a(a) != null && d.a(a).isShowing())
            {
                d.a(a).dismiss();
            }
        }

        public void onPageStarted(WebView webview, String s1, Bitmap bitmap)
        {
            Log.d("Facebook-WebView", (new StringBuilder()).append("Webview loading URL: ").append(s1).toString());
            super.onPageStarted(webview, s1, bitmap);
            if (!d.a(a).isShowing())
            {
                d.a(a).show();
            }
        }

        public void onReceivedError(WebView webview, int l, String s1, String s2)
        {
            super.onReceivedError(webview, l, s1, s2);
            a.d.a(new com.tremorvideo.a.a(s1, l, s2));
            a();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s1)
        {
            Log.d("Facebook-WebView", (new StringBuilder()).append("Redirect URL: ").append(s1).toString());
            if (s1.startsWith("fbconnect://success"))
            {
                Bundle bundle = com.tremorvideo.a.g.b(s1);
                s1 = bundle.getString("error");
                webview = s1;
                if (s1 == null)
                {
                    webview = bundle.getString("error_type");
                }
                if (webview == null)
                {
                    a.d.a(bundle);
                } else
                if (webview.equals("access_denied") || webview.equals("OAuthAccessDeniedException"))
                {
                    a.d.a();
                } else
                {
                    a.d.a(new c(webview));
                }
                d.a(a, true);
                a.dismiss();
                return true;
            }
            if (s1.startsWith("fbconnect://cancel"))
            {
                a.d.a();
                a.dismiss();
                return true;
            }
            if (s1.contains("touch"))
            {
                return false;
            } else
            {
                a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s1)));
                return true;
            }
        }

        protected a()
        {
            a = d.this;
            super();
        }
    }


    static final float a[] = {
        20F, 60F
    };
    static final float b[] = {
        40F, 60F
    };
    static final android.view.ViewGroup.LayoutParams c = new android.view.ViewGroup.LayoutParams(-2, -2);
    protected b.a d;
    private String e;
    private ProgressDialog f;
    private WebView g;
    private LinearLayout h;
    private TextView i;
    private boolean j;
    private boolean k;

    protected d(Context context, String s1, b.a a1)
    {
        super(context);
        e = s1;
        d = a1;
        j = true;
        k = false;
        f = an.a(getContext());
        f.setMessage("Loading...");
        f.setCancelable(false);
        setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final d a;

            public void onCancel(DialogInterface dialoginterface)
            {
                a.d.a();
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    static ProgressDialog a(d d1)
    {
        return d1.f;
    }

    public static d a(Context context, String s1, b.a a1)
    {
        int l = ad.q();
        if (l < 5)
        {
            return new d(context, s1, a1);
        }
        if (l < 7)
        {
            return new e(context, s1, a1);
        } else
        {
            return new f(context, s1, a1);
        }
    }

    static boolean a(d d1, boolean flag)
    {
        d1.k = flag;
        return flag;
    }

    static boolean b(d d1)
    {
        return d1.j;
    }

    static boolean b(d d1, boolean flag)
    {
        d1.j = flag;
        return flag;
    }

    private void c()
    {
        requestWindowFeature(1);
        BitmapDrawable bitmapdrawable = new BitmapDrawable(bv.a(s.a));
        i = new TextView(getContext());
        i.setText("Facebook");
        i.setTextColor(-1);
        i.setTypeface(Typeface.DEFAULT_BOLD);
        i.setBackgroundColor(0xff6d84b4);
        i.setPadding(6, 4, 4, 4);
        i.setCompoundDrawablePadding(6);
        i.setCompoundDrawablesWithIntrinsicBounds(bitmapdrawable, null, null, null);
        h.addView(i);
    }

    static boolean c(d d1)
    {
        return d1.k;
    }

    static WebView d(d d1)
    {
        return d1.g;
    }

    private void d()
    {
        h.addView(g);
    }

    static TextView e(d d1)
    {
        return d1.i;
    }

    public void a()
    {
        j = true;
        g = new WebView(getContext());
        g.setVerticalScrollBarEnabled(false);
        g.setHorizontalScrollBarEnabled(false);
        g.setWebViewClient(b());
        g.getSettings().setJavaScriptEnabled(true);
        g.setWebChromeClient(new WebChromeClient());
        g.loadUrl(e);
        g.setLayoutParams(c);
        g.getSettings().setSaveFormData(false);
        g.getSettings().setSavePassword(false);
        getWindow().setFlags(1024, 1024);
        show();
        f.show();
    }

    protected WebViewClient b()
    {
        return new a();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        h = new LinearLayout(getContext());
        h.setOrientation(1);
        c();
        d();
        bundle = new android.widget.LinearLayout.LayoutParams(-2, -2);
        addContentView(h, bundle);
    }

    public boolean onKeyDown(int l, KeyEvent keyevent)
    {
        if (l == 84)
        {
            return true;
        } else
        {
            return super.onKeyDown(l, keyevent);
        }
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }

}
