// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import java.util.Date;
import org.altbeacon.beacon.c.c;

// Referenced classes of package org.altbeacon.beacon.service:
//            a

public class d
{

    public static long a = 10000L;
    private boolean b;
    private long c;
    private a d;

    public d(a a1)
    {
        b = false;
        c = 0L;
        d = a1;
    }

    public a a()
    {
        return d;
    }

    public boolean b()
    {
        c = System.currentTimeMillis();
        if (!b)
        {
            b = true;
            return true;
        } else
        {
            return false;
        }
    }

    public boolean c()
    {
        if (b && c > 0L && (new Date()).getTime() - c > a)
        {
            b = false;
            org.altbeacon.beacon.c.c.a("MonitorState", "We are newly outside the region because the lastSeenTime of %s was %s seconds ago, and that is over the expiration duration of %s", new Object[] {
                Long.valueOf(c), Long.valueOf(System.currentTimeMillis() - c), Long.valueOf(a)
            });
            c = 0L;
            return true;
        } else
        {
            return false;
        }
    }

    public boolean d()
    {
        return b && !c();
    }

}
