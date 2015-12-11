// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            ExperimentationDataManager

public static class throttleExpiration
{

    public final List optIn = new ArrayList();
    public final List optOut = new ArrayList();
    public long throttleExpiration;

    public ()
    {
        throttleExpiration = 0L;
    }
}
