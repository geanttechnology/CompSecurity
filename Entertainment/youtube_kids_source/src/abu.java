// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.Locale;

final class abu extends bmr
{

    private aaa a;

    abu(aaa aaa1)
    {
        a = aaa1;
        super();
    }

    public final Object a()
    {
        Object obj = new bke();
        bri bri1 = ((os) (a.O())).a.a;
        boolean flag;
        if (bri1.a() && bri1.a.a.f != null && bri1.a.a.f.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj.a = flag;
        obj = ((bke) (obj)).a();
        return new cqx(new mw(new bkt(a.a, a.a(a.c.n(), a.c.e(), ((bkd) (obj))), String.format(Locale.US, "%s/%s", new Object[] {
            a.a.getPackageName(), a.g(a.a)
        }))), a.d.d(), a.c.b());
    }
}
