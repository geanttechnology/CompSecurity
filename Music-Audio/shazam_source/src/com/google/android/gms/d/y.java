// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            gu, w, gb, ct, 
//            gn, gm, aa, ii, 
//            ce, v, ae, he

public final class y
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnScrollChangedListener
{

    final Object a = new Object();
    final Context b;
    aa c;
    BroadcastReceiver d;
    final HashSet e = new HashSet();
    final ce f = new ce() {

        final y a;

        public final void a(he he1, Map map)
        {
            if (!a.a(map))
            {
                return;
            } else
            {
                map = a;
                he1.getWebView();
                map.c();
                return;
            }
        }

            
            {
                a = y.this;
                super();
            }
    };
    final ce g = new ce() {

        final y a;

        public final void a(he he, Map map)
        {
            if (!a.a(map))
            {
                return;
            } else
            {
                (new StringBuilder("Received request to untrack: ")).append(com.google.android.gms.d.y.b(a).c);
                com.google.android.gms.ads.internal.util.client.b.a(3);
                a.a();
                return;
            }
        }

            
            {
                a = y.this;
                super();
            }
    };
    final ce h = new ce() {

        final y a;

        public final void a(he he, Map map)
        {
            if (a.a(map) && map.containsKey("isVisible"))
            {
                boolean flag;
                if ("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible")))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                he = a;
                flag = Boolean.valueOf(flag).booleanValue();
                he = ((y) (he)).e.iterator();
                while (he.hasNext()) 
                {
                    ((v)he.next()).a(flag);
                }
            }
        }

            
            {
                a = y.this;
                super();
            }
    };
    private final WeakReference i;
    private WeakReference j;
    private final WeakReference k;
    private final w l;
    private final ct m;
    private final ct.d n;
    private boolean o;
    private final WindowManager p;
    private final PowerManager q;
    private final KeyguardManager r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private gu x;

    public y(AdSizeParcel adsizeparcel, gb gb1, VersionInfoParcel versioninfoparcel, View view, ct ct1)
    {
        t = false;
        u = false;
        m = ct1;
        i = new WeakReference(gb1);
        k = new WeakReference(view);
        j = new WeakReference(null);
        v = true;
        x = new gu(200L);
        l = new w(UUID.randomUUID().toString(), versioninfoparcel, adsizeparcel.b, gb1.j, gb1.a());
        n = m.b();
        p = (WindowManager)view.getContext().getSystemService("window");
        q = (PowerManager)view.getContext().getApplicationContext().getSystemService("power");
        r = (KeyguardManager)view.getContext().getSystemService("keyguard");
        b = view.getContext().getApplicationContext();
        try
        {
            adsizeparcel = a(view);
            n.a(new hc.c(adsizeparcel) {

                final JSONObject a;
                final y b;

                public final void a(Object obj)
                {
                    b.a(a);
                }

            
            {
                b = y.this;
                a = jsonobject;
                super();
            }
            }, new hc.a() {

                final y a;

                public final void a()
                {
                }

            
            {
                a = y.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (AdSizeParcel adsizeparcel) { }
        // Misplaced declaration of an exception variable
        catch (AdSizeParcel adsizeparcel)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Failure while processing active view data.", adsizeparcel);
        }
        n.a(new hc.c() {

            final y a;

            public final void a(Object obj)
            {
                y y1;
                obj = (ae)obj;
                y.a(a);
                y1 = a;
                ((ae) (obj)).a("/updateActiveView", y1.f);
                ((ae) (obj)).a("/untrackActiveViewUnit", y1.g);
                ((ae) (obj)).a("/visibilityChanged", y1.h);
                y1 = a;
                obj = y1.a;
                obj;
                JVM INSTR monitorenter ;
                if (y1.d == null) goto _L2; else goto _L1
_L1:
                a.a(false);
                return;
_L2:
                IntentFilter intentfilter = new IntentFilter();
                intentfilter.addAction("android.intent.action.SCREEN_ON");
                intentfilter.addAction("android.intent.action.SCREEN_OFF");
                y1.d = y1. new BroadcastReceiver() {

                    final y a;

                    public final void onReceive(Context context, Intent intent)
                    {
                        a.a(false);
                    }

            
            {
                a = y.this;
                super();
            }
                };
                y1.b.registerReceiver(y1.d, intentfilter);
                obj;
                JVM INSTR monitorexit ;
                if (true) goto _L1; else goto _L3
_L3:
                Exception exception;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = y.this;
                super();
            }
        }, new hc.a() {

            final y a;

            public final void a()
            {
                a.a();
            }

            
            {
                a = y.this;
                super();
            }
        });
        (new StringBuilder("Tracking ad unit: ")).append(l.c);
        com.google.android.gms.ads.internal.util.client.b.a(3);
    }

    private static int a(int i1, DisplayMetrics displaymetrics)
    {
        float f1 = displaymetrics.density;
        return (int)((float)i1 / f1);
    }

    private JSONObject a(View view)
    {
        boolean flag = com.google.android.gms.ads.internal.p.g().a(view);
        int ai1[] = new int[2];
        int ai[] = new int[2];
        Object obj;
        Rect rect;
        JSONObject jsonobject;
        Rect rect1;
        Rect rect2;
        Rect rect3;
        Rect rect4;
        boolean flag1;
        boolean flag2;
        try
        {
            view.getLocationOnScreen(ai1);
            view.getLocationInWindow(ai);
        }
        catch (Exception exception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Failure getting view location.", exception);
        }
        obj = view.getContext().getResources().getDisplayMetrics();
        rect = new Rect();
        rect.left = ai1[0];
        rect.top = ai1[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        rect1 = new Rect();
        rect1.right = p.getDefaultDisplay().getWidth();
        rect1.bottom = p.getDefaultDisplay().getHeight();
        rect2 = new Rect();
        flag1 = view.getGlobalVisibleRect(rect2, null);
        rect3 = new Rect();
        flag2 = view.getLocalVisibleRect(rect3);
        rect4 = new Rect();
        view.getHitRect(rect4);
        jsonobject = j();
        obj = jsonobject.put("windowVisibility", view.getWindowVisibility()).put("isStopped", u).put("isPaused", t).put("isAttachedToWindow", flag).put("viewBox", (new JSONObject()).put("top", a(rect1.top, ((DisplayMetrics) (obj)))).put("bottom", a(rect1.bottom, ((DisplayMetrics) (obj)))).put("left", a(rect1.left, ((DisplayMetrics) (obj)))).put("right", a(rect1.right, ((DisplayMetrics) (obj))))).put("adBox", (new JSONObject()).put("top", a(rect.top, ((DisplayMetrics) (obj)))).put("bottom", a(rect.bottom, ((DisplayMetrics) (obj)))).put("left", a(rect.left, ((DisplayMetrics) (obj)))).put("right", a(rect.right, ((DisplayMetrics) (obj))))).put("globalVisibleBox", (new JSONObject()).put("top", a(rect2.top, ((DisplayMetrics) (obj)))).put("bottom", a(rect2.bottom, ((DisplayMetrics) (obj)))).put("left", a(rect2.left, ((DisplayMetrics) (obj)))).put("right", a(rect2.right, ((DisplayMetrics) (obj))))).put("globalVisibleBoxVisible", flag1).put("localVisibleBox", (new JSONObject()).put("top", a(rect3.top, ((DisplayMetrics) (obj)))).put("bottom", a(rect3.bottom, ((DisplayMetrics) (obj)))).put("left", a(rect3.left, ((DisplayMetrics) (obj)))).put("right", a(rect3.right, ((DisplayMetrics) (obj))))).put("localVisibleBoxVisible", flag2).put("hitBox", (new JSONObject()).put("top", a(rect4.top, ((DisplayMetrics) (obj)))).put("bottom", a(rect4.bottom, ((DisplayMetrics) (obj)))).put("left", a(rect4.left, ((DisplayMetrics) (obj)))).put("right", a(rect4.right, ((DisplayMetrics) (obj))))).put("screenDensity", ((DisplayMetrics) (obj)).density);
        if (view.getVisibility() == 0 && view.isShown() && q.isScreenOn() && (!r.inKeyguardRestrictedInputMode() || com.google.android.gms.ads.internal.p.e().b))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((JSONObject) (obj)).put("isVisible", flag);
        return jsonobject;
    }

    static boolean a(y y1)
    {
        y1.o = true;
        return true;
    }

    static w b(y y1)
    {
        return y1.l;
    }

    private void h()
    {
        if (c != null)
        {
            c.a(this);
        }
    }

    private void i()
    {
        ViewTreeObserver viewtreeobserver = (ViewTreeObserver)j.get();
        if (viewtreeobserver == null || !viewtreeobserver.isAlive())
        {
            return;
        } else
        {
            viewtreeobserver.removeOnScrollChangedListener(this);
            viewtreeobserver.removeGlobalOnLayoutListener(this);
            return;
        }
    }

    private JSONObject j()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("afmaVersion", l.d).put("activeViewJSON", l.b).put("timestamp", com.google.android.gms.ads.internal.p.i().b()).put("adFormat", l.a).put("hashCode", l.c).put("isMraid", l.e);
        return jsonobject;
    }

    protected final void a()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        i();
        synchronized (a)
        {
            if (d != null)
            {
                b.unregisterReceiver(d);
                d = null;
            }
        }
        v = false;
        h();
        n.a();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(v v1)
    {
        e.add(v1);
    }

    protected final void a(JSONObject jsonobject)
    {
        try
        {
            JSONArray jsonarray = new JSONArray();
            JSONObject jsonobject1 = new JSONObject();
            jsonarray.put(jsonobject);
            jsonobject1.put("units", jsonarray);
            n.a(new hc.c(jsonobject1) {

                final JSONObject a;
                final y b;

                public final void a(Object obj)
                {
                    ((ae)obj).a("AFMA_updateActiveView", a);
                }

            
            {
                b = y.this;
                a = jsonobject;
                super();
            }
            }, new hc.b());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Skipping active view message.", jsonobject);
        }
    }

    protected final void a(boolean flag)
    {
label0:
        {
            synchronized (a)
            {
                if (o && v)
                {
                    break label0;
                }
            }
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        if (x.a())
        {
            break MISSING_BLOCK_LABEL_46;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj1;
        Object obj2;
        obj1 = (gb)i.get();
        obj2 = (View)k.get();
        JSONException jsonexception;
        boolean flag1;
        if (obj2 != null && obj1 != null)
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        b();
        obj;
        JVM INSTR monitorexit ;
        return;
        a(a(((View) (obj2))));
_L1:
        obj2 = (View)k.get();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        obj1 = (ViewTreeObserver)j.get();
        obj2 = ((View) (obj2)).getViewTreeObserver();
        if (obj2 == obj1)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        i();
        if (!s)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        if (!((ViewTreeObserver) (obj1)).isAlive())
        {
            break MISSING_BLOCK_LABEL_189;
        }
        s = true;
        ((ViewTreeObserver) (obj2)).addOnScrollChangedListener(this);
        ((ViewTreeObserver) (obj2)).addOnGlobalLayoutListener(this);
        j = new WeakReference(obj2);
        h();
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        com.google.android.gms.ads.internal.util.client.b.a(3);
          goto _L1
        jsonexception;
          goto _L2
        RuntimeException runtimeexception;
        runtimeexception;
          goto _L2
    }

    protected final boolean a(Map map)
    {
        if (map == null)
        {
            return false;
        }
        map = (String)map.get("hashCode");
        return !TextUtils.isEmpty(map) && map.equals(l.c);
    }

    public final void b()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (!v) goto _L2; else goto _L1
_L1:
        w = true;
        JSONObject jsonobject = j();
        jsonobject.put("doneReasonCode", "u");
        a(jsonobject);
_L3:
        (new StringBuilder("Untracking ad unit: ")).append(l.c);
        com.google.android.gms.ads.internal.util.client.b.a(3);
_L2:
        return;
        Object obj1;
        obj1;
        com.google.android.gms.ads.internal.util.client.b.a("JSON failure while processing active view data.", ((Throwable) (obj1)));
          goto _L3
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        com.google.android.gms.ads.internal.util.client.b.a("Failure while processing active view data.", ((Throwable) (obj1)));
          goto _L3
    }

    protected final void c()
    {
        a(false);
    }

    public final boolean d()
    {
        boolean flag;
        synchronized (a)
        {
            flag = v;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void e()
    {
        synchronized (a)
        {
            u = true;
            a(false);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void f()
    {
        synchronized (a)
        {
            t = true;
            a(false);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void g()
    {
        synchronized (a)
        {
            t = false;
            a(false);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onGlobalLayout()
    {
        a(false);
    }

    public final void onScrollChanged()
    {
        a(true);
    }
}
