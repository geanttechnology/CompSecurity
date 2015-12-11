// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.devicedata;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.framework.ContentProviderClientCallback;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.framework.SecureContentResolver;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.DBUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ParcelUtils;

// Referenced classes of package com.amazon.identity.auth.device.devicedata:
//            DeviceDataStoreDefinition, DeviceDataInfo

public class DeviceDataCommunication
    implements DeviceDataStoreDefinition
{

    private static final String COLUMNS[] = {
        "value", "isPersistent"
    };
    public static final Uri DEVICE_DATA_STORE_URI = Uri.parse("content://com.amazon.sso.device.data");
    public static final String ERROR_COLUMNS[] = {
        "exception"
    };
    private static final String TAG = com/amazon/identity/auth/device/devicedata/DeviceDataCommunication.getName();
    private final SecureContentResolver mSecureContentResolver;

    public DeviceDataCommunication(SecureContentResolver securecontentresolver)
    {
        mSecureContentResolver = securecontentresolver;
    }

    public DeviceDataCommunication(ServiceWrappingContext servicewrappingcontext)
    {
        this(new SecureContentResolver(servicewrappingcontext));
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
                    contentproviderclient = contentproviderclient.query(DeviceDataCommunication.DEVICE_DATA_STORE_URI, DeviceDataCommunication.COLUMNS, key, null, null);
                    if (contentproviderclient == null)
                    {
                        break MISSING_BLOCK_LABEL_30;
                    }
                    if (contentproviderclient.moveToFirst())
                    {
                        break MISSING_BLOCK_LABEL_76;
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
                    this = DBUtils.getString(this, "exception");
                    obj = DBUtils.getString(contentproviderclient, "value");
                    String s1 = DBUtils.getString(contentproviderclient, "isPersistent");
                    boolean flag = Boolean.parseBoolean(s1);
                    DeviceDataCommunication.TAG;
                    String.format("Received Key=%s, Value=%s, Persistent=%s", new Object[] {
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
            MAPLog.e(TAG, "Got a RemoteMAPException", key);
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
        return retriveValueFromCentralStore(s);
    }





/*
    static void access$200$7e2d3e40(Cursor cursor)
        throws DeviceDataStoreException
    {
        cursor = DBUtils.getString(cursor, "exception");
        if (TextUtils.isEmpty(cursor)) goto _L2; else goto _L1
_L1:
        cursor = ParcelUtils.deserialize(cursor);
        if (cursor == null) goto _L4; else goto _L3
_L3:
        if (!(cursor instanceof DeviceDataStoreException)) goto _L4; else goto _L5
_L5:
        cursor = (DeviceDataStoreException)cursor;
_L6:
        Object obj = cursor;
        if (cursor == null)
        {
            obj = new DeviceDataStoreException("DeviceDataProvider threw an unrecognized exception");
        }
        throw obj;
        cursor;
        MAPLog.w(TAG, "Unable to deserialize exception from DeviceDataProvider", cursor);
_L4:
        cursor = null;
        if (true) goto _L6; else goto _L2
_L2:
        return;
    }

*/
}
