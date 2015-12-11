// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            m, v, ak, q, 
//            x, w, bl, o

public class AdColonyBrowser extends Activity
{

    static boolean A = true;
    static boolean B = false;
    static boolean C = false;
    static boolean D = false;
    public static String a;
    static boolean b = true;
    static boolean w = false;
    static boolean x = false;
    static boolean y = false;
    static boolean z = false;
    WebView c;
    m d;
    m e;
    m f;
    m g;
    m h;
    m i;
    m j;
    m k;
    m l;
    RelativeLayout m;
    RelativeLayout n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    ProgressBar s;
    DisplayMetrics t;
    v u;
    x v;

    public AdColonyBrowser()
    {
        o = false;
        p = false;
        q = false;
        r = false;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        configuration = new android.widget.RelativeLayout.LayoutParams(-2, t.heightPixels - (int)(1.5D * (double)h.g));
        configuration.addRule(3, m.getId());
        c.setLayoutParams(configuration);
        A = true;
        u.invalidate();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        C = true;
        d = new m(ak.g("browser_back_image_normal"));
        e = new m(ak.g("browser_stop_image_normal"));
        f = new m(ak.g("browser_reload_image_normal"));
        g = new m(ak.g("browser_forward_image_normal"));
        h = new m(ak.g("browser_close_image_normal"));
        i = new m(ak.g("browser_glow_button"));
        j = new m(ak.g("browser_icon"));
        k = new m(ak.g("browser_back_image_normal"), true);
        l = new m(ak.g("browser_forward_image_normal"), true);
        t = com.jirbo.adcolony.q.d().getResources().getDisplayMetrics();
        float f1 = (float)t.widthPixels / t.xdpi;
        float f2 = (float)t.heightPixels / t.ydpi;
        double d1 = Math.sqrt(f1 * f1 + f2 * f2);
        double d2 = Math.sqrt(t.widthPixels * t.widthPixels + t.heightPixels * t.heightPixels) / d1 / 220D;
        d1 = d2;
        if (d2 > 1.8D)
        {
            d1 = 1.8D;
        }
        A = true;
        w = false;
        x = false;
        D = false;
        d.a(d1);
        e.a(d1);
        f.a(d1);
        g.a(d1);
        h.a(d1);
        i.a(d1);
        k.a(d1);
        l.a(d1);
        s = new ProgressBar(this);
        s.setVisibility(4);
        n = new RelativeLayout(this);
        m = new RelativeLayout(this);
        m.setBackgroundColor(0xffcccccc);
        int i1;
        if (!ak.d)
        {
            m.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, (int)((double)d.g * 1.5D)));
        } else
        {
            m.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, (int)((double)d.g * 1.5D)));
        }
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().requestFeature(2);
        setVolumeControlStream(3);
        c = new WebView(this);
        c.getSettings().setJavaScriptEnabled(true);
        c.getSettings().setBuiltInZoomControls(true);
        c.getSettings().setUseWideViewPort(true);
        c.getSettings().setLoadWithOverviewMode(true);
        c.getSettings().setGeolocationEnabled(true);
        if (b)
        {
            if (!ak.d)
            {
                if (android.os.Build.VERSION.SDK_INT >= 10)
                {
                    setRequestedOrientation(6);
                } else
                {
                    setRequestedOrientation(0);
                }
            } else
            {
                setRequestedOrientation(ak.n);
            }
        }
        b = true;
        c.setWebChromeClient(new WebChromeClient() {

            final AdColonyBrowser a;

            public void onGeolocationPermissionsShowPrompt(String s1, android.webkit.GeolocationPermissions.Callback callback)
            {
                callback.invoke(s1, true, false);
            }

            public void onProgressChanged(WebView webview, int j1)
            {
                a.setProgress(j1 * 1000);
            }

            
            {
                a = AdColonyBrowser.this;
                super();
            }
        });
        c.setWebViewClient(new WebViewClient() {

            final AdColonyBrowser a;

            public void onPageFinished(WebView webview, String s1)
            {
                if (!AdColonyBrowser.D)
                {
                    AdColonyBrowser.z = true;
                    AdColonyBrowser.y = false;
                    a.s.setVisibility(4);
                    AdColonyBrowser.w = a.c.canGoBack();
                    AdColonyBrowser.x = a.c.canGoForward();
                }
                a.u.invalidate();
            }

            public void onPageStarted(WebView webview, String s1, Bitmap bitmap)
            {
                if (!AdColonyBrowser.D)
                {
                    AdColonyBrowser.y = true;
                    AdColonyBrowser.z = false;
                    a.s.setVisibility(0);
                }
                a.u.invalidate();
            }

            public void onReceivedError(WebView webview, int j1, String s1, String s2)
            {
                bl.d.a("Error viewing URL: ").b(s1);
                a.finish();
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s1)
            {
                if (s1.startsWith("market://") || s1.startsWith("amzn://"))
                {
                    webview = new Intent("android.intent.action.VIEW", Uri.parse(s1));
                    if (ak.B != null)
                    {
                        ak.B.startActivity(webview);
                    }
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = AdColonyBrowser.this;
                super();
            }
        });
        u = new v(this, this);
        v = new x(this, this);
        n.setBackgroundColor(0xffffff);
        n.addView(m);
        m.setId(12345);
        bundle = new android.widget.RelativeLayout.LayoutParams(-2, t.heightPixels - (int)((double)h.g * 1.5D));
        bundle.addRule(3, m.getId());
        n.addView(c, bundle);
        bundle = new android.widget.RelativeLayout.LayoutParams(-2, 20);
        bundle.addRule(3, m.getId());
        bundle.setMargins(0, -10, 0, 0);
        n.addView(v, bundle);
        if (t.widthPixels > t.heightPixels)
        {
            i1 = t.widthPixels;
        } else
        {
            i1 = t.heightPixels;
        }
        n.addView(u, new android.widget.RelativeLayout.LayoutParams(i1 * 2, i1 * 2));
        bundle = new android.widget.RelativeLayout.LayoutParams(-2, t.heightPixels - (int)((double)h.g * 1.5D));
        bundle.addRule(3, m.getId());
        n.addView(new w(this, this), bundle);
        setContentView(n);
        c.loadUrl(a);
        bl.c.a("Viewing ").b(a);
    }

    public void onDestroy()
    {
        if (!ak.l && B)
        {
            for (int i1 = 0; i1 < ak.U.size(); i1++)
            {
                ((Bitmap)ak.U.get(i1)).recycle();
            }

            ak.U.clear();
        }
        B = false;
        C = false;
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        u.b();
    }

    public void onResume()
    {
        super.onResume();
        A = true;
        u.invalidate();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
    }

}
