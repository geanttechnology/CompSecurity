// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.c.c;

public class i
{

    private static final SimpleDateFormat a = new SimpleDateFormat("HH:mm:ss.SSS");
    private static i h;
    private ArrayList b;
    private long c;
    private boolean d;
    private boolean e;
    private boolean f;
    private a g;

    private i()
    {
        c = 0L;
        d();
    }

    private String a(Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            return a.format(date);
        }
    }

    public static i a()
    {
        if (h == null)
        {
            h = new i();
        }
        return h;
    }

    private void a(a a1, boolean flag)
    {
        if (flag)
        {
            org.altbeacon.beacon.c.c.a("Stats", "sample start time, sample stop time, first detection time, last detection time, max millis between detections, detection count", new Object[0]);
        }
    /* block-local class not found */
    class a {}

        org.altbeacon.beacon.c.c.a("Stats", "%s, %s, %s, %s, %s, %s", new Object[] {
            a(a1.e), a(a1.f), a(a1.c), a(a1.d), Long.valueOf(a1.b), Long.valueOf(a1.a)
        });
    }

    private void e()
    {
        org.altbeacon.beacon.c.c.a("Stats", "--- Stats for %s samples", new Object[] {
            Integer.valueOf(b.size())
        });
        Iterator iterator = b.iterator();
        for (boolean flag = true; iterator.hasNext(); flag = false)
        {
            a((a)iterator.next(), flag);
        }

    }

    private void f()
    {
        if (g == null || c > 0L && (new Date()).getTime() - g.e.getTime() >= c)
        {
            c();
        }
    }

    public void a(Beacon beacon)
    {
        f();
        beacon = g;
        beacon.a = ((a) (beacon)).a + 1L;
        if (g.c == null)
        {
            g.c = new Date();
        }
        if (g.d != null)
        {
            long l = (new Date()).getTime() - g.d.getTime();
            if (l > g.b)
            {
                g.b = l;
            }
        }
        g.d = new Date();
    }

    public boolean b()
    {
        return f;
    }

    public void c()
    {
        Date date = new Date();
        if (g != null)
        {
            Date date1 = new Date(g.e.getTime() + c);
            g.f = date1;
            date = date1;
            if (!e)
            {
                date = date1;
                if (d)
                {
                    a(g, true);
                    date = date1;
                }
            }
        }
        g = new a();
        g.e = date;
        b.add(g);
        if (e)
        {
            e();
        }
    }

    public void d()
    {
        b = new ArrayList();
        c();
    }

}
