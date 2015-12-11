// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public final class ahs
{

    private static final Random k = new SecureRandom();
    private bmr A;
    public final Context a;
    public final bgv b;
    public final bmj c;
    final cgk d;
    public chr e;
    final bmr f = new aih(this);
    final bmr g = new aii(this);
    final bmr h = new aij(this);
    final bmr i = new ahy(this);
    final bmr j = new aia(this);
    private final nd l;
    private final s m = null;
    private final String n;
    private final bmr o = new aht(this);
    private final bmr p = new aid(this);
    private final bmr q = new aie(this);
    private final bmr r = new aif(this);
    private final bmr s = new aig(this);
    private final bmr t = new aik(this);
    private final bmr u = new ahu(this);
    private final bmr v = new ahv(this);
    private final bmr w = new ahw(this);
    private final bmr x = new ahx(this);
    private final bmr y = new ahz(this);
    private final bmr z = new aib(this);

    public ahs(Context context, bgv bgv1, nd nd1, s s1, bmj bmj1, cgk cgk1)
    {
        A = new aic(this);
        a = context.getApplicationContext();
        b = (bgv)b.a(bgv1);
        l = (nd)b.a(nd1);
        c = (bmj)b.a(bmj1);
        bgv1 = bgv1.i();
        if (bgv1.contains("remote_id"))
        {
            context = bgv1.getString("remote_id", "");
        } else
        {
            context = (new BigInteger(130, k)).toString(32);
            bgv1.edit().putString("remote_id", context).apply();
        }
        n = context;
        d = (cgk)b.a(cgk1);
    }

    static cgk a(ahs ahs1)
    {
        return ahs1.d;
    }

    static chr b(ahs ahs1)
    {
        return ahs1.e;
    }

    static bgv c(ahs ahs1)
    {
        return ahs1.b;
    }

    static nd d(ahs ahs1)
    {
        return ahs1.l;
    }

    static Context e(ahs ahs1)
    {
        return ahs1.a;
    }

    static String f(ahs ahs1)
    {
        return ahs1.n;
    }

    static cho g(ahs ahs1)
    {
        return ahs1.c();
    }

    static bmj h(ahs ahs1)
    {
        return ahs1.c;
    }

    static bmr i(ahs ahs1)
    {
        return ahs1.r;
    }

    static boolean j(ahs ahs1)
    {
        return ahs1.l();
    }

    static chl k(ahs ahs1)
    {
        s s1;
        chi chi1;
        if (ahs1.m != null)
        {
            s1 = ahs1.m.a();
        } else
        {
            s1 = null;
        }
        chi1 = new chi(new chh(ahs1.h()));
        if (s1 != null && ahs1.l())
        {
            return new cha(ahs1.b.m(), ahs1.b.c(), s1, chi1);
        } else
        {
            return chi1;
        }
    }

    static ais l(ahs ahs1)
    {
        return (ais)ahs1.u.b_();
    }

    private final boolean l()
    {
        return e.a.d && m != null;
    }

    public final ip a()
    {
        return (ip)o.b_();
    }

    public final aku b()
    {
        return (aku)p.b_();
    }

    final cho c()
    {
        return (cho)q.b_();
    }

    public final amd d()
    {
        return (amd)s.b_();
    }

    public final ajf e()
    {
        return (ajf)t.b_();
    }

    public final ajb f()
    {
        return (ajb)v.b_();
    }

    public final ctx g()
    {
        return (ctx)w.b_();
    }

    public final chs h()
    {
        return (chs)x.b_();
    }

    public final chq i()
    {
        return (chq)y.b_();
    }

    public final aiq j()
    {
        return (aiq)z.b_();
    }

    public final ajl k()
    {
        return (ajl)A.b_();
    }

}
