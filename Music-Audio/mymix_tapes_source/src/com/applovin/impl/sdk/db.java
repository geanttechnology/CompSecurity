// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.applovin.impl.sdk:
//            dd

public class db
{

    private static final db a = new db();
    private final Object b = new Object();
    private final Map c = new HashMap(2);

    private db()
    {
    }

    static db a()
    {
        return a;
    }

    dd a(String s)
    {
        synchronized (b)
        {
            s = (dd)c.remove(s);
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    void a(String s, long l, String s1, boolean flag)
    {
        dd dd1 = new dd(this, s1, l, flag, null);
        synchronized (b)
        {
            c.put(s, dd1);
        }
        return;
        s;
        s1;
        JVM INSTR monitorexit ;
        throw s;
    }

}
