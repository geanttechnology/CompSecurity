// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import com.amazon.identity.auth.device.DeviceDataStoreImplementationFactory;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            SSODeviceInfo

public final class DeviceInfoHolder
{

    private static SSODeviceInfo sDeviceInfo = null;

    public static SSODeviceInfo getInstance(Context context)
    {
        com/amazon/identity/auth/device/framework/DeviceInfoHolder;
        JVM INSTR monitorenter ;
        if (sDeviceInfo == null)
        {
            sDeviceInfo = DeviceDataStoreImplementationFactory.getSSODeviceInfoImpl(context);
        }
        context = sDeviceInfo;
        com/amazon/identity/auth/device/framework/DeviceInfoHolder;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

}
