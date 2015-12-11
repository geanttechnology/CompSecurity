// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

// Referenced classes of package com.urbanairship:
//            UAirship, AirshipConfigOptions

public abstract class Autopilot
    implements UAirship.OnReadyCallback
{

    public static final String AUTOPILOT_MANIFEST_KEY = "com.urbanairship.autopilot";
    private static final String TAG = "Urban Airship Autopilot";

    public Autopilot()
    {
    }

    public static void automaticTakeOff(Application application)
    {
        com/urbanairship/Autopilot;
        JVM INSTR monitorenter ;
        if (UAirship.isFlying()) goto _L2; else goto _L1
_L1:
        boolean flag = UAirship.isTakingOff();
        if (!flag) goto _L3; else goto _L2
_L2:
        com/urbanairship/Autopilot;
        JVM INSTR monitorexit ;
        return;
_L3:
        Object obj = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData.getString("com.urbanairship.autopilot");
_L4:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        Log.e("Urban Airship Autopilot", "Unable to takeOff automatically");
          goto _L2
        application;
        throw application;
        obj;
        Log.e("Urban Airship Autopilot", (new StringBuilder("Failed to load meta-data, NameNotFound: ")).append(((android.content.pm.PackageManager.NameNotFoundException) (obj)).getMessage()).toString());
        obj = null;
          goto _L4
        obj;
        Log.e("Urban Airship Autopilot", (new StringBuilder("Failed to load meta-data, NullPointer: ")).append(((NullPointerException) (obj)).getMessage()).toString());
        obj = null;
          goto _L4
        obj = Class.forName(((String) (obj)));
        obj = (Autopilot)((Class) (obj)).newInstance();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        Log.e("Urban Airship Autopilot", "Unable to instantiate the defined Autopilot instance. Instance is null.");
          goto _L2
        application;
        Log.e("Urban Airship Autopilot", (new StringBuilder("Unable to load the defined Autopilot instance. ClassNotFoundException: ")).append(application.getMessage()).toString());
          goto _L2
        application;
        Log.e("Urban Airship Autopilot", (new StringBuilder("Unable to instantiate the defined Autopilot instance. IllegalAccessException: ")).append(application.getMessage()).toString());
          goto _L2
        application;
        Log.e("Urban Airship Autopilot", (new StringBuilder("Unable to instantiate the defined Autopilot instance. InstantiationException: ")).append(application.getMessage()).toString());
          goto _L2
        application;
        Log.e("Urban Airship Autopilot", (new StringBuilder("Unable to instantiate the defined Autopilot instance. ClassCastException: ")).append(application.getMessage()).toString());
          goto _L2
        AirshipConfigOptions airshipconfigoptions = ((Autopilot) (obj)).createAirshipConfigOptions(application);
        if (UAirship.isFlying() || UAirship.isTakingOff())
        {
            Log.e("Urban Airship Autopilot", "Airship is flying before autopilot is able to take off. Make sureAutoPilot.onCreateAirshipConfig is not calling takeOff directly.");
        }
        UAirship.takeOff(application, airshipconfigoptions, ((UAirship.OnReadyCallback) (obj)));
          goto _L2
    }

    public static void automaticTakeOff(Context context)
    {
        automaticTakeOff((Application)context.getApplicationContext());
    }

    public AirshipConfigOptions createAirshipConfigOptions(Context context)
    {
        return null;
    }
}
