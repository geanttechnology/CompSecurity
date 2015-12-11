// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.altbeacon.beacon.Beacon;

public class c
{

    private HashMap a;
    private HashMap b;

    public c()
    {
        a = new HashMap();
        b = new HashMap();
    }

    private void a(Beacon beacon, HashMap hashmap)
    {
        HashMap hashmap1 = hashmap;
        if (hashmap == null)
        {
            hashmap1 = new HashMap();
            b.put(c(beacon), hashmap1);
        }
        a.put(Integer.valueOf(beacon.hashCode()), beacon);
        hashmap1.put(Integer.valueOf(beacon.hashCode()), beacon);
    }

    private Beacon b(Beacon beacon)
    {
        Beacon beacon2 = null;
        Beacon beacon1 = null;
        HashMap hashmap = (HashMap)b.get(c(beacon));
        if (hashmap != null)
        {
            Iterator iterator = hashmap.values().iterator();
            do
            {
                beacon2 = beacon1;
                if (!iterator.hasNext())
                {
                    break;
                }
                beacon2 = (Beacon)iterator.next();
                if (beacon.l())
                {
                    beacon2.a(beacon.j());
                    beacon2.a(beacon.f());
                } else
                {
                    beacon.a(beacon2.g());
                    beacon1 = beacon;
                }
            } while (true);
        }
        if (!beacon.l())
        {
            a(beacon, hashmap);
        }
        beacon1 = beacon2;
        if (beacon2 == null)
        {
            beacon1 = beacon2;
            if (!beacon.l())
            {
                beacon1 = beacon;
            }
        }
        return beacon1;
    }

    private String c(Beacon beacon)
    {
        return (new StringBuilder()).append(beacon.k()).append(beacon.b()).toString();
    }

    public Beacon a(Beacon beacon)
    {
        this;
        JVM INSTR monitorenter ;
        Beacon beacon1 = beacon;
        if (beacon.b() != -1)
        {
            beacon1 = b(beacon);
        }
        this;
        JVM INSTR monitorexit ;
        return beacon1;
        beacon;
        throw beacon;
    }
}
