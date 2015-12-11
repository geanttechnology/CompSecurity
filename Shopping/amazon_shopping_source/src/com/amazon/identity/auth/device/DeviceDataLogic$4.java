// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import com.amazon.identity.auth.device.api.DeviceDataStoreException;
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
        return new DeviceDataInfo(DeviceDataLogic.access$100(DeviceDataLogic.this), true);
    }

    eException()
    {
        this$0 = DeviceDataLogic.this;
        super();
    }
}
