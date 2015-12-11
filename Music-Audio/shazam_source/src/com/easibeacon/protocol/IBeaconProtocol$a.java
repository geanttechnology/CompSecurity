// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.easibeacon.protocol;

import java.util.Comparator;

// Referenced classes of package com.easibeacon.protocol:
//            IBeaconProtocol, IBeacon

private final class <init>
    implements Comparator
{

    final IBeaconProtocol a;

    public final int compare(Object obj, Object obj1)
    {
        obj = (IBeacon)obj;
        obj1 = (IBeacon)obj1;
        return ((IBeacon) (obj)).getProximity() - ((IBeacon) (obj1)).getProximity();
    }

    private (IBeaconProtocol ibeaconprotocol)
    {
        a = ibeaconprotocol;
        super();
    }

    a(IBeaconProtocol ibeaconprotocol, byte byte0)
    {
        this(ibeaconprotocol);
    }
}
