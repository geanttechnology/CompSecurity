// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            y, ap

private static final class b extends 
{

    private WeakReference a;
    private WeakReference b;

    public final void a(Status status)
    {
        Map map;
        Object obj;
        map = (Map)a.get();
        obj = b.get();
        if (status.b() || map == null || obj == null) goto _L2; else goto _L1
_L1:
        map;
        JVM INSTR monitorenter ;
        obj = (ap)map.remove(obj);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        ((ap) (obj)).a();
        map;
        JVM INSTR monitorexit ;
_L2:
        a(status);
        return;
        status;
        map;
        JVM INSTR monitorexit ;
        throw status;
    }

    (Map map, Object obj, com.google.android.gms.common.api..a a1)
    {
        super(a1);
        a = new WeakReference(map);
        b = new WeakReference(obj);
    }
}
