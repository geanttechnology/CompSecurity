// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class boz extends bxi
{

    List a;

    boz(bxm bxm, cpj cpj)
    {
        super(bxm, cpj);
        a = new ArrayList();
        a(bqd.a);
    }

    protected final void a()
    {
        boolean flag;
        if (!a.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
    }

    public final String b()
    {
        return "log_interaction";
    }

    public final eun d()
    {
        dno dno1 = new dno();
        dno1.a = h();
        dno1.b = (dnp[])a.toArray(new dnp[a.size()]);
        dno1.c = System.currentTimeMillis();
        return dno1;
    }
}
