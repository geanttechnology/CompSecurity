// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.d;
import com.appnexus.opensdk.b.e;
import com.appnexus.opensdk.b.j;
import com.appnexus.opensdk.b.k;
import com.appnexus.opensdk.b.l;
import com.appnexus.opensdk.b.o;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.appnexus.opensdk:
//            r, k, x, au, 
//            AdActivity, q, d, a, 
//            am

class m extends WebView
    implements r
{
    private final class a extends WebViewClient
    {

        final m a;

        public final void onLoadResource(WebView webview, String s1)
        {
            if (!s1.startsWith("http"))
            {
                break MISSING_BLOCK_LABEL_118;
            }
            android.webkit.WebView.HitTestResult hittestresult = a.getHitTestResult();
            if (hittestresult == null)
            {
                return;
            }
            boolean flag;
            if (hittestresult.getExtra() == null)
            {
                break MISSING_BLOCK_LABEL_118;
            }
            flag = hittestresult.getExtra().equals(s1);
            if (flag)
            {
                switch (hittestresult.getType())
                {
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                default:
                    return;

                case 1: // '\001'
                case 6: // '\006'
                case 7: // '\007'
                case 8: // '\b'
                    a.c(s1);
                    break;
                }
                webview.stopLoading();
                a.a();
                return;
            }
            break MISSING_BLOCK_LABEL_118;
            webview;
        }

        public final void onPageFinished(WebView webview, String s1)
        {
            super.onPageFinished(webview, s1);
            if (!com.appnexus.opensdk.m.d(a))
            {
                webview.loadUrl("javascript:window.mraid.util.pageFinished()");
                if (m.a(a))
                {
                    m.c(a).a(a, a.k);
                    com.appnexus.opensdk.m.e(a);
                }
                m.f(a);
            }
        }

        public final void onReceivedError(WebView webview, int i1, String s1, String s2)
        {
            com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.f, com.appnexus.opensdk.b.b.a(an.d.webview_received_error, i1, s1, s2));
        }

        public final void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            m.g(a);
            com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.f, com.appnexus.opensdk.b.b.a(an.d.webclient_error, sslerror.getPrimaryError(), sslerror.toString()));
        }

        public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
        {
            boolean flag1;
            boolean flag2;
            flag1 = true;
            flag2 = false;
            com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.b, (new StringBuilder("Loading URL: ")).append(s1).toString());
            if (!s1.startsWith("javascript:")) goto _L2; else goto _L1
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            if (!s1.startsWith("mraid://"))
            {
                break; /* Loop/switch isn't completed */
            }
            com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.i, s1);
            if (m.a(a))
            {
                m.c(a).a(s1, com.appnexus.opensdk.m.b(a));
                return true;
            }
            webview = Uri.parse(s1).getHost();
            flag = flag1;
            if (webview != null)
            {
                flag = flag1;
                if (webview.equals("enable"))
                {
                    a.g();
                    return true;
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
            m m1;
            Object obj;
            if (!s1.startsWith("anjam://"))
            {
                break; /* Loop/switch isn't completed */
            }
            m1 = a;
            webview = Uri.parse(s1);
            obj = webview.getHost();
            if (!"MayDeepLink".equals(obj)) goto _L6; else goto _L5
_L5:
            s1 = webview.getQueryParameter("cb");
            webview = webview.getQueryParameter("url");
            flag = flag2;
            if (m1.getContext() == null) goto _L8; else goto _L7
_L7:
            flag = flag2;
            if (m1.getContext().getPackageManager() == null) goto _L8; else goto _L9
_L9:
            if (webview != null) goto _L11; else goto _L10
_L10:
            flag = flag2;
_L8:
            webview = new LinkedList();
            webview.add(new BasicNameValuePair("caller", "MayDeepLink"));
            webview.add(new BasicNameValuePair("mayDeepLink", String.valueOf(flag)));
            com.appnexus.opensdk.a.a(m1, s1, webview);
            return true;
_L11:
            webview = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(webview)));
            webview.setFlags(0x10000000);
            flag = flag2;
            if (webview.resolveActivity(m1.getContext().getPackageManager()) != null)
            {
                flag = true;
            }
            if (true) goto _L8; else goto _L6
