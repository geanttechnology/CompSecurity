// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.h;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.b:
//            cj, bz, ca, dj, 
//            cn, bu, ck, aq, 
//            f, be

public class cm extends WebView
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, cj
{
    public static class a extends MutableContextWrapper
    {

        private Activity a;
        private Context b;
        private Context c;

        public Activity a()
        {
            return a;
        }

        public Context b()
        {
            return c;
        }

        public Object getSystemService(String s1)
        {
            return c.getSystemService(s1);
        }

        public void setBaseContext(Context context)
        {
            b = context.getApplicationContext();
            Activity activity;
            if (context instanceof Activity)
            {
                activity = (Activity)context;
            } else
            {
                activity = null;
            }
            a = activity;
            c = context;
            super.setBaseContext(b);
        }

        public void startActivity(Intent intent)
        {
            if (a != null && !dj.f())
            {
                a.startActivity(intent);
                return;
            } else
            {
                intent.setFlags(0x10000000);
                b.startActivity(intent);
                return;
            }
        }

        public a(Context context)
        {
            super(context);
            setBaseContext(context);
        }
    }


    boolean a;
    private final ck b;
    private final a c;
    private final Object d = new Object();
    private final f e;
    private final VersionInfoParcel f;
    private com.google.android.gms.ads.internal.overlay.c g;
    private AdSizeParcel h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private Boolean n;
    private int o;
    private com.google.android.gms.ads.internal.overlay.c p;
    private int q;
    private int r;
    private int s;
    private int t;
    private final WindowManager u = (WindowManager)getContext().getSystemService("window");

    protected cm(a a1, AdSizeParcel adsizeparcel, boolean flag, boolean flag1, f f1, VersionInfoParcel versioninfoparcel)
    {
        super(a1);
        q = -1;
        r = -1;
        s = -1;
        t = -1;
        c = a1;
        h = adsizeparcel;
        k = flag;
        m = false;
        o = -1;
        e = f1;
        f = versioninfoparcel;
        setBackgroundColor(0);
        adsizeparcel = getSettings();
        adsizeparcel.setJavaScriptEnabled(true);
        adsizeparcel.setSavePassword(false);
        adsizeparcel.setSupportMultipleWindows(true);
        adsizeparcel.setJavaScriptCanOpenWindowsAutomatically(true);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            adsizeparcel.setMixedContentMode(0);
        }
        com.google.android.gms.ads.internal.c.c().a(a1, versioninfoparcel.b, adsizeparcel);
        com.google.android.gms.ads.internal.c.e().a(getContext(), adsizeparcel);
        setDownloadListener(this);
        b = com.google.android.gms.ads.internal.c.e().a(this, flag1);
        setWebViewClient(b);
        setWebChromeClient(com.google.android.gms.ads.internal.c.e().a(this));
        u();
        if (dj.d())
        {
            addJavascriptInterface(new cn(this), "googleAdsJsInterface");
        }
    }

    static cm a(Context context, AdSizeParcel adsizeparcel, boolean flag, boolean flag1, f f1, VersionInfoParcel versioninfoparcel)
    {
        return new cm(new a(context), adsizeparcel, flag, flag1, f1, versioninfoparcel);
    }

    private void s()
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        Boolean boolean1;
        n = com.google.android.gms.ads.internal.c.f().b();
        boolean1 = n;
        if (boolean1 != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        evaluateJavascript("(function(){})()", null);
        a(Boolean.valueOf(true));
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        a(Boolean.valueOf(false));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    private void t()
    {
        Activity activity = c();
        if (m && activity != null)
        {
            com.google.android.gms.ads.internal.c.e().a(activity, this);
            m = false;
        }
    }

    private void u()
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (!k && !h.e) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 14) goto _L4; else goto _L3
_L3:
        com.google.android.gms.ads.internal.util.client.b.a("Disabling hardware acceleration on an overlay.");
        v();
_L5:
        return;
