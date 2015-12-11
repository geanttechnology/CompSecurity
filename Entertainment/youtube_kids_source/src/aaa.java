// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

public final class aaa extends nd
{

    final bjp A;
    final bmr B = new aan(this);
    final bmr C = new aap(this);
    final bmr D = new aaq(this);
    final bmr E = new aar(this);
    final bmr F = new aas(this);
    final bmr G = new aat(this);
    final bmr H = new aav(this);
    final bmr I = new aaw(this);
    public final bmr J = new aaz(this);
    final bmr K = new abg(this);
    final bmr L = new abj(this);
    public final bmr M = new abl(this);
    public final bmr N = new abm(this);
    public final bmr O = new abn(this);
    final bmr P = new abp(this);
    public final bmr Q = new abr(this);
    private final bmr R = new aam(this);
    private final bmr S = new abu(this);
    private final bmr T = new aac(this);
    private final bmr U = new aah(this);
    private final bmr V = new aal(this);
    private final bmr W = new aao(this);
    private final bmr X = new aau(this);
    private final bmr Y = new aay(this);
    private final bmr Z = new aba(this);
    private final bmr aa = new abb(this);
    private final bmr ab = new abc(this);
    private final bmr ac = new abd(this);
    private final bmr ad = new abe(this);
    private final bmr ae = new abf(this);
    private final bmr af = new abh(this);
    private final bmr ag = new abk(this);
    private final bmr ah = new abo(this);
    private final bmr ai = new abq(this);
    public ahs n;
    final bmr o = new aab(this);
    public final bmr p = new aax(this);
    public final bmr q = new abi(this);
    public final bmr r = new abs(this);
    final bmr s = new abv(this);
    final bmr t = new abw(this);
    final bmr u = new aby(this);
    final bmr v = new aad(this);
    final bmr w = new aae(this);
    final bmr x = new aag(this);
    final bmr y = new aai(this);
    final bmr z = new aaj(this);

    public aaa(Context context, bgv bgv1, cnq cnq1)
    {
        super(context, bgv1, cnq1, new acm(context, context.getContentResolver(), bgv1.b()));
        A = new aak(this, c.c());
    }

    private bxr T()
    {
        return new oz((bdc)C.b_(), c.k(), (PackageManager)c.h.b_());
    }

    static ckk a(aaa aaa1)
    {
        Object obj = new aaf(aaa1);
        clj clj1 = new clj(aaa1.d.e(), (mh)aaa1.t.b_(), new cqs[] {
            aaa1.l(), aaa1.m()
        });
        chw chw1 = aaa1.q();
        cvl cvl = aaa1.a(aaa1.q().a());
        aaa1 = aaa1.e;
        obj = new cjx(chw1.b, chw1.k, chw1.g, chw1.l, chw1.f, ((cka) (obj)));
        aaa1 = ((aaa) (obj));
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            aaa1 = (WindowManager)chw1.b.getSystemService("window");
            aaa1 = new cjg(new cjh(chw1.g, chw1.h, chw1.i, cvl, chw1.k, chw.a, chw1.e, chw1.l, clj1, chw1.j, null, null, new chx(chw1, aaa1)), ((ckk) (obj)), chw1.b, chw1.j);
        }
        return new ckn(aaa1);
    }

    static rv b(aaa aaa1)
    {
        return (rv)aaa1.V.b_();
    }

    public final acn A()
    {
        return (acn)T.b_();
    }

    protected final bfi B()
    {
        return (bfi)X.b_();
    }

    public final rs C()
    {
        return new rs(new bgm((cpz)I.b_(), (cpz)H.b_(), c.b(), c.d(), (ctw)B.b_(), y(), B(), D()), new cwq(c.b(), c.c(), c.l(), (bor)Y.b_(), a.b(a)), new pg(a, c.b(), q().c, q().d, new cxe()), null, new cwz((cpz)H.b_(), c.h(), d.e(), new bdm((bdi)z.b_()), c.c()), new pm(c.d(), (cpz)Z.b_(), c.b(), c.h(), c.o(), d.e(), q().c, q().d, q().m, q().n, o(), ((acm)super.s()).m(), (czk)O.b_()), new px((cpz)aa.b_(), c.b(), c.h(), c.d(), d.e(), D(), r()), new ve((cpz)Z.b_(), c.c(), z()));
    }

    public final crh D()
    {
        return (crh)ac.b_();
    }

    public final bok E()
    {
        return (bok)R.b_();
    }

    public final cpz F()
    {
        return (cpz)H.b_();
    }

    public final mh G()
    {
        return (mh)u.b_();
    }

    public final rx H()
    {
        return (rx)ae.b_();
    }

    public final ctx I()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(w());
        Object obj;
        if (a.e(a) && (new bgs(c.i())).a())
        {
            obj = new bgu(T(), c.i());
        } else
        {
            obj = T();
        }
        arraylist.add(obj);
        return new crq(c.d(), J(), n(), u(), c.c(), arraylist);
    }

    public final bpa J()
    {
        return (bpa)ah.b_();
    }

    public final ctw K()
    {
        return (ctw)B.b_();
    }

    public final acb L()
    {
        return (acb)W.b_();
    }

    public final bpj M()
    {
        return (bpj)U.b_();
    }

    public final bov N()
    {
        return (bov)ai.b_();
    }

    public final acm O()
    {
        return (acm)super.s();
    }

    public final ly P()
    {
        return (ly)S.b_();
    }

    public final cxn Q()
    {
        return (cxn)ag.b_();
    }

    public final acd R()
    {
        return (acd)ab.b_();
    }

    public final bqc S()
    {
        return (bqc)af.b_();
    }

    public final ctx a(buz buz)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(w());
        arraylist.add(new bda(buz));
        return new crq(c.d(), J(), n(), u(), c.c(), arraylist);
    }

    public final mh a()
    {
        return (mh)t.b_();
    }

    public final cog b()
    {
        return acl.a;
    }

    public final bmj s()
    {
        return (acm)super.s();
    }

    public final bog t()
    {
        return (bog)ad.b_();
    }
}
