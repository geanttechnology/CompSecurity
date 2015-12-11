// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class ab
{

    private final HashMap a = new HashMap();

    public ab()
    {
    }

    public final void a(Class class1, ac ac1)
    {
        if (ac1 == null)
        {
            bc.a("Ignoring attempt to register null event listener");
            return;
        }
        HashMap hashmap = a;
        hashmap;
        JVM INSTR monitorenter ;
        HashSet hashset1 = (HashSet)a.get(class1);
        HashSet hashset;
        hashset = hashset1;
        if (hashset1 != null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        hashset = new HashSet();
        a.put(class1, hashset);
        hashset.add(ac1);
        hashmap;
        JVM INSTR monitorexit ;
        return;
        class1;
        hashmap;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public final void a(Object obj)
    {
        Object obj1;
        if (obj == null)
        {
            bc.a("Ignoring attempt to post null event");
            return;
        }
        obj1 = obj.getClass();
        HashMap hashmap = a;
        hashmap;
        JVM INSTR monitorenter ;
        obj1 = (HashSet)a.get(obj1);
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        hashmap;
        JVM INSTR monitorexit ;
        return;
        obj;
        hashmap;
        JVM INSTR monitorexit ;
        throw obj;
        for (obj1 = ((HashSet) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((ac)((Iterator) (obj1)).next()).a(obj)) { }
        hashmap;
        JVM INSTR monitorexit ;
    }
}
