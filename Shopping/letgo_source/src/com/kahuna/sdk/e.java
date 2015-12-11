// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            v, m, c

public class e
{

    private String a;
    private int b;
    private int c;
    private Object d;
    private Map e;

    protected e(String s)
    {
        b = -1;
        c = -1;
        d = new Object();
        if (v.a(s) && m.a)
        {
            Log.w("Kahuna", "You must specify a valid name for the event builder. Ignoring event");
            Thread.dumpStack();
        }
        a = s;
    }

    protected c a()
    {
        Object obj1;
        if (v.a(a))
        {
            return null;
        }
        obj1 = new c(a);
        if (b != -1 && c != -1)
        {
            ((c) (obj1)).a(b);
            ((c) (obj1)).b(c);
        }
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        JSONObject jsonobject;
        Iterator iterator;
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        jsonobject = new JSONObject();
        iterator = e.keySet().iterator();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_193;
        }
        s = (String)iterator.next();
        if (e.get(s) == null) goto _L2; else goto _L1
_L1:
        jsonobject.put(s, e.get(s));
          goto _L2
        Exception exception;
        exception;
        if (!m.a) goto _L2; else goto _L3
_L3:
        Log.w("Kahuna", (new StringBuilder()).append("Exception when building event from event builder: ").append(exception).toString());
          goto _L2
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        ((c) (obj1)).a(jsonobject);
        obj;
        JVM INSTR monitorexit ;
        return ((c) (obj1));
    }

    public e a(int i, int j)
    {
        b = i;
        c = j;
        return this;
    }
}
