// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.c;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.gimbal.internal.proximity.core.c:
//            k

final class a extends ScanCallback
{

    private k a;

    public final void onScanFailed(int i)
    {
        k.j();
    }

    public final void onScanResult(int i, ScanResult scanresult)
    {
        scanresult = a.a(scanresult.getRssi(), scanresult.getScanRecord().getBytes());
        if (a.c != null)
        {
            a.c.execute(scanresult);
        }
    }

    (k k1)
    {
        a = k1;
        super();
    }
}
