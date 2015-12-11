// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.service.core.AbTestService;
import com.groupon.util.DeviceInfoUtil;

public class BitmapAbTestHelper
{

    private AbTestService abTestService;
    private DeviceInfoUtil deviceInfoUtil;

    public BitmapAbTestHelper()
    {
    }

    public boolean isEnable565Bitmap1506()
    {
        return deviceInfoUtil.isDeviceAtOrBelow2012() && abTestService.getVariant("enable565Bitmap1506").equals("on");
    }
}
