// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.exacttarget.etpushsdk.ETException;
import com.exacttarget.etpushsdk.ETLocationManager;
import com.exacttarget.etpushsdk.event.LastKnownLocationEvent;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.m;

// Referenced classes of package com.exacttarget.etpushsdk.location:
//            c

class d extends BroadcastReceiver
{

    final c a;

    d(c c1)
    {
        a = c1;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        m.a("~!lc", "onReceive()");
        try
        {
            context.unregisterReceiver(a.f);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            m.d("~!lc", context.getMessage());
            return;
        }
        if (!ETLocationManager.getInstance().g())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        context = (Location)intent.getExtras().get("location");
        if (a.b == null || context == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        a.b.onLocationChanged(context);
        EventBus.getInstance().b(new LastKnownLocationEvent(context));
        a.c.removeUpdates(a.a);
        return;
        context;
        m.d("~!lc", context.getMessage());
        return;
    }
}
