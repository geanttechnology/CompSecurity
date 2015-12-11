// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import abq;
import abv;
import aby;
import acb;
import acd;
import ace;
import acg;
import ach;
import aci;
import aea;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xc;

// Referenced classes of package com.google.android.gms.internal:
//            gs, ay

public class gu extends WebView
    implements DownloadListener
{

    private final ace a;
    private final acd b;
    private final Object c = new Object();
    private final aea d;
    private final gs e;
    private xc f;
    private ay g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private final WindowManager l = (WindowManager)getContext().getSystemService("window");

    protected gu(acd acd1, ay ay1, boolean flag, boolean flag1, aea aea1, gs gs1)
    {
        super(acd1);
        b = acd1;
        g = ay1;
        h = flag;
        d = aea1;
        e = gs1;
        setBackgroundColor(0);
        ay1 = getSettings();
        ay1.setJavaScriptEnabled(true);
        ay1.setSavePassword(false);
        ay1.setSupportMultipleWindows(true);
        ay1.setJavaScriptCanOpenWindowsAutomatically(true);
        abq.a(acd1, gs1.b, ay1);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            aby.a(getContext(), ay1);
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            abv.a(getContext(), ay1);
        }
        setDownloadListener(this);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new ach(this, flag1);
        } else
        {
            a = new ace(this, flag1);
        }
        setWebViewClient(a);
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            setWebChromeClient(new aci(this));
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            setWebChromeClient(new acg(this));
        }
        m();
    }

    public static gu a(Context context, ay ay1, boolean flag, boolean flag1, aea aea1, gs gs1)
    {
        return new gu(new acd(context), ay1, flag, flag1, aea1, gs1);
    }

    private void m()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (!h && !g.e) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 14) goto _L4; else goto _L3
_L3:
        acb.a("Disabling hardware acceleration on an overlay.");
        n();
_L5:
        return;
