// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;

// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils, MobileAdsLoggerFactory, MobileAdsLogger, AndroidTargetUtils

public static class LOGTAG
{

    private static final String LOGTAG = com/amazon/device/ads/ThreadUtils$ThreadRunner.getSimpleName();
    private final HashMap executors;
    private final MobileAdsLogger logger;

    public void execute(Runnable runnable, e e, ad ad)
    {
        Object obj = (HashMap)executors.get(e);
        if (obj == null)
        {
            logger.e("No executor available for %s execution style.", new Object[] {
                e
            });
            return;
        }
        obj = (tor)((HashMap) (obj)).get(ad);
        if (obj == null)
        {
            logger.e("No executor available for %s execution style on % execution thread.", new Object[] {
                e, ad
            });
        }
        ((tor) (obj)).execute(runnable);
    }

    public transient void executeAsyncTask(e e, ad ad, final cTask task, final Object params[])
    {
        ThreadUtils.access$000().execute(new Runnable() {

            final ThreadUtils.ThreadRunner this$0;
            final Object val$params[];
            final ThreadUtils.MobileAdsAsyncTask val$task;

            public void run()
            {
                AndroidTargetUtils.executeAsyncTask(task, params);
            }

            
            {
                this$0 = ThreadUtils.ThreadRunner.this;
                task = mobileadsasynctask;
                params = aobj;
                super();
            }
        }, e, ad);
    }

    public transient void executeAsyncTask(cTask ctask, Object aobj[])
    {
        executeAsyncTask(e.RUN_ASAP, ad.MAIN_THREAD, ctask, aobj);
    }

    public tor withExecutor(tor tor)
    {
        HashMap hashmap1 = (HashMap)executors.get(tor.getExecutionStyle());
        HashMap hashmap = hashmap1;
        if (hashmap1 == null)
        {
            hashmap = new HashMap();
            executors.put(tor.getExecutionStyle(), hashmap);
        }
        hashmap.put(tor.getExecutionThread(), tor);
        return this;
    }


    tor()
    {
        this(new MobileAdsLoggerFactory());
        tor tor = new <init>();
        withExecutor(new eduler());
        withExecutor(new eadRunner(tor));
        withExecutor(new eduler());
        withExecutor(new ner(tor));
    }

    ner(MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        executors = new HashMap();
        logger = mobileadsloggerfactory.createMobileAdsLogger(LOGTAG);
    }
}
