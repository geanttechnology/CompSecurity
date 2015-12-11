// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.millennialmedia.android:
//            al, v, ad, an, 
//            ab, aq, ak, q, 
//            MMActivity, e, ac, au, 
//            HttpMMHeaders, u

final class ao extends WebView
{
    private static final class a extends android.view.GestureDetector.SimpleOnGestureListener
    {

        WeakReference a;

        public final boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            motionevent = (ao)a.get();
            if (motionevent != null)
            {
                motionevent = motionevent.e();
                if (motionevent != null)
                {
                    an.a.a(((ad) (motionevent)).h);
                }
            }
            return false;
        }

        public a(ao ao1)
        {
            a = new WeakReference(ao1);
        }
    }

    private static final class b extends WebChromeClient
    {

        WeakReference a;

        private static String a(Context context)
        {
            PackageManager packagemanager = context.getApplicationContext().getPackageManager();
            try
            {
                context = packagemanager.getApplicationInfo(context.getPackageName(), 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context = null;
            }
            if (context != null)
            {
                context = packagemanager.getApplicationLabel(context);
            } else
            {
                context = "This app";
            }
            return (String)(String)context;
        }

        static void a(b b1, boolean flag)
        {
            b1 = (ao)b1.a.get();
            if (b1 != null)
            {
                b1 = b1.getContext().getSharedPreferences("MillennialMediaSettings", 0).edit();
                b1.putBoolean("mm_use_geo_location", flag);
                b1.commit();
            }
        }

        public final void onConsoleMessage(String s1, int i1, String s2)
        {
            super.onConsoleMessage(s1, i1, s2);
        }

        public final void onGeolocationPermissionsShowPrompt(String s1, android.webkit.GeolocationPermissions.Callback callback)
        {
            ao ao1 = (ao)a.get();
            boolean flag;
            boolean flag1;
            if (ao1 != null)
            {
                if (!ao1.getContext().getSharedPreferences("MillennialMediaSettings", 0).contains("mm_use_geo_location"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_202;
            }
            ao1 = (ao)a.get();
            if (ao1 != null)
            {
                flag1 = ao1.getContext().getSharedPreferences("MillennialMediaSettings", 0).getBoolean("mm_use_geo_location", false);
            } else
            {
                flag1 = false;
            }
            if (!flag1) goto _L2; else goto _L1
_L1:
            callback.invoke(s1, true, true);
_L4:
            return;
_L2:
            Object obj = (ao)a.get();
            if (obj == null) goto _L4; else goto _L3
_L3:
            obj = ((ao) (obj)).g();
            if (obj == null) goto _L4; else goto _L5
_L5:
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(((Context) (obj)));
            builder.setTitle(a(((Context) (obj))));
            builder.setMessage("Would like to use your Current Location.").setPositiveButton("Allow", new android.content.DialogInterface.OnClickListener(this, callback, s1) {

                final android.webkit.GeolocationPermissions.Callback a;
                final String b;
                final b c;

                public final void onClick(DialogInterface dialoginterface, int i1)
                {
                    b.a(c, true);
                    a.invoke(b, true, true);
                }

            
            {
                c = b1;
                a = callback;
                b = s1;
                super();
            }
            }).setNegativeButton("Don't Allow", new android.content.DialogInterface.OnClickListener(this, callback, s1) {

                final android.webkit.GeolocationPermissions.Callback a;
                final String b;
                final b c;

                public final void onClick(DialogInterface dialoginterface, int i1)
                {
                    b.a(c, false);
                    a.invoke(b, false, false);
                }

            
            {
                c = b1;
                a = callback;
                b = s1;
                super();
            }
            });
            builder.create().show();
            return;
            callback.invoke(s1, false, false);
            return;
        }

        public final boolean onJsAlert(WebView webview, String s1, String s2, JsResult jsresult)
        {
            ao ao1 = (ao)a.get();
            if (ao1 != null)
            {
                if (ao1.getContext() != ao1.getContext().getApplicationContext())
                {
                    return super.onJsAlert(webview, s1, s2, jsresult);
                }
                Toast.makeText(ao1.getContext(), s2, 0).show();
            }
            return true;
        }

        public final boolean onJsBeforeUnload(WebView webview, String s1, String s2, JsResult jsresult)
        {
            ao ao1 = (ao)a.get();
            if (ao1 != null)
            {
                if (ao1.getContext() != ao1.getContext().getApplicationContext())
                {
                    return super.onJsBeforeUnload(webview, s1, s2, jsresult);
                }
                Toast.makeText(ao1.getContext(), s2, 0).show();
            }
            return true;
        }

        public final boolean onJsConfirm(WebView webview, String s1, String s2, JsResult jsresult)
        {
            ao ao1 = (ao)a.get();
            if (ao1 != null)
            {
                if (ao1.getContext() != ao1.getContext().getApplicationContext())
                {
                    return super.onJsConfirm(webview, s1, s2, jsresult);
                }
                Toast.makeText(ao1.getContext(), s2, 0).show();
            }
            return true;
        }

        public final boolean onJsPrompt(WebView webview, String s1, String s2, String s3, JsPromptResult jspromptresult)
        {
            ao ao1 = (ao)a.get();
            if (ao1 != null)
            {
                if (ao1.getContext() != ao1.getContext().getApplicationContext())
                {
                    return super.onJsPrompt(webview, s1, s2, s3, jspromptresult);
                }
                Toast.makeText(ao1.getContext(), s2, 0).show();
            }
            return true;
        }

        b(ao ao1)
        {
            a = new WeakReference(ao1);
        }
    }

    private static final class c
        implements android.view.View.OnTouchListener
    {

        WeakReference a;

        public final boolean onTouch(View view, MotionEvent motionevent)
        {
            view = (ao)a.get();
            boolean flag;
            if (motionevent.getAction() == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (view != null)
            {
                return flag && (view.getParent() instanceof ad);
            } else
            {
                return flag;
            }
        }

        c(ao ao1)
        {
            a = new WeakReference(ao1);
        }
    }


    long a;
    volatile boolean b;
    volatile String c;
    boolean d;
    final String e;
    final GestureDetector f;
    volatile boolean g;
    String h;
    int i;
    volatile boolean j;
    int k;
    int l;
    volatile boolean m;
    HttpMMHeaders n;
    boolean o;
    boolean p;

    public ao(Context context, long l1)
    {
        super(context);
        d = true;
        k = -50;
        l = -50;
        m = false;
        o = false;
        p = false;
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnTouchListener(new c(this));
        c = "loading";
        a = l1;
        String.format("Assigning WebView internal id: %d", new Object[] {
            Long.valueOf(a)
        });
        al.a();
        setId((int)(15063L + a));
        WebSettings websettings;
        if (v.a(context).e)
        {
            c();
        } else
        {
            a();
        }
        setWebChromeClient(new b(this));
        websettings = getSettings();
        e = websettings.getUserAgentString();
        websettings.setJavaScriptEnabled(true);
        websettings.setCacheMode(-1);
        websettings.setDefaultTextEncodingName("UTF-8");
        websettings.setLoadWithOverviewMode(true);
        websettings.setGeolocationEnabled(true);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            al.c();
            websettings.setMediaPlaybackRequiresUserGesture(false);
        }
        websettings.setJavaScriptCanOpenWindowsAutomatically(true);
        f = new GestureDetector(context.getApplicationContext(), new a(this));
    }

    static boolean a(ao ao1)
    {
        return ao1.l == -50 && ao1.k == -50;
    }

    private static boolean t()
    {
        int i1 = Integer.parseInt(android.os.Build.VERSION.SDK);
        return "Nexus S".equals(Build.MODEL) && "samsung".equals(Build.MANUFACTURER) && (i1 == 16 || i1 == 17);
    }

    private ad u()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = getParent();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof ad)) goto _L2; else goto _L3
_L3:
        obj = (ad)obj;
_L5:
        this;
        JVM INSTR monitorexit ;
        return ((ad) (obj));
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    final void a()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            al.c();
            setLayerType(0, null);
        }
    }

    final void a(ab ab1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!an.c() || !q() || ab1 == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        ab1 = ab1.d();
        if (ab1 instanceof ad)
        {
            ab1 = (ad)ab1;
            j = true;
            an.a(new Runnable(ab1) {

                final ad a;
                final ao b;

                public final void run()
                {
                    synchronized (b)
                    {
                        a.b();
                        if (an.c() && !ao.a(b))
                        {
                            android.view.ViewGroup.LayoutParams layoutparams = b.getLayoutParams();
                            layoutparams.width = b.l;
                            layoutparams.height = b.k;
                            b.l = -50;
                            b.k = -50;
                            b.requestLayout();
                        }
                        b.k();
                        b.d = true;
                        b.invalidate();
                    }
                    return;
                    exception;
                    ao1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                b = ao.this;
                a = ad1;
                super();
            }
            });
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ab1;
        throw ab1;
    }

    final void a(u u1)
    {
        this;
        JVM INSTR monitorenter ;
        ad ad1;
        if (!an.c())
        {
            break MISSING_BLOCK_LABEL_52;
        }
        ad1 = e();
        j = false;
        (new StringBuilder("New DTOResizeParameters = ")).append(u1);
        al.b();
        if (ad1 == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        an.a(new Runnable(ad1, u1) {

            final ad a;
            final u b;
            final ao c;

            public final void run()
            {
                synchronized (c)
                {
                    c.d = true;
                    a.a(b);
                    Object obj = b;
                    ad ad2 = a;
                    ad2.getClass();
                    obj = new ad.a(ad2, ((u) (obj)));
                    if (ao.a(c))
                    {
                        android.view.ViewGroup.LayoutParams layoutparams = c.getLayoutParams();
                        c.l = layoutparams.width;
                        c.k = layoutparams.height;
                        if (c.l <= 0)
                        {
                            c.l = c.getWidth();
                        }
                        if (c.k <= 0)
                        {
                            c.k = c.getHeight();
                        }
                    }
                    ((ad.a) (obj)).a(c.getLayoutParams());
                    c.loadUrl("javascript:MMJS.sdk.setState('resized');");
                    c.c = "resized";
                }
                return;
                exception;
                ao1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                c = ao.this;
                a = ad1;
                b = u1;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        u1;
        throw u1;
    }

    final void a(String s1, String s2, ab ab1)
    {
        if (s1 == null || s2 == null || ab1 == null)
        {
            return;
        }
        a(ab1);
        d();
        String s3 = s2.substring(0, s2.lastIndexOf("/") + 1);
        if (an.a >= 5)
        {
            String.format("Received ad with base url %s.", new Object[] {
                s3
            });
            al.a();
            al.a();
        }
        if (ab1.h())
        {
            s2 = new FutureTask(new Callable(ab1) {

                final ab a;
                final ao b;

                private Void a()
                {
                    Bitmap bitmap;
                    b.buildDrawingCache();
                    bitmap = b.getDrawingCache();
                    if (bitmap == null)
                    {
                        break MISSING_BLOCK_LABEL_32;
                    }
                    bitmap = Bitmap.createBitmap(bitmap);
                    a.a(bitmap);
                    b.destroyDrawingCache();
_L2:
                    return null;
                    Exception exception;
                    exception;
                    al.a("MMWebView", "Animation exception: ", exception);
                    if (true) goto _L2; else goto _L1
_L1:
                }

                public final Object call()
                {
                    return a();
                }

            
            {
                b = ao.this;
                a = ab1;
                super();
            }
            });
            an.a(s2);
            String s4;
            Matcher matcher;
            try
            {
                s2.get();
            }
            // Misplaced declaration of an exception variable
            catch (String s2) { }
            // Misplaced declaration of an exception variable
            catch (String s2) { }
        }
        s2 = s1;
        if (ab1.d)
        {
            s2 = (new StringBuilder("<head><meta name=\"viewport\" content=\"target-densitydpi=device-dpi\" /></head>")).append(s1).toString();
        }
        if (aq.b(ab1.j()))
        {
            s1 = ab1.j();
            matcher = Pattern.compile("<script.*src=[\"|']mraid\\.js[\"|']").matcher(s2);
            s4 = aq.a(s1);
            (new StringBuilder("Mraid path: ")).append(aq.a(s1));
            al.b();
            if (matcher.find())
            {
                s1 = matcher.replaceFirst((new StringBuilder("<script src=\"")).append(s4).append("\"").toString());
            } else
            if (s2.indexOf("<head>") == -1)
            {
                s1 = (new StringBuilder("<script src=\"")).append(s4).append("\"></script>").append(s2).toString();
            } else
            {
                matcher = Pattern.compile("<head>").matcher(s2);
                s1 = s2;
                if (matcher.find())
                {
                    s1 = matcher.replaceFirst((new StringBuilder("<head><script src=\"")).append(s4).append("\"></script>").toString());
                }
            }
            s2 = s1;
            if (s1.indexOf("<html>") == -1)
            {
                s2 = (new StringBuilder("<html><head></head><body style='margin:0;padding:0;'>")).append(s1).append("</body></html>").toString();
            }
        } else
        {
            al.a("MMWebView", "MMJS is not downloaded");
        }
        an.a(new Runnable(ab1, s3, s2) {

            final ab a;
            final String b;
            final String c;
            final ao d;

            public final void run()
            {
                aa aa;
                if (v.a(d.getContext()).e)
                {
                    d.c();
                } else
                if (d.i == 0)
                {
                    d.b();
                } else
                {
                    d.a();
                }
                aa = a.d();
                if (aa != null && (aa instanceof ak))
                {
                    ((ak)aa).d();
                }
                d.d = true;
                d.loadDataWithBaseURL(b, c, "text/html", "UTF-8", null);
            }

            
            {
                d = ao.this;
                a = ab1;
                b = s1;
                c = s2;
                super();
            }
        });
    }

    final boolean a(long l1)
    {
        android.view.ViewParent viewparent = getParent();
        if (viewparent == null)
        {
            return false;
        }
        (new StringBuilder("Id check for parent: ")).append(l1).append(" versus ").append(((ak)viewparent).h.h);
        al.d();
        return l1 == ((ak)viewparent).h.h;
    }

    final boolean a(String s1)
    {
        return !TextUtils.isEmpty(h) && s1.equals((new StringBuilder()).append(h).append("?").toString()) || s1.equals((new StringBuilder()).append(h).append("#").toString());
    }

    final void b()
    {
        if (t())
        {
            break MISSING_BLOCK_LABEL_53;
        }
        android/webkit/WebView.getMethod("setLayerType", new Class[] {
            Integer.TYPE, android/graphics/Paint
        }).invoke(this, new Object[] {
            Integer.valueOf(1), null
        });
        al.b();
        return;
        Exception exception;
        exception;
    }

    final void c()
    {
        if (t())
        {
            break MISSING_BLOCK_LABEL_53;
        }
        android/webkit/WebView.getMethod("setLayerType", new Class[] {
            Integer.TYPE, android/graphics/Paint
        }).invoke(this, new Object[] {
            Integer.valueOf(2), null
        });
        al.b();
        return;
        Exception exception;
        exception;
    }

    final void d()
    {
        com.millennialmedia.android.q.a();
        o = false;
        p = false;
    }

    final ad e()
    {
        if (getParent() instanceof ad)
        {
            return (ad)getParent();
        } else
        {
            return null;
        }
    }

    final ak f()
    {
        if (getParent() instanceof ak)
        {
            return (ak)getParent();
        } else
        {
            return null;
        }
    }

    final Activity g()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = getParent();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof ViewGroup)) goto _L2; else goto _L3
_L3:
        obj = ((ViewGroup)obj).getContext();
        if (obj == null) goto _L2; else goto _L4
_L4:
        if (!(obj instanceof MMActivity)) goto _L2; else goto _L5
_L5:
        obj = (MMActivity)obj;
_L7:
        this;
        JVM INSTR monitorexit ;
        return ((Activity) (obj));
_L2:
        obj = null;
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
        throw exception;
    }

    final e h()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = getParent();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof e)) goto _L2; else goto _L3
