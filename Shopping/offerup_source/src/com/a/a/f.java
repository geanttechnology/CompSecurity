// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.a.d;
import com.a.e;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.a.a:
//            a, b, g, c

public final class f extends a
    implements LocationListener
{

    private LocationManager f;
    private Location g;
    private boolean h;
    private Date i;

    public f(Activity activity, c c, d d1, long l)
    {
        super(activity, c, d1, com.a.a.b.d, l);
        i = new Date();
        f = (LocationManager)activity.getApplicationContext().getSystemService("location");
    }

    private boolean a(Location location, Location location1)
    {
        if (location1 != null)
        {
            long l = location.getTime() - location1.getTime();
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (l > 0x36ee80L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (l < 0x36ee80L)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (l > 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag1)
            {
                if (flag2)
                {
                    return false;
                }
                int j = (int)(location.getAccuracy() - location1.getAccuracy());
                boolean flag3;
                boolean flag4;
                if (j > 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (j < 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (j > 200)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                location = location.getProvider();
                location1 = location1.getProvider();
                if (location == null)
                {
                    if (location1 == null)
                    {
                        flag4 = true;
                    } else
                    {
                        flag4 = false;
                    }
                } else
                {
                    flag4 = location.equals(location1);
                }
                if (!flag2 && (!flag || flag1) && (!flag || flag3 || !flag4))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private void f()
    {
        if (g == null) goto _L2; else goto _L1
_L1:
        long l = (g.getTime() - i.getTime()) / 1000L;
        a((new StringBuilder("Time it took:")).append(l).toString(), new Object[0]);
        b.a(e.a, (new StringBuilder()).append(g.getLatitude()).toString());
        b.a(e.b, (new StringBuilder()).append(g.getLongitude()).toString());
        b.a(e.c, (new StringBuilder()).append(g.getTime() / 1000L).toString());
        b.a(e.d, (new StringBuilder()).append(g.getProvider()).toString());
        h = true;
_L4:
        e = true;
        g();
        a(c, d);
        return;
_L2:
        a("No Location found.", new Object[0]);
        if (c == null)
        {
            c = com.a.a.g.d;
            d = new RuntimeException("No location found");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void g()
    {
        if (f != null)
        {
            f.removeUpdates(this);
        }
    }

    protected final void a()
    {
        Object obj1;
        Object obj = null;
        h = false;
        String s;
        String s1;
        Iterator iterator;
        try
        {
            a("Getting providers", new Object[0]);
            obj1 = f.getProviders(true);
            if (((List) (obj1)).size() == 0)
            {
                a(com.a.a.g.d, ((Exception) (new RuntimeException(com.a.a.g.d.name()))));
                return;
            }
        }
        catch (SecurityException securityexception)
        {
            a(securityexception.getMessage(), new Object[0]);
            c = g.c;
            d = securityexception;
            return;
        }
        iterator = ((List) (obj1)).iterator();
_L13:
        obj1 = obj;
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        s1 = (String)iterator.next();
        s = ((String) (obj));
        if (isCancelled()) goto _L4; else goto _L3
_L3:
        a((new StringBuilder("Trying provider [")).append(s1).append("]").toString(), new Object[0]);
        obj1 = obj;
        if (obj == null)
        {
            obj1 = s1;
        }
        obj = f.getLastKnownLocation("network");
        s = ((String) (obj1));
        if (obj == null) goto _L4; else goto _L5
_L5:
        s = ((String) (obj1));
        if (i.getTime() - ((Location) (obj)).getTime() >= 0x36ee80L) goto _L4; else goto _L6
_L6:
        a((new StringBuilder("New enough, using this location: ")).append(((Location) (obj)).getProvider()).toString(), new Object[0]);
        if (!a(((Location) (obj)), g)) goto _L2; else goto _L7
_L7:
        a((new StringBuilder()).append(((Location) (obj)).getProvider()).append(" is better location").toString(), new Object[0]);
        g = ((Location) (obj));
        h = true;
        obj1 = s1;
_L2:
        if (isCancelled() || c != null)
        {
            break MISSING_BLOCK_LABEL_481;
        }
        if (h && obj1 != null)
        {
            break MISSING_BLOCK_LABEL_477;
        }
        a("making a single request", new Object[0]);
        this;
        JVM INSTR monitorenter ;
        Looper.prepare();
        if (android.os.Build.VERSION.SDK_INT <= 8) goto _L9; else goto _L8
_L8:
        f.requestSingleUpdate(((String) (obj1)), this, null);
_L10:
        if (!e && !isCancelled())
        {
            a("Waiting on location... for [%s] milliseconds", new Object[] {
                (new StringBuilder()).append(e()).toString()
            });
            wait(e());
            a("Done Waiting on location.", new Object[0]);
            if (!h)
            {
                g();
                d();
            }
        }
_L11:
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L4:
        obj = s;
        continue; /* Loop/switch isn't completed */
_L9:
        f.requestLocationUpdates(((String) (obj1)), 1000L, 1.0F, this);
          goto _L10
        Exception exception;
        exception;
        a((new StringBuilder("Got exception(hiding it):")).append(exception.getMessage()).toString(), new Object[0]);
          goto _L11
        f();
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    protected final void finalize()
    {
        super.finalize();
        g();
    }

    public final void onLocationChanged(Location location)
    {
        if (a(location, g))
        {
            g = location;
        }
        f();
    }

    public final void onProviderDisabled(String s)
    {
        f();
    }

    public final void onProviderEnabled(String s)
    {
    }

    public final void onStatusChanged(String s, int j, Bundle bundle)
    {
        if (j == 0 || j == 1)
        {
            f();
        }
    }
}
