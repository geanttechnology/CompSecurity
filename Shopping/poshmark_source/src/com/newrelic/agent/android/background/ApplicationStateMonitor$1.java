// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.background;

import com.newrelic.agent.android.logging.AgentLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.newrelic.agent.android.background:
//            ApplicationStateMonitor

class this._cls0
    implements Runnable
{

    final ApplicationStateMonitor this$0;

    public void run()
    {
        ApplicationStateMonitor.access$000(ApplicationStateMonitor.this).lock();
        if (foregrounded.get())
        {
            ApplicationStateMonitor.access$100().info("UI has become hidden (app backgrounded)");
            ApplicationStateMonitor.access$200(ApplicationStateMonitor.this);
            foregrounded.set(false);
        }
        ApplicationStateMonitor.access$000(ApplicationStateMonitor.this).unlock();
        return;
        Exception exception;
        exception;
        ApplicationStateMonitor.access$000(ApplicationStateMonitor.this).unlock();
        throw exception;
    }

    ()
    {
        this$0 = ApplicationStateMonitor.this;
        super();
    }
}
