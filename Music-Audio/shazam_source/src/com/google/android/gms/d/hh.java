// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.overlay.d;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            he, gm, gn, io, 
//            hi, gw, gd, hf, 
//            eb, co, o, k

public final class hh extends WebView
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, he
{
    public static final class a extends MutableContextWrapper
    {

        Activity a;
        Context b;
        private Context c;

        public final Object getSystemService(String s1)
        {
            return b.getSystemService(s1);
        }

        public final void setBaseContext(Context context)
        {
            c = context.getApplicationContext();
            Activity activity;
            if (context instanceof Activity)
            {
                activity = (Activity)context;
            } else
            {
                activity = null;
            }
            a = activity;
            b = context;
            super.setBaseContext(c);
        }

        public final void startActivity(Intent intent)
        {
            if (a != null && !com.google.android.gms.d.io.a(21))
            {
                a.startActivity(intent);
                return;
            } else
            {
                intent.setFlags(0x10000000);
                c.startActivity(intent);
                return;
            }
        }

        public a(Context context)
        {
            super(context);
            setBaseContext(context);
        }
    }


    private final hf a;
    private final a b;
    private final Object c = new Object();
    private final o d;
    private final VersionInfoParcel e;
    private final com.google.android.gms.ads.internal.d f;
    private d g;
    private AdSizeParcel h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private Boolean m;
    private int n;
    private boolean o;
    private String p;
    private String q;
    private d r;
    private gw s;
    private int t;
    private int u;
    private int v;
    private int w;
    private Map x;
    private final WindowManager y = (WindowManager)getContext().getSystemService("window");

    private hh(a a1, AdSizeParcel adsizeparcel, boolean flag, boolean flag1, o o1, VersionInfoParcel versioninfoparcel, com.google.android.gms.ads.internal.d d1)
    {
        super(a1);
        o = true;
        p = "";
        t = -1;
        u = -1;
        v = -1;
        w = -1;
        b = a1;
        h = adsizeparcel;
        k = flag;
        n = -1;
        d = o1;
        e = versioninfoparcel;
        f = d1;
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
        adsizeparcel.setUserAgentString(com.google.android.gms.ads.internal.p.e().a(a1, versioninfoparcel.b));
        com.google.android.gms.ads.internal.p.g().a(getContext(), adsizeparcel);
        setDownloadListener(this);
        a = com.google.android.gms.ads.internal.p.g().a(this, flag1);
        setWebViewClient(a);
        setWebChromeClient(com.google.android.gms.ads.internal.p.g().a(this));
        u();
        if (com.google.android.gms.d.io.a(17))
        {
            addJavascriptInterface(new hi(this), "googleAdsJsInterface");
        }
        s = new gw(b.a, this, null);
    }

    static hh a(Context context, AdSizeParcel adsizeparcel, boolean flag, boolean flag1, o o1, VersionInfoParcel versioninfoparcel, com.google.android.gms.ads.internal.d d1)
    {
        return new hh(new a(context), adsizeparcel, flag, flag1, o1, versioninfoparcel, d1);
    }

    static void a(hh hh1)
    {
        hh1.WebView.destroy();
    }

    private void a(Boolean boolean1)
    {
        m = boolean1;
        gd gd1 = com.google.android.gms.ads.internal.p.h();
        synchronized (gd1.a)
        {
            gd1.g = boolean1;
        }
        return;
        boolean1;
        obj;
        JVM INSTR monitorexit ;
        throw boolean1;
    }

    private void d(String s1)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (n())
        {
            break MISSING_BLOCK_LABEL_22;
        }
        loadUrl(s1);
_L2:
        return;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    private void e(String s1)
    {
        if (!com.google.android.gms.d.io.a(19))
        {
            break MISSING_BLOCK_LABEL_144;
        }
        if (t() != null) goto _L2; else goto _L1
_L1:
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        Boolean boolean1;
        m = com.google.android.gms.ads.internal.p.h().g();
        boolean1 = m;
        if (boolean1 != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        evaluateJavascript("(function(){})()", null);
        a(Boolean.valueOf(true));
_L3:
        obj;
        JVM INSTR monitorexit ;
_L2:
        if (!t().booleanValue())
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (n())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        evaluateJavascript(s1, null);
_L4:
        return;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        a(Boolean.valueOf(false));
          goto _L3
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
        com.google.android.gms.ads.internal.util.client.b.a(5);
          goto _L4
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
        d((new StringBuilder("javascript:")).append(s1).toString());
        return;
        d((new StringBuilder("javascript:")).append(s1).toString());
        return;
          goto _L3
    }

    private boolean s()
    {
        if (a.a())
        {
            com.google.android.gms.ads.internal.p.e();
            DisplayMetrics displaymetrics = com.google.android.gms.d.gm.a(y);
            com.google.android.gms.ads.internal.client.m.a();
            int k1 = com.google.android.gms.ads.internal.util.client.a.b(displaymetrics, displaymetrics.widthPixels);
            com.google.android.gms.ads.internal.client.m.a();
            int l1 = com.google.android.gms.ads.internal.util.client.a.b(displaymetrics, displaymetrics.heightPixels);
            Activity activity = b.a;
            int i1;
            int j1;
            if (activity == null || activity.getWindow() == null)
            {
                j1 = l1;
                i1 = k1;
            } else
            {
                com.google.android.gms.ads.internal.p.e();
                int ai[] = com.google.android.gms.d.gm.a(activity);
                com.google.android.gms.ads.internal.client.m.a();
                i1 = com.google.android.gms.ads.internal.util.client.a.b(displaymetrics, ai[0]);
                com.google.android.gms.ads.internal.client.m.a();
                j1 = com.google.android.gms.ads.internal.util.client.a.b(displaymetrics, ai[1]);
            }
            if (u != k1 || t != l1 || v != i1 || w != j1)
            {
                boolean flag;
                if (u != k1 || t != l1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                u = k1;
                t = l1;
                v = i1;
                w = j1;
                (new eb(this)).a(k1, l1, i1, j1, displaymetrics.density, y.getDefaultDisplay().getRotation());
                return flag;
            }
        }
        return false;
    }

    private Boolean t()
    {
        Boolean boolean1;
        synchronized (c)
        {
            boolean1 = m;
        }
        return boolean1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void u()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (!k && !h.e) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 14) goto _L4; else goto _L3
_L3:
        com.google.android.gms.ads.internal.util.client.b.a(3);
        v();
_L5:
        return;
_L4:
        com.google.android.gms.ads.internal.util.client.b.a(3);
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
            com.google.android.gms.ads.internal.util.client.b.a(3);
            v();
        }
          goto _L5
        com.google.android.gms.ads.internal.util.client.b.a(3);
        w();
          goto _L5
    }

    private void v()
    {
        synchronized (c)
        {
            if (!l)
            {
                com.google.android.gms.ads.internal.p.g().c(this);
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
        synchronized (c)
        {
            if (l)
            {
                com.google.android.gms.ads.internal.p.g().b(this);
            }
            l = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a()
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put("version", e.b);
        a("onhide", ((Map) (hashmap)));
    }

    public final void a(int i1)
    {
        HashMap hashmap = new HashMap(2);
        hashmap.put("closetype", String.valueOf(i1));
        hashmap.put("version", e.b);
        a("onhide", ((Map) (hashmap)));
    }

    public final void a(Context context, AdSizeParcel adsizeparcel)
    {
        synchronized (c)
        {
            s.b();
            setContext(context);
            g = null;
            h = adsizeparcel;
            k = false;
            i = false;
            p = "";
            n = -1;
            com.google.android.gms.ads.internal.p.g().b(this);
            loadUrl("about:blank");
            a.d();
            setOnTouchListener(null);
            setOnClickListener(null);
            o = true;
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public final void a(AdSizeParcel adsizeparcel)
    {
        synchronized (c)
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

    public final void a(d d1)
    {
        synchronized (c)
        {
            g = d1;
        }
        return;
        d1;
        obj;
        JVM INSTR monitorexit ;
        throw d1;
    }

    public final void a(String s1)
    {
        synchronized (c)
        {
            super.loadUrl(s1);
        }
        return;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public final void a(String s1, String s2)
    {
        e((new StringBuilder()).append(s1).append("(").append(s2).append(");").toString());
    }

    public final void a(String s1, Map map)
    {
        try
        {
            map = com.google.android.gms.ads.internal.p.e().a(map);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return;
        }
        a(s1, ((JSONObject) (map)));
    }

    public final void a(String s1, JSONObject jsonobject)
    {
        Object obj = jsonobject;
        if (jsonobject == null)
        {
            obj = new JSONObject();
        }
        jsonobject = ((JSONObject) (obj)).toString();
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append("AFMA_ReceiveMessage('");
        ((StringBuilder) (obj)).append(s1);
        ((StringBuilder) (obj)).append("'");
        ((StringBuilder) (obj)).append(",");
        ((StringBuilder) (obj)).append(jsonobject);
        ((StringBuilder) (obj)).append(");");
        (new StringBuilder("Dispatching AFMA event: ")).append(((StringBuilder) (obj)).toString());
        com.google.android.gms.ads.internal.util.client.b.a(2);
        e(((StringBuilder) (obj)).toString());
    }

    public final void a(boolean flag)
    {
        HashMap hashmap = new HashMap();
        String s1;
        if (flag)
        {
            s1 = "1";
        } else
        {
            s1 = "0";
        }
        hashmap.put("isVisible", s1);
        a("onAdVisibilityChanged", ((Map) (hashmap)));
    }

    public final void b()
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put("version", e.b);
        a("onshow", hashmap);
    }

    public final void b(d d1)
    {
        synchronized (c)
        {
            r = d1;
        }
        return;
        d1;
        obj;
        JVM INSTR monitorexit ;
        throw d1;
    }

    public final void b(String s1)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        String s2;
        s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        p = s2;
        obj;
        JVM INSTR monitorexit ;
        return;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public final void b(String s1, JSONObject jsonobject)
    {
        JSONObject jsonobject1 = jsonobject;
        if (jsonobject == null)
        {
            jsonobject1 = new JSONObject();
        }
        a(s1, jsonobject1.toString());
    }

    public final void b(boolean flag)
    {
        synchronized (c)
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

    public final Activity c()
    {
        return b.a;
    }

    public final void c(String s1)
    {
        synchronized (c)
        {
            q = s1;
        }
        return;
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public final void c(boolean flag)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        g.a(a.a(), flag);
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

    public final Context d()
    {
        return b.b;
    }

    public final void d(boolean flag)
    {
        synchronized (c)
        {
            o = flag;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void destroy()
    {
label0:
        {
            synchronized (c)
            {
                s.b();
                if (g != null)
                {
                    g.a();
                    g.k();
                    g = null;
                }
                a.d();
                if (!j)
                {
                    break label0;
                }
            }
            return;
        }
        com.google.android.gms.ads.internal.p.r();
        com.google.android.gms.d.co.a(this);
        obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        if (x != null)
        {
            for (Iterator iterator = x.values().iterator(); iterator.hasNext(); iterator.next()) { }
        }
        break MISSING_BLOCK_LABEL_124;
        Exception exception;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        JVM INSTR monitorexit ;
        j = true;
        com.google.android.gms.ads.internal.util.client.b.a(2);
        a.c();
        obj;
        JVM INSTR monitorexit ;
    }

    public final com.google.android.gms.ads.internal.d e()
    {
        return f;
    }

    public final void evaluateJavascript(String s1, ValueCallback valuecallback)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (!n())
        {
            break MISSING_BLOCK_LABEL_33;
        }
        com.google.android.gms.ads.internal.util.client.b.a(5);
        if (valuecallback == null)
        {
            break MISSING_BLOCK_LABEL_30;
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

    public final d f()
    {
        d d1;
        synchronized (c)
        {
            d1 = g;
        }
        return d1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final d g()
    {
        d d1;
        synchronized (c)
        {
            d1 = r;
        }
        return d1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final String getRequestId()
    {
        String s1;
        synchronized (c)
        {
            s1 = p;
        }
        return s1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final int getRequestedOrientation()
    {
        int i1;
        synchronized (c)
        {
            i1 = n;
        }
        return i1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final WebView getWebView()
    {
        return this;
    }

    public final AdSizeParcel h()
    {
        AdSizeParcel adsizeparcel;
        synchronized (c)
        {
            adsizeparcel = h;
        }
        return adsizeparcel;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final hf i()
    {
        return a;
    }

    public final boolean j()
    {
        return i;
    }

    public final o k()
    {
        return d;
    }

    public final VersionInfoParcel l()
    {
        return e;
    }

    public final void loadData(String s1, String s2, String s3)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (n())
        {
            break MISSING_BLOCK_LABEL_27;
        }
        super.loadData(s1, s2, s3);
_L2:
        return;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public final void loadDataWithBaseURL(String s1, String s2, String s3, String s4, String s5)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (n())
        {
            break MISSING_BLOCK_LABEL_31;
        }
        super.loadDataWithBaseURL(s1, s2, s3, s4, s5);
_L2:
        return;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public final void loadUrl(String s1)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (n())
        {
            break MISSING_BLOCK_LABEL_22;
        }
        super.loadUrl(s1);
_L2:
        return;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        obj;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public final boolean m()
    {
        boolean flag;
        synchronized (c)
        {
            flag = k;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean n()
    {
        boolean flag;
        synchronized (c)
        {
            flag = j;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void o()
    {
        synchronized (c)
        {
            com.google.android.gms.ads.internal.util.client.b.a(2);
            com.google.android.gms.d.gm.a.post(new Runnable() {

                final hh a;

                public final void run()
                {
                    com.google.android.gms.d.hh.a(a);
                }

            
            {
                a = hh.this;
                super();
            }
            });
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected final void onAttachedToWindow()
    {
        synchronized (c)
        {
            super.onAttachedToWindow();
            if (!n())
            {
                s.c();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected final void onDetachedFromWindow()
    {
        synchronized (c)
        {
            if (!n())
            {
                s.d();
            }
            super.onDetachedFromWindow();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onDownloadStart(String s1, String s2, String s3, String s4, long l1)
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
            (new StringBuilder("Couldn't find an Activity to view url/mimetype: ")).append(s1).append(" / ").append(s4);
        }
        com.google.android.gms.ads.internal.util.client.b.a(3);
    }

    protected final void onDraw(Canvas canvas)
    {
        while (n() || android.os.Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) 
        {
            return;
        }
        super.onDraw(canvas);
    }

    public final void onGlobalLayout()
    {
        boolean flag = s();
        d d1 = f();
        if (d1 != null && flag && d1.p)
        {
            d1.p = false;
            d1.m();
        }
    }

    protected final void onMeasure(int i1, int j1)
    {
        int l1;
label0:
        {
            l1 = 0x7fffffff;
            synchronized (c)
            {
                if (!n())
                {
                    break label0;
                }
                setMeasuredDimension(0, 0);
            }
            return;
        }
        if (!isInEditMode() && !k && !h.i)
        {
            break MISSING_BLOCK_LABEL_73;
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
            break MISSING_BLOCK_LABEL_124;
        }
        DisplayMetrics displaymetrics = new DisplayMetrics();
        y.getDefaultDisplay().getMetrics(displaymetrics);
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
        break MISSING_BLOCK_LABEL_148;
_L4:
        if (h.g <= i1 && h.d <= j1)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        float f1 = b.getResources().getDisplayMetrics().density;
        (new StringBuilder("Not enough space to show ad. Needs ")).append((int)((float)h.g / f1)).append("x").append((int)((float)h.d / f1)).append(" dp, but only has ").append((int)((float)k1 / f1)).append("x").append((int)((float)i2 / f1)).append(" dp.");
        com.google.android.gms.ads.internal.util.client.b.a(5);
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

    public final void onPause()
    {
        if (n())
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
            com.google.android.gms.ads.internal.util.client.b.a("Could not pause webview.", exception);
        }
    }

    public final void onResume()
    {
        if (n())
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
            com.google.android.gms.ads.internal.util.client.b.a("Could not resume webview.", exception);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (d != null)
        {
            d.a.a(motionevent);
        }
        if (n())
        {
            return false;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public final boolean p()
    {
        boolean flag;
        synchronized (c)
        {
            flag = o;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void q()
    {
        s.a();
    }

    public final String r()
    {
        String s1;
        synchronized (c)
        {
            s1 = q;
        }
        return s1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void setContext(Context context)
    {
        b.setBaseContext(context);
        s.a = b.a;
    }

    public final void setRequestedOrientation(int i1)
    {
        synchronized (c)
        {
            n = i1;
            if (g != null)
            {
                g.a(n);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void stopLoading()
    {
        if (n())
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
            com.google.android.gms.ads.internal.util.client.b.a("Could not stop loading webview.", exception);
        }
    }
}
