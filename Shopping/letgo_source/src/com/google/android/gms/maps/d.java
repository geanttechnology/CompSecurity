// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.support.v7.yz;
import android.support.v7.zv;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.maps.model.b;
import com.google.android.gms.maps.model.e;

// Referenced classes of package com.google.android.gms.maps:
//            b

public final class d
{

    private static boolean a = false;

    public static int a(Context context)
    {
        int i = 0;
        com/google/android/gms/maps/d;
        JVM INSTR monitorenter ;
        boolean flag;
        x.a(context, "Context is null");
        flag = a;
        if (!flag) goto _L2; else goto _L1
_L1:
        com/google/android/gms/maps/d;
        JVM INSTR monitorexit ;
        return i;
_L2:
        context = zv.a(context);
        a(((yz) (context)));
        a = true;
          goto _L1
        context;
        throw context;
        context;
        i = ((c) (context)).a;
          goto _L1
    }

    public static void a(yz yz1)
    {
        try
        {
            b.a(yz1.a());
            b.a(yz1.b());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (yz yz1)
        {
            throw new e(yz1);
        }
    }

}
