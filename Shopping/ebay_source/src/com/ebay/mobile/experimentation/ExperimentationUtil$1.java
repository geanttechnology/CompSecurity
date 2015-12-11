// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.experimentation;

import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.domain.net.api.experimentation.Experiment;
import java.util.List;

// Referenced classes of package com.ebay.mobile.experimentation:
//            ExperimentationUtil

static final class val.config
    implements com.ebay.nautilus.domain.net.api.experimentation.ager.ClientConfiguration
{

    final DcsHelper val$config;

    public String getChannelId()
    {
        return val$config.getEpChannelId();
    }

    public String getDefaultOverride(Experiment experiment)
    {
        return val$config.getEpDefaultOverride(experiment);
    }

    public List getEpExperimentBlacklist()
    {
        return val$config.getEpExperimentBlacklist();
    }

    public List getEpTreatmentBlacklist()
    {
        return val$config.getEpTreatmentBlacklist();
    }

    public int getExperimentationQualificationPeriodSeconds()
    {
        return val$config.getExperimentationQualificationPeriodSeconds();
    }

    public boolean isExperimentationDisabled()
    {
        return val$config.isExperimentationDisabled();
    }

    iment(DcsHelper dcshelper)
    {
        val$config = dcshelper;
        super();
    }
}
