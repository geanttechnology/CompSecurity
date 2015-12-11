// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

// Referenced classes of package com.tapjoy.internal:
//            gq, cw, x, gd, 
//            ac, ad, ag, co, 
//            gn, r, n, o, 
//            l, k, fx, cr

public final class gg
{

    public static final String a = UUID.randomUUID().toString();
    private static gg b;
    private final gt.l.a c = gt.l.M();
    private final gt.a.a d = gt.a.o();
    private final gt.x.a e = gt.x.ac();
    private final Context f;
    private final gn g;

    private gg(Context context, gn gn1)
    {
        Object obj1 = null;
        super();
        gq.a();
        c.k("11.2.2/Android").e("Android").f(android.os.Build.VERSION.RELEASE).c(Build.MANUFACTURER).d(Build.MODEL).g(Locale.getDefault().toString()).h(TimeZone.getDefault().getID());
        Object obj2 = context.getApplicationContext();
        f = ((Context) (obj2));
        context = android.provider.Settings.Secure.getString(((Context) (obj2)).getContentResolver(), "android_id");
        Object obj;
        if (!"9774d56d682e549c".equals(context))
        {
            context = cw.b(context);
        } else
        {
            context = null;
        }
        obj = context;
        if (context == null)
        {
            context = x.a(((Context) (obj2)));
            obj = new File(gd.b(((Context) (obj2))), "deviceid");
            double d1;
            Object obj3;
            Signature asignature[];
            int i;
            long l1;
            long l2;
            boolean flag1;
            if (context != null)
            {
                context = new File(context, ".io.5rocks");
            } else
            {
                context = null;
            }
            obj = ac.a(((File) (obj)), context);
        }
        c.b(((String) (obj)));
        context = ad.a(((Context) (obj2)));
        if (context != null)
        {
            c.a(context.replace(":", "").toLowerCase(Locale.US));
        }
        obj = ((Context) (obj2)).getPackageManager();
        context = (TelephonyManager)((Context) (obj2)).getSystemService("phone");
        if (context != null)
        {
            obj3 = context.getSimCountryIso();
            if (!cw.c(((String) (obj3))))
            {
                c.l(((String) (obj3)).toUpperCase(Locale.US));
            }
            obj3 = context.getNetworkCountryIso();
            if (!cw.c(((String) (obj3))))
            {
                c.m(((String) (obj3)).toUpperCase(Locale.US));
            }
            boolean flag;
            if (((PackageManager) (obj)).checkPermission("android.permission.READ_PHONE_STATE", ((Context) (obj2)).getPackageName()) == 0)
            {
                try
                {
                    context = context.getDeviceId();
                    if (!cw.c(context))
                    {
                        c.n(context);
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Context context) { }
                // Misplaced declaration of an exception variable
                catch (Context context) { }
            }
        }
        obj2 = ((Context) (obj2)).getPackageName();
        c.i(((String) (obj2)));
        obj3 = c;
        asignature = ag.e(((PackageManager) (obj)), ((String) (obj2)));
        context = obj1;
        if (asignature != null)
        {
            context = obj1;
            if (asignature.length > 0)
            {
                context = Base64.encodeToString(co.a(asignature[0].toByteArray()), 2);
            }
        }
        ((gt.l.a) (obj3)).j(cw.a(context));
        d.a(ag.a(((PackageManager) (obj)), ((String) (obj2))));
        d.a(ag.b(((PackageManager) (obj)), ((String) (obj2))));
        context = ((PackageManager) (obj)).getInstallerPackageName(((String) (obj2)));
        if (!cw.c(context))
        {
            d.c(context);
        }
        context = a(((PackageManager) (obj)), ((String) (obj2)));
        if (!cw.c(context))
        {
            d.d(context);
        }
        a();
        g = gn1;
        context = g.c.a();
        if (context != null && context.length() > 0)
        {
            c.k((new StringBuilder()).append(context).append(" 11.2.2/Android").toString());
        }
        context = g.b();
        if (context != null)
        {
            e.a(context);
        }
        context = e;
        gn1 = g;
        l2 = gn1.b.getLong("it", 0L);
        l1 = l2;
        if (l2 == 0L)
        {
            obj = gn1.a;
            l2 = ag.c(((Context) (obj)).getPackageManager(), ((Context) (obj)).getPackageName());
            l1 = l2;
            if (l2 == 0L)
            {
                l2 = gd.c(gn1.a).lastModified();
                l1 = l2;
                if (l2 == 0L)
                {
                    obj = gn1.a;
                    l2 = (new File(ag.d(((Context) (obj)).getPackageManager(), ((Context) (obj)).getPackageName()))).lastModified();
                    l1 = l2;
                    if (l2 == 0L)
                    {
                        l1 = System.currentTimeMillis();
                    }
                }
            }
            gn1.b.edit().putLong("it", l1).commit();
        }
        context.a(l1);
        i = g.f.b();
        e.a(a(7, i));
        e.b(a(30, i));
        i = g.h.b();
        if (i > 0)
        {
            e.e(i);
        }
        l1 = g.i.a();
        if (l1 > 0L)
        {
            e.b(l1);
        }
        l1 = g.j.a();
        if (l1 > 0L)
        {
            e.c(l1);
        }
        l1 = g.k.a();
        if (l1 > 0L)
        {
            e.d(l1);
        }
        context = g.l.a();
        if (context != null)
        {
            e.b(context);
        }
        i = g.m.b();
        if (i > 0)
        {
            e.f(i);
        }
        d1 = g.n.a();
        if (d1 != 0.0D)
        {
            e.a(d1);
        }
        l1 = g.o.a();
        if (l1 > 0L)
        {
            e.e(l1);
        }
        d1 = g.p.a();
        if (d1 != 0.0D)
        {
            e.b(d1);
        }
        context = g.g.a();
        if (context != null)
        {
            try
            {
                context = gt.u.a(Base64.decode(context, 2));
                e.h();
                e.a(context.e());
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                g.g.c();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                g.g.c();
            }
        }
        context = g.q.a();
        if (context != null)
        {
            d.b(context);
        } else
        {
            d.h();
        }
        context = g.r.a();
        if (context != null)
        {
            e.d(context);
        } else
        {
            e.o();
        }
        i = g.s.a().intValue();
        if (i != -1)
        {
            e.g(i);
        } else
        {
            e.r();
        }
        i = g.t.a().intValue();
        if (i != -1)
        {
            e.h(i);
        } else
        {
            e.u();
        }
        context = g.u.a();
        if (context != null)
        {
            e.e(context);
        } else
        {
            e.x();
        }
        context = g.v.a();
        if (context != null)
        {
            e.f(context);
        } else
        {
            e.A();
        }
        context = g.w.a();
        if (context != null)
        {
            e.g(context);
        } else
        {
            e.D();
        }
        context = g.x.a();
        if (context != null)
        {
            e.h(context);
        } else
        {
            e.G();
        }
        context = g.y.a();
        if (context != null)
        {
            e.i(context);
        } else
        {
            e.J();
        }
        context = g.z.a();
        flag1 = g.A.a().booleanValue();
        if (context != null)
        {
            e.c(context);
            e.a(flag1);
        } else
        {
            e.k();
            e.l();
        }
        e.b(g.B.b());
        context = new Runnable() {

            final gg a;

            public final void run()
            {
                cr cr1;
                boolean flag2;
                cr1 = new cr();
                flag2 = cr1.a(gg.a(a));
                gg gg1 = a;
                gg1;
                JVM INSTR monitorenter ;
                if (!flag2)
                {
                    break MISSING_BLOCK_LABEL_110;
                }
                String s = cw.a(cr1.a);
                boolean flag3 = cr1.b;
                gg.b(a).c(s);
                gg.b(a).a(flag3);
                gg.c(a).z.a(s);
                gg.c(a).A.a(flag3);
                gq.a(s, flag3);
_L2:
                gg1;
                JVM INSTR monitorexit ;
                return;
                gg.b(a).k();
                gg.b(a).l();
                gg.c(a).z.a(null);
                gg.c(a).A.a(false);
                gq.a(null, false);
                if (true) goto _L2; else goto _L1
_L1:
                Exception exception;
                exception;
                throw exception;
            }

            
            {
                a = gg.this;
                super();
            }
        };
        gn1 = Looper.myLooper();
        if (gn1 != null && gn1 == Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            (new z.a(context)).execute(new Void[0]);
            return;
        } else
        {
            context.run();
            return;
        }
    }

    private static int a(int i, int j)
    {
        return Integer.bitCount((1 << i) - 1 & j);
    }

    static Context a(gg gg1)
    {
        return gg1.f;
    }

    public static gg a(Context context)
    {
        com/tapjoy/internal/gg;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new gg(context, gn.a(context));
        }
        context = b;
        com/tapjoy/internal/gg;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private static String a(PackageManager packagemanager, String s)
    {
        packagemanager = packagemanager.getApplicationInfo(s, 128).metaData;
        if (packagemanager == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        packagemanager = ((PackageManager) (packagemanager.get("com.tapjoy.appstore")));
        if (packagemanager == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        packagemanager = packagemanager.toString().trim();
        return packagemanager;
        packagemanager;
        return null;
    }

    static gt.x.a b(gg gg1)
    {
        return gg1.e;
    }

    static gn c(gg gg1)
    {
        return gg1.g;
    }

    private void g()
    {
        String s = Base64.encodeToString(gt.u.f().a(e.f()).e().a(), 2);
        g.g.a(s);
    }

    final void a()
    {
        this;
        JVM INSTR monitorenter ;
        DisplayMetrics displaymetrics;
        Object obj;
        displaymetrics = new DisplayMetrics();
        ((WindowManager)f.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        obj = fx.a();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        int i = displaymetrics.heightPixels;
        obj = ((Activity) (obj)).getWindow();
        Rect rect = new Rect();
        ((Window) (obj)).getDecorView().getWindowVisibleDisplayFrame(rect);
        displaymetrics.heightPixels = i - rect.top;
        c.a(displaymetrics.densityDpi);
        c.b(displaymetrics.widthPixels);
        c.c(displaymetrics.heightPixels);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        l1 = g.i.a() + l1;
        g.i.a(l1);
        e.b(l1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(long l1, double d1)
    {
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = g.a();
        g.o.a(editor, l1);
        g.p.a(editor, d1);
        editor.commit();
        e.e(l1);
        e.b(d1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(long l1, long l2)
    {
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = g.a();
        g.j.a(editor, l1);
        g.k.a(editor, l2);
        editor.commit();
        e.c(l1);
        e.d(l2);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    final void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        g.d.a(s);
        e.a(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final void a(String s, double d1)
    {
        int i = 1;
        this;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor;
        editor = g.a();
        if (!s.equals(g.l.a()))
        {
            break MISSING_BLOCK_LABEL_117;
        }
        i = g.m.b() + 1;
        g.m.a(editor, i);
        d1 += g.n.a();
        g.n.a(editor, d1);
        editor.commit();
_L2:
        e.f(i);
        e.a(d1);
        this;
        JVM INSTR monitorexit ;
        return;
        g.l.a(editor, s);
        g.m.a(editor, 1);
        g.n.a(editor, d1);
        g.o.a(editor);
        g.p.a(editor);
        editor.commit();
        e.b(s);
        e.i();
        e.j();
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    public final boolean a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        g.s.a(i);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        Exception exception;
        boolean flag;
        if (!e.p() || e.q() != i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e.g(i);
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
        flag = e.p();
        e.r();
          goto _L1
        exception;
        throw exception;
    }

    public final boolean a(int i, String s)
    {
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        flag1 = false;
        flag2 = false;
        flag3 = false;
        flag4 = false;
        flag5 = false;
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        i;
        JVM INSTR tableswitch 1 5: default 56
    //                   1 60
    //                   2 141
    //                   3 217
    //                   4 293
    //                   5 369;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        g.u.a(s);
        if (s == null) goto _L8; else goto _L7
_L7:
        if (!e.v()) goto _L10; else goto _L9
_L9:
        flag = flag1;
        if (e.w().equals(s)) goto _L11; else goto _L10
_L11:
        e.e(s);
          goto _L1
        s;
        throw s;
_L8:
        flag = e.v();
        e.x();
          goto _L1
_L3:
        g.v.a(s);
        if (s == null) goto _L13; else goto _L12
_L12:
        if (!e.y()) goto _L15; else goto _L14
_L14:
        flag = flag2;
        if (e.z().equals(s)) goto _L16; else goto _L15
_L16:
        e.f(s);
          goto _L1
_L13:
        flag = e.y();
        e.A();
          goto _L1
_L4:
        g.w.a(s);
        if (s == null) goto _L18; else goto _L17
_L17:
        if (!e.B()) goto _L20; else goto _L19
_L19:
        flag = flag3;
        if (e.C().equals(s)) goto _L21; else goto _L20
_L21:
        e.g(s);
          goto _L1
_L18:
        flag = e.B();
        e.D();
          goto _L1
_L5:
        g.x.a(s);
        if (s == null) goto _L23; else goto _L22
_L22:
        if (!e.E()) goto _L25; else goto _L24
_L24:
        flag = flag4;
        if (e.F().equals(s)) goto _L26; else goto _L25
_L26:
        e.h(s);
          goto _L1
_L23:
        flag = e.E();
        e.G();
          goto _L1
_L6:
        g.y.a(s);
        if (s == null) goto _L28; else goto _L27
_L27:
        if (!e.H()) goto _L30; else goto _L29
_L29:
        flag = flag5;
        if (e.I().equals(s)) goto _L31; else goto _L30
_L31:
        e.i(s);
          goto _L1
_L28:
        flag = e.H();
        e.J();
          goto _L1
_L10:
        flag = true;
          goto _L11
_L15:
        flag = true;
          goto _L16
_L20:
        flag = true;
          goto _L21
_L25:
        flag = true;
          goto _L26
_L30:
        flag = true;
          goto _L31
    }

    final boolean a(String s, long l1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int j = e.g();
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        gt.t t;
        t = e.c(i);
        if (!t.f().equals(s))
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        e.a(i, gt.t.a(t).a(l1));
        g();
        this;
        JVM INSTR monitorexit ;
        return true;
        this;
        JVM INSTR monitorexit ;
        return false;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        e.a(gt.t.k().a(s).a(l1));
        g();
        this;
        JVM INSTR monitorexit ;
        return true;
        s;
        throw s;
    }

    public final boolean a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        g.B.a(flag);
        boolean flag1;
        if (flag != e.K())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        e.b(flag);
        this;
        JVM INSTR monitorexit ;
        return flag1;
        Exception exception;
        exception;
        throw exception;
    }

    public final gt.n b()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        long l1;
        c.g(Locale.getDefault().toString()).h(TimeZone.getDefault().getID());
        l1 = System.currentTimeMillis();
        i = e.g();
        boolean flag;
        flag = false;
        i--;
_L2:
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        if (e.c(i).h() > l1 - 0xf731400L)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        e.d(i);
        flag = true;
        break MISSING_BLOCK_LABEL_128;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        g();
        gt.n n1 = gt.n.k().a(c).a(d).a(e).e();
        this;
        JVM INSTR monitorexit ;
        return n1;
        Exception exception;
        exception;
        throw exception;
        i--;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final boolean b(int i)
    {
        this;
        JVM INSTR monitorenter ;
        g.t.a(i);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        Exception exception;
        boolean flag;
        if (!e.s() || e.t() != i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e.h(i);
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
        flag = e.s();
        e.u();
          goto _L1
        exception;
        throw exception;
    }

    public final boolean b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        g.q.a(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        boolean flag;
        if (!d.f() || !d.g().equals(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d.b(s);
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
        flag = d.f();
        d.h();
          goto _L1
        s;
        throw s;
    }

    final String c()
    {
        this;
        JVM INSTR monitorenter ;
        String s = g.d.a();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean c(String s)
    {
        this;
        JVM INSTR monitorenter ;
        g.r.a(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        boolean flag;
        if (!e.m() || !e.n().equals(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e.d(s);
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
        flag = e.m();
        e.o();
          goto _L1
        s;
        throw s;
    }

    public final gt.p d()
    {
        int i = 1;
        this;
        JVM INSTR monitorenter ;
        Calendar calendar;
        int j;
        int l1;
        calendar = Calendar.getInstance();
        j = calendar.get(1) * 10000 + calendar.get(2) * 100 + 100 + calendar.get(5);
        l1 = g.e.a().intValue();
        if (l1 == j) goto _L2; else goto _L1
_L1:
        if (l1 != 0) goto _L4; else goto _L3
_L3:
        Object obj;
        e.a(1);
        e.b(1);
        obj = gt.p.k();
        ((gt.p.a) (obj)).a("fq7_0_1");
        ((gt.p.a) (obj)).b("fq30_0_1");
_L10:
        g.e.a(j);
        g.f.a(i);
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = ((gt.p.a) (obj)).e();
_L16:
        this;
        JVM INSTR monitorexit ;
        return ((gt.p) (obj));
_L4:
        Calendar calendar1;
        int i1;
        int j1;
        int k1;
        k1 = g.f.a().intValue();
        i1 = a(7, k1);
        j1 = a(30, k1);
        calendar1 = Calendar.getInstance();
        calendar1.set(l1 / 10000, (l1 / 100) % 100 - 1, l1 % 100);
        l1 = Integer.signum(calendar.get(1) - calendar1.get(1));
        l1;
        JVM INSTR tableswitch -1 1: default 548
    //                   -1 400
    //                   0 248
    //                   1 461;
           goto _L7 _L8 _L7 _L9
_L7:
        i = calendar.get(6) - calendar1.get(6);
_L15:
        long l2;
        if (Math.abs(i) >= 30)
        {
            i = 0;
        } else
        if (i >= 0)
        {
            i = k1 << i;
        } else
        {
            i = k1 >> -i;
        }
        i |= 1;
        k1 = a(7, i);
        l1 = a(30, i);
        e.a(k1);
        e.b(l1);
        obj = gt.p.k();
        ((gt.p.a) (obj)).a((new StringBuilder("fq7_")).append(i1).append("_").append(k1).toString());
        ((gt.p.a) (obj)).b((new StringBuilder("fq30_")).append(j1).append("_").append(l1).toString());
          goto _L10
        obj;
        throw obj;
_L8:
        obj = (Calendar)calendar1.clone();
        ((Calendar) (obj)).set(calendar.get(1), calendar.get(2), calendar.get(5));
        l2 = calendar1.getTimeInMillis();
          goto _L11
_L14:
        if (((Calendar) (obj)).getTimeInMillis() >= l2) goto _L13; else goto _L12
_L12:
        ((Calendar) (obj)).add(5, 1);
        i++;
          goto _L14
_L9:
        obj = (Calendar)calendar.clone();
        ((Calendar) (obj)).set(calendar1.get(1), calendar1.get(2), calendar1.get(5));
        l2 = calendar.getTimeInMillis();
          goto _L11
_L13:
        if (l1 <= 0)
        {
            i = -i;
        }
          goto _L15
_L6:
        obj = null;
          goto _L16
_L2:
        this;
        JVM INSTR monitorexit ;
        return null;
_L11:
        i = 0;
          goto _L14
    }

    public final boolean d(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i = e.g() - 1;
_L2:
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        gt.t t = e.c(i);
        if (!t.f().equals(s))
        {
            break MISSING_BLOCK_LABEL_68;
        }
        s = gt.t.a(t).b(System.currentTimeMillis()).e();
        e.a(i, s);
        g();
        this;
        JVM INSTR monitorexit ;
        return true;
        i--;
        if (true) goto _L2; else goto _L1
_L1:
        return false;
        s;
        throw s;
    }

    public final void e()
    {
        this;
        JVM INSTR monitorenter ;
        int i = g.h.b() + 1;
        g.h.a(i);
        e.e(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean f()
    {
        return e.K();
    }

}
