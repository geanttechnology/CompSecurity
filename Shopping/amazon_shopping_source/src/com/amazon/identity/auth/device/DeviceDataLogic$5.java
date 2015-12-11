// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.text.TextUtils;
import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.utils.KeyInfo;

// Referenced classes of package com.amazon.identity.auth.device:
//            DeviceDataLogic, DeviceDataInfo

class this._cls0
    implements viceDataCreator
{

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

    PException()
    {
        this$0 = DeviceDataLogic.this;
        super();
    }
}
