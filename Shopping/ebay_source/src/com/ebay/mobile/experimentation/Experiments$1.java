// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.experimentation;

import com.ebay.nautilus.domain.net.api.experimentation.ExperimentBase;
import com.ebay.nautilus.domain.net.api.experimentation.Factor;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;

// Referenced classes of package com.ebay.mobile.experimentation:
//            Experiments

static final class on.Factor extends ExperimentBase
{

    on.Factor(String s, String s1, String s2)
    {
        super(s, s1, s2);
        defaultTreatment = new Treatment("treatmentDisplayId", new Factor[] {
            new Factor("f1", "0"), new Factor("f2", "true"), new Factor("f3", "Default")
        });
    }
}
