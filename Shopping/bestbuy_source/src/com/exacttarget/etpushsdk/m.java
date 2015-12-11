// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.content.ContentValues;
import com.exacttarget.etpushsdk.database.g;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.List;
import qt;
import qu;

class m
    implements qu
{

    final ETLocationManager.a a;
    final List b;
    final ETLocationManager.c c;

    m(ETLocationManager.c c1, ETLocationManager.a a1, List list)
    {
        c = c1;
        a = a1;
        b = list;
        super();
    }

    public void a(Status status)
    {
        com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("PendingResult<Status> Code: %1$d, Message: %2$s, isSuccess: %3$s", new Object[] {
            Integer.valueOf(status.f()), ETLocationManager.c.a(c, status), Boolean.valueOf(status.e())
        }));
        String s;
        if (a == ETLocationManager.a.a)
        {
            s = "ADD";
        } else
        {
            s = "REMOVE";
        }
        com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("buildGeofenceResultCallback() - %1$s - Num Fences: %2$d - Success: %3$s", new Object[] {
            s, Integer.valueOf(b.size()), String.valueOf(status.e())
        }));
        if (!status.e()) goto _L2; else goto _L1
_L1:
        ETLocationManager._cls1.a[a.ordinal()];
        JVM INSTR tableswitch 1 2: default 144
    //                   1 159
    //                   2 213;
           goto _L3 _L4 _L5
_L3:
        com.exacttarget.etpushsdk.util.m.e("~!RegionMonitor", "We should not be here.");
_L6:
        return;
_L4:
        com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "SUCCESS: Region(s) Added");
        status = b.iterator();
        while (status.hasNext()) 
        {
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("Now Monitoring Region: %1$s", new Object[] {
                status.next()
            }));
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", "SUCCESS: Region(s) Removed");
        status = b.iterator();
        while (status.hasNext()) 
        {
            com.exacttarget.etpushsdk.util.m.a("~!RegionMonitor", String.format("No Longer Monitoring Region: %1$s", new Object[] {
                status.next()
            }));
        }
        if (true) goto _L6; else goto _L2
_L2:
        switch (ETLocationManager._cls1.a[a.ordinal()])
        {
        default:
            com.exacttarget.etpushsdk.util.m.e("~!RegionMonitor", "We should not be here.");
            return;

        case 1: // '\001'
            com.exacttarget.etpushsdk.util.m.d("~!RegionMonitor", String.format("%1$s: Unable to monitor geofences, set them to inactive in db.", new Object[] {
                ETLocationManager.c.a(c, status)
            }));
            try
            {
                status = new ContentValues();
                status.put("active", Integer.valueOf(0));
                g.a("location_type = ?", new String[] {
                    String.valueOf(1)
                }, status);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Status status)
            {
                com.exacttarget.etpushsdk.util.m.c("~!RegionMonitor", status.getMessage(), status);
            }
            return;

        case 2: // '\002'
            com.exacttarget.etpushsdk.util.m.d("~!RegionMonitor", String.format("%1$s: Unable to remove monitored geofences.", new Object[] {
                ETLocationManager.c.a(c, status)
            }));
            return;
        }
    }

    public void onResult(qt qt)
    {
        a((Status)qt);
    }
}
