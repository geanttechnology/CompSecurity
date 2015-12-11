// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android;

import android.os.Process;
import com.shazam.android.ae.a.a;
import com.shazam.android.ae.a.b;
import com.shazam.android.ae.h;
import com.shazam.android.ae.i;
import com.shazam.android.ae.l;
import com.shazam.android.ae.m;
import com.shazam.android.ae.n;
import com.shazam.android.ae.p;
import com.shazam.android.ae.r;
import com.shazam.android.ae.s;
import com.shazam.android.view.tagging.b.e;
import com.shazam.i.b.c;
import com.shazam.i.d.d;
import com.shazam.n.f;
import com.shazam.o.j;
import java.security.SecureRandom;
import java.util.EnumMap;

// Referenced classes of package com.shazam.android:
//            ShazamApplication

final class a
    implements Runnable
{

    final ShazamApplication a;

    public final void run()
    {
        (new b(c.a(), "42030e8082b062a685c6048c984f52dc")).a();
        com.shazam.i.j.a.b();
        if (com.shazam.i.b.ac.b.a == null)
        {
            com.shazam.android.ae.a a1 = new com.shazam.android.ae.a();
            EnumMap enummap = new EnumMap(com/shazam/android/ae/n);
            enummap.put(n.a, l.a);
            enummap.put(n.b, l.a);
            enummap.put(n.c, l.a);
            enummap.put(n.d, l.a);
            enummap.put(n.e, new i(new h(com.shazam.i.i.c.a(), com.shazam.i.b.ac.a.a(), new r()), com.shazam.i.o.a.d()));
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
        (new com.shazam.android.ae.a.c(c.a(), d.C())).a();
        com.shazam.i.o.b.b();
        de.psdev.licensesdialog.a.a(new com.shazam.o.f());
        de.psdev.licensesdialog.a.a(new com.shazam.o.a());
        de.psdev.licensesdialog.a.a(new com.shazam.o.h());
        de.psdev.licensesdialog.a.a(new com.shazam.o.i());
        de.psdev.licensesdialog.a.a(new j());
        de.psdev.licensesdialog.a.a(new com.shazam.o.n());
        e.a(com.shazam.i.b.al.c.b());
        com.shazam.i.b.d.a().l();
    }

    (ShazamApplication shazamapplication)
    {
        a = shazamapplication;
        super();
    }
}
