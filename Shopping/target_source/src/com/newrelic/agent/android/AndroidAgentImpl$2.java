// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

// Referenced classes of package com.newrelic.agent.android:
//            AndroidAgentImpl

class this._cls0
    implements LocationListener
{

    final AndroidAgentImpl this$0;

    public void onLocationChanged(Location location)
    {
        if (AndroidAgentImpl.access$000(AndroidAgentImpl.this, location))
        {
            setLocation(location);
        }
    }

    public void onProviderDisabled(String s)
    {
        if ("passive".equals(s))
        {
            AndroidAgentImpl.access$100(AndroidAgentImpl.this);
        }
    }

    public void onProviderEnabled(String s)
    {
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }

    ()
    {
        this$0 = AndroidAgentImpl.this;
        super();
    }
}
