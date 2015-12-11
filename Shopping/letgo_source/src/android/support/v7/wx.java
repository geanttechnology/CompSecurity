// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.x;

// Referenced classes of package android.support.v7:
//            aaf, wy, la, kx, 
//            wj, wq

class wx
{
    static class a
        implements wj.a
    {

        private final la a;

        public void zza(wq wq1)
        {
            a.a(wq1.b());
            ky.b b1 = new ky.b();
            b1.a("&a", String.valueOf(wq1.c()));
            a.a(b1.a());
        }

        public void zza(wq wq1, Activity activity)
        {
        }

        a(la la1)
        {
            a = la1;
        }
    }


    private final wy a;
    private final Context b;

    public wx(Context context, aaf aaf1, wy wy1)
    {
        b = context;
        a = a(aaf1, wy1);
        b();
    }

    static wy a(aaf aaf1, wy wy1)
    {
        if (aaf1 == null || aaf1.b())
        {
            return wy1;
        } else
        {
            wy1 = new wy.a(wy1.a());
            wy1.a(aaf1.b("trackingId")).a(aaf1.a("trackScreenViews")).b(aaf1.a("collectAdIdentifiers"));
            return wy1.a();
        }
    }

    private void b()
    {
        if (a.b() && !TextUtils.isEmpty(a.d()))
        {
            la la1 = a(a.d());
            la1.a(a.c());
            a(new a(la1));
        }
    }

    la a(String s)
    {
        return kx.a(b).a(s);
    }

    public wy a()
    {
        return a;
    }

    void a(wj.a a1)
    {
        x.a(a1);
        wj wj1 = wj.a(b);
        wj1.a(true);
        wj1.a(a1);
    }
}
