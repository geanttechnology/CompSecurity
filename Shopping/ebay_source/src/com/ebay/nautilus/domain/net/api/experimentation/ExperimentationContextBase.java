// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import android.content.Context;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            ExperimentationContext

abstract class ExperimentationContextBase
    implements ExperimentationContext
{

    protected static final List EMPTY_CONTEXT = Collections.emptyList();
    protected List capturedState;

    public ExperimentationContextBase()
    {
        capturedState = null;
    }

    public abstract List getContextDictionary(Context context);

}
