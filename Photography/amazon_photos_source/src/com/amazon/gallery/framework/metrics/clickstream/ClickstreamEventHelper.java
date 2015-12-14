// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.metrics.clickstream;

import com.amazon.gallery.thor.app.FeatureChecker;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.metrics.clickstream:
//            HitType, AppVariant

public class ClickstreamEventHelper
{

    public static Map createClickstreamExtra(String s, HitType hittype)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("clickstreamEvent", "");
        hashmap.put("componentName", s);
        hashmap.put("hitType", hittype.toString());
        return hashmap;
    }

    public static String getAppVariant(FeatureChecker featurechecker)
    {
        if (featurechecker.hasFreetimeActionBar())
        {
            if (featurechecker.alwaysTransparentHAB())
            {
                return AppVariant.FREETIME.toString();
            } else
            {
                return AppVariant.TEENTIME.toString();
            }
        } else
        {
            return AppVariant.STANDARD.toString();
        }
    }

    public static boolean isClickstreamEvent(Map map)
    {
        return map.containsKey("clickstreamEvent");
    }
}
