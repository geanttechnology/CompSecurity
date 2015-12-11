// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public final class bkx
{

    private static final Comparator a = new bky();
    private final Map b;
    private final Map c = new ConcurrentHashMap();
    private final Executor d;

    public bkx(Map map, Executor executor)
    {
        new Object();
        b = (Map)b.a(map);
        d = (Executor)b.a(executor);
    }

    static void a(bkx bkx1, blb blb)
    {
        b.b();
        blb = new ArrayList();
        Iterator iterator = bkx1.c.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            cl cl1 = (cl)iterator.next();
            if (bkx1.a(cl1))
            {
                blb.add(cl1);
            }
        } while (true);
        Collections.sort(blb, a);
        blb = blb.iterator();
        while (blb.hasNext()) 
        {
            bkx1 = String.valueOf(((cl)blb.next()).a());
            if (bkx1.length() != 0)
            {
                bkx1 = "Executing ConditionTask ".concat(bkx1);
            } else
            {
                bkx1 = new String("Executing ConditionTask ");
            }
            bmo.e(bkx1);
        }
    }

    private boolean a(cl cl1)
    {
        for (cl1 = cl1.b().iterator(); cl1.hasNext();)
        {
            String s = (String)cl1.next();
            if (!((bla)b.get(s)).a())
            {
                return false;
            }
        }

        return true;
    }

    public final void handleConditionReachedNotification(blb blb)
    {
        d.execute(new bkz(this, blb));
    }

}
