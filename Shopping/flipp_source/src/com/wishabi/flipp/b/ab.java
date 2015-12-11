// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import com.google.android.gms.common.g;
import com.google.android.gms.internal.iu;
import com.google.android.gms.location.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// Referenced classes of package com.wishabi.flipp.b:
//            ac, af

public abstract class ab
{

    private final Context a;
    e b;
    final Handler c = new Handler();

    public ab(Context context)
    {
        a = context;
    }

    static void a(ab ab1, Location location, int i)
    {
        if (ab1.b == null) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy a");
        ((SimpleDateFormat) (obj)).setTimeZone(TimeZone.getTimeZone("Canada/Eastern"));
        if (location != null)
        {
            obj = ((SimpleDateFormat) (obj)).format(new Date(location.getTime()));
        } else
        {
            obj = null;
        }
        i;
        JVM INSTR tableswitch 0 1: default 68
    //                   0 84
    //                   1 125;
           goto _L3 _L4 _L5
_L3:
        ab1.a(location, i);
        ab1.a();
_L2:
        return;
_L4:
        if (location != null)
        {
            String.format("Found cached location: %f %f %s", new Object[] {
                Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), obj
            });
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (location != null)
        {
            String.format("Found active location: %f %f %s", new Object[] {
                Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), obj
            });
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    public final void a()
    {
        if (b != null)
        {
            b.a.g();
            b = null;
        }
        c.removeCallbacksAndMessages(null);
    }

    public final void a(long l)
    {
        if (b != null)
        {
            a();
        }
        if (a == null)
        {
            a(null, 5);
        } else
        {
            LocationManager locationmanager = (LocationManager)a.getSystemService("location");
            if (!locationmanager.isProviderEnabled("gps") && !locationmanager.isProviderEnabled("network"))
            {
                a(null, 2);
                return;
            }
            int i = g.a(a);
            if (i != 0)
            {
                a(null, 3);
                if (a instanceof Activity)
                {
                    g.a(i, (Activity)a).show();
                    return;
                }
            } else
            {
                b = new e(a, new ac(this, l), new af(this));
                b.a.d();
                return;
            }
        }
    }

    public abstract void a(Location location, int i);
}
