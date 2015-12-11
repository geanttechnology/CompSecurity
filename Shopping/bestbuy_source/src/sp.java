// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

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
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class sp
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnScrollChangedListener
{

    private final Object a;
    private final WeakReference b;
    private WeakReference c;
    private final WeakReference d;
    private final sn e;
    private final Context f;
    private final sr g;
    private boolean h;
    private final WindowManager i;
    private final PowerManager j;
    private final KeyguardManager k;
    private sq l;
    private boolean m;
    private boolean n;
    private final BlockingQueue o;
    private long p;
    private boolean q;
    private boolean r;
    private BroadcastReceiver s;
    private final HashSet t;

    public sp(Context context, ay ay1, abd abd1, View view, gs gs)
    {
        this(ay1, abd1, gs, view, ((sr) (new su(context, gs))));
    }

    public sp(ay ay1, abd abd1, gs gs, View view, sr sr1)
    {
        a = new Object();
        m = false;
        n = false;
        o = new ArrayBlockingQueue(2);
        p = 0x8000000000000000L;
        t = new HashSet();
        b = new WeakReference(abd1);
        d = new WeakReference(view);
        c = new WeakReference(null);
        q = true;
        e = new sn(UUID.randomUUID().toString(), gs, ay1.b, abd1.j);
        g = sr1;
        i = (WindowManager)view.getContext().getSystemService("window");
        j = (PowerManager)view.getContext().getApplicationContext().getSystemService("power");
        k = (KeyguardManager)view.getContext().getSystemService("keyguard");
        f = view.getContext().getApplicationContext();
        a(sr1);
        g.a(new ss(view) {

            final View a;
            final sp b;

            public void a()
            {
                sp.a(b, true);
                b.a(a);
                b.a();
            }

            
            {
                b = sp.this;
                a = view;
                super();
            }
        });
        b(g);
        try
        {
            ay1 = b(view);
            o.add(new Runnable(ay1) {

                final JSONObject a;
                final sp b;

                public void run()
                {
                    b.a(a);
                }

            
            {
                b = sp.this;
                a = jsonobject;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (ay ay1) { }
        o.add(new Runnable() {

            final sp a;

            public void run()
            {
                a.b(false);
            }

            
            {
                a = sp.this;
                super();
            }
        });
        acb.a((new StringBuilder()).append("Tracking ad unit: ").append(e.d()).toString());
    }

    static sn a(sp sp1)
    {
        return sp1.e;
    }

    static boolean a(sp sp1, boolean flag)
    {
        sp1.h = flag;
        return flag;
    }

    protected int a(int i1, DisplayMetrics displaymetrics)
    {
        float f1 = displaymetrics.density;
        return (int)((float)i1 / f1);
    }

    protected void a()
    {
label0:
        {
            synchronized (a)
            {
                if (s == null)
                {
                    break label0;
                }
            }
            return;
        }
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.SCREEN_ON");
        intentfilter.addAction("android.intent.action.SCREEN_OFF");
        s = new BroadcastReceiver() {

            final sp a;

            public void onReceive(Context context, Intent intent)
            {
                a.b(false);
            }

            
            {
                a = sp.this;
                super();
            }
        };
        f.registerReceiver(s, intentfilter);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void a(View view)
    {
        view = new ArrayList();
        o.drainTo(view);
        for (view = view.iterator(); view.hasNext(); ((Runnable)view.next()).run()) { }
    }

    protected void a(View view, Map map)
    {
        b(false);
    }

    protected void a(JSONObject jsonobject)
    {
        try
        {
            JSONArray jsonarray = new JSONArray();
            JSONObject jsonobject1 = new JSONObject();
            jsonarray.put(jsonobject);
            jsonobject1.put("units", jsonarray);
            g.a("AFMA_updateActiveView", jsonobject1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            acb.b("Skipping active view message.", jsonobject);
        }
    }

    public void a(sm sm1)
    {
        t.add(sm1);
    }

    public void a(sq sq1)
    {
        synchronized (a)
        {
            l = sq1;
        }
        return;
        sq1;
        obj;
        JVM INSTR monitorexit ;
        throw sq1;
    }

    protected void a(sr sr1)
    {
        sr1.a("https://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    protected void a(boolean flag)
    {
        for (Iterator iterator = t.iterator(); iterator.hasNext(); ((sm)iterator.next()).a(this, flag)) { }
    }

    protected boolean a(Map map)
    {
        if (map == null)
        {
            return false;
        }
        map = (String)map.get("hashCode");
        boolean flag;
        if (!TextUtils.isEmpty(map) && map.equals(e.d()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    protected JSONObject b(View view)
    {
        int ai1[] = new int[2];
        int ai[] = new int[2];
        view.getLocationOnScreen(ai1);
        view.getLocationInWindow(ai);
        JSONObject jsonobject = i();
        DisplayMetrics displaymetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = ai1[0];
        rect.top = ai1[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect1 = new Rect();
        rect1.right = i.getDefaultDisplay().getWidth();
        rect1.bottom = i.getDefaultDisplay().getHeight();
        Rect rect2 = new Rect();
        boolean flag = view.getGlobalVisibleRect(rect2, null);
        Rect rect3 = new Rect();
        boolean flag1 = view.getLocalVisibleRect(rect3);
        Rect rect4 = new Rect();
        view.getHitRect(rect4);
        jsonobject.put("viewBox", (new JSONObject()).put("top", a(rect1.top, displaymetrics)).put("bottom", a(rect1.bottom, displaymetrics)).put("left", a(rect1.left, displaymetrics)).put("right", a(rect1.right, displaymetrics))).put("adBox", (new JSONObject()).put("top", a(rect.top, displaymetrics)).put("bottom", a(rect.bottom, displaymetrics)).put("left", a(rect.left, displaymetrics)).put("right", a(rect.right, displaymetrics))).put("globalVisibleBox", (new JSONObject()).put("top", a(rect2.top, displaymetrics)).put("bottom", a(rect2.bottom, displaymetrics)).put("left", a(rect2.left, displaymetrics)).put("right", a(rect2.right, displaymetrics))).put("globalVisibleBoxVisible", flag).put("localVisibleBox", (new JSONObject()).put("top", a(rect3.top, displaymetrics)).put("bottom", a(rect3.bottom, displaymetrics)).put("left", a(rect3.left, displaymetrics)).put("right", a(rect3.right, displaymetrics))).put("localVisibleBoxVisible", flag1).put("hitBox", (new JSONObject()).put("top", a(rect4.top, displaymetrics)).put("bottom", a(rect4.bottom, displaymetrics)).put("left", a(rect4.left, displaymetrics)).put("right", a(rect4.right, displaymetrics))).put("windowVisibility", view.getWindowVisibility()).put("screenDensity", displaymetrics.density).put("isVisible", c(view)).put("isStopped", n).put("isPaused", m);
        if (aej.d())
        {
            jsonobject.put("isAttachedToWindow", view.isAttachedToWindow());
        }
        return jsonobject;
    }

    protected void b()
    {
        synchronized (a)
        {
            if (s != null)
            {
                f.unregisterReceiver(s);
                s = null;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void b(sr sr1)
    {
        sr1.a("/updateActiveView", new vd() {

            final sp a;

            public void a(gu gu, Map map)
            {
                if (!a.a(map))
                {
                    return;
                } else
                {
                    a.a(gu, map);
                    return;
                }
            }

            
            {
                a = sp.this;
                super();
            }
        });
        sr1.a("/untrackActiveViewUnit", new vd() {

            final sp a;

            public void a(gu gu, Map map)
            {
                if (!a.a(map))
                {
                    return;
                } else
                {
                    acb.a((new StringBuilder()).append("Received request to untrack: ").append(sp.a(a).d()).toString());
                    a.c();
                    return;
                }
            }

            
            {
                a = sp.this;
                super();
            }
        });
        sr1.a("/visibilityChanged", new vd() {

            final sp a;

            public void a(gu gu, Map map)
            {
                while (!a.a(map) || !map.containsKey("isVisible")) 
                {
                    return;
                }
                boolean flag;
                if ("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible")))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a.a(Boolean.valueOf(flag).booleanValue());
            }

            
            {
                a = sp.this;
                super();
            }
        });
        sr1.a("/viewabilityChanged", vc.a);
    }

    protected void b(boolean flag)
    {
label0:
        {
            synchronized (a)
            {
                if (h && q)
                {
                    break label0;
                }
            }
            return;
        }
        long l1 = abi.a().b().b();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        if (p + 200L <= l1)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        abd abd1;
        View view;
        p = l1;
        abd1 = (abd)b.get();
        view = (View)d.get();
        JSONException jsonexception;
        boolean flag1;
        if (view != null && abd1 != null)
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        d();
        obj;
        JVM INSTR monitorexit ;
        return;
        a(b(view));
_L1:
        g();
        e();
        obj;
        JVM INSTR monitorexit ;
        return;
        jsonexception;
        acb.a("Active view update failed.", jsonexception);
          goto _L1
    }

    protected void c()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        h();
        b();
        q = false;
        Exception exception;
        try
        {
            g.c();
        }
        catch (Throwable throwable) { }
        e();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean c(View view)
    {
        return view.getVisibility() == 0 && view.isShown() && j.isScreenOn() && !k.inKeyguardRestrictedInputMode();
    }

    public void d()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (!q) goto _L2; else goto _L1
_L1:
        r = true;
        a(j());
_L3:
        acb.a((new StringBuilder()).append("Untracking ad unit: ").append(e.d()).toString());
_L2:
        return;
        Object obj1;
        obj1;
        acb.b("JSON Failure while processing active view data.", ((Throwable) (obj1)));
          goto _L3
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    protected void e()
    {
        if (l != null)
        {
            l.a(this);
        }
    }

    public boolean f()
    {
        boolean flag;
        synchronized (a)
        {
            flag = q;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void g()
    {
        Object obj = (View)d.get();
        if (obj != null)
        {
            ViewTreeObserver viewtreeobserver = (ViewTreeObserver)c.get();
            obj = ((View) (obj)).getViewTreeObserver();
            if (obj != viewtreeobserver)
            {
                c = new WeakReference(obj);
                ((ViewTreeObserver) (obj)).addOnScrollChangedListener(this);
                ((ViewTreeObserver) (obj)).addOnGlobalLayoutListener(this);
                return;
            }
        }
    }

    protected void h()
    {
        ViewTreeObserver viewtreeobserver = (ViewTreeObserver)c.get();
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

    protected JSONObject i()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("afmaVersion", e.b()).put("activeViewJSON", e.c()).put("timestamp", abi.a().b().b()).put("adFormat", e.a()).put("hashCode", e.d());
        return jsonobject;
    }

    protected JSONObject j()
    {
        JSONObject jsonobject = i();
        jsonobject.put("doneReasonCode", "u");
        return jsonobject;
    }

    public void k()
    {
        synchronized (a)
        {
            n = true;
            b(false);
            g.a();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void l()
    {
        synchronized (a)
        {
            m = true;
            b(false);
            g.a();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void m()
    {
        synchronized (a)
        {
            g.b();
            m = false;
            b(false);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onGlobalLayout()
    {
        b(false);
    }

    public void onScrollChanged()
    {
        b(true);
    }
}
