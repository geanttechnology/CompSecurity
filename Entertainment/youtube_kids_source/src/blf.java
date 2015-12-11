// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class blf
{

    public static final bll a = new blg();
    public final Map b = new HashMap();
    public final ScheduledExecutorService c;
    public final bll d;
    public final Executor e;
    private final bjb f;
    private final bmi g;

    public blf(bjb bjb1, ScheduledExecutorService scheduledexecutorservice, bmi bmi1, bll bll1, Executor executor)
    {
        f = (bjb)b.a(bjb1);
        c = scheduledexecutorservice;
        g = (bmi)b.a(bmi1);
        d = (bll)b.a(bll1);
        e = (Executor)b.a(executor);
    }

    static bjb a(blf blf1)
    {
        return blf1.f;
    }

    static void a(blf blf1, amv amv1)
    {
        blf1.b(amv1);
    }

    private void a(List list)
    {
        String s;
        for (list = list.iterator(); list.hasNext(); f.a(s))
        {
            s = (String)list.next();
            bmo.e(String.format(Locale.US, "Removing task %s", new Object[] {
                s
            }));
        }

    }

    private void a(List list, long l)
    {
        amv amv1;
        for (list = list.iterator(); list.hasNext(); f.a(amv1.b, amv1))
        {
            amv1 = (amv)list.next();
            bmo.e(String.format(Locale.US, "Updating task %s", new Object[] {
                amv1.b
            }));
            amv1.a(amv1.e + l);
        }

    }

    private void b(amv amv1)
    {
        long l = Math.max(amv1.d - g.a(), 0L);
        blj blj1 = new blj(this);
        if (amv1.e > 0L)
        {
            bmo.e(String.format(Locale.US, "Scheduling task %s with ScheduledExecutorService for repeating execution.", new Object[] {
                amv1.b
            }));
            c.scheduleAtFixedRate(blj1, l, amv1.e, TimeUnit.MILLISECONDS);
            return;
        } else
        {
            bmo.e(String.format(Locale.US, "Scheduling task %s with ScheduledExecutorService for one time execution.", new Object[] {
                amv1.b
            }));
            c.schedule(blj1, l, TimeUnit.MILLISECONDS);
            return;
        }
    }

    static void b(blf blf1)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        long l;
        b.b();
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        l = blf1.g.a();
        bjc bjc1 = blf1.f.d();
        do
        {
            if (!bjc1.hasNext())
            {
                break;
            }
            amv amv1 = (amv)bjc1.next();
            Object obj = (ble)blf1.b.get(amv1.b);
            if (obj == null)
            {
                obj = String.valueOf(amv1.b);
                if (((String) (obj)).length() != 0)
                {
                    obj = "Missing task factory for task type: ".concat(((String) (obj)));
                } else
                {
                    obj = new String("Missing task factory for task type: ");
                }
                bmo.c(((String) (obj)));
                arraylist.add(amv1.b);
            } else
            {
                obj = ((ble) (obj)).a(amv1);
                if (l >= ((bld) (obj)).a.d)
                {
                    bmo.e(String.format(Locale.US, "Executed scheduled task of type %s", new Object[] {
                        ((bld) (obj)).b()
                    }));
                    blf1.e.execute(new blk(blf1, ((bld) (obj))));
                    boolean flag;
                    if (((bld) (obj)).a.e > 0L)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        arraylist.add(((bld) (obj)).b());
                    } else
                    {
                        arraylist1.add(amv1);
                    }
                }
            }
        } while (true);
        bjc1.a();
        blf1.f.a();
        blf1.a(arraylist);
        blf1.a(arraylist1, l);
        blf1.f.c();
        blf1.f.b();
        return;
        Exception exception;
        exception;
        blf1.f.b();
        throw exception;
    }

    public final void a(amv amv1)
    {
        this;
        JVM INSTR monitorenter ;
        b.b();
        f.a(amv1.b, amv1);
        b(amv1);
        this;
        JVM INSTR monitorexit ;
        return;
        amv1;
        throw amv1;
    }

}
