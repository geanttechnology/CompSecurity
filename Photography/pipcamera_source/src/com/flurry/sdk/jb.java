// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.flurry.android.FlurryEventRecordStatus;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.flurry.sdk:
//            hm, kc, jm, js, 
//            kg, ix, jo, jf, 
//            ju, hl, jt, iy, 
//            iw, jz, ho, jc, 
//            je, lt, iv, ja, 
//            ji, jj, iz, lr, 
//            lk, ll, iu, kb, 
//            lf, lg, ka, le, 
//            la, lb, ly, ig, 
//            ii, jg

public class jb
    implements ll.a
{

    static int a = 100;
    static int b = 10;
    static int c = 1000;
    static int d = 0x27100;
    static int e = 50;
    private static final String f = com/flurry/sdk/jb.getSimpleName();
    private int A;
    private final List B = new ArrayList();
    private int C;
    private int D;
    private boolean E;
    private final hm F = new hm();
    private final kb G = new kb() {

        final jb a;

        public void a(jg jg1)
        {
            js.a().b(new ly(this) {

                final _cls9 a;

                public void a()
                {
                    jb.a(a.a, true, je.a().d());
                }

            
            {
                a = _pcls9;
                super();
            }
            });
        }

        public volatile void a(ka ka)
        {
            a((jg)ka);
        }

            
            {
                a = jb.this;
                super();
            }
    };
    private final AtomicInteger g = new AtomicInteger(0);
    private final AtomicInteger h = new AtomicInteger(0);
    private final AtomicInteger i = new AtomicInteger(0);
    private final kb j = new kb() {

        final jb a;

        public volatile void a(ka ka)
        {
            a((lg)ka);
        }

        public void a(lg lg1)
        {
            if (jb.a(a) != null && lg1.b != jb.a(a).get())
            {
                return;
            }
            class _cls8
            {

                static final int a[];

                static 
                {
                    a = new int[lg.a.values().length];
                    try
                    {
                        a[lg.a.a.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        a[lg.a.c.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[lg.a.d.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[lg.a.e.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls8.a[lg1.c.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                a.a(lg1.b, (Context)lg1.a.get());
                return;

            case 2: // '\002'
                a.a((Context)lg1.a.get());
                return;

            case 3: // '\003'
                a.b((Context)lg1.a.get());
                return;

            case 4: // '\004'
                kc.a().b("com.flurry.android.sdk.FlurrySessionEvent", jb.b(a));
                break;
            }
            a.a(lg1.d);
        }

            
            {
                a = jb.this;
                super();
            }
    };
    private WeakReference k;
    private File l;
    private jz m;
    private boolean n;
    private long o;
    private boolean p;
    private String q;
    private byte r;
    private Long s;
    private int t;
    private final List u = new ArrayList();
    private final Map v = new HashMap();
    private final Map w = new HashMap();
    private final Map x = new HashMap();
    private final List y = new ArrayList();
    private boolean z;

    public jb()
    {
        t = -1;
        z = true;
        A = 0;
        C = 0;
        D = 0;
        E = true;
        kc.a().a("com.flurry.android.sdk.FlurrySessionEvent", j);
    }

    static WeakReference a(jb jb1)
    {
        return jb1.k;
    }

    static void a(jb jb1, boolean flag, long l1)
    {
        jb1.a(flag, l1);
    }

    private void a(boolean flag)
    {
        Object obj;
        int i1;
        int j1;
        boolean flag1;
        j1 = -1;
        if (flag)
        {
            w.put("boot.time", Long.toString(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
            obj = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            Object obj1 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            float f1;
            Object obj2;
            StringBuilder stringbuilder;
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                w.put("disk.size.total.internal", Long.toString(((StatFs) (obj)).getAvailableBlocksLong()));
                w.put("disk.size.available.internal", Long.toString(((StatFs) (obj)).getAvailableBlocksLong()));
                w.put("disk.size.total.external", Long.toString(((StatFs) (obj1)).getAvailableBlocksLong()));
                w.put("disk.size.available.external", Long.toString(((StatFs) (obj1)).getAvailableBlocksLong()));
            } else
            {
                w.put("disk.size.total.internal", Long.toString(((StatFs) (obj)).getAvailableBlocks()));
                w.put("disk.size.available.internal", Long.toString(((StatFs) (obj)).getAvailableBlocks()));
                w.put("disk.size.total.external", Long.toString(((StatFs) (obj1)).getAvailableBlocks()));
                w.put("disk.size.available.external", Long.toString(((StatFs) (obj1)).getAvailableBlocks()));
            }
            w.put("carrier.name", jm.a().c());
            w.put("carrier.details", jm.a().d());
        }
        obj = (ActivityManager)js.a().c().getSystemService("activity");
        obj1 = new android.app.ActivityManager.MemoryInfo();
        ((ActivityManager) (obj)).getMemoryInfo(((android.app.ActivityManager.MemoryInfo) (obj1)));
        obj2 = w;
        stringbuilder = (new StringBuilder()).append("memory.available");
        if (flag)
        {
            obj = ".start";
        } else
        {
            obj = ".end";
        }
        ((Map) (obj2)).put(stringbuilder.append(((String) (obj))).toString(), Long.toString(((android.app.ActivityManager.MemoryInfo) (obj1)).availMem));
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            obj2 = w;
            stringbuilder = (new StringBuilder()).append("memory.total");
            if (flag)
            {
                obj = ".start";
            } else
            {
                obj = ".end";
            }
            ((Map) (obj2)).put(stringbuilder.append(((String) (obj))).toString(), Long.toString(((android.app.ActivityManager.MemoryInfo) (obj1)).availMem));
        }
        obj = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        obj = js.a().c().registerReceiver(null, ((IntentFilter) (obj)));
        if (obj == null) goto _L2; else goto _L1
_L1:
        i1 = ((Intent) (obj)).getIntExtra("status", -1);
        if (i1 == 2 || i1 == 5)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        try
        {
            j1 = ((Intent) (obj)).getIntExtra("level", -1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            i1 = -1;
            continue; /* Loop/switch isn't completed */
        }
        i1 = ((Intent) (obj)).getIntExtra("scale", -1);
_L5:
        f1 = (float)j1 / (float)i1;
        obj1 = w;
        obj2 = (new StringBuilder()).append("battery.charging");
        if (flag)
        {
            obj = ".start";
        } else
        {
            obj = ".end";
        }
        ((Map) (obj1)).put(((StringBuilder) (obj2)).append(((String) (obj))).toString(), Boolean.toString(flag1));
        obj1 = w;
        obj2 = (new StringBuilder()).append("battery.remaining");
        if (flag)
        {
            obj = ".start";
        } else
        {
            obj = ".end";
        }
        ((Map) (obj1)).put(((StringBuilder) (obj2)).append(((String) (obj))).toString(), Float.toString(f1));
        return;
        obj;
        flag1 = false;
        i1 = -1;
_L3:
        kg.a(5, f, (new StringBuilder()).append("Error getting battery status: ").append(obj).toString());
        j1 = i1;
        i1 = -1;
        continue; /* Loop/switch isn't completed */
        obj;
        i1 = j1;
        if (true) goto _L3; else goto _L2
_L2:
        flag1 = false;
        i1 = -1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void a(boolean flag, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        if (E) goto _L2; else goto _L1
_L1:
        kg.a(3, f, "Analytics disabled, not sending agent report.");
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (flag) goto _L4; else goto _L3
_L3:
        if (u.isEmpty()) goto _L5; else goto _L4
_L4:
        kg.a(3, f, "generating agent report");
        Object obj = (new ix(js.a().d(), jo.a().e(), n, jf.a().e(), o, l1, u, jf.a().h(), F.a(false), v, ju.a().c(), System.currentTimeMillis())).a();
_L6:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        kg.e(f, "Error generating report");
_L7:
        j();
          goto _L5
        obj;
        throw obj;
        obj;
        kg.e(f, (new StringBuilder()).append("Exception while generating report: ").append(obj).toString());
        obj = null;
          goto _L6
        kg.a(3, f, (new StringBuilder()).append("generated report of size ").append(obj.length).append(" with ").append(u.size()).append(" reports.").toString());
        iy iy1 = hl.a().d();
        String s1 = (new StringBuilder()).append("").append(jt.a()).toString();
        iy1.b(((byte []) (obj)), js.a().d(), s1);
          goto _L7
    }

    static kb b(jb jb1)
    {
        return jb1.j;
    }

    private void b(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = y.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            iw iw1 = (iw)iterator.next();
            if (iw1.a() && !iw1.b())
            {
                iw1.a(l1);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_62;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    private void c(Context context)
    {
        if (context instanceof Activity)
        {
            Bundle bundle = ((Activity)context).getIntent().getExtras();
            if (bundle != null)
            {
                kg.a(3, f, (new StringBuilder()).append("Launch Options Bundle is present ").append(bundle.toString()).toString());
                Iterator iterator = bundle.keySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s1 = (String)iterator.next();
                    if (s1 != null)
                    {
                        context = ((Context) (bundle.get(s1)));
                        if (context != null)
                        {
                            context = context.toString();
                        } else
                        {
                            context = "null";
                        }
                        v.put(s1, new ArrayList(Arrays.asList(new String[] {
                            context
                        })));
                        kg.a(3, f, (new StringBuilder()).append("Launch options Key: ").append(s1).append(". Its value: ").append(context).toString());
                    }
                } while (true);
            }
        }
    }

    static void c(jb jb1)
    {
        jb1.i();
    }

    static void d(jb jb1)
    {
        jb1.m();
    }

    static void e(jb jb1)
    {
        jb1.n();
    }

    static List f(jb jb1)
    {
        return jb1.u;
    }

    static boolean g(jb jb1)
    {
        return jb1.E;
    }

    private void i()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        kg.a(4, f, "Loading persistent session report data.");
        obj = (List)m.a();
        if (obj == null) goto _L2; else goto _L1
_L1:
        u.addAll(((java.util.Collection) (obj)));
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!l.exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        kg.a(4, f, "Legacy persistent agent data found, converting.");
        obj = ho.a(l);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        long l2;
        boolean flag;
        flag = ((jc) (obj)).a();
        l2 = ((jc) (obj)).b();
        long l1;
        l1 = l2;
        if (l2 > 0L)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        l1 = je.a().d();
        n = flag;
        o = l1;
        n();
        obj = ((jc) (obj)).c();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        u.addAll(((java.util.Collection) (obj)));
        l.delete();
        c();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void j()
    {
        u.clear();
        m.b();
    }

    private String k()
    {
        return (new StringBuilder()).append(".flurryagent.").append(Integer.toString(js.a().d().hashCode(), 16)).toString();
    }

    private String l()
    {
        return (new StringBuilder()).append(".yflurryreport.").append(Long.toString(lt.i(js.a().d()), 16)).toString();
    }

    private void m()
    {
        SharedPreferences sharedpreferences = js.a().c().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
        n = sharedpreferences.getBoolean("com.flurry.sdk.previous_successful_report", false);
        o = sharedpreferences.getLong("com.flurry.sdk.initial_run_time", je.a().d());
    }

    private void n()
    {
        android.content.SharedPreferences.Editor editor = js.a().c().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        editor.putBoolean("com.flurry.sdk.previous_successful_report", n);
        editor.putLong("com.flurry.sdk.initial_run_time", o);
        editor.commit();
    }

    private int o()
    {
        return g.incrementAndGet();
    }

    private int p()
    {
        return h.incrementAndGet();
    }

    public FlurryEventRecordStatus a(String s1, String s2, Map map, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventFailed;
        if (map != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flurryeventrecordstatus;
_L2:
        if (!TextUtils.isEmpty(s2))
        {
            map.put("\uE8FFsid+Tumblr", s2);
            flurryeventrecordstatus = a(s1, map, false);
            kg.a(5, f, (new StringBuilder()).append("logEvent status for syndication:").append(flurryeventrecordstatus).toString());
        }
        if (true) goto _L1; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public FlurryEventRecordStatus a(String s1, Map map, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        FlurryEventRecordStatus flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventRecorded;
        if (E) goto _L2; else goto _L1
_L1:
        s1 = FlurryEventRecordStatus.kFlurryEventAnalyticsDisabled;
        kg.e(f, "Analytics has been disabled, not logging event.");
_L3:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        String s2;
        long l1;
        long l2;
label0:
        {
            l1 = SystemClock.elapsedRealtime();
            l2 = je.a().e();
            s2 = lt.b(s1);
            if (s2.length() != 0)
            {
                break label0;
            }
            s1 = FlurryEventRecordStatus.kFlurryEventFailed;
        }
          goto _L3
        s1 = (iv)x.get(s2);
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        if (x.size() >= a) goto _L5; else goto _L4
_L4:
        s1 = new iv();
        s1.a = 1;
        x.put(s2, s1);
        kg.e(f, (new StringBuilder()).append("Event count started: ").append(s2).toString());
        s1 = flurryeventrecordstatus;
_L6:
        if (!p || y.size() >= c || A >= d)
        {
            break MISSING_BLOCK_LABEL_470;
        }
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        map = Collections.emptyMap();
        if (map.size() <= b)
        {
            break MISSING_BLOCK_LABEL_323;
        }
        kg.e(f, (new StringBuilder()).append("MaxEventParams exceeded: ").append(map.size()).toString());
        s1 = FlurryEventRecordStatus.kFlurryEventParamsCountExceeded;
          goto _L3
_L5:
        kg.e(f, (new StringBuilder()).append("Too many different events. Event not counted: ").append(s2).toString());
        s1 = FlurryEventRecordStatus.kFlurryEventUniqueCountExceeded;
          goto _L6
        s1.a = ((iv) (s1)).a + 1;
        kg.e(f, (new StringBuilder()).append("Event count incremented: ").append(s2).toString());
        s1 = FlurryEventRecordStatus.kFlurryEventRecorded;
          goto _L6
        s1 = new iw(o(), s2, map, l1 - l2, flag);
        if (s1.d() + A > d)
        {
            break MISSING_BLOCK_LABEL_442;
        }
        y.add(s1);
        int i1 = A;
        A = s1.d() + i1;
        flurryeventrecordstatus = FlurryEventRecordStatus.kFlurryEventRecorded;
        s1 = flurryeventrecordstatus;
        if (!E) goto _L3; else goto _L7
_L7:
        s1 = flurryeventrecordstatus;
        if (hl.a().c() == null) goto _L3; else goto _L8
_L8:
        js.a().b(new Runnable(s2, map) {

            final String a;
            final Map b;
            final jb c;

            public void run()
            {
                hl.a().c().a(a, b);
            }

            
            {
                c = jb.this;
                a = s1;
                b = map;
                super();
            }
        });
        s1 = flurryeventrecordstatus;
          goto _L3
        s1;
        throw s1;
        A = d;
        z = false;
        kg.e(f, "Event Log size exceeded. No more event details logged.");
        s1 = FlurryEventRecordStatus.kFlurryEventLogCountExceeded;
          goto _L3
        z = false;
          goto _L3
    }

    iz a(long l1, long l2, long l3, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new ja();
        ((ja) (obj)).a(jo.a().e());
        ((ja) (obj)).a(l1);
        ((ja) (obj)).b(l2);
        ((ja) (obj)).c(l3);
        ((ja) (obj)).a(w);
        ((ja) (obj)).b(je.a().i());
        ((ja) (obj)).c(je.a().j());
        ((ja) (obj)).b(je.a().k());
        ((ja) (obj)).d(ji.a().c());
        ((ja) (obj)).e(ji.a().d());
        ((ja) (obj)).a(i1);
        if (t == -1) goto _L2; else goto _L1
_L1:
        i1 = t;
_L3:
        ((ja) (obj)).b(i1);
        ((ja) (obj)).f(d());
        ((ja) (obj)).a(jj.a().e());
        ((ja) (obj)).c(h());
        ((ja) (obj)).a(r);
        ((ja) (obj)).a(s);
        ((ja) (obj)).c(g());
        ((ja) (obj)).a(e());
        ((ja) (obj)).a(z);
        ((ja) (obj)).b(f());
        ((ja) (obj)).d(C);
        obj = new iz(((ja) (obj)));
_L4:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        kg.e(f, "New session report wasn't created");
        this;
        JVM INSTR monitorexit ;
        return ((iz) (obj));
_L2:
        i1 = lr.j();
          goto _L3
        Object obj1;
        obj1;
        kg.a(5, f, (new StringBuilder()).append("Error creating analytics session report: ").append(obj1).toString());
        obj1 = null;
          goto _L4
        obj1;
        throw obj1;
          goto _L3
    }

    public void a()
    {
        n = true;
    }

    public void a(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        kc.a().a(G);
        js.a().b(new ly() {

            final jb a;

            public void a()
            {
                if (jb.g(a) && hl.a().c() != null)
                {
                    hl.a().c().d();
                }
                if (hl.a().e() != null)
                {
                    js.a().b(new ly(this) {

                        final _cls5 a;

                        public void a()
                        {
                            hl.a().e().d();
                        }

            
            {
                a = _pcls5;
                super();
            }
                    });
                }
            }

            
            {
                a = jb.this;
                super();
            }
        });
        if (jf.a().c())
        {
            js.a().b(new ly(l1) {

                final long a;
                final jb b;

                public void a()
                {
                    jb.a(b, false, a);
                }

            
            {
                b = jb.this;
                a = l1;
                super();
            }
            });
        }
        lk.a().b("Gender", this);
        lk.a().b("UserId", this);
        lk.a().b("Age", this);
        lk.a().b("LogEvents", this);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        t = lr.j();
        if (hl.a().e() != null)
        {
            js.a().b(new ly() {

                final jb a;

                public void a()
                {
                    hl.a().e().e();
                }

            
            {
                a = jb.this;
                super();
            }
            });
        }
        if (E && hl.a().c() != null)
        {
            js.a().b(new ly() {

                final jb a;

                public void a()
                {
                    hl.a().c().c();
                }

            
            {
                a = jb.this;
                super();
            }
            });
        }
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public void a(lf lf, Context context)
    {
        k = new WeakReference(lf);
        lf = lk.a();
        p = ((Boolean)lf.a("LogEvents")).booleanValue();
        lf.a("LogEvents", this);
        kg.a(4, f, (new StringBuilder()).append("initSettings, LogEvents = ").append(p).toString());
        q = (String)lf.a("UserId");
        lf.a("UserId", this);
        kg.a(4, f, (new StringBuilder()).append("initSettings, UserId = ").append(q).toString());
        r = ((Byte)lf.a("Gender")).byteValue();
        lf.a("Gender", this);
        kg.a(4, f, (new StringBuilder()).append("initSettings, Gender = ").append(r).toString());
        s = (Long)lf.a("Age");
        lf.a("Age", this);
        kg.a(4, f, (new StringBuilder()).append("initSettings, BirthDate = ").append(s).toString());
        E = ((Boolean)lf.a("analyticsEnabled")).booleanValue();
        lf.a("analyticsEnabled", this);
        kg.a(4, f, (new StringBuilder()).append("initSettings, AnalyticsEnabled = ").append(E).toString());
        l = context.getFileStreamPath(k());
        m = new jz(context.getFileStreamPath(l()), ".yflurryreport.", 1, new le() {

            final jb a;

            public lb a(int i1)
            {
                return new la(new iz.a());
            }

            
            {
                a = jb.this;
                super();
            }
        });
        c(context);
        a(true);
        if (hl.a().c() != null)
        {
            js.a().b(new ly() {

                final jb a;

                public void a()
                {
                    hl.a().c().b();
                }

            
            {
                a = jb.this;
                super();
            }
            });
        }
        js.a().b(new ly() {

            final jb a;

            public void a()
            {
                jb.c(a);
            }

            
            {
                a = jb.this;
                super();
            }
        });
        js.a().b(new ly() {

            final jb a;

            public void a()
            {
                jb.d(a);
            }

            
            {
                a = jb.this;
                super();
            }
        });
        if (jf.a().c())
        {
            js.a().b(new ly() {

                final jb a;

                public void a()
                {
                    jb.a(a, true, je.a().d());
                }

            
            {
                a = jb.this;
                super();
            }
            });
            return;
        } else
        {
            kc.a().a("com.flurry.android.sdk.IdProviderFinishedEvent", G);
            return;
        }
    }

    public void a(String s1, Object obj)
    {
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 5: default 56
    //                   -1752163738: 119
    //                   -1720015653: 164
    //                   -738063011: 104
    //                   65759: 149
    //                   2129321697: 134;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_164;
_L7:
        switch (byte0)
        {
        default:
            kg.a(6, f, "onSettingUpdate internal error!");
            return;

        case 0: // '\0'
            p = ((Boolean)obj).booleanValue();
            kg.a(4, f, (new StringBuilder()).append("onSettingUpdate, LogEvents = ").append(p).toString());
            return;

        case 1: // '\001'
            q = (String)obj;
            kg.a(4, f, (new StringBuilder()).append("onSettingUpdate, UserId = ").append(q).toString());
            return;

        case 2: // '\002'
            r = ((Byte)obj).byteValue();
            kg.a(4, f, (new StringBuilder()).append("onSettingUpdate, Gender = ").append(r).toString());
            return;

        case 3: // '\003'
            s = (Long)obj;
            kg.a(4, f, (new StringBuilder()).append("onSettingUpdate, Birthdate = ").append(s).toString());
            return;

        case 4: // '\004'
            E = ((Boolean)obj).booleanValue();
            break;
        }
        break MISSING_BLOCK_LABEL_352;
_L4:
        if (s1.equals("LogEvents"))
        {
            byte0 = 0;
        }
          goto _L7
_L2:
        if (s1.equals("UserId"))
        {
            byte0 = 1;
        }
          goto _L7
_L6:
        if (s1.equals("Gender"))
        {
            byte0 = 2;
        }
          goto _L7
_L5:
        if (s1.equals("Age"))
        {
            byte0 = 3;
        }
          goto _L7
        if (s1.equals("analyticsEnabled"))
        {
            byte0 = 4;
        }
          goto _L7
        kg.a(4, f, (new StringBuilder()).append("onSettingUpdate, AnalyticsEnabled = ").append(E).toString());
        return;
    }

    public void a(String s1, String s2, String s3, Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (!"uncaught".equals(s1)) goto _L2; else goto _L3
_L3:
        int i1 = 1;
_L6:
        C = C + 1;
        if (B.size() >= e) goto _L5; else goto _L4
_L4:
        long l1 = System.currentTimeMillis();
        s1 = new iu(p(), Long.valueOf(l1).longValue(), s1, s2, s3, throwable);
        B.add(s1);
        kg.e(f, (new StringBuilder()).append("Error logged: ").append(s1.c()).toString());
_L8:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        i1 = 0;
          goto _L6
_L5:
        if (!i1)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        i1 = 0;
_L9:
        if (i1 >= B.size()) goto _L8; else goto _L7
_L7:
        iu iu1 = (iu)B.get(i1);
        if (iu1.c() == null || "uncaught".equals(iu1.c()))
        {
            break MISSING_BLOCK_LABEL_234;
        }
        long l2 = System.currentTimeMillis();
        s1 = new iu(p(), Long.valueOf(l2).longValue(), s1, s2, s3, throwable);
        B.set(i1, s1);
          goto _L8
        s1;
        throw s1;
        i1++;
          goto _L9
        kg.e(f, "Max errors logged. No more errors logged.");
          goto _L8
    }

    public void a(String s1, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = y.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        iw iw1 = (iw)iterator.next();
        if (!iw1.a(s1)) goto _L4; else goto _L3
_L3:
        long l1;
        long l2;
        l1 = SystemClock.elapsedRealtime();
        l2 = je.a().e();
        if (map == null) goto _L6; else goto _L5
_L5:
        if (map.size() <= 0 || A >= d) goto _L6; else goto _L7
_L7:
        int i1;
        i1 = A - iw1.d();
        s1 = new HashMap(iw1.c());
        iw1.a(map);
        if (iw1.d() + i1 > d)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        if (iw1.c().size() <= b) goto _L9; else goto _L8
_L8:
        kg.e(f, (new StringBuilder()).append("MaxEventParams exceeded on endEvent: ").append(iw1.c().size()).toString());
        iw1.b(s1);
_L6:
        iw1.a(l1 - l2);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L9:
        A = i1 + iw1.d();
          goto _L6
        s1;
        throw s1;
        iw1.b(s1);
        z = false;
        A = d;
        kg.e(f, "Event Log size exceeded. No more event details logged.");
          goto _L6
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        D = D + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void b(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        a(false);
        long l1 = je.a().d();
        long l2 = je.a().f();
        long l3 = je.a().h();
        int i1 = je.a().l().a();
        b(je.a().f());
        if (E && hl.a().c() != null)
        {
            js.a().b(new ly(l1) {

                final long a;
                final jb b;

                public void a()
                {
                    hl.a().c().a(a);
                }

            
            {
                b = jb.this;
                a = l1;
                super();
            }
            });
        }
        js.a().b(new ly() {

            final jb a;

            public void a()
            {
                jb.e(a);
            }

            
            {
                a = jb.this;
                super();
            }
        });
        if (jf.a().c())
        {
            js.a().b(new ly(l1, l2, l3, i1) {

                final long a;
                final long b;
                final long c;
                final int d;
                final jb e;

                public void a()
                {
                    iz iz1 = e.a(a, b, c, d);
                    jb.f(e).clear();
                    jb.f(e).add(iz1);
                    e.c();
                }

            
            {
                e = jb.this;
                a = l1;
                b = l2;
                c = l3;
                d = i1;
                super();
            }
            });
        }
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        kg.a(4, f, "Saving persistent agent data.");
        m.a(u);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    String d()
    {
        if (q == null)
        {
            return "";
        } else
        {
            return q;
        }
    }

    List e()
    {
        return y;
    }

    List f()
    {
        return B;
    }

    Map g()
    {
        return x;
    }

    int h()
    {
        return D;
    }

}
