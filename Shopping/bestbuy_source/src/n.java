// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

final class n
    implements Runnable
{

    private final String a;
    private final Context b;
    private final ScheduledExecutorService c;
    private final String d;
    private final String e;
    private final String f;

    private n(String s1, Context context, ScheduledExecutorService scheduledexecutorservice, String s2, String s3, String s4)
    {
        a = s1;
        b = context;
        c = scheduledexecutorservice;
        d = s2;
        f = s4;
        e = s3;
    }

    n(String s1, Context context, ScheduledExecutorService scheduledexecutorservice, String s2, String s3, String s4, byte byte0)
    {
        this(s1, context, scheduledexecutorservice, s2, s3, s4);
    }

    public final void run()
    {
        int i;
        i = 1;
        bc.a((new StringBuilder("Started to run ")).append(getClass().getName()).toString());
        aa aa1;
        Object obj;
        obj = new z(b);
        aa1 = new aa(((z) (obj)));
        aa1.a();
        if (aa1.a("disable_until") <= System.currentTimeMillis())
        {
            i = 0;
        }
        if (i != 0)
        {
            ae ae1;
            am am1;
            Object obj1;
            Object obj2;
            Object obj3;
            ah ah1;
            ax ax1;
            bf bf1;
            try
            {
                l.e = false;
                return;
            }
            catch (Throwable throwable)
            {
                Log.d("ADInstrumentation", "Error starting AppDynamics instrumentation", throwable);
            }
            break MISSING_BLOCK_LABEL_499;
        }
        i = l.b().a();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        l.d.b(i);
        obj1 = new an(new y(((z) (obj)), aa1));
        obj = new a(b);
        ((a) (obj)).a();
        ae1 = new ae();
        am1 = new am(b, f, a);
        obj2 = m.a(d, e, am1, l.c());
        obj3 = new ArrayList();
        ((List) (obj3)).add(l.g);
        obj1 = new ao(new aq(((m) (obj2)), l.d, ((List) (obj3))), ((an) (obj1)), am1, new ap[] {
            l.f
        });
        obj2 = new ag(am1, ((a) (obj)), az.a, l.d);
        l.b.a(((ao) (obj1)));
        l.b.a(((ag) (obj2)));
        l.g.a(((ao) (obj1)));
        l.g.a(((ag) (obj2)));
        l.f.a(((ag) (obj2)));
        l.h.a(((ag) (obj2)), ((ao) (obj1)));
        obj3 = new bk(((ag) (obj2)), ((ao) (obj1)), l.a);
        ah1 = new ah(((ao) (obj1)), c, l.a);
        ae1.a(ah1);
        ah1.a(new Runnable(((bk) (obj3))) {

            private bk a;

            public final void run()
            {
                a.a(10000);
            }

            
            {
                a = bk1;
                super();
            }
        }, 10000);
        ah1.a(new o(ah1, l.f, l.g), al.c);
        ax1 = new ax(((ag) (obj2)), ((ao) (obj1)), l.a);
        bf1 = new bf(((ao) (obj1)), ((ag) (obj2)), 60000);
        l.c = new l(a, ((ao) (obj1)), aa1, ((bk) (obj3)), ax1, bf1, b, am1, c, ((ag) (obj2)), ae1, ((a) (obj)), (byte)0);
        l.g.a(ah1);
        bc.a("Instrumentation has been initialized.");
        l.b().a(((ao) (obj1)));
        l.b().a(((ao) (obj1)), ah1);
        return;
    }
}
