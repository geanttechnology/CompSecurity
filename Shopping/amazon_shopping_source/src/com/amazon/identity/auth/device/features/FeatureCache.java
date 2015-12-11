// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.features;

import android.content.Context;
import java.util.EnumMap;

// Referenced classes of package com.amazon.identity.auth.device.features:
//            Feature

public final class FeatureCache
{

    private static final FeatureCache INSTANCE = new FeatureCache();
    private static final String LOG_TAG = com/amazon/identity/auth/device/features/FeatureCache.getName();
    private final EnumMap mCache = new EnumMap(com/amazon/identity/auth/device/features/Feature);

    private FeatureCache()
    {
    }

    private boolean fetchAndSetFeature(Context context, Feature feature)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        context = Boolean.valueOf(feature.fetchValue(context));
        mCache.put(feature, context);
        String s = LOG_TAG;
        String.format("Setting feature %s to %s", new Object[] {
            feature.toString(), context
        });
        flag = context.booleanValue();
        this;
        JVM INSTR monitorexit ;
        return flag;
        context;
        throw context;
    }

    public static FeatureCache getInstance()
    {
        return INSTANCE;
    }

    public boolean get(Context context, Feature feature)
    {
        this;
        JVM INSTR monitorenter ;
        Boolean boolean1 = (Boolean)mCache.get(feature);
        if (boolean1 == null) goto _L2; else goto _L1
_L1:
        boolean flag = boolean1.booleanValue();
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = fetchAndSetFeature(context, feature);
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

}
