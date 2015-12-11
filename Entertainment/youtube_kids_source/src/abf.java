// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import java.util.Collections;
import java.util.concurrent.Executor;

final class abf extends bmr
{

    private aaa a;

    abf(aaa aaa1)
    {
        a = aaa1;
        super();
    }

    public final Object a()
    {
        ckk ckk = aaa.a(a);
        Object obj = new czh(Collections.emptyList());
        Object obj1 = new cyp(a.c.d());
        rs rs = a.C();
        obj = new rr(a.c.b(), ckk, a.a, ((cyp) (obj1)), a.q().j, (ow)a.G.b_(), rs, aaa.b(a), (ctw)a.B.b_(), a.p(), a.h(), a.c.f(), ((czh) (obj)));
        cxf cxf1;
        if (((KidsApplication)a.a.getApplicationContext()).i())
        {
            obj1 = a.n;
            ctx ctx = a.I();
            Object obj2 = a.K();
            rv rv = aaa.b(a);
            obj2 = new ajk(((ahs) (obj1)).a, ((ahs) (obj1)).b.b(), ((ahs) (obj1)).b.d(), ((ahs) (obj1)).d(), ((ctw) (obj2)), ((ahs) (obj1)).i());
            obj = new ajp(((ahs) (obj1)).d(), rv, ((ahs) (obj1)).b.d(), ((rh) (obj)), ((rh) (obj2)), ctx, ((ahs) (obj1)).g());
            ((ahs) (obj1)).b.d().a(obj);
        } else
        {
            obj = new sd(((rh) (obj)), a.I());
        }
        obj1 = new ud(a.a.getApplicationContext(), a.c.d(), cuf.a, (cud)a.y.b_(), a.c(), null, (blx)a.c.j.b_(), a.c.f(), a.O(), (Executor)a.c.f.b_(), a.w(), aaa.b(a), a.K(), ((rw) (obj)), a.n(), a.u());
        cxf1 = new cxf(a.c.d(), a.a, a.Q(), a.c.i());
        return new rx(a.a.getApplicationContext(), a.c.d(), ckk, cxf1, aaa.b(a), (ctw)a.B.b_(), ((rw) (obj)), rs, (sf)a.L.b_(), ((ud) (obj1)), a.z());
    }
}
