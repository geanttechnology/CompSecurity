// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            an, ai, ad, aw

public class by
{
    class a extends WebViewClient
    {

        final c a;
        final an b;
        final Dialog c;
        final Activity d;
        final e e;
        final String f;
        final int g;
        final String h;
        final aw i;

        public void onPageFinished(WebView webview, String s)
        {
            if (!a.a && s.compareTo("https://api.twitter.com/oauth/authorize") != 0)
            {
                if (b.isShowing())
                {
                    b.dismiss();
                }
                if (!c.isShowing())
                {
                    c.setContentView(a, new android.view.ViewGroup.LayoutParams(-2, -2));
                    c.show();
                    return;
                }
            }
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            super.onPageStarted(webview, s, bitmap);
        }

        public void onReceivedError(WebView webview, int j, String s, String s1)
        {
            if (a.a)
            {
                return;
            } else
            {
                d.runOnUiThread(new Runnable(this) {

                    final a a;

                    public void run()
                    {
                        a.b.dismiss();
                        a.c.dismiss();
                        a.e.a(0, "");
                    }

            
            {
                a = a1;
                super();
            }
                });
                return;
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            while (a.a || a.b) 
            {
                return true;
            }
            if (s.startsWith("oauth"))
            {
                a.b = true;
                webview = Uri.parse(s);
                if (webview.getQueryParameter("denied") != null)
                {
                    e.a(-1, "");
                    d.runOnUiThread(new Runnable(this) {

                        final a a;

                        public void run()
                        {
                            a.c.dismiss();
                            a.b.dismiss();
                        }

            
            {
                a = a1;
                super();
            }
                    });
                    return true;
                } else
                {
                    d.runOnUiThread(new Runnable(this) {

                        final a a;

                        public void run()
                        {
                            a.c.dismiss();
                            a.b.show();
                        }

            
            {
                a = a1;
                super();
            }
                    });
                    (new a(this, webview)).execute(new Void[0]);
                    return true;
                }
            } else
            {
                return super.shouldOverrideUrlLoading(webview, s);
            }
        }

        public a(c c1, an an1, Dialog dialog, Activity activity, e e1, String s, int j, 
                String s1, aw aw)
        {
            a = c1;
            b = an1;
            c = dialog;
            d = activity;
            e = e1;
            f = s;
            g = j;
            h = s1;
            i = aw;
            super();
        }
    }

    class a.a extends AsyncTask
    {

        String a;
        final Uri b;
        final a c;

        protected transient Boolean a(Void avoid[])
        {
            Object obj;
            String s;
            avoid = b.getQueryParameter("oauth_verifier");
            obj = new com.tremorvideo.sdk.android.c.a("zSB18SDCMETDn2BH50xg", "Khb9CLQxkT62an9PUUpvBtRyh1Jluvwi7FGAiJkuJY&", c.f, "POST", "https://api.twitter.com/oauth/access_token");
            ((com.tremorvideo.sdk.android.c.a) (obj)).a("oauth_verifier", avoid);
            ((com.tremorvideo.sdk.android.c.a) (obj)).a();
            avoid = ((com.tremorvideo.sdk.android.c.a) (obj)).b();
            obj = (String)avoid.get("oauth_token");
            avoid = (String)avoid.get("oauth_token_secret");
            s = (new StringBuilder()).append("Khb9CLQxkT62an9PUUpvBtRyh1Jluvwi7FGAiJkuJY&").append(avoid).toString();
            if (c.g != 0) goto _L2; else goto _L1
_L1:
            avoid = "https://api.twitter.com/1.1/statuses/update.json";
_L4:
            avoid = new com.tremorvideo.sdk.android.c.a("zSB18SDCMETDn2BH50xg", s, ((String) (obj)), "POST", avoid);
            if (c.g == 0)
            {
                avoid.a("status", c.i.a("message", "Tweet"));
            }
            boolean flag = avoid.a();
            ad.d(avoid.c());
            return Boolean.valueOf(flag);
_L2:
            avoid = (new StringBuilder()).append("https://api.twitter.com/1.1/statuses/retweet/").append(c.h).append(".json").toString();
            if (true) goto _L4; else goto _L3
_L3:
            avoid;
            ad.a(avoid);
            return Boolean.valueOf(false);
        }

