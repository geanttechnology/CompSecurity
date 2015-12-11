// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.HttpClient;

final class aar extends bmr
{

    private aaa a;

    aar(aaa aaa1)
    {
        a = aaa1;
        super();
    }

    public final Object a()
    {
        pb pb1 = new pb(a.c.c(), (HttpClient)a.c.c.b_(), a.i(), a.c.b(), a.c.d(), a.A);
        pb1.h = (bdc)a.C.b_();
        pb1.f = (cub)b.a(a);
        pb1.k = (bfo)a.D.b_();
        pb1.i = (bgm)a.F.b_();
        crl crl = a.g();
        if (pb1.g == null)
        {
            pb1.g = new ArrayList();
        }
        pb1.g.add(crl);
        pb1.k = (bfo)a.D.b_();
        return new pa(pb1);
    }
}
