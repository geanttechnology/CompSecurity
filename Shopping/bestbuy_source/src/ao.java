// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONObject;

final class ao
{

    private aq a;
    private final an b;
    private final BlockingQueue c = new LinkedBlockingQueue(200);
    private final List d;

    transient ao(aq aq1, an an1, am am, ap aap[])
    {
        a = aq1;
        b = an1;
        d = Arrays.asList(aap);
    }

    private boolean a(af af1)
    {
        if (!c.offer(af1))
        {
            bc.a("In-memory beacon queue is full; agent dropped beacon: %s", af1.b());
            return false;
        } else
        {
            return true;
        }
    }

    final aq a()
    {
        return a;
    }

    final boolean a(JSONObject jsonobject)
    {
        return a(new af(jsonobject, System.currentTimeMillis()));
    }

    final void b()
    {
        ArrayList arraylist = new ArrayList();
        c.drainTo(arraylist);
        bc.a("Persisting %s beacons", arraylist.size());
        b.a(arraylist);
    }

    final void b(JSONObject jsonobject)
    {
        a(new af(jsonobject, System.currentTimeMillis()));
    }

    final void c()
    {
        bc.a("Loading persisted beacons");
        Iterator iterator = b.a().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            af af1 = (af)iterator.next();
            String s = af1.b().optString("type", null);
            boolean flag;
            if (s != null && al.b.contains(s))
            {
                if (System.currentTimeMillis() - af1.a() > al.d)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                a(af1);
            }
        } while (true);
    }

    final boolean d()
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            ap ap1 = (ap)iterator.next();
            try
            {
                ap1.a(this);
            }
            catch (Exception exception)
            {
                bc.b((new StringBuilder("Error thrown by listener: ")).append(ap1.getClass()).append(" before sending beacons.").toString(), exception);
            }
        }

        Object obj = new ArrayList();
        JSONArray jsonarray = new JSONArray();
        c.drainTo(((Collection) (obj)));
        for (Iterator iterator1 = ((ArrayList) (obj)).iterator(); iterator1.hasNext(); jsonarray.put(((af)iterator1.next()).b())) { }
        if (jsonarray.length() > 0 && !a.a(jsonarray))
        {
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a((af)((Iterator) (obj)).next())) { }
            return false;
        } else
        {
            return true;
        }
    }

    public final void e()
    {
        b.b();
    }
}
