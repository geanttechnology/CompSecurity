// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import com.amazon.identity.auth.device.DeviceDataInfo;
import com.amazon.identity.auth.device.DeviceDataStoreCache;
import com.amazon.identity.auth.device.DeviceDataStoreDefinition;
import com.amazon.identity.auth.device.DeviceDataStoreImplementationFactory;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            DeviceDataStoreException

public final class DeviceDataStore
{

    private static final String TAG = com/amazon/identity/auth/device/api/DeviceDataStore.getName();
    private static DeviceDataStore sTheOneAndTheOnly;
    private final DeviceDataStoreCache mDeviceDataCache = DeviceDataStoreCache.getInstance();
    private final DeviceDataStoreDefinition mDeviceDataStoreDefinition;

    DeviceDataStore(Context context)
    {
        mDeviceDataStoreDefinition = DeviceDataStoreImplementationFactory.getDeviceDataStoreImplementation(context);
    }

    public static DeviceDataStore getInstance(Context context)
    {
        com/amazon/identity/auth/device/api/DeviceDataStore;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null)
        {
            sTheOneAndTheOnly = new DeviceDataStore(context.getApplicationContext());
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/api/DeviceDataStore;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public String getValue(String s)
        throws DeviceDataStoreException
    {
        if (s == null)
        {
            s = String.format("Key passed in is null", new Object[0]);
            MAPLog.w(TAG, s);
            throw new DeviceDataStoreException(s);
        }
        String s1;
        if (mDeviceDataCache.containsKey(s))
        {
            s1 = mDeviceDataCache.get(s);
        } else
        {
            DeviceDataInfo devicedatainfo = mDeviceDataStoreDefinition.getValue(s);
            if (devicedatainfo == null)
            {
                s = String.format("Key %s was not found in the device data store", new Object[] {
                    s
                });
                MAPLog.w(TAG, s);
                throw new DeviceDataStoreException(s);
            }
            String s2 = devicedatainfo.value;
            if (s2 != null)
            {
                s1 = s2;
                if (devicedatainfo.isPersistent)
                {
                    mDeviceDataCache.put(s, s2);
                    return s2;
                }
            } else
            {
                MAPLog.formattedInfo(TAG, "Getting null value for key %s ", new Object[] {
                    s
                });
                return s2;
            }
        }
        return s1;
    }

}
