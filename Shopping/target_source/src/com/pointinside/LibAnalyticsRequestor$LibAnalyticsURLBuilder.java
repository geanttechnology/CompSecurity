// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside;

import android.location.Location;
import com.pointinside.net.EndpointType;
import com.pointinside.net.url.URLBuilder;

// Referenced classes of package com.pointinside:
//            LibAnalyticsRequestor

static class  extends URLBuilder
{

    public void onPrepareURL()
    {
    }

    public void setLocation(Location location)
    {
        putLocationInParam(location);
    }

    public ()
    {
        super(EndpointType.INITIALIZE, null);
    }
}
