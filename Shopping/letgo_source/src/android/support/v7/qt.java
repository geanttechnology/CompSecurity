// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            qu, ox, ul, nf, 
//            tp, um, qr

public class qt extends qu
    implements ox
{

    DisplayMetrics a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    private final ul h;
    private final Context i;
    private final WindowManager j;
    private final nf k;
    private float l;
    private int m;

    public qt(ul ul1, Context context, nf nf1)
    {
        super(ul1);
        b = -1;
        c = -1;
        d = -1;
        e = -1;
        f = -1;
        g = -1;
        h = ul1;
        i = context;
        k = nf1;
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
        a(zzk.zzcE().zzc(i, ai[0]), zzk.zzcE().zzc(i, ai[1]));
    }

    private qr i()
    {
        return (new qr.a()).b(k.a()).a(k.b()).c(k.f()).d(k.c()).e(k.d()).a();
    }

    void a()
    {
        b = zzk.zzcE().zzb(a, a.widthPixels);
        c = zzk.zzcE().zzb(a, a.heightPixels);
        Activity activity = h.c();
        if (activity == null || activity.getWindow() == null)
        {
            d = b;
            e = c;
            return;
        } else
        {
            int ai[] = zzp.zzbx().a(activity);
            d = zzk.zzcE().zzb(a, ai[0]);
            e = zzk.zzcE().zzb(a, ai[1]);
            return;
        }
    }

    public void a(int i1, int j1)
    {
        int k1;
        if (i instanceof Activity)
        {
            k1 = zzp.zzbx().d((Activity)i)[0];
        } else
        {
            k1 = 0;
        }
        b(i1, j1 - k1, f, g);
        h.i().a(i1, j1);
    }

    void b()
    {
        if (h.h().zzsH)
        {
            f = b;
            g = c;
            return;
        } else
        {
            h.measure(0, 0);
            f = zzk.zzcE().zzc(i, h.getMeasuredWidth());
            g = zzk.zzcE().zzc(i, h.getMeasuredHeight());
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
        if (zzb.zzM(2))
        {
            zzb.zzaD("Dispatching Ready Event.");
        }
        c(h.l().zzIz);
    }

    void e()
    {
        a(b, c, d, e, l, m);
    }

    void f()
    {
        qr qr1 = i();
        h.a("onDeviceFeaturesReceived", qr1.a());
    }

    public void zza(ul ul1, Map map)
    {
        c();
    }
}
