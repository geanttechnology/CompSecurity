// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.events;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.liverail.library.events:
//            a, VPAIDEvent, VPAIDEventListener

public class b
    implements a
{

    private HashMap a;
    private a b;

    public b()
    {
        this(null);
    }

    public b(a a1)
    {
        a = new HashMap();
        if (a1 == null)
        {
            a1 = this;
        }
        b = a1;
    }

    public void a()
    {
        synchronized (a)
        {
            a.clear();
        }
        b = null;
        return;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void addEventListener(String s, VPAIDEventListener vpaideventlistener)
    {
        HashMap hashmap = a;
        hashmap;
        JVM INSTR monitorenter ;
        CopyOnWriteArrayList copyonwritearraylist1 = (CopyOnWriteArrayList)a.get(s);
        CopyOnWriteArrayList copyonwritearraylist;
        copyonwritearraylist = copyonwritearraylist1;
        if (copyonwritearraylist1 != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        copyonwritearraylist = new CopyOnWriteArrayList();
        a.put(s, copyonwritearraylist);
        copyonwritearraylist.add(vpaideventlistener);
        hashmap;
        JVM INSTR monitorexit ;
        return;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void dispatchEvent(VPAIDEvent vpaidevent)
    {
        Object obj;
        obj = vpaidevent.getType();
        vpaidevent.setTarget(b);
        synchronized (a)
        {
            obj = (CopyOnWriteArrayList)a.get(obj);
        }
        if (obj == null)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_44;
        vpaidevent;
        hashmap;
        JVM INSTR monitorexit ;
        throw vpaidevent;
        for (Iterator iterator = ((CopyOnWriteArrayList) (obj)).iterator(); iterator.hasNext(); ((VPAIDEventListener)iterator.next()).onEvent(vpaidevent)) { }
        return;
    }

    public boolean hasEventListener(String s, VPAIDEventListener vpaideventlistener)
    {
        HashMap hashmap = a;
        hashmap;
        JVM INSTR monitorenter ;
        s = (CopyOnWriteArrayList)a.get(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        hashmap;
        JVM INSTR monitorexit ;
        return false;
        boolean flag = s.contains(vpaideventlistener);
        hashmap;
        JVM INSTR monitorexit ;
        return flag;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void removeEventListener(String s, VPAIDEventListener vpaideventlistener)
    {
        HashMap hashmap = a;
        hashmap;
        JVM INSTR monitorenter ;
        CopyOnWriteArrayList copyonwritearraylist = (CopyOnWriteArrayList)a.get(s);
        if (copyonwritearraylist != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        hashmap;
        JVM INSTR monitorexit ;
        return;
        copyonwritearraylist.remove(vpaideventlistener);
        if (copyonwritearraylist.size() == 0)
        {
            a.remove(s);
        }
        hashmap;
        JVM INSTR monitorexit ;
        return;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }
}