_L3:
        obj = (e)obj;
_L5:
        this;
        JVM INSTR monitorexit ;
        return ((e) (obj));
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public final void i()
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        android/webkit/WebView.getMethod("onPause", new Class[0]).invoke(this, new Object[0]);
        return;
        Exception exception;
        exception;
        al.d();
        return;
    }

    public final void j()
    {
        ab ab1 = ac.a(a);
        if (ab1 != null && ab1.j && !c.equals("expanded"))
        {
            an.a.e(ac.a(a));
        }
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        android/webkit/WebView.getMethod("onResume", new Class[0]).invoke(this, new Object[0]);
        return;
        Exception exception;
        exception;
        al.d();
        return;
    }

    final void k()
    {
        loadUrl("javascript:MMJS.sdk.setState('default')");
        c = "default";
        d = true;
    }

    final void l()
    {
        loadUrl("javascript:MMJS.sdk.setState('hidden')");
        c = "hidden";
    }

    public final void loadDataWithBaseURL(String s1, String s2, String s3, String s4, String s5)
    {
        h = s1;
        try
        {
            super.loadDataWithBaseURL(s1, s2, s3, s4, s5);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            al.a("MMWebView", "Error hit when calling through to loadDataWithBaseUrl", s1);
        }
    }

    public final void loadUrl(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return;
        }
        if (s1.startsWith("http"))
        {
            h = s1;
        }
        al.a();
        if (an.a())
        {
            try
            {
                super.loadUrl(s1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return;
            }
        } else
        {
            an.a(new Runnable(s1) {

                final String a;
                final ao b;

                public final void run()
                {
                    b.loadUrl(a);
                }

            
            {
                b = ao.this;
                a = s1;
                super();
            }
            });
            return;
        }
    }

    final void m()
    {
        loadUrl("javascript:MMJS.sdk.setViewable(false)");
        m = false;
    }

    final void n()
    {
        loadUrl("javascript:MMJS.sdk.setViewable(true)");
        m = true;
    }

    final void o()
    {
        loadUrl("javascript:MMJS.sdk.setState('expanded');");
        c = "expanded";
        o = false;
        p = false;
        d = true;
    }

    protected final void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        j1 = android.view.View.MeasureSpec.getSize(j1);
        int k1 = android.view.View.MeasureSpec.getSize(i1);
        i1 = getMeasuredHeight();
        if (i1 == 0)
        {
            i1 = j1;
        }
        if (g)
        {
            setMeasuredDimension(1, 1);
            return;
        } else
        {
            setMeasuredDimension(k1, i1);
            return;
        }
    }

    protected final void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        if (getContext().getResources().getDisplayMetrics() != null && d)
        {
            org.json.JSONObject jsonobject = au.a(this);
            loadUrl((new StringBuilder("javascript:MMJS.sdk.setAdSize(")).append(jsonobject).append(");").toString());
            if (getHeight() != 1 || getWidth() != 1)
            {
                an.a(new Runnable() {

                    final ao a;

                    public final void run()
                    {
                        a.d = false;
                    }

            
            {
                a = ao.this;
                super();
            }
                }, 800L);
            }
        }
        super.onSizeChanged(i1, j1, k1, l1);
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            requestFocus();
        }
        if (f != null)
        {
            f.onTouchEvent(motionevent);
        }
        if (motionevent.getAction() == 1)
        {
            String.format("Ad clicked: action=%d x=%f y=%f", new Object[] {
                Integer.valueOf(motionevent.getAction()), Float.valueOf(motionevent.getX()), Float.valueOf(motionevent.getY())
            });
            al.a();
        }
        return super.onTouchEvent(motionevent);
    }

    final void p()
    {
        android.view.ViewParent viewparent = getParent();
        if (viewparent != null && (viewparent instanceof ViewGroup))
        {
            ((ViewGroup)viewparent).removeView(this);
        }
    }

    final boolean q()
    {
        return "resized".equals(c);
    }

    final boolean r()
    {
        return hasWindowFocus() && s();
    }

    final boolean s()
    {
        return u() == null;
    }

    public final void setBackgroundColor(int i1)
    {
        i = i1;
        if (i1 == 0)
        {
            b();
        }
        super.setBackgroundColor(i1);
    }

    public final String toString()
    {
        return (new StringBuilder("MMWebView originally from(")).append(a).append(") MRaidState(").append(c).append(").").append(super.toString()).toString();
    }
}
