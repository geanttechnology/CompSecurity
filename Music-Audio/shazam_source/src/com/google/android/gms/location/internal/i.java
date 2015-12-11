// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.location.copresence.internal.CopresenceApiOptions;
import com.google.android.gms.location.copresence.internal.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.android.gms.location.internal:
//            a, h, m, f, 
//            LocationRequestUpdateData

public final class i extends a
{

    final com.google.android.gms.location.internal.h g;
    private final b h;

    public i(Context context, Looper looper, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c, String s, h h1)
    {
        this(context, looper, b1, c, s, h1, CopresenceApiOptions.a);
    }

    private i(Context context, Looper looper, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c, String s, h h1, CopresenceApiOptions copresenceapioptions)
    {
        super(context, looper, b1, c, s, h1);
        g = new com.google.android.gms.location.internal.h(context, a);
        if (h1.a != null)
        {
            looper = h1.a.name;
        } else
        {
            looper = null;
        }
        h = new b(context, looper, h1.e, a, copresenceapioptions);
    }

    public final void d()
    {
        com.google.android.gms.location.internal.h h1 = g;
        h1;
        JVM INSTR monitorenter ;
        boolean flag = e();
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj2 = g;
        Object obj = ((com.google.android.gms.location.internal.h) (obj2)).c;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = ((com.google.android.gms.location.internal.h) (obj2)).c.values().iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        Object obj3 = (h.b)iterator.next();
        if (obj3 == null) goto _L6; else goto _L5
_L5:
        ((f)((com.google.android.gms.location.internal.h) (obj2)).a.b()).a(LocationRequestUpdateData.a(((com.google.android.gms.location.l) (obj3))));
          goto _L6
        obj2;
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
        obj;
        Object obj1;
        try
        {
            throw new IllegalStateException(((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally { }
        Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", ((Throwable) (obj)));
_L2:
        super.d();
        h1;
        JVM INSTR monitorexit ;
        return;
_L4:
        ((com.google.android.gms.location.internal.h) (obj2)).c.clear();
        iterator = ((com.google.android.gms.location.internal.h) (obj2)).d.values().iterator();
_L7:
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_207;
            }
            obj3 = (h.a)iterator.next();
        } while (obj3 == null);
        ((f)((com.google.android.gms.location.internal.h) (obj2)).a.b()).a(LocationRequestUpdateData.a(((com.google.android.gms.location.k) (obj3))));
          goto _L7
        ((com.google.android.gms.location.internal.h) (obj2)).d.clear();
        obj;
        JVM INSTR monitorexit ;
        obj = g;
        flag = ((com.google.android.gms.location.internal.h) (obj)).b;
        if (!flag) goto _L2; else goto _L8
_L8:
        ((com.google.android.gms.location.internal.h) (obj)).a.a();
        ((f)((com.google.android.gms.location.internal.h) (obj)).a.b()).a(false);
        obj.b = false;
          goto _L2
        obj1;
        throw new IllegalStateException(((Throwable) (obj1)));
        h1;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public final boolean o()
    {
        return true;
    }
}
