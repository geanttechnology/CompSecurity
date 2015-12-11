// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.os.Binder;
import android.util.Log;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            IBeaconService

public class this._cls0 extends Binder
{

    final IBeaconService this$0;

    public IBeaconService getService()
    {
        Log.i("IBeaconService", "getService of IBeaconBinder called");
        return IBeaconService.this;
    }

    public ()
    {
        this$0 = IBeaconService.this;
        super();
    }
}
