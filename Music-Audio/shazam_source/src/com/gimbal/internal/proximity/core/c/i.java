// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.c;

import android.bluetooth.BluetoothAdapter;
import com.gimbal.a.b;
import com.gimbal.android.util.a;
import com.gimbal.internal.c.c;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.gimbal.internal.proximity.core.c:
//            l

public class i extends a
{

    private static final com.gimbal.a.a c = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/core/c/i.getName());
    int a;
    int b;
    private final Object d = new Object();
    private final l e;

    public i(l l1)
    {
        e = l1;
        a = 1000;
        b = 500;
    }

    public final void a(AtomicBoolean atomicboolean)
    {
_L6:
        if (atomicboolean.get())
        {
            break MISSING_BLOCK_LABEL_128;
        }
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        l l1 = e;
        BluetoothAdapter bluetoothadapter = l1.h();
        if (bluetoothadapter == null) goto _L2; else goto _L1
_L1:
        l1.f();
        bluetoothadapter.startLeScan(l1);
_L4:
        d.wait(a);
        e.j();
        d.wait(b);
        obj;
        JVM INSTR monitorexit ;
        continue; /* Loop/switch isn't completed */
        atomicboolean;
        throw atomicboolean;
_L2:
        l.d.d("BluetoothAdapter - Adapter is null", new Object[0]);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        l.d.d("Start Scanning failed", new Object[] {
            exception
        });
        if (true) goto _L4; else goto _L3
_L3:
        atomicboolean;
        e.j();
        throw atomicboolean;
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final String c()
    {
        return com/gimbal/internal/proximity/core/c/i.getSimpleName();
    }

    final void d()
    {
        synchronized (d)
        {
            d.notifyAll();
        }
    }

}
