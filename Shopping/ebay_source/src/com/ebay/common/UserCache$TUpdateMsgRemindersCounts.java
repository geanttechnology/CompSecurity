// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.os.Handler;
import android.os.Process;
import com.ebay.common.net.api.aps.ApplicationProcessServiceApi;
import com.ebay.common.net.api.aps.UserActivitySummary;

// Referenced classes of package com.ebay.common:
//            UserCache

private static final class userId extends Thread
{

    private final ApplicationProcessServiceApi api;
    private final eApi i;
    private final String iafToken;
    private final String userId;

    public void run()
    {
        Runnable runnable;
        Object obj;
        com.ebay.common.net.ception ception;
        try
        {
            Process.setThreadPriority(10);
        }
        catch (Exception exception) { }
        runnable = new Runnable() {

            final UserCache.TUpdateMsgRemindersCounts this$0;
            final UserActivitySummary val$summary;

            public void run()
            {
                i.updateMsgRemindersCounts(summary);
            }

            
            {
                this$0 = UserCache.TUpdateMsgRemindersCounts.this;
                summary = useractivitysummary;
                super();
            }
        };
        if (!i.i.post(runnable))
        {
            throw new Exception();
        }
        break MISSING_BLOCK_LABEL_94;
        ception;
        synchronized (i(i))
        {
            i(i, 0);
        }
        i.i(ception.getErrors());
        orException.getErrors(i, null);
        return;
        i(i, null);
        return;
        exception1;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception1;
        obj;
        i(i, null);
        throw obj;
        obj;
        synchronized (i(i))
        {
            i(i, -3);
        }
        i.i();
        i(i, null);
        return;
        exception2;
        arraylist1;
        JVM INSTR monitorexit ;
        throw exception2;
    }


    public eApi(eApi eapi, ApplicationProcessServiceApi applicationprocessserviceapi, String s, String s1)
    {
        i = eapi;
        api = applicationprocessserviceapi;
        iafToken = s;
        userId = s1;
    }
}
