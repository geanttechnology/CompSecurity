// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.client;

import com.radiusnetworks.ibeacon.IBeaconDataNotifier;

// Referenced classes of package com.radiusnetworks.ibeacon.client:
//            NullIBeaconDataFactory, DataProviderException

class val.notifier
    implements Runnable
{

    final NullIBeaconDataFactory this$0;
    final IBeaconDataNotifier val$notifier;

    public void run()
    {
        val$notifier.iBeaconDataUpdate(null, null, new DataProviderException("Please upgrade to the Pro version of the Android iBeacon Library."));
    }

    ()
    {
        this$0 = final_nullibeacondatafactory;
        val$notifier = IBeaconDataNotifier.this;
        super();
    }
}
