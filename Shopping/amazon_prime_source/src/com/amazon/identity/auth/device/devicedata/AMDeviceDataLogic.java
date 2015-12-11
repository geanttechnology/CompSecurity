// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.devicedata;

import android.content.Context;
import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.api.MultipleAccountManager;
import com.amazon.identity.auth.device.framework.AMDeviceInfo;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.UnitTestUtils;

// Referenced classes of package com.amazon.identity.auth.device.devicedata:
//            DeviceDataLogic, DeviceDataCommunication, DeviceDataInfo

public final class AMDeviceDataLogic extends DeviceDataLogic
{

    private static AMDeviceDataLogic sTheOneAndTheOnly;
    private final Context mContext;
    private DeviceDataCommunication mDeviceDataCommunication;
    private final boolean mIsContentProviderPresent;
    private final MultipleAccountManager mMultipleAccountManager;

    private AMDeviceDataLogic(Context context, boolean flag)
    {
        super(context);
        mIsContentProviderPresent = flag;
        mContext = context;
        mMultipleAccountManager = new MultipleAccountManager(mContext);
    }

    private DeviceDataCommunication getDeviceDataCommunication()
    {
        this;
        JVM INSTR monitorenter ;
        DeviceDataCommunication devicedatacommunication;
        if (mDeviceDataCommunication == null)
        {
            mDeviceDataCommunication = new DeviceDataCommunication(ServiceWrappingContext.create(mContext));
        }
        devicedatacommunication = mDeviceDataCommunication;
        this;
        JVM INSTR monitorexit ;
        return devicedatacommunication;
        Exception exception;
        exception;
        throw exception;
    }

    public static AMDeviceDataLogic getInstance(Context context, boolean flag)
    {
        com/amazon/identity/auth/device/devicedata/AMDeviceDataLogic;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null || UnitTestUtils.isRunningInUnitTest())
        {
            sTheOneAndTheOnly = new AMDeviceDataLogic(context.getApplicationContext(), flag);
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/devicedata/AMDeviceDataLogic;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public SSODeviceInfo buildSSODeviceInfo()
    {
        return new AMDeviceInfo(mContext, mMultipleAccountManager);
    }

    public DeviceDataInfo getValue(String s)
        throws DeviceDataStoreException
    {
        KeyInfo keyinfo = KeyInfo.parseKey(s);
        if (mIsContentProviderPresent && ("Default COR".equals(keyinfo.getKey()) || "Default PFM".equals(keyinfo.getKey())))
        {
            return getDeviceDataCommunication().getValue(s);
        } else
        {
            return super.getValue(s);
        }
    }
}
