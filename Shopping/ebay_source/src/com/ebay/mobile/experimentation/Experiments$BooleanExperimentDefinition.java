// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.experimentation;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.api.experimentation.ExperimentBase;
import com.ebay.nautilus.domain.net.api.experimentation.Factor;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;

// Referenced classes of package com.ebay.mobile.experimentation:
//            Experiments

public static class defaultTreatment extends ExperimentBase
{

    public static final String FACTOR_ENABLED = "enabled";

    public static boolean isEnabled(Treatment treatment, boolean flag)
    {
        Object obj;
        if (treatment == null)
        {
            obj = null;
        } else
        {
            obj = treatment.getCurrentFactor("enabled");
        }
        if (treatment == null || treatment.isDefault || TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return flag;
        } else
        {
            return Boolean.parseBoolean(((String) (obj)));
        }
    }

    public (String s, String s1, String s2)
    {
        this(s, s1, s2, false);
    }

    public <init>(String s, String s1, String s2, boolean flag)
    {
        super(s, s1, s2);
        defaultTreatment = new Treatment(Experiments.access$000(), new Factor[] {
            new Factor("enabled", Boolean.toString(flag))
        });
    }
}
