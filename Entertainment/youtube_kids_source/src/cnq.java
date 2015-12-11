// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import java.io.File;
import java.util.concurrent.Executor;

public class cnq
{

    final Context a;
    final bgv b;
    public final bmr c = new cns(this);
    private Resources d;
    private final bmr e = new cnr(this);
    private final bmr f = new cnt(this);
    private final bmr g = new cnu(this);

    public cnq(Context context, bgv bgv1)
    {
        a = (Context)b.a(context);
        b = (bgv)b.a(bgv1);
        d = context.getResources();
    }

    public cnh a()
    {
        return cnh.a;
    }

    protected final blu b()
    {
        int i;
        int j;
        j = 0;
        cps cps1 = new cps(d.getDimensionPixelSize(0x7f0a000b), d.getDimensionPixelSize(0x7f0a000c), d.getDimensionPixelSize(0x7f0a000d));
        java.util.concurrent.ExecutorService executorservice = b.c();
        Executor executor = (Executor)b.e.b_();
        Context context = a;
        org.apache.http.client.HttpClient httpclient = b.g();
        String s = b.p().getAbsolutePath();
        bmi bmi = b.b();
        if (bnh.b(a))
        {
            i = 3;
        } else
        {
            i = 2;
        }
        b.a(s);
        cpq.a[i - 1];
        JVM INSTR tableswitch 1 3: default 148
    //                   1 180
    //                   2 186
    //                   3 197;
           goto _L1 _L2 _L3 _L4
_L1:
        i = 0;
_L6:
        return new cpp(executorservice, executor, context, httpclient, s, bmi, cps1, i, j);
_L2:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 50;
        j = 15;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 300;
        j = 100;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final blu c()
    {
        return (blu)e.b_();
    }

    public final cok d()
    {
        return (cok)f.b_();
    }

    public final cnf e()
    {
        return (cnf)g.b_();
    }
}
