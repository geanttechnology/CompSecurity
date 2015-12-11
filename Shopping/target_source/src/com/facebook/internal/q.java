// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.e;
import com.facebook.f;
import com.facebook.g;
import com.facebook.h;
import com.facebook.i;
import com.facebook.k;
import java.util.Locale;

// Referenced classes of package com.facebook.internal:
//            n, o, p

public class q extends Dialog
{
    public static class a
    {

        private Context a;
        private String b;
        private String c;
        private int d;
        private c e;
        private Bundle f;
        private AccessToken g;

        private void a(Context context, String s, Bundle bundle)
        {
            a = context;
            c = s;
            if (bundle != null)
            {
                f = bundle;
                return;
            } else
            {
                f = new Bundle();
                return;
            }
        }

        public a a(int k)
        {
            d = k;
            return this;
        }

        public a a(c c1)
        {
            e = c1;
            return this;
        }

        public q a()
        {
            if (g != null)
            {
                f.putString("app_id", g.h());
                f.putString("access_token", g.b());
            } else
            {
                f.putString("app_id", b);
            }
            return new q(a, c, f, d, e);
        }

        public String b()
        {
            return b;
        }

        public Context c()
        {
            return a;
        }

        public int d()
        {
            return d;
        }

        public Bundle e()
        {
            return f;
        }

        public c f()
        {
            return e;
        }

        public a(Context context, String s, Bundle bundle)
        {
label0:
            {
                super();
                d = 0x1030010;
                g = AccessToken.a();
                if (g == null)
                {
                    String s1 = o.a(context);
                    if (s1 == null)
                    {
                        break label0;
                    }
                    b = s1;
                }
                a(context, s, bundle);
                return;
            }
            throw new f("Attempted to create a builder without a valid access token or a valid default Application ID.");
        }

        public a(Context context, String s, String s1, Bundle bundle)
        {
            d = 0x1030010;
            String s2 = s;
            if (s == null)
            {
                s2 = o.a(context);
            }
            p.a(s2, "applicationId");
            b = s2;
            a(context, s1, bundle);
        }
    }

    private class b extends WebViewClient
    {

        final q a;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            if (!q.b(a))
            {
                q.c(a).dismiss();
            }
            q.d(a).setBackgroundColor(0);
            com.facebook.internal.q.e(a).setVisibility(0);
            com.facebook.internal.q.f(a).setVisibility(0);
            q.a(a, true);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            o.a("FacebookSDK.WebDialog", (new StringBuilder()).append("Webview loading URL: ").append(s).toString());
            super.onPageStarted(webview, s, bitmap);
            if (!q.b(a))
            {
                q.c(a).show();
            }
        }

