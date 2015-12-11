// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.SharedPreferences;

// Referenced classes of package com.google.android.gms.b:
//            u

public class x
{

    private final Object a = new Object();
    private boolean b;
    private SharedPreferences c;

    public x()
    {
        b = false;
        c = null;
    }

    public Object a(u u1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (b)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        u1 = ((u) (u1.b()));
        return u1;
        obj;
        JVM INSTR monitorexit ;
        return u1.a(c);
        u1;
        obj;
        JVM INSTR monitorexit ;
        throw u1;
    }
}
