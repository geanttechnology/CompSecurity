// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            ExperimentationDataManager, Experiment

public static interface 
{

    public abstract String getChannelId();

    public abstract String getDefaultOverride(Experiment experiment);

    public abstract List getEpExperimentBlacklist();

    public abstract List getEpTreatmentBlacklist();

    public abstract int getExperimentationQualificationPeriodSeconds();

    public abstract boolean isExperimentationDisabled();
}
