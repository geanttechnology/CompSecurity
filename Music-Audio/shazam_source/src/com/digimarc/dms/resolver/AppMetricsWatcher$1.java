// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import com.digimarc.dms.imagereader.Payload;

// Referenced classes of package com.digimarc.dms.resolver:
//            AppMetricsWatcher, ResolveResult, AppMetricsReporter

class this._cls0
    implements solvedListener
{

    final AppMetricsWatcher this$0;

    public void onError(Payload payload)
    {
    }

    public void onResolvedUnknown(ResolveResult resolveresult)
    {
    }

    public void onResolvedWithPayoff(ResolveResult resolveresult)
    {
        if (AppMetricsWatcher.isFakePayload(resolveresult.getPayload()))
        {
            AppMetricsReporter.saveReportingCompletedCache();
        }
    }

    solvedListener()
    {
        this$0 = AppMetricsWatcher.this;
        super();
    }
}
