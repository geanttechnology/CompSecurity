// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.location;

import android.app.PendingIntent;
import android.location.LocationManager;
import com.exacttarget.etpushsdk.util.m;

// Referenced classes of package com.exacttarget.etpushsdk.location:
//            g

public class b extends g
{

    public b(LocationManager locationmanager)
    {
        super(locationmanager);
    }

    public void a(long l, long l1, PendingIntent pendingintent)
    {
        m.a("~!lb", "requestPassiveLocationUpdates");
        a.requestLocationUpdates("passive", l, l1, pendingintent);
    }
}
