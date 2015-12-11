// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.content.ContentValues;
import com.exacttarget.etpushsdk.database.g;
import com.exacttarget.etpushsdk.util.m;
import com.google.android.gms.common.api.Status;
import qt;
import qu;

class n
    implements qu
{

    final ETLocationManager.a a;
    final ETLocationManager.c b;

    n(ETLocationManager.c c, ETLocationManager.a a1)
    {
        b = c;
        a = a1;
        super();
    }

    public void a(Status status)
    {
        m.a("~!RegionMonitor", String.format("PendingResult<Status> Code: %1$d, Message: %2$s, isSuccess: %3$s", new Object[] {
            Integer.valueOf(status.f()), status.c(), Boolean.valueOf(status.e())
        }));
        switch (ETLocationManager._cls1.a[a.ordinal()])
        {
        default:
            m.e("~!RegionMonitor", "We should not be here.");
            return;

        case 3: // '\003'
            m.a("~!RegionMonitor", String.format("buildGeofenceResultCallback() - %1$s - Success: %2$s", new Object[] {
                "REMOVE_ALL", String.valueOf(status.e())
            }));
            break;
        }
        ETLocationManager.c.a(b, Boolean.FALSE);
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
            m.c("~!RegionMonitor", status.getMessage(), status);
        }
    }

    public void onResult(qt qt)
    {
        a((Status)qt);
    }
}
