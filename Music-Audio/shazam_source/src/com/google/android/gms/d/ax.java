// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.SharedPreferences;

// Referenced classes of package com.google.android.gms.d:
//            au

public final class ax
{

    final Object a = new Object();
    boolean b;
    SharedPreferences c;

    public ax()
    {
        b = false;
        c = null;
    }

    public final Object a(au au1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (b)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        au1 = ((au) (au1.b));
        return au1;
        obj;
        JVM INSTR monitorexit ;
        return au1.a(c);
        au1;
        obj;
        JVM INSTR monitorexit ;
        throw au1;
    }
}
