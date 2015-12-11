// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.a.a.a;
import com.google.a.b;
import java.util.Date;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.internal:
//            v

public final class by
{

    public static a a(v v1)
    {
        int i;
        HashSet hashset;
        Date date;
        if (v1.e != null)
        {
            hashset = new HashSet(v1.e);
        } else
        {
            hashset = null;
        }
        date = new Date(v1.b);
        v1.d;
        JVM INSTR tableswitch 1 2: default 56
    //                   1 87
    //                   2 80;
           goto _L1 _L2 _L3
_L1:
        i = b.a;
_L5:
        return new a(date, i, hashset, v1.f);
_L3:
        i = b.c;
        continue; /* Loop/switch isn't completed */
_L2:
        i = b.b;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