_L4:
        acb.a("Enabling hardware acceleration on an overlay.");
        o();
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
            acb.a("Disabling hardware acceleration on an AdView.");
            n();
        }
          goto _L5
        acb.a("Enabling hardware acceleration on an AdView.");
        o();
          goto _L5
    }

    private void n()
    {
        synchronized (c)
        {
            if (!i && android.os.Build.VERSION.SDK_INT >= 11)
            {
                abv.a(this);
            }
            i = true;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void o()
    {
        synchronized (c)
        {
            if (i && android.os.Build.VERSION.SDK_INT >= 11)
            {
                abv.b(this);
            }
            i = false;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a()
    {
        if (!f().b())
        {
            return;
        }
        DisplayMetrics displaymetrics = new DisplayMetrics();
        Display display = l.getDefaultDisplay();
        display.getMetrics(displaymetrics);
        int j1 = abq.c(getContext());
        float f1 = 160F / (float)displaymetrics.densityDpi;
        int i1 = Math.round((float)displaymetrics.widthPixels * f1);
        j1 = Math.round((float)(displaymetrics.heightPixels - j1) * f1);
        try
        {
            b("onScreenInfoChanged", (new JSONObject()).put("width", i1).put("height", j1).put("density", displaymetrics.density).put("rotation", display.getRotation()));
            return;
        }
        catch (JSONException jsonexception)
        {
            acb.b("Error occured while obtaining screen information.", jsonexception);
        }
    }

    public void a(Context context, ay ay1)
    {
        synchronized (c)
        {
            b.setBaseContext(context);
            f = null;
            g = ay1;
            h = false;
            k = false;
            abq.b(this);
            loadUrl("about:blank");
            a.d();
            setOnTouchListener(null);
            setOnClickListener(null);
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void a(ay ay1)
    {
        synchronized (c)
        {
            g = ay1;
            requestLayout();
        }
        return;
        ay1;
        obj;
        JVM INSTR monitorexit ;
        throw ay1;
    }

    protected void a(String s)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (l())
        {
            break MISSING_BLOCK_LABEL_22;
        }
        loadUrl(s);
_L2:
        return;
        acb.e("The webview is destroyed. Ignoring action.");
        if (true) goto _L2; else goto _L1
_L1:
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void a(String s, Map map)
    {
        try
        {
            map = abq.a(map);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            acb.e("Could not convert parameters to JSON.");
            return;
        }
        b(s, map);
    }

    public void a(String s, JSONObject jsonobject)
    {
        Object obj = jsonobject;
        if (jsonobject == null)
        {
            obj = new JSONObject();
        }
        jsonobject = ((JSONObject) (obj)).toString();
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append((new StringBuilder()).append("javascript:").append(s).append("(").toString());
        ((StringBuilder) (obj)).append(jsonobject);
        ((StringBuilder) (obj)).append(");");
        a(((StringBuilder) (obj)).toString());
    }

    public void a(xc xc1)
    {
        synchronized (c)
        {
            f = xc1;
        }
        return;
        xc1;
        obj;
        JVM INSTR monitorexit ;
        throw xc1;
    }

    public void a(boolean flag)
    {
        synchronized (c)
        {
            h = flag;
            m();
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
        hashmap.put("version", e.b);
        a("onhide", hashmap);
    }

    public void b(String s, JSONObject jsonobject)
    {
        Object obj = jsonobject;
        if (jsonobject == null)
        {
            obj = new JSONObject();
        }
        jsonobject = ((JSONObject) (obj)).toString();
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append("javascript:AFMA_ReceiveMessage('");
        ((StringBuilder) (obj)).append(s);
        ((StringBuilder) (obj)).append("'");
        ((StringBuilder) (obj)).append(",");
        ((StringBuilder) (obj)).append(jsonobject);
        ((StringBuilder) (obj)).append(");");
        acb.d((new StringBuilder()).append("Dispatching AFMA event: ").append(obj).toString());
        a(((StringBuilder) (obj)).toString());
    }

    public void b(boolean flag)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (f == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        f.b(flag);
_L2:
        return;
        k = flag;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c()
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put("version", e.b);
        a("onshow", hashmap);
    }

    public xc d()
    {
        xc xc1;
        synchronized (c)
        {
            xc1 = f;
        }
        return xc1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void destroy()
    {
        synchronized (c)
        {
            if (f != null)
            {
                f.a();
            }
            j = true;
            super.destroy();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ay e()
    {
        ay ay1;
        synchronized (c)
        {
            ay1 = g;
        }
        return ay1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void evaluateJavascript(String s, ValueCallback valuecallback)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        if (!l())
        {
            break MISSING_BLOCK_LABEL_34;
        }
        acb.e("The webview is destroyed. Ignoring action.");
        if (valuecallback == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        valuecallback.onReceiveValue(null);
        obj;
        JVM INSTR monitorexit ;
        return;
        super.evaluateJavascript(s, valuecallback);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public ace f()
    {
        return a;
    }

    public boolean g()
    {
        return k;
    }

    public aea h()
    {
        return d;
    }

    public gs i()
    {
        return e;
    }

    public boolean j()
    {
        boolean flag;
        synchronized (c)
        {
            flag = h;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Context k()
    {
        return b.a();
    }

    public boolean l()
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

    public void onDownloadStart(String s, String s1, String s2, String s3, long l1)
    {
        try
        {
            s1 = new Intent("android.intent.action.VIEW");
            s1.setDataAndType(Uri.parse(s), s3);
            getContext().startActivity(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            acb.a((new StringBuilder()).append("Couldn't find an Activity to view url/mimetype: ").append(s).append(" / ").append(s3).toString());
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        int l1;
label0:
        {
            l1 = 0x7fffffff;
            synchronized (c)
            {
                if (!isInEditMode() && !h)
                {
                    break label0;
                }
                super.onMeasure(i1, j1);
            }
            return;
        }
        int k1;
        int i2;
        int j2;
        int k2;
        k2 = android.view.View.MeasureSpec.getMode(i1);
        k1 = android.view.View.MeasureSpec.getSize(i1);
        j2 = android.view.View.MeasureSpec.getMode(j1);
        i2 = android.view.View.MeasureSpec.getSize(j1);
        break MISSING_BLOCK_LABEL_62;
_L3:
        if (g.g <= i1 && g.d <= j1)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        float f1 = b.getResources().getDisplayMetrics().density;
        acb.e((new StringBuilder()).append("Not enough space to show ad. Needs ").append((int)((float)g.g / f1)).append("x").append((int)((float)g.d / f1)).append(" dp, but only has ").append((int)((float)k1 / f1)).append("x").append((int)((float)i2 / f1)).append(" dp.").toString());
        if (getVisibility() != 8)
        {
            setVisibility(4);
        }
        setMeasuredDimension(0, 0);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (getVisibility() != 8)
        {
            setVisibility(0);
        }
        setMeasuredDimension(g.g, g.d);
          goto _L1
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
        if (true) goto _L3; else goto _L2
_L2:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (d != null)
        {
            d.a(motionevent);
        }
        return super.onTouchEvent(motionevent);
    }

    public void setContext(Context context)
    {
        b.setBaseContext(context);
    }
}
