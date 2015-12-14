// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.features;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.EnumMap;

// Referenced classes of package com.amazon.identity.auth.device.features:
//            FeatureSet, FeatureCache, Feature

public final class FeatureSetCache extends FeatureSet
{

    private static final String LOG_TAG = com/amazon/identity/auth/device/features/FeatureCache.getName();
    private static FeatureSetCache sSingleFeatureSetCacheInstance;
    private final EnumMap mCache = new EnumMap(com/amazon/identity/auth/device/features/Feature);
    private final FeatureSet mDelegateFeatureSet;

    public FeatureSetCache(FeatureSet featureset)
    {
        if (featureset == null)
        {
            throw new IllegalArgumentException("delegateFeatureSet is null");
        } else
        {
            mDelegateFeatureSet = featureset;
            return;
        }
    }

    public static FeatureSetCache getInstance(FeatureSet featureset)
    {
        com/amazon/identity/auth/device/features/FeatureSetCache;
        JVM INSTR monitorenter ;
        if (sSingleFeatureSetCacheInstance == null)
        {
            sSingleFeatureSetCacheInstance = new FeatureSetCache(featureset);
        }
        featureset = sSingleFeatureSetCacheInstance;
        com/amazon/identity/auth/device/features/FeatureSetCache;
        JVM INSTR monitorexit ;
        return featureset;
        featureset;
        throw featureset;
    }

    public boolean hasFeature(Feature feature)
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
        flag = mDelegateFeatureSet.hasFeature(feature);
        mCache.put(feature, Boolean.valueOf(flag));
        MAPLog.i(LOG_TAG, String.format("Caching feature %s as %s", new Object[] {
            feature.toString(), Boolean.valueOf(flag)
        }));
        if (true) goto _L4; else goto _L3
_L3:
        feature;
        throw feature;
    }

}
