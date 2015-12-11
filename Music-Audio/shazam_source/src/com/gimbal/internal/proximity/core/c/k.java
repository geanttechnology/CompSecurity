// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import com.gimbal.a.a;
import com.gimbal.a.b;
import com.gimbal.internal.c.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.gimbal.internal.proximity.core.c:
//            h, c, n

public class k extends h
{

    private static a d = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/core/c/k.getName());
    private static b e = com.gimbal.internal.c.c.f(com/gimbal/internal/proximity/core/c/k.getName());
    private static final byte f[] = new byte[0];
    private int g;
    private AtomicBoolean h;
    private ScanCallback i;

    public k(Context context, com.gimbal.internal.proximity.core.c.c c1, n n, com.gimbal.internal.proximity.core.sighting.c c2)
    {
        super(context, c1, n, c2);
        g = 2;
        i = new ScanCallback() {

            private k a;

            public final void onScanFailed(int i1)
            {
                k.j();
            }

            public final void onScanResult(int i1, ScanResult scanresult)
            {
                scanresult = a.a(scanresult.getRssi(), scanresult.getScanRecord().getBytes());
                if (a.c != null)
                {
                    a.c.execute(scanresult);
                }
            }

            
            {
                a = k.this;
                super();
            }
        };
        h = new AtomicBoolean(false);
    }

    static a j()
    {
        return d;
    }

    private void k()
    {
        Object obj = h();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        f();
        obj = ((BluetoothAdapter) (obj)).getBluetoothLeScanner();
        if (obj != null)
        {
            try
            {
                Object obj1 = new android.bluetooth.le.ScanSettings.Builder();
                ((android.bluetooth.le.ScanSettings.Builder) (obj1)).setScanMode(g);
                obj1 = ((android.bluetooth.le.ScanSettings.Builder) (obj1)).build();
                ArrayList arraylist = new ArrayList();
                android.bluetooth.le.ScanFilter.Builder builder = new android.bluetooth.le.ScanFilter.Builder();
                builder.setManufacturerData(140, f);
                arraylist.add(builder.build());
                ((BluetoothLeScanner) (obj)).startScan(arraylist, ((android.bluetooth.le.ScanSettings) (obj1)), i);
                return;
            }
            catch (Exception exception)
            {
                e.d("Start Scanning failed: {} - {}", new Object[] {
                    exception.getClass().getSimpleName(), exception.getMessage()
                });
            }
        }
        break MISSING_BLOCK_LABEL_140;
        e.d("BluetoothAdapter - Adapter is null", new Object[0]);
        return;
    }

    private void l()
    {
        synchronized (h)
        {
            if (h.get())
            {
                c();
                k();
            }
        }
    }

    public final void a()
    {
        if (g != 2)
        {
            g = 2;
            l();
        }
    }

    public final void b()
    {
        if (g != 1)
        {
            g = 1;
            l();
        }
    }

    public final void c()
    {
        AtomicBoolean atomicboolean = h;
        atomicboolean;
        JVM INSTR monitorenter ;
        boolean flag = h.get();
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj = h();
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((BluetoothAdapter) (obj)).getBluetoothLeScanner();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        ((BluetoothLeScanner) (obj)).stopScan(i);
_L5:
        g();
        h.set(false);
_L2:
        atomicboolean;
        JVM INSTR monitorexit ;
        return;
_L4:
        e.d("BluetoothAdapter - Adapter is null", new Object[0]);
          goto _L5
        Object obj1;
        obj1;
        e.d("Stop Scan failed: {} - {}", new Object[] {
            obj1.getClass().getSimpleName(), ((Exception) (obj1)).getMessage()
        });
          goto _L5
        obj1;
        throw obj1;
    }

    public final void d()
    {
        synchronized (h)
        {
            if (!h.get())
            {
                k();
                h.set(true);
            }
        }
    }

}
