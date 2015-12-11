// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.h;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.b:
//            be, cj, s, bz, 
//            ck, bc

public class bd extends be
{

    DisplayMetrics a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    private final cj h;
    private final Context i;
    private final WindowManager j;
    private final s k;
    private float l;
    private int m;

    public bd(cj cj1, Context context, s s1)
    {
        super(cj1);
        b = -1;
        c = -1;
        d = -1;
        e = -1;
        f = -1;
        g = -1;
        h = cj1;
        i = context;
        k = s1;
        j = (WindowManager)context.getSystemService("window");
    }

    private void g()
    {
        a = new DisplayMetrics();
        Display display = j.getDefaultDisplay();
        display.getMetrics(a);
        l = a.density;
        m = display.getRotation();
    }

    private void h()
    {
        int ai[] = new int[2];
        h.getLocationOnScreen(ai);
        a(com.google.android.gms.ads.internal.client.h.a().b(i, ai[0]), com.google.android.gms.ads.internal.client.h.a().b(i, ai[1]));
    }

    private bc i()
    {
        return (new bc.a()).b(k.a()).a(k.b()).c(k.f()).d(k.c()).e(k.d()).a();
    }

    void a()
    {
        b = com.google.android.gms.ads.internal.client.h.a().b(a, a.widthPixels);
        c = com.google.android.gms.ads.internal.client.h.a().b(a, a.heightPixels);
        Activity activity = h.c();
        if (activity == null || activity.getWindow() == null)
        {
            d = b;
            e = c;
            return;
        } else
        {
            int ai[] = com.google.android.gms.ads.internal.c.c().a(activity);
            d = com.google.android.gms.ads.internal.client.h.a().b(a, ai[0]);
            e = com.google.android.gms.ads.internal.client.h.a().b(a, ai[1]);
            return;
        }
    }

    public void a(int i1, int j1)
    {
        int k1;
        if (i instanceof Activity)
        {
            k1 = com.google.android.gms.ads.internal.c.c().d((Activity)i)[0];
        } else
        {
            k1 = 0;
        }
        b(i1, j1 - k1, f, g);
        h.h().a(i1, j1);
    }

    void b()
    {
        if (h.g().e)
        {
            f = b;
            g = c;
            return;
        } else
        {
            h.measure(0, 0);
            f = com.google.android.gms.ads.internal.client.h.a().b(i, h.getMeasuredWidth());
            g = com.google.android.gms.ads.internal.client.h.a().b(i, h.getMeasuredHeight());
            return;
        }
    }

    public void c()
    {
        g();
        a();
        b();
        e();
        f();
        h();
        d();
    }

    void d()
    {
        if (com.google.android.gms.ads.internal.util.client.b.a(2))
        {
            com.google.android.gms.ads.internal.util.client.b.c("Dispatching Ready Event.");
        }
        c(h.k().b);
    }

    void e()
    {
        a(b, c, d, e, l, m);
    }

    void f()
    {
        bc bc1 = i();
        h.a("onDeviceFeaturesReceived", bc1.a());
    }
}
