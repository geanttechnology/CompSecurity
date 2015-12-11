// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import com.amazon.identity.auth.device.api.DeviceDataStoreException;
import com.amazon.identity.auth.device.utils.KeyInfo;

// Referenced classes of package com.amazon.identity.auth.device:
//            DeviceDataLogic, DeviceDataInfo

private static interface 
{

    public abstract DeviceDataInfo makeDeviceDataInfo(KeyInfo keyinfo)
        throws DeviceDataStoreException;
}
