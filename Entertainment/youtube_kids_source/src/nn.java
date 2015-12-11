// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class nn extends bmr
{

    private nd a;

    nn(nd nd1)
    {
        a = nd1;
        super();
    }

    public final Object a()
    {
        bmj bmj1 = a.s();
        android.content.Context context = a.a;
        android.os.Handler handler = a.c.l();
        String s = a.c.n();
        bkn bkn = a.c.h();
        bmh bmh = a.c.o();
        java.util.concurrent.ExecutorService executorservice = a.c.c();
        cnb cnb1 = new cnb(a.c.i(), a.d(a.a));
        bwu bwu = a.h();
        bmi bmi = a.c.b();
        ckt ckt = a.p();
        boolean flag3 = a.a(a.a, bmj1);
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (a.c(a.a, 1080) && bmj1.g())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((a.c(a.a, 1440) || a.b(1440)) && bmj1.h())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if ((a.c(a.a, 2160) || a.b(2160)) && bmj1.i())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        return new chw(context, handler, s, bkn, bmh, executorservice, cnb1, bwu, bmi, ckt, flag3, flag, flag1, flag2);
    }
}
