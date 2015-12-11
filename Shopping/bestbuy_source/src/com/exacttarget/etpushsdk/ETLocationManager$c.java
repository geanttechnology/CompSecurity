// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import ahu;
import ahy;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.exacttarget.etpushsdk.data.Message;
import com.exacttarget.etpushsdk.data.Region;
import com.exacttarget.etpushsdk.data.RegionMessage;
import com.exacttarget.etpushsdk.database.e;
import com.exacttarget.etpushsdk.database.f;
import com.exacttarget.etpushsdk.database.g;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.m;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pp;
import qo;
import qp;
import qq;
import qu;

// Referenced classes of package com.exacttarget.etpushsdk:
//            n, m, ETLocationManager, ETLocationReceiver, 
//            c

class <init>
    implements qo, qp
{

    final ETLocationManager a;
    private Boolean b;
    private List c;
    private List d;
    private PendingIntent e;

    static Boolean a(<init> <init>1, Boolean boolean1)
    {
        <init>1.b = boolean1;
        return boolean1;
    }

    static String a(b b1, Status status)
    {
        return b1.a(status);
    }

    private String a(Status status)
    {
        if (status == null)
        {
            return "NULL";
        }
        switch (status.f())
        {
        default:
            return "UNKNOWN_ERROR";

        case 1000: 
            return "GEOFENCE_NOT_AVAILABLE";

        case 1001: 
            return "GEOFENCE_TOO_MANY_GEOFENCES";

        case 1002: 
            return "GEOFENCE_TOO_MANY_PENDING_INTENTS";

        case 1: // '\001'
            return "UNSPECIFIED_ERROR";

        case 0: // '\0'
            return "SUCCESS";
        }
    }

    private qu a(a a1, PendingIntent pendingintent)
    {
        return new n(this, a1);
    }

    private qu a(a a1, List list)
    {
        return new com.exacttarget.etpushsdk.m(this, a1, list);
    }

    static void a(a a1)
    {
        a1.c();
    }

    private PendingIntent b()
    {
        m.a("~!RegionMonitor", "getGeofencePendingIntent()");
        if (e == null)
        {
            m.a("~!RegionMonitor", "Create New GeofencePendingIntent");
            Intent intent = new Intent(com.exacttarget.etpushsdk.ETLocationManager.e(a), com/exacttarget/etpushsdk/ETLocationReceiver);
            intent.setAction("et_location_action_geofence_cross");
            e = PendingIntent.getBroadcast(com.exacttarget.etpushsdk.ETLocationManager.e(a), 1002, intent, 0x8000000);
        } else
        {
            m.a("~!RegionMonitor", "Reuse Existing GeofencePendingIntent");
        }
        return e;
    }

    private void c()
    {
        m.a("~!RegionMonitor", "updateGeofencesFromDatabase()");
        if (c == null)
        {
            m.a("~!RegionMonitor", "No Monitored Regions Yet");
            return;
        }
        ArrayList arraylist;
        Object obj1;
        Object obj2;
        obj1 = g.a("location_type = ? AND active = ?", new String[] {
            String.valueOf(1), "1"
        }, null, null, null);
        arraylist = new ArrayList();
        m.a("~!RegionMonitor", "Removing Regions ...");
        obj2 = c.iterator();
_L7:
        Object obj3;
        if (!((Iterator) (obj2)).hasNext())
        {
            break MISSING_BLOCK_LABEL_286;
        }
        obj3 = (Region)((Iterator) (obj2)).next();
        if (((List) (obj1)).contains(obj3) && !"~~m@g1c_f3nc3~~".equals(((Region) (obj3)).getId())) goto _L2; else goto _L1
_L1:
        arraylist.add(((Region) (obj3)).getId());
        if (TextUtils.isEmpty(((Region) (obj3)).getName())) goto _L4; else goto _L3
_L3:
        Object obj = ((Region) (obj3)).getName();
_L8:
        if (!((String) (obj)).equals("~~m@g1c_f3nc3~~")) goto _L6; else goto _L5
_L5:
        m.a("~!RegionMonitor", String.format("Removing Region: %1$s @ (%2$s, %3$s)", new Object[] {
            obj, ((Region) (obj3)).getLatitude(), ((Region) (obj3)).getLongitude()
        }));
          goto _L7
_L4:
        try
        {
            obj = ((Region) (obj3)).getId();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            m.c("~!RegionMonitor", ((Exception) (obj)).getMessage(), ((Throwable) (obj)));
            return;
        }
          goto _L8
_L6:
        m.a("~!RegionMonitor", String.format("Removing Region: %1$s", new Object[] {
            obj
        }));
          goto _L7
_L2:
        Message message;
        if (((Region) (obj3)).getActive().booleanValue())
        {
            obj = "ACTIVE";
        } else
        {
            obj = "INACTIVE";
        }
        m.a("~!RegionMonitor", String.format("Ignoring %1$s Region: %2$s", new Object[] {
            obj, ((Region) (obj3)).getName()
        }));
          goto _L7
        if (arraylist.size() > 0)
        {
            m.a("~!RegionMonitor", String.format("Removing %1$d Region(s)", new Object[] {
                Integer.valueOf(arraylist.size())
            }));
            ahy.c.a(ETLocationManager.c(a), arraylist).a(a(c, arraylist));
        }
        arraylist = new ArrayList();
        m.a("~!RegionMonitor", "Adding Regions ...");
        obj1 = ((List) (obj1)).iterator();
_L13:
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_555;
        }
        obj2 = (Region)((Iterator) (obj1)).next();
        if (c.contains(obj2) && !"~~m@g1c_f3nc3~~".equals(((Region) (obj2)).getId()))
        {
            break MISSING_BLOCK_LABEL_528;
        }
        arraylist.add(obj2);
        if (TextUtils.isEmpty(((Region) (obj2)).getName())) goto _L10; else goto _L9
_L9:
        obj = ((Region) (obj2)).getName();
_L14:
        if (!((String) (obj)).equals("~~m@g1c_f3nc3~~")) goto _L12; else goto _L11
_L11:
        m.a("~!RegionMonitor", String.format("Adding Region: %1$s @ (%2$s, %3$s)", new Object[] {
            obj, ((Region) (obj2)).getLatitude(), ((Region) (obj2)).getLongitude()
        }));
          goto _L13
_L10:
        obj = ((Region) (obj2)).getId();
          goto _L14
_L12:
        m.a("~!RegionMonitor", String.format("Adding Region: %1$s", new Object[] {
            obj
        }));
          goto _L13
        m.a("~!RegionMonitor", String.format("Already Monitoring Region: %1$s", new Object[] {
            ((Region) (obj2)).getName()
        }));
          goto _L13
        d = new ArrayList();
        obj = arraylist.iterator();
_L16:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_744;
        }
        obj1 = (Region)((Iterator) (obj)).next();
        obj2 = new ArrayList();
        obj3 = f.a("region_id = ?", new String[] {
            ((Region) (obj1)).getId()
        }, null, null, null).iterator();
