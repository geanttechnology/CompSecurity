// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.background;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.newrelic.agent.android.background:
//            ApplicationStateMonitor

class this._cls0
    implements ThreadFactory
{

    final ApplicationStateMonitor this$0;

    public Thread newThread(Runnable runnable)
    {
        return new Thread(runnable, "[New Relic] App State Monitor");
    }

    ()
    {
        this$0 = ApplicationStateMonitor.this;
        super();
    }
}
