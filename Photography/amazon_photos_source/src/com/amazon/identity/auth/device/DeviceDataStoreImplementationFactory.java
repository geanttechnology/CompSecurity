// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.content.Context;
import com.amazon.identity.auth.device.framework.AmazonDeviceInfo;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.platform.util.PlatformUtils;

// Referenced classes of package com.amazon.identity.auth.device:
//            DeviceDataCommunication, DeviceDataStoreSystemPropertyDecorator, AMDeviceDataLogic, DeviceDataLogic, 
//            DeviceDataStoreDefinition

public final class DeviceDataStoreImplementationFactory
{

    private static volatile DeviceDataStoreImplementationFactory sInstance;
    private DeviceDataStoreDefinition mDeviceDataDefinitionImpl;
    private SSODeviceInfo mSSODeviceInfoImpl;

    private DeviceDataStoreImplementationFactory(Context context)
    {
        boolean flag = PlatformUtils.unSecureCheckHasContentProviderWithAuthority(context, DeviceDataCommunication.DEVICE_DATA_STORE_URI);
        if (flag && PlatformUtils.isPostMergeDevice(context))
        {
            mSSODeviceInfoImpl = new AmazonDeviceInfo(context);
            mDeviceDataDefinitionImpl = new DeviceDataStoreSystemPropertyDecorator(new DeviceDataCommunication(ServiceWrappingContext.create(context)), context);
            return;
        }
        if (PlatformUtils.isNonAmazonDeviceWithCentralSSO(context))
        {
            context = AMDeviceDataLogic.getInstance(context, flag);
            mSSODeviceInfoImpl = context.buildSSODeviceInfo();
            mDeviceDataDefinitionImpl = context;
            return;
        } else
        {
            mSSODeviceInfoImpl = new AmazonDeviceInfo(context);
            mDeviceDataDefinitionImpl = DeviceDataLogic.getInstance(context);
            return;
        }
    }

    public static DeviceDataStoreDefinition getDeviceDataStoreImplementation(Context context)
    {
        return getInstance(context).mDeviceDataDefinitionImpl;
    }

    static DeviceDataStoreImplementationFactory getInstance(Context context)
    {
        if (sInstance != null) goto _L2; else goto _L1
_L1:
        com/amazon/identity/auth/device/DeviceDataStoreImplementationFactory;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new DeviceDataStoreImplementationFactory(context);
        }
        com/amazon/identity/auth/device/DeviceDataStoreImplementationFactory;
        JVM INSTR monitorexit ;
_L2:
        return sInstance;
        context;
        throw context;
    }

    public static SSODeviceInfo getSSODeviceInfoImpl(Context context)
    {
        return getInstance(context).mSSODeviceInfoImpl;
    }
}
