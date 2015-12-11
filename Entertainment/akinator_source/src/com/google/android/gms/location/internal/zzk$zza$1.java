// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzk

class zzaFh extends Handler
{

    final LocationCallback zzaFh;
    final y zzaFz;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            zzaFh.onLocationResult((LocationResult)message.obj);
            return;

        case 1: // '\001'
            zzaFh.onLocationAvailability((LocationAvailability)message.obj);
            break;
        }
    }

    y(y y, Looper looper, LocationCallback locationcallback)
    {
        zzaFz = y;
        zzaFh = locationcallback;
        super(looper);
    }
}
