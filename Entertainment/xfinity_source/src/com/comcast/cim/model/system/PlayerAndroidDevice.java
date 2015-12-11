// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.system;

import android.app.Application;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerAndroidDevice extends AndroidDevice
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/model/system/PlayerAndroidDevice);

    public PlayerAndroidDevice(Application application, Resources resources, TelephonyManager telephonymanager, String s)
    {
        super(application, resources, telephonymanager, s);
    }

    public boolean hasCellularCapability()
    {
        PackageManager packagemanager = application.getPackageManager();
        return packagemanager.hasSystemFeature("android.hardware.telephony") || packagemanager.hasSystemFeature("com.verizon.hardware.telephony.lte") || packagemanager.hasSystemFeature("com.verizon.hardware.telephony.ehrpd") || packagemanager.hasSystemFeature("com.vzw.hardware.lte") || packagemanager.hasSystemFeature("com.vzw.hardware.ehrpd");
    }

}
