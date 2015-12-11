// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Pair;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

class tv
    implements Runnable
{

    public volatile boolean a;
    private final int b;
    private tu c;

    public tv(tu tu1, int i)
    {
        c = tu1;
        super();
        b = i;
    }

    private void a()
    {
        c.v = b;
    }

    private void a(bxb bxb1)
    {
        if (a)
        {
            return;
        } else
        {
            a();
            c.a(bxb1);
            return;
        }
    }

    private void a(ced ced1, Exception exception)
    {
        ebc ebc1 = new ebc();
        ebc1.a = ced1.b;
        ebc1.b = ced1.f;
        ced1 = new dsz();
        ced1.a = 2;
        ced1.b = c.e.a(exception);
        exception = new dsc();
        exception.a = 1;
        duc duc1 = new duc();
        duc1.g = ebc1;
        duc1.a = ced1;
        duc1.i = exception;
        a(new bxb(duc1, 0L));
    }

    static void a(tv tv1)
    {
        tv1.a = true;
    }

    static void a(tv tv1, Exception exception)
    {
        if (!tv1.a)
        {
            tv1.a();
            tu tu1 = tv1.c;
            Object obj = tv1.c;
            obj = csf.d;
            Throwable throwable = bnh.a(exception);
            if ((throwable instanceof cro) || (throwable instanceof crm))
            {
                obj = csf.i;
            }
            tu1.a(new cse(((csf) (obj)), false, tv1.c.e.a(exception), exception));
        }
    }

    static void b(tv tv1)
    {
        if (!tv1.a)
        {
            tv1.c.a(cts.f);
        }
    }

    protected void a(int i)
    {
        b(i);
    }

    protected final boolean b(int i)
    {
        ced ced1;
        ced1 = (ced)c.t.get(i);
        String s = ced1.b;
        crs crs = c.n;
        throw new crn();
        Object obj;
        obj;
        a(ced1, ((Exception) (obj)));
_L2:
        return true;
        obj;
        a(ced1, ((Exception) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        c.p.execute(new tx(this, exception));
        return false;
    }

    public final void run()
    {
        Object obj = null;
        int i = b;
        if (c.l)
        {
            i = c.u[b];
        }
        if (c.t == null)
        {
            Object obj1 = c;
            int j;
            if (((tu) (obj1)).v())
            {
                crs crs = ((tu) (obj1)).n;
                obj1 = ((tu) (obj1)).r;
            } else
            {
                obj = ((tu) (obj1)).n;
                obj = ((tu) (obj1)).q;
                obj = new Pair(null, Collections.emptyList());
            }
            c.s = (cdu)((Pair) (obj)).first;
            c.t = (List)((Pair) (obj)).second;
            j = c.t.size();
            c.u = new int[j];
            if (c.l)
            {
                tu.a(c);
            }
        }
        if (c.t.isEmpty())
        {
            c.p.execute(new tw(this));
        }
        if (i >= c.t.size() || i < 0)
        {
            return;
        } else
        {
            a(i);
            return;
        }
    }
}
