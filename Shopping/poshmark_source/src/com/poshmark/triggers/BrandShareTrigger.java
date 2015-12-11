// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.triggers;

import android.content.SharedPreferences;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.utils.FeatureManager;

// Referenced classes of package com.poshmark.triggers:
//            PMTrigger, TriggerThresholds

public class BrandShareTrigger extends PMTrigger
{

    public BrandShareTrigger()
    {
        fetchTriggerFromPrefs();
    }

    public void fetchTriggerFromPrefs()
    {
        if (PMApplicationSession.GetPMSession().getUserId() != null)
        {
            initPrefsObject();
            if (savedTriggers != null)
            {
                String s = getClass().toString();
                String s1 = savedTriggers.getString((new StringBuilder()).append(s).append("_state").toString(), null);
                if (s1 != null)
                {
                    currentState = PMTrigger.TriggerState.valueOf(s1);
                    currentCount = savedTriggers.getInt((new StringBuilder()).append(s).append("_count").toString(), 0);
                }
            }
        }
    }

    public int getThresholdForState(PMTrigger.TriggerState triggerstate)
    {
        TriggerThresholds triggerthresholds = FeatureManager.getGlobalFeatureManager().getBrandShareTriggerFeature();
        if (triggerthresholds == null) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState[];

            static 
            {
                $SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState = new int[PMTrigger.TriggerState.values().length];
                try
                {
                    $SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState[PMTrigger.TriggerState.INITIAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState[PMTrigger.TriggerState.IGNORED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState[PMTrigger.TriggerState.INTERACTED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState[PMTrigger.TriggerState.DISMISSED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.poshmark.triggers.PMTrigger.TriggerState[triggerstate.ordinal()];
        JVM INSTR tableswitch 1 4: default 48
    //                   1 51
    //                   2 56
    //                   3 61
    //                   4 66;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        return 0x7fffffff;
_L3:
        return triggerthresholds.initial_threshold;
_L4:
        return triggerthresholds.repeat_ignored_threshold;
_L5:
        return triggerthresholds.repeat_clicked_threshold;
_L6:
        return triggerthresholds.repeat_dismissed_threshold;
    }

    public boolean isValid()
    {
        return FeatureManager.getGlobalFeatureManager().getBrandShareTriggerFeature() != null;
    }

    public boolean shouldFireTrigger()
    {
        int i = getThresholdForState(currentState);
        return currentCount >= i;
    }
}
