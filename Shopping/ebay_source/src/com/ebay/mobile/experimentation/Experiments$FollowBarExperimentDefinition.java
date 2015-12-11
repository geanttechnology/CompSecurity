// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.experimentation;

import com.ebay.nautilus.domain.net.api.experimentation.ExperimentBase;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;

// Referenced classes of package com.ebay.mobile.experimentation:
//            Experiments

public static class defaultTreatment extends ExperimentBase
{

    public static boolean isFollowBarVisible(Treatment treatment)
    {
        boolean flag;
        if (treatment != null && !treatment.isDefault && treatment.treatmentName.equals("mAPP_001_Follow_Refine_Bar"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return !flag;
    }

    public (String s, String s1, String s2)
    {
        super(s, s1, s2);
        defaultTreatment = new Treatment(Experiments.access$000(), null);
    }
}
