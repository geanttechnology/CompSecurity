// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.util.Log;
import com.paypal.android.sdk.bj;
import com.paypal.android.sdk.cn;
import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.cv;
import com.paypal.android.sdk.cx;
import com.paypal.android.sdk.dj;
import com.paypal.android.sdk.dk;
import com.paypal.android.sdk.dr;
import com.paypal.android.sdk.dy;
import com.paypal.android.sdk.ea;
import com.paypal.android.sdk.eb;
import com.paypal.android.sdk.ec;
import com.paypal.android.sdk.ed;
import com.paypal.android.sdk.ef;
import com.paypal.android.sdk.eh;
import com.paypal.android.sdk.ei;
import com.paypal.android.sdk.ej;
import com.paypal.android.sdk.el;
import com.paypal.android.sdk.em;
import com.paypal.android.sdk.en;
import com.paypal.android.sdk.eq;
import com.paypal.android.sdk.et;
import com.paypal.android.sdk.eu;
import com.paypal.android.sdk.ew;

// Referenced classes of package com.paypal.android.sdk.payments:
//            PayPalService, br, d, bf, 
//            PayPalConfiguration

final class bi
    implements dk
{

    private PayPalService a;

    private bi(PayPalService paypalservice)
    {
        a = paypalservice;
        super();
    }

    bi(PayPalService paypalservice, byte byte0)
    {
        this(paypalservice);
    }

    private static eb a(String s, String s1, long l)
    {
        return new eb(s, s1, 1000L * l + System.currentTimeMillis());
    }

    public final void a()
    {
        PayPalService.v();
    }

    public final void a(ec ec1)
    {
        PayPalService.v();
        a.a(ea.d, ec1.j(), ec1.t());
        a.i();
        PayPalService.g(a).a(br.d());
        PayPalService.g(a).a();
    }

    public final void a(ef ef1)
    {
        PayPalService.v();
        a.a(ea.p, ef1.j());
        PayPalService.g(a).a(ef1.a);
        PayPalService.g(a).a();
    }

    public final void a(eh eh1)
    {
        PayPalService.v();
        PayPalService.g(a).a(eh1);
        PayPalService.g(a).a();
    }

    public final void a(ei ei1)
    {
        PayPalService.v();
        a.a(ea.d, ei1.j(), ei1.v());
        PayPalService.g(a).a(br.d());
        a.q();
        PayPalService.g(a).a();
    }

    public final void a(ej ej1)
    {
        ej1 = ej1.p().a();
        PayPalService.v();
        Log.e("paypal.sdk", ej1);
    }

    public final void a(el el1)
    {
        PayPalService.v();
        PayPalService.g(a).a(el1);
        PayPalService.g(a).a();
    }

    public final void a(em em1)
    {
        PayPalService.v();
        a.d().h = em1.g;
        PayPalService.e(a).a();
    }

    public final void a(en en1)
    {
        long l = 840L;
        PayPalService.v();
        long l1 = en1.f;
        dr dr1;
        if (l1 <= 840L)
        {
            l = l1;
        }
        if (en1.c == null)
        {
            a.d().f = a(en1.d, en1.e, l);
        } else
        {
            a.d().h = en1.g;
            a.d().d = new ed(en1.c, en1.e);
        }
        a.d().e = null;
        dr1 = new dr();
        if (en1.a.a())
        {
            dr1.a(en1.a.b());
            dr1.a(cx.a);
        } else
        {
            dr1.a(en1.a.d());
            dr1.a(cx.b);
        }
        a.d();
        if (en1.a.a())
        {
            a.d().c = en1.a.b();
            a.a(ea.f, Boolean.valueOf(en1.b), en1.j());
        } else
        {
            a.d().c = en1.a.d().a(cn.a());
            a.a(ea.g, Boolean.valueOf(en1.b), en1.j());
        }
        PayPalService.e(a).a();
    }

    public final void a(et et1)
    {
        PayPalService.v();
        a.a(ea.b, et1.j());
        a.d().b = a(et1.a, et1.b, et1.c);
        a.d().g = et1.d;
        PayPalService.b(a);
        if (PayPalService.c(a) != null)
        {
            PayPalService.v();
            PayPalService.c(a).a();
            PayPalService.d(a);
        }
    }

    public final void a(eu eu1)
    {
        PayPalService.v();
        eu1 = new dy(PayPalService.h(a), eu1.t(), eu1.a, eu1.v(), eu1.u(), eu1.w(), eu1.x(), eu1.y());
        PayPalService.f(a).a(eu1, PayPalService.a(a).j());
        PayPalService.g(a).a();
    }

    public final void b(ec ec1)
    {
        ec1.p().a();
        PayPalService.v();
        PayPalService.c(a, ec1);
    }

    public final void b(ef ef1)
    {
        String s = ef1.p().a();
        PayPalService.v();
        Log.e("paypal.sdk", s);
        PayPalService.g(a).a(PayPalService.b(a, ef1));
    }

    public final void b(eh eh1)
    {
        String s = eh1.p().a();
        PayPalService.v();
        Log.e("paypal.sdk", s);
        PayPalService.g(a).a(PayPalService.b(a, eh1));
    }

    public final void b(ei ei1)
    {
        ei1.p().a();
        PayPalService.v();
        PayPalService.c(a, ei1);
    }

    public final void b(el el1)
    {
        String s = el1.p().a();
        PayPalService.v();
        Log.e("paypal.sdk", s);
        PayPalService.g(a).a(PayPalService.b(a, el1));
    }

    public final void b(em em1)
    {
        String s = em1.p().a();
        PayPalService.v();
        Log.e("paypal.sdk", s);
        PayPalService.e(a).a(PayPalService.b(a, em1));
    }

    public final void b(en en1)
    {
        String s = en1.p().a();
        PayPalService.v();
        Log.e("paypal.sdk", s);
        a.i();
        eq eq1 = en1.a;
        boolean flag = en1.b;
        if (eq1.a())
        {
            PayPalService.a(a, ea.f, flag, s, en1.j());
        } else
        {
            PayPalService.a(a, ea.g, flag, s, en1.j());
        }
        PayPalService.f(a).a();
        if (en1.h)
        {
            a.d().h = en1.g;
            a.d().e = new dj(en1.i);
        }
        PayPalService.e(a).a(PayPalService.b(a, en1));
    }

    public final void b(et et1)
    {
        PayPalService.a(a, et1);
    }

    public final void b(eu eu1)
    {
        eu1 = eu1.p().a();
        PayPalService.v();
        Log.e("paypal.sdk", eu1);
        PayPalService.g(a).a();
    }
}
