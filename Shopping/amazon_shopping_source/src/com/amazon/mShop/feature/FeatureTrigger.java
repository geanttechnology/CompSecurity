// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;

import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.feature:
//            Features

public class FeatureTrigger
{

    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static final List REMOVE_SERVICE_CALL_AFTER_SENDING_TRIGGER;
    private static final Map SERVICECALL_TO_FEATURE = new HashMap();

    public FeatureTrigger()
    {
    }

    public static final String getHttpHeaderFeatureTriggers(String s)
    {
        com/amazon/mShop/feature/FeatureTrigger;
        JVM INSTR monitorenter ;
        String as[];
        boolean flag;
        as = (String[])SERVICECALL_TO_FEATURE.get(s);
        flag = Util.isEmpty(as);
        if (!flag) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        com/amazon/mShop/feature/FeatureTrigger;
        JVM INSTR monitorexit ;
        return s;
_L2:
        StringBuilder stringbuilder;
        int j;
        stringbuilder = new StringBuilder();
        j = as.length;
        String s1;
        String s2;
        for (int i = 0; i >= j; i++)
        {
            break MISSING_BLOCK_LABEL_127;
        }

        s1 = as[i];
        s2 = Features.getInstance().getFeatureState(s1);
        if (!Util.isEmpty(s2) && Features.getInstance().isAllowClientTrigger(s1))
        {
            stringbuilder.append((new StringBuilder()).append(s1).append("=").append(s2).toString());
            stringbuilder.append(";");
        }
        break MISSING_BLOCK_LABEL_200;
        if (DEBUG)
        {
            Log.d("Trigger", (new StringBuilder()).append("Method:").append(s).append(" Header:").append(stringbuilder.toString()).toString());
        }
        if (REMOVE_SERVICE_CALL_AFTER_SENDING_TRIGGER.contains(s))
        {
            removeServiceCallAndFeature(s);
        }
        s = stringbuilder.toString();
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public static void removeServiceCallAndFeature(String s)
    {
        SERVICECALL_TO_FEATURE.remove(s);
    }

    static 
    {
        REMOVE_SERVICE_CALL_AFTER_SENDING_TRIGGER = new ArrayList();
        REMOVE_SERVICE_CALL_AFTER_SENDING_TRIGGER.add("post_metrics_v36");
    }
}
