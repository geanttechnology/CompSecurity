// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AdvertisingIdHelper
{

    Object advertisingInfo;
    private final Context context;
    Method getIdMethod;
    Method isLimitAdTrackingEnabledMethod;

    public AdvertisingIdHelper(Context context1)
    {
        advertisingInfo = null;
        isLimitAdTrackingEnabledMethod = null;
        getIdMethod = null;
        context = context1;
    }

    public void cleanupClass()
    {
        advertisingInfo = null;
        isLimitAdTrackingEnabledMethod = null;
        getIdMethod = null;
    }

    public String getId()
        throws InvocationTargetException, IllegalAccessException
    {
        return (String)getIdMethod.invoke(advertisingInfo, new Object[0]);
    }

    public void initializeClass()
        throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        advertisingInfo = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] {
            android/content/Context
        }).invoke(null, new Object[] {
            context
        });
        isLimitAdTrackingEnabledMethod = advertisingInfo.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
        getIdMethod = advertisingInfo.getClass().getMethod("getId", new Class[0]);
    }

    public boolean isLimitAdTrackingEnabled()
        throws InvocationTargetException, IllegalAccessException
    {
        return ((Boolean)isLimitAdTrackingEnabledMethod.invoke(advertisingInfo, new Object[0])).booleanValue();
    }
}
