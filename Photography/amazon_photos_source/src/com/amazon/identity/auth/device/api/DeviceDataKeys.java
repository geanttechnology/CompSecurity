// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.storage.StorageKeyUtils;

public final class DeviceDataKeys
{

    public static final String KEY_DEVICE_SERIAL_NUMBER = "Device Serial Number";
    public static final String KEY_DEVICE_TYPE = "DeviceType";
    public static final String KEY_KE_DEVICE = "ke_device";

    private DeviceDataKeys()
    {
    }

    public static String getDeviceTypeKeyForPackage(String s)
    {
        return StorageKeyUtils.getKeyWithPackageNamespace(s, "DeviceType");
    }
}
