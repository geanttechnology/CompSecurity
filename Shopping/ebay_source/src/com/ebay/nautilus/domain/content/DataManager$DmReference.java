// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DataManager

private static class params extends WeakReference
{

    final eyParams params;

    public eyParams(eyParams eyparams, DataManager datamanager, ReferenceQueue referencequeue)
    {
        super(datamanager, referencequeue);
        params = eyparams;
    }
}
