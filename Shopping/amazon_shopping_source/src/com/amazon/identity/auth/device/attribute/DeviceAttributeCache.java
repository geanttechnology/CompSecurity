// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.attribute;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.EnumMap;

// Referenced classes of package com.amazon.identity.auth.device.attribute:
//            DeviceAttribute

public final class DeviceAttributeCache
{

    private static final DeviceAttributeCache INSTANCE = new DeviceAttributeCache();
    private static final String LOG_TAG = com/amazon/identity/auth/device/attribute/DeviceAttributeCache.getName();
    private final EnumMap mCache = new EnumMap(com/amazon/identity/auth/device/attribute/DeviceAttribute);

    private DeviceAttributeCache()
    {
    }

    private Object fetchAndSetDeviceAttribute(Context context, DeviceAttribute deviceattribute)
    {
        this;
        JVM INSTR monitorenter ;
        context = ((Context) (deviceattribute.fetchValue(context)));
        if (!(context instanceof String)) goto _L2; else goto _L1
_L1:
        boolean flag = TextUtils.isEmpty((String)context);
        if (!flag) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return context;
_L2:
        MAPLog.i(LOG_TAG, String.format("Setting device attribute %s to %s", new Object[] {
            deviceattribute.toString(), context
        }));
        mCache.put(deviceattribute, context);
        if (true) goto _L3; else goto _L4
_L4:
        context;
        throw context;
    }

    public static DeviceAttributeCache getInstance()
    {
        return INSTANCE;
    }

    public Object get(Context context, DeviceAttribute deviceattribute)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = mCache.get(deviceattribute);
        if (obj == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L2:
        obj = fetchAndSetDeviceAttribute(context, deviceattribute);
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

}
