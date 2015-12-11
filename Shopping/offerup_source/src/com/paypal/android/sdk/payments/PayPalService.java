// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.paypal.android.sdk.a;
import com.paypal.android.sdk.ac;
import com.paypal.android.sdk.az;
import com.paypal.android.sdk.ba;
import com.paypal.android.sdk.bb;
import com.paypal.android.sdk.bd;
import com.paypal.android.sdk.bf;
import com.paypal.android.sdk.bi;
import com.paypal.android.sdk.bj;
import com.paypal.android.sdk.bs;
import com.paypal.android.sdk.by;
import com.paypal.android.sdk.cf;
import com.paypal.android.sdk.ch;
import com.paypal.android.sdk.cj;
import com.paypal.android.sdk.co;
import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.cr;
import com.paypal.android.sdk.cs;
import com.paypal.android.sdk.cv;
import com.paypal.android.sdk.dj;
import com.paypal.android.sdk.dl;
import com.paypal.android.sdk.dn;
import com.paypal.android.sdk.dx;
import com.paypal.android.sdk.dy;
import com.paypal.android.sdk.ea;
import com.paypal.android.sdk.eb;
import com.paypal.android.sdk.ed;
import com.paypal.android.sdk.ef;
import com.paypal.android.sdk.ej;
import com.paypal.android.sdk.ek;
import com.paypal.android.sdk.el;
import com.paypal.android.sdk.em;
import com.paypal.android.sdk.en;
import com.paypal.android.sdk.eq;
import com.paypal.android.sdk.et;
import com.paypal.android.sdk.ev;
import com.paypal.android.sdk.ex;
import com.paypal.android.sdk.fk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.paypal.android.sdk.payments:
//            d, bv, ba, be, 
//            PayPalConfiguration, bi, ay, bw, 
//            bf, bh, bc, br, 
//            e, bb, bd

public final class PayPalService extends Service
{

    static final ExecutorService a = bs.a();
    private static final String c = com/paypal/android/sdk/payments/PayPalService.getSimpleName();
    private static Intent s;
    dy b;
    private ac d;
    private cq e;
    private PayPalConfiguration f;
    private boolean g;
    private d h;
    private d i;
    private bw j;
    private String k;
    private bb l;
    private com.paypal.android.sdk.payments.bf m;
    private a n;
    private cv o;
    private List p;
    private boolean q;
    private boolean r;
    private final BroadcastReceiver t = new com.paypal.android.sdk.payments.ba(this);
    private final IBinder u = new be(this);

    public PayPalService()
    {
        h = new d();
        i = new d();
        j = new bv(this);
        p = new ArrayList();
        q = true;
        r = true;
    }

    static PayPalConfiguration a(PayPalService paypalservice)
    {
        return paypalservice.f;
    }

