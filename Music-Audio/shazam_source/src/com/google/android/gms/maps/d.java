// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.maps.a.a;
import com.google.android.gms.maps.a.ai;
import com.google.android.gms.maps.a.n;
import com.google.android.gms.maps.model.b;

// Referenced classes of package com.google.android.gms.maps:
//            b

public final class d
{

    private static boolean a = false;

    public static int a(Context context)
    {
        com/google/android/gms/maps/d;
        JVM INSTR monitorenter ;
        boolean flag;
        w.a(context, "Context is null");
        flag = a;
        if (!flag) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        com/google/android/gms/maps/d;
        JVM INSTR monitorexit ;
        return i;
_L2:
        context = ai.a(context);
        com.google.android.gms.maps.b.a = (a)w.a(context.a());
        context = context.b();
        if (b.a == null)
        {
            b.a = (com.google.android.gms.maps.model.a.b)w.a(context);
        }
        a = true;
        i = 0;
        continue; /* Loop/switch isn't completed */
        context;
        i = ((c) (context)).a;
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw new com.google.android.gms.maps.model.d(context);
        context;
        com/google/android/gms/maps/d;
        JVM INSTR monitorexit ;
        throw context;
    }

}