_L4:
        com.google.android.gms.ads.internal.util.client.b.a("Enabling hardware acceleration on an overlay.");
        w();
          goto _L5
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                break label0;
            }
            com.google.android.gms.ads.internal.util.client.b.a("Disabling hardware acceleration on an AdView.");
            v();
        }
          goto _L5
        com.google.android.gms.ads.internal.util.client.b.a("Enabling hardware acceleration on an AdView.");
        w();
          goto _L5
    }

    private void v()
    {
        synchronized (d)
        {
            if (!l)
            {
                com.google.android.gms.ads.internal.c.e().b(this);
            }
            l = true;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void w()
    {
        synchronized (d)
        {
            if (l)
            {
                com.google.android.gms.ads.internal.c.e().a(this);
            }
            l = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a()
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put("version", f.b);
        a("onhide", ((Map) (hashmap)));
    }

    public void a(int i1)
    {
        HashMap hashmap = new HashMap(2);
        hashmap.put("closetype", String.valueOf(i1));
        hashmap.put("version", f.b);
        a("onhide", ((Map) (hashmap)));
    }

    public void a(AdSizeParcel adsizeparcel)
    {
        synchronized (d)
        {
            h = adsizeparcel;
            requestLayout();
        }
        return;
        adsizeparcel;
        obj;
        JVM INSTR monitorexit ;
        throw adsizeparcel;
    }

    public void a(com.google.android.gms.ads.internal.overlay.c c1)
    {
        synchronized (d)
        {
            g = c1;
        }
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    void a(Boolean boolean1)
    {
        n = boolean1;
        com.google.android.gms.ads.internal.c.f().a(boolean1);
    }

    public void a(String s1)
    {
        synchronized (d)
        {
            super.loadUrl(s1);
        }
        return;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    protected void a(String s1, ValueCallback valuecallback)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (m()) goto _L2; else goto _L1
_L1:
        evaluateJavascript(s1, valuecallback);
_L4:
        return;
_L2:
        com.google.android.gms.ads.internal.util.client.b.e("The webview is destroyed. Ignoring action.");
        if (valuecallback == null) goto _L4; else goto _L3
_L3:
        valuecallback.onReceiveValue(null);
          goto _L4
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public void a(String s1, Map map)
    {
        try
        {
            map = com.google.android.gms.ads.internal.c.c().a(map);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.ads.internal.util.client.b.e("Could not convert parameters to JSON.");
            return;
        }
        a(s1, ((JSONObject) (map)));
    }

    public void a(String s1, JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            jsonobject = new JSONObject();
        }
        StringBuilder stringbuilder;
        if (!(jsonobject instanceof JSONObject))
        {
            jsonobject = jsonobject.toString();
        } else
        {
            jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        stringbuilder = new StringBuilder();
        stringbuilder.append("AFMA_ReceiveMessage('");
        stringbuilder.append(s1);
        stringbuilder.append("'");
        stringbuilder.append(",");
        stringbuilder.append(jsonobject);
        stringbuilder.append(");");
        com.google.android.gms.ads.internal.util.client.b.d((new StringBuilder()).append("Dispatching AFMA event: ").append(stringbuilder.toString()).toString());
        c(stringbuilder.toString());
    }

    public void a(boolean flag)
    {
        synchronized (d)
        {
            k = flag;
            u();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b()
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put("version", f.b);
        a("onshow", hashmap);
    }

    public void b(com.google.android.gms.ads.internal.overlay.c c1)
    {
        synchronized (d)
        {
            p = c1;
        }
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    protected void b(String s1)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (m())
        {
            break MISSING_BLOCK_LABEL_22;
        }
        loadUrl(s1);
_L2:
        return;
        com.google.android.gms.ads.internal.util.client.b.e("The webview is destroyed. Ignoring action.");
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public void b(boolean flag)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        g.a(b.b(), flag);
_L2:
        return;
        i = flag;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Activity c()
    {
        return c.a();
    }

    protected void c(String s1)
    {
        if (dj.e())
        {
            if (q() == null)
            {
                s();
            }
            if (q().booleanValue())
            {
                a(s1, ((ValueCallback) (null)));
                return;
            } else
            {
                b((new StringBuilder()).append("javascript:").append(s1).toString());
                return;
            }
        } else
        {
            b((new StringBuilder()).append("javascript:").append(s1).toString());
            return;
        }
    }

    public Context d()
    {
        return c.b();
    }

    public void destroy()
    {
label0:
        {
            synchronized (d)
            {
                t();
                if (g != null)
                {
                    g.a();
                    g.k();
                    g = null;
                }
                b.f();
                if (!j)
                {
                    break label0;
                }
            }
            return;
        }
        com.google.android.gms.ads.internal.c.k().a(this);
        j = true;
        com.google.android.gms.ads.internal.util.client.b.d("Initiating WebView self destruct sequence in 3...");
        b.c();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public com.google.android.gms.ads.internal.overlay.c e()
    {
        com.google.android.gms.ads.internal.overlay.c c1;
        synchronized (d)
        {
            c1 = g;
        }
        return c1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void evaluateJavascript(String s1, ValueCallback valuecallback)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (!m())
        {
            break MISSING_BLOCK_LABEL_34;
        }
        com.google.android.gms.ads.internal.util.client.b.e("The webview is destroyed. Ignoring action.");
        if (valuecallback == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        valuecallback.onReceiveValue(null);
        obj;
        JVM INSTR monitorexit ;
        return;
        super.evaluateJavascript(s1, valuecallback);
        obj;
        JVM INSTR monitorexit ;
        return;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public com.google.android.gms.ads.internal.overlay.c f()
    {
        com.google.android.gms.ads.internal.overlay.c c1;
        synchronized (d)
        {
            c1 = p;
        }
        return c1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public AdSizeParcel g()
    {
        AdSizeParcel adsizeparcel;
        synchronized (d)
        {
            adsizeparcel = h;
        }
        return adsizeparcel;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getRequestedOrientation()
    {
        int i1;
        synchronized (d)
        {
            i1 = o;
        }
        return i1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public WebView getWebView()
    {
        return this;
    }

    public ck h()
    {
        return b;
    }

    public boolean i()
    {
        return i;
    }

    public f j()
    {
        return e;
    }

    public VersionInfoParcel k()
    {
        return f;
    }

    public boolean l()
    {
        boolean flag;
        synchronized (d)
        {
            flag = k;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void loadData(String s1, String s2, String s3)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (m())
        {
            break MISSING_BLOCK_LABEL_27;
        }
        super.loadData(s1, s2, s3);
_L2:
        return;
        com.google.android.gms.ads.internal.util.client.b.e("The webview is destroyed. Ignoring action.");
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public void loadDataWithBaseURL(String s1, String s2, String s3, String s4, String s5)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (m())
        {
            break MISSING_BLOCK_LABEL_31;
        }
        super.loadDataWithBaseURL(s1, s2, s3, s4, s5);
_L2:
        return;
        com.google.android.gms.ads.internal.util.client.b.e("The webview is destroyed. Ignoring action.");
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public void loadUrl(String s1)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (m())
        {
            break MISSING_BLOCK_LABEL_22;
        }
        super.loadUrl(s1);
_L2:
        return;
        com.google.android.gms.ads.internal.util.client.b.e("The webview is destroyed. Ignoring action.");
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public boolean m()
    {
        boolean flag;
        synchronized (d)
        {
            flag = j;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void n()
    {
        synchronized (d)
        {
            com.google.android.gms.ads.internal.util.client.b.d("Destroying WebView!");
            super.destroy();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void o()
    {
        synchronized (d)
        {
            r();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onAttachedToWindow()
    {
        synchronized (d)
        {
            super.onAttachedToWindow();
            if (!m())
            {
                a = true;
                if (b.b())
                {
                    r();
                }
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onDetachedFromWindow()
    {
        synchronized (d)
        {
            if (!m())
            {
                t();
                a = false;
            }
            super.onDetachedFromWindow();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onDownloadStart(String s1, String s2, String s3, String s4, long l1)
    {
        try
        {
            s2 = new Intent("android.intent.action.VIEW");
            s2.setDataAndType(Uri.parse(s1), s4);
            getContext().startActivity(s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s2)
        {
            com.google.android.gms.ads.internal.util.client.b.a((new StringBuilder()).append("Couldn't find an Activity to view url/mimetype: ").append(s1).append(" / ").append(s4).toString());
        }
    }

    protected void onDraw(Canvas canvas)
    {
        while (m() || android.os.Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) 
        {
            return;
        }
        super.onDraw(canvas);
    }

    public void onGlobalLayout()
    {
        boolean flag = p();
        com.google.android.gms.ads.internal.overlay.c c1 = e();
        if (c1 != null && flag)
        {
            c1.o();
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        int l1;
label0:
        {
            l1 = 0x7fffffff;
            synchronized (d)
            {
                if (!m())
                {
                    break label0;
                }
                setMeasuredDimension(0, 0);
            }
            return;
        }
        if (!isInEditMode() && !k)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        super.onMeasure(i1, j1);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (!h.e)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        DisplayMetrics displaymetrics = new DisplayMetrics();
        u.getDefaultDisplay().getMetrics(displaymetrics);
        setMeasuredDimension(displaymetrics.widthPixels, displaymetrics.heightPixels);
        obj;
        JVM INSTR monitorexit ;
        return;
        int k1;
        int i2;
        int j2;
        int k2;
        k2 = android.view.View.MeasureSpec.getMode(i1);
        k1 = android.view.View.MeasureSpec.getSize(i1);
        j2 = android.view.View.MeasureSpec.getMode(j1);
        i2 = android.view.View.MeasureSpec.getSize(j1);
        break MISSING_BLOCK_LABEL_138;
_L4:
        if (h.g <= i1 && h.d <= j1)
        {
            break MISSING_BLOCK_LABEL_306;
        }
        float f1 = c.getResources().getDisplayMetrics().density;
        com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Not enough space to show ad. Needs ").append((int)((float)h.g / f1)).append("x").append((int)((float)h.d / f1)).append(" dp, but only has ").append((int)((float)k1 / f1)).append("x").append((int)((float)i2 / f1)).append(" dp.").toString());
        if (getVisibility() != 8)
        {
            setVisibility(4);
        }
        setMeasuredDimension(0, 0);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        if (getVisibility() != 8)
        {
            setVisibility(0);
        }
        setMeasuredDimension(h.g, h.d);
        if (true) goto _L2; else goto _L1
_L1:
        if (k2 != 0x80000000 && k2 != 0x40000000)
        {
            i1 = 0x7fffffff;
        } else
        {
            i1 = k1;
        }
        if (j2 != 0x80000000)
        {
            j1 = l1;
            if (j2 != 0x40000000)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        j1 = i2;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPause()
    {
        if (m())
        {
            return;
        }
        try
        {
            super.onPause();
            return;
        }
        catch (Exception exception)
        {
            com.google.android.gms.ads.internal.util.client.b.b("Could not pause webview.", exception);
        }
    }

    public void onResume()
    {
        if (m())
        {
            return;
        }
        try
        {
            super.onResume();
            return;
        }
        catch (Exception exception)
        {
            com.google.android.gms.ads.internal.util.client.b.b("Could not resume webview.", exception);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (e != null)
        {
            e.a(motionevent);
        }
        if (m())
        {
            return false;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public boolean p()
    {
        if (h().b())
        {
            DisplayMetrics displaymetrics = com.google.android.gms.ads.internal.c.c().a(u);
            int k1 = com.google.android.gms.ads.internal.client.h.a().b(displaymetrics, displaymetrics.widthPixels);
            int l1 = com.google.android.gms.ads.internal.client.h.a().b(displaymetrics, displaymetrics.heightPixels);
            Activity activity = c();
            int i1;
            int j1;
            if (activity == null || activity.getWindow() == null)
            {
                j1 = l1;
                i1 = k1;
            } else
            {
                int ai[] = com.google.android.gms.ads.internal.c.c().a(activity);
                i1 = com.google.android.gms.ads.internal.client.h.a().b(displaymetrics, ai[0]);
                j1 = com.google.android.gms.ads.internal.client.h.a().b(displaymetrics, ai[1]);
            }
            if (r != k1 || q != l1 || s != i1 || t != j1)
            {
                boolean flag;
                if (r != k1 || q != l1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                r = k1;
                q = l1;
                s = i1;
                t = j1;
                (new be(this)).a(k1, l1, i1, j1, displaymetrics.density, u.getDefaultDisplay().getRotation());
                return flag;
            }
        }
        return false;
    }

    Boolean q()
    {
        Boolean boolean1;
        synchronized (d)
        {
            boolean1 = n;
        }
        return boolean1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void r()
    {
        Activity activity = c();
        if (!m && activity != null && a)
        {
            com.google.android.gms.ads.internal.c.c().a(activity, this);
            m = true;
        }
    }

    public void setContext(Context context)
    {
        c.setBaseContext(context);
    }

    public void setRequestedOrientation(int i1)
    {
        synchronized (d)
        {
            o = i1;
            if (g != null)
            {
                g.a(o);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void stopLoading()
    {
        if (m())
        {
            return;
        }
        try
        {
            super.stopLoading();
            return;
        }
        catch (Exception exception)
        {
            com.google.android.gms.ads.internal.util.client.b.b("Could not stop loading webview.", exception);
        }
    }
}