    private void a(Intent intent)
    {
        s = intent;
        (new StringBuilder("init:")).append(b(intent));
        if (f == null)
        {
            f = (PayPalConfiguration)intent.getParcelableExtra("com.paypal.android.sdk.paypalConfiguration");
            if (f == null)
            {
                throw new RuntimeException("Missing EXTRA_PAYPAL_CONFIGURATION. To avoid this error, set EXTRA_PAYPAL_CONFIGURATION in both PayPalService, and the initializing activity.");
            }
        }
        if (!f.n())
        {
            throw new RuntimeException("Service extras invalid.  Please check the docs.");
        }
        Object obj1 = f.b();
        Object obj;
        if (az.c(((String) (obj1))))
        {
            obj = "https://api-m.paypal.com/v1/";
        } else
        if (az.b(((String) (obj1))))
        {
            obj = "https://api-m.sandbox.paypal.com/v1/";
        } else
        if (az.a(((String) (obj1))))
        {
            obj = null;
        } else
        if (intent.hasExtra("com.paypal.android.sdk.baseEnvironmentUrl"))
        {
            obj = intent.getStringExtra("com.paypal.android.sdk.baseEnvironmentUrl");
        } else
        {
            throw new RuntimeException((new StringBuilder("Invalid environment selected:")).append(((String) (obj1))).toString());
        }
        o = new cv(n, f.b());
        obj = b(((String) (obj1)), ((String) (obj)));
        if (l == null)
        {
            int i1;
            int j1;
            boolean flag;
            boolean flag1;
            if (intent.hasExtra("com.paypal.android.sdk.mockNetworkDelay"))
            {
                i1 = intent.getIntExtra("com.paypal.android.sdk.mockNetworkDelay", 500);
            } else
            {
                i1 = 500;
            }
            if (intent.hasExtra("com.paypal.android.sdk.mockEnable2fa"))
            {
                flag = intent.getBooleanExtra("com.paypal.android.sdk.mockEnable2fa", false);
            } else
            {
                flag = false;
            }
            if (intent.hasExtra("com.paypal.android.sdk.mock2faPhoneNumberCount"))
            {
                j1 = intent.getIntExtra("com.paypal.android.sdk.mock2faPhoneNumberCount", 1);
            } else
            {
                j1 = 1;
            }
            q = true;
            if (intent.hasExtra("com.paypal.android.sdk.enableAuthenticator"))
            {
                q = intent.getBooleanExtra("com.paypal.android.sdk.enableAuthenticator", true);
            }
            if (intent.hasExtra("com.paypal.android.sdk.enableAuthenticatorSecurity"))
            {
                r = intent.getBooleanExtra("com.paypal.android.sdk.enableAuthenticatorSecurity", true);
            }
            if (intent.hasExtra("com.paypal.android.sdk.enableStageSsl"))
            {
                flag1 = intent.getBooleanExtra("com.paypal.android.sdk.enableStageSsl", true);
            } else
            {
                flag1 = true;
            }
            obj1 = n;
            b();
            l = new bb(((a) (obj1)), ((ba) (obj)));
            l.a(new bi(new com.paypal.android.sdk.payments.bi(this, (byte)0)));
            if (az.a(f.b()))
            {
                obj = new ev(l, i1, flag, j1);
            } else
            {
                obj = new by(n, f.b(), b(), l, flag1, Collections.singletonList(new cr(b().c())));
            }
            l.a(new cf(l, ((com.paypal.android.sdk.cg) (obj))));
        }
        ex.b(f.a());
        if (e == null)
        {
            e = new cq();
        }
        if (!f.i())
        {
            obj = n.f();
            Log.w("paypal.sdk", "clearing user data");
            a.submit(new ay(((android.content.Context) (obj))));
        }
        k = intent.getComponent().getPackageName();
        a(ea.a);
        x();
    }

    private void a(cj cj1)
    {
        l.b(cj1);
    }

    private void a(ea ea1, boolean flag, String s1, String s2, String s3)
    {
        j.a(ea1, flag, s1, s2, s3);
    }

    static void a(PayPalService paypalservice, cj cj1)
    {
        paypalservice.e.b = null;
        (new StringBuilder()).append(cj1.n()).append(" request error");
        String s1 = cj1.p().a();
        Log.e("paypal.sdk", s1);
        paypalservice.b(ea.b, s1, cj1.j());
        if (paypalservice.m != null)
        {
            paypalservice.m.a(paypalservice.b(cj1));
            paypalservice.m = null;
        }
        paypalservice.g = false;
    }

    static void a(PayPalService paypalservice, ea ea1, boolean flag, String s1, String s2)
    {
        paypalservice.a(ea1, flag, s1, s2, null);
    }

    private static ba b(String s1, String s2)
    {
        ba ba1 = new ba(s1, s2);
        if (s2 != null)
        {
            if (!s2.startsWith("https://"))
            {
                throw new RuntimeException((new StringBuilder()).append(s2).append(" does not start with 'https://', ignoring ").append(s1).toString());
            }
            s1 = s2;
            if (!s2.endsWith("/"))
            {
                (new StringBuilder()).append(s2).append(" does not end with a slash, adding one.");
                s1 = (new StringBuilder()).append(s2).append("/").toString();
            }
            ch ch1;
            for (s2 = co.d().iterator(); s2.hasNext(); ba1.c().put(ch1.a(), (new StringBuilder()).append(s1).append(ch1.c()).toString()))
            {
                ch1 = (ch)s2.next();
            }

        }
        return ba1;
    }

