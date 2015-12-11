// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.tracking;

import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.model.user.UserManager;

// Referenced classes of package com.comcast.cim.tracking:
//            CimAppMeasurement

public abstract class TrackingService
{

    protected final AndroidDevice androidDevice;
    protected final Provider appMeasurementProvider;
    protected final String applicationVersion;
    protected final UserManager userManager;

    public TrackingService(UserManager usermanager, String s, AndroidDevice androiddevice, Provider provider)
    {
        userManager = usermanager;
        applicationVersion = s;
        androidDevice = androiddevice;
        appMeasurementProvider = provider;
    }

    protected CimAppMeasurement getAppMeasurement(String s)
    {
        CimAppMeasurement cimappmeasurement = (CimAppMeasurement)appMeasurementProvider.get();
        cimappmeasurement.putCdata("events", s);
        cimappmeasurement.putCdata("appName", "xfinityplayer app");
        cimappmeasurement.putCdata("hashedGUID", userManager.getHashedOmnitureGuid());
        cimappmeasurement.putCdata("cellularCarrier", androidDevice.getCarrier());
        return cimappmeasurement;
    }
}
