// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.devicedata;

import com.amazon.identity.auth.device.api.DeviceDataStoreException;

// Referenced classes of package com.amazon.identity.auth.device.devicedata:
//            DeviceDataInfo

public interface DeviceDataStoreDefinition
{

    public abstract DeviceDataInfo getValue(String s)
        throws DeviceDataStoreException;
}
