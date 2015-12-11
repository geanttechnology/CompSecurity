// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.content.Context;

// Referenced classes of package com.digimarc.dms.resolver:
//            AppMetricsReporter, DigimarcResolver, ResolverService

static final class val.resolver
    implements Runnable
{

    final Context val$context;
    final ResolverService val$resolver;

    public final void run()
    {
        Context _tmp = AppMetricsReporter.access$002(val$context);
        DigimarcResolver.getAppInfo(AppMetricsReporter.access$000());
        AppMetricsReporter appmetricsreporter = new AppMetricsReporter(AppMetricsReporter.access$000(), DigimarcResolver.getSdkVersion(), DigimarcResolver.getAppName(), DigimarcResolver.getAppVersion());
        int i = 0;
        do
        {
label0:
            {
                if (i < 3)
                {
                    if (!appmetricsreporter.needsReporting() || !val$resolver.isInitialized())
                    {
                        break label0;
                    }
                    val$resolver.resolve(AppMetricsReporter.getFakePayload());
                }
                return;
            }
            try
            {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedexception) { }
            i++;
        } while (true);
    }

    (Context context1, ResolverService resolverservice)
    {
        val$context = context1;
        val$resolver = resolverservice;
        super();
    }
}
