// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            Experiment

public class FrameworkExperiments
{

    private static final List experiments = Arrays.asList(new Experiment[0]);

    public FrameworkExperiments()
    {
    }

    public static List getExperiments()
    {
        return experiments;
    }

}
