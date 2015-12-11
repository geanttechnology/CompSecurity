// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.framework.ContentProviderClientCallback;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.SecureContentResolver;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.DBUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ParcelUtils;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.identity.auth.device:
//            DeviceDataStoreDefinition, DeviceDataLogic, DeviceDataInfo

public class DeviceDataCommunication
    implements DeviceDataStoreDefinition
{

    public static final String COLUMNS[] = {
        "value", "isPersistent"
    };
    public static final String COLUMN_EXCEPTION = "exception";
    public static final String COLUMN_IS_PERSISTENT = "isPersistent";
    public static final String COLUMN_VALUE = "value";
    public static final Uri DEVICE_DATA_STORE_URI = Uri.parse("content://com.amazon.sso.device.data");
    public static final String ERROR_COLUMNS[] = {
        "exception"
    };
    private static final String TAG = com/amazon/identity/auth/device/DeviceDataCommunication.getName();
    private final DeviceDataLogic mDeviceDataLogic;
    private final PlatformWrapper mPlatform;
    private final SecureContentResolver mSecureContentResolver;

    public DeviceDataCommunication(PlatformWrapper platformwrapper, SecureContentResolver securecontentresolver, DeviceDataLogic devicedatalogic)
    {
        mSecureContentResolver = securecontentresolver;
        mPlatform = platformwrapper;
        mDeviceDataLogic = devicedatalogic;
    }

    public DeviceDataCommunication(ServiceWrappingContext servicewrappingcontext)
    {
        this((PlatformWrapper)servicewrappingcontext.getSystemService("sso_platform"), new SecureContentResolver(servicewrappingcontext), DeviceDataLogic.getInstance(servicewrappingcontext));
    }

    private DeviceDataInfo retriveValueFromCentralStore(final String key)
        throws DeviceDataStoreException
    {
        try
        {
            key = (DeviceDataInfo)mSecureContentResolver.acquireContentProviderClient(DEVICE_DATA_STORE_URI, new ContentProviderClientCallback() {

                final DeviceDataCommunication this$0;
                final String val$key;

                public DeviceDataInfo useContentProviderClient(ContentProviderClient contentproviderclient)
                    throws Exception
                {
                    contentproviderclient = mSecureContentResolver.query(DeviceDataCommunication.DEVICE_DATA_STORE_URI, DeviceDataCommunication.COLUMNS, key, null, null);
                    if (contentproviderclient == null)
                    {
                        break MISSING_BLOCK_LABEL_36;
                    }
                    if (contentproviderclient.moveToFirst())
                    {
                        break MISSING_BLOCK_LABEL_82;
                    }
                    String s = String.format("Key %s was not found in the device data store", new Object[] {
                        key
                    });
                    MAPLog.w(DeviceDataCommunication.TAG, s);
                    throw new DeviceDataStoreException(s);
                    Exception exception;
                    exception;
                    if (contentproviderclient != null)
                    {
                        contentproviderclient.close();
                    }
                    throw exception;
                    Object obj;
                    this = ParcelUtils.deserialize(DBUtils.getString(contentproviderclient, "exception"));
                    obj = DBUtils.getString(contentproviderclient, "value");
                    String s1 = DBUtils.getString(contentproviderclient, "isPersistent");
                    boolean flag = Boolean.parseBoolean(s1);
                    DeviceDataCommunication.TAG;
                    String.format("Recevied Key=%s, Value=%s, Persistent=%s", new Object[] {
                        key, obj, s1
                    });
                    obj = new DeviceDataInfo(((String) (obj)), flag);
                    if (contentproviderclient != null)
                    {
                        contentproviderclient.close();
                    }
                    return ((DeviceDataInfo) (obj));
                }

                public volatile Object useContentProviderClient(ContentProviderClient contentproviderclient)
                    throws Exception
                {
                    return useContentProviderClient(contentproviderclient);
                }

            
            {
                this$0 = DeviceDataCommunication.this;
                key = s;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (final String key)
        {
            if (key.getCause() instanceof DeviceDataStoreException)
            {
                throw (DeviceDataStoreException)key.getCause();
            } else
            {
                throw new DeviceDataStoreException((new StringBuilder("Failed to query device data store: ")).append(key.getMessage()).toString());
            }
        }
        return key;
    }

    public DeviceDataInfo getValue(String s)
        throws DeviceDataStoreException
    {
        boolean flag1 = true;
        if (!mPlatform.unSecureCheckHasContentProviderWithAuthority(DEVICE_DATA_STORE_URI)) goto _L2; else goto _L1
_L1:
        if (!mPlatform.isNewIdentiyMobilePlatformSSO()) goto _L4; else goto _L3
_L3:
        boolean flag = flag1;
_L6:
        if (flag)
        {
            return retriveValueFromCentralStore(s);
        } else
        {
            return mDeviceDataLogic.getValue(s);
        }
_L4:
        flag = flag1;
        if ("Default COR".equals(s)) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if ("Default PFM".equals(s)) goto _L6; else goto _L2
_L2:
        flag = false;
          goto _L6
    }





/*
    static void access$200(DeviceDataCommunication devicedatacommunication, Cursor cursor)
        throws DeviceDataStoreException
    {
        devicedatacommunication = ParcelUtils.deserialize(DBUtils.getString(cursor, "exception"));
        if (devicedatacommunication != null && (devicedatacommunication instanceof DeviceDataStoreException))
        {
            throw (DeviceDataStoreException)devicedatacommunication;
        } else
        {
            return;
        }
    }

*/
}
