// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.attributes.CorPfmInfo;
import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.attribute.DeviceAttribute;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.framework.RemoteMapInfo;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.utils.CentralApkUtils;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.Platform;
import com.amazon.identity.auth.device.utils.StringHelpers;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import com.amazon.identity.platform.util.PlatformUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device:
//            DeviceDataStoreDefinition, DeviceDataInfo

public final class DeviceDataLogic
    implements DeviceDataStoreDefinition
{
    private static interface DeviceDataCreator
    {

        public abstract DeviceDataInfo makeDeviceDataInfo(KeyInfo keyinfo)
            throws DeviceDataStoreException;
    }


    public static final String DEVICE_INFO_NAMESPACE = "device.metadata";
    private static final String TAG = com/amazon/identity/auth/device/DeviceDataLogic.getName();
    private static DeviceDataLogic sTheOneAndTheOnly;
    private final Context mContext;
    private final CorPfmInfo mCorPfmInfo;
    private final DataStorage mDataStorage;
    private final Map mDeviceDataLookup = new HashMap();
    private final SSODeviceInfo mDeviceInfo;

    private DeviceDataLogic(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mCorPfmInfo = new CorPfmInfo(mContext);
        mDeviceInfo = (SSODeviceInfo)mContext.getSystemService("dcp_device_info");
        mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
        mDeviceDataLookup.put("Default COR", new DeviceDataCreator() {

            final DeviceDataLogic this$0;

            public DeviceDataInfo makeDeviceDataInfo(KeyInfo keyinfo)
            {
                return new DeviceDataInfo(mCorPfmInfo.getDeviceDefaultCor(), false);
            }

            
            {
                this$0 = DeviceDataLogic.this;
                super();
            }
        });
        mDeviceDataLookup.put("Default PFM", new DeviceDataCreator() {

            final DeviceDataLogic this$0;

            public DeviceDataInfo makeDeviceDataInfo(KeyInfo keyinfo)
            {
                return new DeviceDataInfo(mCorPfmInfo.getDeviceDefaultPfm(), false);
            }

            
            {
                this$0 = DeviceDataLogic.this;
                super();
            }
        });
        mDeviceDataLookup.put("Client Id", new DeviceDataCreator() {

            final DeviceDataLogic this$0;

            public DeviceDataInfo makeDeviceDataInfo(KeyInfo keyinfo)
                throws DeviceDataStoreException
            {
                return new DeviceDataInfo(StringHelpers.convertToHex(String.format("%s#%s", new Object[] {
                    DeviceDataLogic.access$100(DeviceDataLogic.this), Platform.getDeviceAttribute(mContext, DeviceAttribute.CentralDeviceType)
                })), true);
            }

            
            {
                this$0 = DeviceDataLogic.this;
                super();
            }
        });
        mDeviceDataLookup.put("Device Serial Number", new DeviceDataCreator() {

            final DeviceDataLogic this$0;

            public DeviceDataInfo makeDeviceDataInfo(KeyInfo keyinfo)
                throws DeviceDataStoreException
            {
                return new DeviceDataInfo(DeviceDataLogic.access$100(DeviceDataLogic.this), true);
            }

            
            {
                this$0 = DeviceDataLogic.this;
                super();
            }
        });
        mDeviceDataLookup.put("DeviceType", new DeviceDataCreator() {

            final DeviceDataLogic this$0;

            public DeviceDataInfo makeDeviceDataInfo(KeyInfo keyinfo)
                throws DeviceDataStoreException
            {
                keyinfo = keyinfo.getPackageName();
                Object obj;
                try
                {
                    obj = new DeviceDataInfo(DeviceDataLogic.access$300(DeviceDataLogic.this, keyinfo), true);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new DeviceDataStoreException((new StringBuilder("Failed to query device type for ")).append(keyinfo).toString());
                }
                if (TextUtils.isEmpty(((DeviceDataInfo) (obj)).value))
                {
                    throw new DeviceDataStoreException("Value of device type is null.  This is expected on Grover V1 for the central device Type when the device is not registered.");
                } else
                {
                    return ((DeviceDataInfo) (obj));
                }
            }

            
            {
                this$0 = DeviceDataLogic.this;
                super();
            }
        });
    }

    public static DeviceDataLogic getInstance(Context context)
    {
        com/amazon/identity/auth/device/DeviceDataLogic;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null || UnitTestUtils.isRunningInUnitTest())
        {
            sTheOneAndTheOnly = new DeviceDataLogic(context.getApplicationContext());
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/DeviceDataLogic;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public DeviceDataInfo getValue(final String deviceKey)
        throws DeviceDataStoreException
    {
        KeyInfo keyinfo = KeyInfo.parseKey(deviceKey);
        DeviceDataCreator devicedatacreator1 = (DeviceDataCreator)mDeviceDataLookup.get(keyinfo.getKey());
        DeviceDataCreator devicedatacreator = devicedatacreator1;
        if (devicedatacreator1 == null)
        {
            devicedatacreator = new DeviceDataCreator() {

                final DeviceDataLogic this$0;
                final String val$deviceKey;

                public DeviceDataInfo makeDeviceDataInfo(KeyInfo keyinfo1)
                    throws DeviceDataStoreException
                {
                    keyinfo1 = DeviceDataLogic devicedatalogic1 = null;
                    if (keyinfo1 == null)
                    {
                        return null;
                    } else
                    {
                        return new DeviceDataInfo(keyinfo1, true);
                    }
                }

            
            {
                this$0 = DeviceDataLogic.this;
                deviceKey = s;
                super();
            }
            };
        }
        if (devicedatacreator == null)
        {
            return null;
        } else
        {
            return devicedatacreator.makeDeviceDataInfo(keyinfo);
        }
    }




/*
    static String access$100(DeviceDataLogic devicedatalogic)
        throws DeviceDataStoreException
    {
        boolean flag;
        if (!CentralApkUtils.isRunningInCentralAPK(devicedatalogic.mContext) && PlatformUtils.isNonAmazonDeviceWithCentralSSO(devicedatalogic.mContext))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            String s = (new MAPAccountManager(devicedatalogic.mContext)).getPrimaryAccount();
            if (s == null)
            {
                MAPLog.e(TAG, "Cannot return DSN on this platform (Grover or Canary V1). We can only return it while the device is registered");
                throw new DeviceDataStoreException("Cannot return DSN on this platform (Grover or Canary V1). We can only return it while the device is registered");
            } else
            {
                return (new BackwardsCompatiableDataStorage(devicedatalogic.mContext)).getUserData(s, "com.amazon.dcp.sso.token.device.deviceserialname");
            }
        } else
        {
            return devicedatalogic.mDeviceInfo.getDeviceSerialNumber();
        }
    }

*/



/*
    static String access$300(DeviceDataLogic devicedatalogic, String s)
        throws RemoteMAPException
    {
        if (s == null)
        {
            return Platform.getDeviceAttribute(devicedatalogic.mContext, DeviceAttribute.CentralDeviceType);
        }
        devicedatalogic = MAPApplicationInformationQueryer.getInstance(devicedatalogic.mContext).getAppInfo(s);
        if (devicedatalogic == null)
        {
            return null;
        } else
        {
            return devicedatalogic.getDeviceType();
        }
    }

*/


/*
    static String access$400(DeviceDataLogic devicedatalogic, String s)
    {
        DeviceDataLogic devicedatalogic1 = null;
        if (PlatformUtils.isPostMergeDevice(devicedatalogic.mContext))
        {
            devicedatalogic = devicedatalogic.mDataStorage.getDeviceData("device.metadata", s);
            devicedatalogic1 = devicedatalogic;
            if (devicedatalogic == null)
            {
                MAPLog.i(TAG, (new StringBuilder("device attribute ")).append(s).append(" not found in datastore").toString());
                devicedatalogic1 = devicedatalogic;
            }
        }
        return devicedatalogic1;
    }

*/
}
