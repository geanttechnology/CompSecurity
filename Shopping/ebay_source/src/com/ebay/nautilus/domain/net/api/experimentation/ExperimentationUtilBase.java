// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            Treatment, Factor, ExperimentationDataManager, Experiment

public abstract class ExperimentationUtilBase
{

    public ExperimentationUtilBase()
    {
    }

    public static String getCurrentFactor(Experiment experiment, ExperimentationDataManager experimentationdatamanager, String s)
    {
        experiment = getCurrentFactors(experiment, experimentationdatamanager);
        if (experiment == null)
        {
            return null;
        } else
        {
            return (String)experiment.get(s);
        }
    }

    public static Map getCurrentFactors(Experiment experiment, ExperimentationDataManager experimentationdatamanager)
    {
        Object obj = getCurrentTreatment(experiment, experimentationdatamanager);
        if (obj == null)
        {
            return null;
        }
        HashMap hashmap = new HashMap();
        Factor factor;
        for (obj = ((Treatment) (obj)).factors.iterator(); ((Iterator) (obj)).hasNext(); hashmap.put(factor.key, factor.value))
        {
            factor = (Factor)((Iterator) (obj)).next();
        }

        experimentationdatamanager.getExperimentState(experiment);
        return hashmap;
    }

    public static Treatment getCurrentTreatment(Experiment experiment, ExperimentationDataManager experimentationdatamanager)
    {
        return experimentationdatamanager.getExperimentState(experiment);
    }
}
