// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            v, c, m

public class d
{

    private static d a = new d();
    private Object b;
    private HashMap c;
    private Object d;
    private HashMap e;

    private d()
    {
        b = new Object();
        c = new HashMap();
        d = new Object();
        e = new HashMap();
    }

    protected static c a(String s, long l)
    {
        Object obj;
        while (v.a(s) || (obj = a.b(s, l)) == null) 
        {
            return null;
        }
        s = ((String) (a.d));
        s;
        JVM INSTR monitorenter ;
        if (!a.e.containsKey(obj))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        obj = (c)a.e.get(obj);
        return ((c) (obj));
        Exception exception;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
        s;
        JVM INSTR monitorexit ;
        return null;
    }

    private Long a(Long long1)
    {
        Long long2;
        if (long1.longValue() < 30L)
        {
            long2 = Long.valueOf(30L);
        } else
        {
            long2 = long1;
            if (long1.longValue() > 0xed4e00L)
            {
                return Long.valueOf(0xed4e00L);
            }
        }
        return long2;
    }

    protected static void a()
    {
        synchronized (a.d)
        {
            a.e.clear();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static void a(c c1)
    {
        String s;
        while (c1 == null || v.a(c1.a()) || (s = a.b(c1.a(), c1.b())) == null) 
        {
            return;
        }
        Object obj = a.d;
        obj;
        JVM INSTR monitorenter ;
        if (a.e.containsKey(s)) goto _L2; else goto _L1
_L1:
        a.e.put(s, c1);
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Inserted new bucket mapping '").append(s).append("'").toString());
        }
_L4:
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
_L2:
        if (!m.a) goto _L4; else goto _L3
_L3:
        Log.d("Kahuna", (new StringBuilder()).append("Attempted to insert bucket mapping that already exists '").append(s).append("', aborting.").toString());
          goto _L4
    }

    protected static void a(List list)
    {
        Object obj = a.d;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = a.b;
        obj1;
        JVM INSTR monitorenter ;
        int j;
        a.e.clear();
        j = list.size();
        int i = 0;
_L4:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        c c1 = (c)list.get(i);
        String s = c1.a().toLowerCase();
        if (c1.i() && a.c.containsKey(s) && System.currentTimeMillis() / 1000L < ((Long)a.c.get(s)).longValue() + c1.b())
        {
            String s1 = a.b(c1.a(), c1.b());
            if (!a.e.containsKey(s1))
            {
                a.e.put(s1, c1);
                if (m.a)
                {
                    Log.d("Kahuna", (new StringBuilder()).append("Rebuilt new bucket mapping '").append(s1).append("'").toString());
                }
            }
        }
        break MISSING_BLOCK_LABEL_251;
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
_L2:
        return;
        list;
        obj1;
        JVM INSTR monitorexit ;
        throw list;
        list;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw list;
        }
        // Misplaced declaration of an exception variable
        catch (List list) { }
        if (!m.a) goto _L2; else goto _L1
_L1:
        Log.w("Kahuna", (new StringBuilder()).append("Caught exception rebuilding event bucket mappings: ").append(list).toString());
        return;
        i++;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected static void a(JSONObject jsonobject)
    {
        Object obj = a.b;
        obj;
        JVM INSTR monitorenter ;
        a.c.clear();
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        String s;
        long l;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); a.c.put(s.toLowerCase(), a.a(Long.valueOf(l))))
        {
            s = (String)iterator.next();
            l = (long)(Double.valueOf(jsonobject.optDouble(s, 0.5D)).doubleValue() * 60D);
        }

        break MISSING_BLOCK_LABEL_133;
        jsonobject;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw jsonobject;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject) { }
        if (m.a)
        {
            Log.w("Kahuna", (new StringBuilder()).append("Caught exception loading bucket mappings from persistent store: ").append(jsonobject).toString());
        }
        return;
        obj;
        JVM INSTR monitorexit ;
    }

    protected static boolean a(String s)
    {
        if (v.a(s))
        {
            return false;
        }
        boolean flag;
        synchronized (a.b)
        {
            flag = a.c.containsKey(s.toLowerCase());
        }
        return flag;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    private String b(String s, long l)
    {
        Object obj = null;
        HashMap hashmap = c;
        hashmap;
        JVM INSTR monitorenter ;
        String s1 = s.toLowerCase();
        if (!c.containsKey(s1)) goto _L2; else goto _L1
_L1:
        long l1 = ((Long)c.get(s1)).longValue();
        s = (new StringBuilder()).append(s1).append("_").append((int)(l / l1)).toString();
_L4:
        return s;
_L2:
        s = obj;
        if (!m.a)
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.w("Kahuna", (new StringBuilder()).append("Attempted to obtain a bucket mapping for event not in bucketConfig: ").append(s1).toString());
        s = obj;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

}
