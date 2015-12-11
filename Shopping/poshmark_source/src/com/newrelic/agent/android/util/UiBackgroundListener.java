// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.newrelic.agent.android.util:
//            NamedThreadFactory

public class UiBackgroundListener
    implements ComponentCallbacks2
{

    protected final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("UiBackgroundListener"));

    public UiBackgroundListener()
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
    }

    public void onLowMemory()
    {
    }

    public void onTrimMemory(int i)
    {
        Runnable runnable;
        switch (i)
        {
        default:
            return;

        case 20: // '\024'
            runnable = new Runnable() {

                final UiBackgroundListener this$0;

                public void run()
                {
                    ApplicationStateMonitor.getInstance().uiHidden();
                }

            
            {
                this$0 = UiBackgroundListener.this;
                super();
            }
            };
            break;
        }
        executor.submit(runnable);
    }
}