_L6:
            if ("DeepLink".equals(obj))
            {
                if (m1.l)
                {
                    s1 = webview.getQueryParameter("cb");
                    obj = webview.getQueryParameter("url");
                    webview = new LinkedList();
                    webview.add(new BasicNameValuePair("caller", "DeepLink"));
                    if (m1.getContext() == null || obj == null)
                    {
                        com.appnexus.opensdk.a.a(m1, s1, webview);
                        return true;
                    }
                    try
                    {
                        obj = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(((String) (obj)))));
                        ((Intent) (obj)).setFlags(0x10000000);
                        m1.getContext().startActivity(((Intent) (obj)));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        com.appnexus.opensdk.a.a(m1, s1, webview);
                        return true;
                    }
                    return true;
                } else
                {
                    com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.h, com.appnexus.opensdk.b.b.a(an.d.no_user_interaction, s1));
                    return true;
                }
            }
            if ("ExternalBrowser".equals(obj))
            {
                if (m1.l)
                {
                    webview = webview.getQueryParameter("url");
                    flag = flag1;
                    if (m1.getContext() != null)
                    {
                        flag = flag1;
                        if (webview != null)
                        {
                            flag = flag1;
                            if (webview.startsWith("http"))
                            {
                                try
                                {
                                    webview = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(webview)));
                                    m1.getContext().startActivity(webview);
                                }
                                // Misplaced declaration of an exception variable
                                catch (WebView webview)
                                {
                                    Toast.makeText(m1.getContext(), an.d.action_cant_be_completed, 0).show();
                                    return true;
                                }
                                return true;
                            }
                        }
                    }
                } else
                {
                    com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.h, com.appnexus.opensdk.b.b.a(an.d.no_user_interaction, s1));
                    return true;
                }
            } else
            if ("InternalBrowser".equals(obj))
            {
                if (m1.l)
                {
                    webview = webview.getQueryParameter("url");
                    flag = flag1;
                    if (m1.getContext() != null)
                    {
                        flag = flag1;
                        if (webview != null)
                        {
                            flag = flag1;
                            if (webview.startsWith("http"))
                            {
                                obj = Uri.decode(webview);
                                webview = AdActivity.a();
                                s1 = new Intent(m1.getContext(), webview);
                                s1.putExtra("ACTIVITY_TYPE", "BROWSER");
                                WebView webview1 = new WebView(m1.getContext());
                                com.appnexus.opensdk.b.o.a(webview1);
                                q.a.add(webview1);
                                webview1.loadUrl(((String) (obj)));
                                if (m1.b.getBrowserStyle() != null)
                                {
                                    obj = (new StringBuilder()).append(webview1.hashCode()).toString();
                                    s1.putExtra("bridgeid", ((String) (obj)));
                                    com.appnexus.opensdk.k.b.d.add(new Pair(obj, m1.b.getBrowserStyle()));
                                }
                                try
                                {
                                    m1.getContext().startActivity(s1);
                                }
                                // Misplaced declaration of an exception variable
                                catch (String s1)
                                {
                                    Toast.makeText(m1.getContext(), an.d.action_cant_be_completed, 0).show();
                                    com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.adactivity_missing, webview.getName()));
                                    q.a.remove();
                                    return true;
                                }
                                return true;
                            }
                        }
                    }
                } else
                {
                    com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.h, com.appnexus.opensdk.b.b.a(an.d.no_user_interaction, s1));
                    return true;
                }
            } else
            if ("RecordEvent".equals(obj))
            {
                webview = webview.getQueryParameter("url");
                flag = flag1;
                if (webview != null)
                {
                    flag = flag1;
                    if (webview.startsWith("http"))
                    {
                        s1 = new WebView(m1.getContext());
                        s1.setWebViewClient(new a._cls1());
                        s1.loadUrl(webview);
                        s1.setVisibility(8);
                        m1.addView(s1);
                        return true;
                    }
                }
            } else
            {
                if ("DispatchAppEvent".equals(obj))
                {
                    s1 = webview.getQueryParameter("event");
                    webview = webview.getQueryParameter("data");
                    m1.b.getAdDispatcher().a(s1, webview);
                    return true;
                }
                if ("GetDeviceID".equals(obj))
                {
                    obj = webview.getQueryParameter("cb");
                    LinkedList linkedlist;
                    if (!com.appnexus.opensdk.b.k.a(com.appnexus.opensdk.b.j.a().d))
                    {
                        webview = com.appnexus.opensdk.b.j.a().d;
                        s1 = "aaid";
                    } else
                    {
                        webview = com.appnexus.opensdk.b.j.a().b;
                        s1 = "sha1udid";
                    }
                    linkedlist = new LinkedList();
                    linkedlist.add(new BasicNameValuePair("caller", "GetDeviceID"));
                    linkedlist.add(new BasicNameValuePair("idname", s1));
                    linkedlist.add(new BasicNameValuePair("id", webview));
                    com.appnexus.opensdk.a.a(m1, ((String) (obj)), linkedlist);
                    return true;
                } else
                {
                    com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.b, (new StringBuilder("ANJAM called with unsupported function: ")).append(((String) (obj))).toString());
                    return true;
                }
            }
            if (true) goto _L4; else goto _L12
