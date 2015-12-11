// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Process;
import android.support.a.b;
import com.b.a.i;
import com.facebook.k;
import com.shazam.android.ae.m;
import com.shazam.android.ae.n;
import com.shazam.android.ae.p;
import com.shazam.android.ae.r;
import com.shazam.android.ae.s;
import com.shazam.android.analytics.event.StartupEvent;
import com.shazam.android.ax.h;
import com.shazam.android.persistence.e.e;
import com.shazam.android.service.player.j;
import com.shazam.android.service.player.l;
import com.shazam.i.b.ah.f;
import com.shazam.i.b.d;
import com.shazam.i.b.g.b.c;
import com.shazam.i.o.a;
import com.shazam.k.t;
import com.shazam.model.account.UserState;
import com.shazam.model.configuration.InstallationIdRepository;
import com.shazam.model.rdio.RdioConnectionState;
import com.shazam.o.q;
import java.security.SecureRandom;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.shazam.android:
//            e

public class ShazamApplication extends b
{
    private final class a
        implements com.facebook.k.a
    {

        final ShazamApplication a;

        public final void a()
        {
            com.shazam.android.u.c c1 = com.shazam.i.b.u.a.a();
            if (com.shazam.b.e.a.a(c1.a()))
            {
                c1.b.submit(c1.c);
            }
        }

        private a()
        {
            a = ShazamApplication.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    private final List a = new ArrayList();
    private final ExecutorService b = com.shazam.i.o.a.b();
    private com.shazam.android.j.e c;
    private com.shazam.android.aa.a d;
    private com.shazam.android.ac.b e;

    public ShazamApplication()
    {
        c = (new com.shazam.android.j.e.a()).a();
        d = com.shazam.android.aa.a.a;
    }

    static com.shazam.android.aa.a a(ShazamApplication shazamapplication, com.shazam.android.aa.a a1)
    {
        shazamapplication.d = a1;
        return a1;
    }

    private void a(PackageManager packagemanager, String s)
    {
        try
        {
            packagemanager.setComponentEnabledSetting(new ComponentName(this, s), 1, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PackageManager packagemanager)
        {
            return;
        }
    }

    static void a(ShazamApplication shazamapplication)
    {
        try
        {
            i.a(shazamapplication);
            i.c();
            i.b("a7b7f8b55b80291d9aee5ea4c0e63581");
            i.a("17885264");
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            m.a(shazamapplication, "Failed to initialize ComScore SDK", runtimeexception);
        }
    }

    private transient void a(android.app.Application.ActivityLifecycleCallbacks aactivitylifecyclecallbacks[])
    {
        Collections.addAll(a, aactivitylifecyclecallbacks);
        for (int i1 = 0; i1 < 5; i1++)
        {
            registerActivityLifecycleCallbacks(aactivitylifecyclecallbacks[i1]);
        }

    }

    public final com.shazam.android.j.e a()
    {
        this;
        JVM INSTR monitorenter ;
        com.shazam.android.j.e e1 = c;
        this;
        JVM INSTR monitorexit ;
        return e1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(com.shazam.android.j.e e1)
    {
        this;
        JVM INSTR monitorenter ;
        c = e1;
        this;
        JVM INSTR monitorexit ;
        return;
        e1;
        throw e1;
    }

    public void onCreate()
    {
        super.onCreate();
        Object obj = com.shazam.i.b.g.b.c.a();
        ((StartupEvent) (obj)).markApplicationCreationStarted();
        (new com.shazam.android.e()).a(this);
        (new Thread(new Runnable() {

            final ShazamApplication a;

            public final void run()
            {
                (new com.shazam.android.ae.a.b(com.shazam.i.b.c.a(), "42030e8082b062a685c6048c984f52dc")).a();
                com.shazam.i.j.a.b();
                if (com.shazam.i.b.ac.b.a == null)
                {
                    com.shazam.android.ae.a a1 = new com.shazam.android.ae.a();
                    EnumMap enummap = new EnumMap(com/shazam/android/ae/n);
                    enummap.put(n.a, com.shazam.android.ae.l.a);
                    enummap.put(n.b, com.shazam.android.ae.l.a);
                    enummap.put(n.c, com.shazam.android.ae.l.a);
                    enummap.put(n.d, com.shazam.android.ae.l.a);
                    enummap.put(n.e, new com.shazam.android.ae.i(new com.shazam.android.ae.h(com.shazam.i.i.c.a(), com.shazam.i.b.ac.a.a(), new r()), com.shazam.i.o.a.d()));
                    com.shazam.i.b.ac.b.a = new com.shazam.android.ae.c(new p[] {
                        a1, new s(enummap)
                    });
                }
                m.a(com.shazam.i.b.ac.b.a);
                com.appnexus.opensdk.b.b.a = false;
                new SecureRandom();
                Process.setThreadPriority(10);
                com.shazam.android.ShazamApplication.a(a);
                com.shazam.android.ShazamApplication.a(a, com.shazam.i.b.aa.a.a());
                com.shazam.i.p.a.a().c();
                (new com.shazam.android.ae.a.c(com.shazam.i.b.c.a(), com.shazam.i.d.d.C())).a();
                com.shazam.i.o.b.b();
                de.psdev.licensesdialog.a.a(new com.shazam.o.f());
                de.psdev.licensesdialog.a.a(new com.shazam.o.a());
                de.psdev.licensesdialog.a.a(new com.shazam.o.h());
                de.psdev.licensesdialog.a.a(new com.shazam.o.i());
                de.psdev.licensesdialog.a.a(new com.shazam.o.j());
                de.psdev.licensesdialog.a.a(new com.shazam.o.n());
                com.shazam.android.view.tagging.b.e.a(com.shazam.i.b.al.c.b());
                com.shazam.i.b.d.a().l();
            }

            
            {
                a = ShazamApplication.this;
                super();
            }
        }, "Async Class Loader")).start();
        k.a(getApplicationContext(), new a((byte)0));
        k.n();
        k.c();
        Object obj1 = new e(f.a(), com.shazam.i.b.r.a.a(), com.shazam.i.b.d.a());
        Object obj2 = ((e) (obj1)).c.d();
        ((e) (obj1)).a.b("pk_registration", (new StringBuilder()).append(((String) (obj2))).append("auth/v1/register").toString());
        obj2 = ((e) (obj1)).c.e();
        ((e) (obj1)).a.b("pk_registration_upgrade", (new StringBuilder()).append(((String) (obj2))).append("shazam/v1/registerUpgrade").toString());
        obj2 = ((e) (obj1)).c.c();
        ((e) (obj1)).a.b("pk_requestConfig", (new StringBuilder()).append(((String) (obj2))).append("orbit/RequestConfig2").toString());
        obj2 = Locale.getDefault();
        ((e) (obj1)).a.b("pk_locale", (new StringBuilder()).append(((Locale) (obj2)).getLanguage()).append("_").append(((Locale) (obj2)).getCountry()).toString());
        boolean flag;
        long l1;
        try
        {
            obj2 = com.shazam.android.ag.a.a("ShazamId_SmartPhone_Gamma__5.12.1");
        }
        catch (ParseException parseexception)
        {
            throw new com.shazam.android.persistence.e.a((new StringBuilder("Failed to parse appId from resources: ")).append("ShazamId_SmartPhone_Gamma__5.12.1").toString(), parseexception);
        }
        ((e) (obj1)).b.a(((com.shazam.android.ag.a) (obj2)), ((e) (obj1)).a);
        try
        {
            String s = ((e) (obj1)).c.a();
            if (com.shazam.b.e.a.c(s))
            {
                ((com.shazam.android.ag.a) (obj2)).c(s);
                (new StringBuilder("TestMode overriding channel: ")).append(((com.shazam.android.ag.a) (obj2)).d);
            }
            s = ((e) (obj1)).c.b();
            if (com.shazam.b.e.a.c(s))
            {
                obj2.c = new com.shazam.android.ag.b(s);
                ((com.shazam.android.ag.a) (obj2)).a();
                (new StringBuilder("TestMode overriding version: ")).append(((com.shazam.android.ag.a) (obj2)).c);
            }
        }
        catch (ParseException parseexception1) { }
        (new StringBuilder("Channel: ")).append(((com.shazam.android.ag.a) (obj2)).d);
        ((e) (obj1)).a.b("pk_appId", ((com.shazam.android.ag.a) (obj2)).b);
        a(com.shazam.i.b.ah.c.c.a().b());
        obj1 = new com.shazam.android.ba.a();
        l1 = ((com.shazam.android.ba.a) (obj1)).a.g("pk_knowCode");
        if (l1 < 0x7b0c0L && ((com.shazam.android.ba.a) (obj1)).c.a())
        {
            ((com.shazam.android.ba.a) (obj1)).b.a(UserState.MIGRATION_CANDIDATE);
        }
        if (l1 != 0x7d064L)
        {
            ((com.shazam.android.ba.a) (obj1)).a();
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj1 = com.shazam.i.b.c.a().getPackageManager();
            a(((PackageManager) (obj1)), "com.shazam.android.activities.TagDetailsDisplay");
            a(((PackageManager) (obj1)), "com.shazam.android.activities.MusicDetailsActivity");
        }
        h.a.a();
        obj1 = new q(2L, TimeUnit.SECONDS);
        e = new com.shazam.android.ac.b(((q) (obj1)), new com.shazam.android.ac.a[] {
            new com.shazam.android.ac.d(com.shazam.i.b.ar.a.c.a()), new l(com.shazam.i.b.an.a.a.a(), new j(), ((q) (obj1))), new com.shazam.android.ad.d(com.shazam.i.b.g.c.c.a(), ((q) (obj1))), com.shazam.i.b.w.e.b.a(), new com.shazam.android.ac.e(com.shazam.i.b.ar.a.e.a())
        });
        a(new android.app.Application.ActivityLifecycleCallbacks[] {
            new com.shazam.android.ad.a.d(b), new com.shazam.android.ad.a.b(), e, new com.shazam.android.ad.a.i(), new com.shazam.android.ac.c()
        });
        com.shazam.i.b.ai.a.a.a().a(com.shazam.i.b.ap.a.a().a());
        ((StartupEvent) (obj)).markApplicationCreationEnded();
        obj = new com.shazam.android.j.m(f.a(), com.shazam.i.b.at.a.a());
        ((com.shazam.android.j.m) (obj)).a.a("pk_l_a_l", ((com.shazam.android.j.m) (obj)).b.a());
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        d.b();
    }

    public void onTerminate()
    {
        super.onTerminate();
        d.a();
        for (Iterator iterator = a.iterator(); iterator.hasNext(); unregisterActivityLifecycleCallbacks((android.app.Application.ActivityLifecycleCallbacks)iterator.next())) { }
        if (e != null)
        {
            com.shazam.android.ac.b b1 = e;
            b1.a.removeCallbacks(b1);
        }
    }

    public void onTrimMemory(int i1)
    {
        super.onTrimMemory(i1);
        d.c();
    }
}
