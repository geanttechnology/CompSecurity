// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import com.amazon.identity.auth.attributes.CorPfmInfo;
import com.amazon.identity.auth.device.utils.KeyInfo;

// Referenced classes of package com.amazon.identity.auth.device:
//            DeviceDataLogic, DeviceDataInfo

class this._cls0
    implements viceDataCreator
{

    final DeviceDataLogic this$0;

    public DeviceDataInfo makeDeviceDataInfo(KeyInfo keyinfo)
    {
        return new DeviceDataInfo(DeviceDataLogic.access$000(DeviceDataLogic.this).getDeviceDefaultPfm(), false);
    }

    viceDataCreator()
    {
        this$0 = DeviceDataLogic.this;
        super();
    }
}