_L12:
            if (s1.startsWith("appnexuspb://"))
            {
                am.a(a, s1);
                return true;
            } else
            {
                a.c(s1);
                a.a();
                return true;
            }
        }

        private a()
        {
            a = m.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    static interface b
    {

        public abstract void a();
    }

    private final class c extends WebView
    {

        final m a;

        public c(Context context)
        {
            a = m.this;
            super(context);
            com.appnexus.opensdk.b.o.a(this);
            setWebViewClient(new _cls1(this, m.this));
        }
    }


    boolean a;
    com.appnexus.opensdk.k b;
    boolean c;
    x d;
    int e;
    int f;
    boolean g;
    int h;
    int i;
    int j;
    protected String k;
    boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private Handler p;
    private boolean q;
    private ProgressDialog r;
    private final Runnable s = new Runnable() {

        final m a;

        public final void run()
        {
            if (m.h(a))
            {
                return;
            } else
            {
                a.i();
                m.i(a).postDelayed(this, 1000L);
                return;
            }
        }

            
            {
                a = m.this;
                super();
            }
    };

    public m(com.appnexus.opensdk.k k1)
    {
        super(k1.getContext());
        a = false;
        g = false;
        n = false;
        o = false;
        p = new Handler();
        q = false;
        l = false;
        b = k1;
        k = x.a[x.b.a.ordinal()];
        com.appnexus.opensdk.b.j.a().j = getSettings().getUserAgentString();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setLightTouchEnabled(false);
        getSettings().setLoadsImagesAutomatically(true);
        getSettings().setSupportZoom(false);
        getSettings().setUseWideViewPort(false);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        setHorizontalScrollbarOverlay(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setBackgroundColor(0);
        setScrollBarStyle(0);
        d = new x(this);
        setWebChromeClient(new au(this));
        setWebViewClient(new a((byte)0));
    }

    static String a(m m1, String s1)
    {
        return m1.b(s1);
    }

    static String a(String s1)
    {
        String s2;
        if (!s1.contains("<html>"))
        {
            s2 = (new StringBuilder("<html><head></head><body style='padding:0;margin:0;'>")).append(s1).append("</body></html>").toString();
        } else
        {
            s2 = s1;
            if (!s1.contains("<head>"))
            {
                return s1.replace("<html>", "<html><head></head>");
            }
        }
        return s2;
    }

    private void a(int i1, int j1)
    {
        if (i1 == 0 && j1 == 0)
        {
            com.appnexus.opensdk.b.o.b(this);
            o = true;
            if (c && m)
            {
                k();
            }
        } else
        {
            com.appnexus.opensdk.b.o.c(this);
            o = false;
            l();
        }
        d.d();
    }

    protected static void a(Activity activity, boolean flag, AdActivity.b b1)
    {
        if (b1 != AdActivity.b.c)
        {
            AdActivity.a(activity, b1);
        }
        if (flag)
        {
            com.appnexus.opensdk.AdActivity.b(activity);
        } else
        if (b1 == AdActivity.b.c)
        {
            AdActivity.a(activity);
            return;
        }
    }

    private void a(WebView webview)
    {
        Class class1 = AdActivity.a();
        Intent intent = new Intent(b.getContext(), class1);
        intent.setFlags(0x10000000);
        intent.putExtra("ACTIVITY_TYPE", "BROWSER");
        q.a.add(webview);
        if (b.getBrowserStyle() != null)
        {
            webview = (new StringBuilder()).append(super.hashCode()).toString();
            intent.putExtra("bridgeid", webview);
            com.appnexus.opensdk.k.b.d.add(new Pair(webview, b.getBrowserStyle()));
        }
        try
        {
            b.getContext().startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.adactivity_missing, class1.getName()));
        }
        q.a.remove();
    }

    static void a(m m1, WebView webview)
    {
        m1.a(webview);
    }

    static boolean a(m m1)
    {
        return m1.c;
    }

    static boolean b(m m1)
    {
        return m1.l;
    }

    static boolean b(m m1, String s1)
    {
        return m1.f(s1);
    }

    static x c(m m1)
    {
        return m1.d;
    }

    static String d(String s1)
    {
        return a(s1);
    }

    static boolean d(m m1)
    {
        return m1.m;
    }

    static void e(m m1)
    {
        m1.k();
    }

    private boolean e(String s1)
    {
        Intent intent;
        boolean flag;
        flag = false;
        intent = new Intent("android.intent.action.VIEW", Uri.parse(s1));
        intent.setFlags(0x10000000);
        b.getContext().startActivity(intent);
        flag = true;
_L2:
        return flag;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.opening_url_failed, s1));
        if (c)
        {
            Toast.makeText(b.getContext(), an.d.action_cant_be_completed, 0).show();
            return false;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    static boolean f(m m1)
    {
        m1.m = true;
        return true;
    }

    private boolean f(String s1)
    {
        if (s1.contains("://play.google.com") || s1.contains("market://"))
        {
            com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.opening_app_store));
            return e(s1);
        } else
        {
            return false;
        }
    }

    static void g(m m1)
    {
        m1.a = true;
    }

    static boolean h(m m1)
    {
        return m1.q;
    }

    static Handler i(m m1)
    {
        return m1.p;
    }

    static ProgressDialog j(m m1)
    {
        return m1.r;
    }

    private void k()
    {
        if (!o)
        {
            return;
        } else
        {
            q = false;
            p.removeCallbacks(s);
            p.post(s);
            return;
        }
    }

    private void l()
    {
        q = true;
        p.removeCallbacks(s);
    }

    final void a()
    {
        if (b != null)
        {
            b.getAdDispatcher().c();
            b.g();
        }
    }

    public final View b()
    {
        return this;
    }

    final String b(String s1)
    {
        Resources resources = getResources();
        StringBuilder stringbuilder = new StringBuilder("<head><script>");
        if (resources == null || !com.appnexus.opensdk.b.k.a(stringbuilder, resources, an.c.sdkjs) || !com.appnexus.opensdk.b.k.a(stringbuilder, resources, an.c.anjam) || !com.appnexus.opensdk.b.k.a(stringbuilder, resources, an.c.mraid))
        {
            com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.b, "Error reading SDK's raw resources.");
            return s1;
        } else
        {
            stringbuilder.append("</script>");
            return s1.replace("<head>", stringbuilder.toString());
        }
    }

    final void c(String s1)
    {
        if (b.getOpensNativeBrowser() || !s1.startsWith("http"))
        {
            break MISSING_BLOCK_LABEL_207;
        }
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.opening_inapp));
        if (!f(s1)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (b.getLoadsInBackground())
        {
            c c1 = new c(getContext());
            c1.loadUrl(s1);
            c1.setVisibility(8);
            b.addView(c1);
            s1 = c1;
        } else
        {
            WebView webview = new WebView(getContext());
            com.appnexus.opensdk.b.o.a(webview);
            webview.loadUrl(s1);
            a(webview);
            s1 = webview;
        }
        if (!b.getShowLoadingIndicator()) goto _L1; else goto _L3
_L3:
        r = new ProgressDialog(((ViewGroup)getParent()).getContext());
        r.setCancelable(true);
        r.setOnCancelListener(new android.content.DialogInterface.OnCancelListener(s1) {

            final WebView a;
            final m b;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.stopLoading();
            }

            
            {
                b = m.this;
                a = webview;
                super();
            }
        });
        r.setMessage(getContext().getResources().getString(an.d.loading));
        r.setProgressStyle(0);
        r.show();
        return;
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(an.d.opening_native));
        e(s1);
        return;
    }

    public final boolean c()
    {
        return a;
    }

    public final int d()
    {
        return h;
    }

    public void destroy()
    {
        com.appnexus.opensdk.b.l.a(this);
        super.destroy();
        removeAllViews();
        l();
    }

    public final int e()
    {
        return i;
    }

    public final void f()
    {
        destroy();
    }

    public final void g()
    {
        if (!c)
        {
            c = true;
            if (m)
            {
                d.a(this, k);
                k();
                return;
            }
        }
    }

    void h()
    {
        if (b != null)
        {
            b.a(e, f, d);
        }
    }

    protected final void i()
    {
        if (getContext() instanceof Activity)
        {
            int ai[] = new int[2];
            getLocationOnScreen(ai);
            int i1 = ai[0];
            int j1 = ai[0];
            int k1 = getWidth();
            int l1 = ai[1];
            int i2 = ai[1];
            int j2 = getHeight();
            ai = com.appnexus.opensdk.b.l.a((Activity)getContext());
            boolean flag;
            if (j1 + k1 > 0 && i1 < ai[0] && j2 + i2 > 0 && l1 < ai[1])
            {
                flag = true;
            } else
            {
                flag = false;
            }
            n = flag;
            if (d != null)
            {
                d.d();
                d.a(i1, l1, getWidth(), getHeight());
                i1 = getContext().getResources().getConfiguration().orientation;
                x x1 = d;
                if (x1.m != i1)
                {
                    x1.m = i1;
                    x1.b();
                    x1.c();
                    return;
                }
            }
        }
    }

    final boolean j()
    {
        return n && o;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        l = true;
        return super.onTouchEvent(motionevent);
    }

    public void onVisibilityChanged(View view, int i1)
    {
        super.onVisibilityChanged(view, i1);
        a(getWindowVisibility(), i1);
    }

    protected void onWindowVisibilityChanged(int i1)
    {
        super.onWindowVisibilityChanged(i1);
        a(i1, getVisibility());
    }

    public void scrollTo(int i1, int j1)
    {
        super.scrollTo(0, 0);
    }

    // Unreferenced inner class com/appnexus/opensdk/m$1

