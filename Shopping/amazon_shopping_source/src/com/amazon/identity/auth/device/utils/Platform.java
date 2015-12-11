// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import com.amazon.identity.auth.device.attribute.DeviceAttribute;
import com.amazon.identity.auth.device.attribute.DeviceAttributeCache;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureCache;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class Platform
{

    private static final String TAG = com/amazon/identity/auth/device/utils/Platform.getName();

    private Platform()
    {
    }

    public static String getDeviceAttribute(Context context, DeviceAttribute deviceattribute)
    {
        context = ((Context) (DeviceAttributeCache.getInstance().get(context, deviceattribute)));
        if (context instanceof String)
        {
            return (String)context;
        } else
        {
            MAPLog.e(TAG, "Device Attribute %s is not of type String.", new Object[] {
                deviceattribute.toString()
            });
            throw new RuntimeException("Incorrectly called getDeviceAttribute in Platform.  Try calling hasDeviceAttribute.");
        }
    }

    public static boolean hasDeviceAttribute(Context context, DeviceAttribute deviceattribute)
    {
        context = ((Context) (DeviceAttributeCache.getInstance().get(context, deviceattribute)));
        if (context instanceof Boolean)
        {
            return ((Boolean)context).booleanValue();
        } else
        {
            MAPLog.e(TAG, "Device Attribute %s is not of type boolean.", new Object[] {
                deviceattribute.toString()
            });
            throw new RuntimeException("Incorrectly called hasDeviceAttribute in Platform.  Try calling getDeviceAttribute.");
        }
    }

    public static boolean hasFeature(Context context, Feature feature)
    {
        return FeatureCache.getInstance().get(context, feature);
    }

}
