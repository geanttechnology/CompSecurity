// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executors;

final class bhb extends bmr
{

    private bgv a;

    bhb(bgv bgv1)
    {
        a = bgv1;
        super();
    }

    public final Object a()
    {
        bgv bgv1 = a;
        return new blf(new blm((biz)bgv1.g.b_()), Executors.newScheduledThreadPool(1), bgv1.b(), blf.a, bgv1.c());
    }
}