/* anonymous class */
    final class _cls1 extends d
    {

        final String a;
        final m b;

        protected final String a()
        {
            return a;
        }

        protected final void a(e e1)
        {
            if (e1.a)
            {
                e1 = com.appnexus.opensdk.m.d(e1.b);
                String s1 = m.a(b, e1);
                try
                {
                    e1 = (new URL(a)).getHost();
                }
                // Misplaced declaration of an exception variable
                catch (e e1)
                {
                    e1 = null;
                }
                b.loadDataWithBaseURL(e1, s1, "text/html", "UTF-8", null);
                b.g();
            }
        }

        protected final void onPostExecute(Object obj)
        {
            a((e)obj);
        }

            
            {
                b = m.this;
                a = s1;
                super();
            }
    }


    // Unreferenced inner class com/appnexus/opensdk/m$3

/* anonymous class */
    final class _cls3
        implements b
    {

        final x a;
        final boolean b;
        final AdActivity.b c;
        final m d;

        public final void a()
        {
            if (a != null && a.j != null)
            {
                m.a(a.j, b, c);
                com.appnexus.opensdk.k.o = null;
            }
        }

            
            {
                d = m.this;
                a = x1;
                b = flag;
                c = b1;
                super();
            }
    }


    // Unreferenced inner class com/appnexus/opensdk/m$c$1

/* anonymous class */
    final class c._cls1 extends WebViewClient
    {

        final m a;
        final c b;
        private boolean c;

        public final void onPageFinished(WebView webview, String s1)
        {
            com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.j, (new StringBuilder("Opening URL: ")).append(s1).toString());
            com.appnexus.opensdk.b.l.a(b);
            if (com.appnexus.opensdk.m.j(b.a) != null)
            {
                com.appnexus.opensdk.m.j(b.a).dismiss();
            }
            if (c)
            {
                c = false;
                return;
            } else
            {
                b.setVisibility(0);
                m.a(b.a, b);
                return;
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
        {
            com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.b.b.j, (new StringBuilder("Redirecting to URL: ")).append(s1).toString());
            c = com.appnexus.opensdk.m.b(b.a, s1);
            if (c && com.appnexus.opensdk.m.j(b.a) != null)
            {
                com.appnexus.opensdk.m.j(b.a).dismiss();
            }
            return c;
        }

            
            {
                b = c1;
                a = m1;
                super();
                c = false;
            }
    }

}