        protected void a(Boolean boolean1)
        {
            c.b.dismiss();
            if (boolean1.booleanValue())
            {
                c.e.a(1, "");
                return;
            } else
            {
                c.e.a(0, a);
                return;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((Boolean)obj);
        }

        a.a(a a1, Uri uri)
        {
            c = a1;
            b = uri;
            super();
            a = "";
        }
    }

    class b extends a
    {

        final aw j;
        final String k;
        final int l;
        final String m;
        final e n;
        final Activity o;
        final Dialog p;
        final an q;
        final c r;

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            ad.d("SSL Error");
            sslerrorhandler.proceed();
            super.onReceivedSslError(webview, sslerrorhandler, sslerror);
        }

        b(aw aw, String s, int i, String s1, e e1, Activity activity, Dialog dialog, 
                an an1, c c1)
        {
            j = aw;
            k = s;
            l = i;
            m = s1;
            n = e1;
            o = activity;
            p = dialog;
            q = an1;
            r = c1;
            super(c1, an1, dialog, activity, e1, s1, i, s, aw);
        }
    }

    class c extends WebView
    {

        public boolean a;
        public boolean b;

        c(Activity activity)
        {
            super(activity);
            a = false;
            b = false;
            getSettings().setJavaScriptEnabled(true);
            getSettings().setSaveFormData(false);
            getSettings().setSavePassword(false);
        }
    }

    class d extends AsyncTask
    {

        String a;
        String b;
        final Activity c;
        final aw d;
        final an e;
        final e f;
        final int g;
        final String h;

        protected transient Boolean a(Void avoid[])
        {
            boolean flag;
            try
            {
                avoid = new com.tremorvideo.sdk.android.c.a("zSB18SDCMETDn2BH50xg", "Khb9CLQxkT62an9PUUpvBtRyh1Jluvwi7FGAiJkuJY&", "POST", "https://api.twitter.com/oauth/request_token");
                avoid.a("oauth_callback", "oauth://twitter.com");
                flag = avoid.a();
                a = (String)avoid.b().get("oauth_token");
                b = (new StringBuilder()).append("https://api.twitter.com/oauth/authorize?oauth_token=").append(a).toString();
                if (a == null || b == null)
                {
                    return Boolean.valueOf(false);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                ad.a(avoid);
                return Boolean.valueOf(false);
            }
            return Boolean.valueOf(flag);
        }

        protected void a(Boolean boolean1)
        {
            if (boolean1.booleanValue())
            {
                by.a(c, d, b, e, a, f, g, h);
                return;
            } else
            {
                e.dismiss();
                f.a(0, "");
                return;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((Boolean)obj);
        }

        d(Activity activity, aw aw, an an1, e e1, int i, String s)
        {
            c = activity;
            d = aw;
            e = an1;
            f = e1;
            g = i;
            h = s;
            super();
        }
    }

    public static interface e
    {

        public abstract void a(int i, String s);
    }


    public static void a(Activity activity, aw aw, e e1)
    {
        a(activity, aw, e1, 0, "");
    }

    public static void a(Activity activity, aw aw, e e1, int i, String s)
    {
        an an1 = an.a(activity);
        an1.setMessage("Loading...");
        an1.setCancelable(false);
        an1.show();
        (new d(activity, aw, an1, e1, i, s)).execute(new Void[0]);
    }

    static void a(Activity activity, aw aw, String s, an an1, String s1, e e1, int i, String s2)
    {
        b(activity, aw, s, an1, s1, e1, i, s2);
    }

    private static void b(Activity activity, aw aw, String s, an an1, String s1, e e1, int i, String s2)
    {
        c c1 = new c(activity);
        ai ai1 = ai.a(activity);
        ai1.requestWindowFeature(1);
        ai1.getWindow().setFlags(1024, 1024);
        ai1.setOnCancelListener(new android.content.DialogInterface.OnCancelListener(c1, e1) {

            final c a;
            final e b;

            public void onCancel(DialogInterface dialoginterface)
            {
                a.a = true;
                b.a(-1, "");
            }

            
            {
                a = c1;
                b = e1;
                super();
            }
        });
        if (ad.q() < 7)
        {
            c1.setWebViewClient(new a(c1, an1, ai1, activity, e1, s1, i, s2, aw));
        } else
        {
            c1.setWebViewClient(new b(aw, s2, i, s1, e1, activity, ai1, an1, c1));
        }
        an1.dismiss();
        ai1.setContentView(c1, new android.view.ViewGroup.LayoutParams(-2, -2));
        ai1.show();
        an1.show();
        c1.loadUrl(s);
    }
}
