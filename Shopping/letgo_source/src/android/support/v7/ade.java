// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            aea

class ade
    implements aea
{

    private final Map a = new HashMap();
    private final int b;
    private final aeb.a c;
    private int d;

    ade(int i, aeb.a a1)
    {
        b = i;
        c = a1;
    }

    public Object a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = a.get(obj);
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    public void a(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj != null && obj1 != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        throw new NullPointerException("key == null || value == null");
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        d = d + c.a(obj, obj1);
        if (d > b)
        {
            Iterator iterator = a.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                d = d - c.a(entry.getKey(), entry.getValue());
                iterator.remove();
            } while (d > b);
        }
        a.put(obj, obj1);
        this;
        JVM INSTR monitorexit ;
    }
}
