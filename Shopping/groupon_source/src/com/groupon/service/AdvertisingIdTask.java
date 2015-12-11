// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.groupon.models.nst.AdTrackingExtraInfo;
import com.groupon.models.nst.AdTrackingSettingsMap;
import com.groupon.tracking.mobile.sdk.Logger;
import java.io.IOException;

public class AdvertisingIdTask extends AsyncTask
{

    private static final int STATUS_IO_EXCEPTION = 2;
    private static final int STATUS_NOT_AVAILABLE_EXCEPTION = 4;
    private static final int STATUS_NO_INFO = 1;
    private static final int STATUS_REPAIRABLE_EXCEPTION = 3;
    private static final int STATUS_SUCCESS = 0;
    private Context context;
    private Logger logger;
    private SharedPreferences prefs;

    public AdvertisingIdTask()
    {
    }

    private void logStatus(int i)
    {
        logger.logGeneralEvent("aid", "", "status", i, Logger.NULL_NST_FIELD);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = AdvertisingIdClient.getAdvertisingIdInfo(context);
        if (avoid == null) goto _L2; else goto _L1
_L1:
        String s;
        Logger logger1;
        boolean flag;
        s = avoid.getId();
        flag = avoid.isLimitAdTrackingEnabled();
        prefs.edit().putString("advertisingId", s).putBoolean("limitAdTracking", flag).apply();
        logger.logGeneralEvent("aidv", "", s, 0, Logger.NULL_NST_FIELD);
        logger1 = logger;
        if (flag)
        {
            avoid = "false";
        } else
        {
            avoid = "true";
        }
        logger1.logAdTracking("", new AdTrackingSettingsMap(avoid), new AdTrackingExtraInfo(s));
        logger.forceLogRotate();
        logStatus(0);
_L5:
        prefs.edit().putLong("advertisingIdLastUpdate", System.currentTimeMillis()).apply();
_L3:
        return null;
_L2:
        logStatus(1);
        continue; /* Loop/switch isn't completed */
        avoid;
        logStatus(2);
        prefs.edit().putLong("advertisingIdLastUpdate", System.currentTimeMillis()).apply();
          goto _L3
        avoid;
        logStatus(3);
        prefs.edit().putLong("advertisingIdLastUpdate", System.currentTimeMillis()).apply();
          goto _L3
        avoid;
        logStatus(4);
        prefs.edit().putLong("advertisingIdLastUpdate", System.currentTimeMillis()).apply();
          goto _L3
        avoid;
        prefs.edit().putLong("advertisingIdLastUpdate", System.currentTimeMillis()).apply();
        throw avoid;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
