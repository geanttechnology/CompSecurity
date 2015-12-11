// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.easibeacon.protocol;

import com.shazam.b.b;

// Referenced classes of package com.easibeacon.protocol:
//            IBeacon

public interface IBeaconListener
{

    public static final IBeaconListener NO_OP_BEACON_LISTENER = (IBeaconListener)b.a(com/easibeacon/protocol/IBeaconListener);

    public abstract void beaconFound(IBeacon ibeacon);

    public abstract void enterRegion(IBeacon ibeacon);

    public abstract void exitRegion(IBeacon ibeacon);

    public abstract void searchState(int i);

}
