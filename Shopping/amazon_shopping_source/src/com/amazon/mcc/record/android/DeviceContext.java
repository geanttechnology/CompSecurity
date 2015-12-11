// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record.android;

import android.os.Build;
import com.amazon.mcc.record.BasicContext;
import java.util.HashMap;
import java.util.Map;

public class DeviceContext extends BasicContext
{

    public DeviceContext()
    {
        super(Build.DEVICE);
        initializeProperties();
    }

    protected DeviceContext(String s)
    {
        super((new StringBuilder()).append(Build.DEVICE).append(".").append(s).toString());
        initializeProperties();
    }

    private void initializeProperties()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("device.manufacturer", Build.MANUFACTURER);
        hashmap.put("device.model", Build.MODEL);
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            hashmap.put("device.hardware", Build.HARDWARE);
        }
        hashmap.put("device.brand", Build.BRAND);
        hashmap.put("device.sdkVersion", Integer.valueOf(android.os.Build.VERSION.SDK_INT));
        hashmap.put("device.androidRelease", android.os.Build.VERSION.RELEASE);
        addProperties(hashmap);
    }

    public Map getProperties()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("device.systemTime", Long.valueOf(System.currentTimeMillis()));
        addProperties(hashmap);
        return super.getProperties();
    }
}
