// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Display;
import android.view.WindowManager;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.medialets.advertising:
//            AdManager, a, AdManagerService

final class y
{

    public static final int CDN_CONNECTED = 2;
    public static final int NOT_CONNECTED = 0;
    public static final int UNKNOWN_CONNECTION = 1;
    public static final int WIFI_CONNECTED = 3;

    y()
    {
    }

    public static int a()
    {
        Object obj = AdManager.getInstance().mService;
        int i;
        try
        {
            obj = ((ConnectivityManager)((Context) (obj)).getSystemService("connectivity")).getActiveNetworkInfo();
        }
        catch (SecurityException securityexception)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Could not gain access to network state, reporting unknown connection: ").append(securityexception.toString()).toString());
            return 1;
        }
_L5:
        if (obj == null)
        {
            return 1;
        }
        i = ((NetworkInfo) (obj)).getType();
        i;
        JVM INSTR lookupswitch 3: default 68
    //                   0: 77
    //                   1: 72
    //                   6: 82;
           goto _L1 _L2 _L3 _L4
_L1:
        i = 1;
_L6:
        return i;
_L3:
        i = 3;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 2;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 2;
        if (true) goto _L6; else goto _L5
    }

    public static String a(String s)
    {
        s = (new BigInteger(1, MessageDigest.getInstance("MD5").digest(s.getBytes()))).toString(16);
_L2:
        String s1 = s;
        if (s.length() >= 32)
        {
            break; /* Loop/switch isn't completed */
        }
        s = (new StringBuilder()).append("0").append(s).toString();
        if (true) goto _L2; else goto _L1
        s;
        com.medialets.advertising.a.c((new StringBuilder()).append("MD5 Algorithm was not found: ").append(s.toString()).toString());
        s1 = null;
_L1:
        return s1;
    }

    public static boolean b()
    {
        return a() > 0;
    }

    public static Display c()
    {
        return ((WindowManager)AdManager.getInstance().mService.getSystemService("window")).getDefaultDisplay();
    }

    public static String d()
    {
        AdManager admanager = AdManager.getInstance();
        String s1 = android.provider.Settings.Secure.getString(admanager.mService.getContentResolver(), "android_id");
        String s = s1;
        if (s1 == null)
        {
            s = admanager.mService.getApplicationId();
        }
        return s;
    }

    public static double[] e()
    {
        Object obj = new Criteria();
        ((Criteria) (obj)).setAccuracy(2);
        ((Criteria) (obj)).setAltitudeRequired(false);
        ((Criteria) (obj)).setBearingRequired(false);
        ((Criteria) (obj)).setCostAllowed(false);
        ((Criteria) (obj)).setPowerRequirement(1);
        ((Criteria) (obj)).setSpeedRequired(false);
        LocationManager locationmanager = (LocationManager)AdManager.getInstance().mService.getSystemService("location");
        String s = locationmanager.getBestProvider(((Criteria) (obj)), true);
        obj = s;
        if (s == null)
        {
            obj = "network";
        }
        double ad[];
        try
        {
            obj = locationmanager.getLastKnownLocation(((String) (obj)));
        }
        catch (SecurityException securityexception)
        {
            com.medialets.advertising.a.d((new StringBuilder()).append("No permission to access the location. Setting to zeroes: ").append(securityexception.toString()).toString());
            securityexception = null;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Error with the location provider: ").append(illegalargumentexception.toString()).toString());
            illegalargumentexception = null;
        }
        ad = new double[2];
        if (obj != null)
        {
            ad[0] = ((Location) (obj)).getLatitude();
            ad[1] = ((Location) (obj)).getLongitude();
            return ad;
        } else
        {
            ad[0] = 0.0D;
            ad[1] = 0.0D;
            return ad;
        }
    }

    public static int f()
    {
        int i = c().getOrientation();
        boolean flag;
        if (i == 1 || i == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag ? 2 : 1;
    }

    public static boolean g()
    {
        ActivityInfo activityinfo = AdManager.getInstance().getCurrentActivityInfo();
        if ((activityinfo.configChanges & 0x80) == 128 && (activityinfo.configChanges & 0x20) == 32)
        {
            com.medialets.advertising.a.d("Supports orientation: true");
            return true;
        } else
        {
            com.medialets.advertising.a.d("Supports orientation: false");
            return false;
        }
    }
}
