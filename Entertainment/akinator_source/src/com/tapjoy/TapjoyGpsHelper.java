// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

// Referenced classes of package com.tapjoy:
//            TapjoyIntegrationException, TapjoyLog, TapjoyAdIdClient

public class TapjoyGpsHelper
{

    private Context a;
    private String b;
    private boolean c;
    private int d;
    private int e;
    private boolean f;
    private Boolean g;
    private Boolean h;

    public TapjoyGpsHelper(Context context)
    {
        d = 0;
        e = 0;
        a = context;
    }

    public void checkGooglePlayIntegration()
    {
        if (!isGooglePlayServicesAvailable())
        {
            throw new TapjoyIntegrationException("Tapjoy SDK is disabled because Google Play Services was not found. For more information about including the Google Play services client library visit http://developer.android.com/google/play-services/setup.html or http://tech.tapjoy.com/product-overview/sdk-change-log/tapjoy-and-identifiers");
        }
        if (!isGooglePlayManifestConfigured())
        {
            throw new TapjoyIntegrationException("Failed to load manifest.xml meta-data, 'com.google.android.gms.version' not found. For more information about including the Google Play services client library visit http://developer.android.com/google/play-services/setup.html or http://tech.tapjoy.com/product-overview/sdk-change-log/tapjoy-and-identifiers");
        } else
        {
            return;
        }
    }

    public String getAdvertisingId()
    {
        return b;
    }

    public int getDeviceGooglePlayServicesVersion()
    {
        return d;
    }

    public int getPackagedGooglePlayServicesVersion()
    {
        return e;
    }

    public boolean isAdIdAvailable()
    {
        return f;
    }

    public boolean isAdTrackingEnabled()
    {
        return c;
    }

    public boolean isGooglePlayManifestConfigured()
    {
        if (h == null)
        {
            try
            {
                e = a.getPackageManager().getApplicationInfo(a.getPackageName(), 128).metaData.getInt("com.google.android.gms.version");
                h = Boolean.valueOf(true);
            }
            catch (Exception exception)
            {
                h = Boolean.valueOf(false);
            }
        }
        return h.booleanValue();
    }

    public boolean isGooglePlayServicesAvailable()
    {
        if (g == null)
        {
            try
            {
                a.getClassLoader().loadClass("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                g = Boolean.valueOf(true);
            }
            catch (Exception exception)
            {
                g = Boolean.valueOf(false);
            }
            catch (Error error)
            {
                g = Boolean.valueOf(false);
            }
        }
        return g.booleanValue();
    }

    public void loadAdvertisingId()
    {
        TapjoyLog.i("TapjoyGpsHelper", "Looking for Google Play Services...");
        if (isGooglePlayServicesAvailable() && isGooglePlayManifestConfigured())
        {
            TapjoyLog.i("TapjoyGpsHelper", "Packaged Google Play Services found, fetching advertisingID...");
            TapjoyLog.i("TapjoyGpsHelper", (new StringBuilder("Packaged Google Play Services version: ")).append(e).toString());
            TapjoyAdIdClient tapjoyadidclient = new TapjoyAdIdClient(a);
            f = tapjoyadidclient.setupAdIdInfo();
            try
            {
                d = a.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
                TapjoyLog.i("TapjoyGpsHelper", (new StringBuilder("Device's Google Play Services version: ")).append(d).toString());
            }
            catch (Exception exception)
            {
                TapjoyLog.i("TapjoyGpsHelper", "Error getting device's Google Play Services version");
            }
            if (f)
            {
                c = tapjoyadidclient.isAdTrackingEnabled();
                b = tapjoyadidclient.getAdvertisingId();
                TapjoyLog.i("TapjoyGpsHelper", (new StringBuilder("Found advertising ID: ")).append(b).toString());
                TapjoyLog.i("TapjoyGpsHelper", (new StringBuilder("Is ad tracking enabled: ")).append(Boolean.toString(c)).toString());
                return;
            } else
            {
                TapjoyLog.i("TapjoyGpsHelper", "Error getting advertisingID from Google Play Services");
                return;
            }
        } else
        {
            TapjoyLog.i("TapjoyGpsHelper", "Google Play Services not found");
            return;
        }
    }
}
