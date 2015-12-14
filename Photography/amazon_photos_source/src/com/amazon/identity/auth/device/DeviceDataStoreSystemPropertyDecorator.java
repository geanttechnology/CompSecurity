// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.content.Context;
import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.SerialNumber;

// Referenced classes of package com.amazon.identity.auth.device:
//            DeviceDataStoreDefinition, DeviceDataInfo

public class DeviceDataStoreSystemPropertyDecorator
    implements DeviceDataStoreDefinition
{

    private DeviceDataInfo mDeviceSerialNumber;
    private DeviceDataInfo mDeviceType;
    private final DeviceDataStoreDefinition mOriginalDataStore;

    public DeviceDataStoreSystemPropertyDecorator(DeviceDataStoreDefinition devicedatastoredefinition, Context context)
    {
        mDeviceType = null;
        mDeviceSerialNumber = null;
        mOriginalDataStore = devicedatastoredefinition;
        devicedatastoredefinition = DeviceTypeHelpers.getCentralDeviceTypeFromSystemProperty(context);
        if (devicedatastoredefinition != null)
        {
            mDeviceType = new DeviceDataInfo(devicedatastoredefinition, true);
        }
        devicedatastoredefinition = SerialNumber.getAmazonSerial(context);
        if (devicedatastoredefinition != null)
        {
            mDeviceSerialNumber = new DeviceDataInfo(devicedatastoredefinition, true);
        }
    }

    public DeviceDataInfo getValue(String s)
        throws DeviceDataStoreException
    {
        if (mDeviceType != null && "DeviceType".equals(s))
        {
            return mDeviceType;
        }
        if (mDeviceSerialNumber != null && "Device Serial Number".equals(s))
        {
            return mDeviceSerialNumber;
        } else
        {
            return mOriginalDataStore.getValue(s);
        }
    }
}
