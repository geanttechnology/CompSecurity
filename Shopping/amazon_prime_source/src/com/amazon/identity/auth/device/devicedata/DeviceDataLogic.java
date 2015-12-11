// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.devicedata;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.attributes.CorPfmInfo;
import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.attribute.DeviceAttribute;
import com.amazon.identity.auth.device.endpoint.OpenIdRequest;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.Platform;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import com.amazon.identity.platform.util.PlatformUtils;

// Referenced classes of package com.amazon.identity.auth.device.devicedata:
//            DeviceDataStoreDefinition, DeviceDataInfo, DeviceDataStoreImplementationFactory

public class DeviceDataLogic
    implements DeviceDataStoreDefinition
{

    private static final String TAG = com/amazon/identity/auth/device/devicedata/DeviceDataLogic.getName();
    private static DeviceDataLogic sTheOneAndTheOnly;
    private final Context mContext;
    private final CorPfmInfo mCorPfmInfo;
    private final DataStorage mDataStorage;

    DeviceDataLogic(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mCorPfmInfo = new CorPfmInfo(mContext);
        mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
    }

    public static DeviceDataLogic getInstance(Context context)
    {
        com/amazon/identity/auth/device/devicedata/DeviceDataLogic;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null || UnitTestUtils.isRunningInUnitTest())
        {
            sTheOneAndTheOnly = new DeviceDataLogic(context.getApplicationContext());
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/devicedata/DeviceDataLogic;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    protected DeviceDataInfo getClientID()
        throws DeviceDataStoreException
    {
        return new DeviceDataInfo(OpenIdRequest.constructClientIdWithDsnAndDeviceType(getDsn().value, Platform.getDeviceAttribute(mContext, DeviceAttribute.CentralDeviceType)), true);
    }

    protected DeviceDataInfo getDefaultCOR()
    {
        return new DeviceDataInfo(mCorPfmInfo.getDeviceDefaultCor(), false);
    }

    protected DeviceDataInfo getDefaultPFM()
    {
        return new DeviceDataInfo(mCorPfmInfo.getDeviceDefaultPfm(), false);
    }

    protected DeviceDataInfo getDeviceType(KeyInfo keyinfo)
        throws DeviceDataStoreException
    {
        keyinfo = keyinfo.getPackageName();
        keyinfo = DeviceTypeHelpers.getDeviceTypeOfPackage(mContext, keyinfo);
        if (TextUtils.isEmpty(keyinfo))
        {
            throw new DeviceDataStoreException("Value of device type is null.  This is expected on Grover V1 for the central device Type when the device is not registered.");
        } else
        {
            return new DeviceDataInfo(keyinfo, true);
        }
    }

    protected DeviceDataInfo getDsn()
        throws DeviceDataStoreException
    {
        Object obj = DeviceDataStoreImplementationFactory.getSSODeviceInfoImpl(mContext);
        try
        {
            obj = new DeviceDataInfo(((SSODeviceInfo) (obj)).getDeviceSerialNumber(), true);
        }
        catch (UnsupportedOperationException unsupportedoperationexception)
        {
            throw new DeviceDataStoreException("Fetching DSN on this device is not supported while unregistered.");
        }
        return ((DeviceDataInfo) (obj));
    }

    public DeviceDataInfo getValue(String s)
        throws DeviceDataStoreException
    {
        KeyInfo keyinfo = KeyInfo.parseKey(s);
        if (keyinfo.getKey().equals("Device Serial Number"))
        {
            return getDsn();
        }
        if (keyinfo.getKey().equals("DeviceType"))
        {
            return getDeviceType(keyinfo);
        }
        if (keyinfo.getKey().equals("Default COR"))
        {
            return getDefaultCOR();
        }
        if (keyinfo.getKey().equals("Default PFM"))
        {
            return getDefaultPFM();
        }
        if (keyinfo.getKey().equals("Client Id"))
        {
            return getClientID();
        }
        if (PlatformUtils.isPostMergeDevice(mContext))
        {
            String s1 = mDataStorage.getDeviceData("device.metadata", s);
            if (s1 == null)
            {
                MAPLog.i(TAG, (new StringBuilder("device attribute ")).append(s).append(" not found in datastore").toString());
                return null;
            } else
            {
                return new DeviceDataInfo(s1, true);
            }
        } else
        {
            (new StringBuilder("Key : ")).append(s).append(" not found. Generic keys are not supported on this platform.");
            return null;
        }
    }

}
