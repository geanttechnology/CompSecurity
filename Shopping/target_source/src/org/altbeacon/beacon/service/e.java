// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.c.c;

// Referenced classes of package org.altbeacon.beacon.service:
//            f, a

public class e
{

    private static boolean c = false;
    private a a;
    private Map b;

    public e(a a1)
    {
        b = new HashMap();
        a = a1;
    }

    public a a()
    {
        return a;
    }

    public void a(Beacon beacon)
    {
        if (b.containsKey(beacon))
        {
            f f1 = (f)b.get(beacon);
            org.altbeacon.beacon.c.c.a("RangeState", "adding %s to existing range for: %s", new Object[] {
                beacon, f1
            });
            f1.a(beacon);
            return;
        } else
        {
            org.altbeacon.beacon.c.c.a("RangeState", "adding %s to new rangedBeacon", new Object[] {
                beacon
            });
            b.put(beacon, new f(beacon));
            return;
        }
    }

    public Collection b()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        ArrayList arraylist;
        obj1 = new HashMap();
        arraylist = new ArrayList();
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = b.keySet().iterator();
_L1:
        Beacon beacon;
        f f1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_191;
        }
        beacon = (Beacon)iterator.next();
        f1 = (f)b.get(beacon);
        if (f1.a())
        {
            f1.c();
            if (!f1.d())
            {
                arraylist.add(f1.b());
            }
        }
        boolean flag;
        if (!f1.d())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        if (!c || f1.f())
        {
            f1.a(false);
        }
        ((Map) (obj1)).put(beacon, f1);
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        org.altbeacon.beacon.c.c.a("RangeState", "Dumping beacon from RangeState because it has no recent measurements.", new Object[0]);
          goto _L1
        b = ((Map) (obj1));
        obj;
        JVM INSTR monitorexit ;
        this;
        JVM INSTR monitorexit ;
        return arraylist;
    }

}
