// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            ag, af

public class ae
{

    ag a[] = {
        new ag(this, "gps"), new ag(this, "network")
    };
    private Context b;
    private af c;
    private LocationManager d;
    private boolean e;

    public ae(Context context, af af1)
    {
        b = context;
        c = af1;
    }

    static af a(ae ae1)
    {
        return ae1.c;
    }

    private void b()
    {
        if (d == null)
        {
            d = (LocationManager)b.getSystemService("location");
        }
        if (d != null)
        {
            try
            {
                d.requestLocationUpdates("network", 1000L, 0.0F, a[1]);
            }
            catch (SecurityException securityexception)
            {
                Log.i("LocationManager", "fail to request location update, ignore", securityexception);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.d("LocationManager", (new StringBuilder()).append("provider does not exist ").append(illegalargumentexception.getMessage()).toString());
            }
            try
            {
                d.requestLocationUpdates("gps", 1000L, 0.0F, a[0]);
                if (c != null)
                {
                    c.a(false);
                }
            }
            catch (SecurityException securityexception1)
            {
                Log.i("LocationManager", "fail to request location update, ignore", securityexception1);
            }
            catch (IllegalArgumentException illegalargumentexception1)
            {
                Log.d("LocationManager", (new StringBuilder()).append("provider does not exist ").append(illegalargumentexception1.getMessage()).toString());
            }
            Log.d("LocationManager", "startReceivingLocationUpdates");
        }
    }

    static boolean b(ae ae1)
    {
        return ae1.e;
    }

    private void c()
    {
        if (d != null)
        {
            int i = 0;
            while (i < a.length) 
            {
                try
                {
                    d.removeUpdates(a[i]);
                }
                catch (Exception exception)
                {
                    Log.i("LocationManager", "fail to remove location listners, ignore", exception);
                }
                i++;
            }
            Log.d("LocationManager", "stopReceivingLocationUpdates");
        }
        if (c != null)
        {
            c.a();
        }
    }

    public Location a()
    {
        if (!e)
        {
            return null;
        }
        for (int i = 0; i < a.length; i++)
        {
            Location location = a[i].a();
            if (location != null)
            {
                return location;
            }
        }

        Log.d("LocationManager", "No location received yet.");
        return null;
    }

    public void a(boolean flag)
    {
label0:
        {
            if (e != flag)
            {
                e = flag;
                if (!flag)
                {
                    break label0;
                }
                b();
            }
            return;
        }
        c();
    }
}
