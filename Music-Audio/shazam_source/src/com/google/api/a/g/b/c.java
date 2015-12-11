// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g.b;

import com.google.api.a.g.m;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.google.api.a.g.b:
//            a, f, e, d

class c extends a
{

    HashMap a;
    private final Lock b = new ReentrantLock();

    protected c(e e, String s)
    {
        super(e, s);
        a = new HashMap();
    }

    public final d a(String s, Serializable serializable)
    {
        com.google.api.a.f.a.a.a.a.c.a(s);
        com.google.api.a.f.a.a.a.a.c.a(serializable);
        b.lock();
        a.put(s, m.a(serializable));
        b.unlock();
        return this;
        s;
        b.unlock();
        throw s;
    }

    public final Serializable a(String s)
    {
        if (s == null)
        {
            return null;
        }
        b.lock();
        s = (byte[])a.get(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        b.unlock();
        return s;
_L2:
        s = m.a(new ByteArrayInputStream(s));
        if (true) goto _L4; else goto _L3
_L3:
        s;
        b.unlock();
        throw s;
    }

    public final Set a()
    {
        b.lock();
        Set set = Collections.unmodifiableSet(a.keySet());
        b.unlock();
        return set;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
    }

    public String toString()
    {
        return f.a(this);
    }
}
