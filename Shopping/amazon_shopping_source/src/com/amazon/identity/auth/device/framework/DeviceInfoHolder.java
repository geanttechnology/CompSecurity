// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            AmazonDeviceInfo, SSODeviceInfo

public final class DeviceInfoHolder
{

    private static SSODeviceInfo sDeviceInfo = null;

    private DeviceInfoHolder()
    {
    }

    public static SSODeviceInfo getInstance(Context context)
    {
        com/amazon/identity/auth/device/framework/DeviceInfoHolder;
        JVM INSTR monitorenter ;
        if (sDeviceInfo == null)
        {
            sDeviceInfo = new AmazonDeviceInfo(context);
        }
        context = sDeviceInfo;
        com/amazon/identity/auth/device/framework/DeviceInfoHolder;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

}
