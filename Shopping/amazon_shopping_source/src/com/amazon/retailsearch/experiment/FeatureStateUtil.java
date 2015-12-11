// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.experiment;

import android.text.TextUtils;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;

public class FeatureStateUtil
{

    private FeatureStateUtil()
    {
    }

    public static String getAssetsWeblab(FeatureConfiguration featureconfiguration)
    {
        if (featureconfiguration == null) goto _L2; else goto _L1
_L1:
        featureconfiguration = featureconfiguration.getFeatureState("SX_mShop_Android_Assets_Loading_Scheme");
_L4:
        Object obj = featureconfiguration;
        if (TextUtils.isEmpty(featureconfiguration))
        {
            return "C";
        }
        break; /* Loop/switch isn't completed */
_L2:
        featureconfiguration = "C";
        if (true) goto _L4; else goto _L3
        featureconfiguration;
        obj = "C";
_L3:
        return ((String) (obj));
    }
}