    private bh b(cj cj1)
    {
        String s1 = cj1.p().a();
        Integer integer = cj1.r();
        cj1.p();
        return new bh(s1, integer);
    }

    static bh b(PayPalService paypalservice, cj cj1)
    {
        return paypalservice.b(cj1);
    }

    private static String b(Intent intent)
    {
        if (intent == null)
        {
            return "Intent = null";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Intent{");
        stringbuilder.append((new StringBuilder("action:")).append(intent.getAction()).toString());
        stringbuilder.append((new StringBuilder(", cmp:")).append(intent.getComponent()).append(", ").toString());
        if (intent.getExtras() == null)
        {
            stringbuilder.append("null extras");
        } else
        {
            stringbuilder.append("extras:");
            Iterator iterator = intent.getExtras().keySet().iterator();
            while (iterator.hasNext()) 
            {
                String s1 = (String)iterator.next();
                stringbuilder.append((new StringBuilder("(")).append(s1).append(":").append(intent.getExtras().get(s1)).append(")").toString());
            }
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    private void b(ea ea1, String s1, String s2)
    {
        a(ea1, false, s1, s2, null);
    }

    static boolean b(PayPalService paypalservice)
    {
        paypalservice.g = false;
        return false;
    }

    static com.paypal.android.sdk.payments.bf c(PayPalService paypalservice)
    {
        return paypalservice.m;
    }

    static void c(PayPalService paypalservice, cj cj1)
    {
        String s1 = cj1.p().a();
        Log.e("paypal.sdk", s1);
        paypalservice.b(ea.c, s1, cj1.j());
        paypalservice.i.a(paypalservice.b(cj1));
    }

    static com.paypal.android.sdk.payments.bf d(PayPalService paypalservice)
    {
        paypalservice.m = null;
        return null;
    }

    static d e(PayPalService paypalservice)
    {
        return paypalservice.h;
    }

    static cv f(PayPalService paypalservice)
    {
        return paypalservice.o;
    }

    static d g(PayPalService paypalservice)
    {
        return paypalservice.i;
    }

    static a h(PayPalService paypalservice)
    {
        return paypalservice.n;
    }

    static String v()
    {
        return c;
    }

    private boolean w()
    {
        return f != null && e != null;
    }

    private void x()
    {
        a(new bc(this), false);
    }

    protected final String a()
    {
        return l.e();
    }

    final void a(int i1)
    {
        l.b(new em(l, b(), l.c(), f.j(), e.h, (String)(new ArrayList(e.e.a.keySet())).get(i1)));
    }

    public final void a(bf bf1)
    {
        a(((cj) (new ek(l, b(), dx.a(bf1)))));
    }

    final void a(ea ea1)
    {
        a(ea1, false, ((String) (null)), ((String) (null)), null);
    }

    final void a(ea ea1, Boolean boolean1)
    {
        a(ea1, boolean1.booleanValue(), ((String) (null)), ((String) (null)), null);
    }

    final void a(ea ea1, Boolean boolean1, String s1)
    {
        a(ea1, boolean1.booleanValue(), ((String) (null)), s1, null);
    }

    final void a(ea ea1, String s1)
    {
        a(ea1, false, ((String) (null)), s1, null);
    }

    final void a(ea ea1, String s1, String s2)
    {
        a(ea1, false, ((String) (null)), s1, s2);
    }

    final void a(eq eq, String s1, boolean flag, String s2, boolean flag1, String s3)
    {
        l.b(new en(l, b(), l.c(), f.j(), eq, s1, e.h, flag, s2, flag1, s3));
    }

    final void a(eq eq, boolean flag, String s1, boolean flag1, String s2)
    {
        l.b(new en(l, b(), l.c(), f.j(), eq, flag, s1, flag1, s2));
    }

    final void a(com.paypal.android.sdk.payments.bd bd1)
    {
        h.a(bd1);
    }

    final void a(com.paypal.android.sdk.payments.bf bf1, boolean flag)
    {
        if (flag)
        {
            e.b = null;
        }
        for (m = bf1; g || e.a();)
        {
            return;
        }

        g = true;
        a(ea.b);
        l.b(new et(f.b(), l, b(), f.j()));
    }

    public final void a(String s1, String s2)
    {
        a(((cj) (new ej(l, b(), s1, s2))));
    }

    final void a(List list)
    {
        l.b(new ef(l, b(), l.c(), f.j(), e.d.b(), e.h, list));
    }

    protected final boolean a(com.paypal.android.sdk.payments.bb bb1)
    {
        if (w())
        {
            return true;
        } else
        {
            p.add(bb1);
            return false;
        }
    }

    final ac b()
    {
        if (d == null)
        {
            d = new br();
        }
        return d;
    }

    final void b(com.paypal.android.sdk.payments.bd bd1)
    {
        i.a(bd1);
    }

    protected final bb c()
    {
        return l;
    }

    protected final cq d()
    {
        return e;
    }

    final PayPalConfiguration e()
    {
        return f;
    }

    protected final String f()
    {
        return f.b();
    }

    protected final String g()
    {
        return f.j();
    }

    final void h()
    {
        q();
        i();
        o.a();
        r();
    }

    final void i()
    {
        e.f = null;
        cs.a(f.b());
        e.c = null;
    }

    final boolean j()
    {
        return e.a();
    }

    final boolean k()
    {
        cq cq1 = e;
        return cq1.f != null && cq1.f.b();
    }

    final boolean l()
    {
        return e.d != null && e.h != null;
    }

    final void m()
    {
        i.b();
    }

    final void n()
    {
        h.b();
    }

    final void o()
    {
        m = null;
    }

    public final IBinder onBind(Intent intent)
    {
        (new StringBuilder("onBind(")).append(b(intent)).append(")");
        if (!w())
        {
            if (s == null)
            {
                a(intent);
            } else
            {
                a(s);
            }
        }
        return u;
    }

    public final void onCreate()
    {
        Log.w("paypal.sdk", (new StringBuilder()).append(com/paypal/android/sdk/payments/PayPalService.getSimpleName()).append(" created. ").append(b().b()).toString());
        new br();
        n = new a(this, "AndroidBasePrefs");
        dl.a(n);
        dn.a(n);
        bd.a(a, this, n, "2.11.1");
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("com.paypal.android.sdk.clearAllUserData");
        com.paypal.android.sdk.payments.e.a(this).a(t, intentfilter);
    }

    public final void onDestroy()
    {
        if (l != null)
        {
            l.a();
            l.b();
            l = null;
        }
        try
        {
            com.paypal.android.sdk.payments.e.a(this).a(t);
        }
        catch (Throwable throwable)
        {
            (new StringBuilder("ignoring:")).append(throwable.getMessage());
        }
        (new StringBuilder("service destroyed: ")).append(this);
    }

    public final void onRebind(Intent intent)
    {
        super.onRebind(intent);
        (new StringBuilder("onRebind(")).append(b(intent)).append(")");
    }

    public final int onStartCommand(Intent intent, int i1, int j1)
    {
        (new StringBuilder("onStartCommand(")).append(b(intent)).append(", ").append(i1).append(", ").append(j1).append(")");
        if (!w())
        {
            (new fk(this)).a();
            if (intent == null || intent.getExtras() == null)
            {
                throw new RuntimeException("Service extras required. Please see the docs.");
            }
            a(intent);
        }
        if (p.size() > 0)
        {
            for (intent = p.iterator(); intent.hasNext(); ((com.paypal.android.sdk.payments.bb)intent.next()).a()) { }
            p.clear();
        }
        return 3;
    }

    public final boolean onUnbind(Intent intent)
    {
        (new StringBuilder("onUnbind(")).append(b(intent)).append(")");
        return true;
    }

    final void p()
    {
        l.b(new el(l, b(), l.c(), e.b.a(), f.j()));
    }

    final void q()
    {
        b = o.a(f.j());
        o.b();
        if (b != null && e.b != null)
        {
            a(e.b.a(), b.e());
            b = null;
        }
    }

    final void r()
    {
        if (f != null && f.n())
        {
            e = new cq();
            x();
        }
    }

    protected final String s()
    {
        return k;
    }

    final boolean t()
    {
        return q;
    }

    final boolean u()
    {
        return r;
    }

}
