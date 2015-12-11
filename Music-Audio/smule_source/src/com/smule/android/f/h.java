// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import com.smule.android.c.aa;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.android.f:
//            i

public class h
{

    public static final String a = com/smule/android/f/h.getName();
    private static h c = null;
    HashMap b;

    private h()
    {
        b = new HashMap();
    }

    public static h a()
    {
        com/smule/android/f/h;
        JVM INSTR monitorenter ;
        h h1;
        if (c == null)
        {
            c = new h();
        }
        h1 = c;
        com/smule/android/f/h;
        JVM INSTR monitorexit ;
        return h1;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(String s, Object obj)
    {
        a(s, obj, true);
    }

    public void a(String s, Object obj, boolean flag)
    {
        if (flag)
        {
            aa.a(a, (new StringBuilder()).append("Posting notification ").append(s).toString());
        }
        this;
        JVM INSTR monitorenter ;
        s = (Observable)b.get(s);
        this;
        JVM INSTR monitorexit ;
        if (s != null)
        {
            s.notifyObservers(obj);
        }
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void a(String s, Observer observer)
    {
        this;
        JVM INSTR monitorenter ;
        Observable observable = (Observable)b.get(s);
        Object obj;
        obj = observable;
        if (observable != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        obj = new i();
        b.put(s, obj);
        ((Observable) (obj)).addObserver(observer);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public transient void a(String s, Object aobj[])
    {
        HashMap hashmap = new HashMap();
        if (aobj.length % 2 == 1)
        {
            throw new RuntimeException((new StringBuilder()).append("Bad number of parameters ").append(aobj.length).toString());
        }
        for (int j = 0; j < aobj.length; j += 2)
        {
            hashmap.put(aobj[j].toString(), aobj[j + 1]);
        }

        try
        {
            a(s, hashmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aa.c(a, "Exception while posting a notification", s);
        }
        throw new RuntimeException(s);
    }

    public void b(String s, Observer observer)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Observable)b.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        s.deleteObserver(observer);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

}
