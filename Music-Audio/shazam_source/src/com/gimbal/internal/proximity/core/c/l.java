// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.gimbal.a.a;
import com.gimbal.a.b;
import com.gimbal.internal.c.c;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.gimbal.internal.proximity.core.c:
//            h, i, c, n

public class l extends h
    implements android.bluetooth.BluetoothAdapter.LeScanCallback
{

    static b d = com.gimbal.internal.c.c.f(com/gimbal/internal/proximity/core/c/l.getSimpleName());
    private static a e = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/core/c/l.getSimpleName());
    private i f;

    public l(Context context, com.gimbal.internal.proximity.core.c.c c1, n n, com.gimbal.internal.proximity.core.sighting.c c2)
    {
        super(context, c1, n, c2);
    }

    private i k()
    {
        if (f == null)
        {
            f = new i(this);
        }
        return f;
    }

    public final void a()
    {
        k().a = 1000;
        k().b = 500;
        k().d();
    }

    public final void b()
    {
        k().a = 1000;
        k().b = 1000;
        k().d();
    }

    public final void c()
    {
        k().b();
    }

    public final void d()
    {
        k().a();
    }

    public final void j()
    {
        BluetoothAdapter bluetoothadapter = h();
        {
            if (bluetoothadapter == null)
            {
                break MISSING_BLOCK_LABEL_23;
            }
            try
            {
                bluetoothadapter.stopLeScan(this);
            }
            catch (Exception exception)
            {
                d.d("Stop Scan failed ", new Object[] {
                    exception
                });
            }
        }
        this;
        JVM INSTR monitorenter ;
        g();
        this;
        JVM INSTR monitorexit ;
        return;
        d.d("BluetoothAdapter - Adapter is null", new Object[0]);
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_14;
        }
        Exception exception1;
        exception1;
        throw exception1;
    }

    public void onLeScan(BluetoothDevice bluetoothdevice, int i1, byte abyte0[])
    {
        if (super.c != null)
        {
            super.c.execute(a(i1, abyte0));
        }
    }

}
