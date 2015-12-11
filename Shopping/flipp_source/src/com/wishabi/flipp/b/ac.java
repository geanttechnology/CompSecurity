// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.c;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.ir;
import com.google.android.gms.internal.it;
import com.google.android.gms.internal.iu;
import com.google.android.gms.internal.ix;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

// Referenced classes of package com.wishabi.flipp.b:
//            ab, ad, ae

final class ac
    implements c
{

    final long a;
    final int b = 100;
    final ab c;

    ac(ab ab1, long l)
    {
        c = ab1;
        a = l;
        super();
    }

    public final void a_()
    {
        Object obj;
        LocationRequest locationrequest;
        ad ad1;
        obj = c.b.a();
        if (obj != null && System.currentTimeMillis() - ((Location) (obj)).getTime() < a)
        {
            Date date = new Date(((Location) (obj)).getTime());
            SimpleDateFormat simpledateformat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy a");
            simpledateformat.setTimeZone(TimeZone.getTimeZone("Canada/Eastern"));
            String.format("Found cached location: %f %f %s", new Object[] {
                Double.valueOf(((Location) (obj)).getLatitude()), Double.valueOf(((Location) (obj)).getLongitude()), simpledateformat.format(date)
            });
            c.a(((Location) (obj)), 0);
            c.b.a.g();
            c.b = null;
            return;
        }
        locationrequest = new LocationRequest();
        int i = b;
        switch (i)
        {
        case 101: // 'e'
        case 103: // 'g'
        default:
            throw new IllegalArgumentException((new StringBuilder("invalid quality: ")).append(i).toString());

        case 100: // 'd'
        case 102: // 'f'
        case 104: // 'h'
        case 105: // 'i'
            locationrequest.b = i;
            break;
        }
        locationrequest.g = 1;
        long l = SystemClock.elapsedRealtime();
        if (10000L > 0x7fffffffffffffffL - l)
        {
            locationrequest.f = 0x7fffffffffffffffL;
        } else
        {
            locationrequest.f = l + 10000L;
        }
        if (locationrequest.f < 0L)
        {
            locationrequest.f = 0L;
        }
        if (0L < 0L)
        {
            throw new IllegalArgumentException("invalid interval: 0");
        }
        locationrequest.c = 0L;
        if (!locationrequest.e)
        {
            locationrequest.d = (long)((double)locationrequest.c / 6D);
        }
        obj = c.b;
        ad1 = new ad(this);
        obj = ((e) (obj)).a;
        ir ir1 = ((iu) (obj)).f;
        ir1;
        JVM INSTR monitorenter ;
        ir ir2;
        ir2 = ((iu) (obj)).f;
        ir2.a.a();
        ha.a(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
        HashMap hashmap = ir2.d;
        hashmap;
        JVM INSTR monitorenter ;
        obj = (it)ir2.d.get(ad1);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_407;
        }
        obj = new it(ad1);
        ir2.d.put(ad1, obj);
        ((io)ir2.a.b()).a(locationrequest, ((com.google.android.gms.location.j) (obj)), ir2.b.getPackageName());
        hashmap;
        JVM INSTR monitorexit ;
        ir1;
        JVM INSTR monitorexit ;
        c.c.postDelayed(new ae(this), 10000L);
        return;
        Object obj1;
        obj1;
        throw new IllegalStateException(((Throwable) (obj1)));
        obj1;
        hashmap;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        ir1;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public final void b()
    {
    }
}
