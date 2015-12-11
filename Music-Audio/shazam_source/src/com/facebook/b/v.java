// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

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
import com.facebook.g;
import com.facebook.h;
import com.facebook.i;
import com.facebook.j;
import com.facebook.k;
import com.facebook.m;
import java.util.Locale;

// Referenced classes of package com.facebook.b:
//            s, t, u

public class v extends Dialog
{
    public static class a
    {

        public Context a;
        public String b;
        public int c;
        public c d;
        public Bundle e;
        private String f;
        private AccessToken g;

        private void a(Context context, String s1, Bundle bundle)
        {
            a = context;
            f = s1;
            if (bundle != null)
            {
                e = bundle;
                return;
            } else
            {
                e = new Bundle();
                return;
            }
        }

        public v a()
        {
            if (g != null)
            {
                e.putString("app_id", g.g);
                e.putString("access_token", g.d);
            } else
            {
                e.putString("app_id", b);
            }
            return new v(a, f, e, c, d);
        }

        public a(Context context, String s1, Bundle bundle)
        {
label0:
            {
                super();
                c = 0x1030010;
                g = AccessToken.a();
                if (g == null)
                {
                    String s2 = t.a(context);
                    if (s2 == null)
                    {
                        break label0;
                    }
                    b = s2;
                }
                a(context, s1, bundle);
                return;
            }
            throw new h("Attempted to create a builder without a valid access token or a valid default Application ID.");
        }

        public a(Context context, String s1, String s2, Bundle bundle)
        {
            c = 0x1030010;
            String s3 = s1;
            if (s1 == null)
            {
                s3 = t.a(context);
            }
            u.a(s3, "applicationId");
            b = s3;
            a(context, s2, bundle);
        }
    }

    private final class b extends WebViewClient
    {

        final v a;

        public final void onPageFinished(WebView webview, String s1)
        {
            super.onPageFinished(webview, s1);
            if (!v.b(a))
            {
                v.c(a).dismiss();
            }
            v.d(a).setBackgroundColor(0);
            v.e(a).setVisibility(0);
            v.f(a).setVisibility(0);
            com.facebook.b.v.g(a);
        }

        public final void onPageStarted(WebView webview, String s1, Bitmap bitmap)
        {
            t.a();
            super.onPageStarted(webview, s1, bitmap);
            if (!v.b(a))
            {
                v.c(a).show();
            }
        }

        public final void onReceivedError(WebView webview, int l, String s1, String s2)
        {
            super.onReceivedError(webview, l, s1, s2);
            a.a(new g(s1, l, s2));
        }

        public final void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            super.onReceivedSslError(webview, sslerrorhandler, sslerror);
            sslerrorhandler.cancel();
            a.a(new g(null, -11, null));
        }

        public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
        {
            boolean flag;
            flag = false;
            t.a();
            if (!s1.startsWith(v.a(a))) goto _L2; else goto _L1
_L1:
            Bundle bundle = a.a(s1);
            webview = bundle.getString("error");
            s1 = webview;
            if (webview == null)
            {
                s1 = bundle.getString("error_type");
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
            if (!t.a(webview))
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
            if (t.a(s1) && t.a(((String) (obj))) && l == -1)
            {
                webview = a;
                if (((v) (webview)).b != null && !((v) (webview)).d)
                {
                    webview.d = true;
                    ((v) (webview)).b.a(bundle, null);
                    webview.dismiss();
                }
            } else
            if (s1 != null && (s1.equals("access_denied") || s1.equals("OAuthAccessDeniedException")))
            {
                a.cancel();
            } else
            if (l == 4201)
            {
                a.cancel();
            } else
            {
                webview = new j(l, s1, ((String) (obj)));
                a.a(new m(webview, ((String) (obj))));
            }
            flag = true;
_L4:
            return flag;
_L2:
            if (s1.startsWith("fbconnect://cancel"))
            {
                a.cancel();
                return true;
            }
            if (s1.contains("touch")) goto _L4; else goto _L3
_L3:
            a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s1)));
            return true;
            webview;
            return false;
            if (true) goto _L6; else goto _L5
_L6:
            break MISSING_BLOCK_LABEL_169;
