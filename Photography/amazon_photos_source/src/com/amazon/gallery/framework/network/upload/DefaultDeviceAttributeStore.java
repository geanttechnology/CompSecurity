// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.upload;

import android.os.Build;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.UUID;

// Referenced classes of package com.amazon.gallery.framework.network.upload:
//            DeviceAttributeStore

public class DefaultDeviceAttributeStore
    implements DeviceAttributeStore
{

    private static final String TAG = com/amazon/gallery/framework/network/upload/DefaultDeviceAttributeStore.getName();

    public DefaultDeviceAttributeStore()
    {
    }

    public void clearCachedDeviceInformation()
    {
        GLogger.e(TAG, "Client should implement DeviceAttributeStore in Application layer and replace at creation of REST client", new Object[0]);
    }

    public boolean deviceHasWAN()
    {
        return false;
    }

    public String getCachedDeviceId()
    {
        GLogger.e(TAG, "Client should implement DeviceAttributeStore in Application layer and replace at creation of REST client", new Object[0]);
        return "0";
    }

    public String getDefaultDeviceName()
    {
        GLogger.e(TAG, "Client should implement DeviceAttributeStore in Application layer and replace at creation of REST client", new Object[0]);
        return "default";
    }

    public String getDeviceName()
    {
        GLogger.e(TAG, "Client should implement DeviceAttributeStore in Application layer and replace at creation of REST client", new Object[0]);
        return "default";
    }

    public String getDeviceSerialNumber()
    {
        GLogger.e(TAG, "Client should implement DeviceAttributeStore in Application layer and replace at creation of REST client", new Object[0]);
        return Build.SERIAL;
    }

    public String getDeviceType()
    {
        GLogger.e(TAG, "Client should implement DeviceAttributeStore in Application layer and replace at creation of REST client", new Object[0]);
        return Build.TYPE;
    }

    public String getDeviceTypeId()
    {
        GLogger.e(TAG, "Client should implement DeviceAttributeStore in Application layer and replace at creation of REST client", new Object[0]);
        return "default";
    }

    public String getUniqueDeviceId()
    {
        return UUID.randomUUID().toString();
    }

    public boolean isTablet()
    {
        GLogger.e(TAG, "Client should implement DeviceAttributeStore in Application layer and replace at creation of REST client", new Object[0]);
        return true;
    }

    public void storeDeviceId(String s)
    {
        GLogger.e(TAG, "Client should implement DeviceAttributeStore in Application layer and replace at creation of REST client", new Object[0]);
    }

}
