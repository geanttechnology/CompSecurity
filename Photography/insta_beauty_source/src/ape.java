// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ape
{

    protected File a;
    final apc b;
    private final AtomicLong c;
    private final AtomicInteger d;
    private final int e;
    private final int f;
    private final Map g;

    private ape(apc apc, File file, int i, int j)
    {
        b = apc;
        super();
        g = Collections.synchronizedMap(new HashMap());
        a = file;
        e = i;
        f = j;
        c = new AtomicLong();
        d = new AtomicInteger();
        a();
    }

    ape(apc apc, File file, int i, int j, apd apd)
    {
        this(apc, file, i, j);
    }

    static File a(ape ape1, String s)
    {
        return ape1.b(s);
    }

    private File a(String s)
    {
        s = b(s);
        Long long1 = Long.valueOf(System.currentTimeMillis());
        s.setLastModified(long1.longValue());
        g.put(s, long1);
        return s;
    }

    static Map a(ape ape1)
    {
        return ape1.g;
    }

    private void a()
    {
        (new Thread(new apf(this))).start();
    }

    static void a(ape ape1, File file)
    {
        ape1.a(file);
    }

    private void a(File file)
    {
        for (int i = d.get(); i + 1 > f; i = d.addAndGet(-1))
        {
            long l = b();
            c.addAndGet(-l);
        }

        d.addAndGet(1);
        long l2 = b(file);
        for (long l1 = c.get(); l1 + l2 > (long)e; l1 = c.addAndGet(-l1))
        {
            l1 = b();
        }

        c.addAndGet(l2);
        Long long1 = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(long1.longValue());
        g.put(file, long1);
    }

    private long b()
    {
        File file = null;
        if (!g.isEmpty()) goto _L2; else goto _L1
_L1:
        long l = 0L;
_L6:
        return l;
_L2:
        Object obj = g.entrySet();
        Map map = g;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = ((Set) (obj)).iterator();
        obj = null;
_L4:
        java.util.Map.Entry entry;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        entry = (java.util.Map.Entry)iterator.next();
        if (file != null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        file = (File)entry.getKey();
        obj = (Long)entry.getValue();
        continue; /* Loop/switch isn't completed */
        Long long1;
        long1 = (Long)entry.getValue();
        if (long1.longValue() >= ((Long) (obj)).longValue())
        {
            continue; /* Loop/switch isn't completed */
        }
        file = (File)entry.getKey();
        obj = long1;
        if (true) goto _L4; else goto _L3
_L3:
        map;
        JVM INSTR monitorexit ;
        long l1;
        l1 = b(file);
        l = l1;
        if (!file.delete()) goto _L6; else goto _L5
_L5:
        g.remove(file);
        return l1;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static long b(ape ape1, File file)
    {
        return ape1.b(file);
    }

    private long b(File file)
    {
        return file.length();
    }

    static File b(ape ape1, String s)
    {
        return ape1.a(s);
    }

    private File b(String s)
    {
        return new File(a, (new StringBuilder()).append(s.hashCode()).append("").toString());
    }

    static AtomicLong b(ape ape1)
    {
        return ape1.c;
    }

    static AtomicInteger c(ape ape1)
    {
        return ape1.d;
    }

    static boolean c(ape ape1, String s)
    {
        return ape1.c(s);
    }

    private boolean c(String s)
    {
        return a(s).delete();
    }
}