_L5:
        }

        private b()
        {
            a = v.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    public static interface c
    {

        public abstract void a(Bundle bundle, h h1);
    }


    String a;
    c b;
    WebView c;
    boolean d;
    boolean e;
    private String f;
    private ProgressDialog g;
    private ImageView h;
    private FrameLayout i;
    private boolean j;

    public v(Context context, String s1)
    {
        this(context, s1, (byte)0);
    }

    private v(Context context, String s1, byte byte0)
    {
        super(context, 0x1030010);
        a = "fbconnect://success";
        d = false;
        j = false;
        e = false;
        f = s1;
    }

    public v(Context context, String s1, Bundle bundle, int l, c c1)
    {
        int i1 = l;
        if (l == 0)
        {
            i1 = 0x1030010;
        }
        super(context, i1);
        a = "fbconnect://success";
        d = false;
        j = false;
        e = false;
        context = bundle;
        if (bundle == null)
        {
            context = new Bundle();
        }
        context.putString("redirect_uri", "fbconnect://success");
        context.putString("display", "touch");
        context.putString("sdk", String.format(Locale.ROOT, "android-%s", new Object[] {
            k.h()
        }));
        f = t.a(s.a(), (new StringBuilder()).append(s.d()).append("/dialog/").append(s1).toString(), context).toString();
        b = c1;
    }

    private static int a(int l, float f1, int i1, int j1)
    {
        double d1;
        int k1;
        d1 = 0.5D;
        k1 = (int)((float)l / f1);
        if (k1 > i1) goto _L2; else goto _L1
_L1:
        d1 = 1.0D;
_L4:
        return (int)(d1 * (double)l);
_L2:
        if (k1 < j1)
        {
            d1 = 0.5D + ((double)(j1 - k1) / (double)(j1 - i1)) * 0.5D;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static String a(v v1)
    {
        return v1.a;
    }

    static boolean b(v v1)
    {
        return v1.j;
    }

    static ProgressDialog c(v v1)
    {
        return v1.g;
    }

    static FrameLayout d(v v1)
    {
        return v1.i;
    }

    static WebView e(v v1)
    {
        return v1.c;
    }

    static ImageView f(v v1)
    {
        return v1.h;
    }

    static boolean g(v v1)
    {
        v1.e = true;
        return true;
    }

    protected Bundle a(String s1)
    {
        s1 = Uri.parse(s1);
        Bundle bundle = t.b(s1.getQuery());
        bundle.putAll(t.b(s1.getFragment()));
        return bundle;
    }

    public final void a()
    {
        Display display = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        int l;
        int i1;
        if (displaymetrics.widthPixels < displaymetrics.heightPixels)
        {
            l = displaymetrics.widthPixels;
        } else
        {
            l = displaymetrics.heightPixels;
        }
        if (displaymetrics.widthPixels < displaymetrics.heightPixels)
        {
            i1 = displaymetrics.heightPixels;
        } else
        {
            i1 = displaymetrics.widthPixels;
        }
        l = Math.min(a(l, displaymetrics.density, 480, 800), displaymetrics.widthPixels);
        i1 = Math.min(a(i1, displaymetrics.density, 800, 1280), displaymetrics.heightPixels);
        getWindow().setLayout(l, i1);
    }

    protected final void a(Throwable throwable)
    {
        if (b != null && !d)
        {
            d = true;
            throwable = (h)throwable;
            b.a(null, throwable);
            dismiss();
        }
    }

    public void cancel()
    {
        if (b != null && !d)
        {
            a(new i());
        }
    }

    public void dismiss()
    {
        if (c != null)
        {
            c.stopLoading();
        }
        if (!j && g != null && g.isShowing())
        {
            g.dismiss();
        }
        super.dismiss();
    }

    public void onAttachedToWindow()
    {
        j = false;
        super.onAttachedToWindow();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        g = new ProgressDialog(getContext());
        g.requestWindowFeature(1);
        g.setMessage(getContext().getString(com.facebook.x.d.com_facebook_loading));
        g.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final v a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.cancel();
            }

            
            {
                a = v.this;
                super();
            }
        });
        requestWindowFeature(1);
        i = new FrameLayout(getContext());
        a();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        h = new ImageView(getContext());
        h.setOnClickListener(new android.view.View.OnClickListener() {

            final v a;

            public final void onClick(View view)
            {
                a.cancel();
            }

            
            {
                a = v.this;
                super();
            }
        });
        bundle = getContext().getResources().getDrawable(com.facebook.x.a.com_facebook_close);
        h.setImageDrawable(bundle);
        h.setVisibility(4);
        int l = h.getDrawable().getIntrinsicWidth() / 2 + 1;
        bundle = new LinearLayout(getContext());
        c = new WebView(getContext().getApplicationContext()) {

            final v a;

            public final void onWindowFocusChanged(boolean flag)
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
                a = v.this;
                super(context);
            }
        };
        c.setVerticalScrollBarEnabled(false);
        c.setHorizontalScrollBarEnabled(false);
        c.setWebViewClient(new b((byte)0));
        c.getSettings().setJavaScriptEnabled(true);
        c.loadUrl(f);
        c.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        c.setVisibility(4);
        c.getSettings().setSavePassword(false);
        c.getSettings().setSaveFormData(false);
        c.setFocusable(true);
        c.setFocusableInTouchMode(true);
        c.setOnTouchListener(new android.view.View.OnTouchListener() {

            final v a;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                if (!view.hasFocus())
                {
                    view.requestFocus();
                }
                return false;
            }

            
            {
                a = v.this;
                super();
            }
        });
        bundle.setPadding(l, l, l, l);
        bundle.addView(c);
        bundle.setBackgroundColor(0xcc000000);
        i.addView(bundle);
        i.addView(h, new android.view.ViewGroup.LayoutParams(-2, -2));
        setContentView(i);
    }

    public void onDetachedFromWindow()
    {
        j = true;
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int l, KeyEvent keyevent)
    {
        if (l == 4)
        {
            cancel();
        }
        return super.onKeyDown(l, keyevent);
    }

    protected void onStart()
    {
        super.onStart();
        a();
    }
}
