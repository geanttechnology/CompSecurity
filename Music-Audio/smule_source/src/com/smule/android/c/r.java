// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;

import java.util.HashMap;

// Referenced classes of package com.smule.android.c:
//            s

public class r
{

    private HashMap a;

    public r()
    {
        a = new HashMap();
    }

    public s a(String s1)
    {
        HashMap hashmap = a;
        hashmap;
        JVM INSTR monitorenter ;
        if (!a.containsKey(s1)) goto _L2; else goto _L1
_L1:
        s1 = (s)a.get(s1);
_L4:
        return s1;
_L2:
        s s2;
        s2 = new s();
        a.put(s1, s2);
        s1 = s2;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        hashmap;
        JVM INSTR monitorexit ;
        throw s1;
    }

    public void b(String s1)
    {
        synchronized (a)
        {
            a.remove(s1);
        }
        return;
        s1;
        hashmap;
        JVM INSTR monitorexit ;
        throw s1;
    }
}
