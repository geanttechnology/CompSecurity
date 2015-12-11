// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.controller;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.listener.Loc;
import com.tapjoy.mraid.view.MraidView;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.tapjoy.mraid.controller:
//            Abstract

public class MraidLocation extends Abstract
{

    final int c = 1000;
    private LocationManager d;
    private boolean e;
    private Loc f;
    private Loc g;
    private int h;
    private boolean i;

    public MraidLocation(MraidView mraidview, Context context)
    {
        super(mraidview, context);
        e = false;
        i = false;
        try
        {
            d = (LocationManager)context.getSystemService("location");
            if (!TapjoyConnectCore.isUnitTestMode())
            {
                if (d.getProvider("gps") != null)
                {
                    f = new Loc(context, 1000, this, "gps");
                }
                if (d.getProvider("network") != null)
                {
                    g = new Loc(context, 1000, this, "network");
                }
                e = true;
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MraidView mraidview)
        {
            return;
        }
    }

    private static String a(Location location)
    {
        return (new StringBuilder("{ lat: ")).append(location.getLatitude()).append(", lon: ").append(location.getLongitude()).append(", acc: ").append(location.getAccuracy()).append("}").toString();
    }

    public void allowLocationServices(boolean flag)
    {
        i = flag;
    }

    public boolean allowLocationServices()
    {
        return i;
    }

    public void fail()
    {
        TapjoyLog.e("MRAID Location", "Location can't be determined");
        a.injectMraidJavaScript("window.mraidview.fireErrorEvent(\"Location cannot be identified\", \"OrmmaLocationController\")");
    }

    public String getLocation()
    {
        TapjoyLog.d("MRAID Location", (new StringBuilder("getLocation: hasPermission: ")).append(e).toString());
        if (e)
        {
            Iterator iterator = d.getProviders(true).iterator();
            Location location = null;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Location location1 = d.getLastKnownLocation((String)iterator.next());
                location = location1;
                if (location1 == null)
                {
                    continue;
                }
                location = location1;
                break;
            } while (true);
            TapjoyLog.d("MRAID Location", (new StringBuilder("getLocation: ")).append(location).toString());
            if (location != null)
            {
                return a(location);
            }
        }
        return null;
    }

    public void startLocationListener()
    {
        if (h == 0)
        {
            if (g != null)
            {
                g.start();
            }
            if (f != null)
            {
                f.start();
            }
        }
        h = h + 1;
    }

    public void stopAllListeners()
    {
        h = 0;
        try
        {
            f.stop();
        }
        catch (Exception exception1) { }
        try
        {
            g.stop();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void stopLocationListener()
    {
        h = h - 1;
        if (h == 0)
        {
            if (g != null)
            {
                g.stop();
            }
            if (f != null)
            {
                f.stop();
            }
        }
    }

    public void success(Location location)
    {
        location = (new StringBuilder("window.mraidview.fireChangeEvent({ location: ")).append(a(location)).append("})").toString();
        TapjoyLog.d("MRAID Location", location);
        a.injectMraidJavaScript(location);
    }
}