        public void onReceivedError(WebView webview, int l, String s, String s1)
        {
            super.onReceivedError(webview, l, s, s1);
            a.a(new e(s, l, s1));
        }

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            super.onReceivedSslError(webview, sslerrorhandler, sslerror);
            sslerrorhandler.cancel();
            a.a(new e(null, -11, null));
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            boolean flag;
            flag = false;
            o.a("FacebookSDK.WebDialog", (new StringBuilder()).append("Redirect URL: ").append(s).toString());
            if (!s.startsWith(q.a(a))) goto _L2; else goto _L1
_L1:
            Bundle bundle = a.a(s);
            webview = bundle.getString("error");
            s = webview;
            if (webview == null)
            {
                s = bundle.getString("error_type");
            }
            Object obj = bundle.getString("error_msg");
            webview = ((WebView) (obj));
            if (obj == null)
            {
                webview = bundle.getString("error_message");
            }
            obj = webview;
            if (webview == null)
            {
                obj = bundle.getString("error_description");
            }
            webview = bundle.getString("error_code");
            int l;
            if (!o.a(webview))
            {
                try
                {
                    l = Integer.parseInt(webview);
                }
                // Misplaced declaration of an exception variable
                catch (WebView webview)
                {
                    l = -1;
                }
            } else
            {
                l = -1;
            }
            if (o.a(s) && o.a(((String) (obj))) && l == -1)
            {
                a.a(bundle);
            } else
            if (s != null && (s.equals("access_denied") || s.equals("OAuthAccessDeniedException")))
            {
                a.cancel();
            } else
            if (l == 4201)
            {
                a.cancel();
            } else
            {
                webview = new h(l, s, ((String) (obj)));
                a.a(new k(webview, ((String) (obj))));
            }
            flag = true;
_L4:
            return flag;
_L2:
            if (s.startsWith("fbconnect://cancel"))
            {
                a.cancel();
                return true;
            }
            if (s.contains("touch")) goto _L4; else goto _L3
_L3:
            a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
            return true;
            webview;
            return false;
            if (true) goto _L6; else goto _L5
_L6:
            break MISSING_BLOCK_LABEL_159;
_L5:
        }

        private b()
        {
            a = q.this;
            super();
        }

    }

    public static interface c
    {

        public abstract void a(Bundle bundle, f f1);
    }


    private String a;
    private String b;
    private c c;
    private WebView d;
    private ProgressDialog e;
    private ImageView f;
    private FrameLayout g;
    private boolean h;
    private boolean i;
    private boolean j;

    public q(Context context, String s)
    {
        this(context, s, 0x1030010);
    }

    public q(Context context, String s, int k)
    {
        int l = k;
        if (k == 0)
        {
            l = 0x1030010;
        }
        super(context, l);
        b = "fbconnect://success";
        h = false;
        i = false;
        j = false;
        a = s;
    }

    public q(Context context, String s, Bundle bundle, int k, c c1)
    {
        int l = k;
        if (k == 0)
        {
            l = 0x1030010;
        }
        super(context, l);
        b = "fbconnect://success";
        h = false;
        i = false;
        j = false;
        context = bundle;
        if (bundle == null)
        {
            context = new Bundle();
        }
        context.putString("redirect_uri", "fbconnect://success");
        context.putString("display", "touch");
        context.putString("sdk", String.format(Locale.ROOT, "android-%s", new Object[] {
            com.facebook.i.g()
        }));
        a = o.a(n.a(), (new StringBuilder()).append(n.d()).append("/").append("dialog/").append(s).toString(), context).toString();
        c = c1;
    }

    private int a(int k, float f1, int l, int i1)
    {
        double d1;
        int j1;
        d1 = 0.5D;
        j1 = (int)((float)k / f1);
        if (j1 > l) goto _L2; else goto _L1
_L1:
        d1 = 1.0D;
_L4:
        return (int)(d1 * (double)k);
_L2:
        if (j1 < i1)
        {
            d1 = 0.5D + ((double)(i1 - j1) / (double)(i1 - l)) * 0.5D;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static String a(q q1)
    {
        return q1.b;
    }

    private void a(int k)
    {
        LinearLayout linearlayout = new LinearLayout(getContext());
        d = new WebView(getContext().getApplicationContext()) {

            final q a;

            public void onWindowFocusChanged(boolean flag)
            {
                try
                {
                    super.onWindowFocusChanged(flag);
                    return;
                }
                catch (NullPointerException nullpointerexception)
                {
                    return;
                }
            }

            
            {
                a = q.this;
                super(context);
            }
        };
        d.setVerticalScrollBarEnabled(false);
        d.setHorizontalScrollBarEnabled(false);
        d.setWebViewClient(new b());
        d.getSettings().setJavaScriptEnabled(true);
        d.loadUrl(a);
        d.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        d.setVisibility(4);
        d.getSettings().setSavePassword(false);
        d.getSettings().setSaveFormData(false);
        d.setFocusable(true);
        d.setFocusableInTouchMode(true);
        d.setOnTouchListener(new android.view.View.OnTouchListener() {

            final q a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (!view.hasFocus())
                {
                    view.requestFocus();
                }
                return false;
            }

            
            {
                a = q.this;
                super();
            }
        });
        linearlayout.setPadding(k, k, k, k);
        linearlayout.addView(d);
        linearlayout.setBackgroundColor(0xcc000000);
        g.addView(linearlayout);
    }

    static boolean a(q q1, boolean flag)
    {
        q1.j = flag;
        return flag;
    }

    static boolean b(q q1)
    {
        return q1.i;
    }

    static ProgressDialog c(q q1)
    {
        return q1.e;
    }

    static FrameLayout d(q q1)
    {
        return q1.g;
    }

    static WebView e(q q1)
    {
        return q1.d;
    }

    private void e()
    {
        f = new ImageView(getContext());
        f.setOnClickListener(new android.view.View.OnClickListener() {

            final q a;

            public void onClick(View view)
            {
                a.cancel();
            }

            
            {
                a = q.this;
                super();
            }
        });
        Drawable drawable = getContext().getResources().getDrawable(com.facebook.v.a.com_facebook_close);
        f.setImageDrawable(drawable);
        f.setVisibility(4);
    }

    static ImageView f(q q1)
    {
        return q1.f;
    }

    protected Bundle a(String s)
    {
        s = Uri.parse(s);
        Bundle bundle = o.b(s.getQuery());
        bundle.putAll(o.b(s.getFragment()));
        return bundle;
    }

    protected void a(Bundle bundle)
    {
        if (c != null && !h)
        {
            h = true;
            c.a(bundle, null);
            dismiss();
        }
    }

    public void a(c c1)
    {
        c = c1;
    }

    protected void a(Throwable throwable)
    {
        if (c != null && !h)
        {
            h = true;
            if (throwable instanceof f)
            {
                throwable = (f)throwable;
            } else
            {
                throwable = new f(throwable);
            }
            c.a(null, throwable);
            dismiss();
        }
    }

    protected boolean a()
    {
        return h;
    }

    protected void b(String s)
    {
        b = s;
    }

    protected boolean b()
    {
        return j;
    }

    protected WebView c()
    {
        return d;
    }

    public void cancel()
    {
        if (c != null && !h)
        {
            a(new g());
        }
    }

    public void d()
    {
        Display display = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        int k;
        int l;
        if (displaymetrics.widthPixels < displaymetrics.heightPixels)
        {
            k = displaymetrics.widthPixels;
        } else
        {
            k = displaymetrics.heightPixels;
        }
        if (displaymetrics.widthPixels < displaymetrics.heightPixels)
        {
            l = displaymetrics.heightPixels;
        } else
        {
            l = displaymetrics.widthPixels;
        }
        k = Math.min(a(k, displaymetrics.density, 480, 800), displaymetrics.widthPixels);
        l = Math.min(a(l, displaymetrics.density, 800, 1280), displaymetrics.heightPixels);
        getWindow().setLayout(k, l);
    }

    public void dismiss()
    {
        if (d != null)
        {
            d.stopLoading();
        }
        if (!i && e != null && e.isShowing())
        {
            e.dismiss();
        }
        super.dismiss();
    }

    public void onAttachedToWindow()
    {
        i = false;
        super.onAttachedToWindow();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        e = new ProgressDialog(getContext());
        e.requestWindowFeature(1);
        e.setMessage(getContext().getString(com.facebook.v.d.com_facebook_loading));
        e.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final q a;

            public void onCancel(DialogInterface dialoginterface)
            {
                a.cancel();
            }

            
            {
                a = q.this;
                super();
            }
        });
        requestWindowFeature(1);
        g = new FrameLayout(getContext());
        d();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        e();
        a(f.getDrawable().getIntrinsicWidth() / 2 + 1);
        g.addView(f, new android.view.ViewGroup.LayoutParams(-2, -2));
        setContentView(g);
    }

    public void onDetachedFromWindow()
    {
        i = true;
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int k, KeyEvent keyevent)
    {
        if (k == 4)
        {
            cancel();
        }
        return super.onKeyDown(k, keyevent);
    }

    protected void onStart()
    {
        super.onStart();
        d();
    }
}
