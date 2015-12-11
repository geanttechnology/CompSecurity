// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.events.activity.OnDestroyEvent;
import com.squareup.otto.Bus;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.util:
//            HttpThreadFactory

public class HttpExecutor extends ScheduledThreadPoolExecutor
{

    public static final int HTTP_EXECUTOR_POOL_SIZE = 5;
    private String contextName;

    public HttpExecutor(final Context context)
    {
        super(5, new HttpThreadFactory());
        contextName = context.toString();
        ((Bus)RoboGuice.getInjector(context).getInstance(com/squareup/otto/Bus)).register(new Object() {

            final HttpExecutor this$0;
            final Context val$context;

            public void onEvent(OnDestroyEvent ondestroyevent)
            {
                Ln.d("Clearing tasks and shutting down executor for destroyed context %s", new Object[] {
                    context
                });
                getQueue().clear();
                shutdown();
            }

            
            {
                this$0 = HttpExecutor.this;
                context = context1;
                super();
            }
        });
    }

    protected void afterExecute(Runnable runnable, Throwable throwable)
    {
        Ln.d("%s queue size: %s", new Object[] {
            this, Integer.valueOf(getQueue().size())
        });
    }

    public void execute(Runnable runnable)
    {
        if (isShutdown())
        {
            try
            {
                throw new IllegalStateException(String.format("Refusing to execute new command for context %s that has been destroyed", new Object[] {
                    contextName
                }));
            }
            // Misplaced declaration of an exception variable
            catch (Runnable runnable)
            {
                Ln.w(runnable);
            }
            return;
        } else
        {
            super.execute(runnable);
            return;
        }
    }
}
