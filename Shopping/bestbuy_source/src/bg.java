// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;

final class bg
    implements ap
{

    private static final Pattern a = Pattern.compile("([a-zA-Z0-9]+\\s*)+");
    private final int b;
    private final int c;
    private final int d;
    private final Map e;
    private final Map f;
    private ag g;

    bg()
    {
        this(16, 100, 50);
    }

    private bg(int i, int j, int k)
    {
        e = new HashMap(5);
        f = new HashMap();
        g = null;
        b = (Math.max(Math.abs(16), 2) >> 1) << 1;
        c = Math.max(1, Math.abs(100));
        d = 50;
    }

    final void a(ag ag)
    {
        g = ag;
    }

    public final void a(ao ao1)
    {
        if (g != null) goto _L2; else goto _L1
_L1:
        bc.a("Could not generate beacons because beaconBuilder is not set");
_L6:
        return;
_L2:
        synchronized (e)
        {
            if (e.size() != 0)
            {
                break MISSING_BLOCK_LABEL_48;
            }
        }
        return;
        ao1;
        map;
        JVM INSTR monitorexit ;
        try
        {
            throw ao1;
        }
        // Misplaced declaration of an exception variable
        catch (ao ao1)
        {
            bc.b("Error draining captured metric data to beacon queue", ao1);
        }
        return;
        ArrayList arraylist;
        bc.a("Draining collected beacons into beacon queue.");
        arraylist = new ArrayList(e.values());
        e.clear();
        map;
        JVM INSTR monitorexit ;
        Iterator iterator;
        bc.a("Adding #%d metrics to the beacon queue.", arraylist.size());
        iterator = arraylist.iterator();
        int i = 0;
_L4:
        org.json.JSONObject jsonobject;
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            jsonobject = ((bh)iterator.next()).a();
        } while (jsonobject == null);
        if (!ao1.a(jsonobject))
        {
            bc.a("Beacon queue is full, dropping #%d metricKey observations.", arraylist.size() - i);
            return;
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final boolean a()
    {
        Map map = e;
        map;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (e.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        map;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
