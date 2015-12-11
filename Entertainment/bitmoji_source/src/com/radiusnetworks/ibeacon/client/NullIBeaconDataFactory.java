// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.client;

import android.os.Handler;
import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconDataNotifier;

// Referenced classes of package com.radiusnetworks.ibeacon.client:
//            IBeaconDataFactory, DataProviderException

public class NullIBeaconDataFactory
    implements IBeaconDataFactory
{

    public NullIBeaconDataFactory()
    {
    }

    public void requestIBeaconData(IBeacon ibeacon, final IBeaconDataNotifier notifier)
    {
        (new Handler()).post(new Runnable() {

            final NullIBeaconDataFactory this$0;
            final IBeaconDataNotifier val$notifier;

            public void run()
            {
                notifier.iBeaconDataUpdate(null, null, new DataProviderException("Please upgrade to the Pro version of the Android iBeacon Library."));
            }

            
            {
                this$0 = NullIBeaconDataFactory.this;
                notifier = ibeacondatanotifier;
                super();
            }
        });
    }
}
