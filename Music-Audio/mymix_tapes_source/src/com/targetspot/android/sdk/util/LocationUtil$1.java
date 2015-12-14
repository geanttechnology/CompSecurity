// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Message;

// Referenced classes of package com.targetspot.android.sdk.util:
//            LocationUtil

static final class val.lm
    implements LocationListener
{

    final cationHandler val$handler;
    final LocationManager val$lm;

    public void onLocationChanged(Location location)
    {
        if (val$handler != null)
        {
            Message message = Message.obtain();
            message.what = 1;
            message.obj = location;
            val$handler.sendMessage(message);
        }
        val$lm.removeUpdates(this);
    }

    public void onProviderDisabled(String s)
    {
        if (val$handler != null)
        {
            val$handler.sendEmptyMessage(-1);
        }
        val$lm.removeUpdates(this);
    }

    public void onProviderEnabled(String s)
    {
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }

    cationHandler(cationHandler cationhandler, LocationManager locationmanager)
    {
        val$handler = cationhandler;
        val$lm = locationmanager;
        super();
    }
}
