// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.content.ContentProviderClient;
import android.database.Cursor;
import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.framework.ContentProviderClientCallback;
import com.amazon.identity.auth.device.framework.SecureContentResolver;
import com.amazon.identity.auth.device.utils.DBUtils;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device:
//            DeviceDataCommunication, DeviceDataInfo

class val.key
    implements ContentProviderClientCallback
{

    final DeviceDataCommunication this$0;
    final String val$key;

    public DeviceDataInfo useContentProviderClient(ContentProviderClient contentproviderclient)
        throws Exception
    {
        contentproviderclient = DeviceDataCommunication.access$000(DeviceDataCommunication.this).query(DeviceDataCommunication.DEVICE_DATA_STORE_URI, DeviceDataCommunication.COLUMNS, val$key, null, null);
        if (contentproviderclient == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        if (contentproviderclient.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        String s = String.format("Key %s was not found in the device data store", new Object[] {
            val$key
        });
        MAPLog.w(DeviceDataCommunication.access$100(), s);
        throw new DeviceDataStoreException(s);
        Exception exception;
        exception;
        if (contentproviderclient != null)
        {
            contentproviderclient.close();
        }
        throw exception;
        Object obj;
        DeviceDataCommunication.access$200(DeviceDataCommunication.this, contentproviderclient);
        obj = DBUtils.getString(contentproviderclient, "value");
        String s1 = DBUtils.getString(contentproviderclient, "isPersistent");
        boolean flag = Boolean.parseBoolean(s1);
        DeviceDataCommunication.access$100();
        String.format("Recevied Key=%s, Value=%s, Persistent=%s", new Object[] {
            val$key, obj, s1
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

    on()
    {
        this$0 = final_devicedatacommunication;
        val$key = String.this;
        super();
    }
}
