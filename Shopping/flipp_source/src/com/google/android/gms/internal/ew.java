// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            cu, ej, eo, fk, 
//            fn, ez, fc, ex, 
//            x, et, jg, cd

public final class ew extends WebView
    implements DownloadListener
{

    final ez a;
    final Object b = new Object();
    final jg c;
    final cu d;
    cd e;
    private final ex f;
    private x g;
    private boolean h;
    private boolean i;

    private ew(ex ex1, x x1, boolean flag, boolean flag1, jg jg1, cu cu1)
    {
        super(ex1);
        f = ex1;
        g = x1;
        h = flag;
        c = jg1;
        d = cu1;
        setBackgroundColor(0);
        x1 = getSettings();
        x1.setJavaScriptEnabled(true);
        x1.setSavePassword(false);
        x1.setSupportMultipleWindows(true);
        x1.setJavaScriptCanOpenWindowsAutomatically(true);
        ej.a(ex1, cu1.b, x1);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            eo.a(getContext(), x1);
            x1.setMediaPlaybackRequiresUserGesture(false);
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            eo.a(getContext(), x1);
        }
        setDownloadListener(this);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new fk(this, flag1);
        } else
        {
            a = new ez(this, flag1);
        }
        setWebViewClient(a);
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            setWebChromeClient(new fn(this));
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            setWebChromeClient(new fc(this));
        }
        e();
    }

    public static ew a(Context context, x x1, boolean flag, boolean flag1, jg jg1, cu cu1)
    {
        return new ew(new ex(context), x1, flag, flag1, jg1, cu1);
    }

    private void e()
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        if (!h && !g.e) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 14) goto _L4; else goto _L3
_L3:
        et.a("Disabling hardware acceleration on an overlay.");
        f();
_L5:
        return;
_L4:
        et.a("Enabling hardware acceleration on an overlay.");
        g();
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
            et.a("Disabling hardware acceleration on an AdView.");
            f();
        }
          goto _L5
        et.a("Enabling hardware acceleration on an AdView.");
        g();
          goto _L5
    }

    private void f()
    {
        synchronized (b)
        {
            if (!i && android.os.Build.VERSION.SDK_INT >= 11)
            {
                setLayerType(1, null);
            }
            i = true;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void g()
    {
        synchronized (b)
        {
            if (i && android.os.Build.VERSION.SDK_INT >= 11)
            {
                setLayerType(0, null);
            }
            i = false;
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
        hashmap.put("version", d.b);
        a("onshow", ((Map) (hashmap)));
    }

    public final void a(Context context, x x1)
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        f.setBaseContext(context);
        e = null;
        g = x1;
        h = false;
        ej.b(this);
        loadUrl("about:blank");
        x1 = a;
        synchronized (((ez) (x1)).c)
        {
            ((ez) (x1)).b.clear();
            x1.d = null;
            x1.e = null;
            x1.f = null;
            x1.g = null;
            x1.h = false;
            x1.i = false;
            x1.j = null;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        x1;
        context;
        JVM INSTR monitorexit ;
        throw x1;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public final void a(x x1)
    {
        synchronized (b)
        {
            g = x1;
            requestLayout();
        }
        return;
        x1;
        obj;
        JVM INSTR monitorexit ;
        throw x1;
    }

    public final void a(String s, Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("javascript:AFMA_ReceiveMessage('");
        stringbuilder.append(s);
        stringbuilder.append("'");
        if (map != null)
        {
            try
            {
                s = ej.a(map).toString();
                stringbuilder.append(",");
                stringbuilder.append(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                et.d("Could not convert AFMA event parameters to JSON.");
                return;
            }
        }
        stringbuilder.append(");");
        et.c((new StringBuilder("Dispatching AFMA event: ")).append(stringbuilder).toString());
        loadUrl(stringbuilder.toString());
    }

    public final void a(boolean flag)
    {
        synchronized (b)
        {
            h = flag;
            e();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final cd b()
    {
        cd cd;
        synchronized (b)
        {
            cd = e;
        }
        return cd;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final x c()
    {
        x x1;
        synchronized (b)
        {
            x1 = g;
        }
        return x1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean d()
    {
        boolean flag;
        synchronized (b)
        {
            flag = h;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onDownloadStart(String s, String s1, String s2, String s3, long l)
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
            et.a((new StringBuilder("Couldn't find an Activity to view url/mimetype: ")).append(s).append(" / ").append(s3).toString());
        }
    }

    protected final void onMeasure(int j, int k)
    {
        int i1;
label0:
        {
            i1 = 0x7fffffff;
            synchronized (b)
            {
                if (!isInEditMode() && !h)
                {
                    break label0;
                }
                super.onMeasure(j, k);
            }
            return;
        }
        int l;
        int j1;
        int k1;
        int l1;
        l1 = android.view.View.MeasureSpec.getMode(j);
        l = android.view.View.MeasureSpec.getSize(j);
        k1 = android.view.View.MeasureSpec.getMode(k);
        j1 = android.view.View.MeasureSpec.getSize(k);
        break MISSING_BLOCK_LABEL_59;
_L3:
        if (g.g <= j && g.d <= k)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        et.d((new StringBuilder("Not enough space to show ad. Needs ")).append(g.g).append("x").append(g.d).append(" pixels, but only has ").append(l).append("x").append(j1).append(" pixels.").toString());
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
        if (l1 != 0x80000000 && l1 != 0x40000000)
        {
            j = 0x7fffffff;
        } else
        {
            j = l;
        }
        if (k1 != 0x80000000)
        {
            k = i1;
            if (k1 != 0x40000000)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        k = j1;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (c != null)
        {
            c.a(motionevent);
        }
        return super.onTouchEvent(motionevent);
    }

    public final void setContext(Context context)
    {
        f.setBaseContext(context);
    }
}
