// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import com.amazon.identity.auth.device.DeviceDataCommunication;
import com.amazon.identity.auth.device.DeviceDataInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            DeviceDataStoreException

public final class DeviceDataStore
{

    private static final String TAG = com/amazon/identity/auth/device/api/DeviceDataStore.getName();
    private static DeviceDataStore sTheOneAndTheOnly;
    private final ServiceWrappingContext mContext;
    private final ConcurrentHashMap mDeviceDataCache = new ConcurrentHashMap();
    private final DeviceDataCommunication mDeviceDataCommunication;

    DeviceDataStore(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mDeviceDataCommunication = new DeviceDataCommunication(mContext);
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
        if (mDeviceDataCache.containsKey(s))
        {
            return (String)mDeviceDataCache.get(s);
        }
        DeviceDataInfo devicedatainfo = mDeviceDataCommunication.getValue(s);
        if (devicedatainfo == null)
        {
            s = String.format("Key %s was not found in the device data store", new Object[] {
                s
            });
            MAPLog.w(TAG, s);
            throw new DeviceDataStoreException(s);
        }
        String s1 = devicedatainfo.value;
        if (s1 != null)
        {
            if (devicedatainfo.isPersistent)
            {
                mDeviceDataCache.put(s, s1);
            }
        } else
        {
            MAPLog.i(TAG, "Getting null value for key %s ", new Object[] {
                s
            });
        }
        return s1;
    }

}
