// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import com.ebay.nautilus.domain.dcs.DcsPropString;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            ExperimentationContext, Treatment

public interface Experiment
    extends DcsPropString, ExperimentationContext
{

    public abstract Treatment getCurrentTreatment(EbayContext ebaycontext);

    public abstract Treatment getDefaultTreatment();

    public abstract String getDisplayId();

    public abstract String getId();

    public abstract String getName();
}
