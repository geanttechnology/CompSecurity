// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.FloatMath;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class bie
    implements bid
{

    final int a;
    final LinkedHashMap b;

    public bie(int i)
    {
        a = i;
        b = new bif(this, (int)FloatMath.ceil((float)i / 0.75F) + 1, 0.75F, true);
    }

    public Object a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        b.a(obj);
        obj = b.get(obj);
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    public void a(bjo bjo1)
    {
        this;
        JVM INSTR monitorenter ;
        b.a(bjo1);
        Iterator iterator = b.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (bjo1.a(iterator.next()))
            {
                iterator.remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_58;
        bjo1;
        throw bjo1;
        this;
        JVM INSTR monitorexit ;
    }

    public void a(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        b.a(obj);
        b.a(obj1);
        b.put(obj, obj1);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public Object b(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        b.a(obj);
        obj = b.remove(obj);
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    public String toString()
    {
        this;
        JVM INSTR monitorenter ;
        String s = b.toString();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }
}
