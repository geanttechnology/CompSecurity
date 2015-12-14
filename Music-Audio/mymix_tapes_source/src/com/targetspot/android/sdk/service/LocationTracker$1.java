// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.location.Location;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.targetspot.android.sdk.service:
//            LocationTracker

class Handler extends com.targetspot.android.sdk.util.ionHandler
{

    final LocationTracker this$0;

    public void handleError(Message message)
    {
        Log.e("LocationTracker", "Error obtaining location");
        synchronized (notify)
        {
            currentLocation = null;
            notify.notify();
        }
        return;
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void handleLocation(Location location)
    {
        Log.d("LocationTracker", (new StringBuilder()).append("Updated location: ").append(location.getLatitude()).append(" ").append(location.getLongitude()).toString());
        synchronized (notify)
        {
            currentLocation = location;
            notify.notify();
        }
        return;
        location;
        obj;
        JVM INSTR monitorexit ;
        throw location;
    }

    Handler()
    {
        this$0 = LocationTracker.this;
        super();
    }
}
