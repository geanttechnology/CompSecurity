// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.millennialmedia.android:
//            MMLog, HandShake, MMAdView, MMSDK, 
//            MMAdImpl, MRaid, MMLayout, BridgeMMSpeechkit, 
//            MMActivity, AdViewOverlayView, Utils, HttpMMHeaders, 
//            DTOResizeParameters

class MMWebView extends WebView
{

    long a;
    volatile boolean b;
    volatile String c;
    boolean d;
    volatile boolean e;
    int f;
    int g;
    int h;
    volatile boolean i;
    HttpMMHeaders j;
    boolean k;
    private GestureDetector l;
    private String m;
    private volatile boolean n;

    public MMWebView(Context context, long l1)
    {
        super(context);
        d = true;
        g = -50;
        h = -50;
        i = false;
        k = false;
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnTouchListener(new WebTouchListener());
        c = "loading";
        a = l1;
        MMLog.a("MMWebView", String.format("Assigning WebView internal id: %d", new Object[] {
            Long.valueOf(a)
        }));
        setId((int)(15063L + a));
        WebSettings websettings;
        if (HandShake.a(context).d)
        {
            c();
        } else
        {
            a();
        }
        setWebChromeClient(new MyWebChromeClient());
        websettings = getSettings();
        websettings.getUserAgentString();
        websettings.setJavaScriptEnabled(true);
        websettings.setCacheMode(-1);
        websettings.setDefaultTextEncodingName("UTF-8");
        websettings.setLoadWithOverviewMode(true);
        websettings.setGeolocationEnabled(true);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            MMLog.c("MMWebView", "Disabling user gesture requirement for media playback");
            websettings.setMediaPlaybackRequiresUserGesture(false);
        }
        websettings.setJavaScriptCanOpenWindowsAutomatically(true);
        l = new GestureDetector(context.getApplicationContext(), new BannerGestureListener());
    }

    static boolean a(MMWebView mmwebview)
    {
        return mmwebview.h == -50 && mmwebview.g == -50;
    }

    private static boolean s()
    {
        int i1 = Integer.parseInt(android.os.Build.VERSION.SDK);
        return "Nexus S".equals(Build.MODEL) && "samsung".equals(Build.MANUFACTURER) && (i1 == 16 || i1 == 17);
    }

    private MMAdView t()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = getParent();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof MMAdView)) goto _L2; else goto _L3
_L3:
        obj = (MMAdView)obj;
