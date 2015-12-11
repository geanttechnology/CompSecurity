// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.easibeacon.protocol;

import android.bluetooth.BluetoothAdapter;
import java.util.ArrayList;

// Referenced classes of package com.easibeacon.protocol:
//            IBeaconProtocol, IBeaconListener

final class a
    implements Runnable
{

    final IBeaconProtocol a;

    public final void run()
    {
        IBeaconProtocol.c(a);
        IBeaconProtocol.e(a).stopLeScan(IBeaconProtocol.d(a));
        if (IBeaconProtocol.a(a).isEmpty())
        {
            IBeaconProtocol.b(a).searchState(2);
        } else
        {
            IBeaconProtocol.b(a).searchState(3);
        }
        IBeaconProtocol.f(a);
    }

    (IBeaconProtocol ibeaconprotocol)
    {
        a = ibeaconprotocol;
        super();
    }
}
