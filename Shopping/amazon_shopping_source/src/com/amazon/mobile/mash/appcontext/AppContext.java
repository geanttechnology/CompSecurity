// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.appcontext;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.amazon.mobile.mash.util.UIUtils;

// Referenced classes of package com.amazon.mobile.mash.appcontext:
//            CapabilityManager

public abstract class AppContext
{

    private CapabilityManager mCapabilityManager;

    public AppContext(CapabilityManager capabilitymanager)
    {
        mCapabilityManager = capabilitymanager;
    }

    public String getAppContextSchemaVersion()
    {
        return "1.3";
    }

    public abstract String getAppName();

    public abstract String getAppVersion();

    public long getCapability()
    {
        return mCapabilityManager.formatCapabilities();
    }

    public abstract String getDebugWeinreServerHost();

    public abstract int getDebugWeinreServerPort();

    public abstract boolean getDebugWeinreServerSatus();

    public String getDeviceCarrier(Context context)
    {
        return ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
    }

    public String getDeviceConnectionType(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context == null || !context.isConnected())
        {
            return null;
        } else
        {
            return context.getTypeName();
        }
    }

    public int getDeviceDisplayHeight(Context context)
    {
        return UIUtils.getPortraitHeight(context);
    }

    public int getDeviceDisplayWidth(Context context)
    {
        return UIUtils.getPortraitWidth(context);
    }

    public abstract String getDeviceDmsDeviceType();

    public abstract String getDeviceDmsSerialNumber();

    public float getDeviceLogicalDensity(Context context)
    {
        return UIUtils.getDeviceDisplayMetrics(context).density;
    }

    public String getDeviceManufacturer()
    {
        return Build.MANUFACTURER;
    }

    public String getDeviceModal()
    {
        return Build.MODEL;
    }

    public String getDeviceModalVersion()
    {
        return Build.DEVICE;
    }

    public float getDevicePhysicalDensityX(Context context)
    {
        return UIUtils.getDeviceDisplayMetrics(context).xdpi;
    }

    public float getDevicePhysicalDensityY(Context context)
    {
        return UIUtils.getDeviceDisplayMetrics(context).ydpi;
    }

    public String getDeviceProductLine()
    {
        return Build.PRODUCT;
    }

    public String getMASHApiVersion()
    {
        return "1.11.0";
    }

    public int getMASHUrlIntercepterVersion()
    {
        return 2;
    }

    public abstract String getOSName();

    public String getOSVersion()
    {
        return android.os.Build.VERSION.RELEASE;
    }
}
