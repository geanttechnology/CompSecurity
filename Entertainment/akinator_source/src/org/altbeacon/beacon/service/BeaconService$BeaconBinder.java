// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.os.Binder;
import org.altbeacon.beacon.logging.LogManager;

// Referenced classes of package org.altbeacon.beacon.service:
//            BeaconService

public class this._cls0 extends Binder
{

    final BeaconService this$0;

    public BeaconService getService()
    {
        LogManager.i("BeaconService", "getService of BeaconBinder called", new Object[0]);
        return BeaconService.this;
    }

    public ()
    {
        this$0 = BeaconService.this;
        super();
    }
}