_L15:
        do
        {
            if (!((Iterator) (obj3)).hasNext())
            {
                break MISSING_BLOCK_LABEL_677;
            }
            message = com.exacttarget.etpushsdk.database.e.a(((RegionMessage)((Iterator) (obj3)).next()).getMessage().getId());
        } while (message == null);
        ((List) (obj2)).add(message);
          goto _L15
        ((Region) (obj1)).setMessages(((List) (obj2)));
        m.a("~!RegionMonitor", String.format("Creating Geofence from Region: %1$s at (%2$s, %3$s) w/Radius of %4$dm", new Object[] {
            ((Region) (obj1)).getId(), ((Region) (obj1)).getLatitude(), ((Region) (obj1)).getLongitude(), ((Region) (obj1)).getRadius()
        }));
        d.add(((Region) (obj1)).a());
          goto _L16
        if (d.size() > 0)
        {
            m.a("~!RegionMonitor", String.format("Adding %1$d Region(s)", new Object[] {
                Integer.valueOf(arraylist.size())
            }));
            ahy.c.a(ETLocationManager.c(a), d, b()).a(a(a, d));
            return;
        }
        m.a("~!RegionMonitor", "No New Fences to Monitor");
        return;
    }

    public void a()
    {
        m.a("~!RegionMonitor", "Removing All Geofences");
        ahy.c.a(ETLocationManager.c(a), b()).a(a(b, b()));
    }

    public void a(Boolean boolean1)
    {
        b = boolean1;
    }

    public void a(List list)
    {
        c = list;
    }

    public void onConnected(Bundle bundle)
    {
        m.a("~!RegionMonitor", "GoogleApiClient onConnected()");
        if (!com.exacttarget.etpushsdk.util.d.h())
        {
            m.a("~!RegionMonitor", "Not Watching Location, Return");
            return;
        }
        if (b.booleanValue())
        {
            a();
            return;
        } else
        {
            c();
            return;
        }
    }

    public void onConnectionFailed(pp pp1)
    {
        m.a("~!RegionMonitor", "onConnectionFailed()");
        m.d("~!RegionMonitor", (new StringBuilder()).append("PlayServices connection failed: ").append(pp1.c()).toString());
    }

    public void onConnectionSuspended(int i)
    {
        m.a("~!RegionMonitor", String.format("onConnectionSuspended(%1$d)", new Object[] {
            Integer.valueOf(i)
        }));
    }

    private (ETLocationManager etlocationmanager)
    {
        a = etlocationmanager;
        super();
        b = Boolean.FALSE;
        c = null;
        d = null;
    }

    d(ETLocationManager etlocationmanager, c c1)
    {
        this(etlocationmanager);
    }
}
