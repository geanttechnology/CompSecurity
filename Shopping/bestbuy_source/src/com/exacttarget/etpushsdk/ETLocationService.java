// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import ahs;
import ahv;
import android.app.IntentService;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.PowerManager;
import com.exacttarget.etpushsdk.event.LastKnownLocationEvent;
import com.exacttarget.etpushsdk.location.a;
import com.exacttarget.etpushsdk.location.e;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.m;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETLocationManager, ETPush, ETLocationReceiver

public final class ETLocationService extends IntentService
{

    public ETLocationService()
    {
        super("~!ETLocationService");
    }

    private void a(Intent intent)
    {
        m.a("~!ETLocationService", "handleGeofenceCrossEnterExit()");
        int j = ahv.a(intent).c();
        if (j == 1 || j == 2)
        {
            intent = ahv.a(intent).d().iterator();
            int i = 0;
            while (intent.hasNext()) 
            {
                Object obj = (ahs)intent.next();
                m.a("~!ETLocationService", (new StringBuilder()).append("FenceTripped: ").append(i).append(", ").append(((ahs) (obj)).f()).toString());
                obj = ((ahs) (obj)).f();
                if ("~~m@g1c_f3nc3~~".equals(obj) && 2 == j)
                {
                    m.a("~!ETLocationService", "Magic fence was exited, get new fence data");
                    ETLocationManager.getInstance().f(true);
                    if (ETLocationManager.getInstance().isWatchingLocation())
                    {
                        ETLocationManager.getInstance().a(false);
                    }
                } else
                {
                    ETPush.getInstance().a(((String) (obj)), j, -1);
                }
                i++;
            }
        } else
        {
            m.d("~!ETLocationService", (new StringBuilder()).append("Invalid Geofence Transition Type: ").append(j).toString());
        }
    }

    private void b(Intent intent)
    {
        int i = ahv.a(intent).b();
        m.d("~!ETLocationService", (new StringBuilder()).append("ERROR, LocationStatusCode: ").append(i).toString());
    }

    protected void onHandleIntent(Intent intent)
    {
        android.os.PowerManager.WakeLock wakelock;
        m.a("~!ETLocationService", String.format("%s.onHandleIntent()", new Object[] {
            getClass().getSimpleName()
        }));
        wakelock = ((PowerManager)getSystemService("power")).newWakeLock(1, "~!ETLocationService");
        wakelock.acquire();
        ETLocationReceiver.completeWakefulIntent(intent);
        Object obj;
        obj = intent.getAction();
        ETPush.c();
        byte byte0 = -1;
        int i = ((String) (obj)).hashCode();
        i;
        JVM INSTR lookupswitch 5: default 120
    //                   -2024163871: 193
    //                   -1548914285: 225
    //                   -1193189742: 177
    //                   516295792: 209
    //                   1662413067: 161;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        byte0;
        JVM INSTR tableswitch 0 4: default 156
    //                   0 241
    //                   1 336
    //                   2 367
    //                   3 403
    //                   4 437;
           goto _L7 _L8 _L9 _L10 _L11 _L12
_L7:
        wakelock.release();
        return;
_L6:
        if (!((String) (obj)).equals("android.intent.action.PROVIDER_CHANGED")) goto _L1; else goto _L13
_L13:
        byte0 = 0;
          goto _L1
_L4:
        if (!((String) (obj)).equals("et_location_action_timeout")) goto _L1; else goto _L14
_L14:
        byte0 = 1;
          goto _L1
_L2:
        if (!((String) (obj)).equals("et_location_action_15minute_update")) goto _L1; else goto _L15
_L15:
        byte0 = 2;
          goto _L1
_L5:
        if (!((String) (obj)).equals("et_location_action_geofence_cross")) goto _L1; else goto _L16
_L16:
        byte0 = 3;
          goto _L1
_L3:
        if (!((String) (obj)).equals("et_location_action_passive_location_change")) goto _L1; else goto _L17
_L17:
        byte0 = 4;
          goto _L1
_L8:
        m.a("~!ETLocationService", "Providers changed.");
        if (!ETLocationManager.getInstance().g()) goto _L19; else goto _L18
_L18:
        m.a("~!ETLocationService", "Location Provider enabled.");
        if (ETLocationManager.getInstance().isWatchingLocation())
        {
            ETLocationManager.getInstance().a(false);
        }
          goto _L7
        intent;
        m.c("~!ETLocationService", intent.getMessage(), intent);
        wakelock.release();
        return;
_L19:
        m.a("~!ETLocationService", "Location Provider disabled.");
        if (ETLocationManager.getInstance().isWatchingLocation())
        {
            ETLocationManager.getInstance().c(true);
        }
          goto _L7
        intent;
        wakelock.release();
        throw intent;
_L9:
        m.a("~!ETLocationService", "Location timeout.");
        if (ETLocationManager.getInstance().a != null)
        {
            ETLocationManager.getInstance().a.a();
        }
          goto _L7
_L10:
        m.a("~!ETLocationService", "Location 15 minute update.");
        if (!ETLocationManager.getInstance().isWatchingLocation()) goto _L21; else goto _L20
_L20:
        ETLocationManager.getInstance().a(false);
          goto _L7
_L21:
        ETLocationManager.getInstance().stopWatchingLocation();
          goto _L7
_L11:
        m.a("~!ETLocationService", "Location geofence crossed.");
        if (!ahv.a(intent).a()) goto _L23; else goto _L22
_L22:
        b(intent);
          goto _L7
_L23:
        a(intent);
          goto _L7
_L12:
        m.a("~!ETLocationService", "Location changed (passively).");
        if (!ETLocationManager.getInstance().isWatchingLocation() && !ETLocationManager.getInstance().isWatchingProximity()) goto _L7; else goto _L24
_L24:
        m.a("~!ETLocationService", "Location on and watching location...");
        if (!intent.hasExtra("location")) goto _L26; else goto _L25
_L25:
        intent = (Location)intent.getExtras().get("location");
_L29:
        if (intent == null) goto _L7; else goto _L27
_L27:
        m.a("~!ETLocationService", (new StringBuilder()).append("New Passive Location: ").append(intent.getLatitude()).append(", ").append(intent.getLongitude()).toString());
        EventBus.getInstance().b(new LastKnownLocationEvent(intent));
          goto _L7
_L26:
        intent = (new e(com.exacttarget.etpushsdk.ETPush.a())).a(0, System.currentTimeMillis() - 0x493e0L);
        obj = (LastKnownLocationEvent)EventBus.getInstance().a(com/exacttarget/etpushsdk/event/LastKnownLocationEvent);
        if (obj == null) goto _L29; else goto _L28
_L28:
        obj = ((LastKnownLocationEvent) (obj)).getLocation();
        if (((Location) (obj)).getTime() > System.currentTimeMillis() - 0x493e0L) goto _L31; else goto _L30
_L30:
        float f = ((Location) (obj)).distanceTo(intent);
        if (f >= 0.0F) goto _L29; else goto _L31
_L31:
        intent = null;
          goto _L29
    }
}
