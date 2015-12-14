// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.attribute;

import android.content.Context;
import com.amazon.identity.auth.device.utils.CentralApkUtils;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;

public abstract class DeviceAttribute extends Enum
{

    private static final DeviceAttribute $VALUES[];
    public static final DeviceAttribute CentralAPK;
    public static final DeviceAttribute CentralDeviceType;

    private DeviceAttribute(String s, int i)
    {
        super(s, i);
    }


    public static DeviceAttribute valueOf(String s)
    {
        return (DeviceAttribute)Enum.valueOf(com/amazon/identity/auth/device/attribute/DeviceAttribute, s);
    }

    public static DeviceAttribute[] values()
    {
        return (DeviceAttribute[])$VALUES.clone();
    }

    public abstract Object fetchValue(Context context);

    static 
    {
        CentralDeviceType = new DeviceAttribute("CentralDeviceType", 0) {

            public Object fetchValue(Context context)
            {
                return DeviceTypeHelpers.getCentralDeviceType(context);
            }

        };
        CentralAPK = new DeviceAttribute("CentralAPK", 1) {

            public Object fetchValue(Context context)
            {
                return Boolean.valueOf(CentralApkUtils.hasCentralAPK(context));
            }

        };
        $VALUES = (new DeviceAttribute[] {
            CentralDeviceType, CentralAPK
        });
    }
}
