// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;

public final class StorageKeyUtils
{

    private StorageKeyUtils()
    {
    }

    public static String getKeyWithDeviceTypePrefix(Context context, String s, String s1)
    {
        if (DeviceTypeHelpers.areAppsWithDeviceTypeUsingDeviceCredentials(context, s))
        {
            return s1;
        } else
        {
            return (new StringBuilder()).append(s).append("/").append(s1).toString();
        }
    }

    public static String getKeyWithPackageNamespace(String s, String s1)
    {
        if (s == null)
        {
            return s1;
        } else
        {
            return String.format("%s/%s", new Object[] {
                s, s1
            });
        }
    }
}
