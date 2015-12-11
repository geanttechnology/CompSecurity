// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.utils.KeyInfo;

// Referenced classes of package com.amazon.identity.auth.device:
//            DeviceDataLogic, DeviceDataInfo

class val.deviceKey
    implements viceDataCreator
{

    final DeviceDataLogic this$0;
    final String val$deviceKey;

    public DeviceDataInfo makeDeviceDataInfo(KeyInfo keyinfo)
        throws DeviceDataStoreException
    {
        keyinfo = DeviceDataLogic.access$400(DeviceDataLogic.this, val$deviceKey);
        if (keyinfo == null)
        {
            return null;
        } else
        {
            return new DeviceDataInfo(keyinfo, true);
        }
    }

    eException()
    {
        this$0 = final_devicedatalogic;
        val$deviceKey = String.this;
        super();
    }
}
