// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.location;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import com.exacttarget.etpushsdk.event.LastKnownLocationEvent;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.m;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.exacttarget.etpushsdk.location:
//            a, d

public class c
    implements a
{

    protected PendingIntent a;
    protected LocationListener b;
    protected LocationManager c;
    protected Context d;
    protected Criteria e;
    protected BroadcastReceiver f;

    public c(Context context)
    {
        f = new d(this);
        d = context;
        c = (LocationManager)context.getSystemService("location");
        e = new Criteria();
        e.setAccuracy(1);
        a = PendingIntent.getBroadcast(context, 0, new Intent("com.exacttarget.etpushsdk.SINGLE_LOCATION_UPDATE_ACTION"), 0x8000000);
    }

    public Location a(int i, long l)
    {
        Location location = null;
        long l1 = 0x8000000000000000L;
        Iterator iterator = c.getAllProviders().iterator();
        float f1 = 3.402823E+38F;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            obj = c.getLastKnownLocation(((String) (obj)));
            if (obj != null)
            {
                float f2 = ((Location) (obj)).getAccuracy();
                long l2 = ((Location) (obj)).getTime();
                if (l2 > l && f2 <= f1 && l2 > l1)
                {
                    f1 = f2;
                    location = ((Location) (obj));
                    l1 = l2;
                } else
                if (l2 < l && f1 == 3.402823E+38F && l2 > l1)
                {
                    location = ((Location) (obj));
                    l1 = l2;
                }
            }
        } while (true);
        if (l1 < l || f1 > (float)i)
        {
            m.a("~!lc", "starting singleUpdateReceiver");
            IntentFilter intentfilter = new IntentFilter("com.exacttarget.etpushsdk.SINGLE_LOCATION_UPDATE_ACTION");
            d.registerReceiver(f, intentfilter);
            try
            {
                c.requestSingleUpdate(e, a);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                m.c("~!lc", illegalargumentexception.getMessage(), illegalargumentexception);
                return location;
            }
            return location;
        } else
        {
            EventBus.getInstance().b(new LastKnownLocationEvent(location));
            return location;
        }
    }

    public void a()
    {
        c.removeUpdates(a);
    }
}