_L5:
        this;
        JVM INSTR monitorexit ;
        return ((MMAdView) (obj));
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
            MMLog.c("MMWebView", "Disabling acceleration");
            setLayerType(0, null);
        }
    }

    final void a(DTOResizeParameters dtoresizeparameters)
    {
        this;
        JVM INSTR monitorenter ;
        MMAdView mmadview;
        if (!MMSDK.c())
        {
            break MISSING_BLOCK_LABEL_56;
        }
        mmadview = f();
        n = false;
        MMLog.b("MMWebView", (new StringBuilder("New DTOResizeParameters = ")).append(dtoresizeparameters).toString());
        if (mmadview == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        MMSDK.a(new Runnable(mmadview, dtoresizeparameters) {

            private MMAdView a;
            private DTOResizeParameters b;
            private MMWebView c;

            public void run()
            {
                synchronized (c)
                {
                    c.d = true;
                    a.a(b);
                    Object obj = b;
                    MMAdView mmadview1 = a;
                    mmadview1.getClass();
                    obj = new MMAdView.BannerBounds(mmadview1, ((DTOResizeParameters) (obj)));
                    if (MMWebView.a(c))
                    {
                        android.view.ViewGroup.LayoutParams layoutparams = c.getLayoutParams();
                        c.h = layoutparams.width;
                        c.g = layoutparams.height;
                        if (c.h <= 0)
                        {
                            c.h = c.getWidth();
                        }
                        if (c.g <= 0)
                        {
                            c.g = c.getHeight();
                        }
                    }
                    ((MMAdView.BannerBounds) (obj)).a(c.getLayoutParams());
                    c.loadUrl("javascript:MMJS.sdk.setState('resized');");
                    c.c = "resized";
                }
                return;
                exception;
                mmwebview;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                c = MMWebView.this;
                a = mmadview;
                b = dtoresizeparameters;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        dtoresizeparameters;
        throw dtoresizeparameters;
    }

    final void a(MMAdImpl mmadimpl)
    {
        this;
        JVM INSTR monitorenter ;
        if (!MMSDK.c() || !p() || mmadimpl == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        mmadimpl = mmadimpl.d();
        if (mmadimpl instanceof MMAdView)
        {
            mmadimpl = (MMAdView)mmadimpl;
            n = true;
            MMSDK.a(new Runnable(mmadimpl) {

                private MMAdView a;
                private MMWebView b;

                public void run()
                {
                    synchronized (b)
                    {
                        a.b();
                        if (MMSDK.c() && !MMWebView.a(b))
                        {
                            android.view.ViewGroup.LayoutParams layoutparams = b.getLayoutParams();
                            layoutparams.width = b.h;
                            layoutparams.height = b.g;
                            b.h = -50;
                            b.g = -50;
                            b.requestLayout();
                        }
                        b.j();
                        b.d = true;
                        b.invalidate();
                    }
                    return;
                    exception;
                    mmwebview;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                b = MMWebView.this;
                a = mmadview;
                super();
            }
            });
        }
        this;
        JVM INSTR monitorexit ;
        return;
        mmadimpl;
        throw mmadimpl;
    }

    final void a(String s1, String s2, MMAdImpl mmadimpl)
    {
        if (s1 == null || s2 == null || mmadimpl == null)
        {
            return;
        }
        a(mmadimpl);
        d();
        String s3 = s2.substring(0, s2.lastIndexOf("/") + 1);
        if (MMSDK.a >= 5)
        {
            MMLog.a("MMWebView", String.format("Received ad with base url %s.", new Object[] {
                s3
            }));
            MMLog.a("MMWebView", s1);
        }
        if (mmadimpl.g())
        {
            s2 = new FutureTask(new Callable(mmadimpl) {

                private MMAdImpl a;
                private MMWebView b;

                public volatile Object call()
                {
                    return call();
                }

                public Void call()
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
                    MMLog.a("MMWebView", "Animation exception: ", exception);
                    if (true) goto _L2; else goto _L1
_L1:
                }

            
            {
                b = MMWebView.this;
                a = mmadimpl;
                super();
            }
            });
            MMSDK.a(s2);
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
        if (mmadimpl.c)
        {
            s2 = (new StringBuilder("<head><meta name=\"viewport\" content=\"target-densitydpi=device-dpi\" /></head>")).append(s1).toString();
        }
        if (MRaid.a(mmadimpl.i()))
        {
            s2 = MRaid.a(mmadimpl.i(), s2);
        } else
        {
            MMLog.e("MMWebView", "MMJS is not downloaded");
        }
        MMSDK.a(new Runnable(mmadimpl, s3, s2) {

            private MMAdImpl a;
            private String b;
            private String c;
            private MMWebView d;

            public void run()
            {
                MMAd mmad;
                if (HandShake.a(d.getContext()).d)
                {
                    d.c();
                } else
                if (d.f == 0)
                {
                    d.b();
                } else
                {
                    d.a();
                }
                mmad = a.d();
                if (mmad != null && (mmad instanceof MMLayout))
                {
                    ((MMLayout)mmad).g();
                }
                d.d = true;
                d.loadDataWithBaseURL(b, c, "text/html", "UTF-8", null);
            }

            
            {
                d = MMWebView.this;
                a = mmadimpl;
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
        MMLog.d("MMWebView", (new StringBuilder("Id check for parent: ")).append(l1).append(" versus ").append(((MMLayout)viewparent).e.f).toString());
        return l1 == ((MMLayout)viewparent).e.f;
    }

    final boolean a(String s1)
    {
        return !TextUtils.isEmpty(m) && s1.equals((new StringBuilder()).append(m).append("?").toString()) || s1.equals((new StringBuilder()).append(m).append("#").toString());
    }

    final void b()
    {
        if (s())
        {
            break MISSING_BLOCK_LABEL_58;
        }
        android/webkit/WebView.getMethod("setLayerType", new Class[] {
            Integer.TYPE, android/graphics/Paint
        }).invoke(this, new Object[] {
            Integer.valueOf(1), null
        });
        MMLog.b("MMWebView", "Enable softwareAcceleration");
        return;
        Exception exception;
        exception;
    }

    final void c()
    {
        if (s())
        {
            break MISSING_BLOCK_LABEL_58;
        }
        android/webkit/WebView.getMethod("setLayerType", new Class[] {
            Integer.TYPE, android/graphics/Paint
        }).invoke(this, new Object[] {
            Integer.valueOf(2), null
        });
        MMLog.b("MMWebView", "Enabled hardwareAcceleration");
        return;
        Exception exception;
        exception;
    }

    final void d()
    {
        BridgeMMSpeechkit.a();
        k = false;
    }

    final boolean e()
    {
        if (getParent() != null)
        {
            return (ViewGroup)getParent() instanceof MMAdView;
        } else
        {
            return false;
        }
    }

    final MMAdView f()
    {
        if (getParent() instanceof MMAdView)
        {
            return (MMAdView)getParent();
        } else
        {
            return null;
        }
    }

    final MMLayout g()
    {
        if (getParent() instanceof MMLayout)
        {
            return (MMLayout)getParent();
        } else
        {
            return null;
        }
    }

    final Activity h()
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

    final AdViewOverlayView i()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = getParent();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof AdViewOverlayView)) goto _L2; else goto _L3
_L3:
        obj = (AdViewOverlayView)obj;
_L5:
        this;
        JVM INSTR monitorexit ;
        return ((AdViewOverlayView) (obj));
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    final void j()
    {
        loadUrl("javascript:MMJS.sdk.setState('default')");
        c = "default";
        d = true;
    }

    final void k()
    {
        loadUrl("javascript:MMJS.sdk.setState('hidden')");
        c = "hidden";
    }

    final void l()
    {
        loadUrl("javascript:MMJS.sdk.setViewable(false)");
        i = false;
    }

    public void loadDataWithBaseURL(String s1, String s2, String s3, String s4, String s5)
    {
        m = s1;
        try
        {
            super.loadDataWithBaseURL(s1, s2, s3, s4, s5);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            MMLog.a("MMWebView", "Error hit when calling through to loadDataWithBaseUrl", s1);
        }
    }

    public void loadUrl(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return;
        }
        if (s1.startsWith("http"))
        {
            m = s1;
        }
        MMLog.a("MMWebView", (new StringBuilder("loadUrl @@")).append(s1).toString());
        if (MMSDK.a())
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
            MMSDK.a(new Runnable(s1) {

                private String a;
                private MMWebView b;

                public void run()
                {
                    b.loadUrl(a);
                }

            
            {
                b = MMWebView.this;
                a = s1;
                super();
            }
            });
            return;
        }
    }

    final void m()
    {
        loadUrl("javascript:MMJS.sdk.setViewable(true)");
        i = true;
    }

    final void n()
    {
        loadUrl("javascript:MMJS.sdk.setState('expanded');");
        c = "expanded";
        k = false;
        d = true;
    }

    final void o()
    {
        android.view.ViewParent viewparent = getParent();
        if (viewparent != null && (viewparent instanceof ViewGroup))
        {
            ((ViewGroup)viewparent).removeView(this);
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        j1 = android.view.View.MeasureSpec.getSize(j1);
        int k1 = android.view.View.MeasureSpec.getSize(i1);
        i1 = getMeasuredHeight();
        if (i1 == 0)
        {
            i1 = j1;
        }
        if (e)
        {
            setMeasuredDimension(1, 1);
            return;
        } else
        {
            setMeasuredDimension(k1, i1);
            return;
        }
    }

    public void onPauseWebView()
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        android/webkit/WebView.getMethod("onPause", new Class[0]).invoke(this, new Object[0]);
        return;
        Exception exception;
        exception;
        MMLog.d("MMWebView", "No onPause()");
        return;
    }

    public void onResumeWebView()
    {
        if (!e() && android.os.Build.VERSION.SDK_INT >= 19)
        {
            Activity activity = h();
            if (activity != null)
            {
                activity.setRequestedOrientation(14);
            }
        }
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        android/webkit/WebView.getMethod("onResume", new Class[0]).invoke(this, new Object[0]);
        return;
        Exception exception;
        exception;
        MMLog.d("MMWebView", "No onResume()");
        return;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        if (getContext().getResources().getDisplayMetrics() != null && d)
        {
            org.json.JSONObject jsonobject = Utils.a(this);
            loadUrl((new StringBuilder("javascript:MMJS.sdk.setAdSize(")).append(jsonobject).append(");").toString());
            if (getHeight() != 1 || getWidth() != 1)
            {
                MMSDK.a(new Runnable() {

                    private MMWebView a;

                    public void run()
                    {
                        a.d = false;
                    }

            
            {
                a = MMWebView.this;
                super();
            }
                }, 800L);
            }
        }
        super.onSizeChanged(i1, j1, k1, l1);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            requestFocus();
        }
        l.onTouchEvent(motionevent);
        if (motionevent.getAction() == 1)
        {
            MMLog.a("MMWebView", String.format("Ad clicked: action=%d x=%f y=%f", new Object[] {
                Integer.valueOf(motionevent.getAction()), Float.valueOf(motionevent.getX()), Float.valueOf(motionevent.getY())
            }));
        }
        return super.onTouchEvent(motionevent);
    }

    final boolean p()
    {
        return "resized".equals(c);
    }

    final boolean q()
    {
        return hasWindowFocus() && r();
    }

    final boolean r()
    {
        return t() == null;
    }

    public void setBackgroundColor(int i1)
    {
        f = i1;
        if (i1 == 0)
        {
            b();
        }
        super.setBackgroundColor(i1);
    }

    public String toString()
    {
        return (new StringBuilder("MMWebView originally from(")).append(a).append(") MRaidState(").append(c).append(").").append(super.toString()).toString();
    }

    // Unreferenced inner class com/millennialmedia/android/MMWebView$2

/* anonymous class */
    class _cls2
        implements Runnable
    {

        private String a;
        private String b;
        private MMWebView c;

        public void run()
        {
            if (HandShake.a(c.getContext()).d)
            {
                c.c();
            } else
            if (c.f == 0)
            {
                c.b();
            } else
            {
                c.a();
            }
            c.d = true;
            c.loadDataWithBaseURL(a, b, "text/html", "UTF-8", null);
        }

            
            {
                c = MMWebView.this;
                a = s1;
                b = s2;
                super();
            }
    }


    private class WebTouchListener
        implements android.view.View.OnTouchListener
    {

        private WeakReference a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            view = (MMWebView)a.get();
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
                return flag && (view.getParent() instanceof MMAdView);
            } else
            {
                return flag;
            }
        }

        WebTouchListener()
        {
            a = new WeakReference(MMWebView.this);
        }
    }


    private class MyWebChromeClient extends WebChromeClient
    {

        private WeakReference a;

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
            return (String)context;
        }

        static void a(MyWebChromeClient mywebchromeclient, boolean flag)
        {
            mywebchromeclient = (MMWebView)mywebchromeclient.a.get();
            if (mywebchromeclient != null)
            {
                mywebchromeclient = mywebchromeclient.getContext().getSharedPreferences("MillennialMediaSettings", 0).edit();
                mywebchromeclient.putBoolean("mm_use_geo_location", flag);
                mywebchromeclient.commit();
            }
        }

        public void onConsoleMessage(String s1, int i1, String s2)
        {
            super.onConsoleMessage(s1, i1, s2);
        }

        public void onGeolocationPermissionsShowPrompt(String s1, android.webkit.GeolocationPermissions.Callback callback)
        {
            MMWebView mmwebview = (MMWebView)a.get();
            boolean flag;
            boolean flag1;
            if (mmwebview != null)
            {
                if (!mmwebview.getContext().getSharedPreferences("MillennialMediaSettings", 0).contains("mm_use_geo_location"))
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
            mmwebview = (MMWebView)a.get();
            if (mmwebview != null)
            {
                flag1 = mmwebview.getContext().getSharedPreferences("MillennialMediaSettings", 0).getBoolean("mm_use_geo_location", false);
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
            Object obj = (MMWebView)a.get();
            if (obj == null) goto _L4; else goto _L3
_L3:
            obj = ((MMWebView) (obj)).h();
            if (obj == null) goto _L4; else goto _L5
_L5:
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(((Context) (obj)));
            builder.setTitle(a(((Context) (obj))));
            builder.setMessage("Would like to use your Current Location.").setPositiveButton("Allow", new android.content.DialogInterface.OnClickListener(callback, s1) {

                private android.webkit.GeolocationPermissions.Callback a;
                private String b;
                private MyWebChromeClient c;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    MyWebChromeClient.a(c, true);
                    a.invoke(b, true, true);
                }

                
                {
                    c = MyWebChromeClient.this;
                    a = callback;
                    b = s1;
                    super();
                }
            }).setNegativeButton("Don't Allow", new android.content.DialogInterface.OnClickListener(callback, s1) {

                private android.webkit.GeolocationPermissions.Callback a;
                private String b;
                private MyWebChromeClient c;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    MyWebChromeClient.a(c, false);
                    a.invoke(b, false, false);
                }

                
                {
                    c = MyWebChromeClient.this;
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

        public boolean onJsAlert(WebView webview, String s1, String s2, JsResult jsresult)
        {
            MMWebView mmwebview = (MMWebView)a.get();
            if (mmwebview != null)
            {
                if (mmwebview.getContext() != mmwebview.getContext().getApplicationContext())
                {
                    return super.onJsAlert(webview, s1, s2, jsresult);
                }
                Toast.makeText(mmwebview.getContext(), s2, 0).show();
            }
            return true;
        }

        public boolean onJsBeforeUnload(WebView webview, String s1, String s2, JsResult jsresult)
        {
            MMWebView mmwebview = (MMWebView)a.get();
            if (mmwebview != null)
            {
                if (mmwebview.getContext() != mmwebview.getContext().getApplicationContext())
                {
                    return super.onJsBeforeUnload(webview, s1, s2, jsresult);
                }
                Toast.makeText(mmwebview.getContext(), s2, 0).show();
            }
            return true;
        }

        public boolean onJsConfirm(WebView webview, String s1, String s2, JsResult jsresult)
        {
            MMWebView mmwebview = (MMWebView)a.get();
            if (mmwebview != null)
            {
                if (mmwebview.getContext() != mmwebview.getContext().getApplicationContext())
                {
                    return super.onJsConfirm(webview, s1, s2, jsresult);
                }
                Toast.makeText(mmwebview.getContext(), s2, 0).show();
            }
            return true;
        }

        public boolean onJsPrompt(WebView webview, String s1, String s2, String s3, JsPromptResult jspromptresult)
        {
            MMWebView mmwebview = (MMWebView)a.get();
            if (mmwebview != null)
            {
                if (mmwebview.getContext() != mmwebview.getContext().getApplicationContext())
                {
                    return super.onJsPrompt(webview, s1, s2, s3, jspromptresult);
                }
                Toast.makeText(mmwebview.getContext(), s2, 0).show();
            }
            return true;
        }

        MyWebChromeClient()
        {
            a = new WeakReference(MMWebView.this);
        }
    }


    private class BannerGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        private WeakReference a;

        public boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            motionevent = (MMWebView)a.get();
            if (motionevent != null)
            {
                motionevent = motionevent.f();
                if (motionevent != null)
                {
                    MMSDK.Event.a(((MMAdView) (motionevent)).e);
                }
            }
            return false;
        }

        public BannerGestureListener()
        {
            a = new WeakReference(MMWebView.this);
        }
    }

}
