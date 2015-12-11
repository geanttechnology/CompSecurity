// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.List;
import java.util.concurrent.Executor;

public final class cpz
{

    private final List a;
    private final mh b;
    private final cqe c;
    private final bmi d;
    private final com e;
    private final Executor f;

    public cpz(List list, mh mh1, cqe cqe1, bmi bmi1, com com1, Executor executor)
    {
        a = (List)b.a(list);
        b = (mh)b.a(mh1);
        c = (cqe)b.a(cqe1);
        d = (bmi)b.a(bmi1);
        e = (com)b.a(com1);
        f = (Executor)b.a(executor);
    }

    public static cqd a(String s, int i)
    {
        return new cqd(0, s, i);
    }

    public final void a(cqd cqd1, mj mj)
    {
        Object obj = cqd1.c;
        boolean flag;
        if (obj != null && ((Uri) (obj)).getScheme() != null && ((Uri) (obj)).getHost() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            f.execute(new cqa(this, mj, ((Uri) (obj))));
            return;
        }
        obj = e.w();
        mj = new cpy(cqd1.a, cqd1.c.toString(), cqd1.d, cqd1.b, cqd1.f, cqd1.e, cqd1.g, cqd1.h, mj, a, d, ((coi) (obj)).a(), cqd1.i);
        bmo.e("Sending from HttpPingService");
        if (!((coi) (obj)).b() || !cqd1.d || c == cqe.a)
        {
            b.a(mj);
            return;
        } else
        {
            c.a();
            return;
        }
    }
}
