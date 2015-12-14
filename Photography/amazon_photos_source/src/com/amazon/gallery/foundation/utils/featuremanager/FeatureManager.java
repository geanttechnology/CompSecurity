// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.featuremanager;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.gallery.foundation.utils.DebugAssert;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.foundation.utils.featuremanager:
//            FeatureName

public class FeatureManager
{

    private static Map featureMap = new HashMap();

    public static boolean isFeatureEnabled(FeatureName featurename)
    {
        featurename = (Boolean)featureMap.get(featurename.getName());
        if (featurename != null)
        {
            return featurename.booleanValue();
        } else
        {
            return false;
        }
    }

    public static void loadSetting(Context context)
    {
        if (DebugAssert.isDebugBuild)
        {
            context = context.getSharedPreferences(".features", 0).getAll().entrySet().iterator();
            do
            {
                if (!context.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)context.next();
                if (entry.getValue() instanceof Boolean)
                {
                    featureMap.put(entry.getKey(), (Boolean)entry.getValue());
                }
            } while (true);
        }
    }

    public static void setFeatureEnabled(Context context, FeatureName featurename, boolean flag)
    {
        featureMap.put(featurename.getName(), Boolean.valueOf(flag));
        if (DebugAssert.isDebugBuild)
        {
            context.getSharedPreferences(".features", 0).edit().putBoolean(featurename.getName(), flag).apply();
        }
    }

}
