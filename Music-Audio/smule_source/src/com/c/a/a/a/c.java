// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.a.a;

import com.c.a.a.a.b.a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.c.a.a.a:
//            a

public abstract class c extends com.c.a.a.a.a
{

    private final AtomicInteger b = new AtomicInteger();
    private final int c;
    private final Map d = Collections.synchronizedMap(new HashMap());

    public c(File file, a a1, int i)
    {
        super(file, a1);
        c = i;
        a();
    }

    static Map a(c c1)
    {
        return c1.d;
    }

    private void a()
    {
        (new Thread(new Runnable() {

            final c a;

            public void run()
            {
                int i = 0;
                File afile[] = a.a.listFiles();
                if (afile != null)
                {
                    int k = afile.length;
                    int j = 0;
                    for (; i < k; i++)
                    {
                        File file = afile[i];
                        j += a.a(file);
                        com.c.a.a.a.c.a(a).put(file, Long.valueOf(file.lastModified()));
                    }

                    c.b(a).set(j);
                }
            }

            
            {
                a = c.this;
                super();
            }
        })).start();
    }

    private int b()
    {
        File file = null;
        if (!d.isEmpty()) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj = d.entrySet();
        Map map = d;
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
        i = 0;
        if (file == null) goto _L6; else goto _L5
_L5:
        int j;
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_194;
        }
        j = a(file);
        i = j;
        if (!file.delete()) goto _L6; else goto _L7
_L7:
        d.remove(file);
        return j;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        d.remove(file);
        return 0;
    }

    static AtomicInteger b(c c1)
    {
        return c1.b;
    }

    protected abstract int a(File file);

    public File a(String s)
    {
        s = super.a(s);
        Long long1 = Long.valueOf(System.currentTimeMillis());
        s.setLastModified(long1.longValue());
        d.put(s, long1);
        return s;
    }

    public void a(String s, File file)
    {
        int j = a(file);
        int i = b.get();
        do
        {
label0:
            {
                if (i + j > c)
                {
                    i = b();
                    if (i != -1)
                    {
                        break label0;
                    }
                }
                b.addAndGet(j);
                s = Long.valueOf(System.currentTimeMillis());
                file.setLastModified(s.longValue());
                d.put(file, s);
                return;
            }
            i = b.addAndGet(-i);
        } while (true);
    }
}
