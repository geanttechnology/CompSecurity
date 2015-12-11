// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import com.radiusnetworks.ibeacon.Region;
import java.util.Map;

// Referenced classes of package com.arellomobile.android.push:
//            PushBeaconService

private class mRegion
    implements Runnable
{

    private Region mRegion;
    final PushBeaconService this$0;

    public void run()
    {
        PushBeaconService.access$100().remove(mRegion);
        PushBeaconService.access$200(PushBeaconService.this, mRegion);
    }

    public (Region region)
    {
        this$0 = PushBeaconService.this;
        super();
        mRegion = region;
    }
}
